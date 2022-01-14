package Client.Render;

import Client.Window.ClientWindow;
import Util.IRenderTarget2D;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Renderer extends JPanel
{
	//=====================================================================
	// Constructor
	//---------------------------------------------------------------------
	public Renderer(ClientWindow window, int x, int y, int width, int height )
	{
		super();
		window.add(this);

		this.mRenderTargets2D         = new ArrayList<>();
		this.mRenderTargets2DToAdd    = new ArrayList<>();
		this.mRenderTargets2DToRemove = new ArrayList<>();

		this.mX = x;
		this.mY = y;
		this.mWidth  = width;
		this.mHeight = height;
	}

	//=====================================================================
	// Methods
	//---------------------------------------------------------------------


	@Override
	public void repaint()
	{
		super.repaint();
	}

	@Override
	public void paintComponent(Graphics g)
	{

		boolean listHasChanged; // track changes and try to whack-a-mole concurrency errors are they pop up

		g.clearRect(0,0,mWidth,mHeight);

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

		for(IRenderTarget2D t : mRenderTargets2D)
		{
			t.draw((Graphics2D)  g);
		}
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

	public void renderTargets()
	{
		this.repaint();
	}

	protected final ArrayList<IRenderTarget2D> mRenderTargets2D;
	protected final ArrayList<IRenderTarget2D> mRenderTargets2DToAdd;
	protected final ArrayList<IRenderTarget2D> mRenderTargets2DToRemove;

	protected final int mX;
	protected final int mY;
	protected final int mWidth;
	protected final int mHeight;
}
