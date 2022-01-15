package Client.Game.Objects;

import Client.Game.ClientGame;
import Util.ISubscribable;
import Util.ISubscriber;

public class SquareButton extends Button
{
	@Override
	public void update(long deltaTime)
	{
		if( isInBounds( ClientGame.getInput().getMouseX(), ClientGame.getInput().getMouseY() ) )
		{
			notifySubscribers();
		}
	}

	@Override
	public boolean isInBounds(int x, int y)
	{
		return x > this.x && x < this.x + width && y > this.y && y < this.y + height;
	}

	@Override
	public void notifiedBySubscription(ISubscribable subscription)
	{
		// dont care
	}
}
