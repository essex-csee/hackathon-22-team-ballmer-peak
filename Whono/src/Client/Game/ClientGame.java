package Client.Game;

import Client.Render.Renderer;
import Util.ILogicTarget;
import Util.IRenderTarget2D;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ClientGame implements Runnable
{
	//=====================================================================
	// Singleton Constructor
	//---------------------------------------------------------------------

	/***
	 * ClientGame singleton constructor
	 */
	private ClientGame()
	{
		mLogicTargets = new ArrayList<ILogicTarget>();
	}

	//=====================================================================
	// Public Methods
	//---------------------------------------------------------------------

	/***
	 * Returns the ClientGame singleton creating it if it had not been so
	 * @return ClientGame singleton
	 * @throws InterruptedException mutex interrupted
	 */
	public static ClientGame get() throws InterruptedException
	{
		if(sClientGame == null)
		{
			sClientGameMutex = new Semaphore(1)   ; // we could sync based on the ClientGame
			sClientGameMutex.acquire();                    // but I think using a mutex here gives more flex
			sClientGame = new ClientGame();                // we've locked until startup can finish
		}

		return sClientGame;
	}

	/***
	 * Adds a logic target to the list to update
	 * @param logicTarget LogicTarget to add
	 */
	public static void addLogicTarget(ILogicTarget logicTarget)
	{
		try
		{
			sClientGameMutex.acquire();
			sClientGame.mLogicTargets.add(logicTarget);
			sClientGameMutex.release();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	/***
	 * Removes a logicTarget from the list
	 * @param logicTarget LogicTarget to remove
	 */
	public static void removeLogicTarget(ILogicTarget logicTarget)
	{
		try
		{
			sClientGameMutex.acquire();
			sClientGame.mLogicTargets.remove(logicTarget);
			sClientGameMutex.release();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	/***
	 * Adds a renderTarget2D to the list of render targets
	 * @param renderTarget2D RenderTarget2D to add
	 */
	public static void addRenderTarget(IRenderTarget2D renderTarget2D)
	{
		try
		{
			sClientGameMutex.acquire();
			sClientGame.mRenderer.addRenderTargets(renderTarget2D);
			sClientGameMutex.release();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	/***
	 * Removes a RenderTarget2D from the list of render targets
	 * @param renderTarget2D RenderTarget to remove
	 */
	public static void removeRenderTarget(IRenderTarget2D renderTarget2D)
	{
		try
		{
			sClientGameMutex.acquire();
			sClientGame.mRenderer.removeRenderTargets(renderTarget2D);
			sClientGameMutex.release();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}

	}

	/***
	 * Run the ClientGame
	 */
	@Override
	public void run()
	{
		try
		{
			startUp();
			gameLoop();
			cleanUp();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	//=====================================================================
	// Protected Methods
	//---------------------------------------------------------------------

	/***
	 * Start up the clientGame
	 * @throws InterruptedException mutex interrupted
	 */
	protected void startUp() throws InterruptedException
	{
		sClientGameMutex.release(); // release the mutex lock in get

		sClientGameMutex.acquire();
		mIsCloseRequested = false;
		sClientGameMutex.release();
	}

	/***
	 * GameLoop updating targets and rendering targets till the window is closed
	 * @throws InterruptedException mutex interrupted
	 */
	protected void gameLoop() throws InterruptedException
	{
		long startTime = System.nanoTime();
		long priorTime = startTime;
		do
		{
			priorTime = startTime;
			startTime = System.currentTimeMillis();
			long deltaTime = startTime - priorTime;

			// draw renderTargets
			mRenderer.renderTargets();

			// update logicTargets
			mLogicTargets.parallelStream().forEachOrdered(i -> i.update(deltaTime) );

			// TODO: framesync

		}
		while (!mIsCloseRequested);
	}

	/***
	 * Clean up left over resources after the window closed
	 */
	protected void cleanUp()
	{
		// the window has closed
		// release resources
	}

	//=====================================================================
	// Protected variables
	//---------------------------------------------------------------------
	protected final ArrayList<ILogicTarget> mLogicTargets;
	protected boolean                       mIsCloseRequested;
	protected Renderer                      mRenderer;

	//=====================================================================
	// Private variables
	//---------------------------------------------------------------------
	private static ClientGame sClientGame;
	private static Semaphore  sClientGameMutex;
}
