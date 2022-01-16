package Client.Game.Objects.GameScreenSolo;

import Client.Game.ClientGame;
import Client.Game.Objects.*;
import Client.Game.Objects.GameScreen.CardButton;
import Client.Game.Objects.GameScreen.PauseButton;
import Client.Game.Objects.GameScreen.SmallExitButton;

public class GameScreenInitSolo extends InitObject
{
    public GameScreenInitSolo()
    {
        super();
    }

    int cardID = 0;

    public void initMenu()
    {
        // Needs offset + rescaling
        SmallExitButton quit = new SmallExitButton();
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
        int handSize = 16;
        for(int i = 1; i <= handSize; i++)
        {
            Card c = new Card();
            CardButton cb = new CardButton(i, handSize,c);
            addGameObject(cb);
        }
        // Get player Hand
        // ID: 4 - handsize
        //
        // iterate through player hand
        //      CardButton offset
        //      CardButton c = new CardButton();
        //      addGameObject(c);
    }

    @Override
    protected void setup()
    {
        GameStateSolo g = GameStateSolo.createGameState(1);

        StaticImageObject background = new StaticImageObject(
                1,
                0,
                0,
                ClientGame.getWindowWidth(),
                ClientGame.getWindowHeight(),
                ImageManager.loadImage("Whono/Assets/BackgroundTile.png")
        );

        addGameObject(background);

        addGameObject(g);
        addGameObject(g.getBoard());



    }

}
