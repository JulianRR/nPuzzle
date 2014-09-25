package nl.mprog.projects.npuzzle10352783;

import android.app.Application;
import android.graphics.drawable.Drawable;

/**
 * Created by julianruger on 23-09-14.
 */
public class GlobalVariables extends Application {

    private int difficulty;
    private int image;

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int d) {
        difficulty = d;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int im) {
        image = im;
    }

}
