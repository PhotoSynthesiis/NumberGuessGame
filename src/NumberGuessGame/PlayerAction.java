package NumberGuessGame;

import NumberGuessGame.exceptions.NoChanceRemainException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerAction {
    private UserChanceCounter chanceCounter;

    public PlayerAction(UserChanceCounter chanceCounter) {
        this.chanceCounter = chanceCounter;
    }

    public List<Integer> guess() throws NoChanceRemainException {
        List<Integer> numberList = receive();
        chanceCounter.decreaseRemainingChance();
        if (chanceCounter.getRemainingChance() == -1) {
            throw new NoChanceRemainException("You have wasted all the chances");
        }
        new PlayerAnswerChecker().checkValidity(numberList);
        return numberList;
    }

    private List<Integer> receive() {
        ArrayList<Integer> userInputNumberList = new ArrayList<Integer>();
        Scanner scanner = new Scanner(System.in);
        String numberString = scanner.nextLine();

        String[] numbers = numberString.split(" ");
        for (String number : numbers) {
            userInputNumberList.add(Integer.parseInt(number));
        }

        return userInputNumberList;
    }
}
