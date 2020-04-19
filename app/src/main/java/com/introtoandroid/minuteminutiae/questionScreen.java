package com.introtoandroid.minuteminutiae;
import android.os.Bundle;
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

        final TextView questionText = (TextView)findViewById(R.id.questionText);
        final Button promptA = (Button)findViewById(R.id.promptA);
        final Button promptB = (Button)findViewById(R.id.promptA);
        final Button promptC = (Button)findViewById(R.id.promptA);
        final Button promptD = (Button)findViewById(R.id.promptA);

        String [] questions = getResources().getStringArray((R.array.questions));
        String [] promptsA = getResources().getStringArray((R.array.answersA));
        String [] promptsB = getResources().getStringArray((R.array.answersB));
        String [] promptsC = getResources().getStringArray((R.array.answersC));
        String [] promptsD = getResources().getStringArray((R.array.answersD));
        String [] answers = getResources().getStringArray((R.array.answers));

        Random rand = new Random();
        int q = questions.length(); // idk why this doesnt work? can any of you see why?
        int n = rand.nextInt(questions.length());
        questionText.setText(questions[n]);
        promptA.setText(promptsA[n]);
        promptB.setText(promptsB[n]);
        promptC.setText(promptsC[n]);
        promptD.setText(promptsD[n]);



    }
}
