package org.academiadecodigo.cachealots.runner;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {

    private final int PADDING = 10;
    private final int CELL_SIZE = 10;

    private int rows;
    private int cols;
    private Position position;
    private Rectangle rectangle;

    public Grid(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

}//end of Grid class
