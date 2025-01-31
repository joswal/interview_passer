package stream_challenges.word_filter;

import java.util.stream.Collectors;

public class StreamCharacterFilter {
    public static void main(String[] args) {
        String input = "H3ll0, W@rld! #2024";

        var result = getWordsAndNumbers(input);

        System.out.println(result);  // Output: [H, 3, l, l, 0, W, r, l, d, 2, 0, 2, 4]
    }

    private static String getWordsAndNumbers(String text){

        return text.chars()
                .filter(Character::isLetterOrDigit)
                .mapToObj(value -> String.valueOf((char) value))
                .collect(Collectors.joining());
    }
}
