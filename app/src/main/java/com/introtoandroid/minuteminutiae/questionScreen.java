package com.introtoandroid.minuteminutiae;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;

import java.util.Random;

public class questionScreen extends Activity {

    public void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_screen);

        Intent i = getIntent();
        String p = i.getStringExtra("PLAYER");

        final int questionNum = i.getIntExtra("QUESTION_NUMBER", 0);
        final int questionSize = i.getIntExtra("QUESTION_SIZE", 0);
        Log.i("questionScreen", "" + questionSize);
        final TextView questionText = findViewById(R.id.questionText);
        final Button promptA = findViewById(R.id.promptA);
        final Button promptB = findViewById(R.id.promptB);
        final Button promptC = findViewById(R.id.promptC);
        final Button promptD = findViewById(R.id.promptD);

        String [] questions = getResources().getStringArray(R.array.questions);
        String [] promptsA = getResources().getStringArray(R.array.answersA);
        String [] promptsB = getResources().getStringArray(R.array.answersB);
        String [] promptsC = getResources().getStringArray(R.array.answersC);
        String [] promptsD = getResources().getStringArray(R.array.answersD);
        String [] answers = getResources().getStringArray(R.array.answers);

        /*Random rand = new Random();
        int q = questions.length;
        int n = rand.nextInt(questions.length);*/
        Log.i("QuestionScreen", "Question Number: " + questionNum);
        questionText.setText(questions[questionNum]);
        promptA.setText(promptsA[questionNum]);
        promptB.setText(promptsB[questionNum]);
        promptC.setText(promptsC[questionNum]);
        promptD.setText(promptsD[questionNum]);

        promptA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(questionSize==5){
                    //create intent to go to end screen
                   Intent endScreen = new Intent(questionScreen.this, end_quiz.class);
                   startActivity(endScreen);

                }
                else {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("Answer", "promtA");

                    setResult(RESULT_OK, resultIntent);
                    finish();
                }
            }
        });

        promptB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(questionSize==5){
                    //create intent to go to end screen
                    Intent endScreen = new Intent(questionScreen.this, end_quiz.class);
                    startActivity(endScreen);

                }
                else {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("Answer", "promtB");

                    setResult(RESULT_OK, resultIntent);
                    finish();
                }
            }
        });

        promptC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(questionSize==5){
                    //create intent to go to end screen
                    Intent endScreen = new Intent(questionScreen.this, end_quiz.class);
                    startActivity(endScreen);

                }
                else {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("Answer", "promtC");

                    setResult(RESULT_OK, resultIntent);
                    finish();
                }
            }
        });

        promptD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(questionSize==5){
                    //create intent to go to end screen
                    Intent endScreen = new Intent(questionScreen.this, end_quiz.class);
                    startActivity(endScreen);

                }
                else {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("Answer", "promtD");

                    setResult(RESULT_OK, resultIntent);
                    finish();
                }
            }
        });





    }
}
