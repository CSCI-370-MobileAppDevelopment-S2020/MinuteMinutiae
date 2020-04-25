package com.introtoandroid.minuteminutiae;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class end_quiz extends Activity {

    Button home;
    TextView winner;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quizend);

        home = (Button) findViewById(R.id.home);
        winner = (TextView) findViewById(R.id.winner);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(end_quiz.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
