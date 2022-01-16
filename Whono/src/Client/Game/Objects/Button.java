package Client.Game.Objects;


import Util.ISubscribable;
import Util.ISubscriber;

import java.awt.*;
import java.util.ArrayList;

public abstract class Button extends GameObject implements ISubscriber, ISubscribable
{
	public Button(long ID)
	{
		super(ID);
	}

	public Button(long ID, Image singleSprite)
	{
		super(ID, singleSprite);
	}

	public Button(long ID, float x, float y, int width, int height, Image sprite)
	{
		super(ID, x, y, width, height, sprite);
	}

	public Button(long ID, float x, float y, int width, int height, ArrayList<Image> spriteList)
	{
		super(ID, x, y, width, height, spriteList);
	}

	public Button(long ID, float x, float y, int width, int height, String name)
	{
		super(ID, x, y, width, height, name);
	}

	//=====================================================================
	// Public Methods
	//---------------------------------------------------------------------
	@Override
	public void subscribe(ISubscriber s) // ISubscribable
	{
		mSubscribers.add(s);
	}

	@Override
	public void notifiedBySubscription(ISubscribable subscription) // ISubscriber
	{
		// dont care
	}

	public void notifySubscribers()
	{
		for(ISubscriber s : mSubscribers)
		{
			s.notifiedBySubscription(this);
		}
	}


	//=====================================================================
	// Protected Methods
	//---------------------------------------------------------------------
	protected abstract boolean isInBounds( int x, int y );

	protected abstract void onMousePress();

	protected abstract void onMouseRelease();

	//=====================================================================
	// Protected variables
	//---------------------------------------------------------------------
	protected ArrayList<ISubscriber> mSubscribers = new ArrayList<>();
}