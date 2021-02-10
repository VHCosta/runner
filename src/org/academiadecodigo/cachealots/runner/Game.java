package org.academiadecodigo.cachealots.runner;

import org.academiadecodigo.cachealots.runner.character.Character;
import org.academiadecodigo.cachealots.runner.character.CharacterType;
import org.academiadecodigo.cachealots.runner.grid.Grid;
import org.academiadecodigo.cachealots.runner.grid.Movement;
import org.academiadecodigo.cachealots.runner.movingGFX.MovingGround;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Game {

    private Grid grid;
    private Keyboard keyboard;
    private RunnerKeyboardHandler handler;
    private Rectangle rectangleHide;
    private Movement move;
    private Character character;
    private MovingGround ground;

    public Game(int cols, int rows) {

        grid = new Grid(cols, rows);

        character = new Character(CharacterType.ALEX, grid);

        rectangleHide = new Rectangle(0,0,grid.PADDING, grid.getHeight()+ grid.PADDING);
        rectangleHide.setColor(Color.WHITE);

        handler = new RunnerKeyboardHandler(grid, character);
        handler.setMovement(move);
        keyboard = new Keyboard(handler);

        move = new Movement(keyboard, handler, grid, character);
        ground = new MovingGround(grid);

    }



    public void start() throws InterruptedException {

        //initialize the grid
        grid.init();

        //draw char sprite
        character.getSprite().draw();

        //shape to hide left side of screen
        rectangleHide.fill();

        //add listeners
        move.addListeners();

        ground.drawGround();






        //game loop
        while(true){ //while game is not over


            //jumping mechanic
            while(character.isJumping()){

                //upwards
                for (int i = 0; i < 18; i++) {
                    move.moveUp( grid.CELL_SIZE/4);
                    Thread.sleep(20);
                }

                //downwards
                for (int i = 0; i < 18; i++) {
                    move.moveDown(grid.CELL_SIZE/4);
                    Thread.sleep(12);
                }

                character.setJumping(false);

            }

        Thread.sleep(20);

        }

    }
}