package com.introtoandroid.minuteminutiae;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;

public class game_ready_activity extends AppCompatActivity{

    ImageButton player1;
    ImageButton player2;
    int ready = 0;
    Boolean readyP1 = false;
    Boolean readyP2 = false;
    public void onCreate (Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_ready_activity);

        player1 = (ImageButton) findViewById(R.id.imageButton);
        player2 = (ImageButton) findViewById(R.id.imageButton2);

       /* player1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readyP1 = !readyP1;
            }
        });
        player2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readyP2 = !readyP2;
            }
        });*/

        player1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readyP1 = !readyP1;
                if(readyP1&&readyP2) {
                    game_ready_activity.this.startActivity(new Intent(game_ready_activity.this, button_buzzer.class));
                }
            }
        });

        player2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readyP2 = !readyP2;
                if(readyP1&&readyP2) {
                    game_ready_activity.this.startActivity(new Intent(game_ready_activity.this, button_buzzer.class));
                }
            }
        });
        /*if(readyP1 && readyP2)
        {
            startActivity(new Intent(game_ready_activity.this, button_buzzer.class));
        }*/

    }
}
