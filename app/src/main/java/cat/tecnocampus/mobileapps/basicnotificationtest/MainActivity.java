package cat.tecnocampus.mobileapps.basicnotificationtest;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button sendButton;

    private static final String CHANNEL_ID = "123456789";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendButton = findViewById(R.id.button_send);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) { //API >= 26 (Android O)
            String tag = "TEST NOTIS";

            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    tag,
                    NotificationManager.IMPORTANCE_DEFAULT
            );

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
    }

    private void sendNotification(String content) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        //Configurem pendingIntent a partir de intent ja creat
        PendingIntent pendingIntent = PendingIntent.getActivity(
                this,
                0,
                intent,
                PendingIntent.FLAG_ONE_SHOT
        );

        //Agafem el so per defecte de les notificacions al nostre sistema operatiu
        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        /*Notification builder, compte! Hi ha el NotificationBuilder (api >= 26)
        /i el NotificationCompat (compatible amb api antiga)*/
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(
                this,
                CHANNEL_ID
        );

        notificationBuilder
                //Paràmetres obligatoris
                .setSmallIcon(android.R.drawable.stat_notify_chat)
                .setContentTitle("Notifications Test Project")
                .setContentText(content)
                //Paràmetres opcionals
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent)
        ;
    }
}
