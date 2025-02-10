package io.github.nathensample.craftsman.util;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringUtils {
    public static String capitalizeWords(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        return Arrays.stream(str.split("\\s+")) // Split by spaces
                .map(word -> word.isEmpty() ? word :
                        Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase()) // Capitalize first letter
                .collect(Collectors.joining(" ")); // Rejoin words with space
    }
}
