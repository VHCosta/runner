package org.academiadecodigo.cachealots.runner.character;
import org.academiadecodigo.cachealots.runner.grid.Direction;
import org.academiadecodigo.cachealots.runner.grid.Grid;
import org.academiadecodigo.cachealots.runner.grid.Movement;
import org.academiadecodigo.simplegraphics.pictures.Picture;
public class Character {

    // class with the characteristics of the running blocks
    private Picture sprite;
    private CharacterType characterType;
    private Grid grid;

    private Movement movement;
    private Direction currentDirection;

    private boolean jumping;
    private boolean singleJump = true;

    private int initialPos;

    public final int JUMP_HEIGHT = 150;
    public final int FLOOR_HEIGHT = 246;


    public Character(CharacterType characterType, Grid grid){
        this.grid = grid;
        this.characterType = characterType;

        movement = new Movement(grid, this);
        currentDirection = Direction.NONE;

        sprite = new Picture((3 * grid.getCellSize()) + grid.getPadding(), (grid.getHeight() - (2.8 * grid.getCellSize())) + grid.getY(), characterType.getSource());
        initialPos = getSprite().getY();
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

    public boolean isSingleJump() {
        return singleJump;
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

    public void setSingleJump(boolean singleJump) {
        this.singleJump = singleJump;
    }

    public Picture getSprite() {
        return sprite;
    }

    public int getInitialPos() {
        return initialPos;
    }
}