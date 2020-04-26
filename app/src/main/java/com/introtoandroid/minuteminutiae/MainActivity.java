package com.introtoandroid.minuteminutiae;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Quiz> quizList;

    Button singleQuizButton;
    ArrayList<String> geoQuestions;
    ArrayList<String> geoAnswers;

    Button startQuiz;
    ImageButton settingsButton;

    Boolean roundTimerValue = false;
    Boolean penaltyValue = false;
    Integer numOfQuestions;

    final int REQUEST_CODE = 413;
  
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startQuiz = findViewById(R.id.singleQuizButton);
        settingsButton = findViewById(R.id.settingsButton);

        startQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, game_ready_activity.class);
                i.putExtra("numOfQuestions", numOfQuestions);
                i.putExtra("penaltyValue", penaltyValue);
                MainActivity.this.startActivity(i);
                //MainActivity.this.startActivity(new Intent(MainActivity.this, game_ready_activity.class));
            }
        });

        settingsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                MainActivity.this.startActivityForResult(new Intent(MainActivity.this, settings_activity.class), REQUEST_CODE);
            }
        });
    }
        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
            super.onActivityResult(requestCode, resultCode, data);
            roundTimerValue = data.getBooleanExtra("roundTimerValue", false);
            penaltyValue = data.getBooleanExtra("penaltyValue", false);
            numOfQuestions = data.getIntExtra("numOfQuestionsValue", 5);
            System.out.println("Number of questions: " + numOfQuestions);
            System.out.println("Wrong answer penalty: " + penaltyValue);
        }

}
