package org.academiadecodigo.cachealots.runner.character;
import org.academiadecodigo.cachealots.runner.grid.Direction;
import org.academiadecodigo.cachealots.runner.grid.Grid;
import org.academiadecodigo.cachealots.runner.grid.Movement;
import org.academiadecodigo.cachealots.runner.grid.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;
public class Character {

    // class with the characteristics of the running blocks
    private Picture sprite;
    private CharacterType characterType;
    private Grid grid;

    private Movement movement;
    private Direction CurrentDirection;

    private boolean jumping;
    private boolean crashed;

    public boolean reachTheTop = false;
    public int jumpHigh = 180;
    public int floorHigh = 245;

    public void setReachTheTop(boolean reachTheTop) {
        this.reachTheTop = reachTheTop;
    }


    public Character(CharacterType characterType, Grid grid){
        this.grid = grid;
        this.characterType = characterType;
        this.sprite = new Picture((3 * grid.getCellSize()) + grid.getPadding(), (grid.getHeight() - (2.5 * grid.getCellSize())) + grid.getY(), characterType.getSource());
    }


    public boolean isCrashed() {
        return crashed;
    }

    public boolean isJumping() {
        return jumping;
    }

    public void setJumping(boolean jumping) {
        this.jumping = jumping;
    }

    public void setCrashed(boolean crashed) {
        this.crashed = crashed;
    }

    public Movement getMovement() {
        return movement;
    }

    public Picture getSprite() {
        return sprite;
    }

}