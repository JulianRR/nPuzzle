package nl.mprog.projects.npuzzle10352783;

import nl.mprog.projects.npuzzle10352783.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


/**
 * GameSetupActivity.java
 * This activity is the setup for the game.
 *
 * Name: Julian Ruger
 * Student ID: 10352783
 * E-mail: julian.ruger@student.uva.nl
 *
 */
public class GameSetupActivity extends Activity {

    private static final int EASY = 3;
    private static final int MEDIUM = 4;
    private static final int HARD = 5;

    Button easy, medium, hard;
    ImageButton im1, im2, im3;
    Intent intent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_game_setup);

        final GlobalVariables globalVariables = (GlobalVariables) getApplicationContext();

        easy = (Button) findViewById(R.id.easy_button);
        medium = (Button) findViewById(R.id.medium_button);
        hard = (Button) findViewById(R.id.hard_button);

        im1 = (ImageButton) findViewById(R.id.imageButton);
        im2 = (ImageButton) findViewById(R.id.imageButton2);
        im3 = (ImageButton) findViewById(R.id.imageButton3);


        intent = new Intent(this, GamePlayActivity.class);
        globalVariables.setDifficulty(MEDIUM);

        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                globalVariables.setDifficulty(EASY);

            }
        });

        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                globalVariables.setDifficulty(MEDIUM);


            }
        });

        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                globalVariables.setDifficulty(HARD);


            }
        });

        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                globalVariables.setImage(R.drawable.android_icon);
                startActivity(intent);
            }
        });

        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                globalVariables.setImage(R.drawable.android_vector);
                startActivity(intent);
            }
        });

        im3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                globalVariables.setImage(R.drawable.ic_launcher);
                startActivity(intent);
            }
        });



    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

    }

}
