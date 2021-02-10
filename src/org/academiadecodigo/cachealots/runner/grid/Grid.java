package org.academiadecodigo.cachealots.runner.grid;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Grid {

    //State


    //-- Constants

    public final int PADDING = 10;
    public final int CELL_SIZE = 30;
    public final int GROUND_X = PADDING;
    public final int GROUND_Y = 9 * CELL_SIZE;

    //-- Properties

    private int cols;
    private int rows;
    private Rectangle outline;
    private Rectangle sky;





    //temp image for background
    private Picture background;


    //Behavior

    //-- Constructor

    public Grid(int cols, int rows){
        this.cols = cols;
        this.rows = rows;



        background = new Picture(PADDING, PADDING, "resources/backGround.png");
        sky = new Rectangle(PADDING, PADDING, background.getWidth(), background.getHeight());
        outline = new Rectangle(PADDING, PADDING, background.getWidth(), background.getHeight());




    }


    //-- Main game methods

    //-- Initialize: show grid on the screen
    public void init(){

        sky.setColor(Color.CYAN);
        sky.fill();
        //background.draw();
        outline.draw();


    }





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
        return outline.getX() + PADDING;
    }

    public int getY(){
        return outline.getY() + PADDING;
    }


    //--- Width & Height

    public int getWidth(){
        return outline.getWidth();
    }

    public int getHeight(){
        return outline.getHeight();
    }


    //--- Aux methods to calculate cells to pixels

    public int colsToX(int cols){
        return (cols * CELL_SIZE) + PADDING;
    }

    public int rowsToY(int rows){
        return (rows * CELL_SIZE) + PADDING;
    }



}//end of Grid class
