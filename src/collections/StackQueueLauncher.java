package collections;

import java.util.*;

public class StackQueueLauncher {

    public static void main(String[] args) {
//        passengerProcessing();

        Queue<Card> cardDeck = new PriorityQueue<>(52, new CardComparator());
        for (Card.Face face: Card.Face.values()){
            for(Card.Suit suit: Card.Suit.values()) {
                cardDeck.offer(new Card(suit, face));
            }
        }

        Deque<Card> cards = new ArrayDeque<>();
        for (int i = 0; i < 10; i++) {
            System.out.println(cardDeck.poll());
        }

        System.out.println("Deck size is: " + cardDeck.size());
        System.out.println(cardDeck.peek());
        cardDeck.clear();;
        System.out.println("Deck size after clear is: " + cardDeck.size());

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
