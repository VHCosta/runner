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
        handler = new RunnerKeyboardHandler(characterShape, grid);
        keyboard = new Keyboard(handler);
        move = new Movement(keyboard, handler, grid);
        //TODO: replace with call to BlockFactory.createBlock();
        //floorShape = new Rectangle(grid.getPadding(), (grid.getHeight() - (2 * grid.getCellSize())) + grid.getY(), grid.getWidth(), (1 * grid.getCellSize()) - grid.getPadding());
        //floorShape.setColor(Color.DARK_GRAY);
    }
    public void start(){
        grid.init();
        characterShape.fill();
        rectangleHide.fill();
        move.simpleMovement();
        //floorShape.draw();
    }
}//end of Game class