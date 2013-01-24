package NumberGuessGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AnswerGenerator {
    private List<Integer> numberList = new ArrayList<Integer>();

    public List<Integer> generateAnswer() {
        Random randomGenerator = new Random();

        do {
            for (int i = 0; i < 4; ) {
                numberList.add(randomGenerator.nextInt(10));
                i++;
            }
        } while (duplicated(numberList));
        return numberList;
    }

    private boolean duplicated(List<Integer> numberList) {
        int number;
        boolean duplicated = false;

        breakFor:
        for (int i = 0; i < numberList.size(); i++) {
            number = numberList.get(i);
            for (int j = i + 1; j < numberList.size(); j++) {
                if (number == numberList.get(j)) {
                    duplicated = true;
                    numberList.clear();
                    break breakFor;
                }
            }
        }

        return duplicated;
    }
}
