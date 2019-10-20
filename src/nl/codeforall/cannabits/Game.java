package nl.codeforall.cannabits;

import nl.codeforall.cannabits.gamelogic.Direction;
import nl.codeforall.cannabits.gamelogic.Grid;
import nl.codeforall.cannabits.gamelogic.object.*;
import nl.codeforall.cannabits.visuals.Screen;
import nl.codeforall.cannabits.visuals.SpriteFactory;
import nl.codeforall.cannabits.visuals.characterVisuals.Sprite;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
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
    private Keyboard keyboard = new Keyboard(this);
    private boolean upKey;
    private boolean downKey;
    private boolean leftKey;
    private boolean rightKey;

    private Direction desiredDirection = null;

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

    public void addKeyboardEvent(int key, KeyboardEventType type) {
        KeyboardEvent event = new KeyboardEvent();
        event.setKey(key);
        event.setKeyboardEventType(type);
        keyboard.addEventListener(event);
    }

    public void keyboardKeys() {
        addKeyboardEvent(KeyboardEvent.KEY_UP, KeyboardEventType.KEY_PRESSED);
        addKeyboardEvent(KeyboardEvent.KEY_DOWN, KeyboardEventType.KEY_PRESSED);
        addKeyboardEvent(KeyboardEvent.KEY_LEFT, KeyboardEventType.KEY_PRESSED);
        addKeyboardEvent(KeyboardEvent.KEY_RIGHT, KeyboardEventType.KEY_PRESSED);
        addKeyboardEvent(KeyboardEvent.KEY_UP, KeyboardEventType.KEY_RELEASED);
        addKeyboardEvent(KeyboardEvent.KEY_DOWN, KeyboardEventType.KEY_RELEASED);
        addKeyboardEvent(KeyboardEvent.KEY_RIGHT, KeyboardEventType.KEY_RELEASED);
        addKeyboardEvent(KeyboardEvent.KEY_LEFT, KeyboardEventType.KEY_RELEASED);

    }


    public void start() throws InterruptedException {
        keyboardKeys();

        while (!player.isDead() && !enemy.isDead()) {

            playerTurn();

            Thread.sleep(60);

            if (characterDeadCheck()) {
                String winner = "Player";
                showResult(winner);
                return;
            }

            Thread.sleep(60);

            enemyTurn();

            if (characterDeadCheck()) {
                String winner = "Enemy";
                showResult(winner);
                return;
            }
        }

    }

    public boolean keyPressCheck() {
        if (upKey || downKey || leftKey || rightKey) {
            return true;
        }

        return false;
    }


    private boolean playerTurn() throws InterruptedException {
        //Prevents the game from running, if no key is pressed.
        while (!keyPressCheck()) {
            Thread.sleep(10);
        }

        if (keyPressCheck()) {

            if (!player.isDirectionPossible(desiredDirection)) {
                return false;
            }

            // If possible move;
            player.move(desiredDirection);
        }
        while (keyPressCheck()) {
            Thread.sleep(10);
        }
        playerSprite.move(desiredDirection);
        // check if move results in fight because two characters are in same position
        //TODO check this for each enemy, currently just one enemy
        if (player.getCell().compareCells(enemy.getCell())) {

            // FIFO battle (gamelogic)
            enemy.setDead();
            int explosionDelay = 50;

            for (int i = 1; i < 7; i++) {
                enemySprite.getPicture().load("explosion/explosion" + i + ".png");
                Thread.sleep(explosionDelay);
            }

            enemySprite.getPicture().delete();
        }
        return true;

    }

    public void enemyTurn() throws InterruptedException {

        enemy.moveTowards(player.getCell());
        Thread.sleep(50);
        enemySprite.move(enemy.getDirection());

        // check if move results in fight because two characters are in same position
        if (enemy.getCell().compareCells(player.getCell())) {

            player.setDead();
            int explosionDelay = 50;

            for (int i = 1; i < 7; i++) {
                playerSprite.getPicture().load("explosion/explosion" + i + ".png");
                Thread.sleep(explosionDelay);
            }

            playerSprite.getPicture().delete();

        }
    }

    public boolean characterDeadCheck() {
        if (player.isDead() || enemy.isDead()) {
            return true;
        }
        return false;
    }

    public void showResult(String winner) {
        Text winResult = new Text(230, 250, "Game Over - " + winner + " wins!");
        winResult.setColor(Color.RED);
        winResult.grow(140, 55);
        winResult.draw();
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_UP:
                upKey = true;
                desiredDirection = Direction.UP;
                break;
            case KeyboardEvent.KEY_DOWN:
                downKey = true;
                desiredDirection = Direction.DOWN;
                break;
            case KeyboardEvent.KEY_LEFT:
                leftKey = true;
                desiredDirection = Direction.LEFT;
                break;
            case KeyboardEvent.KEY_RIGHT:
                rightKey = true;
                desiredDirection = Direction.RIGHT;
                break;
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_UP:
                upKey = false;
                break;
            case KeyboardEvent.KEY_DOWN:
                downKey = false;
                break;
            case KeyboardEvent.KEY_LEFT:
                leftKey = false;
                break;
            case KeyboardEvent.KEY_RIGHT:
                rightKey = false;
                break;
        }
    }
}


