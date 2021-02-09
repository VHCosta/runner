package org.academiadecodigo.cachealots.runner.character;

public enum CharacterType {
    ALEX("resources/alex.jpg"),
    COOL("resources/"),
    MARI_YODA("resources/"),
    KIRBY("resources/"),
    DAME_TU_COSITA("resources/"),
    MARIO("resources/"),
    CACHE("resources/"),
    SPIDER("resources/");

    private String source;

    CharacterType(String source){
        this.source = source;
    }

    public String getSource() {
        return source;
    }
}
