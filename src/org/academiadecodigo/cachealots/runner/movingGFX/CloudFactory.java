package org.academiadecodigo.cachealots.runner.movingGFX;

import org.academiadecodigo.cachealots.runner.Game;
import org.academiadecodigo.cachealots.runner.blocks.Block;

import java.util.AbstractSequentialList;
import java.util.Iterator;
import java.util.LinkedList;

public class CloudFactory {


    private AbstractSequentialList<Cloud> cloudList = new LinkedList<>();

    public void clearCloudList() {
        cloudList.clear();
    }

    public void create(){
        cloudList.add(new Cloud(Game.grid));
    }

    public boolean hasNext(){
        return cloudList.iterator().hasNext();
    }

    public void delete(Cloud cloud) {
        cloudList.remove(cloud);
    }

    public void removeOffscreenClouds(){

        for (int i = 0; i < cloudList.size(); i++) {
            Cloud cloud = cloudList.get(i);

            if (!cloud.isOnScreen()) {
                delete(cloud);
            }
        }
    }

    public Iterator<Cloud> iterator() {
        return cloudList.listIterator();
    }
}
