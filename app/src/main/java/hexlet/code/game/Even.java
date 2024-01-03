package hexlet.code.game;

import hexlet.code.Cli;
import hexlet.code.Engine;
import hexlet.code.game.interfaces.Playable;
import hexlet.code.game.interfaces.Scanarable;

import java.util.Random;
import java.util.Scanner;

public class Even implements Playable {
    private Engine engine = null;

    public Even() {
        engine = new Engine();
    }
    public void play() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        int tryCount = 3;
        Random rnd = new Random();

        do {
            int number = rnd.nextInt(101);
            boolean even = (number & 1) == 1;
            engine.printQuestion(String.valueOf(number));
            String answer = engine.askAnswer();

            switch (answer) {
                case "yes":
                    if (even) {
                        engine.printCorrect();
                        engine.tryCount--;
                        continue;
                    } else {
                        engine.loseText(answer, "no");
                        return;
                    }
                case "no":
                    if (!even) {
                        engine.printCorrect();
                        engine.tryCount--;
                        continue;
                    } else {
                        engine.loseText(answer, "yes");
                        return;
                    }
                default:
                    engine.loseText(answer, even ? "yes" : "no");
                    return;
            }
        } while (engine.tryCount > 0);
        engine.congratulation();
    }
}
