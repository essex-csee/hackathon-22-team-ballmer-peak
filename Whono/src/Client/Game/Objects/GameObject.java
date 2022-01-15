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
	public GameObject(long ID)
	{
		this(ID, null);
	}

	public GameObject(long ID, Image singleSprite)
	{
		this(ID, 0, 0, 0, 0, singleSprite);
	}

	public GameObject(long ID, float x, float y, int width, int height, Image sprite)
	{
		this(   ID,
			x,
			y,
			width,
			height,                                      // preserve null
			(sprite != null)? new ArrayList<Image>( List.of(sprite) ) : null);
	}

	public GameObject(long ID, float x, float y, int width, int height, String name)
	{
		this(
				ID,
				x,
				y,
				width,
				height,
				ImageManager.loadImage(name)
		);
	}

	public GameObject(long ID, float x, float y, int width, int height, ArrayList<Image> spriteList)
	{
		this.ID         = ID;
		this.mX = x;
		this.mY = y;
		this.mWidth = width;
		this.mHeight = height;
		this.mSpriteList = spriteList;
		this.mImageIndex = 0;
	}


	//=====================================================================
	// Methods
	//---------------------------------------------------------------------
	public void draw(Graphics2D g)
	{
		if (
			mSpriteList != null       // don't try if we aren't using sprites
			&& !mSpriteList.isEmpty() // need an actual image to draw
		   )
		{
			g.drawImage(mSpriteList.get(mImageIndex),
				(int) mX,
				(int) mY,
				mWidth,
				mHeight,
				mImageObserver
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
	protected float mX;
	protected float mY;
	protected int mWidth;
	protected int mHeight;
	protected int mImageIndex;
	protected ArrayList<Image> mSpriteList;
	protected ImageObserver mImageObserver = null;
}
