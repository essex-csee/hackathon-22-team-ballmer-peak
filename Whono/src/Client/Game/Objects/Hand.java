package Client.Game.Objects;

import java.util.List;
import java.util.Collections;

public class Hand
{
	private int handID;
	private List<Card> hand;
	private int handSize;
	private int handSizeLimit;

	public Hand()
	{
	}

	public boolean addCard(Card c)
	{
		if((handSize + 1) > handSizeLimit)
		{
			return false;
		}
		hand.add(c);
		handSize++;
		return true;

	}

	public Card removeCard(Card c)
	{

		hand.remove(c);
		handSize--;

		return c;
	}

	public Card removeRandomCard()
	{
		int index = (int) ((Math.random() * handSize));
		Card removed = hand.remove(index);

		if(removed != null) // check a card has been removed before dec'ing
		{
			handSize--;
		}

		return removed;
	}


	public int getHandID()
	{
		return handID;
	}

	public List<Card> getHand()
	{
		return hand;
	}

	public int getHandSize()
	{
		return handSize;
	}

	public void setHandID(int id)
	{
		handID = id;
	}

	public void setHandSizeLimit(int limit)
	{
		handSizeLimit = limit;
	}

	@Override
	public String toString()
	{
		String out = "";
		out += "client.game.objects.Hand[";
		out += "deckID:'" + handID + "',";
		out += "hand:'" + hand + "',";
		out += "handSize:'" + handSize + "',";
		out += "handSizeLimit:'" + handSizeLimit + "',";
		out += "]";
		return out;
	}

}