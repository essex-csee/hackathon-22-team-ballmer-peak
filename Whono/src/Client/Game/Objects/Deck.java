package Client.Game.Objects;

import java.util.Collections;
import java.util.List;

public class Deck
{
	private int DeckID;
	private List<Card> DeckContents;

	public Deck()
	{
	}

	public int DeckID()
	{
		return DeckID;
	}

	public List<Card> getDeckContents()
	{
		return DeckContents;
	}

	public static void addCard(Card c)
	{
		this.DeckContents.add(c);
	}

	public static Card removeCard(Card c)
	{
		// remove card from deck
		// return removed card
	}

	public static void shuffleDeck(Deck d)
	{
		Collections.shuffle(d.DeckContents);
	}

	@Override
	public String toString()
	{
		String out = "";
		out += "Client.Game.Objects.Deck[";
		out += "DeckID:'" + DeckID + "',";
		out += "DeckCards:'" + DeckContents + "',";
		out += "]";
		return out;
	}

}
