package org.academiadecodigo.cachealots.runner.blocks;

import org.academiadecodigo.cachealots.runner.grid.Grid;
import org.academiadecodigo.cachealots.runner.grid.Position;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class Block {  // class with the characteristics of the running blocks

    private Rectangle obstacle;
    private Position pos;
    private Grid grid;


    //private BlockType type;

    public Block(Grid grid) {
        this.grid = grid;
        //int size = pos.getCol() * pos.getRow();

        //int obstacleCol = col - size + grid.getPadding();
        //int obstacleRow = row + grid.getPadding();

        obstacle = new Rectangle(grid.getWidth() - 20, (grid.getHeight() - (2.5 * grid.getCellSize())) + grid.getY(), grid.getCellSize(), grid.getCellSize());

        //Rectangle obstacle  = new Rectangle(grid.getWidth() - 1, (grid.getHeight() - (2.5 * grid.getCellSize())) + grid.getY(), grid.getCellSize(), grid.getCellSize());


        //this.type = type;
    }

    public Rectangle getObstacle() {
        return obstacle;
    }

    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }

    public void move() {
        for (int i = grid.getWidth(); i > 0 - grid.getCellSize(); i++) {
            obstacle.translate(-grid.CELL_SIZE / 4, 0);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }



}//end of Block class
