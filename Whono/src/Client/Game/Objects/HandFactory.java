package Client.Game.Objects;

import java.util.Collections;
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




}
