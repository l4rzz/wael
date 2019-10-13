package nl.codeforall.cannabits.visuals;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import nl.codeforall.cannabits.gamelogic.Direction;

public class Sprite {
    //position in pixels that can move:
    // representation logic

    //property 1 Player1 sprite
    //property 2 Enemy sprite
    private Screen screen;
    private Rectangle spritePosition;
    private FieldDirection fieldDirection;

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
        int x = screen.columnToX(col);
        int y = screen.rowToY(row);
        this.spritePosition = new Rectangle(screen.getPadding(), screen.getPadding(), x, y);

        show();
    }




    public void show(){
        this.spritePosition.fill();
    }
    public void hide(){
        this.spritePosition.delete();
    }

    public void move(FieldDirection direction) {
        int travelDistance = screen.getCellsize();
        switch(direction){

            case UP:
                hide();
                fieldDirection = FieldDirection.UP;
                spritePosition.translate(0,-travelDistance);
                show();
                break;
            case DOWN:
                hide();
                fieldDirection = FieldDirection.DOWN;
                spritePosition.translate(0,travelDistance);
                show();
                break;
            case LEFT:
                hide();
                fieldDirection = FieldDirection.LEFT;
                spritePosition.translate(-travelDistance, 0);
                show();
                break;
            case RIGHT:
                hide();
                fieldDirection = FieldDirection.RIGHT;
                spritePosition.translate(travelDistance, 0);
                show();
                break;
        }


    }

}
