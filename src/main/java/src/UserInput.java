package src;

import src.interfaces.InputInterface;

public class UserInput implements InputInterface {
    int guess;
    @Override
    public boolean setInput(String arg) {
        try {
            guess = Integer.parseInt(arg);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public String getInput() {
        return String.valueOf(guess);
    }
}
