package Client.Game.Objects.MainMenu;

import Client.Game.ClientGame;
import Client.Game.Objects.Card;
import Client.Game.Objects.Display.CardDisplay;
import Client.Game.Objects.ImageManager;
import Client.Game.Objects.InitObject;
import Client.Game.Objects.StaticImageObject;

public class MainMenuInit extends InitObject
{
	public MainMenuInit()
	{
		super();
	}

	@Override
	protected void setup()
	{
		// title
		int titleWidth  = (int) (362f * 1.4f);
		int titleHeight = (int) (242f * 1.4f);
		addGameObject( new StaticImageObject(0, ClientGame.getWindowWidth()/2 - titleWidth/2, 0, titleWidth, titleHeight, ImageManager.loadImage("Whono/Assets/whonoTilt.png") ) );

		addGameObject(new PlayButton());
		addGameObject(new ExitButton());

	}

}
