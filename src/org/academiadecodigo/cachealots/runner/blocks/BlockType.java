package org.academiadecodigo.cachealots.runner.blocks;

public enum BlockType {

    BLOCK(4),
    DOUBLE_BLOCK(3),
    FAT_BLOCK(2);


    private int speed;

    BlockType(int speed){
            this.speed = speed;
    }

}
