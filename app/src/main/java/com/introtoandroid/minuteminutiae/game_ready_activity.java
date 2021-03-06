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

    Integer numOfQuestions;
    Boolean penaltyValue;

    public void onCreate (Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_ready_activity);

        Intent intent = getIntent();
        numOfQuestions = intent.getIntExtra("numOfQuestions", 5);
        penaltyValue = intent.getBooleanExtra("penaltyValue", false);

        player1 = findViewById(R.id.imageButton);
        player2 = findViewById(R.id.imageButton2);

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
                if(readyP1) {
                    player1.setImageResource(R.drawable.checkicon);
                }
                else{
                    player1.setImageResource(R.drawable.questionmark);
                }
                if(readyP1&&readyP2) {
                    Intent buzzerIntent = new Intent(game_ready_activity.this, button_buzzer.class);
                    buzzerIntent.putExtra("numOfQuestions", numOfQuestions);
                    buzzerIntent.putExtra("penaltyValue", penaltyValue);
                    startActivity(buzzerIntent);
                    //game_ready_activity.this.startActivity(new Intent(game_ready_activity.this, button_buzzer.class));
                }
            }
        });

        player2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readyP2 = !readyP2;
                if(readyP2) {
                    player2.setImageResource(R.drawable.checkicon);
                }
                else{
                    player2.setImageResource(R.drawable.questionmark);
                }
                if(readyP1&&readyP2) {
                    Intent buzzerIntent = new Intent(game_ready_activity.this, button_buzzer.class);
                    buzzerIntent.putExtra("numOfQuestions", numOfQuestions);
                    buzzerIntent.putExtra("penaltyValue", penaltyValue);
                    startActivity(buzzerIntent);
                    //game_ready_activity.this.startActivity(new Intent(game_ready_activity.this, button_buzzer.class));
                }
            }
        });
        /*if(readyP1 && readyP2)
        {
            startActivity(new Intent(game_ready_activity.this, button_buzzer.class));
        }*/

    }
}
