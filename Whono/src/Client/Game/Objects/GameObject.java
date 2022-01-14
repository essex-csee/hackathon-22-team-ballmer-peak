package Client.Game.Objects;

import Util.ILogicTarget;
import Util.IRenderTarget2D;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;

public abstract class GameObject implements IRenderTarget2D, ILogicTarget
{
	//=====================================================================
	// Constructors
	//---------------------------------------------------------------------
	protected GameObject()
	{
		this(-1); // -1 to flag this object doesn't have a valid id
	}

	protected GameObject(long ID)
	{
		this(ID, null);
	}

	protected GameObject(long ID, Image singleSprite)
	{
		this(ID, 0, 0, 0, 0, singleSprite);
	}

	protected GameObject(long ID, int x, int y, int width, int height, Image sprite)
	{
		this(   ID,
			x,
			y,
			width,
			height,                                      // preserve null
			(sprite != null)? new ArrayList<Image>( List.of(sprite) ) : null);
	}

	protected GameObject(long ID, int x, int y, int width, int height, ArrayList<Image> spriteList)
	{
		this.ID         = ID;
		this.x          = x;
		this.y          = y;
		this.width      = width;
		this.height     = height;
		this.spriteList = spriteList;
		this.imageIndex = 0;
	}


	//=====================================================================
	// Methods
	//---------------------------------------------------------------------
	public void draw(Graphics2D g)
	{
		if (
			spriteList != null       // don't try if we aren't using sprites
			&& !spriteList.isEmpty() // need an actual image to draw
		   )
		{
			g.drawImage(spriteList.get(imageIndex),
				x,
				y,
				width,
				height,
				imageObserver
			);
		}
	}

	public abstract void update(long deltaTime);

	//=====================================================================
	// public variables
	//---------------------------------------------------------------------
	public final long ID;

	//=====================================================================
	// Protected variables
	//---------------------------------------------------------------------
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected int imageIndex;
	protected ArrayList<Image> spriteList;
	protected ImageObserver imageObserver = null;
}
