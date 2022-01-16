package Client.Game.Objects.GameScreen;

import Client.Game.ClientGame;
import Client.Game.Objects.*;
import Util.CONSTANTS;
import Util.ISubscribable;
import Util.ISubscriber;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Board extends GameObject implements ISubscriber
{
	private final ArrayList<Deck> mDecks;
	private final ArrayList<DeckButton>  mDeckDisplays;
	private final ArrayList<Hand> mHands;
	private final ArrayList<CardDisplay> mCardDisplays;
	private final ArrayList<Card> mPile;
	private final ArrayList<CardButton>  mPileDisplays;

	private Card mPileCard;
	private int playerID = 0;

	public Board()
	{
		super(-1);
		mDecks        = new ArrayList<>();
		mDeckDisplays = new ArrayList<>();
		mHands        = new ArrayList<>();
		mCardDisplays = new ArrayList<>();
		mPile         = new ArrayList<>();
		mPileDisplays = new ArrayList<>();
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
		mPileDisplays.clear();
		mPileDisplays.add( new CardButton(
			ClientGame.getWindowWidth()  / 2f,
			ClientGame.getWindowHeight() / 2f - CONSTANTS.CARD_HEIGHT_PADDING, c ) );
		mPileCard = c;
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

	public Card getPileCard()
	{
		return mPileCard;
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

	public void refreshDisplay(Hand h)
	{
		mCardDisplays.clear();
		CardDisplay cd = CardDisplay.CreateHandDisplay(h);
		mCardDisplays.add(cd);
		cd.subscribe(this);

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

		for(CardButton c : mPileDisplays)
		{
			c.update(deltaTime);
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

		for(CardButton c : mPileDisplays)
		{
			c.draw(g);
		}

	}

	@Override
	public void notifiedBySubscription(ISubscribable subscription)
	{
		if(subscription instanceof CardButton)
		{
			System.out.println("POKED by " + ((CardButton) subscription).getCard() );

			Card c =((CardButton) subscription).getCard();
			Hand h = getHands().get(0);
			if( Game.canPlay(mPileCard, c) )
			{
				addToPile(c);
				h.removeCard(c);
				refreshDisplay(h);
			}
		}

		if(subscription instanceof DeckButton)
		{
			System.out.println("POKED by " + ((DeckButton) subscription) );
			Hand h = getHands().get(0);
			if (mDecks.get(0).getDeckContents().size() == 0)
			{
				for(Card c : mPile)
				{
					mDecks.get(0).addCard( c );
				}
				mPile.clear();
				mPile.add(mPileCard);
			}
			else
			{
				if (h.getHandSize() < Hand.HAND_MAX_SIZE)
				{
					System.out.printf("Card added\n");
					h.addCard(mDecks.get(0).drawCard());
					refreshDisplay(h);
				}
			}
		}
	}
}
