package Client.Game.Objects;

import java.util.Collections;
import java.util.List;

public class Board
{
	private int boardID;
	private List<Deck> decks;
	private List<Hand> hands;
	private List<Card> pile;

	public Board()
	{
	}

	public void addDeck(Deck d)
	{
		decks.add(d);
	}

	public void addHand(Hand h)
	{
		hands.add(h);
	}

	public void addToPile(Card c)
	{
		pile.add(c);
	}

	public int getBoardID()
	{
		return boardID;
	}


	public List<Deck> getDecks()
	{
		return decks;
	}

	public List<Hand> getHands()
	{
		return hands;
	}

	public List<Card> getPile()
	{
		return pile;
	}

	public Deck removeDeck(Deck d)
	{
		Deck removed = null;
		int index = decks.indexOf(d);
		if(index != 1)
		{
			removed = decks.get(index);
		}

		return removed;
	}
	public Hand removeHand(Hand h)
	{
		Hand removed = null;
		int index = pile.indexOf(h);
		if(index != 1)
		{
			removed = hands.get(index);
		}

		return removed;
	}

	public Card removeCard(Card c)
	{
		Card removed = null;
		int index = pile.indexOf(c);
		if(index != 1)
		{
			removed = pile.get(index);
		}

		return removed;
	}

	@Override
	public String toString()
	{
		String out = "";
		out += "Client.Game.Object.Board[";
		out += "boardID:'" + boardID + "',";
		out += "decks:'" + decks + "',";
		out += "hands:'" + hands + "',";
		out += "pile:'" + pile + "',";
		return out;
	}

}
