package Client.Game.Objects.MainMenu;

import Client.Game.Objects.InitObject;

public class MainMenuInit extends InitObject
{
	public MainMenuInit()
	{
		super();

		addGameObject(new PlayButton());
		addGameObject(new ExitButton());
	}

}
