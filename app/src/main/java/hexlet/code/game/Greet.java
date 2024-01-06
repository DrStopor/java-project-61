package hexlet.code.game;

import hexlet.code.game.interfaces.Playable;

import java.util.Scanner;

public final class Greet implements Playable {
    private String userName = "";

    public Greet() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        Scanner scanner = new Scanner(System.in);
        userName = scanner.next();
    }

    @Override
    public void play() {
        System.out.printf("Hello, %s!", userName);
    }

    private String getUserName() {
        return userName;
    }

    private void setUserName(String name) {
        userName = name;
    }
}
