package Client.Game.Objects.MainMenu;

import Client.Game.Objects.SquareButton;

import javax.swing.*;

public class PlayButton extends SquareButton
{
	PlayButton()
	{
		super(0,
			480,
			0,
			320,
			360,
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
