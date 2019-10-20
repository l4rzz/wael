package nl.codeforall.cannabits;

import nl.codeforall.cannabits.gamelogic.Cell;
import nl.codeforall.cannabits.gamelogic.Direction;
import nl.codeforall.cannabits.gamelogic.Grid;
import nl.codeforall.cannabits.gamelogic.object.*;
import nl.codeforall.cannabits.visuals.Screen;
import nl.codeforall.cannabits.visuals.SpriteFactory;
import nl.codeforall.cannabits.visuals.characterVisuals.Sprite;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Game implements KeyboardHandler {

    private Grid grid;
    private Player player;
    private Enemy enemy;
    private Sprite playerSprite;
    private Sprite enemySprite;
    private Screen screen;

    Direction desiredDirection = null;

    public Game() {
        // create a grid and screen
        grid = new Grid(16, 16);
        screen = new Screen(grid);
        screen.show();

        // TODO implement walls in game

        // creation of GameObjects
        player = (Player) ObjectFactory.createObject(GameObjectType.PLAYER, grid);
        playerSprite = SpriteFactory.makeSprite(player, screen);
        enemy = (Enemy) ObjectFactory.createObject(GameObjectType.ENEMY, grid);
        enemySprite = SpriteFactory.makeSprite(enemy, screen);


    }

    public void myKeyboard() {
        Keyboard keyboard = new Keyboard(this);


        KeyboardEvent keyUp = new KeyboardEvent();
        keyUp.setKey(KeyboardEvent.KEY_UP);
        keyUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyUp);

        KeyboardEvent keyDown = new KeyboardEvent();
        keyDown.setKey(KeyboardEvent.KEY_DOWN);
        keyDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyDown);

        KeyboardEvent keyLeft = new KeyboardEvent();
        keyLeft.setKey(KeyboardEvent.KEY_LEFT);
        keyLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyLeft);

        KeyboardEvent keyRight = new KeyboardEvent();
        keyRight.setKey(KeyboardEvent.KEY_RIGHT);
        keyRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyRight);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_UP:
                desiredDirection = Direction.UP;
                break;
            case KeyboardEvent.KEY_DOWN:
                desiredDirection = Direction.DOWN;
                break;
            case KeyboardEvent.KEY_LEFT:
                desiredDirection = Direction.LEFT;
                break;
            case KeyboardEvent.KEY_RIGHT:
                desiredDirection = Direction.RIGHT;
                break;
        }

    }

    public void start() throws InterruptedException {
        myKeyboard();
        // loop till player or enemy is dead
        while (!enemy.isDead() && !player.isDead()) {


            // Player turn

            // Listen to keyboard

            // TODO Screen.gameMessage("No can do. Use arrow keys to move your character.");
            // Screen.gameMessage("No can do. Use arrow keys to move your character.");
            // TODO Back to keyboard


            // Checking if keystroke translates into possible move
            if (!player.isDirectionPossible(desiredDirection)) {
                desiredDirection = null;
            }
            // Screen.gameMessage("You are not allowed to move in this direction.");
            //   continue; // should go back into while loop // TODO back to keyboard

            // If so
            player.move(desiredDirection);
            playerSprite.move(desiredDirection);
            desiredDirection = null;

            // check if move results in fight because two characters are in same position
            //TODO check this for each enemy, currently just one enemy
            if (player.getCell().equals(enemy.getCell())) {

                // FIFO battle (gamelogic)
                enemy.setDead();
                enemySprite.deadAnimation();

                // TODO: ONLY WITH MULTIPLE ENEMIES: check remaining number of enemies
                GameCharacter winner = player;

            }

            // Wait a few hundred milliseconds
            Thread.sleep(2000);

            // Enemy turn

            // moves
            enemy.moveTowardWithWalls(player.getCell());
            enemySprite.move(enemy.getDirection());

            // check if move results in fight because two characters are in same position
            if (enemy.getCell().equals(player.getCell())) {

                // FIFO battle
                // show battle animation // TODO: a few sprites that represent a battle e.g. flashing red
                player.setDead();
                playerSprite.deadAnimation();
                GameCharacter winner = enemy; // TODO: Show results in text

            }

        } // end of turns, loop ends if there is a winner
        // TODO Screen.gameMessage("Winner: " + winner);

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}


