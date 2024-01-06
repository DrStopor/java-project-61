package hexlet.code;

import java.util.Scanner;

public final class Engine {
    public static final int MAX_TRY = 3;
    private String userName = "";
    private final Scanner scanner = new Scanner(System.in);
    private int tryCount = MAX_TRY;

    public Engine() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        setUserName(scanner.next());
        System.out.printf("Hello, %s!\n", getUserName());
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
        System.out.printf("Congratulations, %s!", getUserName());
    }

    public void loseText(String userAnswer, String answer) {
        System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.\n"
                + "Let's try again, %s!", userAnswer, answer, getUserName());
    }

    private void setUserName(String name) {
        userName = name;
    }

    private String getUserName() {
        return userName;
    }

    public void setTryCount(int value) {
        tryCount = value;
    }

    public int getTryCount() {
        return tryCount;
    }

    private Scanner getScanner() {
        return scanner;
    }
}
