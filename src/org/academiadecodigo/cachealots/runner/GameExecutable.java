package org.academiadecodigo.cachealots.runner;

public class GameExecutable {

    public static void main(String[] args) {

        Game runner = new Game(20, 12);

        try {
            runner.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }//end of main()

}//end of GameExecutable class
