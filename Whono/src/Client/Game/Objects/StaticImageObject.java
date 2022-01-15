package Client.Game.Objects;

import Client.Game.ClientGame;

import java.awt.*;

public class StaticImageObject extends GameObject
{
	public StaticImageObject(long ID, float x, float y, int width, int height, Image image)
	{
		super(ID, x, y, width, height, image);
	}

	@Override
	public void update(long deltaTime)
	{
		if(ClientGame.getInput().getKeyPressed('a'))
		{
			mX -= deltaTime;
		}

		if(ClientGame.getInput().getKeyPressed('d'))
		{
			mX += deltaTime;
		}

		if(ClientGame.getInput().getKeyPressed('w'))
		{
			mY +=deltaTime;
		}

		if(ClientGame.getInput().getKeyPressed('s'))
		{
			mY -=deltaTime;
		}
	}
}
