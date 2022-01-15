package Client.Game.Objects;

import Client.Game.ClientGame;
import Util.ILogicTarget;
import Util.IRenderTarget2D;

import java.util.ArrayList;

public abstract class InitObject extends GameObject
{
	public InitObject()
	{
		super(-1);

		logicTargetsToSpawn    = new ArrayList<>();
		renderTarget2DsToSpawn = new ArrayList<>();
	}

	@Override
	public void update(long deltaTime)
	{
		spawn();
	}

	protected void addGameObject(GameObject g)
	{
		logicTargetsToSpawn.add(g);
		renderTarget2DsToSpawn.add(g);
	}

	protected abstract void setup();

	private void spawn()
	{
		setup();

		ClientGame.wipeRenderTarget();
		ClientGame.wipeLogicTarget();

		for( ILogicTarget logicTarget : logicTargetsToSpawn)
		{
			ClientGame.addLogicTarget(logicTarget);
		}

		for( IRenderTarget2D renderTarget : renderTarget2DsToSpawn)
		{
			ClientGame.addRenderTarget(renderTarget);
		}

		ClientGame.removeLogicTarget(this);
	}

	//=====================================================================
	// Protected variables
	//---------------------------------------------------------------------
	protected ArrayList<ILogicTarget>    logicTargetsToSpawn;
	protected ArrayList<IRenderTarget2D> renderTarget2DsToSpawn;
}
