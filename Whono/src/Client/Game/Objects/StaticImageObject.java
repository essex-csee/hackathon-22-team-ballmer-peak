package Client.Game.Objects;

import Client.Game.ClientGame;

import java.awt.*;

public class StaticImageObject extends GameObject
{
	public StaticImageObject(long ID, int x, int y, int width, int height, Image image)
	{
		super(ID, x, y, width, height, image);
	}

	@Override
	public void update(long deltaTime)
	{
		if(ClientGame.getInput().getKeyPressed('a'))
		{
			x-= deltaTime;
		}

		if(ClientGame.getInput().getKeyPressed('d'))
		{
			x+= deltaTime;
		}

		if(ClientGame.getInput().getKeyPressed('w'))
		{
			y+=deltaTime;
		}

		if(ClientGame.getInput().getKeyPressed('s'))
		{
			y-=deltaTime;
		}
	}
}
