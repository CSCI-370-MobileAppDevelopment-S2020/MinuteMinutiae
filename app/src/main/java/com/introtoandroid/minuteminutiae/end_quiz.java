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
    Intent i;
    TextView winnerScore;
    TextView otherPlayer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quizend);

        i = getIntent();
        int playerOneScore = i.getIntExtra("PLAYERONESCORE", 0);
        int playerTwoScore = i.getIntExtra("PLAYERTWOSCORE", 0);

        home = (Button) findViewById(R.id.home);
        winner = (TextView) findViewById(R.id.winner);
        winnerScore = (TextView) findViewById(R.id.winnerScore);
        otherPlayer = (TextView) findViewById(R.id.player);

        if(playerOneScore > playerTwoScore){
            winner.setText("Player 1");
            winnerScore.setText("With a score of: " + playerOneScore);
            otherPlayer.setText("Player 2's score was : " + playerTwoScore);
        }else if(playerTwoScore> playerOneScore){
            winner.setText("Player 2");
            winnerScore.setText("With a score of: " + playerTwoScore);
            otherPlayer.setText("Player 1's score was: " + playerOneScore);
        }else{
            winner.setText("Both");
            winnerScore.setText("With a score of: " + playerOneScore);

        }

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(end_quiz.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
