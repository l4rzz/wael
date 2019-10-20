package nl.codeforall.cannabits.gamelogic.object;

import nl.codeforall.cannabits.gamelogic.Grid;

public class ObjectFactory {

    public static GameObject createObject(GameObjectType gameObjectType, Grid grid){

        switch (gameObjectType){
            case PLAYER:
                return new Player(gameObjectType, grid);
            case ENEMY:
                return new Enemy(gameObjectType, grid);
            case WALL:
                return new Wall(gameObjectType, grid);

        }
        return null;
    }


}
