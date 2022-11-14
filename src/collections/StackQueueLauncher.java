package collections;

import java.util.Stack;

public class StackQueueLauncher {

    public static void main(String[] args) {
        passengerProcessing();
    }

    public static void passengerProcessing() {

        Stack<Passenger> bus = new Stack<>();
        Passenger passenger = new Passenger("Katerina", "Ivanova");
        bus.push(new Passenger("Alex", "Vasko"));
        bus.push(new Passenger("Victor", "Mihailow"));
        bus.push(new Passenger("Dmitriy", "Petrov"));
        bus.push(passenger);
        bus.push(new Passenger("Ivan", "Ivanov"));

        System.out.println("Last passenger entered is: " + bus.peek());

        while (!bus.isEmpty()) {
            System.out.println("Passenger: " + bus.pop());
        }
    }

    private static class Passenger {

        private static int number;
        private String name;
        private String surname;

        public Passenger (String name, String surname) {
            number++;
            this.name = name;
            this.surname = surname;
        }

        public static int getNumber() {
            return number;
        }

        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }

        @Override
        public String toString() {
            return "Passengsr" + number + " is " + name + " " + surname;
        }
    }
}
