package com.introtoandroid.minuteminutiae;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class button_buzzer extends AppCompatActivity {

    ImageButton playerOneButton;
    ImageButton playerTwoButton;
    TextView questionView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button_buzzer);

        int[] questionNums;
        playerOneButton = (ImageButton) findViewById(R.id.imageButton);
        playerTwoButton = (ImageButton) findViewById(R.id.imageButton2);
        questionView = (TextView) findViewById(R.id.question_text_for_user);
        String [] questions = getResources().getStringArray(R.array.questions);
        Random rand = new Random();
        int q = questions.length;
        final int n = rand.nextInt(questions.length);
        questionView.setText(questions[n]);

        playerOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Buzzer", "Player One pressed button first");
                Intent i = new Intent(button_buzzer.this, questionScreen.class);
                i.putExtra("QUESTION_NUMBER", n);
                startActivity(i);
            }
        });

        playerTwoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Buzzer", "Player Two pressed button first");
                Intent i = new Intent(button_buzzer.this, questionScreen.class);
                i.putExtra("QUESTION_NUMBER", n);
                startActivity(i);
            }
        });

    }
}
