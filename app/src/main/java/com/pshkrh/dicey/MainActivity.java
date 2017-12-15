package com.pshkrh.dicey;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button rollButton = (Button) findViewById(R.id.rollButton);

        final ImageView leftDice = (ImageView) findViewById(R.id.img_leftdice);
        final ImageView rightDice = (ImageView) findViewById(R.id.img_rightdice);

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Dicey" , "The button has been pressed!");

                Random rng = new Random();

                int x;

                int num1 = rng.nextInt(6);
                int num2 = rng.nextInt(6);

                Log.d("Dicey", "Random Number 1 is " + num1 + " and Random Number 2 is " + num2);

                final int diceArr[] = {
                        R.drawable.dice1,
                        R.drawable.dice2,
                        R.drawable.dice3,
                        R.drawable.dice4,
                        R.drawable.dice5,
                        R.drawable.dice6
                };
                leftDice.setImageResource(diceArr[num1]);
                rightDice.setImageResource(diceArr[num2]);
            }
        });



    }
}
