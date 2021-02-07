package org.academiadecodigo.cachealots.runner;

import org.academiadecodigo.cachealots.runner.grid.Grid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;

public class Game {

    private Grid grid;
    private Keyboard keyboard;
    private RunnerKeyboardHandler handler;

    //temporary shape as placeholder
    private Rectangle characterShape;



    private Rectangle floorShape;


    //will replace rectangle:
    //private Picture characterSprite;



    //TODO: get temp gfx for:
    // [] background (Grid class?)
    // [] char sprites


    public Game(int cols, int rows){
        grid = new Grid(cols, rows);

        //TODO: replace with call to BlockFactory.createBlock();
        characterShape = new Rectangle((3 * grid.getCellSize()) + grid.getPadding(), (grid.getHeight() - (2.5 * grid.getCellSize())) + grid.getY(), grid.getCellSize(), grid.getCellSize());
        characterShape.setColor(Color.BLUE);


        //floorShape = new Rectangle(grid.getPadding(), (grid.getHeight() - (2 * grid.getCellSize())) + grid.getY(), grid.getWidth(), (1 * grid.getCellSize()) - grid.getPadding());
        //floorShape.setColor(Color.DARK_GRAY);


        handler = new RunnerKeyboardHandler(characterShape, grid);
        keyboard = new Keyboard(handler);
    }
    public void movement(){

        keyboard.addEventListener(KeyboardEvent.KEY_RIGHT, KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(KeyboardEvent.KEY_LEFT,KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(KeyboardEvent.KEY_UP,KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(KeyboardEvent.KEY_DOWN,KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(KeyboardEvent.KEY_SPACE,KeyboardEventType.KEY_PRESSED);
        Boolean jump;
    }


    public void start(){
        grid.init();
        characterShape.fill();
        movement();
        //floorShape.draw();

    }


}//end of Game class
