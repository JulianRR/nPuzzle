nPuzzle
=======

[Requirements](http://apps.mprog.nl/projects/n-puzzle-android)

[n-Puzzle wiki](http://en.wikipedia.org/wiki/15_puzzle)


## Proposal

n-Puzzle with three difficulties, 3x3, 4x4 and 5x5.

### Features
* Three difficulties, easy (3x3), medium (4x4, default) and hard (5x5).
* User can choose existing image or upload a custom image.
* User gets to see the image 3 seconds before the game starts.
* Tap tile immediatly adjecent to empty space to move the tile.
* Menu: change difficulty (game restarts when changed), reset puzzle or quit.
* Game state must be saved if user changes app, quits etc.
* Puzzle will be timed for some competitive play.
* When puzzle is solved the player is congratulated and his time is shown in a new activity.

[Mock up](https://github.com/JulianRR/nPuzzle)


# Design Document

1. Home screen, HomeActivity.java
2. Game setup, GameSetupActivity.java
3. Gameplay, PuzzleActivity.java
4. Menu
5. End game
6. Extra's

## 1) Home screen
HomeActiviy will be a Fullscreen activity. The default Fullscreen template from android studio will be used for this activity. I will add two buttons. The first button is the play button which will take the user to the next (GameSetupActivity.java) activity. The second button is the help button which will show a pop up window where the game will be explained.

Usefull classes:
* [Intent](http://developer.android.com/reference/android/content/Intent.html)
  * [public abstract void startActivity (Intent intent, Bundle options)](http://developer.android.com/reference/android/content/Context.html#startActivity(android.content.Intent)), will be used to change activities.
* [PopupWindow](http://developer.android.com/reference/android/widget/PopupWindow.html), will be used for the help button pop up.

## 2) Game setup
GameSetupActivity will be a Fullscreen activity. The default Fullscreen template from android studio will be used for this activity. The difficulty buttons will set a global variable when pressed to keep track of which difficulty is used.
The user has the option to choose between three existing images. The user can also choose a custom image from his or her device. When an image is chosen the game starts (if the user also chose a difficulty, so if the difficulty variable is set).

Usefull classes:
* [ToggleButton](http://developer.android.com/reference/android/widget/ToggleButton.html), used to choose the difficulty.
* [ImageButton](http://developer.android.com/reference/android/widget/ImageButton.html), used for choosing one of the three existing. 
* [Intent](http://developer.android.com/reference/android/content/Intent.html)
  * [ACTION_PICK](http://developer.android.com/reference/android/content/Intent.html#ACTION_PICK), used to choose an image from the gallery on the device.
    * [Tutorial](http://sudhanshuvinodgupta.blogspot.nl/2012/07/using-intentactionpick.html)

## 3) Gameplay
PuzzleActivity will be a Fullscreen activity. he default Fullscreen template from android studio will be used for this activity. The image chosen will be shown 3 seconds before the game starts. After these 3 seconds a "stopwatch" will start to keep track of the time it takes to solve the puzzle.

Usefull classes:
* [ViewFlipper](http://developer.android.com/reference/android/widget/ViewFlipper.html), used to switch to a shuffled image after 3 seconds.
  * [public void setFlipInterval (int milliseconds)](http://developer.android.com/reference/android/widget/ViewFlipper.html#setFlipInterval(int)), int parameter will be set to 3000
  * [public void startFlipping ()](http://developer.android.com/reference/android/widget/ViewFlipper.html#startFlipping()), start the timer, after 3000 milliseconds the view will switch to the shuffled image (the game) view.
  * [public void stopFlipping ()](http://developer.android.com/reference/android/widget/ViewFlipper.html#stopFlipping()), stop the timer immediately after the view switched.
* [Timer](http://developer.android.com/reference/java/util/Timer.html), used to time the puzzle.
  * [Tutorial](http://stackoverflow.com/questions/4597690/android-timer-how)

Frameworks:
* [AndEngine](https://github.com/nicolasgramlich/AndEngine), used to make the n-puzzle.
* [Cocos2d-Android](http://www.cocos2d-x.org/), used instead of AndEngine if this works on android 2.1.

A few AndEngine tutorials, because AndEngine has very little documentation.
* [General tutorial](http://android.kul.is/p/list-of-tutorials.html)
* [Game Example](http://www.matim-dev.com/full-game-tutorial---part-1.html)

## 4) Menu
I decided to change the menu into a popup menu instead of a navigation drawer, because a navigation drawer does not work properly with a fullscreen app.

Usefull classes:
* [Popup menu](http://developer.android.com/reference/android/widget/PopupMenu.html), used to create a popup menu.


## 5) End game
A popup window will be used instead of a new activiy to congratulate the player on solving the puzzle. The popup window will be a bit transparent so the completed image will be visible.

Usefull classes:
* [PopupWindow](http://developer.android.com/reference/android/widget/PopupWindow.html)



# Style guide
The style guide used is the default style guide from android studio
https://source.android.com/source/code-style.html
