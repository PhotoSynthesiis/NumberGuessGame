package NumberGuessGame;

import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AnswerGeneratorTest {
    private List<Integer> answer;

    @Before
    public void setUp() {
        answer = new AnswerGenerator().generateAnswer();
    }

    @Test
    public void shouldHaveFourNumbersToCombineAnAnswer() {
        assertThat(answer.size(), is(4));
    }

    @Test
    public void shouldHaveFourDifferentNumbersInTheAnswer() {
        Collections.sort(answer);
        assertThat(answer.get(0) < answer.get(1), is(true));
        assertThat(answer.get(1) < answer.get(2), is(true));
        assertThat(answer.get(2) < answer.get(3), is(true));
    }
}

