package hexlet.code.game;

import hexlet.code.Engine;
import hexlet.code.game.interfaces.Playable;

import java.util.Random;

public final class Gcd implements Playable {
    private static final int MAX_NUMBER = 100;
    private static final int MIN_NUMBER = 0;
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
            numberOne = rnd.nextInt(MIN_NUMBER, MAX_NUMBER);
            numberTwo = rnd.nextInt(MIN_NUMBER, MAX_NUMBER);
            result = getGdc(numberOne, numberTwo);
            engine.printQuestion(numberOne + " " + numberTwo);
            String answer = engine.askAnswer();

            if (result == Integer.parseInt(answer)) {
                engine.printCorrect();
                engine.setTryCount(engine.getTryCount() - 1);
            } else {
                engine.loseText(answer, String.valueOf(result));
                return;
            }
        } while (engine.getTryCount() > 0);

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
