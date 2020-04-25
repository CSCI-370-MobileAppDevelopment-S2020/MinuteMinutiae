package com.introtoandroid.minuteminutiae;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.chip.Chip;

public class settings_activity extends AppCompatActivity {

    EditText numOfQuestions;
    Switch wrongAnswerPenalty, roundTimer;

    Boolean roundTimerValue;
    Boolean penaltyValue;
    Integer numOfQuestionsValue;


    final int RESULT_CODE = 30;


    @Override
    protected void onCreate(Bundle savedInstanceState){

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);



        getSupportActionBar().setTitle("Settings");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_layout);

        numOfQuestions = findViewById(R.id.numQuestionsText);
        wrongAnswerPenalty = findViewById(R.id.penaltySwitch);
        roundTimer = findViewById(R.id.timerSwitch);

        roundTimerValue = roundTimer.isChecked();
        penaltyValue = wrongAnswerPenalty.isChecked();

    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);

        intent.putExtra("roundTimerValue", roundTimerValue);
        intent.putExtra("penaltyValue", penaltyValue);
        setResult(RESULT_CODE);
        finish();

        return true;
    }
}
