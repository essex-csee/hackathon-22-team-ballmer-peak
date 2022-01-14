package Client.Game;

import Util.ILogicTarget;
import Util.IRenderTarget2D;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ClientGame implements Runnable
{
	private ClientGame()
	{
		logicTargets = new ArrayList<ILogicTarget>();
	}

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

	public static void addLogicTarget(ILogicTarget logicTarget)
	{
		try
		{
			sClientGameMutex.acquire();
			sClientGame.logicTargets.add(logicTarget);
			sClientGameMutex.release();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	public static void removeLogicTarget(ILogicTarget logicTarget)
	{
		try
		{
			sClientGameMutex.acquire();
			sClientGame.logicTargets.remove(logicTarget);
			sClientGameMutex.release();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	public static void addRenderTarget(IRenderTarget2D renderTarget2D)
	{
		try
		{
			sClientGameMutex.acquire();
			sClientGameMutex.release();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	public static void removeRenderTarget(IRenderTarget2D renderTarget2D)
	{
		try
		{
			sClientGameMutex.acquire();
			sClientGameMutex.release();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}

	}

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

	public void startUp() throws InterruptedException
	{
		sClientGameMutex.release(); // release the mutex lock in get

		sClientGameMutex.acquire();
		isCloseRequested = false;
		sClientGameMutex.release();
	}

	public void gameLoop() throws InterruptedException
	{
		long startTime = System.nanoTime();
		long priorTime = startTime;
		do
		{
			priorTime = startTime;
			startTime = System.currentTimeMillis();
			long deltaTime = startTime - priorTime;

			// update logicTargets
			logicTargets.parallelStream().forEachOrdered(i -> i.update(deltaTime) );

		}
		while (!isCloseRequested);
	}

	public void cleanUp()
	{
	}

	protected final ArrayList<ILogicTarget> logicTargets;
	protected boolean      isCloseRequested;

	private static ClientGame sClientGame;
	private static Semaphore  sClientGameMutex;
}
