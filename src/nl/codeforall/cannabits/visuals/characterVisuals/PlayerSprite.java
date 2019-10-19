package nl.codeforall.cannabits.visuals.characterVisuals;

import nl.codeforall.cannabits.gamelogic.Direction;
import nl.codeforall.cannabits.visuals.FieldDirection;
import nl.codeforall.cannabits.visuals.Screen;
import org.academiadecodigo.simplegraphics.pictures.Picture;


//TODO make sprites porportionally for cellsize, extend sprite movements

public class PlayerSprite extends Sprite{
    private final static String pictureSource = "playersprites/Player/leftstand.png";
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
    public void move(FieldDirection direction) throws InterruptedException {
        int travelDistance = getScreen().getCellsize();
        switch(direction){

            case UP:
                moveUpAnimation(travelDistance);
                break;
            case DOWN:
                moveDownAnimation(travelDistance);
                break;
            case LEFT:
                moveLeftAnimation(travelDistance);
                break;
            case RIGHT:
                moveRightAnimation(travelDistance);
                break;
        }
    }

    public void moveLeftAnimation(int travelDistance) throws InterruptedException {
        sprite.load("playersprites/Player/leftwalk1.png");
        setFieldDirection(FieldDirection.LEFT);
        Thread.sleep(500);
        sprite.translate(-(travelDistance/2),0);
        sprite.load("playersprites/Player/leftwalk3.png");
        Thread.sleep(500);
        sprite.translate(-(travelDistance/2),0);
        sprite.load("playersprites/Player/leftwalk2.png");
    }

    public void moveRightAnimation(int travelDistance) throws InterruptedException {
        sprite.load("playersprites/Player/rightwalk1.png");
        setFieldDirection(FieldDirection.RIGHT);
        Thread.sleep(500);
        sprite.translate(travelDistance/2,0);
        sprite.load("playersprites/Player/rightwalk3.png");
        Thread.sleep(500);
        sprite.translate(travelDistance/2,0);
        sprite.load("playersprites/Player/rightwalk2.png");
    }

    public void moveUpAnimation(int travelDistance) throws InterruptedException {
        sprite.load("playersprites/Player/upwalk1.png");
        setFieldDirection(FieldDirection.UP);
        Thread.sleep(500);
        sprite.translate(0,-(travelDistance/2));
        sprite.load("playersprites/Player/upwalk3.png");
        Thread.sleep(500);
        sprite.translate(0,-(travelDistance/2));
        sprite.load("playersprites/Player/upwalk2.png");
    }

    public void moveDownAnimation(int travelDistance) throws InterruptedException {
        sprite.load("playersprites/Player/downwalk1.png");
        setFieldDirection(FieldDirection.LEFT);
        Thread.sleep(500);
        sprite.translate(0,travelDistance/2);
        sprite.load("playersprites/Player/downwalk3.png");
        Thread.sleep(500);
        sprite.translate(0,travelDistance/2);
        sprite.load("playersprites/Player/downwalk2.png");
    }

    public int getHeight(){
        return sprite.getHeight();
    }


}

