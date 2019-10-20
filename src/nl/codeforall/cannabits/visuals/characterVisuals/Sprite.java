package nl.codeforall.cannabits.visuals.characterVisuals;

import nl.codeforall.cannabits.gamelogic.object.GameCharacter;
import nl.codeforall.cannabits.visuals.FieldDirection;
import nl.codeforall.cannabits.visuals.Screen;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import nl.codeforall.cannabits.gamelogic.Direction;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Sprite<T> {
    //position in pixels that can move:
    // representation logic

    private Screen screen;
    private FieldDirection fieldDirection;
    private int xcoordinate;
    private int ycoordinate;
    private Picture picture;

    public Sprite(int col, int row, Screen screen, Direction direction) {

        switch(direction) {
            case RIGHT:
                this.fieldDirection = FieldDirection.RIGHT;
                break;
            case LEFT:
                this.fieldDirection = FieldDirection.LEFT;
                break;
            case DOWN:
                this.fieldDirection = FieldDirection.DOWN;
                break;
            case UP:
                this.fieldDirection = FieldDirection.UP;
                break;
        }

        this.screen = screen;
        this.xcoordinate = screen.columnToX(col);
        this.ycoordinate = screen.rowToY(row);

    }

    public abstract void show();

    public abstract void hide();

    public abstract void deadAnimation() throws InterruptedException;

    public void move(Direction direction) throws InterruptedException {
        //TODO move
        int travelDistance = screen.getCellsize();
        switch(direction){

            case UP:
                fieldDirection = FieldDirection.UP;
                this.ycoordinate -= travelDistance;
                break;
            case DOWN:
                fieldDirection = FieldDirection.DOWN;
                this.ycoordinate += travelDistance;
                break;
            case LEFT:
                fieldDirection = FieldDirection.LEFT;
                this.xcoordinate -= travelDistance;
                break;
            case RIGHT:
                fieldDirection = FieldDirection.RIGHT;
                this.xcoordinate += travelDistance;
                break;
        }


    }
    protected Screen getScreen(){
        return this.screen;
    }
    public int getXcoordinate(){
        return xcoordinate;
    }
    protected int getYcoordinate(){
        return ycoordinate;
    }
    protected void setFieldDirection(FieldDirection direction){
        this.fieldDirection = direction;
    }

    public Picture getPicture(){
        return this.picture;
    }

}
