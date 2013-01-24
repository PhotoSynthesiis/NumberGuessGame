package NumberGuessGame;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ResultReporterTest {

    @Test
    public void shouldGet4A0BWhenBingo() {
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

        int totalMatch = SystemToUserAnswerMatcher.checkTotalMatchIndicator(answerBackend, answerUserInput);
        int halfMatch = SystemToUserAnswerMatcher.checkHalfMatchIndicator(answerBackend, answerUserInput);

        assertThat(ResultReporter.presentResult(totalMatch, halfMatch), is("4A0B"));
    }

    @Test
    public void shouldGet2A2BWhenHalfTotalMatchHalfHalfMatch() {
        List<Integer> answerBackend = new ArrayList<Integer>();
        answerBackend.add(1);
        answerBackend.add(2);
        answerBackend.add(3);
        answerBackend.add(4);

        List<Integer> answerUserInput = new ArrayList<Integer>();
        answerUserInput.add(1);
        answerUserInput.add(2);
        answerUserInput.add(4);
        answerUserInput.add(3);

        int totalMatch = SystemToUserAnswerMatcher.checkTotalMatchIndicator(answerBackend, answerUserInput);
        int halfMatch = SystemToUserAnswerMatcher.checkHalfMatchIndicator(answerBackend, answerUserInput);

        assertThat(ResultReporter.presentResult(totalMatch, halfMatch), is("2A2B"));
    }

    @Test
    public void shouldGet0A4BWhenHalfTotalMatchHalfHalfMatch() {
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

        int totalMatch = SystemToUserAnswerMatcher.checkTotalMatchIndicator(answerBackend, answerUserInput);
        int halfMatch = SystemToUserAnswerMatcher.checkHalfMatchIndicator(answerBackend, answerUserInput);

        assertThat(ResultReporter.presentResult(totalMatch, halfMatch), is("0A4B"));
    }

    @Test
    public void shouldGet0A0BWhenSomeoneHasNoLuckAtAll() {
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

        int totalMatch = SystemToUserAnswerMatcher.checkTotalMatchIndicator(answerBackend, answerUserInput);
        int halfMatch = SystemToUserAnswerMatcher.checkHalfMatchIndicator(answerBackend, answerUserInput);

        assertThat(ResultReporter.presentResult(totalMatch, halfMatch), is("0A0B"));
    }
}
