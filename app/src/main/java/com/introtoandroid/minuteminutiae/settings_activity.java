package com.introtoandroid.minuteminutiae;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.chip.Chip;

public class settings_activity extends AppCompatActivity {

    RadioGroup numQuestionsGroup;
    Switch wrongAnswerPenalty, roundTimer;
    Button saveButton;

    Boolean roundTimerValue = false;
    Boolean penaltyValue = false;
    Integer numOfQuestionsValue = 10;


    final int RESULT_CODE = 30;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //intent = new Intent(this, MainActivity.class);


        getSupportActionBar().setTitle("Settings");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_layout);

        numQuestionsGroup = findViewById(R.id.numQuestionsGroup);
        wrongAnswerPenalty = findViewById(R.id.penaltySwitch);
        roundTimer = findViewById(R.id.timerSwitch);
        saveButton = findViewById(R.id.saveButton);



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

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int numPicked = numQuestionsGroup.getCheckedRadioButtonId();
                View radioButton = numQuestionsGroup.findViewById(numPicked);
                int idx = numQuestionsGroup.indexOfChild(radioButton);
                RadioButton r = (RadioButton) numQuestionsGroup.getChildAt(idx);

                numOfQuestionsValue = Integer.parseInt(r.getText().toString());

                finish();
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.fiveButton:
                if (checked)
                    numOfQuestionsValue = 5;
                    break;
            case R.id.tenButton:
                if (checked)
                    numOfQuestionsValue = 10;
                    break;

            case R.id.fifteenButton:
                if (checked)
                    numOfQuestionsValue = 15;
                    break;
        }

    }

    /**
    public boolean onOptionsItemSelected(MenuItem item){

        setResult(RESULT_CODE, intent);
        finish();

        return true;
    }
     */

    @Override
    public void finish(){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);


        intent.putExtra("roundTimerValue", roundTimerValue);
        intent.putExtra("penaltyValue", penaltyValue);
        intent.putExtra("numOfQuestionsValue", numOfQuestionsValue);

        setResult(RESULT_CODE, intent);
        super.finish();
    }
}
