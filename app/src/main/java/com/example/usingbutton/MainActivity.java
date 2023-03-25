package com.example.usingbutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameActive = true;
    int activeplayer = 0;
    int gamestate[] = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    // state meanning
    //  0 - X
    //  1 - O
    //  2 - Null
    int[][] winningposition = {{0, 1, 2}, {3, 4, 5},
            {6, 7, 8}, {0, 3, 6}, {1, 4, 7},
            {2, 5, 8}, {0, 4, 8}, {6, 4, 2}};

    public void playertap(View view) {

        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());//image view no ek img obj chhe ne pachi tena img na tag ne call kari ne string ma convert kare la chhe*
        // basically it will return int of tag
        if(!gameActive){
            gameReset(view);
        }
        if (gamestate[tappedImage] == 2 ) {
            gamestate[tappedImage] = activeplayer;
            img.setTranslationY(-1000f);

            if (activeplayer == 0) {
                img.setImageResource(R.drawable.x);
                activeplayer = 1;
                TextView status = findViewById(R.id.status);
                status.setText("O's Turn");
            }
            else {
                img.setImageResource(R.drawable.o);
                activeplayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText("X's Turn");
            }

            img.animate().translationYBy(1000f).setDuration(300);
        }

        //check if any player has won
        for(int [] winningposition : winningposition){
            if(gamestate[winningposition[0]] == gamestate[winningposition[1]] &&
                    gamestate[winningposition[1]] == gamestate[winningposition[2]] &&
                            gamestate[winningposition[0]] !=2){
                // koi jiti gyu
                String winnerStr;
                if(gamestate[winningposition[0]]== 0){
                    winnerStr = "X Is Winner :-)";
                    gameActive = false;
                }
                else{
                    winnerStr = "O Is Winner :-)";
                    gameActive = false;
                }
                // Update the status bar

                TextView status = findViewById(R.id.status);
                status.setText(winnerStr);
            }


        }

    }
    public void gameReset(View view){
        gameActive = true;
        activeplayer = 0;
        for(int i = 0; i<gamestate.length; i++){
            gamestate[i] = 2;
        }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}