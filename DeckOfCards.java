package ca.sheridancollege.project;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckOfCards {
    
    private static List<Card> deck;
    
    public DeckOfCards() {
        deck = new ArrayList<Card>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deck.add(new Card(rank, suit));
            }
        }
    }
    
    public static void shuffleDeck() {
        Collections.shuffle(deck);
    }
    
    public Card dealCard() {
        return deck.remove(0);
    }
    
}

