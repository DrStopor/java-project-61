package hexlet.code;

import hexlet.code.game.interfaces.Scanarable;

import java.util.Scanner;

public class Engine implements Scanarable {
    public String userName = "";
    public Scanner scanner = new Scanner(System.in);
    public int tryCount = 3;

    public Engine() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        userName = scanner.next();
        System.out.printf("Hello, %s!\n", userName);
    }

    public void printQuestion(String question) {
        System.out.println("Question: " + question);
    }

    public String askAnswer() {
        System.out.print("Your answer: ");
        return scanner.next();
    }

    public void printCorrect() {
        System.out.println("Correct!");
    }

    public void congratulation() {
        System.out.printf("Congratulations, %s!", userName);
    }

    public void loseText(String userAnswer, String answer) {
        System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.\n" +
                "Let's try again, %s", userAnswer, answer, userName);
    }
}
