package model;

public class Dice {
    public int roll() {
        return (int)(Math.random() * 6) + 1;
    }
}
