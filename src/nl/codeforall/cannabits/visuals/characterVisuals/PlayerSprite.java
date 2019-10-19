package nl.codeforall.cannabits.visuals.characterVisuals;

import nl.codeforall.cannabits.gamelogic.Direction;
import nl.codeforall.cannabits.visuals.FieldDirection;
import nl.codeforall.cannabits.visuals.Screen;
import org.academiadecodigo.simplegraphics.pictures.Picture;


//TODO make sprites porportionally for cellsize, extend sprite movements

public class PlayerSprite extends Sprite{
    private final static String pictureSource = "playersprites/Player/tile011.png";
    private Picture sprite;

    public PlayerSprite(int col, int row, Screen screen, Direction direction){
        super(col,row,screen,direction);
        this.sprite = new Picture(getXcoordinate(),getYcoordinate(),pictureSource);
        show();
    }

    @Override
    public void show() {
        sprite.draw();
    }

    @Override
    public void hide() {
        sprite.delete();
    }

    @Override
    public void move(FieldDirection direction) {
        int travelDistance = getScreen().getCellsize();
        switch(direction){

            case UP:
                setFieldDirection(FieldDirection.UP);
                sprite.translate(0, -travelDistance);
                break;
            case DOWN:
                setFieldDirection(FieldDirection.DOWN);
                sprite.translate(0, travelDistance);
                break;
            case LEFT:
                setFieldDirection(FieldDirection.LEFT);
                sprite.translate(-travelDistance,0);
                break;
            case RIGHT:
                setFieldDirection(FieldDirection.RIGHT);
                sprite.translate(travelDistance, 0);
                break;
        }
    }

    public int getHeight(){
        return sprite.getHeight();
    }


}

