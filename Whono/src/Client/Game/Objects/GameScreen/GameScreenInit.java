package Client.Game.Objects.GameScreen;

import Client.Game.Objects.InitObject;
import Client.Game.Objects.MainMenu.PlayButton;

public class GameScreenInit extends InitObject
{
    public GameScreenInit()
    {
        super();
    }

    int cardID = 0;

    public void initMenu()
    {
        ExitButton quit = new ExitButton();
        addGameObject(quit);
        PauseButton pause = new PauseButton();
        addGameObject(pause);
    }

    public void initDeck()
    {
        // ID: 2
    }

    public void initPile()
    {
        // ID: 3
    }

    public void initHand()
    {
        // ID: 4 - handsize
    }

    @Override
    protected void setup()
    {
        // Get GameState
        initMenu();
        initDeck();
        initPile();
        initHand();
        //addGameObject(new CardButton());
    }

}
