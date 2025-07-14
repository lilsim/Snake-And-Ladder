package model;

import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class Game {
    private Board board;
    private Dice dice;
    private Queue<Player> players;

    public Game(int boardSize, List<Player> playerList, List<Snake> snakes, List<Ladder> ladders) {
        this.board = new Board(boardSize, snakes, ladders);  
        this.dice = new Dice();
        this.players = new LinkedList<>(playerList);
    }

    public void startGame() {
        boolean won = false;

        while (!won) {
            Player currentPlayer = players.poll();
            int diceValue = dice.roll();
            System.out.println(currentPlayer.getName() + " rolled a " + diceValue);

            int currentPosition = currentPlayer.getPlayingPiece().getCurrentPosition();
            int nextPosition = currentPosition + diceValue;

            if (nextPosition > board.getMaxCellNumber()) {
                System.out.println("Roll too high. Stay at " + currentPosition);
                players.offer(currentPlayer);
                continue;
            }

            // Place piece (handles snake/ladder jump)
            board.placePiece(currentPlayer, nextPosition);

            if (board.isWin(currentPlayer.getPlayingPiece().getCurrentPosition())) {
                System.out.println(currentPlayer.getName() + " has won the game!");
                won = true;
            } else {
                players.offer(currentPlayer);
            }
        }
    }
}
