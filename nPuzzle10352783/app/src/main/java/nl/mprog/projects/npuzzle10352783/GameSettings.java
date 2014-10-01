package nl.mprog.projects.npuzzle10352783;

import android.graphics.Bitmap;

/**
 * GameSettings.java
 * Singleton class for the global variables.
 *
 * Name: Julian Ruger
 * Student ID: 10352783
 * E-mail: julian.ruger@student.uva.nl
 */
public class GameSettings {

    private static GameSettings instance;

    private int difficulty;
    private int nMoves;
    private Bitmap image;

    private GameSettings() {}

    public int getDifficulty() {
        return this.difficulty;
    }

    public void setDifficulty(int d) {
        this.difficulty = d;
    }

    public Bitmap getImage() {
        return this.image;
    }

    public void setImage(Bitmap img) {
        this.image = img;
    }

    public int getMoves() {
        return this.nMoves;
    }

    public void setMoves(int moves) {
        this.nMoves = moves;
    }

    public static synchronized GameSettings getInstance() {
        if (instance == null) {
            instance = new GameSettings();
        }
        return instance;
    }


}
