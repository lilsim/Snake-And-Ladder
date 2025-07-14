package model;

public class Player {
    private String name;
    private PlayingPiece piece;
    public Player(String name) {
        this.name = name;
        this.piece = new PlayingPiece();
    } 
    public String getName() {
        return name;
    }
    public PlayingPiece getPlayingPiece() {
        return piece;
    }
}
