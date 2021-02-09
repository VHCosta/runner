package org.academiadecodigo.cachealots.runner;

import org.academiadecodigo.cachealots.runner.character.Character;
import org.academiadecodigo.cachealots.runner.grid.Grid;
import org.academiadecodigo.cachealots.runner.grid.Movement;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class RunnerKeyboardHandler implements KeyboardHandler {

    private Grid grid;
    private Movement movement;
    private Character character;


    public RunnerKeyboardHandler(Grid grid, Character character){
        this.grid = grid;
        this.character = character;
    }

    public void setMovement(Movement movement) {
        this.movement = movement;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            //directional keys
            case KeyboardEvent.KEY_RIGHT -> movement.moveRight(grid.CELL_SIZE / 4);
            case KeyboardEvent.KEY_LEFT -> movement.moveLeft(grid.CELL_SIZE / 4);
            case KeyboardEvent.KEY_UP -> movement.moveUp(grid.CELL_SIZE / 4);
            case KeyboardEvent.KEY_DOWN -> movement.moveDown(grid.CELL_SIZE / 4);
            //main input
            case KeyboardEvent.KEY_SPACE -> character.setJumping(true);
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

}//end of RunnerKeyboardHandler class
