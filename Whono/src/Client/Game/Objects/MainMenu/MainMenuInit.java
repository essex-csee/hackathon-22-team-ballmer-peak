package Client.Game.Objects.MainMenu;

import Client.Game.Objects.InitObject;

public class MainMenuInit extends InitObject
{
	public MainMenuInit()
	{
		super();
	}

	@Override
	protected void setup()
	{
		addGameObject(new PlayButton());
		addGameObject(new ExitButton());
	}

}
