package org.academiadecodigo.cachealots.runner;

import org.academiadecodigo.cachealots.runner.grid.Grid;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class RunnerKeyboardHandler implements KeyboardHandler {

    private Rectangle rectangle;
    private Picture picture;
    private Grid grid;


    public RunnerKeyboardHandler(Rectangle rectangle, Grid grid){
        this.rectangle = rectangle;
        this.grid = grid;
    }

    public RunnerKeyboardHandler(Picture picture, Grid grid){
        this.picture = picture;
        this.grid = grid;
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                rectangle.translate(grid.CELL_SIZE/4,0);
                break;
            case KeyboardEvent.KEY_LEFT:
                rectangle.translate(-grid.CELL_SIZE/4,0);
                break;
            case KeyboardEvent.KEY_UP:
                rectangle.translate(0,-grid.CELL_SIZE/4);
                break;
            case KeyboardEvent.KEY_DOWN:
                rectangle.translate(0,grid.CELL_SIZE/4);
                break;
            case KeyboardEvent.KEY_SPACE:
                rectangle.translate(0,-grid.CELL_SIZE/4);
                break;


        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

}//end of RunnerKeyboardHandler class
