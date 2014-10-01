package nl.mprog.projects.npuzzle10352783;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.ViewFlipper;


/**
 * GamePlayActivity.java
 * This activity will contain the layout for the puzzle.
 * GamePlay.java will contain the methods to make the puzzle function. These methods
 * will be used here.
 *
 * Name: Julian Ruger
 * Student ID: 10352783
 * E-mail: julian.ruger@student.uva.nl
 *
 */


public class GamePlayActivity extends Activity implements PopupMenu.OnMenuItemClickListener {

    private static final int EASY = 3;
    private static final int MEDIUM = 4;
    private static final int HARD = 5;

    private Bitmap[] tiles;
    private Bitmap[] shuffledTiles;

    private ViewFlipper flipper;
    private GridView gameGrid;
    private Handler handler = new Handler();
    private ImageView imgView;
    private PopupWindow changeDifficulty;
    private View popupView;

    private Bitmap image;

    int difficulty;
    int nMoves = 0;
    TextView moves;
    Button menu, changeEasy, changeMedium, changeHard;


    GamePlay gamePlay;
    GameSettings settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_game_play);

        /* GameSettings for the global variables. */
        settings = GameSettings.getInstance();


        difficulty = settings.getDifficulty();
        image = settings.getImage();

        /* The layout variables are set here (buttons, views etc). */
        flipper = (ViewFlipper) findViewById(R.id.viewFlipper1);
        moves = (TextView) findViewById(R.id.nMoves);
        menu = (Button) findViewById(R.id.menu);
        imgView = (ImageView) findViewById(R.id.imageView);

        imgView.setImageBitmap(image);

        popupView = getLayoutInflater().inflate(R.layout.popup_difficulty, null);
        changeDifficulty = new PopupWindow(popupView, 400, 400, true);

        changeEasy = (Button) popupView.findViewById(R.id.change_easy);
        changeMedium = (Button) popupView.findViewById(R.id.change_medium);
        changeHard = (Button) popupView.findViewById(R.id.change_hard);

        /* Switch to the n-puzzle view after 3 seconds. */
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
               flipper.showNext();
            }
        }, 3000);

        /* Set the view for the chosen difficulty. */
        if (difficulty == EASY) {
            gameGrid = (GridView) findViewById(R.id.gridViewEasy);
        } else if (difficulty == MEDIUM) {
            gameGrid = (GridView) findViewById(R.id.gridViewMedium);
        } else if (difficulty == HARD) {
            gameGrid = (GridView) findViewById(R.id.gridViewHard);
        }


        /* Transparent/empty bitmap for the empty tile */
        Bitmap empty = Bitmap.createBitmap(130, 130, Bitmap.Config.ARGB_8888);

        /* Set all the variables for the game used in GamePlay.java */
        gamePlay = new GamePlay(difficulty, difficulty*difficulty-1, difficulty*difficulty, image,
                empty);

        /* The correct order of the tiles */
        tiles = gamePlay.splitBitmap();
        /* The shuffled order of the tiles */
        shuffledTiles = gamePlay.shuffleTiles(tiles);


        gameGrid.setAdapter(new ImageAdapter(this, shuffledTiles));

        gameGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                /* Check if correct move and update the grid. */
                if(gamePlay.updateGrid(i, shuffledTiles)) {
                    nMoves++;
                    moves.setText("Moves: " + nMoves);

                    gameGrid.setAdapter(new ImageAdapter(getApplicationContext(), shuffledTiles));
                }

                /* Check if puzzle is already solved. */
                if (gamePlay.complete(tiles, shuffledTiles)) {
                    settings.setMoves(nMoves);
                    Intent intent = new Intent(GamePlayActivity.this, YouWinActivity.class);
                    startActivity(intent);
                }
            }
        });

        /* Menu button */
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(GamePlayActivity.this, view);
                popupMenu.setOnMenuItemClickListener(GamePlayActivity.this);
                popupMenu.inflate(R.menu.popup_menu);
                popupMenu.show();

            }
        });


        /* Change difficulty buttons */
        changeEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                settings.setDifficulty(EASY);
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });

        changeMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                settings.setDifficulty(MEDIUM);
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });

        changeHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                settings.setDifficulty(HARD);
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });




    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.restart:
                Intent intent = getIntent();
                finish();
                startActivity(intent);
                return true;
            case R.id.change_difficulty:
                changeDifficulty.showAtLocation(popupView, Gravity.CENTER, 0, 0);
                return true;
            case R.id.quit:
                Intent intent2 = new Intent(GamePlayActivity.this, HomeActivity.class);
                startActivity(intent2);
                return true;
            default:
                return false;
        }

    }
}
