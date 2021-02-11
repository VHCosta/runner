package org.academiadecodigo.cachealots.runner.blocks;

import org.academiadecodigo.cachealots.runner.Game;

import java.util.AbstractSequentialList;
import java.util.Iterator;
import java.util.LinkedList;

public class BlockFactory {


    private AbstractSequentialList<Block> blockList = new LinkedList<>();



    public void create(){
        blockList.add(new Block(Game.grid));
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
                System.out.println(block);
                delete(block);
                System.out.println(block);
            }
            System.out.println(blockList);
        }
    }

    public Iterator<Block> iterator() {
        return blockList.listIterator();
    }
}
