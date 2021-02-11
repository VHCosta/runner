package org.academiadecodigo.cachealots.runner;

import org.academiadecodigo.cachealots.runner.character.Character;
import org.academiadecodigo.cachealots.runner.character.CharacterType;
import org.academiadecodigo.cachealots.runner.grid.Grid;
import org.academiadecodigo.cachealots.runner.grid.Movement;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;

import static java.lang.Thread.sleep;

public class Game {

    public boolean jumping;

    public static Grid grid;
    public static int timer = -1;

    private Keyboard keyboard;
    private RunnerKeyboardHandler handler;
    private Rectangle rectangleHideLeft;
    private Rectangle rectangleHideRight;
    private Movement movement;


    public Rectangle characterShape;
    public Character character;

    public boolean isJumping;


    private Rectangle testAttacker;


    public Game() {

    }

        public void init(){

            grid = new Grid();

            rectangleHideLeft = new Rectangle(0,0,grid.PADDING, grid.getHeight()+ grid.PADDING);
            rectangleHideLeft.setColor(Color.WHITE);
            rectangleHideRight = new Rectangle(grid.getWidth()+ grid.PADDING,0,grid.PADDING*5, grid.getHeight());
            rectangleHideRight.setColor(Color.WHITE);


            character = new Character(CharacterType.ALEX, grid);

           // characterShape = new Rectangle((3 * grid.getCellSize()) + grid.getPadding(), (grid.getHeight() - (2.5 * grid.getCellSize())) + grid.getY(), grid.getCellSize(), grid.getCellSize());
           // characterShape.setColor(Color.BLUE);

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
            //characterShape.fill();
            character.getSprite().draw();


            testAttacker.fill();
            rectangleHideLeft.fill();
            rectangleHideRight.fill();

            //Move all
            moveAll();

        }
    }

    public void moveAll(){
       // for (int i = 0; i<listadeblocos; i++) {
       //movement.playerMove();
       // movement.blocksMove();


      //  comparador de Crashes();}
    }
}
/*
*private void comparadorCrashes(){   comparador jog dos carros


        for(int x = 0; x < cars.length; x++){
        int rolX; int colX; int colY; int rolY;

            rolX = cars[x].getPos().getRow();
            colX = cars[x].getPos().getCol();

            for(int y = 0; y < cars.length; y++){
                if(cars[x].equals(cars[y])){
                    continue;
                }
                rolY = cars[y].getPos().getRow();
                colY = cars[y].getPos().getCol();

                if(rolX == rolY && colX == colY){
                    cars[x].setCrashed(true);
                    cars[y].setCrashed(true);
                }

            }

        }
    }
*
*
 */