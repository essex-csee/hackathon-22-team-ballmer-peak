package Client.Window;

import Client.Window.ClientWindow;
import Util.ISubscriber;

import java.awt.event.*;
import java.util.ArrayList;

public class InputManager implements MouseListener, MouseMotionListener, KeyListener
{
	//=====================================================================
	// Constructor
	//---------------------------------------------------------------------
	public InputManager(ClientWindow w)
	{
		w.addMouseListener(this);
		w.addMouseMotionListener(this);
		w.addKeyListener(this);

		mSubscribers  = new ArrayList<>();

		mPressedKeys  = new ArrayList<>();
		mHeldKeys     = new ArrayList<>();
		mReleasedKeys = new ArrayList<>();
	}

	//=====================================================================
	// Mouse listener methods
	//---------------------------------------------------------------------
	@Override
	public void mouseClicked(MouseEvent e)
	{
		System.out.printf("clicked\n");
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		switch (e.getButton())
		{
			case MouseEvent.BUTTON1:
				mMouseLeftButtonPressed = true;
				break;
			case MouseEvent.BUTTON2:
				mMouseRightButtonPressed = true;
				break;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		switch (e.getButton())
		{
			case MouseEvent.BUTTON1:
				mMouseLeftButtonRelease  = true;
				break;
			case MouseEvent.BUTTON2:
				mMouseRightButtonRelease = true;
				break;
		}
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{

	}

	@Override
	public void mouseExited(MouseEvent e)
	{

	}

	@Override
	public void mouseDragged(MouseEvent e)
	{
		mMouseX = e.getX();
		mMouseY = e.getY();
	}

	@Override
	public void mouseMoved(MouseEvent e)
	{
		mMouseX = e.getX();
		mMouseY = e.getY();
	}

	//=====================================================================
	// Key listener methods
	//---------------------------------------------------------------------
	@Override
	public void keyTyped(KeyEvent e)
	{

	}

	@Override
	public void keyPressed(KeyEvent e)
	{

	}

	@Override
	public void keyReleased(KeyEvent e)
	{

	}

	//=====================================================================
	// Protected variables
	//---------------------------------------------------------------------
	protected final ArrayList<ISubscriber> mSubscribers;

	protected final ArrayList<Character>   mPressedKeys;  // are pressed this frame
	protected final ArrayList<Character>   mHeldKeys;     // are pressed this frame and last frame
	protected final ArrayList<Character>   mReleasedKeys; // where pressed last frame but not this frame

	protected int     mMouseX;
	protected int     mMouseY;

	protected boolean mMouseLeftButtonPressed;
	protected boolean mMouseLeftButtonHeld;
	protected boolean mMouseLeftButtonRelease;

	protected boolean mMouseRightButtonPressed;
	protected boolean mMouseRightButtonHeld;
	protected boolean mMouseRightButtonRelease;
}
