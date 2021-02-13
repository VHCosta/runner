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

    private Rectangle outline;
    private Picture background;

    //Behavior
    //-- Constructor

    public Grid(){
        background = new Picture(PADDING, PADDING, "resources/angryimg.png");
        outline = new Rectangle(PADDING, PADDING, background.getWidth(), background.getHeight());
        outline.setColor(Color.LIGHT_GRAY);
    }

    //-- Main game methods

    //-- Initialize: show grid on the screen
    public void init(){
        background.draw();
        outline.draw();
    }


    //-- Getters

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
