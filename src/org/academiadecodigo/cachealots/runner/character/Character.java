package org.academiadecodigo.cachealots.runner.character;

import org.academiadecodigo.cachealots.runner.grid.Direction;
import org.academiadecodigo.cachealots.runner.grid.Grid;
import org.academiadecodigo.cachealots.runner.grid.Movement;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Character {

    private Picture sprite;
    private Grid grid;
    private boolean jumping;
    private boolean singleJump;

    private CharacterType characterType;
    private Movement movement;
    private Direction currentDirection;

    private int initialPos;


    public final int JUMP_HEIGHT = 150;
    public final int FLOOR_HEIGHT = 235;


    public Character(CharacterType characterType, Grid grid){
        this.grid = grid;
        this.characterType = characterType;

        movement = new Movement(grid, this);
        currentDirection = Direction.NONE;

        sprite = new Picture((3 * grid.getCellSize()) + grid.getPadding(), FLOOR_HEIGHT, characterType.getSource());
        initialPos = sprite.getY();
    }


    public void moveFlow(){
        if(singleJump) {
            if (jumping) {
                currentDirection = Direction.UP;
                System.out.println("far 1");
            }
            if (sprite.getY() <= JUMP_HEIGHT) {
                System.out.println("far 2");
                if (sprite.getY() == FLOOR_HEIGHT) {
                    System.out.println("far 3");
                    currentDirection = Direction.NONE;
                } else {
                    System.out.println("far 4");
                    currentDirection = Direction.DOWN;
                    jumping = false;
                    singleJump = false;
                }
            }
        }
        movement.move(currentDirection);
    }

    public void setSingleJump(boolean singleJump) {
        this.singleJump = singleJump;
    }

    public boolean isJumping() {
        return jumping;
    }

    public void setJumping(boolean jumping) {
        this.jumping = jumping;
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
