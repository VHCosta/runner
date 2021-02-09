package org.academiadecodigo.cachealots.runner;

import org.academiadecodigo.cachealots.runner.grid.Grid;
import org.academiadecodigo.cachealots.runner.grid.Movement;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import static java.lang.Thread.sleep;

public class Game {

    private Grid grid;
    private Keyboard keyboard;
    private RunnerKeyboardHandler handler;
    private Rectangle characterShape;
    private Rectangle rectangleHideLeft;
    private Rectangle rectangleHideRight;
    private Movement move;

    private Rectangle testAttacker1;
    private Rectangle testAttacker2;
    private Rectangle testAttacker3;
    private Rectangle testAttacker4;
    private Rectangle testAttacker5;
    private Rectangle testAttacker6;
    private Rectangle testAttacker7;

    protected boolean jumping;

    private Thread Thread1;


    //  public int time = (int) System.currentTimeMillis();
//    public int meter = grid.CELL_SIZE;

    //will replace rectangle:
    //private Picture characterSprite;
    //TODO: get temp gfx for:
    // [] background (Grid class?)
    // [] char sprites

    public Game(int cols, int rows) {

        grid = new Grid(cols, rows);
        characterShape = new Rectangle((3 * grid.getCellSize()) + grid.getPadding(), (grid.getHeight() - (2.5 * grid.getCellSize())) + grid.getY(), grid.getCellSize(), grid.getCellSize());
        characterShape.setColor(Color.BLUE);
        rectangleHideLeft = new Rectangle(0,0,grid.PADDING, grid.getHeight()+ grid.PADDING);
        rectangleHideLeft.setColor(Color.WHITE);
        rectangleHideRight = new Rectangle(grid.getWidth()+ grid.PADDING,0,grid.PADDING*5, grid.getHeight());
        rectangleHideRight.setColor(Color.WHITE);

        testAttacker1 = new Rectangle((grid.getWidth() - grid.getCellSize()) + grid.getPadding()*5, (grid.getHeight() - (2.5 * grid.getCellSize())) + grid.getY(), grid.getCellSize(), grid.getCellSize());
        testAttacker1.setColor(Color.BLACK);

        testAttacker2 = new Rectangle((grid.getWidth() - grid.getCellSize()) + grid.getPadding()*5, (grid.getHeight() - (2.5 * grid.getCellSize())) + grid.getY(), grid.getCellSize(), grid.getCellSize());
        testAttacker2.setColor(Color.GRAY);

        testAttacker3 = new Rectangle((grid.getWidth() - grid.getCellSize()) + grid.getPadding()*5, (grid.getHeight() - (2.5 * grid.getCellSize())) + grid.getY(), grid.getCellSize(), grid.getCellSize());
        testAttacker3.setColor(Color.YELLOW);

        testAttacker4 = new Rectangle((grid.getWidth() - grid.getCellSize()) + grid.getPadding()*5, (grid.getHeight() - (2.5 * grid.getCellSize())) + grid.getY(), grid.getCellSize(), grid.getCellSize());
        testAttacker4.setColor(Color.PINK);

        testAttacker5 = new Rectangle((grid.getWidth() - grid.getCellSize()) + grid.getPadding()*5, (grid.getHeight() - (2.5 * grid.getCellSize())) + grid.getY(), grid.getCellSize(), grid.getCellSize());
        testAttacker5.setColor(Color.BLACK);

        testAttacker6 = new Rectangle((grid.getWidth() - grid.getCellSize()) + grid.getPadding()*5, (grid.getHeight() - (2.5 * grid.getCellSize())) + grid.getY(), grid.getCellSize(), grid.getCellSize());
        testAttacker6.setColor(Color.YELLOW);

        testAttacker7 = new Rectangle((grid.getWidth() - grid.getCellSize()) + grid.getPadding()*5, (grid.getHeight() - (2.5 * grid.getCellSize())) + grid.getY(), grid.getCellSize(), grid.getCellSize());
        testAttacker7.setColor(Color.PINK);

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


    final Thread thread1 = new Thread() {
        public void run() {
            for (int i = 0; i <= grid.getWidth()/2.7 ; i++) {
                testAttacker1.translate(-grid.CELL_SIZE/8, 0);
                try {
                    sleep(15);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i <= grid.getWidth()/2.7 ; i++) {
                testAttacker2.translate(-grid.CELL_SIZE/8, 0);
                try {
                    sleep(13);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i <= grid.getWidth()/2.5 ; i++) {
                testAttacker3.translate(-grid.CELL_SIZE/8, 0);
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i <= grid.getWidth()/2.5 ; i++) {
                testAttacker4.translate(-grid.CELL_SIZE/8, 0);
                try {
                    sleep(8);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i <= grid.getWidth()/2.7 ; i++) {
                testAttacker5.translate(-grid.CELL_SIZE/8, 0);
                try {
                    sleep(13);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i <= grid.getWidth()/2.5 ; i++) {
                testAttacker6.translate(-grid.CELL_SIZE/8, 0);
                try {
                    sleep(9);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i <= grid.getWidth()/2.5 ; i++) {
                testAttacker7.translate(-grid.CELL_SIZE/8, 0);
                try {
                    sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    public void start() throws InterruptedException {

        grid.init();
        characterShape.fill();


        testAttacker1.fill();
        testAttacker2.fill();
        testAttacker3.fill();
        testAttacker4.fill();
        testAttacker5.fill();
        testAttacker6.fill();
        testAttacker7.fill();
        thread1.start();


        rectangleHideLeft.fill();
        rectangleHideRight.fill();


        move.simpleMovement();

        //floorShape.draw();
        while(true){ //while game is not over
            //checkListener();
            while(jumping){

                for(int i = 0; i<17; i++){
                    move.moveUp(grid.CELL_SIZE/7);
                    sleep(20);
                }
                System.out.println("Up");

                for(int i = 0; i<17; i++) {
                    move.moveDown(grid.CELL_SIZE/7);
                    sleep(20);
                }
                System.out.println("down");
                jumping = false;

            }
        sleep(20);
        }
//hiddenSecretOfLife
    }
}