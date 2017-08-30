package com.example.aanammalik.a121;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** Defining a click  listener */
        android.view.View.OnClickListener settingsClickListener = new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SettingsActivity.class);
                startActivity(intent);


            }
        };

        /** Defining a click  listener */
        android.view.View.OnClickListener showClickListener = new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ShowActivity.class);
                startActivity(intent);
            }
        };

        /** Getting a reference to button object of the main layout */
        Button btnSettings = (Button) findViewById(R.id.btn_settings);
        btnSettings.setOnClickListener(settingsClickListener);

        /** Getting a reference to button object of the main layout */
        Button btnShow = (Button) findViewById(R.id.btn_show);
        btnShow.setOnClickListener(showClickListener);

    }
}
