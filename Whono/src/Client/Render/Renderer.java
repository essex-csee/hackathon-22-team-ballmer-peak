package Client.Render;

import Util.IRenderTarget2D;

import java.awt.*;
import java.util.ArrayList;

public class Renderer
{
	//=====================================================================
	// Constructor
	//---------------------------------------------------------------------
	public Renderer( Graphics g2d, int x, int y, int width, int height )
	{
		this.mRenderTargets2D         = new ArrayList<>();
		this.mRenderTargets2DToAdd    = new ArrayList<>();
		this.mRenderTargets2DToRemove = new ArrayList<>();

		this.mX = x;
		this.mY = y;
		this.mWidth  = width;
		this.mHeight = height;
		this.mG = g2d.create(mX, mY, mWidth, mHeight);
	}

	//=====================================================================
	// Methods
	//---------------------------------------------------------------------
	public void renderTargets()
	{
		boolean listHasChanged; // track changes and try to whack-a-mole concurrency errors are they pop up

		mG.clearRect(0,0, mWidth, mHeight);

		if ( !mRenderTargets2DToRemove.isEmpty() )
		{
			mRenderTargets2D.removeAll(mRenderTargets2DToRemove);
			mRenderTargets2D.clear();

			listHasChanged = true;
		}

		if ( !mRenderTargets2DToAdd.isEmpty() )
		{
			mRenderTargets2D.addAll(mRenderTargets2DToAdd);
			mRenderTargets2DToAdd.clear();

			listHasChanged = true;
		}

		mRenderTargets2D.parallelStream().forEachOrdered( i -> i.draw( (Graphics2D) mG) );
	}

	public void addRenderTargets( IRenderTarget2D target )
	{
		if ( target != null )
		{
			mRenderTargets2DToAdd.add(target);
		}
	}

	public void removeRenderTargets( IRenderTarget2D target )
	{
		if ( target != null )
		{
			mRenderTargets2DToRemove.add(target);
		}
	}

	protected final Graphics mG;

	protected final ArrayList<IRenderTarget2D> mRenderTargets2D;
	protected final ArrayList<IRenderTarget2D> mRenderTargets2DToAdd;
	protected final ArrayList<IRenderTarget2D> mRenderTargets2DToRemove;

	protected final int mX;
	protected final int mY;
	protected final int mWidth;
	protected final int mHeight;
}
