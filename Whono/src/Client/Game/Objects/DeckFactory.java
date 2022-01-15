package Client.Game.Objects;

import Client.Game.Objects.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckFactory
{
	public static Deck createDeck(Card.Type type, Card.Colour colour)
	{
		Deck deck = new Deck();

		int cardID = 0;
		// Create Wildcards
		for(int i = 0; i < 4; i++)
		{
			Card c = new Card();
			c.setCardColour( Card.Colour.BLACK );

			c.setCardID( cardID );
			c.setCardType( Card.Type.WILD );
			deck.addCard(c);
			cardID++;

			c.setCardID( cardID );
			c.setCardType( Card.Type.WILD4 );
			deck.addCard(c);
			cardID++;
		}
		// Create 'Regular' Cards
		for(int i = 1; i < 13; i++)
		{
			Card c = new Card();
			c.setCardID( cardID );
			c.setCardType( Card.Type.values()[i] );

			c.setCardColour( Card.Colour.RED );
			deck.addCard(c);
			cardID++;

			c.setCardID( cardID );
			c.setCardColour( Card.Colour.GREEN );
			deck.addCard(c);
			cardID++;

			c.setCardID( cardID );
			c.setCardColour( Card.Colour.PURPLE );
			deck.addCard(c);
			cardID++;

			c.setCardID( cardID );
			c.setCardColour(Card.Colour.YELLOW );
			deck.addCard(c);
			cardID++;
		}

		return deck;
	}
}
