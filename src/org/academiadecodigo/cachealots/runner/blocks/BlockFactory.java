package org.academiadecodigo.cachealots.runner.blocks;

import org.academiadecodigo.cachealots.runner.Game;
import org.academiadecodigo.cachealots.runner.grid.Grid;
import org.academiadecodigo.cachealots.runner.grid.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.*;


public class BlockFactory implements Iterable<Block>{


    private LinkedList<Block> blockList = new LinkedList<>();


    public void create(){
        blockList.add(new Block(Game.grid));


    }

    public boolean hasNext(){
        return blockList.iterator().hasNext();
    }

    public void delete(){
        blockList.remove();
    }

    public void removeOffscreenBlocks(){

        for (Block block: blockList){

            if (!block.isOnScreen()){
                System.out.println(block);
                delete();
                System.out.println(block);
            }
            System.out.println(blockList);
        }
    }


    @Override
    public Iterator<Block> iterator() {
        return blockList.listIterator();
    }
}
