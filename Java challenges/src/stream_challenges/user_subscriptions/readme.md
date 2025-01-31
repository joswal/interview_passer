if you have a class User with field subscriptions List<Integer> , write a function to get the top 3 most popular subscriptions

```java

class User {
    List<Integer> subscriptions;

    public User(List<Integer> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public List<Integer> getSubscriptions() {
        return subscriptions;
    }
}

```