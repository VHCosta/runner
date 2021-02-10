package org.academiadecodigo.cachealots.runner;
import org.academiadecodigo.cachealots.runner.grid.Grid;
import org.academiadecodigo.cachealots.runner.grid.Movement;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.w3c.dom.html.HTMLImageElement;

import java.awt.geom.AffineTransform;
import java.sql.Time;


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
        rectangleHide = new Rectangle(0,0,grid.PADDING, grid.getHeight()+ grid.PADDING);
        rectangleHide.setColor(Color.WHITE);
        handler = new RunnerKeyboardHandler(grid, this);
        keyboard = new Keyboard(handler);
        move = new Movement(keyboard, handler, grid, characterShape);
        handler.setMovement(move);



        //TODO: replace with call to BlockFactory.createBlock();

        //floorShape = new Rectangle(grid.getPadding(), (grid.getHeight() - (2 * grid.getCellSize())) + grid.getY(), grid.getWidth(), (1 * grid.getCellSize()) - grid.getPadding());
        //floorShape.setColor(Color.DARK_GRAY);
    }
    public void jump(boolean j) {
        if(characterShape.getY()==245) {
            this.jumping = j;
        }
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
        int timesGoingUpAndDown=0;
        boolean rtf=false;
        //floorShape.draw();
        while(true){ //while game is not over
            //checkListener();
            double speed=0;

            double g=9.8;
            double d=0;
            double maxTime=0.00536;
            double maxHight=100;
            double jumpUpInitialSpeed=0.186567;
            double t0= System.currentTimeMillis();
            while(jumping){
                while(rtf==false) {
                    int initialJumpY=characterShape.getY();
                    double t=System.currentTimeMillis()-t0;
                    d = (g*Math.pow(t/1000,2))/2;
                    if(characterShape.getY()-d>=characterShape.getY()-100){
                        //tM=2*jumpUpInitialSpeed*Math.sin(90)/g;
                        move.moveUp(d);
                        Thread.sleep(20);
                        System.out.println(characterShape.getY());
                        System.out.println(characterShape.getY()-d);
                        if(characterShape.getY()+d<=initialJumpY-100){
                            move.moveUp(characterShape.getY()-(initialJumpY-100));
                            rtf = true;
                            Thread.sleep(2);
                        }
                    }
                }
                while(rtf==true) {
                    double t=System.currentTimeMillis()-t0;
                    d = (g*Math.pow(t/1000,2))/2;
                    move.moveDown(d);
                    Thread.sleep(2);
                    if(characterShape.getY()+d>=245) {
                        move.moveDown(245-characterShape.getY());
                        Thread.sleep(2);
                        rtf=false;
                        jumping = false;
                        break;
                    }
                }
            }
        Thread.sleep(20);
        }
    }
}