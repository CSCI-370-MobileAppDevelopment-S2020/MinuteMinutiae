package com.introtoandroid.minuteminutiae;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;

public class questionScreenRotated extends Activity {

    Intent i;
    public void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_screen_rotated);

        i = getIntent();
        String p = i.getStringExtra("PLAYER");
        final Boolean penaltyValue = i.getBooleanExtra("penaltyValue", false);

        final int questionNum = i.getIntExtra("QUESTION_NUMBER", 0);
        final int questionSize = i.getIntExtra("QUESTION_SIZE", 0);
        Log.i("questionScreen", "" + questionSize);
        final TextView questionText = findViewById(R.id.questionText);
        final Button promptA = findViewById(R.id.promptA);
        final Button promptB = findViewById(R.id.promptB);
        final Button promptC = findViewById(R.id.promptC);
        final Button promptD = findViewById(R.id.promptD);

        String [] questions = getResources().getStringArray(R.array.questions);
        String [] promptsA = getResources().getStringArray(R.array.answersA);
        String [] promptsB = getResources().getStringArray(R.array.answersB);
        String [] promptsC = getResources().getStringArray(R.array.answersC);
        String [] promptsD = getResources().getStringArray(R.array.answersD);
        String [] answers = getResources().getStringArray(R.array.answers);

        /*Random rand = new Random();
        int q = questions.length;
        int n = rand.nextInt(questions.length);*/
        Log.i("QuestionScreen", "Question Number: " + questionNum);
        questionText.setText(questions[questionNum]);
        promptA.setText(promptsA[questionNum]);
        promptB.setText(promptsB[questionNum]);
        promptC.setText(promptsC[questionNum]);
        promptD.setText(promptsD[questionNum]);

        final String answer = answers[questionNum];
        Log.i("QUESTIONSCREEN", "Answer is: "+ answer);
        final View customLayout = getLayoutInflater().inflate(R.layout.custom_alert_dialog, null);

        View.OnClickListener answerListener = new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //Figure out which button was clicked
                int buttonID = view.getId();
                Button buttonClicked = findViewById(buttonID);
                if(buttonClicked.getText().toString().equals(answer)){
                    //selected correct answer
                    //show pop up that says they answer correctly
                    //go back to buzzer screen
                    final Dialog dialog = new Dialog(questionScreenRotated.this);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setCancelable(false);
                    dialog.setContentView(R.layout.custom_alert_dialog);
                    TextView title = (TextView) dialog.findViewById(R.id.title);
                    title.setText("Correct!");

                    Button dialogbutton = (Button) dialog.findViewById(R.id.dialogbutton);
                    dialogbutton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                            if(questionSize==5){
                                //create intent to go to end screen
                                int p1s = i.getIntExtra("PLAYERONESCORE", 0) + 1;
                                int p2s = i.getIntExtra("PLAYERTWOSCORE", 0);
                                Intent endScreen = new Intent(questionScreenRotated.this, end_quiz.class);
                                endScreen.putExtra("PLAYERONESCORE", p1s);
                                endScreen.putExtra("PLAYERTWOSCORE", p2s);
                                startActivity(endScreen);

                            }
                            else {
                                Intent resultIntent = new Intent();
                                resultIntent.putExtra("point", "PlayerOne");
                                resultIntent.putExtra("wrong", "NA" );

                                setResult(RESULT_OK, resultIntent);
                                finish();
                            }

                        }

                    });
                    dialog.show();

                    /*new AlertDialog.Builder(questionScreenRotated.this)
                            .setTitle("Correct")
                            .setMessage("Ready for next Question?")

                            // Specifying a listener allows you to take an action before dismissing the dialog.
                            // The dialog is automatically dismissed when a dialog button is clicked.
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // go back to buzzer screen
                                    if(questionSize==5){
                                        //create intent to go to end screen
                                        int p1s = i.getIntExtra("PLAYERONESCORE", 0) + 1;
                                        int p2s = i.getIntExtra("PLAYERTWOSCORE", 0);
                                        Intent endScreen = new Intent(questionScreenRotated.this, end_quiz.class);
                                        endScreen.putExtra("PLAYERONESCORE", p1s);
                                        endScreen.putExtra("PLAYERTWOSCORE", p2s);
                                        startActivity(endScreen);

                                    }
                                    else {
                                        Intent resultIntent = new Intent();
                                        resultIntent.putExtra("point", "PlayerOne");
                                        resultIntent.putExtra("wrong", "NA" );

                                        setResult(RESULT_OK, resultIntent);
                                        finish();
                                    }
                                }
                            })

                            // A null listener allows the button to dismiss the dialog and take no further action.
                            //.setNegativeButton(android.R.string.no, null)
                            //.setIcon(android.R.drawable.ic_dialog_alert)
                            .show();*/
                }
                else{
                    //selected wrong answer
                    final Dialog dialog = new Dialog(questionScreenRotated.this);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setCancelable(false);
                    dialog.setContentView(R.layout.custom_alert_dialog);
                    TextView title = (TextView) dialog.findViewById(R.id.title);
                    title.setText("Incorrect");

                    Button dialogbutton = (Button) dialog.findViewById(R.id.dialogbutton);
                    dialogbutton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                            if(questionSize==5){
                                //create intent to go to end screen
                                Intent endScreen = new Intent(questionScreenRotated.this, end_quiz.class);
                                //If wrong answer penalty is on, they lose a point when wrong
                                if(penaltyValue){
                                    int p1Score = i.getIntExtra("PLAYERONESCORE", 0) - 1;
                                    endScreen.putExtra("PLAYERONESCORE", p1Score);
                                }
                                else {
                                    endScreen.putExtra("PLAYERONESCORE", i.getIntExtra("PLAYERTWOSCORE", 0));
                                }
                                endScreen.putExtra("PLAYERTWOSCORE", i.getIntExtra("PLAYERTWOSCORE", 0));
                                startActivity(endScreen);

                            }
                            else {
                                Intent resultIntent = new Intent();
                                resultIntent.putExtra("point", "NA");
                                resultIntent.putExtra("wrong", "PlayerOne");
                                setResult(RESULT_OK, resultIntent);
                                finish();
                            }
                        }
                    });
                    dialog.show();
                    /*new AlertDialog.Builder(questionScreenRotated.this)
                            .setTitle("Incorrect")
                            //.setMessage("Player 1's turn!")
                            //.setMessage("Next Question")

                            // Specifying a listener allows you to take an action before dismissing the dialog.
                            // The dialog is automatically dismissed when a dialog button is clicked.
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // go back to buzzer screen
                                    if(questionSize==5){
                                        //create intent to go to end screen
                                        Intent endScreen = new Intent(questionScreenRotated.this, end_quiz.class);
                                        //If wrong answer penalty is on, they lose a point when wrong
                                        if(penaltyValue){
                                            int p1Score = i.getIntExtra("PLAYERONESCORE", 0) - 1;
                                            endScreen.putExtra("PLAYERONESCORE", p1Score);
                                        }
                                        else {
                                            endScreen.putExtra("PLAYERONESCORE", i.getIntExtra("PLAYERTWOSCORE", 0));
                                        }
                                        endScreen.putExtra("PLAYERTWOSCORE", i.getIntExtra("PLAYERTWOSCORE", 0));
                                        startActivity(endScreen);

                                    }
                                    else {
                                        Intent resultIntent = new Intent();
                                        resultIntent.putExtra("point", "NA");
                                        resultIntent.putExtra("wrong", "PlayerOne");
                                        setResult(RESULT_OK, resultIntent);
                                        finish();
                                    }


                                }
                            })

                            // A null listener allows the button to dismiss the dialog and take no further action.
                            //.setNegativeButton(android.R.string.no, null)
                            //.setIcon(android.R.drawable.ic_dialog_alert)
                            .show();*/
                }

            }
        };

        promptA.setOnClickListener(answerListener);

        promptB.setOnClickListener(answerListener);

        promptC.setOnClickListener(answerListener);

        promptD.setOnClickListener(answerListener);

    }
}
