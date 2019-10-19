package nl.codeforall.cannabits.visuals;
import nl.codeforall.cannabits.gamelogic.Direction;
import nl.codeforall.cannabits.gamelogic.Grid;
import nl.codeforall.cannabits.visuals.characterVisuals.EnemySprite;
import nl.codeforall.cannabits.visuals.characterVisuals.PlayerSprite;
import nl.codeforall.cannabits.visuals.characterVisuals.Sprite;

public class ScreenTest {
    public static void main(String[] args) {

        Grid grid = new Grid(8,8);

        Screen screen = new Screen(grid);
        screen.show();
        Sprite enemy = new EnemySprite(0,0,screen,Direction.DOWN);
        System.out.println(enemy.getXcoordinate());
        Sprite player = new PlayerSprite(8,8,screen,Direction.RIGHT);


        //enemy.move(FieldDirection.RIGHT);
        //enemy.move(FieldDirection.DOWN);
        //enemy.move(FieldDirection.DOWN);
        //enemy.move(FieldDirection.DOWN);


    }
}
