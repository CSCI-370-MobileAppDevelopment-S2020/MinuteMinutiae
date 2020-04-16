package com.introtoandroid.minuteminutiae;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Quiz> quizList;

    Button singleQuizButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        singleQuizButton = findViewById(R.id.singleQuizButton);



        final Intent singleQuizIntent = new Intent(MainActivity.this, SingleQuizSelect.class);
        //singleQuizIntent.putParcelableArrayListExtra("quizList", quizList);

        singleQuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(singleQuizIntent);
            }
        });

    }
}
