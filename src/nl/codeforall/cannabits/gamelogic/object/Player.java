package nl.codeforall.cannabits.gamelogic.object;

import nl.codeforall.cannabits.gamelogic.Direction;
import nl.codeforall.cannabits.gamelogic.Grid;

public class Player extends GameCharacter {

    public Player(GameObjectType gameObjectType, Grid grid) {
        super(gameObjectType, grid);
    }

    @Override
    public void move(Direction direction) {
        super.move(direction);
    }
}
