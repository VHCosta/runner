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
    private boolean singleJump = true;

    private int initialPos;


    public final int JUMP_HEIGHT = 150;
    public final int FLOOR_HEIGHT = 235;


    public Character(CharacterType characterType, Grid grid){
        this.grid = grid;
        this.characterType = characterType;

        movement = new Movement(grid, this);
        currentDirection = Direction.NONE;

        resetSprite();
        initialPos = sprite.getY();
    }


    public void moveFlow(){

        if(singleJump) {
            if (jumping) {
                currentDirection = Direction.UP;
            }
            if (sprite.getY() <= JUMP_HEIGHT) {
                if (sprite.getY() == FLOOR_HEIGHT) {
                    currentDirection = Direction.NONE;
                } else {
                    currentDirection = Direction.DOWN;
                    jumping = false;
                    singleJump = false;
                }
            }
        }
        movement.move(currentDirection);
    }

    public boolean isSingleJump() {
        return singleJump;
    }

    public boolean isJumping() {
        return jumping;
    }

    public void setJumping(boolean jumping) {
        this.jumping = jumping;
    }

    public void resetSprite(){
        sprite = new Picture((3 * grid.getCellSize()) + grid.getPadding(), FLOOR_HEIGHT, characterType.getSource());
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

    public void setSingleJump(boolean b) {
        singleJump = b;
    }
}
