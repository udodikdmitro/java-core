package arrays;

import java.util.*;

abstract public class ListRunner {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        ToDoList list = new ToDoList();
        int param = scanner.nextInt();

        while (param != 0) {
            switch (param) {
                case 1:
                    System.out.println("Please enter a task to add:");
                    scanner.nextLine();
                    String task1 = scanner.nextLine();
                    list.addToList(task1);
                    System.out.println("Please choose an action by typing [0-6]");
                    param = scanner.nextInt();
                    break;
                case 2:
                    System.out.println("Printing out TO DO LIST:");
                    list.printToDoList();
                    System.out.println("Please choose an action by typing [0-6]");
                    param = scanner.nextInt();
                    break;
                case 3:
                    System.out.println("Please enter an item to update:");
                    scanner.nextLine();
                    int i = scanner.nextInt();
                    System.out.println("Please enter a new task:");
                    scanner.nextLine();
                    String task3 = scanner.nextLine();
                    list.changeTask(i, task3);
                    System.out.println("Please choose an action by typing [0-6]");
                    param = scanner.nextInt();
                    break;
                case 4:
                    System.out.println("Please enter a task to remove:");
                    scanner.nextLine();
                    String task4 = scanner.nextLine();
                    list.removeTask(task4);
                    System.out.println("Please choose an action by typing [0-6]");
                    param = scanner.nextInt();
                    break;
                case 5:
                    System.out.println("Please enter a task to get priority:");
                    scanner.nextLine();
                    String task5 = scanner.nextLine();
                    System.out.println("Priority of the task is " + list.getTaskPriority(task5));
                    System.out.println("Please choose an action by typing [0-6]");
                    param = scanner.nextInt();
                    break;
                case 6:
                    System.out.println("Please enter a task to add:");
                    scanner.nextLine();
                    int index = scanner.nextInt();
                    System.out.println("Please enter a new task:");
                    scanner.nextLine();
                    String task6 = scanner.nextLine();
                    list.changeTask(index, task6);
                    System.out.println("Please choose an action by typing [0-6]");
                    param = scanner.nextInt();
                    break;
                default:
                    param = 0;
            }
        }
    }
}
