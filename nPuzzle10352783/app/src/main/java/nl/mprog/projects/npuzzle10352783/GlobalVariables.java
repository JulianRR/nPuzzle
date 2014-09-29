package nl.mprog.projects.npuzzle10352783;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

/**
 * Created by julianruger on 23-09-14.
 */
public class GlobalVariables extends Application {

    private int difficulty;
    private Bitmap image;

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int d) {
        difficulty = d;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap img) {
        image = img;
    }



}
