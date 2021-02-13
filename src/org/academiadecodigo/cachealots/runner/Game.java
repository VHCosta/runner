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
import org.academiadecodigo.simplegraphics.pictures.Picture;

import javax.swing.*;
import java.util.Iterator;



public class Game {


    public static Grid grid;
    public static int timer = -1;
    public static int delay = 30;
    public static int score = 0;
    public static int level= 1;
    public static int blockToLvUp = 0;


    private Keyboard keyboard;
    private RunnerKeyboardHandler handler;
    private Rectangle rectangleHideLeft;
    private Movement movement;

    public BlockFactory factory;
    public Character character;

    private boolean running;

    private Picture levelUpPicture;
    private Picture gameOverlogo;
    private Picture gameOver3;


    public void init(){

        grid = new Grid();

        factory = new BlockFactory();

        rectangleHideLeft = new Rectangle(0,0,grid.PADDING, grid.getHeight()+ grid.PADDING);
        rectangleHideLeft.setColor(Color.WHITE);

        character = new Character(CharacterType.MARIO, grid);

        movement = new Movement(grid, character);
        handler = new RunnerKeyboardHandler(grid, this);
        handler.setMovement(movement);
        keyboard = new Keyboard(handler);
        keyboard.addEventListener(KeyboardEvent.KEY_SPACE, KeyboardEventType.KEY_PRESSED);

        levelUpPicture = new Picture(grid.CELL_SIZE * 11, grid.CELL_SIZE * 2, "resources/pikachu-meme.png");
        gameOverlogo = new Picture(grid.CELL_SIZE * 4.7, grid.CELL_SIZE * 1.5, "resources/gameover2.png");



    /* iniciar a lista de blocos attacker que vai ser a mesma
    de todos os niveis com veloc dif
     */
    }

    public void start() throws InterruptedException {

        running = true;

        while(true) {

            //Game Clock for all movements
            Thread.sleep(delay);
            timer++;

            // Update screen draws
            grid.init();
            character.getSprite().draw();

            //Create obstacle blocks every x loops
            double x = (Math.ceil(Math.random()*4))*45;

            if(timer % x == 0){
                factory.create();
            }

            rectangleHideLeft.fill();
            factory.removeOffscreenBlocks();

            //Move all
            if(timer % 3 == 0) {
                collisionDetector();
            }
            levelUp(factory.getBlockCounter());

            if(running){
                if(230 < character.getSprite().getY() ){ character.setSingleJump(true);}
                moveAll();
            } else break;


        }
        //gameOver1.draw();
        gameOverlogo.draw();
        System.out.println("Game Over");
        System.out.println("Your Score: " + factory.getBlockCounter());


    }

    public void moveAll(){

        for (Iterator<Block> it = factory.iterator(); it.hasNext(); ) {
            Block b = it.next();
            if(b.isOnScreen()){
                b.move();
            }
        }
        //character.getMovement().
        character.moveFlow();

    }

    private void collisionDetector() {


        for (int Xcharacter = character.getSprite().getX(); Xcharacter < (character.getSprite().getX() + character.getSprite().getWidth()); Xcharacter++){
            for (int Ycharacter = character.getSprite().getY(); Ycharacter < (character.getSprite().getY() + character.getSprite().getHeight()); Ycharacter++){

                for (Iterator<Block> it = factory.iterator(); it.hasNext(); ) {
                    Block block = it.next();

                    for (int Xblock = block.getX(); Xblock < (block.getX() + block.getWidth()); Xblock++){
                        for (int Yblock = block.getY(); Yblock < (block.getY() + block.getHeight()); Yblock++){
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

    public boolean isRunning() {
        return running;
    }

    private void levelUp(int score) throws InterruptedException {


        if(score == blockToLvUp ) {
            System.out.println("You are in level " + level);
            level++;
            delay -= 2;
            blockToLvUp += 7;
            if(blockToLvUp > 8) {
                levelUpPicture.draw();
                Thread.sleep(700);
                levelUpPicture.delete();
            }


        }

    }



}
