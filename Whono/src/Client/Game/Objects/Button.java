package Client.Game.Objects;


import Util.ILogicTarget;
import Util.IRenderTarget2D;
import Util.ISubscribable;
import Util.ISubscriber;

import java.awt.*;
import java.util.ArrayList;

public abstract class Button extends GameObject implements ISubscriber, ISubscribable
{
	//=====================================================================
	// Methods
	//---------------------------------------------------------------------
	public abstract boolean isInBounds( int x, int y );

	public void notifySubscribers()
	{
		for(ISubscriber s : subscribers)
		{
			 s.notifiedBySubscription(this);
		}
	}

	@Override
	public void subscribe(ISubscriber s)
	{
		subscribers.add(s);
	}

	@Override
	public void notifiedBySubscription(ISubscribable subscription)
	{
		// dont care
	}

	//=====================================================================
	// Protected variables
	//---------------------------------------------------------------------
	protected ArrayList<ISubscriber> subscribers;
	protected int x;
	protected int y;
	protected int width;
	protected int height;
}