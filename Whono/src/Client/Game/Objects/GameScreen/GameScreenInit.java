package Client.Game.Objects.GameScreen;

import Client.Game.Objects.InitObject;
import Client.Game.Objects.MainMenu.ExitButton;
import Client.Game.Objects.MainMenu.PlayButton;

public class GameScreenInit extends InitObject
{
    public GameScreenInit()
    {
        super();
    }

    @Override
    protected void setup()
    {
        addGameObject(new CardButton());
    }

}
