package hexlet.code.game;

import hexlet.code.Cli;
import hexlet.code.game.interfaces.Playable;
import hexlet.code.game.interfaces.Scanarable;

import java.util.Random;
import java.util.Scanner;

public class Even implements Playable, Scanarable {
    public String userName = "";
    public Scanner scanner = new Scanner(System.in);

    public Even() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        userName = scanner.next();
        System.out.printf("Hello, %s!", userName);
    }
    public void play() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        int tryCount = 3;
        Random rnd = new Random();

        do {
            int number = rnd.nextInt(101);
            boolean even = (number & 1) == 1;
            System.out.println("Question: " + number);
            System.out.print("Your answer: ");

            String choose = scanner.next();
            switch (choose) {
                case "yes":
                    if (even) {
                        System.out.println("Correct");
                        tryCount--;
                        continue;
                    } else {
                        loseText(choose, "no");
                        return;
                    }
                case "no":
                    if (!even) {
                        System.out.println("Correct");
                        tryCount--;
                        continue;
                    } else {
                        loseText(choose, "yes");
                        return;
                    }
                default:
                    loseText(choose, even ? "yes" : "no");
                    return;
            }
        } while (tryCount > 0);
        System.out.printf("Congratulations, %s!", userName);
    }

    private void loseText(String userAnswer, String answer) {
        System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.\n" +
                "Let's try again, %s", userAnswer, answer, userName);
    }
}
