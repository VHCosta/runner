package org.academiadecodigo.cachealots.runner;

public class Position {

    private int col;
    private int row;


    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }


    public boolean equals(Position pos) {
        return this.col == pos.getCol() && this.row == pos.getRow();
    }

}//end of Position class
