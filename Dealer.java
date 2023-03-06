package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.List;

public class Dealer extends Player {

    private List<Card> hand; // the dealer's hand of cards

    public Dealer(){
        super("Dealer");
    }
    public Dealer(String name) {
        super(name);
        hand = new ArrayList<>();
    }

    public void dealCard(Card card) {
        hand.add(card);
    }

    public void showHand() {
        System.out.println("Dealer's hand:");
        for (Card card : hand) {
            System.out.println(card);
        }
    }

    public boolean wantsToHit() {
        int handValue = calculateHandValue();
        return handValue < 17;
    }

    public int calculateHandValue() {
        int handValue = 0;
        int numAces = 0;
        for (Card card : hand) {
            int cardValue = card.getValue();
            if (cardValue == 1) {
                numAces++;
                handValue += 11;
            } else if (cardValue >= 10) {
                handValue += 10;
            } else {
                handValue += cardValue;
            }
        }
        while (handValue > 21 && numAces > 0) {
            handValue -= 10;
            numAces--;
        }
        return handValue;
    }

    @Override
    public void addCardToHand(Card card) {
        if (getHand().size() == 0) {
            System.out.println(getName() + " shows: " + card);
        } else {
            super.addCardToHand(card);
        }
    }
    @Override
    public void play() {
        // dealer plays according to fixed rules
        while (wantsToHit()) {
            System.out.println(getName() + " hits");
            // deal a card to the dealer's hand
            // in a real game, the card would come from a deck
            // here we will just create a random card
            dealCard(new BlackjackCard(Suit.CLUBS, Rank.TWO));

            // display the dealer's hand
            showHand();
        }

        // determine the outcome of the game
        int handValue = calculateHandValue();
        if (handValue > 21) {
            System.out.println(getName() + " busts. You win!");
        } else {
            System.out.println(getName() + " stands");
        }
    }

}
