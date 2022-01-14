package Client.Game.Objects;

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

	}
}
