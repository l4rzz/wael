package nl.codeforall.cannabits.gamelogic.object;

import nl.codeforall.cannabits.gamelogic.Cell;
import nl.codeforall.cannabits.gamelogic.Grid;

public abstract class GameObject {
    private Cell position;
    private Grid grid;
    private GameObjectType gameObjectType;

    public GameObject(GameObjectType gameObjectType, Grid grid){
        this.gameObjectType = gameObjectType;
        this.grid = grid;
        setStartPosition(grid);
    }

    private void setStartPosition(Grid grid){
        int maxCols = grid.getCols();
        int maxRows = grid.getRows();
        int setCol = (int)Math.floor(Math.random()*maxCols);
        int setRow = (int)Math.floor(Math.random()*maxRows);

        this.position = new Cell(setCol, setRow);
        if(!position.isPassable()){
            setStartPosition(grid);
        }

    }

    public void setPosition(Cell position){
        this.position = position;
    }

    public Cell getCell(){
        return position;
    }

    public Grid getGrid(){
        return grid;
    }

    public GameObjectType getGameObjectType(){
        return gameObjectType;
    }
}
