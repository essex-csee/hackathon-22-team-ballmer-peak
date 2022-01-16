package Client.Game.Objects.GameScreen;

import Client.Game.Objects.*;
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
        // Needs offset + rescaling
        ExitButton quit = new ExitButton();
        addGameObject(quit);
        PauseButton pause = new PauseButton();
        addGameObject(pause);
    }

    public void initDeck()
    {
        // TODO: CardButton needs parameters for the Type/Colour
        // Needs offset
        CardButton deck = new CardButton(2);
        addGameObject(deck);
    }

    public void initPile()
    {
        // Needs offset
        CardButton pile = new CardButton(3);
        addGameObject(pile);
        // ID: 3
    }

    public void initHand()
    {

    }

    @Override
    protected void setup()
    {
        GameState g = GameState.createGameState(4);
        addGameObject(g);

        for(Hand h : g.getBoard().getHands() )
        {
            addGameObject( CardDisplay.CreateHandDisplay(h) );
        }
    }

}
