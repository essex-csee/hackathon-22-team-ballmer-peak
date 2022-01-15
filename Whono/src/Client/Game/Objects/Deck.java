package Client.Game.Objects;

import java.util.Collections;
import java.util.List;

public class Deck
{
	private int deckID;
	private List<Card> deckContents;

	public Deck()
	{
	}

	public int DeckID()
	{
		return deckID;
	}

	public List<Card> getDeckContents()
	{
		return deckContents;
	}

	public void addCard(Card c)
	{
		deckContents.add(c);
	}

	public Card removeCard(Card c)
	{
		// remove card from deck
		// return removed card

		Card toFind = null;

		int i = deckContents.indexOf(c);

		if( i != -1 )
		{
			toFind = deckContents.get(i);
		}

		return toFind;
	}

	public void shuffleDeck(Deck d)
	{
		Collections.shuffle(d.deckContents);
	}

	public Card drawCard()
	{
		if(deckContents.size() > 0)
		{
			return deckContents.remove(0);
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
		out += "DeckCards:'" + deckContents + "',";
		out += "]";
		return out;
	}

}
