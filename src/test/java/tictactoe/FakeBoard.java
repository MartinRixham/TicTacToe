package tictactoe;

import java.util.Arrays;
import java.util.List;

public final class FakeBoard implements Board
{
	private List<Integer> availableSpots = Arrays.asList(0, 1, 2, 3);

	private boolean gameIsDrawn;

	private int lengthOfGame;

	public static FakeBoard playerOneWins()
	{
		return new FakeBoard(false, 1);
	}

	public static FakeBoard playerTwoWins()
	{
		return new FakeBoard(false, 2);
	}

	public static FakeBoard tieAfterFirstMove()
	{
		return new FakeBoard(true, 1);
	}

	public static FakeBoard tieAfterSecondMove()
	{
		return new FakeBoard(true, 2);
	}

	private FakeBoard(boolean gameIsDrawn, int lengthOfGame)
	{
		this.gameIsDrawn = gameIsDrawn;
		this.lengthOfGame = lengthOfGame;
	}

	@Override
	public boolean gameIsOver()
	{
		return !gameIsDrawn && lengthOfGame <= 0;
	}

	@Override
	public boolean isTied()
	{
		return gameIsDrawn && lengthOfGame <= 0;
	}

	@Override
	public void set(int spot, String symbol)
	{
		lengthOfGame--;
	}

	@Override
	public List<Integer> getAvailableSpots()
	{
		return availableSpots;
	}

	@Override
	public boolean isAvailable(int spot)
	{
		return availableSpots.contains(spot);
	}

	@Override
	public String toString()
	{
		return "\u25A1";
	}
}
