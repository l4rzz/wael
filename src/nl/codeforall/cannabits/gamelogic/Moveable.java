package nl.codeforall.cannabits.gamelogic;
import nl.codeforall.cannabits.gamelogic.object.Wall;

public interface Moveable {
    //boolean isDirectionPossible(Direction direction, Wall[] walls);
    void move(Direction direction);
}
