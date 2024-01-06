package hexlet.code;

import hexlet.code.game.*;

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
    public static void main(String[] args) {
        System.out.println(ANSI_BLUE + "Please enter the game number and press Enter.");
        System.out.println(ANSI_GREEN + "1 - Greet");
        System.out.println(ANSI_GREEN + "2 - Even");
        System.out.println(ANSI_GREEN + "3 - Calculator");
        System.out.println(ANSI_GREEN + "4 - GCD");
        System.out.println(ANSI_GREEN + "5 - Progression");
        System.out.println(ANSI_YELLOW + "0 - Exit");
        System.out.print(ANSI_CYAN + "Your choice: ");

        Scanner scanner = new Scanner(System.in);
        String choose = scanner.next();
        int number = Integer.parseInt(choose);

        switch (number) {
            case 1:
                Greet greet = new Greet();
                greet.play();
                return;
            case 2:
                Even even = new Even();
                even.play();
                return;
            case 3:
                Calculator calculator = new Calculator();
                calculator.play();
                return;
            case 4:
                Gcd gcd = new Gcd();
                gcd.play();
                return;
            case 5:
                Progression progression = new Progression();
                progression.play();
                return;
            default:
                return;
        }
    }
}
