package org.academiadecodigo.cachealots.runner;

import org.academiadecodigo.cachealots.runner.grid.Grid;
import org.academiadecodigo.cachealots.runner.grid.Movement;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class RunnerKeyboardHandler implements KeyboardHandler {

    private Movement movement;
    private Game game;


    public RunnerKeyboardHandler(Grid grid, Game game){
        this.game = game;

    }


    public void setMovement(Movement movement) {
        this.movement = movement;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                movement.moveRight(3);
                break;
            case KeyboardEvent.KEY_LEFT:
                movement.moveLeft(3);
                break;
            case KeyboardEvent.KEY_UP:
                movement.moveUp(1);
                break;
            case KeyboardEvent.KEY_DOWN:
                movement.moveDown(1);
                break;


            case KeyboardEvent.KEY_SPACE:
                game.character.setJumping(true);
                // movement.jumping(movement.reachTheTop, game.characterShape);
                break;


        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
/*
    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }*/
}//end of RunnerKeyboardHandler class
