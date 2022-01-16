package Client.Game.Objects;

import Client.Game.Objects.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckFactory
{
	public static Deck createDeck()
	{
		Deck deck = new Deck();

		int cardID = 0;

		/* put this back after wildcards work!
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
		*/

		// Create 'Regular' Cards
		// 14 card types normally temp reduced to 10 as effect cards are currently un implemented
		for(int i = 0; i < 10; i++)
		{
			Card c = new Card();
			c.setCardID( cardID );
			c.setCardType( Card.Type.values()[i] );

			c = new Card();
			c.setCardColour( Card.Colour.RED );
			c.setCardType( Card.Type.values()[i] );
			deck.addCard(c);
			cardID++;

			c = new Card();
			c.setCardID( cardID );
			c.setCardColour( Card.Colour.GREEN );
			c.setCardType( Card.Type.values()[i] );
			deck.addCard(c);
			cardID++;

			c = new Card();
			c.setCardID( cardID );
			c.setCardColour( Card.Colour.PURPLE );
			c.setCardType( Card.Type.values()[i] );
			deck.addCard(c);
			cardID++;

			c = new Card();
			c.setCardID( cardID );
			c.setCardColour(Card.Colour.YELLOW );
			c.setCardType( Card.Type.values()[i] );
			deck.addCard(c);
			cardID++;
		}

		return deck;
	}
}
