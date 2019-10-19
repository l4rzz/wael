package nl.codeforall.cannabits.visuals;
import nl.codeforall.cannabits.gamelogic.Direction;
import nl.codeforall.cannabits.gamelogic.Grid;
import nl.codeforall.cannabits.visuals.characterVisuals.EnemySprite;
import nl.codeforall.cannabits.visuals.characterVisuals.PlayerSprite;
import nl.codeforall.cannabits.visuals.characterVisuals.Sprite;
import nl.codeforall.cannabits.visuals.characterVisuals.WallSprite;

public class ScreenTest {
    public static void main(String[] args) throws InterruptedException {

        Grid grid = new Grid(16,16);

        Screen screen = new Screen(grid);
        screen.show();
        Sprite enemy = new EnemySprite(5,5,screen,Direction.DOWN);
        Sprite player = new PlayerSprite(3,5,screen,Direction.RIGHT);
        Sprite wallsprite = new WallSprite(4, 4, screen);
        Sprite wallsprite2 = new WallSprite(3,4,screen);

        while (true) {
            enemy.move(FieldDirection.LEFT);
            enemy.move(FieldDirection.LEFT);
            enemy.move(FieldDirection.LEFT);
            enemy.move(FieldDirection.DOWN);
            enemy.move(FieldDirection.DOWN);
            enemy.move(FieldDirection.DOWN);
            enemy.move(FieldDirection.RIGHT);
            enemy.move(FieldDirection.RIGHT);
            enemy.move(FieldDirection.RIGHT);
            enemy.move(FieldDirection.UP);
            enemy.move(FieldDirection.UP);
            enemy.move(FieldDirection.UP);
            enemy.deadAnimation();
            player.deadAnimation();
        }



    }
}
