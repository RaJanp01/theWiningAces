/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class that models each Player in the game. Players have an identifier,
 * which should be unique.
 *
 * @author Chiyan Miller, March 3,2023
 */
public abstract class Player {

    private String name; // the unique name for this player
    private List<Card> hand;
    /**
     * A constructor that allows you to set the player's unique ID
     *
     * @param name the unique ID to assign to this player.
     */
    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    /**
     * @return the player name
     */
    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }

    /**
     * Ensure that the playerID is unique
     *
     * @param name the player name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    public int getHandValue() {
        int value = 0;
        boolean hasAce = false;
        for (Card card : hand) {
            if (card.getRank() == Rank.ACE) {
                hasAce = true;
            }
            value += card.getValue();
        }
        if (hasAce && value <= 11) {
            value += 10;
        }
        return value;
    }

    public void addCardToHand(Card card) {
        hand.add(card);
    }

    /**
     * The method to be overridden when you subclass the Player class with your
     * specific type of Player and filled in
     * with logic to play your game.
     */
    public abstract void play();

    public String toString() {
        String str = name + "'s hand:";
        for (Card card : hand) {
            str += " " + card;
        }
        str += " (Value: " + getHandValue() + ")";
        return str;
    }
}

