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
	// Public Methods
	//---------------------------------------------------------------------
	@Override
	public void subscribe(ISubscriber s) // ISubscribable
	{
		subscribers.add(s);
	}

	@Override
	public void notifiedBySubscription(ISubscribable subscription) // ISubscriber
	{
		// dont care
	}

	public void notifySubscribers()
	{
		for(ISubscriber s : subscribers)
		{
			s.notifiedBySubscription(this);
		}
	}


	//=====================================================================
	// Protected Methods
	//---------------------------------------------------------------------
	protected abstract boolean isInBounds( int x, int y );

	protected abstract void onPress();

	protected abstract void onRelease();

	//=====================================================================
	// Protected variables
	//---------------------------------------------------------------------
	protected ArrayList<ISubscriber> subscribers;
	protected int x;
	protected int y;
	protected int width;
	protected int height;
}