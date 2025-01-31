package stream_challenges.word_count;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Author: Joseph Adebajo
 * Date: 31/01/2025
 */
public class MaxOccurringWordCount {

    public static void main(String[] args) {
        String article = "lorem ipsum dolor sit sit amet with the boy whjehjehje Boy boy";

        var result = getMaximumOccurringWord(article);

        System.out.println(result);  // Output: boy
    }

    private static int getMaximumOccurringWord(String article){

        if (article == null || article.isEmpty()) return 0;

        var sanitizedArticle = article.trim().toLowerCase();

        var articleWords = sanitizedArticle.split(" ");


        return Arrays.stream(articleWords)
                        .collect(
                                Collectors.groupingBy(Function.identity(), Collectors.counting())
                        )
                .values()
                .stream()
                .max(Long::compareTo)
                .orElse(0L)
                .intValue();

    }
}
