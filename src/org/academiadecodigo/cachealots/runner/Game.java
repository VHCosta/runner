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

    public boolean running;


    public void init(){

        grid = new Grid();
        factory = new BlockFactory();

        rectangleHideLeft = new Rectangle(0,0,grid.PADDING, grid.getHeight()+ grid.PADDING);
        rectangleHideLeft.setColor(Color.WHITE);
        rectangleHideRight = new Rectangle(grid.getWidth()+ grid.PADDING,0,grid.PADDING*5, grid.getHeight());
        rectangleHideRight.setColor(Color.WHITE);

        character = new Character(CharacterType.ALEX, grid);

        movement = new Movement(grid, character);
        handler = new RunnerKeyboardHandler(grid, this);
        handler.setMovement(movement);
        keyboard = new Keyboard(handler);
        keyboard.addEventListener(KeyboardEvent.KEY_SPACE, KeyboardEventType.KEY_PRESSED);

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
        for (int icharacter = character.getSprite().getX(); icharacter<character.getSprite().getX() + character.getSprite().getWidth(); icharacter++){
            for (int jcharacter = character.getSprite().getY(); jcharacter<character.getSprite().getY() + character.getSprite().getHeight(); jcharacter++){

                for (Iterator<Block> it = factory.iterator(); it.hasNext(); ) {
                    Block block = it.next();

                    for (int iblock = block.getX(); iblock<block.getX() + block.getWidth(); iblock++){
                        for (int jblock = block.getY(); jblock<block.getY() + block.getHeight(); jblock++){
                            if (icharacter == iblock && jcharacter == jblock) {
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
/*

 */