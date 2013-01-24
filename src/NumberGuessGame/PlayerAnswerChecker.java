package NumberGuessGame;

import NumberGuessGame.exceptions.InvalidNumberSizeException;
import NumberGuessGame.exceptions.NumberOutOfRangeException;
import NumberGuessGame.exceptions.NumberSequenceInvalidException;

import java.util.List;

public class PlayerAnswerChecker {

    protected void checkValidity(List<Integer> numberList) {
        try {
            checkNumberSizeValidity(numberList);
            checkNumberRangeValidity(numberList);
            checkSequenceValidity(numberList);
        } catch (NumberOutOfRangeException e) {
            e.printStackTrace();
        } catch (NumberSequenceInvalidException e) {
            e.printStackTrace();
        } catch (InvalidNumberSizeException e) {
            e.printStackTrace();
        }
    }

    public void checkSequenceValidity(List<Integer> numberList) throws NumberSequenceInvalidException {
        for (int i = 0; i < numberList.size(); i++) {
            int theNumber = numberList.get(i);
            for (int j = i + 1; j < numberList.size(); j++) {
                if (theNumber == numberList.get(j))
                    throw new NumberSequenceInvalidException("Pleas input four different numbers");
            }
        }

    }

    public void checkNumberRangeValidity(List<Integer> numberList) throws NumberOutOfRangeException {
        for (Integer integer : numberList) {
            if (integer < 0 || integer > 9)
                throw new NumberOutOfRangeException("Pleas input number between 1 and 9 (inclusive)");
        }
    }

    public void checkNumberSizeValidity(List<Integer> expectedList) throws InvalidNumberSizeException {
        if (expectedList.size() != 4) {
            throw new InvalidNumberSizeException("Please input exactly FOUR numbers");
        }
    }
}
