package org.academiadecodigo.cachealots.runner;

import org.academiadecodigo.cachealots.runner.grid.Grid;
import org.academiadecodigo.cachealots.runner.grid.Position;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Thuri {

    /*package org.academiadecodigo.cachealots.runner.blocks;

import org.academiadecodigo.cachealots.runner.grid.Grid;
import org.academiadecodigo.cachealots.runner.grid.Position;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


    public class Block{  // class with the characteristics of the running blocks

        private Rectangle obstacle;
        private Position pos;
        //private BlockType type;

        public Block(Grid grid, int col, int row){
            this.pos = pos;
            this.grid = grid;
            Rectangle obstacle  = new Rectangle(grid.getWidth() - 1), (grid.getHeight() - (2.5 * grid.getCellSize())) + grid.getY(), grid.getCellSize(), grid.getCellSize();


            //this.type = type;
        }


        public Position getPos() {
            return pos;
        }

        public void setPos(Position pos) {
            this.pos = pos;
        }



    }//end of Block class
}

public enum BlockType{

    SINGLE_BLOCK,
    DOUBLE_BLOCK,
    FAT_BLOCK;


}

public class BlockFactory {

    // Manufactures new random Block
    //return a new block

    public static Block getNewBlock(Grid grid) {

        int random = (int) (Math.random() * BlockType.values().length);
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

        return block;
    }

    //new Rectangle((grid.getWidth() - 1), (grid.getHeight() - (2.5 * grid.getCellSize())) + grid.getY(), grid.getCellSize(), grid.getCellSize());
}


     */
