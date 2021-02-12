package org.academiadecodigo.cachealots.runner.blocks;

import org.academiadecodigo.cachealots.runner.character.Character;
import org.academiadecodigo.cachealots.runner.grid.Direction;
import org.academiadecodigo.cachealots.runner.grid.Grid;
import org.academiadecodigo.cachealots.runner.grid.Movement;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class Block {  // class with the characteristics of the running blocks

    private Rectangle obstacle;
    private Grid grid;
    public boolean onScreen;
    private Movement movement;


    public Block(Grid grid) {
        this.grid = grid;
        movement = new Movement(grid, this);
        obstacle = new Rectangle(grid.getWidth() - 20, (grid.getHeight() - (2.5 * grid.getCellSize())) + grid.getY(), grid.getCellSize(), grid.getCellSize());

        //set random color

        Color[] colors = {
                Color.BLACK,
                Color.DARK_GRAY,
                Color.RED,
                Color.PINK,
                Color.ORANGE
        };
        int randomColor = (int) (Math.random() * colors.length);
        obstacle.setColor(colors[randomColor]);

        show();

    }

    public Rectangle getObstacle() {
        return obstacle;
    }

    public void show(){
        obstacle.fill();
        onScreen = true;

    }

    public void move() {
        movement.moveBlock(Direction.LEFT);
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

    public void setOnScreen(boolean onScreen) {
        this.onScreen = onScreen;
    }

    public boolean isOnScreen(){
        if (obstacle.getX()+obstacle.getWidth() < 0 ) {
            return false;
        }
        return true;
    }


}
//end of Block class
