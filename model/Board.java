package model;

import java.util.List;

public class Board {
    public int size;
    private int[][] grid;
    private List<Snake> snakes;
    private List<Ladder> ladders;

    public Board(int size, List<Snake> snakes, List<Ladder> ladders) {
        this.size = size;
        this.snakes = snakes;
        this.ladders = ladders;
        grid = new int[size][size];
        initializeBoard();
    }

    private void initializeBoard() {
        int value = 1;
        for (int i = 0; i < size; i++) {             
            for (int j = 0; j < size; j++) {
                grid[i][j] = value++;
            }
        }
    }

    public boolean isValidPiece(int pos) {
        return pos > 0 && pos <= size * size;
    }

    public int getCell(int pos) {
        if (!isValidPiece(pos)) {
            throw new IllegalArgumentException("Invalid cell position: " + pos);
        }

        int row = (pos - 1) / size;
        int col = (pos - 1) % size;
        return grid[row][col];
    }

    public boolean isWin(int pos) {
        return pos == size * size;
    }

    public int getMaxCellNumber() {
        return size * size;
    }

    public void placePiece(Player player, int newPosition) {
        if (!isValidPiece(newPosition)) {
            System.out.println("Invalid move: position " + newPosition + " is out of bounds.");
            return;
        }

        int finalPosition = newPosition;

        // Check for Snake
        for (Snake snake : snakes) {
            if (snake.getStart() == finalPosition) {
                System.out.println(player.getName() + " bitten by snake! " + finalPosition + " → " + snake.getEnd());
                finalPosition = snake.getEnd();
                break;
            }
        }

        // Check for Ladder
        for (Ladder ladder : ladders) {
            if (ladder.getStart() == finalPosition) {
                System.out.println(player.getName() + " climbed ladder! " + finalPosition + " → " + ladder.getEnd());
                finalPosition = ladder.getEnd();
                break;
            }
        }

        // Update the player's position
        player.getPlayingPiece().setCurrentPosition(finalPosition);
        System.out.println(player.getName() + " is now at position " + finalPosition);
    }

    // private void display() {
    //     System.out.println("\nBoard:");
    //     for (int i = size - 1; i >= 0; i--) {
    //         if ((size - 1 - i) % 2 == 0) {
    //             for (int j = 0; j < size; j++) {
    //                 System.out.printf("%3d", grid[i][j]);
    //             }
    //         } else {
    //             for (int j = size - 1; j >= 0; j--) {
    //                 System.out.printf("%3d", grid[i][j]);
    //             }
    //         }
    //         System.out.println();
    //     }
    // }
} 
