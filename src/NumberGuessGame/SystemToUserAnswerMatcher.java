package NumberGuessGame;

import java.util.List;

public class SystemToUserAnswerMatcher {

    public static int checkTotalMatchIndicator(List<Integer> answerBackend, List<Integer> answerUserInput) {
        int totalMatch = 0;
        for (int i = 0; i < answerBackend.size(); i ++) {
            if(answerBackend.get(i).equals(answerUserInput.get(i))) {
                totalMatch++;
            }
        }
        return totalMatch;
    }

    public static int checkHalfMatchIndicator(List<Integer> answerBackend, List<Integer> answerUserInput) {
        int halfMatch = 0;
        for(int i = 0; i < answerBackend.size(); i ++) {
            int theNumber = answerBackend.get(i);
            for(int j = 0; j < answerBackend.size(); j ++) {
                if(theNumber == answerUserInput.get(j) && (i != j)) {
                    halfMatch++;
                }
            }
        }
        return halfMatch;
    }
}
