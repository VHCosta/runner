package org.academiadecodigo.cachealots.runner;

import org.academiadecodigo.cachealots.runner.character.Character;
import org.academiadecodigo.cachealots.runner.character.CharacterType;
import org.academiadecodigo.cachealots.runner.blocks.Block;
import org.academiadecodigo.cachealots.runner.blocks.BlockFactory;
import org.academiadecodigo.cachealots.runner.grid.Grid;
import org.academiadecodigo.cachealots.runner.grid.Movement;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;

import java.util.Iterator;


public class Game {


    public static Grid grid;
    public static int timer = -1;

    private Keyboard keyboard;
    private RunnerKeyboardHandler handler;
    private Rectangle rectangleHideLeft;
    private Rectangle rectangleHideRight;
    private Movement movement;

    public BlockFactory factory;

    public Character character;

    private Rectangle testAttacker;


    public void init(){

        grid = new Grid();
        factory = new BlockFactory();

        rectangleHideLeft = new Rectangle(0,0,grid.PADDING, grid.getHeight()+ grid.PADDING);
        rectangleHideLeft.setColor(Color.WHITE);
        rectangleHideRight = new Rectangle(grid.getWidth()+ grid.PADDING,0,grid.PADDING*5, grid.getHeight());
        rectangleHideRight.setColor(Color.WHITE);


        character = new Character(CharacterType.ALEX, grid);

        testAttacker = new Rectangle((grid.getWidth() - grid.getCellSize()) + grid.getPadding()*5, (grid.getHeight() - (2.5 * grid.getCellSize())) + grid.getY(), grid.getCellSize(), grid.getCellSize());
        testAttacker.setColor(Color.BLACK);

        movement = new Movement(grid, character, this);
        handler = new RunnerKeyboardHandler(grid, this);
        handler.setMovement(movement);
        keyboard = new Keyboard(handler);
        keyboard.addEventListener(KeyboardEvent.KEY_SPACE, KeyboardEventType.KEY_PRESSED);

    /* iniciar a lista de blocos attacker que vai ser a mesma
    de todos os niveis com veloc dif
     */
    }


    public void start() throws InterruptedException {
        double t0 = 0;

        while(true) {

            //Game Clock for all movements
            Thread.sleep(30);
            timer++;

            // Update screen draws
            grid.init();
            rectangleHideLeft.fill();
            rectangleHideRight.fill();
            //characterShape.fill();
            character.getSprite().draw();

            //Create obstacle blocks every 50 loops
            if(timer % 100 == 0){
                factory.create();
            }


            factory.removeOffscreenBlocks();


            //Move all
            moveAll();

        }
    }

    public void moveAll(){

        for (Iterator<Block> it = factory.iterator(); it.hasNext(); ) {
            Block b = it.next();
            if(b.isOnScreen()){
                b.move();
            }
        }

    }
}