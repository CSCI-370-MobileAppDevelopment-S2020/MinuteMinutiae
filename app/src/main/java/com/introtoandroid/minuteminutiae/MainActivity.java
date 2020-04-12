package com.introtoandroid.minuteminutiae;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> geoQuestions;
    ArrayList<String> geoAnswers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        geoQuestions = new ArrayList<String>(){{
            add("How many territories does the U.S. have?");
            add("What is the youngest country on Earth?");
            add("What is the most populated country in Europe?");
            add("What is the largest lake in North America?");
            add("What is the longest mountain range in the World?");
        }};
        geoAnswers = new ArrayList<String>(){{
            add("5");
            add("South Sudan");
            add("Russia");
            add("Lake Superior");
            add("The Andes");
        }};

        Quiz geoQuiz = new Quiz(geoQuestions, geoAnswers);
    }
}
