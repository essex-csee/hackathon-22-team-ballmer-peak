package Client.Game.Objects.GameScreen;

import Client.Game.Objects.Card;
import Client.Game.Objects.GameObject;
import Client.Game.Objects.GameScreen.CardButton;
import Client.Game.Objects.Hand;
import Client.Game.Objects.ImageManager;
import Util.ISubscribable;
import Util.ISubscriber;

import java.awt.*;
import java.util.ArrayList;

public class CardDisplay extends GameObject implements ISubscriber, ISubscribable
{
	public static Image getCardImage(Card c)
	{
		String path = "Whono/Assets/Cards/";

		switch (c.getCardColour())
		{
			case BLACK:
				path+="Black/Black";
				break;
			case GREEN:
				path+="Green/Green";
				break;
			case PURPLE:
				path+="Purple/Purple";
				break;
			case RED:
				path+="Red/Red";
				break;
			case YELLOW:
				path+="Yellow/Yellow";
				break;
		}

		switch (c.getCardType())
		{
			case ZERO 	 -> path+="0.png";
			case ONE     -> path+="1.png";
			case TWO     -> path+="2.png";
			case THREE   -> path+="3.png";
			case FOUR    -> path+="4.png";
			case FIVE    -> path+="5.png";
			case SIX     -> path+="6.png";
			case SEVEN   -> path+="7.png";
			case EIGHT   -> path+="8.png";
			case NINE    -> path+="9.png";
			case DRAW2   -> path+="Plus2.png";
			case REVERSE -> path+="Reverse.png";
			case SKIP    -> path+="Skip.png";
			case WILD    -> path+="Wild";
			case WILD4   -> path+="Wild4";
		}

		return ImageManager.loadImage(path);
	}

	public static CardDisplay CreateHandDisplay(Hand h)
	{
		CardDisplay c = new CardDisplay();

		int handSize = h.getHandSize();
		for(int i = 0; i < handSize; i++)
		{
			c.mHandButtons.add( new CardButton(i, handSize, h.getHand().get(i) ) );
			c.mHandButtons.get(i).subscribe(c);
		}

		return c;
	}

	public CardDisplay()
	{
		super(-1);
		mHandButtons = new ArrayList<>();
		mSubscribers = new ArrayList<>();
	}

	@Override
	public void draw(Graphics2D g)
	{
		for( CardButton c : mHandButtons )
		{
			c.draw(g);
		}
	}

	@Override
	public void update(long deltaTime)
	{
		for( CardButton c : mHandButtons )
		{
			c.update(deltaTime);
		}
	}

	@Override
	public void notifiedBySubscription(ISubscribable subscription)
	{
		for(ISubscriber s : mSubscribers)
		{
			s.notifiedBySubscription(subscription);
		}
	}

	@Override
	public void subscribe(ISubscriber s)
	{
		mSubscribers.add(s);
	}

	protected ArrayList<ISubscriber> mSubscribers;
	protected ArrayList<CardButton>  mHandButtons;

}
