package com.example.byras.connecttictac;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //First program have to recreate it in more object oriented way.

    /*
    PARAM
    useFields = is used for check the fields which were already clicked
    ifRedsTurn = indicates whose turn is (false - yellow turn, true - reds turn)
    redList, yellowList = ArrayList which contains ImageViews list
     */
    static boolean[][] usedFields = new boolean[3][3];
    int [][] placementTable = new int[3][3];
    static boolean ifRedsTurn = true;

    public void clickOn00(View view) throws InterruptedException {
        ImageView redButton = findViewById(R.id.red00);
        ImageView yellowButton = findViewById(R.id.yellow00);
        placeAToken(0,0, redButton, yellowButton);
        checkWhoWon();
    }

    public void clickOn01(View view) throws InterruptedException {
        ImageView redButton = findViewById(R.id.red01);
        ImageView yellowButton = findViewById(R.id.yellow01);
        placeAToken(0,1, redButton, yellowButton);
        checkWhoWon();
    }

    public void clickOn02(View view) throws InterruptedException {
        ImageView redButton = findViewById(R.id.red02);
        ImageView yellowButton = findViewById(R.id.yellow02);
        placeAToken(0,2, redButton, yellowButton);
        checkWhoWon();
    }

    public void clickOn10(View view) throws InterruptedException {
        ImageView redButton = findViewById(R.id.red10);
        ImageView yellowButton = findViewById(R.id.yellow10);
        placeAToken(1,0, redButton, yellowButton);
        checkWhoWon();
    }

    public void clickOn11(View view) throws InterruptedException {
        ImageView redButton = findViewById(R.id.red11);
        ImageView yellowButton = findViewById(R.id.yellow11);
        placeAToken(1,1, redButton, yellowButton);
        checkWhoWon();
    }

    public void clickOn12(View view) throws InterruptedException {
        ImageView redButton = findViewById(R.id.red12);
        ImageView yellowButton = findViewById(R.id.yellow12);
        placeAToken(1,2, redButton, yellowButton);
        checkWhoWon();
    }

    public void clickOn20(View view) throws InterruptedException {
        ImageView redButton = findViewById(R.id.red20);
        ImageView yellowButton = findViewById(R.id.yellow20);
        placeAToken(2,0, redButton, yellowButton);
        checkWhoWon();
    }

    public void clickOn21(View view) throws InterruptedException {
        ImageView redButton = findViewById(R.id.red21);
        ImageView yellowButton = findViewById(R.id.yellow21);
        placeAToken(2,1, redButton, yellowButton);
        checkWhoWon();
    }

    public void clickOn22(View view) throws InterruptedException {
        ImageView redButton = findViewById(R.id.red22);
        ImageView yellowButton = findViewById(R.id.yellow22);
        placeAToken(2,2, redButton, yellowButton);
        checkWhoWon();
    }

    public void checkWhoWon () throws InterruptedException {
        int colorIndex;
        String winMessage;
        if (ifRedsTurn){
            colorIndex = 2;
            winMessage = "YELLOW WINS!!!";
        } else {
            colorIndex = 1;
            winMessage = "RED WINS";
        }


        if (placementTable [0][0]==colorIndex && placementTable [0][1]==colorIndex && placementTable [0][2]==colorIndex){
            Toast.makeText(this, winMessage, Toast.LENGTH_LONG).show();
            Thread.sleep(2000);
            resetGame();
        }
        if (placementTable [1][0]==colorIndex && placementTable [1][1]==colorIndex && placementTable [1][2]==colorIndex){
            Toast.makeText(this, winMessage, Toast.LENGTH_LONG).show();
            Thread.sleep(2000);
            resetGame();
        }
        if (placementTable [2][0]==colorIndex && placementTable [2][1]==colorIndex && placementTable [2][2]==colorIndex){
            Toast.makeText(this, winMessage, Toast.LENGTH_LONG).show();
            Thread.sleep(2000);
            resetGame();
        }

        if (placementTable [0][0]==colorIndex && placementTable [1][0]==colorIndex && placementTable [2][0]==colorIndex){
            Toast.makeText(this, winMessage, Toast.LENGTH_LONG).show();
            Thread.sleep(2000);
            resetGame();
        }
        if (placementTable [0][1]==colorIndex && placementTable [1][1]==colorIndex && placementTable [1][2]==colorIndex){
            Toast.makeText(this, winMessage, Toast.LENGTH_LONG).show();
            Thread.sleep(2000);
            resetGame();
        }
        if (placementTable [0][2]==colorIndex && placementTable [1][2]==colorIndex && placementTable [2][2]==colorIndex){
            Toast.makeText(this, winMessage, Toast.LENGTH_LONG).show();
            Thread.sleep(2000);
            resetGame();
        }

        if (placementTable [0][0]==colorIndex && placementTable [1][1]==colorIndex && placementTable [2][2]==colorIndex){
            Toast.makeText(this, winMessage, Toast.LENGTH_LONG).show();
            Thread.sleep(2000);
            resetGame();
        }
        if (placementTable [2][0]==colorIndex && placementTable [1][1]==colorIndex && placementTable [0][2]==colorIndex){
            Toast.makeText(this, winMessage, Toast.LENGTH_LONG).show();
            Thread.sleep(2000);
            resetGame();
        }
    }


    public void placeAToken(int row, int column, ImageView redCoin, ImageView yellowCoin) {
        if (!usedFields[row][column]) {
            if (ifRedsTurn) {
                placeRedCoin(redCoin, row, column);
            } else {
                placeYellowCoin(yellowCoin, row, column);
            }
        } else {
            Toast.makeText(this, "Seriously? Choose another tile.", Toast.LENGTH_LONG).show();
        }
    }

    /*
    showTheCoin - a method which animates passed ImageView of button
     */
    public static void showTheCoin(ImageView button) {
        button.animate().alpha(1).setDuration(1000);
    }

    /*
    placeRedCoin - method which takes Image and indexes of 2D array, calls showTheCoin method
    sets whose turn is this (ifRedsTurn), and marks the field on 2D array as a coin has been
    already placed
     */
    public void placeRedCoin(ImageView redButton, int row, int column) {
        showTheCoin(redButton);
        ifRedsTurn = false;
        usedFields[row][column] = true;
        placementTable[row][column] = 1;
    }

    /*
   placeYellowCoin - method which takes Image and indexes of 2D array, calls showTheCoin method
   sets whose turn is this (ifRedsTurn), and marks the field on 2D array as a coin has been
   already placed
    */
    public void placeYellowCoin(ImageView yellowButton, int row, int column) {
        showTheCoin(yellowButton);
        ifRedsTurn = true;
        usedFields[row][column] = true;
        placementTable[row][column] = 2;
    }

    public void resetGame () {
        for (int i=0; i<=2; i++){
            for (int j=0; j<=2; j++){
                placementTable[i][j]=0;
                usedFields[i][j]=false;
            }
        }

        //red buttons
        ImageView redButton00 = findViewById(R.id.red00);
        ImageView redButton01 = findViewById(R.id.red01);
        ImageView redButton02 = findViewById(R.id.red02);

        ImageView redButton10 = findViewById(R.id.red10);
        ImageView redButton11 = findViewById(R.id.red11);
        ImageView redButton12 = findViewById(R.id.red12);

        ImageView redButton20 = findViewById(R.id.red20);
        ImageView redButton21 = findViewById(R.id.red21);
        ImageView redButton22 = findViewById(R.id.red22);

        //alpha 0 for red buttons
        redButton00.animate().alpha(0).setDuration(1);
        redButton01.animate().alpha(0).setDuration(1);
        redButton02.animate().alpha(0).setDuration(1);

        redButton10.animate().alpha(0).setDuration(1);
        redButton11.animate().alpha(0).setDuration(1);
        redButton12.animate().alpha(0).setDuration(1);

        redButton20.animate().alpha(0).setDuration(1);
        redButton21.animate().alpha(0).setDuration(1);
        redButton22.animate().alpha(0).setDuration(1);

        //yellow buttons
        ImageView yellowButton00 = findViewById(R.id.yellow00);
        ImageView yellowButton01 = findViewById(R.id.yellow01);
        ImageView yellowButton02 = findViewById(R.id.yellow02);

        ImageView yellowButton10 = findViewById(R.id.yellow10);
        ImageView yellowButton11 = findViewById(R.id.yellow11);
        ImageView yellowButton12 = findViewById(R.id.yellow00);

        ImageView yellowButton20 = findViewById(R.id.yellow20);
        ImageView yellowButton21 = findViewById(R.id.yellow21);
        ImageView yellowButton22 = findViewById(R.id.yellow22);

        //yellow buttons set alpha to 0
        yellowButton00.animate().alpha(0).setDuration(1);
        yellowButton01.animate().alpha(0).setDuration(1);
        yellowButton02.animate().alpha(0).setDuration(1);

        yellowButton10.animate().alpha(0).setDuration(1);
        yellowButton11.animate().alpha(0).setDuration(1);
        yellowButton12.animate().alpha(0).setDuration(1);

        yellowButton20.animate().alpha(0).setDuration(1);
        yellowButton21.animate().alpha(0).setDuration(1);
        yellowButton22.animate().alpha(0).setDuration(1);


        Toast.makeText(this, "New game!", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
