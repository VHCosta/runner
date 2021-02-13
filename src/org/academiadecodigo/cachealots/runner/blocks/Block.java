package org.academiadecodigo.cachealots.runner.blocks;

import org.academiadecodigo.cachealots.runner.character.Character;
import org.academiadecodigo.cachealots.runner.grid.Direction;
import org.academiadecodigo.cachealots.runner.grid.Grid;
import org.academiadecodigo.cachealots.runner.grid.Movement;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Block {  // class with the characteristics of the running blocks

    private Rectangle obstacle;
    private Grid grid;
    public boolean onScreen;
    private Movement movement;
    private Picture sprite;

    public Block(Grid grid) {
        this.grid = grid;
        movement = new Movement(grid, this);
        //obstacle = new Rectangle(grid.getWidth() - 20, (grid.getHeight() - (2.5 * grid.getCellSize())) + grid.getY(), grid.getCellSize(), grid.getCellSize());

        sprite = new Picture(grid.getWidth() - 20, (grid.getHeight() - (2.75 * grid.getCellSize())) + grid.getY(), "resources/rocket.png");

        //set random color

        String[] sprites = {
                "resources/thwomp40.png",
                "resources/rocket.png",
                "resources/scaryThwomp.png",
                "resources/surprisedThwomp.png",
                "resources/alexio.png"
        };
        int randomObstacles = (int) (Math.random() * sprites.length);
        sprite.load(sprites[randomObstacles]);

        show();

    }

    public Rectangle getObstacle() {
        return obstacle;
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
        //obstacle.translate(-grid.CELL_SIZE / grid.PADDING, 0);
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
