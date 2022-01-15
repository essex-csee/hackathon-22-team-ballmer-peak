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

	}
}
