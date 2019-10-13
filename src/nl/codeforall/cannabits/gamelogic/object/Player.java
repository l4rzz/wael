package nl.codeforall.cannabits.gamelogic.object;

import nl.codeforall.cannabits.gamelogic.Direction;
import nl.codeforall.cannabits.gamelogic.object.Character;

public class Player extends Character {



    public void attack(){
        //attack enemy when close
    }

    @Override
    public void move(Direction direction) {

    }
    @Override
    public boolean isDirectionPossible(Direction direction){
        return false;
   }
}
