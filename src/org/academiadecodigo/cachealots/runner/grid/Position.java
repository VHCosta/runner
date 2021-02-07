package org.academiadecodigo.cachealots.runner.grid;

public class Position {

    private int col;
    private int row;
    private int height;
    private int weight;


    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public boolean equals(Position pos) {
        return this.col == pos.getCol() && this.row == pos.getRow()
                && this.height == pos.getHeight() && this.weight == pos.getWeight();
    }

}//end of Position class
