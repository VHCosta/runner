package org.academiadecodigo.cachealots.runner.character;

import org.academiadecodigo.cachealots.runner.grid.Direction;
import org.academiadecodigo.cachealots.runner.grid.Grid;
import org.academiadecodigo.cachealots.runner.grid.Movement;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Character {

    private Picture sprite;
    private Grid grid;

    private CharacterType characterType;
    private Movement movement;
    private Direction currentDirection;

    private boolean jumping;
    private boolean descending;

    private int initialPos;


    public final int JUMP_HEIGHT = 150;
    public final int FLOOR_HEIGHT = 235;


    public Character(CharacterType characterType, Grid grid){
        this.grid = grid;
        this.characterType = characterType;

        movement = new Movement(grid, this);
        currentDirection = Direction.NONE;

        sprite = new Picture((3 * grid.getCellSize()) + grid.getPadding(), FLOOR_HEIGHT, characterType.getSource());
        initialPos = getSprite().getY();
    }


    public void moveFlow(){

        if(jumping) {
            currentDirection = Direction.UP;
        }
        if(sprite.getY() <= JUMP_HEIGHT) {
            descending = true;
            if(sprite.getY() == FLOOR_HEIGHT){
                currentDirection = Direction.NONE;
                descending = false;
            }
            else {
                currentDirection = Direction.DOWN;
                jumping = false;
            }
        }

        movement.move(currentDirection);
    }


    public boolean isJumping() {
        return jumping;
    }

    public void setJumping(boolean jumping) {
        this.jumping = jumping;
    }

    public boolean isDescending() {
        return descending;
    }

    public Movement getMovement() {
        return movement;
    }

    public Picture getSprite() {
        return sprite;
    }

    public int getInitialPos() {
        return initialPos;
    }
}
