package org.academiadecodigo.cachealots.runner;

import org.academiadecodigo.bootcamp.Sound;
import org.academiadecodigo.cachealots.runner.character.Character;
import org.academiadecodigo.cachealots.runner.character.CharacterType;
import org.academiadecodigo.cachealots.runner.blocks.Block;
import org.academiadecodigo.cachealots.runner.blocks.BlockFactory;
import org.academiadecodigo.cachealots.runner.grid.Grid;
import org.academiadecodigo.cachealots.runner.grid.Movement;
import org.academiadecodigo.cachealots.runner.movingGFX.*;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.Iterator;

public class Game {

    private Grid grid;
    private Menu menu;
    private static int timer = -1;
    private static int delay = 30;
    private static int level = 0;
    private static int blockToLvUp = 0;

    private boolean running;
    private boolean inMenu;
    private boolean gameOver;
    private boolean gameOverLogged;

    public Character character;

    private Keyboard keyboard;
    private RunnerKeyboardHandler keyboardHandler;
    private Mouse mouse;
    private RunnerMouseHandler mouseHandler;

    private Rectangle rectangleHideLeft;
    private Movement movement;
    private MovingGround ground;

    private CloudBackground cloudBackground;

    private BlockFactory blockFactory;

    private Text levelHUD;
    private Text scoreHUD;
    private Text tryAgain;
    private Text tryAgain2;


    private Picture levelUpPicture;
    private Picture gameOverLogo;

    private Sound whatIsLoveMusic = new Sound("/resources/what is love.wav");
    private Sound funkNaruto = new Sound("/resources/Sadness.wav");

    public void initTools() {

        grid = new Grid();
        menu = new Menu(grid);

        grid.init();

        keyboardHandler = new RunnerKeyboardHandler(grid,this);
        keyboard = new Keyboard(keyboardHandler);
        keyboard.addEventListener(KeyboardEvent.KEY_SPACE, KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(KeyboardEvent.KEY_Q, KeyboardEventType.KEY_PRESSED);


        mouseHandler = new RunnerMouseHandler(menu, this);
        mouse = new Mouse(mouseHandler);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);

    }

