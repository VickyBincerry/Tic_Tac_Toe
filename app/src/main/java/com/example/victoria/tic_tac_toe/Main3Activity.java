package com.example.victoria.tic_tac_toe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {
    private Button[][] buttons = new Button[5][5];
    private boolean gamester1Turn = true;
    private int roundCount;

    private int gamester1Points;
    private int gamester2Points;

    private TextView textViewGamester1;
    private TextView textViewGamester2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        textViewGamester1 = (TextView) findViewById(R.id.text_view_g1);
        textViewGamester2 = (TextView) findViewById(R.id.text_view_g2);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                String buttonID = "button_" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = (Button) findViewById(resID);
                buttons[i][j].setOnClickListener(this);



            }

        }

        Button buttonReset = (Button) findViewById(R.id.button_reset);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame();
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (!((Button) v).getText().toString().equals("")) {
            return;
        }

        if (gamester1Turn) {
            ((Button) v).setText("X");
        } else {
            ((Button) v).setText("O");
        }

        roundCount++;

        if (checkForWin()) {
            if (gamester1Turn) {
                gamester1Wins();
            } else {
                gamester2Wins();
            }
        } else if (roundCount == 25) {
            draw();
        } else {
            gamester1Turn = !gamester1Turn;
        }
    }

    // Check for win
    private boolean checkForWin() {
        String[][] field = new String[5][5];

        //route the string on the button to the field variable
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                field[i][j] = buttons[i][j].getText().toString();
            }
        }
        //Check the rows
        for (int i = 0; i < 5; i++) {
            if (field[i][0].equals(field[i][1]) && field[i][0].equals(field[i][2]) && field[i][0].equals(field[i][3]) && field[i][0].equals(field[i][4]) && !field[i][0].equals("")) {
                return true;
            }
        }
        //Check the columns
        for (int i = 0; i < 5; i++) {
            if (field[0][i].equals(field[1][i]) && field[0][i].equals(field[2][i]) && field[0][i].equals(field[3][i]) && field[0][i].equals(field[4][i]) && !field[0][i].equals("")) {
                return true;
            }
        }

        // Check the diagonals
        if (field[0][0].equals(field[1][1]) && field[0][0].equals(field[2][2]) && field[0][0].equals(field[3][3]) && field[0][0].equals(field[4][4]) && !field[0][0].equals("")) {
            return true;
        }
        if (field[0][2].equals(field[1][1]) && field[0][2].equals(field[2][0]) && field[0][2].equals(field[3][0]) && field[0][2].equals(field[4][0]) && !field[0][2].equals("")) {
            return true;
        }
        return false;
    }

    private void gamester1Wins() {
        gamester1Points++;
        Toast.makeText(this, "GAMESTER 1 WINS!!!!", Toast.LENGTH_SHORT).show();
        updatePointstText();
        resetBoard();
    }

    private void gamester2Wins() {
        gamester2Points++;
        Toast.makeText(this, "GAMESTER 2 WINS!!!!", Toast.LENGTH_SHORT).show();
        updatePointstText();
        resetBoard();
    }

    private void draw() {
        Toast.makeText(this, "GAME OVER!!IT'S A DRAW!!", Toast.LENGTH_SHORT).show();
        resetBoard();
    }

    private void updatePointstText() {
        textViewGamester1.setText("Gamester 1[X]: " + gamester1Points);
        textViewGamester2.setText("Gamester 2[0]: " + gamester2Points);
    }

    private void resetBoard() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                buttons[i][j].setText("");
            }
        }
        roundCount = 0;
        gamester1Turn = true;
    }

    private void resetGame() {
        gamester1Points = 0;
        gamester2Points = 0;
        updatePointstText();
        resetBoard();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("roundCount", roundCount);
        outState.putInt("gamester1Points", gamester1Points);
        outState.putInt("gamester2Points", gamester2Points);
        outState.putBoolean("gamester1Turn", gamester1Turn);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        roundCount = savedInstanceState.getInt("roundCount");
        gamester1Points = savedInstanceState.getInt("gamester1Points");
        gamester2Points = savedInstanceState.getInt("gamester2Points");
        gamester1Turn = savedInstanceState.getBoolean("gamester1Turn");

    }
}

