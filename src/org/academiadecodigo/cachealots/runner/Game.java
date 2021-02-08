package org.academiadecodigo.cachealots.runner;
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
    protected boolean jumping;

    public Game(int cols, int rows) {

        grid = new Grid(cols, rows);
        characterShape = new Rectangle((3 * grid.getCellSize()) + grid.getPadding(), (grid.getHeight() - (2.5 * grid.getCellSize())) + grid.getY(), grid.getCellSize(), grid.getCellSize());
        characterShape.setColor(Color.BLUE);
        rectangleHide = new Rectangle(0,0,grid.PADDING, grid.getHeight()+ grid.PADDING);
        rectangleHide.setColor(Color.WHITE);
        handler = new RunnerKeyboardHandler(grid, this);
        keyboard = new Keyboard(handler);
        move = new Movement(keyboard, handler, grid, characterShape);
        handler.setMovement(move);



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
   // public void gravityJump(){
     //   final int GRAVITY = 10;
       // grid.CELL_SIZE * GRAVITY * Time * Time /2;
    //}

    public void start() throws InterruptedException {
        grid.init();
        characterShape.fill();
        rectangleHide.fill();
        move.simpleMovement();

        //floorShape.draw();
        while(true){ //while game is not over
            //checkListener();
            while(jumping){
                move.moveUp( grid.CELL_SIZE/3);
                System.out.println("up");
                Thread.sleep(20);
                move.moveUp( grid.CELL_SIZE/3);
                System.out.println("up");
                Thread.sleep(20);
                move.moveUp( grid.CELL_SIZE/3);
                System.out.println("up");
                Thread.sleep(20);
                move.moveUp( grid.CELL_SIZE/3);
                System.out.println("up");
                Thread.sleep(20);
                move.moveUp( grid.CELL_SIZE/3);
                System.out.println("up");
                Thread.sleep(20);
                move.moveUp( grid.CELL_SIZE/3);
                System.out.println("up");
                Thread.sleep(20);
                move.moveUp( grid.CELL_SIZE/3);
                System.out.println("up");
                Thread.sleep(20);
                move.moveUp( grid.CELL_SIZE/3);
                System.out.println("up");
                Thread.sleep(20);
                move.moveUp( grid.CELL_SIZE/3);
                System.out.println("up");
                Thread.sleep(20);

                move.moveDown(grid.CELL_SIZE/3);
                System.out.println("down");
                Thread.sleep(20);
                move.moveDown(grid.CELL_SIZE/3);
                System.out.println("down");
                Thread.sleep(20);
                move.moveDown(grid.CELL_SIZE/3);
                System.out.println("down");
                Thread.sleep(20);
                move.moveDown(grid.CELL_SIZE/3);
                System.out.println("down");
                Thread.sleep(20);
                move.moveDown(grid.CELL_SIZE/3);
                System.out.println("down");
                Thread.sleep(20);
                move.moveDown(grid.CELL_SIZE/3);
                System.out.println("down");
                Thread.sleep(20);
                move.moveDown(grid.CELL_SIZE/3);
                System.out.println("down");
                Thread.sleep(20);
                move.moveDown(grid.CELL_SIZE/3);
                System.out.println("down");
                Thread.sleep(20);
                move.moveDown(grid.CELL_SIZE/3);
                System.out.println("down");
                Thread.sleep(20);
                jumping = false;


            }
        Thread.sleep(20);
        }

    }
}