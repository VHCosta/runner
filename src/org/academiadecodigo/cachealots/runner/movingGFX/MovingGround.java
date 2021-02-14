package org.academiadecodigo.cachealots.runner.movingGFX;

import org.academiadecodigo.cachealots.runner.grid.Grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class MovingGround {

    private Picture groundTile = new Picture(0, 0, "resources/ground_frames/cell_0.png");
    private Grid grid;
    private Picture sprite;
    private String[] frames;

    private int frameCounter;


    public MovingGround(Grid grid) {

        this.grid = grid;
        final int GROUND_X = grid.getWidth() - 2 * grid.CELL_SIZE;
        final int GROUND_Y = grid.GROUND_Y;

        frames = new String[]{
                "resources/ground_frames/ground_frame1.png",
                "resources/ground_frames/ground_frame2.png",
                "resources/ground_frames/ground_frame3.png",
        };

        sprite = new Picture(grid.PADDING, GROUND_Y, "resources/ground_frames/ground_frame1.png");
        sprite.draw();
    }


    public void update() {

        if (frameCounter == 3) frameCounter = 0;

        sprite.load(frames[frameCounter]);

        frameCounter++;

    }


    public Picture getSprite() {
        return sprite;
    }

    public void deleteSprite(){
        sprite.delete();
    }

    public void initSprite(){
        sprite = new Picture(grid.PADDING, grid.GROUND_Y, "resources/ground_frames/ground_frame1.png");
    }
}