package collections;

import java.util.*;

public class CollectionsRunner {

    public static void main(String[] args) {
        List<Card> decOfCards = new ArrayList<>();

        for (Card.Face face : Card.Face.values()) {
            for (Card.Suit suit : Card.Suit.values()) {
                decOfCards.add(new Card(suit, face));
            }
        }

        System.out.println("Origin dec of cards:");

        printOutput(decOfCards);

        Collections.shuffle(decOfCards);

        System.out.println("\n\nDec of cards after shuffle:");

        printOutput(decOfCards);

        Collections.sort(decOfCards, new CardComparator());

        System.out.println("\n\nDec of cards after sort:");

        printOutput(decOfCards);
    }

    private static void printOutput(List<Card> decOfCards) {
        for (int i = 0; i < decOfCards.size(); i++) {
            System.out.printf("%-20s %s", decOfCards.get(i), (i + 1) % 4 == 0 ? "\n" : "  ");
        }
    }

    public static class Card implements Comparable<Card> {

        private enum Suit {SPADES, HEARTS, CLUBS, DIMONDS}

        ;

        private enum Face {Ace, Deuce, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King}

        ;

        private final Suit suit;

        private final Face face;

        public Card(Suit suit, Face face) {
            this.suit = suit;
            this.face = face;
        }

        public Suit getSuit() {
            return suit;
        }

        public Face getFace() {
            return face;
        }

        @Override
        public int compareTo(Card card) {

            Face[] values = Face.values();
            List<Face> faces = Arrays.asList(values);

            if (faces.indexOf(this.face) < faces.indexOf(card.getFace())) {
                return -1;
            } else if (faces.indexOf(this.face) > faces.indexOf(card.getFace())) {
                return +1;
            } else if (faces.indexOf(this.face) == faces.indexOf(card.getFace())) {
                return String.valueOf(suit).compareTo(String.valueOf(card.getSuit()));
            }
            return 0;
        }

        @Override
        public String toString() {
            return face + " of " + suit;
        }
    }

    public static class CardComparator implements Comparator<Card> {
        List<Card.Face> faces = Arrays.asList(Card.Face.values());

        @Override
        public int compare(Card card1, Card card2) {

            if (faces.indexOf(card1.getFace()) < faces.indexOf(card2.getFace())) {
                return 1;
            } else if (faces.indexOf(card1.getFace()) > faces.indexOf(card2.getFace())) {
                return -1;
            } else if (faces.indexOf(card1.getFace()) == faces.indexOf(card2.getFace())) {
                return String.valueOf(card1.suit).compareTo(String.valueOf(card2.getSuit()));
            }
            return String.valueOf(card1.getSuit()).compareTo(String.valueOf(card2.getSuit()));
        }
    }
}