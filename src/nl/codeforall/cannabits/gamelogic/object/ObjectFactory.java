package nl.codeforall.cannabits.gamelogic.object;

public class ObjectFactory {

    //Creates instance of Player, Enemy, (Walls)

    //switch(objectType)

    public static GameObject createObject(GameObjectType gameObjectType){

        switch (gameObjectType){
            case PLAYER:
                return new Player();
            case ENEMY:
                return new Enemy();
            case WALL:
                return new Wall();

        }
        return null;
    }


}
