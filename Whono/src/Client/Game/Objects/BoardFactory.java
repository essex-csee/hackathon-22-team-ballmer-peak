package Client.Game.Objects;

import Client.Game.Objects.GameScreen.Board;

import java.util.List;

public class BoardFactory
{
	public static Board createBoard()
	{
		Board board = new Board();
		return board;
	}

	public static Board createBoard(List<Deck> decks, List<Hand> hands, List<Card> pile)
	{
		Board board = new Board();

		for(int i = 0; i < decks.size(); i++)
		{
			board.addDeck(decks.get(i));
		}

		for(int i = 0; i < hands.size(); i++)
		{
			board.addHand(hands.get(i));
		}

		for(int i = 0; i < pile.size(); i++)
		{
			board.addToPile(pile.get(i));
		}

		return board;
	}
}
