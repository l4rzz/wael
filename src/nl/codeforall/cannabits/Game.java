package nl.codeforall.cannabits;

import nl.codeforall.cannabits.gamelogic.Cell;
import nl.codeforall.cannabits.gamelogic.Direction;
import nl.codeforall.cannabits.gamelogic.Grid;
import nl.codeforall.cannabits.gamelogic.object.*;
import nl.codeforall.cannabits.visuals.Screen;

public class Game {

    // variable where the latest user input can be read.
    public UserInput userinput;

    private Grid grid;
    private Player player;
    private Enemy enemy;
    private Screen screen;

    public Game(){
        // create a grid
        grid = new Grid(16,16);

        // TODO implement walls in game

        // creation of GameObjects
        player = (Player) ObjectFactory.createObject(GameObjectType.PLAYER);
        enemy = (Enemy) ObjectFactory.createObject(GameObjectType.ENEMY);

        // setting of their start positions
        player.setStartPosition(grid);
        enemy.setStartPosition(grid);

        // initialising screen
        screen = new Screen(grid);
        screen.show();


    }

    public void start(){
        // Local vars
        String keystroke = "";
        Direction desiredDirection = null;

        // loop till player or enemy is dead
        while (!enemy.isDead() && !player.isDead()){


            // Player turn

            // Listen to keyboard


            // Save keystroke into desired move
            keystroke = "&0123";
            // TODO keystroke input and mapping
            switch(keystroke) {
                case "&0024;":
                    desiredDirection = Direction.UP;
                    break;
                case "&0025;":
                    desiredDirection = Direction.DOWN;
                    break;
                case "&0026;":
                    desiredDirection = Direction.RIGHT;
                    break;
                case "&0027;":
                    desiredDirection = Direction.LEFT;
                    break;
                default:
                    // TODO Screen.gameMessage("No can do. Use arrow keys to move your character.");
                    // Screen.gameMessage("No can do. Use arrow keys to move your character.");
                    // TODO Back to keyboard

            }

            // Checking if keystroke translates into possible move
            //if (!player.isDirectionPossible(desiredDirection,)) {
                // Screen.gameMessage("You are not allowed to move in this direction.");
             //   continue; // should go back into while loop // TODO back to keyboard

            }
            // If so
            player.move(desiredDirection);
            // TODO Show move on screen
            // Screen.showNewPosition(player);

            // check if move results in fight because two characters are in same position
            // check this for each enemy, currently just one enemy
            if(player.getCell().equals(enemy.getCell())) {

                // FIFO battle (gamelogic)
                // enemy.setDead();

                // TODO: ONLY WITH MULTIPLE ENEMIES: check remaining number of enemies
                GameCharacter winner = player;

                // show battle animation // TODO: a few sprites that represent a battle e.g. flashing red

            }

            // Wait a few hundred milliseconds
            // TODO find the waiting method.

            // Enemy turn

            // moves in game logic
            //enemy.moveToWard(player.getCell());
            // TODO Show move on screen
            // Screen.showNewPosition(player);

            // check if move results in fight because two characters are in same position
            if(enemy.getCell().equals(player.getCell())) {

                // FIFO battle
                // show battle animation // TODO: a few sprites that represent a battle e.g. flashing red
                // player.setDeath();
                GameCharacter winner = enemy;

            }


            //else {

            //screen.showNewPosition(enemy);

        } // end of turns, loop ends if there is a winner
        // TODO Screen.gameMessage("Winner: " + winner);



}

