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

[Mock up](https://github.com/JulianRR/nPuzzle/blob/master/doc/nPuzle_MockUp.jpg)
![alt tag](https://github.com/JulianRR/nPuzzle/blob/master/doc/nPuzle_MockUp.jpg)

## Design Document

[Design Document](https://github.com/JulianRR/nPuzzle/blob/master/doc/DesignDoc.md)

## Style Guide

[Style Guide](https://github.com/JulianRR/nPuzzle/blob/master/doc/StyleGuide.md)

## Beta-Release
The game can be played, but some settings can't be set yet by the user.

finished:
* Play button is functional
* Choosing difficulty
* Playing the game and solving it
* Restart and quit buttons in the menu are functional
* New activity when puzzle is solved.
* Number of moves
* Play again button

Not finished:
* Help button
* Choosing image
* App design, colors, button sizes etc.
* Code clean up and comments
