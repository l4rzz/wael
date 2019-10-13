package nl.codeforall.cannabits.gamelogic.object;

import nl.codeforall.cannabits.gamelogic.Direction;
import nl.codeforall.cannabits.gamelogic.Moveable;

public abstract class Character extends GameObject implements Moveable {

    private Direction direction;
    private boolean dead;

    @Override
    public boolean isDirectionPossible(Direction direction) {
        return false;
    }

    protected void changeDirection(Direction direction){
        this.direction = direction;
    }

}
