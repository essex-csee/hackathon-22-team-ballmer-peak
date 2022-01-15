package Client.Game.Objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Card implements Comparable<Card>
{
	// Following enums are specific to UNO
	// 	commented out is a regular deck of cards

	/*

	   public enum Number
	   {
	   	TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE;
	   }

	   public enum Suit
	   {
	   	HEART, DIAMOND, CLUB, SPADE;
	   }

	*/

	/*
		1-12 Red/Green/Blue/Yellow
		4 x 13
		4 x 14
	 */

	public Card()
	{
	}

	public enum Type
	{
		ONE(1),TWO(2),THREE(3),FOUR(4),FIVE(5),SIX(6),SEVEN(7),EIGHT(8),NINE(9),REVERSE(10),SKIP(11),DRAW2(12),WILD(13),WILD4(14);
		private int order;
		private Type(int i)
		{
			this.order = i;
		}
		public int getOrder()
		{
			return order;
		}
	}

	public enum Colour
	{
		 GREEN, PURPLE, RED, YELLOW, BLACK;
	}

	public int getCardID()
	{
		return CardID;
	}

	public void setCardID(int cardID)
	{
		CardID = cardID;
	}

	public Type getCardType()
	{
		return CardType;
	}

	public void setCardType(Type cardType)
	{
		CardType = cardType;
	}

	public Colour getCardColour()
	{
		return cardColour;
	}

	public void setCardColour(Colour cardColour)
	{
		this.cardColour = cardColour;
	}

	private int CardID;
	private Type CardType;
	private Colour cardColour;


	public void shuffleCards(List<Card> cards)
	{
		Collections.shuffle(cards);
	}

	/*

	Create a basic deck of cards using Suits and Numbers

	public List<Card> createDeck()
	{
		List<Card> out = new ArrayList<Card>();

		int id = 0;
		for(Number n : Number.values())
		{
			for(Suit s : Suit.values())
			{
				Card c = new Card();
				c.CardID = id;
				c.CardType = n;
				c.CardColour = s;
				out.add(c);
				i++;
			}
		}
		return out;
	}
	*/

	public List<Card> createDeck()
	{
		List<Card> deck = new ArrayList<Card>();
		int id = 0;
		// Create Wildcards
		for(int i = 0; i < 4; i++)
		{
			Card c = new Card();
			c.cardColour = Colour.BLACK;

			c.CardID = id;
			c.CardType = Type.WILD;
			deck.add(c);
			id++;

			c.CardID = id;
			c.CardType = Type.WILD4;
			deck.add(c);
			id++;
		}
		// Create 'Regular' Cards
		for(int i = 1; i < 13; i++)
		{
			Card c = new Card();
			c.CardID = id;
			c.CardType = Type.values()[i];

			c.cardColour = Colour.RED;
			deck.add(c);
			id++;

			c.CardID = id;
			c.cardColour = Colour.GREEN;
			deck.add(c);
			id++;

			c.CardID = id;
			c.cardColour = Colour.PURPLE;
			deck.add(c);
			id++;

			c.CardID = id;
			c.cardColour = Colour.YELLOW;
			deck.add(c);
			id++;
		}

		return deck;
	}

	@Override
	public int compareTo(Card other)
	{
		if((this.getCardType() == other.getCardType()) && (this.getCardColour() == other.getCardColour()))
		{
			return 0;
		}
		if(this.getCardType().getOrder() > other.getCardType().getOrder())
		{
			return 1;
		}
		else
		{
			return -1;
		}
	}

	@Override
	public String toString()
	{
		return "Client.Game.Objects.Card [CardID:'" + CardID +"',CardType:'" +  CardType + "',CardColour:'" + cardColour + ']';
	}

}
