package Client.Game.Objects.GameScreen;

import Client.Game.ClientGame;
import Client.Game.Objects.*;
import Client.Game.Objects.MainMenu.PlayButton;
import Util.CONSTANTS;

import java.util.ArrayList;
import java.util.List;

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
    /*public void initWin()
    {
        // Needs offset + rescaling
        ExitButton quit = new ExitButton();
        addGameObject(quit);
        PauseButton pause = new PauseButton();
        addGameObject(pause);
    }*/

    @Override
    protected void setup()
    {
        GameState g = GameState.createGameState(4);

        StaticImageObject background = new StaticImageObject(
                1,
                0,
                0,
                ClientGame.getWindowWidth(),
                ClientGame.getWindowHeight(),
                ImageManager.loadImage("Whono/Assets/BackgroundTile.png")
        );

        List<Hand> hands = g.getBoard().getHands();
        List<StaticImageObject> statusList = new ArrayList<>();

        for(int i = 0; i < hands.size(); i++)
        {

            HandStatus status = new HandStatus(
                    i,
                    50,
                    i*50 + 50,
                    CONSTANTS.CARD_WIDTH/4,
                    CONSTANTS.CARD_HEIGHT/4,
                    ImageManager.loadImage("Whono/Assets/whonoBack.png")
            );
            status.setHandSize(hands.get(i).getHandSize());
            statusList.add(status);
        }

        addGameObject(background);

        for(int i = 0; i < statusList.size(); i++)
        {
            //addGameObject(statusList.get(i));
        }

        addGameObject(g);
        addGameObject(g.getBoard());



    }

}
