package client.game.objects;

import java.util.collections;
import java.util.list;

public class Hand
{
	private int handID;
	private list<card> hand;
	private int handSize;
	private int handSizeLimit;

	public Hand(int limit)
	{
		handsizeLimit = limit;
	}

	public boolean addCard(Card c)
	{
		if((handsize + 1) > handlimit)
		{
			return false;
		}
		hand.add(c);
		handsize++;
		return true;

	}

	public card removecard(card c)
	{

		hand.remove(c);
		handsize--;
	}

	public card removeRandomCard()
	{
		int index = (int) ((Math.random() * handsize));
		hand.remove(index);
		handsize--;
	}


	public int gethandid()
	{
		return handid;
	}

	public list<card> gethand()
	{
		return hand;
	}

	public int gethandsize()
	{
		return handsize;
	}

	@override
	public string tostring()
	{
		string out = "";
		out += "client.game.objects.Hand[";
		out += "deckid:'" + handid + "',";
		out += "hand:'" + hand + "',";
		out += "handsize:'" + handsize + "',";
		out += "]";
		return out;
	}

}
