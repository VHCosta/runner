package org.academiadecodigo.cachealots.runner.character;

import org.academiadecodigo.cachealots.runner.blocks.BlockType;
import org.academiadecodigo.cachealots.runner.grid.Position;

public class Character {

    // class with the characteristics of the running blocks

    private boolean crashed;
    private Position pos;
    private CharacterType characterType;

    public Character(CharacterType characterType){
        this.pos = pos;
        this.crashed = false;
        this.characterType = characterType;
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
