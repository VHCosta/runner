package org.academiadecodigo.cachealots.runner;

import org.academiadecodigo.cachealots.runner.character.Character;
import org.academiadecodigo.cachealots.runner.character.CharacterType;
import org.academiadecodigo.cachealots.runner.blocks.Block;
import org.academiadecodigo.cachealots.runner.blocks.BlockFactory;
import org.academiadecodigo.cachealots.runner.grid.Grid;
import org.academiadecodigo.cachealots.runner.grid.Movement;
import org.academiadecodigo.cachealots.runner.movingGFX.CloudBackground;
import org.academiadecodigo.cachealots.runner.movingGFX.CloudBackgroundFactory;
import org.academiadecodigo.cachealots.runner.movingGFX.CloudFactory;
import org.academiadecodigo.cachealots.runner.movingGFX.MovingGround;
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

    private BlockFactory blockFactory;
    private CloudBackgroundFactory cloudBackgroundFactory;
    private CloudFactory cloudFactory;


    private Picture gameOver1;
    private Picture gameOver2;
    private Picture gameOver3;


    public void init() {

        grid = new Grid();
        ground = new MovingGround(grid);

        blockFactory = new BlockFactory();
        cloudBackgroundFactory = new CloudBackgroundFactory();
        cloudFactory = new CloudFactory();

        rectangleHideLeft = new Rectangle(0, 0, grid.PADDING, grid.getHeight() + grid.PADDING);
        rectangleHideLeft.setColor(Color.WHITE);

        character = new Character(CharacterType.MARIO, grid);

        movement = new Movement(grid, character);
        handler = new RunnerKeyboardHandler(grid, character ,this);
        handler.setMovement(movement);
        keyboard = new Keyboard(handler);
        keyboard.addEventListener(KeyboardEvent.KEY_SPACE, KeyboardEventType.KEY_PRESSED);

        gameOver1 = new Picture(grid.CELL_SIZE * 2, grid.CELL_SIZE * 1.5, "resources/willzim.png");
        gameOver2 = new Picture(grid.CELL_SIZE * 5, grid.CELL_SIZE * 1.5, "resources/gameover2.png");


    }

    public boolean isRunning() {
        return running;
    }

    public void start() throws InterruptedException {
        running = true;
        grid.init();
        cloudBackgroundFactory.create();
        character.getSprite().draw();
        ground.drawGround();


        while(true) {

            //Game Clock for all movements
            Thread.sleep(30);
            timer++;



            if(timer % 2 == 0) ground.drawGround();

            // Update screen draws


            //Create obstacle blocks every x loops
            int x = (int) (Math.ceil(Math.random() * 3) * 45);
            if(timer % x == 0){
                blockFactory.create();
            }


            rectangleHideLeft.fill();
            blockFactory.removeOffscreenBlocks();

            //Move all
            if(timer % 3 == 0) {
                collisionDetector();
            }

            if(running){
                if(230 < character.getSprite().getY() ){ character.setSingleJump(true);}
                moveAll();
            } else break;

        }

        //gameOver1.draw();
        gameOver2.draw();
        System.out.println("Game Over");
    }
    public void moveAll(){
        for (Iterator<Block> it = blockFactory.iterator(); it.hasNext(); ) {
            Block b = it.next();
            if(b.isOnScreen()){
                b.move();
            }
        }

        for (Iterator<CloudBackground> it = cloudBackgroundFactory.iterator(); it.hasNext();){
            CloudBackground cb = it.next();
            if(cb.isOnScreen()){
                cb.move();
            }
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
