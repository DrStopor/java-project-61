package hexlet.code.game;

import hexlet.code.Engine;
import hexlet.code.game.interfaces.Playable;

import java.util.Random;

public final class Calculator implements Playable {
    public static final int MAX_NUMBER = 100;
    public static final int VARIATE_CHOISE = 3;
    private Engine engine = null;

    public Calculator() {
        engine = new Engine();
    }

    @Override
    public void play() {
        System.out.println("What is the result of the expression?");
        Random rnd = new Random();
        do {
            int result = 0;
            String answer = "";
            int numberOne = rnd.nextInt(MAX_NUMBER);
            int numberTwo = rnd.nextInt(MAX_NUMBER);
            switch (rnd.nextInt(VARIATE_CHOISE)) {
                default:
                case 0:
                    result = numberOne + numberTwo;
                    engine.printQuestion(numberOne + " + " + numberTwo);
                    answer = engine.askAnswer();
                    break;
                case 1:
                    result = numberOne - numberTwo;
                    engine.printQuestion(numberOne + " - " + numberTwo);
                    answer = engine.askAnswer();
                    break;
                case 2:
                    result = numberOne * numberTwo;
                    engine.printQuestion(numberOne + " * " + numberTwo);
                    answer = engine.askAnswer();
                    break;
            }

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
}
