package org.academiadecodigo.cachealots.runner;

import org.academiadecodigo.cachealots.runner.character.Character;
import org.academiadecodigo.cachealots.runner.grid.Grid;
import org.academiadecodigo.cachealots.runner.grid.Movement;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class RunnerKeyboardHandler implements KeyboardHandler {

    private Grid grid;
    private Movement movement;
    private Game game;


    public RunnerKeyboardHandler(Grid grid, Game game){
        this.grid = grid;
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
                if (!game.isRunning()) {
                    try {
                        game.reset();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    game.character.setJumping(true);
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}//end of RunnerKeyboardHandler class
