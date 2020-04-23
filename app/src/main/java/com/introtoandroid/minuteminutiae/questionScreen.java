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
        int questionNum = i.getIntExtra("QUESTION_NUMBER", 0);
        final TextView questionText = (TextView)findViewById(R.id.questionText);
        final Button promptA = (Button)findViewById(R.id.promptA);
        final Button promptB = (Button)findViewById(R.id.promptB);
        final Button promptC = (Button)findViewById(R.id.promptC);
        final Button promptD = (Button)findViewById(R.id.promptD);

        String [] questions = getResources().getStringArray(R.array.questions);
        String [] promptsA = getResources().getStringArray(R.array.answersA);
        String [] promptsB = getResources().getStringArray(R.array.answersB);
        String [] promptsC = getResources().getStringArray(R.array.answersC);
        String [] promptsD = getResources().getStringArray(R.array.answersD);
        String [] answers = getResources().getStringArray(R.array.answers);

        /*Random rand = new Random();
        int q = questions.length;
        int n = rand.nextInt(questions.length);*/
        Log.i("QuestionScreen", Integer.toString(questionNum));
        questionText.setText(questions[questionNum]);
        promptA.setText(promptsA[questionNum]);
        promptB.setText(promptsB[questionNum]);
        promptC.setText(promptsC[questionNum]);
        promptD.setText(promptsD[questionNum]);



    }
}
