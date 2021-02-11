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

        if(!blockList.iterator().hasNext())
            blockList.add(new Block(Game.grid));
    }

    public void delete(){
        blockList.remove();
    }

    @Override
    public Iterator<Block> iterator() {
        return blockList.listIterator();
    }
}