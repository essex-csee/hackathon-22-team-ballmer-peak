package Client.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClientWindow implements WindowListener
{

	//=====================================================================
	// Constructor
	//---------------------------------------------------------------------
	public ClientWindow()
	{
		// get size of monitor
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		// composition is better than inheritance sometimes?
		// this way we can use pass-through methods and not have to worry about method name's clashing
		mWindow        = new JFrame();

		this.mWidth     = screenSize.width;
		this.mHeight    = screenSize.height;
		this.mIsVisible = false;

		// add window components
		mWindow.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		mWindow.addWindowListener(this);
		mWindow.pack();

		// set size
		mWindow.setMaximumSize(screenSize);
		mWindow.setResizable(false);
		resize(mWidth,mHeight);
	}

	//=====================================================================
	// Methods
	//---------------------------------------------------------------------
	public void resize(int width, int height)
	{
		Dimension newSize = new Dimension(width,height);
		mWindow.setSize(newSize);
	}

	public void hide()
	{
		setVisible(false);
	}

	public void show()
	{
		setVisible(true);
	}

	public boolean isVisible()
	{
		return mIsVisible;
	}

	public void setVisible(boolean visible)
	{
		mIsVisible = visible;
		mWindow.setVisible(visible);
	}

	public Component add(Component component)
	{
		mWindow.add(component);
		return component; // match add functionality
	}

	public void addComponentListener(ComponentListener componentListener)
	{
		mWindow.addComponentListener(componentListener);
	}

	public ClientWindow addMouseListener(MouseListener mouseListener)
	{
		mWindow.addMouseListener(mouseListener);
		return this;
	}

	public ClientWindow addMouseMotionListener(MouseMotionListener mouseMotionListener)
	{
		mWindow.addMouseMotionListener(mouseMotionListener);
		return this;
	}

	public ClientWindow addKeyListener(KeyListener keyListener)
	{
		mWindow.addKeyListener(keyListener);
		return this;
	}

	public ClientWindow addPanel(JPanel panel)
	{
		mWindow.add(panel);
		mWindow.pack();
		return this;
	}

	public boolean isCloseRequested()
	{
		return mIsCloseRequested;
	}

	public int getWidth()
	{
		return mWidth;
	}

	public int getHeight()
	{
		return mHeight;
	}

	public void close()
	{
		mWindow.dispose();
	}

	//=====================================================================
	// WindowListener Methods
	//---------------------------------------------------------------------
	@Override
	public void windowOpened(WindowEvent e)
	{
		mIsCloseRequested = false;
	}

	@Override
	public void windowClosing(WindowEvent e)
	{
		mIsCloseRequested = true;
	}

	@Override
	public void windowClosed(WindowEvent e)
	{
		mIsCloseRequested = true;
	}

	@Override
	public void windowIconified(WindowEvent e)
	{

	}

	@Override
	public void windowDeiconified(WindowEvent e)
	{

	}

	@Override
	public void windowActivated(WindowEvent e)
	{

	}

	@Override
	public void windowDeactivated(WindowEvent e)
	{

	}

	//=====================================================================
	// Protected variables
	//---------------------------------------------------------------------
	protected final JFrame  mWindow;
	protected final int     mWidth;
	protected final int     mHeight;

	protected boolean mIsVisible;
	protected boolean mIsCloseRequested;

}
