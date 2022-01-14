package Client.Game.Objects;

import java.util.Collections;
import java.util.List;

public class Deck
{
	private int DeckID;
	private List<Card> DeckContents;

	public Deck
	{
	}

	public Deck getDeck()
	{
		return this;
	}

	public List<Card> getDeckContents()
	{
		return DeckContents;
	}


	@Override
	public String toString()
	{
		String out;
		out += "Client.Game.Objects.Deck[";
		out += "DeckID:'" + DeckID + "',";
		out += "DeckCards:'" + DeckContents + "',";
		out += "]"
		return out;
	}

}
