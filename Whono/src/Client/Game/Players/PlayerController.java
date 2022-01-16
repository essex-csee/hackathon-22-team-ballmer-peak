package Client.Game.Players;

import java.util.ArrayList;
import java.util.List;

public class PlayerController {
    int playerCount;
    int turn;
    List<Integer> players;

    public PlayerController(int playerCount, int turn)
    {
        this.playerCount = playerCount;
        this.turn = turn;
        this.players = new ArrayList<>();

    }
    public int getTurn()
    {
        return players.get(turn);
    }
    public int getPlayerCount() {
        return players.size();
    }

    public void nextTurn() {
        if (turn < players.size())
            turn++;
        else
            turn = 0;
    }
    public int addPlayer()
    {
        players.add(++playerCount);
        return playerCount - 1;
    }
    public void removePlayer(Integer i)
    {
        players.remove(i);

    }
}
