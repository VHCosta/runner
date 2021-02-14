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
            //System.out.println(menu.startBox.getY());
            //System.out.println("bruh");
            //System.out.println(menu.startBox.getY()+menu.startBox.getHeight());
            //System.out.println(mouseEvent.getY());
            for (int j = menu.startBox.getY() + 25; j < menu.startBox.getY() + 25 +menu.startBox.getHeight(); j++) {
                for (int i = menu.startBox.getX(); i < menu.startBox.getX()+menu.startBox.getWidth(); i++) {
                    if (i == mouseEvent.getX() && j == mouseEvent.getY()) {
                        game.setRunning(true);
                        game.setInMenu(false);
                        game.hideMenu();
                    }
                }
            }

            for (int j = menu.quitBox.getY() + 25; j < menu.quitBox.getY() + 25 +menu.quitBox.getHeight(); j++) {
                for (int i = menu.quitBox.getX(); i < menu.quitBox.getX()+menu.quitBox.getWidth(); i++) {
                    if (i == mouseEvent.getX() && j == mouseEvent.getY()) {
                      System.exit(0);

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