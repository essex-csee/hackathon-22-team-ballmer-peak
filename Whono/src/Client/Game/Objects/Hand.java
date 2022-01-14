package Client.Game.Objects;

import java.util.List;
import java.util.Collections;

public class Hand
{
	private int handID;
	private List<Card> hand;
	private int handSize;
	private int handSizeLimit;

	public Hand(int limit)
	{
		handSizeLimit = limit;
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

	public Card removecard(Card c)
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


	public int gethandid()
	{
		return handID;
	}

	public List<Card> gethand()
	{
		return hand;
	}

	public int gethandsize()
	{
		return handSize;
	}

	@Override
	public String toString()
	{
		String out = "";
		out += "client.game.objects.Hand[";
		out += "deckid:'" + handID + "',";
		out += "hand:'" + hand + "',";
		out += "handsize:'" + handSize + "',";
		out += "]";
		return out;
	}

}
