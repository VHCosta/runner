package org.academiadecodigo.cachealots.runner.blocks;

public class BlockFactory {

    // Manufactures new random Block
    //return a new block

    public static Block getNewBlock() {

        int random = (int) (Math.random() * BlockType.values().length);
        BlockType blockType = BlockType.values()[random];

       return new Block (blockType);

    }
}
