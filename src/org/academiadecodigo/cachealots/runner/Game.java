package org.academiadecodigo.cachealots.runner;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.pictures.Picture;

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


        handler = new RunnerKeyboardHandler(characterShape);
        keyboard = new Keyboard(handler);
    }


    public void start(){
        grid.init();
        characterShape.fill();
        //floorShape.draw();

    }


}//end of Game class
