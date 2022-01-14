package Client.Game.Objects;

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

	public Card
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
		BLACK, RED, GREEN, BLUE, YELLOW;
	}

	private int CardID;
	private Type CardType;
	private Colour CardColour;

	public Type getCardType()
	{
		return CardType;
	}

	public Colour getCardColour()
	{
		return CardColour;
	}

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
		return "Client.Game.Objects.Card [CardID:'" + CardID +"',CardType:'" +  CardType + "',CardColour:'" + CardColour + "'];
	}

}
