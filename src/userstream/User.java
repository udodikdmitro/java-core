package userstream;

public class User {
        private long id;
        private String firstName;
        private String lastName;
        private int age;
        private String nationality;

    public User(long id, String firstName, String lastName, int age, String nationality) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.nationality = nationality;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getNationality() {
        return nationality;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
