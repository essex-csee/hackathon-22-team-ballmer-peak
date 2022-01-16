package Client.Game.Objects;

import Client.ClientMain;
import Client.Game.ClientGame;
import Client.Render.Renderer;
import Client.Window.ClientWindow;

import java.awt.*;

public class GameState extends GameObject
{
    private Board boardState;

    // Possible Game States

    public enum State {
        MAINMENU,PLAYERJOIN,GAMESTART,GAMESTAT,GAMEOVER,LEADERBOARD
    }

    private State currentState;

    public State getCurrentState()
    {
        return currentState;
    }

    public void setCurrentState(State state)
    {
        currentState = state;
    }

    public GameState(long ID)
    {
        super(ID);
    }

    public void setBoardState(Board b)
    {
        boardState.clearBoard();

        for(int i = 0; i < b.getDecks().size(); i++)
        {
            boardState.addDeck(b.getDecks().get(i));
        }
        for(int i = 0; i < b.getHands().size(); i++)
        {
            boardState.addHand(b.getHands().get(i));
        }
        for(int i = 0; i < b.getPile().size(); i++)
        {
            boardState.addToPile(b.getPile().get(i));
        }
    }

    public Board getBoardState()
    {
        return boardState;
    }

    @Override
    public void update(long deltaTime)
    {
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
    }
}
