package Client.Game.Objects.MainMenu;

import Client.Game.Objects.InitObject;
import Client.Game.Objects.TestButton;

public class MainMenuInit extends InitObject
{
	public MainMenuInit()
	{
		super();

	//	addGameObject(new TestButton());
		addGameObject(new PlayButton());
		addGameObject(new ExitButton());
	}

}
