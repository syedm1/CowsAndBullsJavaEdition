package src;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.Collectors;

public final class Utils {
    private static Utils uniqueInstance;

    private Utils() {
    }

    public static Utils getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Utils();
        }
        return uniqueInstance;
    }

    public static List<Character> stringToCharList(@NotNull String input) {
        return input.chars()
                .mapToObj(e -> (char) e)
                .collect(Collectors.toList());
    }


    public static boolean stringIsNullOrEmpty(@NotNull String input) {
        if (input.isEmpty() || input == null) {
            return true;
        }
        return false;
    }

    public static int charToInt(@NotNull char num) {
        return Character.getNumericValue(num);
    }

    public static boolean isInteger(String input) {
        return input.matches("-?\\d+");
    }
}
