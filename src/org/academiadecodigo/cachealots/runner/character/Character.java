package org.academiadecodigo.cachealots.runner.character;

import org.academiadecodigo.cachealots.runner.blocks.BlockType;
import org.academiadecodigo.cachealots.runner.grid.Grid;
import org.academiadecodigo.cachealots.runner.grid.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Character {

    // class with the characteristics of the running blocks

    private boolean crashed;
    private Picture sprite;
    private Position pos;
    private CharacterType characterType;
    private Grid grid;

    public Character(CharacterType characterType, Grid grid){
        pos = new Position();

        this.grid = grid;
        this.characterType = characterType;

        this.sprite = new Picture((3 * grid.getCellSize()) + grid.getPadding(), (grid.getHeight() - (2.5 * grid.getCellSize())) + grid.getY(), characterType.getSource());
    }

    public Position getPos() {
        return pos;
    }

    public boolean isCrashed() {
        return crashed;
    }

    public void setCrashed(boolean crashed) {
        this.crashed = crashed;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }


}
