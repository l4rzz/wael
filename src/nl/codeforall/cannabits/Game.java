package nl.codeforall.cannabits;

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

        // TODO Unlocken connection to gameobject
        player = (Player) ObjectFactory.createObject(GameObjectType.PLAYER);
        enemy = (Enemy) ObjectFactory.createObject(GameObjectType.ENEMY);

        // TODO Unlocken setting of start positions
        player.setStartPosition(grid);
        enemy.setStartPosition(grid);

        // TODO Unlocken initialising screen
        screen = new Screen(grid);

    }

    public void start(){

        // loop till player or enemy is dead
        while (!enemy.isDead() && !player.isDead()){

            // Player turn

                // Listen to keyboard

                // Show move on screen
                // TODO Show move on screen


            // Wait a few hundred milliseconds

            // Enemy turn

        // show for the cell where the character won only the winning character

        }

    } // end of while

}
