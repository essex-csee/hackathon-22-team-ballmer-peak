package Client.Game.Objects.GameScreen;

import Client.Game.Objects.Card;
import Client.Game.Objects.Deck;
import Client.Game.Objects.Game;
import Client.Game.Objects.Hand;

public class AIPlayer
{
	public AIPlayer(Hand hand)
	{
		mHand = hand;
	}

	public Card playCard(Board b)
	{

		while(mHand.getHandSize() < Hand.HAND_MAX_SIZE)
		{

			for (Card c : mHand.getHand())
			{
				if (Game.canPlay(b.getPileCard(), c))
				{
					mHand.removeCard(c);;
					return c;
				}
			}
			mHand.addCard(b.drawCard());
		}

		return null;
	}

	protected Hand mHand;
}
