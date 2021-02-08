package org.academiadecodigo.cachealots.runner.blocks;

import org.academiadecodigo.cachealots.runner.grid.Grid;
import org.academiadecodigo.cachealots.runner.grid.Position;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


/*public class Block{  // class with the characteristics of the running blocks

    private Rectangle obstacle;
    private Position pos;
    private Grid grid;
<<<<<<< HEAD
    private int col = grid.CELL_SIZE;
    private int row = grid.CELL_SIZE;
=======
>>>>>>> 5bc3a5ac77475a6621dcc1320e62f5f6542f84a4
    //private BlockType type;

    public Block(Position pos){

        this.grid = grid;
<<<<<<< HEAD
        int size = col + row;

        int obstacleCol = col - size + grid.getPadding();
        int obstacleRow = row + grid.getPadding();

        obstacle  = new Rectangle(obstacleCol, obstacleRow, size, size);
=======
        Rectangle obstacle  = new Rectangle(grid.getWidth() - 1, (grid.getHeight() - (2.5 * grid.getCellSize())) + grid.getY(), grid.getCellSize(), grid.getCellSize());
>>>>>>> 5bc3a5ac77475a6621dcc1320e62f5f6542f84a4


        //this.type = type;
    }


    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }



}//end of Block class*/
