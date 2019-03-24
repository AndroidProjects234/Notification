package com.example.notification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    NotificationCompat.Builder notification;
    private static final int uniqueID = 45612;      //Assign unique ID to every notification
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notification = new NotificationCompat.Builder(this);    //Reference to builder class
        notification.setAutoCancel(true);   //When activity launch notification leading to activity is cancel
    }

    public void buckysButtonClicked(View view){
        //Build the notification
        notification.setSmallIcon(R.drawable.ic_launcher);
        notification.setTicker("This is the ticker");
        notification.setWhen(System.currentTimeMillis());   //Gives time to upper right corner
        notification.setContentTitle("Here is the title");
        notification.setContentText("I am the body text of your notification");
        //All this put in your activity home screen
        Intent intent = new Intent(this, MainActivity.class);
        //PendingIntent gives your phone excess to intents in your app
       PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        //Builds notification and issues it
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(uniqueID, notification.build());

    }
}
