package Client.Game.Objects;

import Client.Game.Objects.GameScreen.AIPlayer;
import Client.Game.Objects.GameScreen.Board;
import Client.Game.Objects.GameScreen.HandStatus;
import Util.CONSTANTS;

import java.util.ArrayList;

public class GameState extends GameObject
{

    // Possible Game States

    public enum State {
        MAINMENU,PLAYERJOIN,GAMESTART,GAMESTAT,GAMEOVER,LEADERBOARD
    }

    private State currentState = State.MAINMENU;

    public State getCurrentState(){ return  currentState;}

    public static GameState createGameState(int numberOfPlayers, boolean solo)
    {
        GameState g = new GameState(numberOfPlayers,solo);

        g.mDeck = DeckFactory.createDeck();
        g.mHands = new ArrayList<Hand>();

        for(int i = 0; i < 1; i++)
        {
            g.mHands.add(HandFactory.createHand(g.mDeck));
            g.mBoard.addHand(g.mHands.get(i));
        }

        for(int i = 1; i < CONSTANTS.PLAYER_LIMIT; i++)
        {
            Hand h = HandFactory.createHand(g.mDeck);
            g.mHands.add(h);
            g.mBoard.addAIHand( h, new AIPlayer(h) );
        }

        for(int i = 0; i <  g.mHands.size(); i++)
        {

            HandStatus status = new HandStatus(
                    i,
                    50,
                    i*120 + 62,
                    g.mHands.get(i)
            );
            g.mBoard.addHandStatus(status);
        }

        g.mBoard.addDeck(g.mDeck);

        g.getBoard().addToPile(g.mDeck.drawCard());


        return g;
    }

    public GameState(int numberOfPlayers, boolean solo)
    {
        super(-1);
        if(solo) {
            mBoard = new Board();
        }
        else {
            mBoard = new Board();
        }
    }


    public Board getBoard()
    {
        return mBoard;
    }

    @Override
    public void update(long deltaTime)
    {
        /*
        if(ClientGame.getInput().getKeyPressed('q'))
        {
            // Close window
            // Theres no way to access mIsCloseRequested to close the window
        }
        // Perform behaviour based on current state
        switch(getCurrentState())
        {
            case MAINMENU:
                // Draw main menu
                break;
            case GAMESTART:
                // Initialise game
                break;
            case LEADERBOARD:
                // Draw leaderboard
                break;
            case PLAYERJOIN:
                // Player Join Game
                break;
            case GAMEOVER:
                // Game over condition check
                break;
            case GAMESTAT:
                // Game state 'increment'
                break;
            default:
                System.out.println("Invalid State in GameState.");
        }
         */
    }

    protected Deck mDeck;
    protected ArrayList<Hand> mHands;
    protected Board mBoard;

}
