package ca.sheridancollege.project;

public class BlackjackCard extends Card {
    private final Suit suit;
    private final Rank rank;

    public BlackjackCard(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    public int getValue() {
        if (rank == Rank.ACE) {
            return 11;
        } else if (rank == Rank.JACK || rank == Rank.QUEEN || rank == Rank.KING) {
            return 10;
        } else {
            return rank.ordinal() + 1;
        }

    }
}
