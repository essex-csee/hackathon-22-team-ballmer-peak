package Client.Game.Objects.MainMenu;

import Client.Game.ClientGame;
import Client.Game.Objects.SquareButton;

import javax.swing.*;

public class ExitButton extends SquareButton
{


	public ExitButton()
	{
		super(2,
			ClientGame.getWindowWidth()/2f  - 320f/2f,
			120 * 5,
			320,
			86,
				"Whono/Assets/test.png"
				//new ImageIcon("Whono/Assets/test.png").getImage()
		);
	}

	@Override
	protected void onMousePress()
	{

	}

	@Override
	protected void onMouseRelease()
	{
		ClientGame.requestWindowClose();
	}
}
