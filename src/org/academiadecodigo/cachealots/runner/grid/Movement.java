package org.academiadecodigo.cachealots.runner.grid;

import org.academiadecodigo.cachealots.runner.Game;
import org.academiadecodigo.cachealots.runner.character.Character;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import static java.lang.Thread.sleep;


public class Movement {


    private Grid grid;
    private Game game;

    private Character character;

    int timesGoingUp;
    boolean test;


    public boolean reachTheTop = false;
    public int jumpHigh = 180;
    public int floorHigh = 245;




    public Movement(Grid grid, Character character, Game game){
        this.game = game;
        this.grid = grid;
        this.character = character;

    }


    public void moveDown(double distance){
        character.getSprite().translate(0, distance);
    }
    public void moveUp(double distance){
        character.getSprite().translate(0, -distance);
    }
    public void moveRight(int distance){
        character.getSprite().translate(10, 0);
    }
    public void moveLeft(int distance){
        character.getSprite().translate(-10, 0);
    }
    public void setReachTheTop(boolean reachTheTop) {
        this.reachTheTop = reachTheTop;
    }

/*
    public void jumping(boolean reachTheTop, Rectangle characterRectangle) {


        if(!reachTheTop && (characterRectangle.getY() > jumpHigh)){
            moveUp(65);
        }
        if(characterRectangle.getY() > jumpHigh){
            setReachTheTop(true);
        }
        if(reachTheTop && (characterRectangle.getY() < floorHigh)){
            moveDown(65);
        }
        if(characterRectangle.getY() == floorHigh){
            setReachTheTop(false);
        }
    }*/

    public void movejump() {
        double g = 9.8;
        double d = 0;
        double t0 = System.currentTimeMillis();

        if (character.isJumping()) {
            if (test) {
                timesGoingUp++;
                if (timesGoingUp == 10) {
                    moveUp(grid.CELL_SIZE / 3);
                    test = false;
                    timesGoingUp = 0;
                }
                moveUp(grid.CELL_SIZE / 3);
            }
            if (!test) {
                double t = System.currentTimeMillis() - t0;
                d = (g * Math.pow(t / 1000, 2)) / 2;
                moveDown(d);
                if (character.getSprite().getY() + d >= 245) {
                    moveDown(245 - character.getSprite().getY());
                    d = 0;
                    character.setJumping(false);
                }
            }
        }
    }
        /*
        if(jumping){
            current direction = UP;}
        if(Sprite.getY() <= JUMPHEIGHT){
            current direction = DOWN;
            jumping = false;
            if(Sprite.getY ==FLOOR){
                current direction = none;
            }
        }
        movement.move(curent direction);



    public void blocksMove() {
    }


    public void playerMove(boolean jumping) {
        if (jumping) {
            moveUp(1);
        } else if(!jumping){
            moveDown(1);
        } else {}

    }*/
}
