package org.academiadecodigo.cachealots.runner.character;

import org.academiadecodigo.cachealots.runner.blocks.BlockType;

public class CharacterFactory {


    public static Character getNewCharacter() {

        int random = (int) (Math.random() * BlockType.values().length);
        CharacterType characterType = CharacterType.values()[random];

//        return new Character(characterType);
        return null;
    }




}
