package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter board size (e.g., 10 for 10x10): ");
        int boardSize = scanner.nextInt();

        System.out.print("Enter number of players: ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine(); // consume leftover newline

        List<Player> players = new ArrayList<>();
        for (int i = 1; i <= numPlayers; i++) {
            System.out.print("Enter name for Player " + i + ": ");
            String name = scanner.nextLine();
            players.add(new Player(name));
        }

        System.out.print("Enter number of snakes: ");
        int numSnakes = scanner.nextInt();
        List<Snake> snakes = new ArrayList<>();
        for (int i = 1; i <= numSnakes; i++) {
            System.out.print("Enter snake " + i + " start position: ");
            int start = scanner.nextInt();
            System.out.print("Enter snake " + i + " end position: ");
            int end = scanner.nextInt();
            snakes.add(new Snake(start, end));
        }

        System.out.print("Enter number of ladders: ");
        int numLadders = scanner.nextInt();
        List<Ladder> ladders = new ArrayList<>();
        for (int i = 1; i <= numLadders; i++) {
            System.out.print("Enter ladder " + i + " start position: ");
            int start = scanner.nextInt();
            System.out.print("Enter ladder " + i + " end position: ");
            int end = scanner.nextInt();
            ladders.add(new Ladder(start, end));
        }

        System.out.println("\nStarting the game...\n");
        Game game = new Game(boardSize, players, snakes, ladders);
        game.startGame();

        scanner.close();
    }

}
