package NumberGuessGame;

import NumberGuessGame.exceptions.NoChanceRemainException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AnswerCheckerTest {

    @Test
    public void shouldReturnFourWhenAllGuessedRightForTotalMatch() throws NoChanceRemainException {

        List<Integer> answerBackend = new ArrayList<Integer>();
        answerBackend.add(1);
        answerBackend.add(2);
        answerBackend.add(3);
        answerBackend.add(4);

        List<Integer> answerUserInput = new ArrayList<Integer>();
        answerUserInput.add(1);
        answerUserInput.add(2);
        answerUserInput.add(3);
        answerUserInput.add(4);

        int totalMatchIndicator = SystemToUserAnswerMatcher.checkTotalMatchIndicator(answerBackend, answerUserInput);
        assertThat(totalMatchIndicator, is(4));
    }

    @Test
    public void shouldReturnThreeWhenThreeGuessedRightForTotalMatch() throws NoChanceRemainException {

        List<Integer> answerBackend = new ArrayList<Integer>();
        answerBackend.add(1);
        answerBackend.add(2);
        answerBackend.add(3);
        answerBackend.add(4);

        List<Integer> answerUserInput = new ArrayList<Integer>();
        answerUserInput.add(1);
        answerUserInput.add(2);
        answerUserInput.add(3);
        answerUserInput.add(5);

        int totalMatchIndicator = SystemToUserAnswerMatcher.checkTotalMatchIndicator(answerBackend, answerUserInput);
        assertThat(totalMatchIndicator, is(3));
    }

    @Test
    public void shouldReturnZeroWhenNoneGuessedRightForTotalMatch() throws NoChanceRemainException {

        List<Integer> answerBackend = new ArrayList<Integer>();
        answerBackend.add(1);
        answerBackend.add(2);
        answerBackend.add(3);
        answerBackend.add(4);

        List<Integer> answerUserInput = new ArrayList<Integer>();
        answerUserInput.add(4);
        answerUserInput.add(3);
        answerUserInput.add(2);
        answerUserInput.add(1);

        int totalMatchIndicator = SystemToUserAnswerMatcher.checkTotalMatchIndicator(answerBackend, answerUserInput);
        assertThat(totalMatchIndicator, is(0));
    }

    @Test
    public void shouldReturnFourWhenEveryNumberNotRightButHasOccurred() {
        List<Integer> answerBackend = new ArrayList<Integer>();
        answerBackend.add(1);
        answerBackend.add(2);
        answerBackend.add(3);
        answerBackend.add(4);

        List<Integer> answerUserInput = new ArrayList<Integer>();
        answerUserInput.add(4);
        answerUserInput.add(3);
        answerUserInput.add(2);
        answerUserInput.add(1);

        int totalMatchIndicator = SystemToUserAnswerMatcher.checkHalfMatchIndicator(answerBackend, answerUserInput);
        assertThat(totalMatchIndicator, is(4));
    }

    @Test
    public void shouldReturnThreeWhenOneNotRightButHasOccurred() {
        List<Integer> answerBackend = new ArrayList<Integer>();
        answerBackend.add(1);
        answerBackend.add(2);
        answerBackend.add(3);
        answerBackend.add(4);

        List<Integer> answerUserInput = new ArrayList<Integer>();
        answerUserInput.add(1);
        answerUserInput.add(3);
        answerUserInput.add(4);
        answerUserInput.add(2);

        int totalMatchIndicator = SystemToUserAnswerMatcher.checkHalfMatchIndicator(answerBackend, answerUserInput);
        assertThat(totalMatchIndicator, is(3));
    }

    @Test
    public void shouldReturnZeroWhenNoSameButDifferentPositionOccurred() {
        List<Integer> answerBackend = new ArrayList<Integer>();
        answerBackend.add(1);
        answerBackend.add(2);
        answerBackend.add(3);
        answerBackend.add(4);

        List<Integer> answerUserInput = new ArrayList<Integer>();
        answerUserInput.add(5);
        answerUserInput.add(6);
        answerUserInput.add(7);
        answerUserInput.add(8);

        int totalMatchIndicator = SystemToUserAnswerMatcher.checkHalfMatchIndicator(answerBackend, answerUserInput);
        assertThat(totalMatchIndicator, is(0));
    }
}
