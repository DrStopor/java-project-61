package hexlet.code.game;

import hexlet.code.Engine;
import hexlet.code.game.interfaces.Playable;

import java.util.Random;

public class Calculator implements Playable {
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
            int numberOne = rnd.nextInt(100);
            int numberTwo = rnd.nextInt(100);
            switch (rnd.nextInt(3)) {
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
                engine.tryCount--;
            } else {
                engine.loseText(answer, String.valueOf(result));
                return;
            }
        } while (engine.tryCount > 0);

        engine.congratulation();
    }
}
