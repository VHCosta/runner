package org.academiadecodigo.cachealots.runner.blocks;

import org.academiadecodigo.cachealots.runner.grid.Position;

public class Block {  // class with the characteristics of the running blocks

    private int speed;
    private Position pos;
    private BlockType type;

    public Block(BlockType type){
        this.pos = pos;
        this.speed = speed;
        this.type = type;
    }

    public int getSpeed() {
        return speed;
    }

    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }



}//end of Block class
