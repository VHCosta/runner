package org.academiadecodigo.cachealots.runner;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class RunnerKeyboardHandler implements KeyboardHandler {

    private Rectangle rectangle;
    private Picture picture;


    public RunnerKeyboardHandler(Rectangle rectangle){
        this.rectangle = rectangle;
    }

    public RunnerKeyboardHandler(Picture picture){
        this.picture = picture;
    }



    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

}//end of RunnerKeyboardHandler class
