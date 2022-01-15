package Client.Game.Objects;

import Client.ClientMain;
import Client.Game.ClientGame;
import Client.Game.Objects.GameScreen.GameScreenInit;
import Client.Game.Objects.MainMenu.MainMenuInit;
import Client.Render.Renderer;
import Client.Window.ClientWindow;

import java.awt.*;

public class GameState extends GameObject
{
    private Board boardState;

    // Possible Game States

    public enum State {
        MAINMENU,GAMESCREEN;
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
                MainMenuInit mm = new MainMenuInit();
                ClientGame.addLogicTarget(mm);
                break;
            case GAMESCREEN:
                GameScreenInit gs = new GameScreenInit();
                ClientGame.addLogicTarget(gs);
                break;

            default:
                System.out.println("Invalid State in GameState.");
        }
    }
}