    public void initGFX() {

        cloudBackground = new CloudBackground(grid);
        ground = new MovingGround(grid);
        blockFactory = new BlockFactory(grid);

        character = new Character(CharacterType.MARIO, grid);
        movement = new Movement(grid, character);

        rectangleHideLeft = new Rectangle(0, 0, grid.PADDING, grid.getHeight() + grid.PADDING);
        rectangleHideLeft.setColor(Color.WHITE);

        gameOverLogo = new Picture(0, 0, "resources/gameover2.png");
        gameOverLogo.translate((double) (grid.getWidth()/2 - gameOverLogo.getWidth()/2), (double) (grid.getHeight()/3 - gameOverLogo.getHeight()/2));

        levelUpPicture = new Picture(grid.CELL_SIZE * 11, grid.CELL_SIZE * 2, "resources/pikachu-meme.png");

        levelHUD = new Text(grid.CELL_SIZE, grid.CELL_SIZE, "");
        levelHUD.grow(10, 10  );

        scoreHUD = new Text(grid.CELL_SIZE, grid.CELL_SIZE * 2, "");
        scoreHUD.grow(10, 10  );

    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public void hideMenu() {
        menu.hideStart();
    }

    public void start() {

        initTools();
        initGFX();

        cloudBackground.deleteSprite();
        ground.deleteSprite();
        character.deleteSprite();
        menu.init();
        inMenu = true;

        whatIsLoveMusic.play(true);


        while (true) {

            try { Thread.sleep(delay); }
            catch (InterruptedException e) { e.printStackTrace(); }

            if(running){

                timer++;
                if (timer == 0) {
                    grid.changeBackground();
                    cloudBackground.getSprite().draw();
                    ground.getSprite().draw();
                    character.getSprite().draw();
                }

                levelHUD.setText("Level: " + level);
                levelHUD.draw();
                levelHUD.setColor(Color.WHITE);

                scoreHUD.setText("Score: " + blockFactory.getBlockCounter());
                scoreHUD.draw();
                scoreHUD.setColor(Color.WHITE);

                if (timer % 8 == 0) cloudBackground.update();
                if (timer % 2 == 0) ground.update();
                if (timer % 3 == 0) character.update();

                double x = (Math.ceil(Math.random() * 4)) * 45;
                if (timer % x == 0) blockFactory.create();

                if (timer % 3 == 0) collisionDetector();
                if (230 < character.getSprite().getY()) character.setSingleJump(true);

                rectangleHideLeft.fill();

                blockFactory.removeOffscreenBlocks();

                levelUp(blockFactory.getBlockCounter());

                moveAll();

            }

            if(gameOver) {

                if(gameOverLogged) {
                    tryAgain = new Text(0, 0, "Press SPACE to try again!");
                    tryAgain2 = new Text(0, 0, "Press Q to exit.");

                    tryAgain.setColor(Color.WHITE);
                    tryAgain2.setColor(Color.WHITE);

                    tryAgain.translate((double) grid.getWidth()/2 - (double) tryAgain.getWidth()/2, (double) grid.getHeight()/2 + (double) tryAgain.getHeight() * 2);
                    tryAgain2.translate((double) grid.getWidth()/2 - (double) tryAgain2.getWidth()/2, (double) grid.getHeight()/2 + (double) tryAgain.getHeight() * 3);

                    tryAgain.draw();
                    tryAgain2.draw();


                    gameOverLogo.draw();
                    whatIsLoveMusic.stop();
                    funkNaruto.play(true);
                    System.out.println("Game Over");
                    System.out.println("Your Score: " + blockFactory.getBlockCounter());
                    gameOverLogged = false;
                }

            }

        }

    }

    public void reset() {

        Iterator<Block> itBlocks = blockFactory.iterator();
        while (itBlocks.hasNext()) itBlocks.next().getSprite().delete();

        blockFactory.clearBlockList();

        gameOverLogo.delete();
        tryAgain.delete();
        tryAgain2.delete();
        levelUpPicture.delete();

        levelHUD.delete();
        scoreHUD.delete();

        ground.deleteSprite();
        cloudBackground.deleteSprite();
        character.deleteSprite();

        initGFX();

        running = true;
        funkNaruto.stop();
        whatIsLoveMusic.play(true);

        gameOver = false;
        timer = -1;
        delay = 30;
        level= 0;
        blockToLvUp = 0;

    }

    public void moveAll(){
        Iterator<Block> it = blockFactory.iterator();
        while (it.hasNext()) {
            Block b = it.next();
            if(b.isOnScreen()) b.move();
        }
        character.moveFlow();
    }

    private void collisionDetector() {


        for (int Xcharacter = character.getSprite().getX(); Xcharacter < (character.getSprite().getX() + character.getSprite().getWidth()); Xcharacter++) {
            for (int Ycharacter = character.getSprite().getY(); Ycharacter < (character.getSprite().getY() + character.getSprite().getHeight()); Ycharacter++) {

                for (Iterator<Block> it = blockFactory.iterator(); it.hasNext(); ) {
                    Block block = it.next();

                    for (int Xblock = block.getX(); Xblock < (block.getX() + block.getWidth()); Xblock++) {
                        for (int Yblock = block.getY(); Yblock < (block.getY() + block.getHeight()); Yblock++) {
                            if (Xcharacter == Xblock && Ycharacter == Yblock) {
                                gameOver = true;
                                running = false;
                                gameOverLogged = true;
                            }
                        }
                    }
                }
            }
        }
    }

    private void levelUp(int score) {

        if(score == blockToLvUp ) {
            //System.out.println("You are in level " + level);
            level++;
            delay -= 2;
            blockToLvUp += 7;

            if(blockToLvUp > 8) {
                levelUpPicture.draw();

                try { Thread.sleep(300); }
                catch (InterruptedException e) { e.printStackTrace(); }

                levelUpPicture.delete();
            }
        }
    }

    public boolean isInMenu() {
        return inMenu;
    }

    public void setInMenu(boolean inMenu) {
        this.inMenu = inMenu;
    }
}
