package org.academiadecodigo.cachealots.runner.character;

import org.academiadecodigo.cachealots.runner.blocks.BlockType;
import org.academiadecodigo.cachealots.runner.grid.Grid;

public class CharacterFactory {

    private Grid grid;

    public CharacterFactory(Grid grid) {
        this.grid = grid;
    }

    public Character getNewCharacter() {

        int random = (int) (Math.random() * BlockType.values().length);
        CharacterType characterType = CharacterType.values()[random];
        return new Character(characterType, this.grid);
    }




}
