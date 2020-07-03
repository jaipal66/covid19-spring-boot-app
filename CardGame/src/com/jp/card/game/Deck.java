package com.jp.card.game;

public class Deck {

	private static final int NUMBER_OF_CARDS = 52;
	private Card cards[] = new Card[NUMBER_OF_CARDS];
	private int numCards=0;

	public Deck() {
		int i = 0;
		for (int suit = Suit.HEARTS.ordinal(); suit <= Suit.SPADES.ordinal(); suit++) {
			for (int rank = Rank.ACE.ordinal(); rank <= Rank.KING.ordinal(); rank++) {
				Card card = new Card(Suit.values()[suit], Rank.values()[rank]);
				cards[i++] = card;
			}

		}
		this.numCards=52;
	}

	public Card deal() {
		if(numCards==0)
			return null;
		return cards[numCards--];
	}

	public void shuffle(int n) {
		int i, j, k;
		for (k = 0; k < n; k++) {
			i = (int) (NUMBER_OF_CARDS * Math.random()); // Pick 2 random cards
			j = (int) (NUMBER_OF_CARDS * Math.random()); // in the deck
			Card tmp = cards[i];
			cards[i] = cards[j];
			cards[j] = tmp;
		}
		numCards = 52; // Reset current card to deal from top of deck
	}

	public String toString() {
		String result = "";
		int k;

		k = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j <= 13; j++)
				result += (cards[k++] + " ");

			result += "\n"; // Add NEWLINE after 13 cards
		}
		return result;
	}
}
