package org.academiadecodigo.cachealots.runner.movingGFX;

import org.academiadecodigo.cachealots.runner.grid.Direction;
import org.academiadecodigo.cachealots.runner.grid.Grid;
import org.academiadecodigo.cachealots.runner.grid.Movement;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Cloud {  // class with the characteristics of the running blocks

    private Grid grid;
    public boolean onScreen;
    private Movement movement;
    private Picture sprite;

    public Cloud(Grid grid) {
        this.grid = grid;
        movement = new Movement(grid, this);
        sprite = new Picture(grid.PADDING, (grid.getHeight() - (2.75 * grid.getCellSize())) + grid.getY(), "resources/clouds/cloud_bg01.png");


        show();

    }

    public void show(){
        //obstacle.fill();
        sprite.draw();
        onScreen = true;

    }

    public Picture getSprite() {
        return sprite;
    }

    public void move() {
        movement.moveBlock(Direction.LEFT);
    }

    public int getX(){
        return sprite.getX();
    }

    public int getY(){
        return sprite.getY();
    }

    public int getHeight(){
        return sprite.getHeight();
    }

    public int getWidth(){
        return sprite.getWidth();
    }



    public boolean isOnScreen(){
        if (sprite.getX() + sprite.getWidth() < 0 ) {
            return false;
        }
        return true;
    }


}
//end of Block class
