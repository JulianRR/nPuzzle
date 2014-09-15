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
3. Gameplay
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
GameSetupActivity will be a Fullscreen activity. The default Fullscreen template from android studio will be used for this activity.

Usefull classes:

## 3) Gameplay


Usefull classes:

## 4) Menu
The menu will be a navigation drawer.

Usefull classes:

## 5) End game

Usefull classes:


# Style guide
Thee style guide used is the default style guide from android studio
https://source.android.com/source/code-style.html
