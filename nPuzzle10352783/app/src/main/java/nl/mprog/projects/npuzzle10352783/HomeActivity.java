package nl.mprog.projects.npuzzle10352783;

import nl.mprog.projects.npuzzle10352783.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.content.Intent;
import android.widget.PopupWindow;

/**
 * HomeActivity.java
 * Start screen for the n Puzzle game.
 *
 * Name: Julian Ruger
 * Student ID: 10352783
 * E-mail: julian.ruger@student.uva.nl
 *
 */

public class HomeActivity extends Activity {

    Button play, help, close;
    Intent intent;
    PopupWindow popupHelp;
    View popupView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);

        play = (Button) findViewById(R.id.play_button);
        help = (Button) findViewById(R.id.help_button);


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(HomeActivity.this, GameSetupActivity.class);
                startActivity(intent);
            }
        });

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupView = getLayoutInflater().inflate(R.layout.popup_help, null);
                popupHelp = new PopupWindow(popupView, 500, 600, true);
                popupHelp.showAtLocation(popupView, Gravity.CENTER, 0, 0);

                close = (Button) popupView.findViewById(R.id.close_button);

                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupHelp.dismiss();
                    }
                });


            }
        });




    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

    }



}
