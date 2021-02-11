package org.academiadecodigo.cachealots.runner.blocks;
import org.academiadecodigo.cachealots.runner.grid.Grid;
import org.academiadecodigo.cachealots.runner.grid.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
public class Block {  // class with the characteristics of the running blocks
    private Rectangle obstacle;
    private Position pos;
    private Grid grid;
    //private BlockType type;
    public Block(Grid grid) {
        this.grid = grid;
        obstacle = new Rectangle(grid.getWidth() - 20, (grid.getHeight() - (2.5 * grid.getCellSize())) + grid.getY(), grid.getCellSize(), grid.getCellSize());
        obstacle.setColor(Color.RED);
        obstacle.fill();
        //Rectangle obstacle  = new Rectangle(grid.getWidth() - 1, (grid.getHeight() - (2.5 * grid.getCellSize())) + grid.getY(), grid.getCellSize(), grid.getCellSize());
    }
    public Rectangle getObstacle() {
        return obstacle;
    }
    public void show(){
        obstacle.fill();
    }
    public void move() {
        obstacle.translate(-grid.CELL_SIZE / 8, 0);
    }
    public int getX(){
        return obstacle.getX();
    }
    public int getY(){
        return obstacle.getY();
    }
    public int getHeight(){
        return obstacle.getHeight();
    }
    public int getWidth(){
        return obstacle.getWidth();
    }
}
//end of Block class