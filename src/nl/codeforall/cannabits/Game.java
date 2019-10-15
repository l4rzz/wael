package nl.codeforall.cannabits;

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
        grid = new Grid(8,8);

        // creation of GameObjects
        player = (Player) ObjectFactory.createObject(GameObjectType.PLAYER);
        enemy = (Enemy) ObjectFactory.createObject(GameObjectType.ENEMY);

        // setting of their start positions
        player.setStartPosition(grid);
        enemy.setStartPosition(grid);

        // initialising screen
        screen = new Screen(grid);

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
                    case default:
                        // TODO Screen.gameMessage("No can do. Use arrow keys to move your character.");
                        //Screen.gameMessage("No can do. Use arrow keys to move your character.");
                        // Back to keyboard

                }

                // Checking if keystroke translates into possible move
                if (!player.isDirectionPossible(desiredDirection)) {
                    //Screen.gameMessage("You are not allowed to move in this direction.");
                    continue; // should go back into while loop // TODO double check with peers.

                }
                // If so
                player.move(desiredDirection);
                // TODO Show move on screen
                Screen.showNewPosition(player);

                    // check if move results in fight because two characters are in same position
                        // FIFO battle
                        // show battle animation

                // Wait a few hundred milliseconds
                // TODO find the waiting method.

            // Enemy turn

        // show for the cell where the character won only the winning character

        }

    } // end of while

}
