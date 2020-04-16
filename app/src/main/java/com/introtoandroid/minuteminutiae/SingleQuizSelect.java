package com.introtoandroid.minuteminutiae;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SingleQuizSelect extends AppCompatActivity {
    GridView quizGrid;
    ListView selectList;
    ArrayList<Quiz> quizList;
    ArrayList<String> geoQuestions;
    ArrayList<String> geoAnswers;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_select_activity);

        //Creates a quiz for testing, with questions and answers
        geoQuestions = new ArrayList<>(5);
        geoAnswers = new ArrayList<>(5);
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
        geoQuiz.setName("Geography quiz");

        //Creates an empty quiz for testing
        Quiz testQuiz = new Quiz();
        testQuiz.setName("Test quiz");

        //Contains a list of all the quizes
        quizList = new ArrayList<Quiz>();

        quizList.add(testQuiz);
        quizList.add(geoQuiz);

        //Populates a list of quiz names to be listed in the ListView
        String[] quizNameList = new String[quizList.size()];
        for(int i = 0; i<quizList.size(); i++){
            quizNameList[i] = quizList.get(i).getName();
        }

        Context context = getApplicationContext();

        Intent intent = getIntent();

        //Code for grid view adapter, etc.
        //quizList = intent.getParcelableArrayListExtra("quizList");
        //quizGrid = findViewById(R.id.quizGrid);
        //QuizAdapter adapter = new QuizAdapter(context, quizList);
        //quizGrid.setAdapter(adapter);

        selectList = findViewById(R.id.select_list);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, quizNameList);
        selectList.setAdapter(adapter);

    }
}
