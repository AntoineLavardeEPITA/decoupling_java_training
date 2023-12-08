package fr.lernejo.guessgame;

public class ComputerPlayer implements Player {

    long min = 0;
    long max = 100;

    @Override
    public long askNextGuess() {
        return min + (max - min) / 2;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater) {
            min = askNextGuess();
        } else {
            max = askNextGuess();
        }
    }
}