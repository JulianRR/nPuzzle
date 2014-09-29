package nl.mprog.projects.npuzzle10352783;

import nl.mprog.projects.npuzzle10352783.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ToggleButton;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


/**
 * GameSetupActivity.java
 * This activity is the setup for the game.
 *
 * Name: Julian Ruger
 * Student ID: 10352783
 * E-mail: julian.ruger@student.uva.nl
 *
 */
public class GameSetupActivity extends Activity {

    private static final int EASY = 3;
    private static final int MEDIUM = 4;
    private static final int HARD = 5;
    private static final int SELECT_PHOTO = 100;

    GlobalVariables globalVariables;

    Button easy, medium, hard, customImg;
    ImageButton im1, im2, im3;
    ToggleButton toggleEasy, toggleMedium, toggleHard;
    Intent intent;
    ImageView customImage;
    Uri imageUri;
    Bitmap image;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_game_setup);

        globalVariables = (GlobalVariables) getApplicationContext();

        customImg = (Button) findViewById(R.id.custom_button);

        toggleEasy = (ToggleButton) findViewById(R.id.easy_togglebutton);
        toggleMedium = (ToggleButton) findViewById(R.id.medium_togglebutton);
        toggleHard = (ToggleButton) findViewById(R.id.hard_togglebutton);

        im1 = (ImageButton) findViewById(R.id.imageButton);
        im2 = (ImageButton) findViewById(R.id.imageButton2);
        im3 = (ImageButton) findViewById(R.id.imageButton3);

        customImage = (ImageView) findViewById(R.id.customImageView);


        intent = new Intent(this, GamePlayActivity.class);
        globalVariables.setDifficulty(MEDIUM);

        toggleEasy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    globalVariables.setDifficulty(EASY);
                    toggleMedium.setChecked(false);
                    toggleHard.setChecked(false);
                }
            }
        });

        toggleMedium.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    globalVariables.setDifficulty(MEDIUM);
                    toggleEasy.setChecked(false);
                    toggleHard.setChecked(false);
                }
            }
        });

        toggleHard.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    globalVariables.setDifficulty(HARD);
                    toggleEasy.setChecked(false);
                    toggleMedium.setChecked(false);
                }
            }
        });


        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image = BitmapFactory.decodeResource(getResources(), R.drawable.android_icon);
                globalVariables.setImage(image);
                startActivity(intent);
            }
        });

        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image = BitmapFactory.decodeResource(getResources(), R.drawable.android_vector);
                globalVariables.setImage(image);
                startActivity(intent);
            }
        });

        im3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
                globalVariables.setImage(image);
                startActivity(intent);
            }
        });

        customImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chooseImageIntent = new Intent(Intent.ACTION_PICK);
                chooseImageIntent.setType("image/*");
                startActivityForResult(chooseImageIntent, SELECT_PHOTO);

            }
        });




    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        switch(requestCode) {
            case SELECT_PHOTO:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = imageReturnedIntent.getData();
                    InputStream imageStream = null;
                    try {
                        imageStream = getContentResolver().openInputStream(selectedImage);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    image = BitmapFactory.decodeStream(imageStream);
                    customImage.setImageBitmap(image);
                    globalVariables.setImage(image);
                    startActivity(intent);

                }
        }
    }




}
