package Client.Game.Objects.MainMenu;

import Client.Game.ClientGame;
import Client.Game.Objects.SquareButton;

import javax.swing.*;

public class PlayButton extends SquareButton
{
	PlayButton()
	{
		super(0,
			ClientGame.getWindowWidth()/2f  - 320f/2f,
			120,
			320,
			86,
			new ImageIcon("Whono/Assets/test.png").getImage()
		);
	}

	@Override
	protected void onMousePress()
	{

	}

	@Override
	protected void onMouseRelease()
	{

	}
}
