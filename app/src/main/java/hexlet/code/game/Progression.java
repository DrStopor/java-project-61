package hexlet.code.game;

import hexlet.code.Engine;
import hexlet.code.game.interfaces.Playable;

import java.util.Random;

public final class Progression implements Playable {
    public static final int MIN_STEP = 1;
    public static final int MIN_NUMBER = 1;
    public static final int MIN_HIDE_INDEX = 0;
    public static final int MAX_STEP = 5;
    public static final int MAX_NUMBER = 50;
    public static final int MAX_HIDE_INDEX = 9;
    private Engine engine = null;

    public Progression() {
        engine = new Engine();
    }

    @Override
    public void play() {
        System.out.println("What number is missing in the progression?");
        Random rnd = new Random();

        do {
            int step = rnd.nextInt(MIN_STEP, MAX_STEP);
            int number = rnd.nextInt(MIN_NUMBER, MAX_NUMBER);
            int hideIndex = rnd.nextInt(MIN_HIDE_INDEX, MAX_HIDE_INDEX);
            int result = 0;
            StringBuilder questionString = new StringBuilder();

            for (int i = 0; i < MAX_HIDE_INDEX; i++, number += step) {
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
                engine.setTryCount(engine.getTryCount() - 1);
            } else {
                engine.loseText(answer, String.valueOf(result));
                return;
            }
        } while (engine.getTryCount() > 0);
        engine.congratulation();
    }
}
