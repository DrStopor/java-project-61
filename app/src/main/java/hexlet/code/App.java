package hexlet.code;

import hexlet.code.game.Calculator;
import hexlet.code.game.Even;
import hexlet.code.game.Gcd;
import hexlet.code.game.Greet;
import hexlet.code.game.Progression;
import hexlet.code.game.Prime;

import java.util.Scanner;

public class App {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final int GREET = 1;
    public static final int EVEN = 2;
    public static final int CALCULATOR = 3;
    public static final int GCD = 4;
    public static final int PROGRESSION = 5;
    public static final int PRIME = 6;

    public static void main(String[] args) {
        System.out.println(ANSI_BLUE + "Please enter the game number and press Enter.");
        System.out.println(ANSI_GREEN + "1 - Greet");
        System.out.println(ANSI_GREEN + "2 - Even");
        System.out.println(ANSI_GREEN + "3 - Calculator");
        System.out.println(ANSI_GREEN + "4 - GCD");
        System.out.println(ANSI_GREEN + "5 - Progression");
        System.out.println(ANSI_GREEN + "6 - Prime");
        System.out.println(ANSI_YELLOW + "0 - Exit");
        System.out.print(ANSI_CYAN + "Your choice: ");

        Scanner scanner = new Scanner(System.in);
        String choose = scanner.next();
        int number = Integer.parseInt(choose);

        switch (number) {
            case GREET:
                Greet greet = new Greet();
                greet.play();
                return;
            case EVEN:
                Even even = new Even();
                even.play();
                return;
            case CALCULATOR:
                Calculator calculator = new Calculator();
                calculator.play();
                return;
            case GCD:
                Gcd gcd = new Gcd();
                gcd.play();
                return;
            case PROGRESSION:
                Progression progression = new Progression();
                progression.play();
                return;
            case PRIME:
                Prime prime = new Prime();
                prime.play();
                return;
            default:
                return;
        }
    }
}
