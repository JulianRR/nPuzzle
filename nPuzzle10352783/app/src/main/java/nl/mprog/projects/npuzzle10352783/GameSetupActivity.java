package nl.mprog.projects.npuzzle10352783;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ToggleButton;

import java.io.FileNotFoundException;
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

    GameSettings settings;

    Button customImg;
    ImageButton im1, im2, im3;
    ToggleButton toggleEasy, toggleMedium, toggleHard;
    Intent intent;
    ImageView customImage;
    Bitmap image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_game_setup);

         /* GameSettings for the global variables. */
        settings = GameSettings.getInstance();


        /* The layout variables are set here (buttons, views etc). */
        customImg = (Button) findViewById(R.id.custom_button);

        toggleEasy = (ToggleButton) findViewById(R.id.easy_togglebutton);
        toggleMedium = (ToggleButton) findViewById(R.id.medium_togglebutton);
        toggleHard = (ToggleButton) findViewById(R.id.hard_togglebutton);

        im1 = (ImageButton) findViewById(R.id.imageButton);
        im2 = (ImageButton) findViewById(R.id.imageButton2);
        im3 = (ImageButton) findViewById(R.id.imageButton3);

        customImage = (ImageView) findViewById(R.id.customImageView);


        intent = new Intent(this, GamePlayActivity.class);
        settings.setDifficulty(MEDIUM);

        /* Toggle buttons to set the difficulty */
        toggleEasy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    settings.setDifficulty(EASY);
                    toggleMedium.setChecked(false);
                    toggleHard.setChecked(false);
                }
            }
        });

        toggleMedium.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    settings.setDifficulty(MEDIUM);
                    toggleEasy.setChecked(false);
                    toggleHard.setChecked(false);
                }
            }
        });

        toggleHard.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    settings.setDifficulty(HARD);
                    toggleEasy.setChecked(false);
                    toggleMedium.setChecked(false);
                }
            }
        });

        /* Image buttons to set the image, game starts if an image is chosen. */
        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image = BitmapFactory.decodeResource(getResources(), R.drawable.android_icon);
                settings.setImage(image);
                startActivity(intent);
            }
        });

        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image = BitmapFactory.decodeResource(getResources(), R.drawable.android_vector);
                settings.setImage(image);
                startActivity(intent);
            }
        });

        im3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
                settings.setImage(image);
                startActivity(intent);
            }
        });

        /* Button to choose a custom image. Game starts if an image is chosen. */
        customImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chooseImageIntent = new Intent(Intent.ACTION_PICK);
                chooseImageIntent.setType("image/*");
                startActivityForResult(chooseImageIntent, SELECT_PHOTO);

            }
        });




    }


    /* Handles the request for choosing an image from memory of the device */
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
                    settings.setImage(image);
                    startActivity(intent);

                }
        }
    }




}
