package org.academiadecodigo.cachealots.runner;

import org.academiadecodigo.cachealots.runner.grid.Grid;
import org.academiadecodigo.cachealots.runner.grid.Movement;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

public class RunnerMouseHandler implements MouseHandler {

    private Movement movement;
    private Game game;
    private Menu menu;

    public RunnerMouseHandler(Menu menu, Game game) {
        this.game = game;
        this.menu = menu;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if(game.isInMenu()) {
            for (int j = menu.startBox.getX(); j < menu.startBox.getWidth(); j++) {
                for (int i = menu.startBox.getX(); i < menu.startBox.getWidth(); i++) {
                    if (i == mouseEvent.getX() && j == mouseEvent.getY()) {
                        game.setRunning(true);
                        game.setInMenu(false);
                        game.hideMenu();
                    }
                }
            }
        }

        if(game.isGameOver()) game.reset();
        if(game.isRunning()) game.character.setJumping(true);
    }


    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
    }

}