package NumberGuessGame;

import NumberGuessGame.exceptions.NoChanceRemainException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;

import java.io.ByteArrayInputStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.MockitoAnnotations.initMocks;

public class UserChanceCounterTest {
    private UserChanceCounter userChanceCounter;
    private PlayerAction playerAction;
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Mock
    public AnswerGenerator answerGenerator;

    @Before
    public void setUp() {
        initMocks(this);
        userChanceCounter = new UserChanceCounter();
        playerAction = new PlayerAction(userChanceCounter);
    }

    @Test
    public void shouldHaveSixChanceInitially() {
        int expectedChanceRemain = 6;

        assertThat(userChanceCounter.getRemainingChance(), is(expectedChanceRemain));
    }

    @Test
    public void shouldHaveFiveChanceRemainIfUserHaveUsedOneChance() throws NoChanceRemainException {
        ByteArrayInputStream in1 = new ByteArrayInputStream("1 2 3 4".getBytes());
        System.setIn(in1);

        int expectedChanceRemain = 5;
        playerAction.guess();

        assertThat(userChanceCounter.getRemainingChance(), is(expectedChanceRemain));
    }

    @Test
    public void shouldHaveFourChanceRemainIfUserHaveUsedTwoChances() throws NoChanceRemainException {
        ByteArrayInputStream in1 = new ByteArrayInputStream("1 2 3 4".getBytes());
        System.setIn(in1);

        int expectedChanceRemain1 = 5;
        playerAction.guess();
        assertThat(userChanceCounter.getRemainingChance(), is(expectedChanceRemain1));

        ByteArrayInputStream in2 = new ByteArrayInputStream("1 2 3 4".getBytes());
        System.setIn(in2);

        int expectedChanceRemain2 = 4;
        playerAction.guess();

        assertThat(userChanceCounter.getRemainingChance(), is(expectedChanceRemain2));
    }

    @Test
    public void shouldThrowNoChanceRemainExceptionGivenUserHasWastedSixChances() throws NoChanceRemainException {
        exception.expect(NoChanceRemainException.class);
        ByteArrayInputStream in1 = new ByteArrayInputStream("1 2 3 4".getBytes());
        System.setIn(in1);
        playerAction.guess();
        ByteArrayInputStream in2 = new ByteArrayInputStream("1 2 3 4".getBytes());
        System.setIn(in2);
        playerAction.guess();
        ByteArrayInputStream in3 = new ByteArrayInputStream("1 2 3 4".getBytes());
        System.setIn(in3);
        playerAction.guess();
        ByteArrayInputStream in4 = new ByteArrayInputStream("1 2 3 4".getBytes());
        System.setIn(in4);
        playerAction.guess();
        ByteArrayInputStream in5 = new ByteArrayInputStream("1 2 3 4".getBytes());
        System.setIn(in5);
        playerAction.guess();
        ByteArrayInputStream in6 = new ByteArrayInputStream("1 2 3 4".getBytes());
        System.setIn(in6);
        playerAction.guess();
        ByteArrayInputStream in7 = new ByteArrayInputStream("1 2 3 4".getBytes());
        System.setIn(in7);
        playerAction.guess();
    }
}