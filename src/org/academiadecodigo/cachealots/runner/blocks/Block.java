package org.academiadecodigo.cachealots.runner.blocks;

import org.academiadecodigo.cachealots.runner.grid.Grid;
import org.academiadecodigo.cachealots.runner.grid.Position;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class Block extends Rectangle{  // class with the characteristics of the running blocks

    private Rectangle obstacle;
    private Position pos;
    private Grid grid;
    private int col = grid.CELL_SIZE;
    private int row = grid.CELL_SIZE;
    //private BlockType type;

    public Block(Position pos){

        this.grid = grid;
        int size = col + row;

        int obstacleCol = col - size + grid.getPadding();
        int obstacleRow = row + grid.getPadding();

        obstacle  = new Rectangle(obstacleCol, obstacleRow, size, size);


        //this.type = type;
    }


    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }



}//end of Block class
