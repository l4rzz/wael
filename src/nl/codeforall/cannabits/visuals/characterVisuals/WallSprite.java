package nl.codeforall.cannabits.visuals.characterVisuals;

import nl.codeforall.cannabits.gamelogic.Direction;
import nl.codeforall.cannabits.visuals.Screen;


//Skeleton for WallSprites, not implemented yet.

public class WallSprite extends Sprite {

    private static final int col = 1;
    private static final int row = 1;
    private static final Direction direction = Direction.DOWN ;

    protected WallSprite(Screen screen){
        super(col,row,screen, direction);
    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }
}
