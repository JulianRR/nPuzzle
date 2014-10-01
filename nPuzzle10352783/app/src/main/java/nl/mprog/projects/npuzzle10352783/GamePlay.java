package nl.mprog.projects.npuzzle10352783;

import android.graphics.Bitmap;

/**
 * GamePlay.java
 * This class contains the methods for the puzzle.
 * These methods are used in GamePlayActivity.java
 *
 * Name: Julian Ruger
 * Student ID: 10352783
 * E-mail: julian.ruger@student.uva.nl
 *
 */
public class GamePlay {

    private int difficulty;
    private int emptyPos;
    private int size;

    private Bitmap image;
    private Bitmap emptyImg;


    /*
     * The variables needed for the methods are set here.
     */
    public GamePlay(int d, int ePos, int gridSize, Bitmap img, Bitmap eImg) {
        difficulty = d;
        emptyPos = ePos;
        size = gridSize;
        image = img;
        emptyImg = eImg;

    }


    /*
     * This methods splits the image (Bitmap) in nxn bitmaps. Each bitmap is used for a tile
     * of the n-puzzle.
     */
    public Bitmap[] splitBitmap() {
        Bitmap[] imageTiles = new Bitmap[size];

        int width = image.getWidth();
        int height = image.getHeight();
        int columns = width / difficulty;
        int rows = height / difficulty;
        int i = 0;

        /* loop through the bitmap and split it up in columns*rows bitmaps */
        for (int y = 0; y < difficulty; y++) {
            for (int x = 0; x < difficulty; x++) {
                imageTiles[i] = Bitmap.createBitmap(image, x*columns, y*rows, columns, rows);

                i++;
            }

        }
        /* Set the last bitmap (last tile) to an empty bitmap */
        imageTiles[emptyPos] = emptyImg;
        return imageTiles;
    }


    /*
     * This method shuffles a bitmap array. The array is reversed, except for
     * the bitmap on the last position. That one stays the same.
     */
    public Bitmap[] shuffleTiles(Bitmap[] a) {
        Bitmap[] sTiles = splitBitmap();

        /* Reverse the array */
        for (int i = emptyPos-1; i >= 0; i--) {
            sTiles[i] = a[emptyPos - (i+1)];
        }

        /* swap the first and the second position if the number of rows and columns is even. */
        if (difficulty == 4) {
            Bitmap tmp = sTiles[0];
            sTiles[0] = sTiles[1];
            sTiles[1] = tmp;
        }
        return sTiles;
    }


    /*
     * This method checks if a bitmap array is equal to another. This method is used to check
     * if the tiles are in the right order.
     */
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


    /*
     * This method check if the chosen tile is adjacent (left, right, top, bottom) to the empty tile.
     * If this is true the position of the chosen tile is swapped with the empty tile.
     */
    public boolean updateGrid(int pos, Bitmap[] grid) {
        if (pos == emptyPos - 1 || pos == emptyPos + 1 ||pos == emptyPos - difficulty || pos == emptyPos + difficulty) {
            Bitmap temp = grid[pos];
            grid[pos] = grid[emptyPos];
            grid[emptyPos] = temp;
            emptyPos = pos;


            return true;
        }

        return false;

    }
}
