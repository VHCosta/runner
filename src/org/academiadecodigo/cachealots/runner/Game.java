package org.academiadecodigo.cachealots.runner;

import org.academiadecodigo.cachealots.runner.character.Character;
import org.academiadecodigo.cachealots.runner.character.CharacterType;
import org.academiadecodigo.cachealots.runner.grid.Grid;
import org.academiadecodigo.cachealots.runner.grid.Movement;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;


public class Game {

    private Grid grid;
    private Keyboard keyboard;
    private RunnerKeyboardHandler handler;
    //temporary shape as placeholder
    private Rectangle characterShape;
    private Rectangle rectangleHide;
    private Movement move;
    private Rectangle floorShape;

    private Character character;
    protected boolean jumping;


    public Game(int cols, int rows) {

        grid = new Grid(cols, rows);

        //characterShape = new Rectangle((3 * grid.getCellSize()) + grid.getPadding(), (grid.getHeight() - (2.5 * grid.getCellSize())) + grid.getY(), grid.getCellSize(), grid.getCellSize());
        //characterShape.setColor(Color.BLUE);

        character = new Character(CharacterType.ALEX, grid);
        rectangleHide = new Rectangle(0,0,grid.PADDING, grid.getHeight()+ grid.PADDING);
        rectangleHide.setColor(Color.WHITE);
        handler = new RunnerKeyboardHandler(grid, this);
        keyboard = new Keyboard(handler);
        move = new Movement(keyboard, handler, grid, character);
        handler.setMovement(move);


        //TODO: replace with call to BlockFactory.createBlock();

        //floorShape = new Rectangle(grid.getPadding(), (grid.getHeight() - (2 * grid.getCellSize())) + grid.getY(), grid.getWidth(), (1 * grid.getCellSize()) - grid.getPadding());
        //floorShape.setColor(Color.DARK_GRAY);
    }

    public void jump(boolean j) {
        this.jumping = j;
    }

    public boolean added;
    void checkListener(){
        if (!added){
            keyboard.addEventListener(KeyboardEvent.KEY_SPACE, KeyboardEventType.KEY_PRESSED);
            added = true;
        }
    }

    public void start() throws InterruptedException {
        //initialize the bg
        grid.init();
        //draw char sprite
        character.getSprite().draw();
        //shape to hide left side of screen
        rectangleHide.fill();
        //add listeners
        move.simpleMovement();

        //game loop
        while(true){ //while game is not over

            while(jumping){

                for (int i = 0; i < 18; i++) {
                    move.moveUp( grid.CELL_SIZE/4);
                    Thread.sleep(20);
                }

                for (int i = 0; i < 18; i++) {
                    move.moveDown(grid.CELL_SIZE/4);
                    Thread.sleep(12);
                }

                jumping = false;

            }

        Thread.sleep(20);

        }

    }
}