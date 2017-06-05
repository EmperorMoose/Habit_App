package com.example.emperormoose.habitapp;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.widget.EditText;
import android.widget.TextView;
import com.example.emperormoose.habitapp.R.drawable;

public class habitActivity extends AppCompatActivity {

    private TextView mTextView;
    private EditText mDetailView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habit);

        Bundle extras = getIntent().getExtras();
        String test = extras.getString("test");
        mTextView = (TextView) findViewById(R.id.textView);
        mTextView.setText(test);
        mDetailView = (EditText) findViewById(R.id.editDetails);

    }

    //This method creates and displays a notification. It is called currently from a button in the layout
    //TODO there is an issue with setting the icon that needs resolving
    private void notificationMethod()
    {
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                .setSmallIcon(drawable.ic_icon)
                .setContentTitle("TestNotificationTitle")
                .setContentText("This is notification test");

        //This creates the landing page for the notification(?)
        Intent resultIntent = new Intent(this, habitActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(habitActivity.class);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        int mId = 001;
        mNotificationManager.notify(mId, mBuilder.build());
    }
}
