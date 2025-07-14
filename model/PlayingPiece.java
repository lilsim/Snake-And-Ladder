package model;

public class PlayingPiece {
    private int currentPosition;
    public PlayingPiece() {
        this.currentPosition = 1; 
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int position) {
        this.currentPosition = position;
    }
}
