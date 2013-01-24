package NumberGuessGame;

import NumberGuessGame.exceptions.InvalidNumberSizeException;
import NumberGuessGame.exceptions.NumberOutOfRangeException;
import NumberGuessGame.exceptions.NumberSequenceInvalidException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

public class PlayerAnswerCheckerTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    private PlayerAnswerChecker playerAnswerChecker;

    @Before
    public void setUp() {
        playerAnswerChecker = new PlayerAnswerChecker();
    }

    @Test
    public void shouldThrowNumberOutOfRangeExceptionGivenInputNumberLessThanZeroOrMoreThanNine() throws NumberOutOfRangeException {
        expectedException.expect(NumberOutOfRangeException.class);

        List<Integer> expectedList = new ArrayList<Integer>();
        expectedList.add(-1);
        expectedList.add(2);
        expectedList.add(3);
        expectedList.add(10);

        playerAnswerChecker.checkNumberRangeValidity(expectedList);
    }

    @Test
    public void shouldThrowNumberSequenceInvalidExceptionGivenInputSomeIdenticalNumbers() throws NumberSequenceInvalidException {
        expectedException.expect(NumberSequenceInvalidException.class);

        List<Integer> expectedList = new ArrayList<Integer>();
        expectedList.add(1);
        expectedList.add(2);
        expectedList.add(3);
        expectedList.add(3);

        playerAnswerChecker.checkSequenceValidity(expectedList);
    }

    @Test
    public void shouldThrowInvalidNumberSizeExceptionGivenInputMoreThanFourNumbersAsAnAnswer() throws InvalidNumberSizeException {
        expectedException.expect(InvalidNumberSizeException.class);

        List<Integer> expectedList = new ArrayList<Integer>();
        expectedList.add(1);
        expectedList.add(2);
        expectedList.add(3);
        expectedList.add(4);
        expectedList.add(5);

        playerAnswerChecker.checkNumberSizeValidity(expectedList);
    }

    @Test
    public void shouldThrowNumberSizeExceptionGivenInputLessThanFourNumberAsAnAnswer() throws InvalidNumberSizeException {
        expectedException.expect(InvalidNumberSizeException.class);

        List<Integer> expectedList = new ArrayList<Integer>();
        expectedList.add(1);
        expectedList.add(2);
        expectedList.add(3);

        playerAnswerChecker.checkNumberSizeValidity(expectedList);
    }
}
