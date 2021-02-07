package org.academiadecodigo.cachealots.runner.grid;

import org.academiadecodigo.cachealots.runner.RunnerKeyboardHandler;
import org.academiadecodigo.cachealots.runner.character.Character;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;

public class Movement {
    private Grid grid;
    private Keyboard keyboard;
    private RunnerKeyboardHandler handler;

    private Character character;
    private Rectangle characterRectangle;



    public Movement(Keyboard keyboard, RunnerKeyboardHandler handler, Grid grid){

        this.grid = grid;
        this.keyboard = keyboard;
        this.handler = handler;

        characterRectangle = new Rectangle((3 * grid.getCellSize()) + grid.getPadding(), (grid.getHeight() - (2.5 * grid.getCellSize())) + grid.getY(), grid.getCellSize(), grid.getCellSize());
        characterRectangle.setColor(Color.BLUE);

    }
    public void simpleMovement(){

        keyboard.addEventListener(KeyboardEvent.KEY_RIGHT, KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(KeyboardEvent.KEY_LEFT,KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(KeyboardEvent.KEY_UP,KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(KeyboardEvent.KEY_DOWN,KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(KeyboardEvent.KEY_SPACE,KeyboardEventType.KEY_PRESSED);

    }








}
