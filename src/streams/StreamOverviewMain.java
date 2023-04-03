package streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOverviewMain {

    private static List<Employee> employeeList = new ArrayList<>();
    private static Map<Integer, Employee> employeeMap = null;

    public static void main(String[] args) throws IOException {
        employeeList.add(new Employee(1, "Alex", "Black", 50000));
        employeeList.add(new Employee(2, "John", "Green", 75000));
        employeeList.add(new Employee(3, "Sam", "Brown", 80000));
        employeeList.add(new Employee(4, "Tony", "Grey", 90000));
        employeeList.add(new Employee(5, "Mike", "Yellow", 60000));
        employeeList.add(new Employee(6, "Victoria", "Pink", 75000));
        employeeList.add(new Employee(7, "Seam", "Magenta", 80000));
        employeeList.add(new Employee(8, "Kate", "Black", 880000));
        employeeList.add(new Employee(9, "Tony", "Grey", 90000));
        employeeList.add(new Employee(10, "Mike", "Yellow", 60000));
        employeeList.add(new Employee(11, "Victoria", "Pink", 750000));

        testStreamFromList();
        testStreamFromFile();
    }

    private static void testStreamFromList() {
        employeeList.stream()
                .filter(e -> e.getSalary() > 60000)
                .filter(e -> e.getId() < 10)
                .toList()
                .forEach(System.out::println);

        Integer[] ids = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

        System.out.println("----------------------------------");
        Stream.of(ids)
                .map(StreamOverviewMain::findById)
                .filter(Objects::nonNull)
                .toList()
                .forEach(System.out::println);

        System.out.println("----------------------------------");

        Optional<Employee> first = Stream.of(ids)
                .map(StreamOverviewMain::findById)
                .filter(Objects::nonNull)
                .findFirst();
    }

    private static void testStreamFromFile() throws IOException{
        Files.lines(Paths.get("out.txt"))
                .filter(e -> e.length() > 4)
                .map(String::toUpperCase)
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }

    private static Employee findById(int id){
        if (employeeMap == null){
            employeeMap = employeeList.stream()
                    .distinct()
                    .collect(Collectors.toMap(Employee::getId, e -> e));
        }
        return  employeeMap.get(id);
    }
}
