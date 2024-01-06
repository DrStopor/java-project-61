package hexlet.code.game;

import hexlet.code.Engine;
import hexlet.code.game.interfaces.Playable;

import java.util.Random;

public class Gcd implements Playable {
    private Engine engine = null;

    public Gcd() {
        engine = new Engine();
    }

    @Override
    public void play() {
        System.out.println("Find the greatest common divisor of given numbers.");
        Random rnd = new Random();
        int numberOne = 0;
        int numberTwo = 0;
        int result = 1;

        do {
            numberOne = rnd.nextInt(100);
            numberTwo = rnd.nextInt(100);
            result = getGdc(numberOne, numberTwo);
            engine.printQuestion(numberOne + " " + numberTwo);
            String answer = engine.askAnswer();

            if (result == Integer.parseInt(answer)) {
                engine.printCorrect();
                engine.tryCount--;
            } else {
                engine.loseText(answer, String.valueOf(result));
                return;
            }
        } while (engine.tryCount > 0);

        engine.congratulation();
    }

    private int getGdc(int numberOne, int numberTwo) {
        int max = Math.max(numberOne, numberTwo);
        int min = Math.min(numberOne, numberTwo);

        if (max % min == 0) {
            return 1;
        }

        do {
            int resultOperation = max % min;
            if (resultOperation != 0) {
                max = min;
                min = resultOperation;
            } else {
                break;
            }

        } while (true);

        return min;
    }
}
