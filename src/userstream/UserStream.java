package userstream;

import java.util.Arrays;
import java.util.List;

public class UserStream {

    private long id;
    private String firstName;
    private String lastName;
    private int age;
    private String nationality;

    public UserStream(long id, String firstName, String lastName, int age, String nationality) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.nationality = nationality;
    }


    public static void main(String[] args) {
        test1();
    }
    public static List<UserStream> userList = Arrays.asList(
                new UserStream(1, "Michael", "Robert", 37, "TR"),
                new UserStream(2, "Mary", "Patricia", 11, "EN"),
                new UserStream(3, "John", "Michael", 7, "FR"),
                new UserStream(4, "Jennifer", "Linda", 77, "TR"),
                new UserStream(5, "William", "Elizabeth", 23, "US"),
                new UserStream(6, "Sue", "Jackson", 11, "IT"),
                new UserStream(7, "Michael", "Tommy", 37, "EN")
        );

    private static void test1() {
            System.out.println("Test 1");
            userList.stream()
                    .forEach(System.out::println);
        }


}
