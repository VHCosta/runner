package org.academiadecodigo.cachealots.runner.grid;

import org.academiadecodigo.cachealots.runner.Game;
import org.academiadecodigo.cachealots.runner.RunnerKeyboardHandler;
import org.academiadecodigo.cachealots.runner.character.Character;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;

import static java.lang.Thread.sleep;


public class Movement {


    private Grid grid;
    private Game game;

    private Character character;



    public boolean reachTheTop = false;
    public int jumpHigh = 180;
    public int floorHigh = 245;




    public Movement(Grid grid, Character character, Game game){
        this.game = game;
        this.grid = grid;
        this.character = character;

    }


    public void moveDown(int distance){
        character.getSprite().translate(0, 10);
    }
    public void moveUp(int distance){
        character.getSprite().translate(0, -10);
    }
    public void moveRight(int distance){
        character.getSprite().translate(10, 0);
    }
    public void moveLeft(int distance){
        character.getSprite().translate(-10, 0);
    }

    public void setReachTheTop(boolean reachTheTop) {
        this.reachTheTop = reachTheTop;
    }


    public void jumping(boolean reachTheTop, Rectangle characterRectangle) {


        if(!reachTheTop && (characterRectangle.getY() > jumpHigh)){
            moveUp(65);
        }
        if(characterRectangle.getY() > jumpHigh){
            setReachTheTop(true);
        }
        if(reachTheTop && (characterRectangle.getY() < floorHigh)){
            moveDown(65);
        }
        if(characterRectangle.getY() == floorHigh){
            setReachTheTop(false);
        }
    }



    public void blocksMove() {
    }


    public void playerMove(boolean jumping) {
        if (jumping) {
            moveUp(1);
        } else if(!jumping){
            moveDown(1);
        } else {}
    }
}
