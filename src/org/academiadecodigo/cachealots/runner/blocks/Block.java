package org.academiadecodigo.cachealots.runner.blocks;

import org.academiadecodigo.cachealots.runner.character.Character;
import org.academiadecodigo.cachealots.runner.grid.Direction;
import org.academiadecodigo.cachealots.runner.grid.Grid;
import org.academiadecodigo.cachealots.runner.grid.Movement;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Block {  // class with the characteristics of the running blocks

    private Grid grid;
    public boolean onScreen;
    private Movement movement;
    private Picture sprite;

    public Block(Grid grid) {
        this.grid = grid;
        movement = new Movement(grid, this);

        sprite = new Picture(grid.getWidth() - 20, (grid.getHeight() - (2.75 * grid.getCellSize())) + grid.getY(), "resources/thwomp40.png");

        String[] sprites = {
                "resources/thwomp40.png",
                "resources/Rocket.png",
                "resources/scaryThwomp.png",
                "resources/surprisedThwomp.png",
                "resources/alexio.png"
        };
        int randomObstacles = (int) (Math.random() * sprites.length);
        sprite.load(sprites[randomObstacles]);

        show();

    }

    public void show(){
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
