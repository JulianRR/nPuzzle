package nl.mprog.projects.npuzzle10352783;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
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

        /* The play button. GameSetupActivity start on click. */
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(HomeActivity.this, GameSetupActivity.class);
                startActivity(intent);
            }
        });

        /* The help button. Popup window with game information is shown on click. */
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


}
