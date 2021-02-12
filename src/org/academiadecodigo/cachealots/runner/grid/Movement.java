package org.academiadecodigo.cachealots.runner.grid;

import org.academiadecodigo.cachealots.runner.Game;
import org.academiadecodigo.cachealots.runner.blocks.Block;
import org.academiadecodigo.cachealots.runner.character.Character;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import static java.lang.Thread.sleep;


public class Movement {


    private Grid grid;
    private Game game;
    private Block block;
    private Character character;

    public final int JUMP_HEIGHT = 150;
    public final int FLOOR_HEIGHT = 246;

    public Movement(Grid grid, Character character) {
        this.grid = grid;
        this.character = character;

    }

    public Movement(Grid grid, Block block) {
        this.grid = grid;
        this.block = block;
    }

    public void moveDown(double distance) {
        character.getSprite().translate(0, distance);
    }

    public void moveUp(double distance) {
        character.getSprite().translate(0, -distance);
    }

    public void moveRight(int distance) {
        character.getSprite().translate(10, 0);
    }

    public void moveLeft(int distance) {
        character.getSprite().translate(-13, 0);
    }


    public void moveBlock(Direction dir) {
        block.getSprite().translate(-5, 0);
    }

    public void move(Direction dir) {
        switch (dir) {
            case UP:
                character.getSprite().translate(0, -4);
                break;
            case DOWN:
                int currentPosition = character.getSprite().getY();
                if (character.getSprite().getY() > character.getInitialPos()) {
                    character.getSprite().translate(0, character.getInitialPos() - currentPosition - 4);
                }
                character.getSprite().translate(0, 5);
                break;
            case LEFT:
                character.getSprite().translate(-5, 0);
                break;
            case RIGHT:
                character.getSprite().translate(5, 0);
                break;
            case NONE:
                break;
        }
    }

}
