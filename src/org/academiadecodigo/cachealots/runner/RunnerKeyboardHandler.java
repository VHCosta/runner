package org.academiadecodigo.cachealots.runner;

import org.academiadecodigo.cachealots.runner.grid.Grid;
import org.academiadecodigo.cachealots.runner.grid.Movement;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class RunnerKeyboardHandler implements KeyboardHandler {

    private Picture picture;
    private Grid grid;
    private Movement movement;
    private Game game;




    public RunnerKeyboardHandler(Grid grid, Game game){
        this.grid = grid;
        this.game = game;

    }

    public RunnerKeyboardHandler(Picture picture, Grid grid){
        this.picture = picture;
        this.grid = grid;
    }

    public void setMovement(Movement movement) {
        this.movement = movement;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                movement.moveRight(grid.CELL_SIZE/4);
                break;
            case KeyboardEvent.KEY_LEFT:
                movement.moveLeft(grid.CELL_SIZE/4);
                break;
            case KeyboardEvent.KEY_UP:
                movement.moveUp(grid.CELL_SIZE/4);
                break;
            case KeyboardEvent.KEY_DOWN:
                movement.moveDown(grid.CELL_SIZE/4);
                break;
            case KeyboardEvent.KEY_SPACE:
                game.jump(true);
                break;

        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

}//end of RunnerKeyboardHandler class
