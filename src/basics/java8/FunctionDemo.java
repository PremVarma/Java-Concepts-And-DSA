package basics.java8;

import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {
        Function<Integer, Integer> doubleIt = x -> 2 * x;
        Function<Integer, Integer> tripleIt = x -> 3 * x;
        System.out.println(doubleIt.andThen(tripleIt).apply(10));
        User user = new User("Prem", "Varma", "prem@gmaill.com");
        Function<User, String> userStringFunction = x -> "User: " + x.firstName + " " + x.lastName;
        Function<String, String> userUpperCase = x -> x.toUpperCase();
        System.out.println(userStringFunction.andThen(userUpperCase).apply(user));
        System.out.println(doubleIt.compose(tripleIt).apply(10));
        Function<Integer, Integer> identity = Function.identity();
        System.out.println(identity.apply(5));
    }
}

class User {
    String firstName;
    String lastName;
    String email;

    User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}