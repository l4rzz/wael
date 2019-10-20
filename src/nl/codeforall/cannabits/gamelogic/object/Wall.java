package nl.codeforall.cannabits.gamelogic.object;

import nl.codeforall.cannabits.gamelogic.Grid;

public class Wall extends GameObject{

    public Wall(GameObjectType gameObjectType, Grid grid){
        super(gameObjectType, grid);
    }

    public void setFinalPosition(int col, int row){
        getCell().setCol(col);
        getCell().setRow(row);
        getGrid().notPassable(col, row);
    }
}
