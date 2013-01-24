package NumberGuessGame;

public class UserChanceCounter {
    private int remainingChance = 6;

    public int getRemainingChance() {
        return remainingChance;
    }

    public void decreaseRemainingChance() {
        remainingChance--;
    }
}
