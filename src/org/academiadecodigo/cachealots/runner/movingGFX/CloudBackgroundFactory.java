package org.academiadecodigo.cachealots.runner.movingGFX;

import org.academiadecodigo.cachealots.runner.Game;
import org.academiadecodigo.cachealots.runner.blocks.Block;

import java.util.AbstractSequentialList;
import java.util.Iterator;
import java.util.LinkedList;

public class CloudBackgroundFactory {


    private AbstractSequentialList<CloudBackground> cloudBackgroundList = new LinkedList<>();


    public void create(){
        cloudBackgroundList.add(new CloudBackground(Game.grid));
    }

    public boolean hasNext(){
        return cloudBackgroundList.iterator().hasNext();
    }

    public void delete(CloudBackground cloudBackground) {
        cloudBackgroundList.remove(cloudBackground);
    }

    public void removeOffscreenCloudBackgrounds(){

        for (int i = 0; i < cloudBackgroundList.size(); i++) {
            CloudBackground cloudBackground = cloudBackgroundList.get(i);

            if (!cloudBackground.isOnScreen()) {
                delete(cloudBackground);
            }
        }
    }

    public Iterator<CloudBackground> iterator() {
        return cloudBackgroundList.listIterator();
    }
}
