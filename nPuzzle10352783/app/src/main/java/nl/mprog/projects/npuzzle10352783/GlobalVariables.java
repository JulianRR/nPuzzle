package nl.mprog.projects.npuzzle10352783;

import android.app.Application;

/**
 * Created by julianruger on 23-09-14.
 */
public class GlobalVariables extends Application {

    private int difficulty;

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int d) {
        difficulty = d;
    }
}
