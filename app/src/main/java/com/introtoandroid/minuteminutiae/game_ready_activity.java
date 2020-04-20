package com.introtoandroid.minuteminutiae;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;

public class game_ready_activity extends AppCompatActivity{

    ImageButton player1 = (ImageButton) findViewById(R.id.imageButton);
    ImageButton player2 = (ImageButton) findViewById(R.id.imageButton2);
    int ready = 0;
    public void onCreate (Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_ready_activity);

        player1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ready++;
            }
        });
        player2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ready++;
            }
        });

        if(ready > 2)
        {
            startActivity(new Intent(game_ready_activity.this, button_buzzer.class));
        }

    }
}
