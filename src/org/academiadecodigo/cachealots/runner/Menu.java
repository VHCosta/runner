package org.academiadecodigo.cachealots.runner;

import org.academiadecodigo.cachealots.runner.grid.Grid;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Menu {

    public boolean tryAgain=false;
    public final int PADDING = 10;
    public Picture startBox = new Picture(PADDING, PADDING, "resources/Sprite-START2.png");
    public Picture quitBox = new Picture(PADDING, PADDING, "resources/Sprite-Quit.png");
    private Grid grid;
    private Text pressSpaceToBegin;



    public Menu(Grid grid) {
        this.grid = grid;

        startBox.translate((double) grid.getWidth()/2 - (double) startBox.getWidth()*1.5, (double) grid.getHeight()/2 + (double) startBox.getHeight());
        quitBox.translate((double) grid.getWidth()/2 + (double) quitBox.getWidth()/2, (double) grid.getHeight()/2 + (double) quitBox.getHeight());

        pressSpaceToBegin = new Text(0, 0, "Press SPACE to begin! Or press Q to exit.");
        pressSpaceToBegin.translate((double) grid.getWidth()/2 - (double) pressSpaceToBegin.getWidth()/2, (double) grid.getHeight()/2 + (double) pressSpaceToBegin.getHeight() * 2);

    }
    public void init(){
        startBox.draw();
        quitBox.draw();
        pressSpaceToBegin.draw();


    }

    public void hideStart(){
        startBox.delete();
        quitBox.delete();
        pressSpaceToBegin.delete();
    }
}