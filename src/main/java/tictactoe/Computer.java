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
		while (true)
		{
			if (board.isAvailable(4))
			{
				return 4;
			}
			else
			{
				int spot = getBestMove();
				if (board.isAvailable(spot))
				{
					return spot;
				}
			}
		}
	}

	private int getBestMove()
	{
		List<Integer> availableSpaces = board.getAvailableSpaces();

		for (int spot : availableSpaces)
		{
			if (winsAt(spot, "O"))
			{
					return spot;
			}

			if (winsAt(spot, "X"))
			{
				return spot;
			}
		}

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
