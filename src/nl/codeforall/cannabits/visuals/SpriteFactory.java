package nl.codeforall.cannabits.visuals;

import nl.codeforall.cannabits.gamelogic.Cell;
import nl.codeforall.cannabits.gamelogic.object.GameObject;
import nl.codeforall.cannabits.gamelogic.object.GameObjectType;
import nl.codeforall.cannabits.gamelogic.object.Player;
import nl.codeforall.cannabits.visuals.characterVisuals.EnemySprite;
import nl.codeforall.cannabits.visuals.characterVisuals.PlayerSprite;
import nl.codeforall.cannabits.visuals.characterVisuals.WallSprite;

public class SpriteFactory {

    //TODO object needs a property for type + getter
    //TODO Game needs to give sprite a screen as argument.

   /* public static void makeSprite(GameObject object, Screen screen){

        GameObjectType objectType = object.getType();

        switch (objectType) {
            case ENEMY:
                return new EnemySprite(object.getCell().getCols(),object.getCell().getRows(),screen,object.getDirection());
                break;
            case PLAYER:
                return new PlayerSprite(object.getCell().getCols(), object.getCell().getRows(),screen,object.getDirection());
                break;
            return new WallSprite(0,0,screen,object.getDirection);

        }




    }


*/
}
