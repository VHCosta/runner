package org.academiadecodigo.cachealots.runner;

import org.academiadecodigo.cachealots.runner.character.Character;
import org.academiadecodigo.cachealots.runner.character.CharacterType;
import org.academiadecodigo.cachealots.runner.grid.Grid;
import org.academiadecodigo.cachealots.runner.grid.Movement;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
<<<<<<< HEAD
=======
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;

>>>>>>> 2665c62da268107f038f65dc69a9a4ba6fa3a584

public class Game {

    private Grid grid;
    private Keyboard keyboard;
    private RunnerKeyboardHandler handler;
    //temporary shape as placeholder
    private Rectangle characterShape;
    private Rectangle rectangleHide;
    private Movement move;
    private Rectangle floorShape;
<<<<<<< HEAD

    private Character character;
=======
    protected boolean jumping;


    //will replace rectangle:
    //private Picture characterSprite;
    //TODO: get temp gfx for:
    // [] background (Grid class?)
    // [] char sprites
>>>>>>> 2665c62da268107f038f65dc69a9a4ba6fa3a584

    public Game(int cols, int rows) {

        grid = new Grid(cols, rows);

        //characterShape = new Rectangle((3 * grid.getCellSize()) + grid.getPadding(), (grid.getHeight() - (2.5 * grid.getCellSize())) + grid.getY(), grid.getCellSize(), grid.getCellSize());
        //characterShape.setColor(Color.BLUE);

        character = new Character(CharacterType.ALEX, grid);

        rectangleHide = new Rectangle(0,0,grid.PADDING, grid.getHeight()+ grid.PADDING);
        rectangleHide.setColor(Color.WHITE);
<<<<<<< HEAD

        handler = new RunnerKeyboardHandler(characterShape, grid);
        keyboard = new Keyboard(handler);

        move = new Movement(keyboard, handler, grid);
=======
        handler = new RunnerKeyboardHandler(grid, this);
        keyboard = new Keyboard(handler);
        move = new Movement(keyboard, handler, grid, characterShape);
        handler.setMovement(move);


>>>>>>> 2665c62da268107f038f65dc69a9a4ba6fa3a584
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
        grid.init();
        character.getSprite().draw();
        rectangleHide.fill();
        move.simpleMovement();
        //floorShape.draw();
        while(true){ //while game is not over
            //checkListener();
            while(jumping){
                move.moveUp(3* grid.CELL_SIZE);
                System.out.println("up");
                Thread.sleep(200);
                move.moveDown(3*grid.CELL_SIZE);
                System.out.println("down");
                jumping = false;

            }
        Thread.sleep(20);
        }

    }
}