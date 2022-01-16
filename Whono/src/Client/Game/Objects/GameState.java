package Client.Game.Objects;

import Client.ClientMain;
import Client.Game.ClientGame;
import Client.Game.Objects.GameScreen.GameScreenInit;
import Client.Game.Objects.MainMenu.MainMenuInit;
import Client.Render.Renderer;
import Client.Window.ClientWindow;

import java.awt.*;
import java.util.ArrayList;

public class GameState extends GameObject
{

    public static GameState createGameState(int numberOfPlayers)
    {
        GameState g = new GameState(numberOfPlayers);

        g.mDeck = DeckFactory.createDeck();
        g.mHands = new ArrayList<Hand>();

        for(int i = 0; i < numberOfPlayers; i++)
        {
            g.mHands.add(HandFactory.createHand(g.mDeck));
        }

        for(Hand h : g.mHands)
        {
            g.mBoard.addHand(h);
        }

        g.mBoard.addDeck(g.mDeck);

        return g;
    }

    public GameState(int numberOfPlayers)
    {
        super(-1);
        mBoard = new Board();
    }

    public Board getBoard()
    {
        return mBoard;
    }

    @Override
    public void update(long deltaTime)
    {

    }

    protected Deck mDeck;
    protected ArrayList<Hand> mHands;
    protected Board mBoard;

}
