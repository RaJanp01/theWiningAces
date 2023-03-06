package ca.sheridancollege.project;

import java.util.Scanner;

public class BlackjackGame {
/*
 * @author Chiyan Miller, March 3,2023
 * @author Rajan Poudel, March 3 2023.
 */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Create a new deck of cards and shuffle it
        DeckOfCards deck = new DeckOfCards();
        DeckOfCards.shuffleDeck();

        // Create players
        System.out.print("Enter the number of players: ");
        int numPlayers = input.nextInt();
        Player[] players = new Player[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter name of player " + (i + 1) + ": ");
            String playerName = input.next();
            players[i] = new Player(playerName);
        }

        // Deal two cards to each player and dealer
        for (int i = 0; i < numPlayers; i++) {
            players[i].addCardToHand(deck.dealCard());
            players[i].addCardToHand(deck.dealCard());
        }
        Dealer dealer = new Dealer();
        dealer.addCardToHand(deck.dealCard());
        dealer.addCardToHand(deck.dealCard());

        // Play the game
        boolean gameOver = false;
        while (!gameOver) {

            // Print the current state of the game
            System.out.println();
            for (int i = 0; i < numPlayers; i++) {
                System.out.println(players[i]);
            }
            System.out.println(dealer);

            // Players take turns
            for (int i = 0; i < numPlayers; i++) {
                boolean done = false;
                while (!done) {
                    System.out.print(players[i].getName() + ", do you want to hit (H) or stand (S)? ");
                    String choice = input.next();
                    if (choice.equalsIgnoreCase("H")) {
                        players[i].addCardToHand(deck.dealCard());
                        System.out.println(players[i]);
                        if (players[i].getHandValue() > 21) {
                            System.out.println(players[i].getName() + " busts!");
                            done = true;
                        }
                    } else {
                        done = true;
                    }
                }
            }

            // Dealer's turn
            while (dealer.getHandValue() < 17) {
                dealer.addCardToHand(deck.dealCard());
                System.out.println(dealer);
                if (dealer.getHandValue() > 21) {
                    System.out.println("Dealer busts!");
                    gameOver = true;
                }
            }

            // Determine the winner(s)
            int dealerHandValue = dealer.getHandValue();
            for (int i = 0; i < numPlayers; i++) {
                int playerHandValue = players[i].getHandValue();
                if (playerHandValue > 21) {
                    System.out.println(players[i].getName() + " loses - busted!");
                } else if (dealerHandValue > 21) {
                    System.out.println(players[i].getName() + " wins - dealer busted!");
                } else if (playerHandValue > dealerHandValue) {
                    System.out.println(players[i].getName() + " wins!");
                } else if (playerHandValue < dealerHandValue) {
                    System.out.println(players[i].getName() + " loses!");
                } else {
                    System.out.println(players[i].getName() + " ties with dealer!");
                }
            }

            // Play another round?
            System.out.print("Play another round? (Y/N) ");
            String playAgain = input.next();
            if (playAgain.equalsIgnoreCase("N"))
                ;
        }
    }
}
