package hexlet.code.game;

import hexlet.code.Engine;
import hexlet.code.game.interfaces.Playable;

import java.util.Random;

public class Progression implements Playable {
    private Engine engine = null;

    public Progression() {
        engine = new Engine();
    }

    @Override
    public void play() {
        System.out.println("What number is missing in the progression?");
        Random rnd = new Random();

        do {
            int step = rnd.nextInt(1,5);
            int number = rnd.nextInt(1, 50);
            int hideIndex = rnd.nextInt(0, 9);
            int result = 0;
            StringBuilder questionString = new StringBuilder();

            for (int i = 0; i < 10; i++, number += step) {
                if (i == hideIndex) {
                    result = number;
                    questionString.append("..").append(" ");
                    continue;
                }
                questionString.append(number).append(" ");
            }
            questionString.deleteCharAt(questionString.length() - 1);

            engine.printQuestion(questionString.toString());
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
}
