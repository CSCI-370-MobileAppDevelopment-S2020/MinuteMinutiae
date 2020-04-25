package com.introtoandroid.minuteminutiae;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Quiz> quizList;

    Button singleQuizButton;
    ArrayList<String> geoQuestions;
    ArrayList<String> geoAnswers;

    Button startQuiz;

    //Boolean roundTimerValue,
  
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startQuiz = findViewById(R.id.singleQuizButton);

        geoQuestions = new ArrayList<String>() {{
            add("How many territories does the U.S. have?");
            add("What is the youngest country on Earth?");
            add("What is the most populated country in Europe?");
            add("What is the largest lake in North America?");
            add("What is the longest mountain range in the World?");
        }};
        geoAnswers = new ArrayList<String>() {{
            add("5");
            add("South Sudan");
            add("Russia");
            add("Lake Superior");
            add("The Andes");
        }};

        Quiz geoQuiz = new Quiz(geoQuestions, geoAnswers);

        startQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent i = new Intent(MainActivity.this, game_ready_activity.class);
                //MainActivity.this.startActivity(i);
                MainActivity.this.startActivity(new Intent(MainActivity.this, game_ready_activity.class));
            }
        });
    }
        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
            super.onActivityResult(requestCode, resultCode, data);

        }

}
