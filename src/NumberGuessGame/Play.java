package NumberGuessGame;

import NumberGuessGame.exceptions.NoChanceRemainException;

import java.util.List;

public class Play {
    public static void main(String[] args) throws NoChanceRemainException {
        List<Integer> answerBackend = generateSystemAnswers();

        UserChanceCounter counter = printFormat();
        while (true) {
            playerGuess(answerBackend, counter);
        }
    }

    private static UserChanceCounter printFormat() {
        System.out.println();
        System.out.println("-----------------------");
        System.out.println("Please input your answer");
        return new UserChanceCounter();
    }

    private static void playerGuess(List<Integer> answerBackend, UserChanceCounter counter) throws NoChanceRemainException {
        List<Integer> answerUserInput = new PlayerAction(counter).guess();

        int totalMatch = SystemToUserAnswerMatcher.checkTotalMatchIndicator(answerBackend, answerUserInput);
        int halfMatch = SystemToUserAnswerMatcher.checkHalfMatchIndicator(answerBackend, answerUserInput);

        String result = ResultReporter.presentResult(totalMatch, halfMatch);

        System.out.println("HINT :" + result);
    }

    private static List<Integer> generateSystemAnswers() {
        System.out.println("-----------------------");
        System.out.println("System generated answers are : ");
        List<Integer> answerBackend = new AnswerGenerator().generateAnswer();
        System.out.println(answerBackend);
        System.out.println("-----------------------");
        return answerBackend;
    }
}
