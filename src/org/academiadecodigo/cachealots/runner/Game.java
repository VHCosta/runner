package org.academiadecodigo.cachealots.runner;

import org.academiadecodigo.cachealots.runner.character.Character;
import org.academiadecodigo.cachealots.runner.character.CharacterType;
import org.academiadecodigo.cachealots.runner.blocks.Block;
import org.academiadecodigo.cachealots.runner.blocks.BlockFactory;
import org.academiadecodigo.cachealots.runner.grid.Grid;
import org.academiadecodigo.cachealots.runner.grid.Movement;
import org.academiadecodigo.cachealots.runner.movingGFX.*;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.Iterator;

public class Game {


    public static Grid grid;
    public static int timer = -1;
    private boolean running;
    public Character character;

    private Keyboard keyboard;
    private RunnerKeyboardHandler handler;

    private Rectangle rectangleHideLeft;
    private Movement movement;
    private MovingGround ground;

    private CloudBackground cloudBackground;

    private CloudFactory cloudFactory;
    private BlockFactory blockFactory;


    private Picture gameOver1;
    private Picture gameOver2;
    private Picture gameOver3;

    public void initTools() {

        grid = new Grid();
        grid.init();

        cloudBackground = new CloudBackground(grid);
        cloudFactory = new CloudFactory();
        blockFactory = new BlockFactory();

        character = new Character(CharacterType.MARIO, grid);

        movement = new Movement(grid, character);
        handler = new RunnerKeyboardHandler(grid,this);
        handler.setMovement(movement);
        keyboard = new Keyboard(handler);
        keyboard.addEventListener(KeyboardEvent.KEY_SPACE, KeyboardEventType.KEY_PRESSED);


    }

    public void init() {

        character = new Character(CharacterType.MARIO, grid);


        ground = new MovingGround(grid);

        rectangleHideLeft = new Rectangle(0, 0, grid.PADDING, grid.getHeight() + grid.PADDING);
        rectangleHideLeft.setColor(Color.WHITE);

        gameOver1 = new Picture(grid.CELL_SIZE * 2, grid.CELL_SIZE * 1.5, "resources/willzim.png");
        gameOver2 = new Picture(grid.CELL_SIZE * 5, grid.CELL_SIZE * 1.5, "resources/gameover2.png");

    }

    public boolean isRunning() {
        return running;
    }

    public void start() throws InterruptedException {
        running = true;
        initTools();
        init();
        cloudBackground.initSprite();
        cloudBackground.show();
        ground.drawGround();

        while(true) {

            //Game Clock for all movements
            Thread.sleep(30);
            timer++;

            if(timer % 8 == 0) cloudBackground.show();
            if(timer % 2 == 0) ground.drawGround();
            character.getSprite().draw();

            //Create obstacle blocks every x loops
            int blockRNG = (int) (Math.ceil(Math.random() * 3) * 45);
            if(timer % blockRNG == 0){
                blockFactory.create();
            }

            rectangleHideLeft.fill();
            blockFactory.removeOffscreenBlocks();

            //Move all
            if(timer % 3 == 0) collisionDetector();

            if (timer % 20 == 0){
                Iterator<Cloud> it = cloudFactory.iterator();
                while (it.hasNext()) {
                    Cloud cb = it.next();
                    if(cb.isOnScreen()) cb.move();
                }
            }

            if(running){
                if(230 < character.getSprite().getY() ) character.setSingleJump(true);
                moveAll();
            } else break;
        }

        gameOver2.draw();
        System.out.println("Game Over");
    }

    public void reset() throws InterruptedException {
        gameOver2.delete();

        Thread.sleep(20);
        System.out.println("reset clouds");
        Iterator<Cloud> itClouds = cloudFactory.iterator();
        while (itClouds.hasNext()) itClouds.next().getSprite().delete();
        cloudFactory.clearCloudList();


        Thread.sleep(20);
        System.out.println("reset blocks");
        Iterator<Block> itBlocks = blockFactory.iterator();
        while (itBlocks.hasNext()) itBlocks.next().getSprite().delete();
        blockFactory.clearBlockList();

        Thread.sleep(20);
        System.out.println("reset cloud bg");
        cloudBackground.resetSprite();
        cloudBackground.initSprite();

        Thread.sleep(20);
        System.out.println("reset char sprite");
        character.getSprite().delete();
        character.resetSprite();


        Thread.sleep(20);
        System.out.println("reset gameOver picture");
        init();
        start();

    }


    public void moveAll(){
        Iterator<Block> it = blockFactory.iterator();
        while (it.hasNext()) {
            Block b = it.next();
            if(b.isOnScreen()) b.move();
        }
        character.moveFlow();
    }

    private void collisionDetector() throws InterruptedException {


        for (int Xcharacter = character.getSprite().getX(); Xcharacter < (character.getSprite().getX() + character.getSprite().getWidth()); Xcharacter++) {
            for (int Ycharacter = character.getSprite().getY(); Ycharacter < (character.getSprite().getY() + character.getSprite().getHeight()); Ycharacter++) {

                for (Iterator<Block> it = blockFactory.iterator(); it.hasNext(); ) {
                    Block block = it.next();

                    for (int Xblock = block.getX(); Xblock < (block.getX() + block.getWidth()); Xblock++) {
                        for (int Yblock = block.getY(); Yblock < (block.getY() + block.getHeight()); Yblock++) {
                            if (Xcharacter == Xblock && Ycharacter == Yblock) {
                                //Game.end(true);
                                running = false;
                            }
                        }
                    }
                }
            }
        }
    }

}
