package org.academiadecodigo.cachealots.runner.movingGFX;

import org.academiadecodigo.cachealots.runner.grid.Direction;
import org.academiadecodigo.cachealots.runner.grid.Grid;
import org.academiadecodigo.cachealots.runner.grid.Movement;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class CloudBackground {  // class with the characteristics of the running blocks

    private Grid grid;
    public boolean onScreen;
    private Movement movement;
    private Picture sprite;
    private int frameIndex;
    private String[] cloudBackgroundFrames;

    public CloudBackground(Grid grid) {
        this.grid = grid;
        movement = new Movement(grid, this);

        cloudBackgroundFrames = new String[]{
                "resources/clouds/cloudbg001.png",
                "resources/clouds/cloudbg002.png",
                "resources/clouds/cloudbg003.png",
                "resources/clouds/cloudbg004.png",
                "resources/clouds/cloudbg005.png",
                "resources/clouds/cloudbg006.png",
                "resources/clouds/cloudbg007.png",
                "resources/clouds/cloudbg008.png",
                "resources/clouds/cloudbg009.png",
                "resources/clouds/cloudbg010.png",
                "resources/clouds/cloudbg011.png",
                "resources/clouds/cloudbg012.png",
                "resources/clouds/cloudbg013.png",
                "resources/clouds/cloudbg014.png",
                "resources/clouds/cloudbg015.png",
                "resources/clouds/cloudbg016.png",
                "resources/clouds/cloudbg017.png",
                "resources/clouds/cloudbg017.png",
                "resources/clouds/cloudbg018.png",
                "resources/clouds/cloudbg019.png",
                "resources/clouds/cloudbg020.png",
                "resources/clouds/cloudbg021.png",
                "resources/clouds/cloudbg022.png",
                "resources/clouds/cloudbg023.png",
                "resources/clouds/cloudbg024.png",
                "resources/clouds/cloudbg025.png",
                "resources/clouds/cloudbg026.png"
        };

    }

    public void initSprite(){
        sprite = new Picture(grid.PADDING, (grid.getHeight() - (2.75 * grid.getCellSize())) + grid.getY(), "resources/clouds/cloudbg001.png");
        sprite.draw();
    }

    public void update(){

        if (frameIndex == cloudBackgroundFrames.length-1) frameIndex = 0;

        System.out.println(cloudBackgroundFrames[frameIndex]);
        sprite.load
                (cloudBackgroundFrames[frameIndex]);
        frameIndex++;

    }

    public Picture getSprite() {
        return sprite;
    }

    public void deleteSprite(){
        sprite.delete();
    }

    public void move() {
        movement.moveCloudBackground(Direction.LEFT);
    }

    public int getX(){
        return sprite.getX();
    }

    public int getY(){
        return sprite.getY();
    }

    public int getHeight(){
        return sprite.getHeight();
    }

    public int getWidth(){
        return sprite.getWidth();
    }



    public boolean isOnScreen(){
        if (sprite.getX() + (sprite.getWidth()/2) < 0 ) {
            return false;
        }
        return true;
    }


}
//end of Block class
