package nl.codeforall.cannabits.visuals;

import nl.codeforall.cannabits.Game;
import nl.codeforall.cannabits.gamelogic.Cell;
import nl.codeforall.cannabits.gamelogic.Direction;
import nl.codeforall.cannabits.gamelogic.object.GameCharacter;
import nl.codeforall.cannabits.gamelogic.object.GameObject;
import nl.codeforall.cannabits.gamelogic.object.GameObjectType;
import nl.codeforall.cannabits.gamelogic.object.Player;
import nl.codeforall.cannabits.visuals.characterVisuals.EnemySprite;
import nl.codeforall.cannabits.visuals.characterVisuals.PlayerSprite;
import nl.codeforall.cannabits.visuals.characterVisuals.Sprite;
import nl.codeforall.cannabits.visuals.characterVisuals.WallSprite;
import nl.codeforall.cannabits.gamelogic.object.Wall;

public class SpriteFactory {

    //TODO Game needs to give sprite a screen as argument.

    public static Sprite makeSprite(GameObject object, Screen screen){

        GameObjectType objectType = object.getGameObjectType();
        if (object instanceof GameCharacter) {
            object =(GameCharacter) object;
        } else {
            object = (Wall) object;
        }
        switch (objectType) {
            case ENEMY:
                return new EnemySprite(object.getCell().getCol(), object.getCell().getRow(), screen, Direction.generateRandom());
            case PLAYER:
                return new PlayerSprite(object.getCell().getCol(), object.getCell().getRow(), screen, Direction.generateRandom());
        }
        return new WallSprite(object.getCell().getCol(),object.getCell().getRow(),screen);






    }



}
