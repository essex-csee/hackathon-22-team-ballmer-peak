package Client.Game.Objects.GameScreen;

import Client.Game.Objects.Card;
import Client.Game.Objects.Deck;
import Client.Game.Objects.GameObject;
import Client.Game.Objects.GameScreen.CardButton;
import Client.Game.Objects.GameScreen.CardDisplay;
import Client.Game.Objects.Hand;
import Util.ISubscribable;
import Util.ISubscriber;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Board extends GameObject implements ISubscriber
{
	private ArrayList<Deck> mDecks;
	private ArrayList<DeckButton>  mDeckDisplays;
	private ArrayList<Hand> mHands;
	private ArrayList<CardDisplay> mCardDisplays;
	private ArrayList<Card> mPile;

	public Board()
	{
		super(-1);
		mDecks = new ArrayList<>();
		mDeckDisplays = new ArrayList<>();
		mHands = new ArrayList<>();
		mPile = new ArrayList<>();
		mCardDisplays = new ArrayList<>();
	}

	public void addDeck(Deck d)
	{
		mDecks.add(d);
		DeckButton db = new DeckButton(-1);
		mDeckDisplays.add( db );
		db.subscribe(this);
	}

	public void addHand(Hand h)
	{
		mHands.add(h);
		CardDisplay cd = CardDisplay.CreateHandDisplay(h);
		mCardDisplays.add( cd );
		cd.subscribe(this);
	}

	public void addToPile(Card c)
	{
		mPile.add(c);
	}

	public List<Deck> getDecks()
	{
		return mDecks;
	}

	public List<Hand> getHands()
	{
		return mHands;
	}

	public List<Card> getPile()
	{
		return mPile;
	}

	public Deck removeDeck(Deck d)
	{
		Deck removed = null;
		int index = mDecks.indexOf(d);
		if(index != 1)
		{
			removed = mDecks.get(index);
		}

		return removed;
	}
	public Hand removeHand(Hand h)
	{
		Hand removed = null;
		int index = mPile.indexOf(h);
		if(index != 1)
		{
			removed = mHands.get(index);
		}

		return removed;
	}

	public Card removeCard(Card c)
	{
		Card removed = null;
		int index = mPile.indexOf(c);
		if(index != 1)
		{
			removed = mPile.get(index);
		}

		return removed;
	}

	public void clearBoard()
	{
		mDecks.clear();
		mHands.clear();
		mPile.clear();
	}

	@Override
	public String toString()
	{
		String out = "";
		out += "Client.Game.Object.Board[";
		out += "boardID:'" + ID     + "',";
		out += "decks:'"   + mDecks + "',";
		out += "hands:'"   + mHands + "',";
		out += "pile:'"    + mPile  + "',";
		return out;
	}

	@Override
	public void update(long deltaTime)
	{
		for(CardDisplay c : mCardDisplays)
		{
			c.update(deltaTime);
		}

		for(DeckButton d : mDeckDisplays)
		{
			d.update(deltaTime);
		}
	}

	@Override
	public void draw(Graphics2D g)
	{
		for(CardDisplay c : mCardDisplays)
		{
			c.draw(g);
		}

		for(DeckButton d : mDeckDisplays)
		{
			d.draw(g);
		}
	}

	@Override
	public void notifiedBySubscription(ISubscribable subscription)
	{
		if(subscription instanceof CardButton)
		{
			System.out.println("POKED by " + ((CardButton) subscription).getCard() );
		}

		if(subscription instanceof DeckButton)
		{
			System.out.println("POKED by " + ((DeckButton) subscription) );
		}
	}
}
