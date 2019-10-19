package nl.codeforall.cannabits.visuals.characterVisuals;

import nl.codeforall.cannabits.gamelogic.Direction;
import nl.codeforall.cannabits.visuals.Screen;
import org.academiadecodigo.simplegraphics.pictures.Picture;


//Skeleton for WallSprites, not implemented yet.

public class WallSprite extends Sprite {

    private static final Direction direction = Direction.DOWN ;
    private static final String spriteSource = "wall.png";
    private Picture wallSprite;

    public WallSprite(int col, int row, Screen screen){
        super(col,row,screen, direction);
        this.wallSprite = new Picture(getXcoordinate(), getYcoordinate(), spriteSource);
        show();
    }

    @Override
    public void show() {
        wallSprite.draw();
    }

    @Override
    public void hide() {
        wallSprite.delete();
    }

    @Override
    public void deadAnimation() throws InterruptedException {

    }
}
