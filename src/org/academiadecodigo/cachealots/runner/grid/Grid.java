package org.academiadecodigo.cachealots.runner.grid;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Grid {

    //State


    //-- Constants

    public final int PADDING = 10;
    public final int CELL_SIZE = 30;


    //-- Properties

    private int cols;
    private int rows;
    private Rectangle rectangle;

    Picture backGround;


    //Behavior

    //-- Constructor

    public Grid(){


        backGround = new Picture(PADDING, PADDING, "resources/backGround.png");
        rectangle = new Rectangle(PADDING, PADDING, backGround.getWidth(), backGround.getHeight());

    }


    //-- Main game methods

    //-- Initialize: show grid on the screen
    public void init(){
        //rectangle.setColor(Color.CYAN);
        backGround.draw();
        rectangle.draw();


        //outline.setColor(Color.DARK_GRAY);
        //outline.draw();
    }

/*
    //TODO: have specific methods to create characterBlock, cloudBlock, obstacleBlock
    /*public Block makeBlock(){

        //TODO: replace with call to BlockFactory.createBlock()
        return BlockFactory.getNewBlock();
    }
*/



    //-- Getters

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public int getCellSize() {
        return CELL_SIZE;
    }

    public int getPadding() {
        return PADDING;
    }

    //-- Other methods

    //--- X & Y

    public int getX(){
        return rectangle.getX() + PADDING;
    }

    public int getY(){
        return rectangle.getY() + PADDING;
    }


    //--- Width & Height

    public int getWidth(){
        return rectangle.getWidth();
    }

    public int getHeight(){
        return rectangle.getHeight();
    }


    //--- Aux methods to calculate cells to pixels

    public int colsToX(int cols){
        return (cols * CELL_SIZE) + PADDING;
    }

    public int rowsToY(int rows){
        return (rows * CELL_SIZE) + PADDING;
    }



}//end of Grid class
