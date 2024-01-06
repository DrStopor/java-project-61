package hexlet.code.game;

import hexlet.code.Cli;
import hexlet.code.game.interfaces.Playable;
import hexlet.code.game.interfaces.Scanarable;

import java.util.Scanner;

public class Greet implements Playable, Scanarable {
    public String userName = "";
    public Scanner scanner = new Scanner(System.in);

    public Greet() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        userName = scanner.next();
    }

    @Override
    public void play() {
        System.out.printf("Hello, %s!", userName);
    }
}
