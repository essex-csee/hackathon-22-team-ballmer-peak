package Client.Game.Objects;

import Client.Game.ClientGame;

import java.awt.*;

public class GameState extends GameObject
{
    private Board boardState;

    // Possible Game States

    public enum State {
        MAINMENU,GAMESTART,LEADERBOARD
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

    @Override
    public void update(long deltaTime)
    {
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
            default:
                System.out.println("Invalid State in GameState.");
        }
    }
}
