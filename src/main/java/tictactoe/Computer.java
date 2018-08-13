package tictactoe;

import java.util.List;

public class Computer implements Player
{
	private Board board;

	public Computer(Board board)
	{
		this.board = board;
	}

	public int getNextMove()
	{
		// First go in the middle.
		if (board.isAvailable(4))
		{
			return 4;
		}

		List<Integer> availableSpaces = board.getAvailableSpaces();

		for (int spot : availableSpaces)
		{
			// Try to find a winning move.
			if (winsAt(spot, "O"))
			{
				return spot;
			}

			// Prevent an opponents winning move.
			if (winsAt(spot, "X"))
			{
				return spot;
			}
		}

		// Choose a corner if possible.
		for (int spot: availableSpaces)
		{
			if (spot % 2 == 0)
			{
				return spot;
			}
		}

		return availableSpaces.get(0);
	}

	private boolean winsAt(int spot, String symbol)
	{
		boolean wins;

		board.set(spot, symbol);
		wins = board.gameIsOver();
		board.set(spot, Integer.toString(spot));

		return wins;
	}
}
