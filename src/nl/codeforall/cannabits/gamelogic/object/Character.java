package nl.codeforall.cannabits.gamelogic.object;

import nl.codeforall.cannabits.gamelogic.Direction;
import nl.codeforall.cannabits.gamelogic.Moveable;

public abstract class Character extends Object implements Moveable {

    private Direction direction;
    private boolean dead;

    protected void changeDirection(Direction direction){
        this.direction = direction;
    }

}
