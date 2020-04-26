package com.introtoandroid.minuteminutiae;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.CompoundButton;
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

    Boolean roundTimerValue = false;
    Boolean penaltyValue = false;
    Integer numOfQuestionsValue;


    final int RESULT_CODE = 30;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        intent = new Intent(this, MainActivity.class);


        getSupportActionBar().setTitle("Settings");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_layout);

        numOfQuestions = findViewById(R.id.numQuestionsText);
        wrongAnswerPenalty = findViewById(R.id.penaltySwitch);
        roundTimer = findViewById(R.id.timerSwitch);

        //Set roundTimerValue to true if checked, false if not
        roundTimer.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    roundTimerValue = true;
                }
                else{
                    roundTimerValue = false;
                }
            }
        });

        //Set penaltyValue to true if checked, false if not
        wrongAnswerPenalty.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    penaltyValue = true;
                }
                else{
                    penaltyValue = false;
                }
            }
        });

    }

    public boolean onOptionsItemSelected(MenuItem item){

        setResult(RESULT_CODE, intent);
        finish();

        return true;
    }

    @Override
    public void finish(){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);

        intent.putExtra("roundTimerValue", roundTimerValue);
        intent.putExtra("penaltyValue", penaltyValue);
        intent.putExtra("numOfQuestionsValue", numOfQuestionsValue);
        super.finish();
    }
}
