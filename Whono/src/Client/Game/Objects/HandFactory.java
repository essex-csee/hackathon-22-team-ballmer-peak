package Client.Game.Objects;

import java.util.List;

public class HandFactory
{
	public static Hand createHand()
	{
		Hand hand = new Hand();
		return hand;
	}

	public static Hand createHand(int id, List<Card> h, int limit)
	{
		Hand hand  = new Hand();

		hand.setHandID(id);
		hand.setHandSizeLimit(limit);

		for(int i = 0; i < h.size(); i++)
		{
			hand.addCard(h.get(i));
		}
		return hand;
	}

	public static Hand createHand(Deck d)
	{
		Hand hand  = new Hand();

		// without a top peek mechanic maintaining deck structure ain't shit
		d.shuffle();

		for(int i = 0; i < Hand.HAND_STARTING_SIZE; i++)
		{
			Card c = d.drawCard();
			hand.addCard(c);
		}

		return hand;
	}




}
