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
    private Boolean jumpmid;
    private Boolean jumpfinal;
    private Boolean jumpfinalmid;


    public RunnerKeyboardHandler(Rectangle rectangle, Grid grid) {
        this.rectangle = rectangle;
        this.grid = grid;
    }

    public RunnerKeyboardHandler(Picture picture, Grid grid) {
        this.picture = picture;
        this.grid = grid;
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                rectangle.translate(grid.CELL_SIZE, 0);
                break;
            case KeyboardEvent.KEY_LEFT:
                rectangle.translate(-grid.CELL_SIZE, 0);
                break;
            case KeyboardEvent.KEY_UP:
                rectangle.translate(0, -grid.CELL_SIZE);
                break;
            case KeyboardEvent.KEY_DOWN:
                rectangle.translate(0, grid.CELL_SIZE);
                break;
            case KeyboardEvent.KEY_SPACE:
                int d = rectangle.getY();
                if (d == 245) {
                    rectangle.translate(0, -5);
                    try {
                        Thread.sleep(40);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    jump = true;
                }
                }
        }
        @Override
        public void keyReleased (KeyboardEvent keyboardEvent){
    if(jumpmid=true){
        rectangle.translate(0, -5);
        this.jumpfinal=true;
    }
    }
    if(jumpfinal=true){
        int d = 245-rectangle.getY();
        int g = 10;
        int t0 = (int) System.currentTimeMillis();
        int ct=(int)System.currentTimeMillis();
        int t=ct-t0;
        int v= (int) (g*Math.pow(t,2)/2);
        System.out.println(t + "t");
        System.out.println(v + "v");
        System.out.println(d + "d");
        d=d-v;
        rectangle.translate(0,5);
        }
    if(jumpfinalmid=true){
        rectangle.translate(0,5);
    }
    }
//end of RunnerKeyboardHandler class
