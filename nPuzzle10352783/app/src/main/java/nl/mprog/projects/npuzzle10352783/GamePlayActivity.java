package nl.mprog.projects.npuzzle10352783;

import nl.mprog.projects.npuzzle10352783.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.util.Arrays;
import java.util.Random;


/**
 * GamePlayActivity.java
 * This activity will contain the puzzle.
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

    private int difficulty;

    private Bitmap[] tiles;
    private Bitmap[] shuffledTiles;

    private ViewFlipper flipper;
    private GridView gameGrid;
    private Handler handler = new Handler();

    private int emptyPos;
    private int size;

    int nMoves = 0;
    TextView moves;
    Button menu;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_game_play);

        final GlobalVariables globalVariables = (GlobalVariables) getApplicationContext();

        difficulty = globalVariables.getDifficulty();
        emptyPos = difficulty * difficulty - 1;
        size = difficulty * difficulty;



        flipper = (ViewFlipper) findViewById(R.id.viewFlipper1);
        moves = (TextView) findViewById(R.id.nMoves);
        menu = (Button) findViewById(R.id.menu);



        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
               flipper.showNext();
            }
        }, 3000);

        if (difficulty == EASY) {
            gameGrid = (GridView) findViewById(R.id.gridViewEasy);
        } else if (difficulty == MEDIUM) {
            gameGrid = (GridView) findViewById(R.id.gridViewMedium);
        } else if (difficulty == HARD) {
            gameGrid = (GridView) findViewById(R.id.gridViewHard);
        }



        Bitmap image = BitmapFactory.decodeResource(getResources(), R.drawable.android_icon);

        tiles = splitBitmap(image, difficulty);
        tiles[emptyPos] = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);

        shuffledTiles = splitBitmap(image, difficulty);
        shuffleTiles();

        gameGrid.setAdapter(new ImageAdapter(this, shuffledTiles));

        gameGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("pos", "pos is" + i + "fdgdf" + view);

                if (i == emptyPos - 1 || i == emptyPos + 1 ||i == emptyPos - difficulty || i == emptyPos + difficulty) {
                    Bitmap temp = shuffledTiles[i];
                    shuffledTiles[i] = shuffledTiles[emptyPos];
                    shuffledTiles[emptyPos] = temp;
                    emptyPos = i;
                    nMoves++;
                    moves.setText("Moves: " + nMoves);

                    gameGrid.setAdapter(new ImageAdapter(getApplicationContext(), shuffledTiles));


                }

                if (complete(tiles, shuffledTiles)) {
                    Intent intent = new Intent(GamePlayActivity.this, YouWinActivity.class);
                    startActivity(intent);
                }
            }
        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(GamePlayActivity.this, view);
                popupMenu.setOnMenuItemClickListener(GamePlayActivity.this);
                popupMenu.inflate(R.menu.popup_menu);
                popupMenu.show();

            }
        });


    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

    }



    public Bitmap[] splitBitmap(Bitmap Image, int difficulty) {
        Bitmap[] imageTiles = new Bitmap[size];
        Drawable[] splitImage = new Drawable[size];

        int width = Image.getWidth();
        int height = Image.getHeight();
        int columns = width / difficulty;
        int rows = height / difficulty;
        int i = 0;
        for (int y = 0; y < difficulty; y++) {
            for (int x = 0; x < difficulty; x++) {
                imageTiles[i] = Bitmap.createBitmap(Image, x*columns, y*rows, columns, rows);

                i++;
            }

        }

        return imageTiles;
    }

    public void shuffleTiles() {
        shuffledTiles[emptyPos] = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);

        for (int i = emptyPos-1; i >= 0; i--) {
            shuffledTiles[i] = tiles[emptyPos - (i+1)];
        }

        if (difficulty == MEDIUM) {
            Bitmap tmp = shuffledTiles[0];
            shuffledTiles[0] = shuffledTiles[1];
            shuffledTiles[1] = tmp;
        }

    }

    public boolean complete(Bitmap[] a, Bitmap[] b) {
        int trueCount = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i].sameAs(b[i])) {
                trueCount++;
            }
        }
        if (trueCount == size) {
            return true;
        } else {
            return false;
        }
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
