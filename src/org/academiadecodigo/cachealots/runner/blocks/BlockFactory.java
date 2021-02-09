package org.academiadecodigo.cachealots.runner.blocks;

import org.academiadecodigo.cachealots.runner.grid.Grid;
import org.academiadecodigo.cachealots.runner.grid.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class BlockFactory {

    // Manufactures new random Block
    //return a new block

    public static Block getNewBlock(Grid grid) {

        Block block = new Block(grid);


        return block;


        /*int random = (int) (Math.random() * BlockType.values().length);
        BlockType blockType = BlockType.values()[random];

        Block block;

        switch (blockType) {
            case FAT_BLOCK:
                block = new FatBlock();
                break;
            case DOUBLE_BLOCK:
                block = new DoubleBlock();
                break;
            case SINGLE_BLOCK:
                block = new SingleBlock();
                break;
            default:
                block = new SingleBlock();
        }

        return block; */


    }
}
