package cat.tecnocampus.mobileapps.basicnotificationtest;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    private void createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){ //API >= 26 (Android O)
            String tag = "TEST NOTIS";

            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    tag,
                    NotificationManager.IMPORTANCE_DEFAULT
            );
        }
    }
}
