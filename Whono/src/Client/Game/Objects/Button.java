package Client.Game.Objects;


import Util.ILogicTarget;
import Util.IRenderTarget2D;
import Util.ISubscriber;

import java.awt.*;
import java.util.ArrayList;

public abstract class Button implements IRenderTarget2D, ILogicTarget, ISubscriber
{
	//=====================================================================
	// Methods
	//---------------------------------------------------------------------
	public abstract void draw(Graphics2D g);        // IRenderTarget2D

	public abstract void update(long deltaTime);    // ILogicTarget

	public abstract void notify( Object notifier ); // ISubscriber

	public abstract boolean isInBounds( int x, int y );

	//=====================================================================
	// Protected variables
	//---------------------------------------------------------------------
	protected ArrayList<ISubscriber> subscribers;
	protected int x;
	protected int y;
	protected int width;
	protected int height;
}