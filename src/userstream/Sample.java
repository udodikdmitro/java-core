package userstream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sample {
    private final List<User> userList = Arrays.asList(
            new User(1, "Michael", "Robert", 37, "TR"),
            new User(2, "Mary", "Patricia", 11, "EN"),
            new User(3, "John", "Michael", 7, "FR"),
            new User(4, "Jennifer", "Linda", 77, "TR"),
            new User(5, "William", "Elizabeth", 23, "US"),
            new User(6, "Sue", "Jackson", 11, "IT"),
            new User(7, "Michael", "Tommy", 37, "EN")
    );

    void test1() {
        System.out.println("Test 1");
        userList.stream()
                .forEach(System.out::println);
    }

    void test2() {
        System.out.println("Test 2");
        userList.stream()
                .map(u -> {
                    long a = u.getId();
                    return new User(
                            u.getId(),
                            "X " + u.getFirstName(),
                            "Y " + u.getLastName(),
                            u.getAge() + 10,
                    u.getNationality());
                })
                .forEach(System.out::println);
    }

    void test3() {
        System.out.println("Test 3");
        userList.stream()
                .sorted(Comparator.comparing(User::getAge))
                .forEach(System.out::println);
    }

    void test4() {
        System.out.println("Test 4");
        userList.stream()
                .sorted(Comparator.comparing(User::getAge)
                        .thenComparing(User::getFirstName)
                        .thenComparing(User::getLastName))
                .forEach(System.out::println);
    }

    void test5(){
        System.out.println("Test 5");
        List<Long> list = userList.stream()
                .filter(x -> x.getAge() > 11)
                .map(User::getId)
                .toList();
        list.forEach(System.out::println);
    }
}
