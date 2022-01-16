package Client.Game.Objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck
{
	public Deck()
	{
		mDeckContents = new ArrayList<>();
	}

	public int DeckID()
	{
		return deckID;
	}

	public List<Card> getDeckContents()
	{
		return mDeckContents;
	}

	public void addCard(Card c)
	{
		mDeckContents.add(c);
	}

	public Card removeCard(Card c)
	{
		// remove card from deck
		// return removed card

		Card toFind = null;

		int i = mDeckContents.indexOf(c);

		if( i != -1 )
		{
			toFind = mDeckContents.get(i);
		}

		return toFind;
	}

	public void shuffle()
	{
		Collections.shuffle(mDeckContents);
	}

	public Card drawCard()
	{
		if(mDeckContents.size() > 0)
		{
			return mDeckContents.remove(0);
		}
		else
		{
			return null;
		}
	}

	@Override
	public String toString()
	{
		String out = "";
		out += "Client.Game.Objects.Deck[";
		out += "DeckID:'" + deckID + "',";
		out += "DeckCards:'" + mDeckContents + "',";
		out += "]";
		return out;
	}

	private int deckID;
	private final List<Card> mDeckContents;

}
