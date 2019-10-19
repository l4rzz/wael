package nl.codeforall.cannabits.visuals.characterVisuals;

import nl.codeforall.cannabits.gamelogic.Direction;
import nl.codeforall.cannabits.visuals.FieldDirection;
import nl.codeforall.cannabits.visuals.Screen;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class EnemySprite extends Sprite {
    private final static String pictureSource = "enemysprites/Zombie/leftstand.png";
    private final static int delay = 400;
    private Picture sprite;

    public EnemySprite(int col, int row, Screen screen, Direction direction){
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
        sprite.load("enemysprites/Zombie/leftwalk1.png");
        setFieldDirection(FieldDirection.LEFT);
        Thread.sleep(delay);
        sprite.translate(-(travelDistance/2),0);
        sprite.load("enemysprites/Zombie/leftwalk3.png");
        Thread.sleep(delay);
        sprite.translate(-(travelDistance/2),0);
        sprite.load("enemysprites/Zombie/leftwalk2.png");
    }

    public void moveRightAnimation(int travelDistance) throws InterruptedException {
        sprite.load("enemysprites/Zombie/rightwalk1.png");
        setFieldDirection(FieldDirection.RIGHT);
        Thread.sleep(delay);
        sprite.translate(travelDistance/2,0);
        sprite.load("enemysprites/Zombie/rightwalk3.png");
        Thread.sleep(delay);
        sprite.translate(travelDistance/2,0);
        sprite.load("enemysprites/Zombie/rightwalk2.png");
    }

    public void moveUpAnimation(int travelDistance) throws InterruptedException {
        sprite.load("enemysprites/Zombie/upwalk1.png");
        setFieldDirection(FieldDirection.UP);
        Thread.sleep(delay);
        sprite.translate(0,-(travelDistance/2));
        sprite.load("enemysprites/Zombie/upwalk3.png");
        Thread.sleep(delay);
        sprite.translate(0,-(travelDistance/2));
        sprite.load("enemysprites/Zombie/upwalk2.png");
    }

    public void moveDownAnimation(int travelDistance) throws InterruptedException {
        sprite.load("enemysprites/Zombie/downwalk1.png");
        setFieldDirection(FieldDirection.LEFT);
        Thread.sleep(delay);
        sprite.translate(0,travelDistance/2);
        sprite.load("enemysprites/Zombie/downwalk3.png");
        Thread.sleep(delay);
        sprite.translate(0,travelDistance/2);
        sprite.load("enemysprites/Zombie/downwalk2.png");
    }



    public int getHeight(){
       return sprite.getHeight();
    }


}

