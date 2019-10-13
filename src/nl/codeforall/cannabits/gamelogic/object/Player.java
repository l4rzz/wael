package nl.codeforall.cannabits.gamelogic.object;

import nl.codeforall.cannabits.gamelogic.object.Character;

public class Player extends Character {



    public void attack(){
        //attack enemy when close
    }

    @Override
    public void move() {

    }

    public static class Field {
        private int cols;
        private int rows;

        public Field(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        }

        public int getCols() {
            return cols;
        }

        public int getRows() {
            return rows;
        }





    }
}
