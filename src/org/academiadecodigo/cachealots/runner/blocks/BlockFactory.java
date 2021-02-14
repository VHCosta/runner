package org.academiadecodigo.cachealots.runner.blocks;

import org.academiadecodigo.cachealots.runner.Game;
import org.academiadecodigo.cachealots.runner.grid.Grid;

import java.util.AbstractSequentialList;
import java.util.Iterator;
import java.util.LinkedList;

public class BlockFactory {


    private AbstractSequentialList<Block> blockList = new LinkedList<>();
    public int blockCounter=0;

    private Grid grid;

    public BlockFactory(Grid grid) {
        this.grid = grid;
    }

    public void clearBlockList(){
        blockList.clear();
    }

    public void create(){
        blockList.add(new Block(grid));
    }


    public boolean hasNext(){
        return blockList.iterator().hasNext();
    }

    public void delete(Block block) {
        blockList.remove(block);
    }

    public void removeOffscreenBlocks(){

        for (int i = 0; i < blockList.size(); i++) {
            Block block = blockList.get(i);

            if (!block.isOnScreen()) {
                delete(block);
                blockCounter++;
            }
        }
    }

    public int getBlockCounter() {
        return blockCounter;
    }

    public Iterator<Block> iterator() {
        return blockList.listIterator();
    }
}
