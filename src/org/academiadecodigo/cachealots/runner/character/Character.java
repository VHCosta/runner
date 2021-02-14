package org.academiadecodigo.cachealots.runner.character;

import org.academiadecodigo.cachealots.runner.grid.Direction;
import org.academiadecodigo.cachealots.runner.grid.Grid;
import org.academiadecodigo.cachealots.runner.grid.Movement;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Character {

    private Picture sprite;
    private String[] spriteFrames;
    private int frameIndex;
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


        spriteFrames = new String[]{
                "resources/mario/mario01.png",
                "resources/mario/mario02.png",
                "resources/mario/mario03.png",
                "resources/mario/mario04.png",
                "resources/mario/mario05.png",
                "resources/mario/mario06.png",
                "resources/mario/mario07.png",
                "resources/mario/mario08.png",
        };

        sprite = new Picture((3 * grid.getCellSize()) + grid.getPadding(), FLOOR_HEIGHT, spriteFrames[frameIndex]);
        sprite.draw();
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

    public void setJumping(boolean jumping) {
        this.jumping = jumping;
    }

    public void initSprite(){
        sprite = new Picture((3 * grid.getCellSize()) + grid.getPadding(), FLOOR_HEIGHT, spriteFrames[frameIndex]);
    }

    public Movement getMovement() {
        return movement;
    }

    public Picture getSprite() {
        return sprite;
    }

    public void update(){


        if (frameIndex == spriteFrames.length-1) frameIndex = 0;

        sprite.load(spriteFrames[frameIndex]);
        frameIndex++;

    }

    public void deleteSprite(){
        sprite.delete();
    }

    public int getInitialPos() {
        return initialPos;
    }

    public void setSingleJump(boolean b) {
        singleJump = b;
    }
}
