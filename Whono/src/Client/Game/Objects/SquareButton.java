package Client.Game.Objects;

import Client.Game.ClientGame;
import Util.ISubscribable;
import Util.ISubscriber;

import java.awt.*;

public abstract class SquareButton extends Button
{
	@Override
	public void update(long deltaTime)
	{
		if( isInBounds( ClientGame.getInput().getMouseX(), ClientGame.getInput().getMouseY() )
		    && ClientGame.getInput().getMouseLeftPressed() ) // if the mouse is released in bounds
		{
			onPress();
		}

		if( isInBounds( ClientGame.getInput().getMouseX(), ClientGame.getInput().getMouseY() )
			&& ClientGame.getInput().getMouseLeftReleased() ) // if the mouse is released in bounds
		{
			onRelease();
		}}

	@Override
	public boolean isInBounds(int x, int y)
	{
		return x > this.x && x < this.x + width && y > this.y && y < this.y + height;
	}

}
