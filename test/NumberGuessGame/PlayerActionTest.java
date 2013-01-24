package NumberGuessGame;

import NumberGuessGame.exceptions.NoChanceRemainException;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PlayerActionTest {
    @Test
    public void shouldReturnANumberSequenceListWhenAnswerFormIsCorrect() throws NoChanceRemainException {
        ByteArrayInputStream in = new ByteArrayInputStream("1 2 3 4".getBytes());
        System.setIn(in);

        List<Integer> numberList = new PlayerAction(new UserChanceCounter()).guess();
        assertThat(numberList.size(), is(4));
    }
}
