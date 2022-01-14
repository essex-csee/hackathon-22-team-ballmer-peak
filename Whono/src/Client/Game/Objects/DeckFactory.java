import java.util.Collections;
import java.util.List;

public class DeckFactory
{

	// TODO:This needs the CardTypes and CardNumbers in order to create the deck of cards
	// This could be more modular but ...

	public static Deck createDeck(enum Type, enum Colour)
	{
		Deck deck = new Deck();

		int CardID = 0;
		// Create Wildcards
		for(int i = 0; i < 4; i++)
		{
			Card c = new Card();
			c.CardColour = Colour.BLACK;

			c.CardID = CardID;
			c.CardType = Type.WILD;
			deck.addCard(c);
			CardID++;

			c.CardID = CardID;
			c.CardType = Type.WILD4;
			deck.addCard(c);
			CardID++;
		}
		// Create 'Regular' Cards
		for(int i = 1; i < 13; i++)
		{
			Card c = new Card();
			c.CardID = CardID;
			c.CardType = Type.values()[i];

			c.CardColour = Colour.RED;
			deck.addCard(c);
			CardID++;

			c.CardID = CardID;
			c.CardColour = Colour.GREEN;
			deck.addCard(c);
			CardID++;

			c.CardID = CardID;
			c.CardColour = Colour.BLUE;
			deck.addCard(c);
			CardID++;

			c.CardID = CardID;
			c.CardColour = Colour.YELLOW;
			deck.addCard(c);
			CardID++;
		}

		return deck;
	}
}
