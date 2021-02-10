package org.academiadecodigo.cachealots.runner.movingGFX;

import org.academiadecodigo.cachealots.runner.grid.Grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;

public class MovingGround {


    private Picture groundTile = new Picture(0, 0, "resources/ground_frames/cell_0.png");
    private Grid grid;



    public MovingGround(Grid grid) {
        this.grid = grid;
    }


    //ground frames
    private Picture tile1;
    private Picture tile2;
    private Picture tile3;


    public void drawGround() throws InterruptedException {

        //Constants
        int GROUND_X = grid.getWidth() - 3 * grid.CELL_SIZE;
        int GROUND_Y = grid.GROUND_Y;

        tile1 = new Picture(grid.PADDING, GROUND_Y, "resources/ground_frames/cell_1.png");
        tile2 = new Picture(grid.PADDING, GROUND_Y, "resources/ground_frames/cell_2.png");
        tile3 = new Picture(grid.PADDING, GROUND_Y, "resources/ground_frames/cell_3.png");

        for(int i = 0; i < 20; i++){
            tile1.draw();
            Thread.sleep(100);
            tile1.delete();
            tile2.draw();
            Thread.sleep(100);
            tile2.delete();
            tile3.draw();
            Thread.sleep(100);
            tile3.delete();
        }



        //groundTile  = new Picture(grid.PADDING, GROUND_Y, "resources/ground_tile_cell.png");
        //groundTile.draw();



    }
}