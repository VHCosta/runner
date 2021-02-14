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


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {




            case KeyboardEvent.KEY_SPACE:
                if(game.isInMenu()){
                    game.setRunning(true);
                    game.setInMenu(false);
                    game.hideMenu();


                    break;
                }

                if(game.isGameOver()){
                    game.reset();
                    break;
                }
                if(game.isRunning()) game.character.setJumping(true);
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}//end of RunnerKeyboardHandler class
