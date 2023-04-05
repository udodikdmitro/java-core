package streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOverviewMain {

    private static List<Employee> employeeList = new ArrayList<>();
    private static List<Employee> secondList = new ArrayList<>();
    private static Map<Integer, Employee> employeeMap = null;

    public static void main(String[] args) throws IOException {
        secondList.add(new Employee(1, "Alex", "Black", 50000, "IT"));
        secondList.add(new Employee(2, "John", "Green", 75000,"IT"));
        secondList.add(new Employee(3, "Sam", "Brown", 80000,"IT"));
        secondList.add(new Employee(4, "Tony", "Grey", 90000,"IT"));
        secondList.add(new Employee(5, "Mike", "Yellow", 60000,"IT"));
        secondList.add(new Employee(6, "Victoria", "Pink", 75000,"IT"));
        secondList.add(new Employee(7, "Seam", "Magenta", 80000, "Finance"));
        secondList.add(new Employee(8, "Kate", "Black", 880000, "Finance"));
        secondList.add(new Employee(9, "Tony", "Grey", 90000, "Finance"));
        secondList.add(new Employee(10, "Mike", "Yellow", 60000,"IT"));
        secondList.add(new Employee(11, "Victoria", "Pink", 750000,"IT"));

//        employeeList.add(new Employee(1, "Alex", "Black", 50000));
//        employeeList.add(new Employee(2, "John", "Green", 75000));
//        employeeList.add(new Employee(3, "Sam", "Brown", 80000));
//        employeeList.add(new Employee(4, "Tony", "Grey", 90000));
//        employeeList.add(new Employee(5, "Mike", "Yellow", 60000));
//        employeeList.add(new Employee(6, "Victoria", "Pink", 75000));
//        employeeList.add(new Employee(7, "Seam", "Magenta", 80000));
//        employeeList.add(new Employee(8, "Kate", "Black", 880000));
//        employeeList.add(new Employee(9, "Tony", "Grey", 90000));
//        employeeList.add(new Employee(10, "Mike", "Yellow", 60000));
//        employeeList.add(new Employee(11, "Victoria", "Pink", 750000));

//        testStreamFromList();
//        testStreamFromFile();
//        testSortAndReduce();
//        partitionByIncome();
//        groupByCriterion(Employee::getDepartment);
//        testStreamGenerator(10);
//        testStreamIterator(10);
        testParallelStream();
    }

    private static void testParallelStream() throws IOException {
        employeeList
                .stream()
                .map(Employee::getId)
                .sorted()
                .collect(Collectors.toList())
                .forEach(System.out::println);

        Files.lines(Paths.get("out.txt"))
                .parallel()
                .sorted()
                .forEach(System.out::println);
    }

    private static void testStreamIterator(int limit){
        Stream.iterate(1, e -> e * 3).limit(limit).forEach(System.out::println);
    }

    private static void testStreamGenerator(int limit){
        Stream.generate(Math::random).limit(limit).forEach(System.out::println);
    }

    private static <R> void groupByCriterion(Function<Employee, R> function){
        Map<R, List<Employee>> collectedEmployees = employeeList.stream()
                .collect(Collectors.groupingBy(function));
        collectedEmployees.keySet()
                .forEach(e -> System.out.println(e + "\n" + collectedEmployees.get(e)));
    }

    private static void partitionByIncome(){
        Map<Boolean, List<Employee>> collectedEmployees = employeeList.stream()
                .collect(Collectors.partitioningBy(e -> e.getSalary() > 70000));

        System.out.println("Poor employees:");
        System.out.println(collectedEmployees.get(false));
        System.out.println("---------------------------");
        System.out.println("Rich employees:");
        System.out.println(collectedEmployees.get(true));
    }

//    private static void testSortAndReduce(){
//        Employee employee = employeeList.stream()
//                .max(Comparator.comparingInt(Employee::getId))
//                .get();
//
//        Employee employee1 = employeeList.stream()
//                .min(Comparator.comparingInt(Employee::getSalary)).get();
//
//        System.out.println("Identity names:");
//        employeeList.stream()
//                .sorted((s1, s2) -> s1.getFirstName().compareTo(s2.getFirstName()))
//                .distinct()
//                .toList()
//                        .forEach(System.out::println);
//
//        System.out.println(employee);
//        System.out.println(employee1);
//
//        System.out.println("----------------------------");
//        Employee identity = new Employee(0, "", "", 0);
//        Employee reduceEmployee = employeeList.stream()
//                .reduce(identity, (e1, e2) -> {
//                    e1.setId(e1.getId() + e2.getId());
//                    e1.setSalary(e1.getSalary() + e2.getSalary());
//                    return e1;
//                });
//
//        System.out.println(reduceEmployee);
//    }

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

        Random r = new Random();
        Integer integer = Stream.of(ids)
                .filter(i -> i % 2 == 0)
                .filter(i -> i % 3 == 0)
                .filter(i -> i % 5 == 0)
                .skip(2)
                .findFirst()
                .orElseGet(() -> r.nextInt());

        OptionalDouble average = Stream.of(ids)
                .map(StreamOverviewMain::findById)
                .filter(Objects::nonNull)
                .mapToInt(Employee::getSalary)
                .average();

        List<List<Employee>> department = new ArrayList<>();
        department.add(employeeList);
        department.add(secondList);

        department.stream()
                .flatMap(l -> l
                        .stream()
                        .map(e -> e.getFirstName()))
                .forEach(System.out::println);

        Consumer<Integer> c = e -> e = e *2;
        Stream.of(ids)
                .peek(c)
                .forEach(System.out::println);
    }

    private static void testStreamFromFile() throws IOException{
        Files.lines(Paths.get("out.txt"))
                .filter(e -> e.length() > 4)
                .map(String::toUpperCase)
                .distinct()
                .sorted()
                .collect(Collectors.toCollection(ArrayList::new))
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
