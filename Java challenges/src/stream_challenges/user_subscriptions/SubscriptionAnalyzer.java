package stream_challenges.user_subscriptions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Author: Joseph Adebajo
 * Date: 31/01/2025
 */
public class SubscriptionAnalyzer {

    static class User {
        List<Integer> subscriptions;

        public User(List<Integer> subscriptions) {
            this.subscriptions = subscriptions;
        }

        public List<Integer> getSubscriptions() {
            return subscriptions;
        }
    }
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User(Arrays.asList(1, 2, 3)),
                new User(Arrays.asList(2, 3, 4)),
                new User(Arrays.asList(3, 4, 5)),
                new User(Arrays.asList(1, 2, 5))
        );

        var result = getTop3Subscriptions(users);

        System.out.println(result.toString());  // Output: boy
    }

    private static List<Integer> getTop3Subscriptions(List<User> users){
        return users.stream()
                .flatMap(user -> user.getSubscriptions().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();

    }
}
