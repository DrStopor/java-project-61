package hexlet.code.game;

import hexlet.code.Engine;
import hexlet.code.game.interfaces.Playable;

import java.util.Random;

public class Prime implements Playable {
    private Engine engine = null;

    public Prime() {
        engine = new Engine();
    }
    @Override
    public void play() {
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        Random rnd = new Random();

        do {
            int number = rnd.nextInt(1, 100);
            boolean isPrime = prime(number);

            engine.printQuestion(String.valueOf(number));
            String answer = engine.askAnswer();

            switch (answer) {
                case "yes":
                    if (!isPrime) {
                        engine.loseText(answer, String.valueOf(isPrime));
                        return;
                    }
                    break;
                case "no":
                    if (isPrime) {
                        engine.loseText(answer, String.valueOf(isPrime));
                        return;
                    }
                    break;
                default:
                    engine.loseText(answer, String.valueOf(isPrime));
                    return;
            }
            engine.tryCount--;
            engine.printCorrect();
        } while (engine.tryCount > 0);
        engine.congratulation();
    }

    private boolean prime(int n) {
        for(int i = 2; i<= Math.sqrt(n); i++) {
            if (n%i == 0) {
                return false;
            }
        }
        return true;
    }
}
