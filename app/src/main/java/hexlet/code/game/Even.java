package hexlet.code.game;

import hexlet.code.Engine;
import hexlet.code.game.interfaces.Playable;

import java.util.Random;

public final class Even implements Playable {
    public static final int MAX_NUMBER = 101;
    private Engine engine = null;

    public Even() {
        engine = new Engine();
    }

    @Override
    public void play() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        Random rnd = new Random();

        do {
            int number = rnd.nextInt(MAX_NUMBER);
            boolean even = (number & 1) == 1;
            engine.printQuestion(String.valueOf(number));
            String answer = engine.askAnswer();

            switch (answer) {
                case "no":
                    if (even) {
                        engine.printCorrect();
                        engine.setTryCount(engine.getTryCount() - 1);
                        continue;
                    } else {
                        engine.loseText(answer, "yes");
                        return;
                    }
                case "yes":
                    if (!even) {
                        engine.printCorrect();
                        engine.setTryCount(engine.getTryCount() - 1);
                        continue;
                    } else {
                        engine.loseText(answer, "no");
                        return;
                    }
                default:
                    engine.loseText(answer, even ? "yes" : "no");
                    return;
            }
        } while (engine.getTryCount() > 0);
        engine.congratulation();
    }
}
