package tictactoe;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

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
			if (board.get(4) == "4")
			{
				return 4;
			}
			else
			{
				int spot = getBestMove();
				if (board.get(spot) != "X" && board.get(spot) != "O")
				{
					return spot;
				}
			}
		}
	}

	private int getBestMove()
	{
		List<String> availableSpaces = board.getAvailableSpaces();

		for (String number : availableSpaces)
		{
			int spot = Integer.parseInt(number);

			if (winsAt(spot, "O"))
			{
				return spot;
			}

			if (winsAt(spot, "X"))
			{
				return spot;
			}
		}

		int n = ThreadLocalRandom.current().nextInt(0, availableSpaces.size());
		return Integer.parseInt(availableSpaces.get(n));
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
