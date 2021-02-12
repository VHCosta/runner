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

    private Keyboard keyboard;
    private RunnerKeyboardHandler handler;
    private Rectangle rectangleHideLeft;
    private Rectangle rectangleHideRight;
    private Movement movement;

    public BlockFactory factory;
    public Character character;

    private boolean running;

    private Picture gameOver1;
    private Picture gameOver2;
    private Picture gameOver3;


    public void init(){

        grid = new Grid();
        factory = new BlockFactory();

        rectangleHideLeft = new Rectangle(0,0,grid.PADDING, grid.getHeight()+ grid.PADDING);
        rectangleHideLeft.setColor(Color.WHITE);
        rectangleHideRight = new Rectangle(grid.getWidth()+ grid.PADDING,0,grid.PADDING*5, grid.getHeight());
        rectangleHideRight.setColor(Color.WHITE);

        character = new Character(CharacterType.MARIO, grid);

        movement = new Movement(grid, character);
        handler = new RunnerKeyboardHandler(grid, this);
        handler.setMovement(movement);
        keyboard = new Keyboard(handler);
        keyboard.addEventListener(KeyboardEvent.KEY_SPACE, KeyboardEventType.KEY_PRESSED);

        gameOver1 = new Picture(grid.CELL_SIZE * 2, grid.CELL_SIZE * 1.5, "resources/willzim.png");
        gameOver2 = new Picture(grid.CELL_SIZE * 5, grid.CELL_SIZE * 1.5, "resources/gameover2.png");



    /* iniciar a lista de blocos attacker que vai ser a mesma
    de todos os niveis com veloc dif
     */
    }

    public void start() throws InterruptedException {

        running = true;

        while(true) {

            //Game Clock for all movements
            Thread.sleep(20);
            timer++;

            // Update screen draws
            grid.init();
            character.getSprite().draw();
            rectangleHideRight.fill();

            //Create obstacle blocks every x loops
            int x = (int) (Math.random() * 10) + 90;

            if(timer % 50 == 0){
                factory.create();
            }
            rectangleHideLeft.fill();

            factory.removeOffscreenBlocks();

            //Move all
            collisionDetector();

            if(running){
                moveAll();
            } else break;


        }
        gameOver1.draw();
        gameOver2.draw();
        System.out.println("Game Over");

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

    private void collisionDetector() throws InterruptedException {



        for (int Xcharacter = character.getSprite().getX(); Xcharacter<character.getSprite().getX() + character.getSprite().getWidth(); Xcharacter++){
            for (int Ycharacter = character.getSprite().getY(); Ycharacter<character.getSprite().getY() + character.getSprite().getHeight(); Ycharacter++){

                for (Iterator<Block> it = factory.iterator(); it.hasNext(); ) {
                    Block block = it.next();

                    for (int Xblock = block.getX(); Xblock<block.getX() + block.getWidth(); Xblock++){
                        for (int Yblock = block.getY(); Yblock<block.getY() + block.getHeight(); Yblock++){
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

