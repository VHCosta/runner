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

    // TODO: 07/02/2021 keep track of a direction

    private Character character;
    private Rectangle characterRectangle;
    public boolean reachTheTop;


    public void setReachTheTop() throws InterruptedException {
        Thread.sleep(200);
        this.reachTheTop = true;
        System.out.println("reached the top");
        moveDown( grid.CELL_SIZE * 2);
        System.out.println("after going down");
    }

    public Movement(Keyboard keyboard, RunnerKeyboardHandler handler, Grid grid, Character character) {

        this.grid = grid;
        this.keyboard = keyboard;
        this.handler = handler;
        this.character = character;

    }

    public Movement(Keyboard keyboard, RunnerKeyboardHandler handler, Grid grid, Rectangle characterRectangle) {

        this.grid = grid;
        this.keyboard = keyboard;
        this.handler = handler;
        this.characterRectangle = characterRectangle;

    }

    public void simpleMovement() {

        keyboard.addEventListener(KeyboardEvent.KEY_RIGHT, KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(KeyboardEvent.KEY_LEFT, KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(KeyboardEvent.KEY_UP, KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(KeyboardEvent.KEY_DOWN, KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(KeyboardEvent.KEY_SPACE, KeyboardEventType.KEY_PRESSED);

    }

    // TODO: 07/02/2021 implement general movement method
    // TODO: 07/02/2021 these should change direction state, instead of moving rectangle
    public void moveUp(int distance){
        //this.direction = UP;
        character.getSprite().translate(0, -distance);
    }

    public void moveDown(int distance){
        character.getSprite().translate(0, distance);
    }

    public void moveRight(int distance){
        character.getSprite().translate(distance, 0);
    }

    public void moveLeft(int distance){
        character.getSprite().translate(-distance, 0);
    }
}
