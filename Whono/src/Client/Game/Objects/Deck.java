package Client.Game.Objects;

import java.util.Collections;
import java.util.List;

public class Deck
{
	private int DeckID;
	private List<Card> Deck;

	public List<Card> getDeck()
	{
		return Deck;
	}

	@Override
	public String toString()
	{
		return "Client.Game.Objects.Deck";
	}

}
