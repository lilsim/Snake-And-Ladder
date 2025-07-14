package model;

public class Cell {
    private int position;
    private Snake snake;
    private Ladder ladder;

    public Cell(int position) {
        this.position = position;
        this.snake = null;
        this.ladder = null;
    }
    public int getPosition() {
        return position;
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public void setLadder(Ladder ladder) {
        this.ladder = ladder;
    }

    public boolean hasSnake() {
        return snake != null;
    }

    public boolean hasLadder() {
        return ladder != null;
    }

    @Override
    public String toString() {
        if (hasSnake()) return "S";
        if (hasLadder()) return "L";
        return String.valueOf(position);
    }

}
