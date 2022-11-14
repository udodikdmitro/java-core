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

}
