package org.academiadecodigo.cachealots.runner;

import org.academiadecodigo.cachealots.runner.grid.Grid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Menu {

    public boolean tryAgain=false;
    public final int PADDING = 10;
    public Picture startBox = new Picture(PADDING, PADDING, "resources/Sprite-START2.png");
    public Picture quitBox = new Picture(PADDING, PADDING, "resources/Sprite-Quit.png");
    private Picture artv = new Picture(PADDING, PADDING, "resources/artv.png");
    private Grid grid;
    private Text pressSpaceToBegin;
    private Text instructions;



    public Menu(Grid grid) {
        this.grid = grid;

        startBox.translate((double) grid.getWidth()/2 - grid.PADDING - (double) startBox.getWidth()-3, (double) grid.getHeight()/2 + (double) startBox.getHeight() * 0.75);
        quitBox.translate((double) grid.getWidth()/2 + grid.PADDING * 2, (double) grid.getHeight()/2 + (double) quitBox.getHeight() * 0.75);
        artv.translate(PADDING * 2, grid.getHeight() - artv.getHeight() - PADDING * 2);

        pressSpaceToBegin = new Text(0, 0, "   Press SPACE to begin! Or press Q to exit.");
        pressSpaceToBegin.setColor(Color.WHITE);
        pressSpaceToBegin.translate((double) grid.getWidth()/2 - (double) pressSpaceToBegin.getWidth()/2, (double) grid.getHeight()/2 + (double) pressSpaceToBegin.getHeight() * 2);

        instructions = new Text(0, 0, "    INSTRUCTIONS | Press SPACE or click to jump!");
        instructions.setColor(Color.WHITE);
        instructions.translate((double) grid.getWidth()/2 - (double) instructions.getWidth()/2, (double) grid.getHeight() - instructions.getHeight());

    }
    public void init(){
        startBox.draw();
        quitBox.draw();
        pressSpaceToBegin.draw();
        instructions.draw();
        artv.draw();

    }

    public void hideStart(){
        startBox.delete();
        quitBox.delete();
        pressSpaceToBegin.delete();
        instructions.delete();
        artv.delete();
    }
}