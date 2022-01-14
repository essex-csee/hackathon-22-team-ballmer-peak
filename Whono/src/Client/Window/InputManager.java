package Client.Window;

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
	// Methods
	//---------------------------------------------------------------------
	public boolean getMouseLeftPressed()
	{
		return mMouseLeftButtonPressed;
	}

	public boolean getMouseRightPressed()
	{
		return mMouseRightButtonPressed;
	}

	public boolean getMouseLeftHeld()
	{
		return mMouseLeftButtonHeld;
	}

	public boolean getMouseRightHeld()
	{
		return mMouseRightButtonHeld;
	}

	public boolean getMouseLeftReleased()
	{
		return mMouseLeftButtonReleased;
	}

	public boolean getMouseRightReleased()
	{
		return mMouseRightButtonReleased;
	}

	public boolean getKeyPressed(char c)
	{
		return mPressedKeys.contains(c);
	}

	public boolean getKeyHeld(char c)
	{
		return mHeldKeys.contains(c);
	}

	public boolean getKeyReleased(char c)
	{
		return mReleasedKeys.contains(c);
	}

	//=====================================================================
	// Mouse listener methods
	//---------------------------------------------------------------------
	@Override
	public void mouseClicked(MouseEvent e)
	{

	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		switch (e.getButton())
		{
			case MouseEvent.BUTTON1:
				if(mMouseRightButtonPressed)
				{
					mMouseLeftButtonHeld = true;
				}
				else
				{
					mMouseLeftButtonPressed = true;
				}
				break;
			case MouseEvent.BUTTON2:

				if(mMouseRightButtonPressed)
				{
					mMouseRightButtonHeld = true;
				}
				else
				{
					mMouseRightButtonPressed = true;
				}
				break;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		switch (e.getButton())
		{
			case MouseEvent.BUTTON1:
				mMouseLeftButtonHeld    = false;
				mMouseLeftButtonReleased = true;
				break;
			case MouseEvent.BUTTON2:
				mMouseRightButtonHeld    = false;
				mMouseRightButtonReleased = true;
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

		mMouseLeftButtonReleased = false;
		mMouseRightButtonReleased = false;
	}

	@Override
	public void mouseMoved(MouseEvent e)
	{
		mMouseX = e.getX();
		mMouseY = e.getY();

		mMouseLeftButtonReleased = false;
		mMouseRightButtonReleased = false;
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
		if(mPressedKeys.contains(e.getKeyChar()))
		{
			mHeldKeys.add(e.getKeyChar());
		}
		else
		{
			mPressedKeys.add(e.getKeyChar());
		}

		mReleasedKeys.clear();
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		mPressedKeys.remove(e);
		mHeldKeys.remove(e);
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
	protected boolean mMouseLeftButtonReleased;

	protected boolean mMouseRightButtonPressed;
	protected boolean mMouseRightButtonHeld;
	protected boolean mMouseRightButtonReleased;
}
