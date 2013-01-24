package NumberGuessGame;

public class ResultReporter {
    public static String presentResult(int totalMatch, int halfMatch) {
        return totalMatch + "A" + halfMatch + "B";
    }
}
