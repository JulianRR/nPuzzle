package nl.mprog.projects.npuzzle10352783;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


/**
 * YouWInActivity.java
 * This activity pops up when the puzzle is solved.
 *
 * Name: Julian Ruger
 * Student ID: 10352783
 * E-mail: julian.ruger@student.uva.nl
 *
 */
public class YouWinActivity extends Activity {

    Button playAgain;
    Intent intent;
    private int nMoves;

    TextView win;

    GameSettings settings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_you_win);

        settings = GameSettings.getInstance();

        playAgain = (Button) findViewById(R.id.playagain_button);
        win = (TextView) findViewById(R.id.textView);

        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(YouWinActivity.this, GameSetupActivity.class);
                startActivity(intent);
            }
        });

        win.setText("You Win! \n You solved the puzzle \n with " + settings.getMoves() + " moves!");


    }


}
