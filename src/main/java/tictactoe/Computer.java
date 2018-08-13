package tictactoe;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Computer implements Player
{
	public int getNextMove(Board board)
	{
		while (true)
		{
			if (board.get(4) == "4")
			{
				return 4;
			}
			else
			{
				int spot = getBestMove(board);
				if (board.get(spot) != "X" && board.get(spot) != "O")
				{
					return spot;
				}
			}
		}
	}

	public int getBestMove(Board board)
	{
		List<String> availableSpaces = board.getAvailableSpaces();
		boolean foundBestMove = false;
		int spot = 100;
		for (String as : availableSpaces)
		{
			spot = Integer.parseInt(as);
			board.set(spot, "O");
			if (board.gameIsOver())
			{
				foundBestMove = true;
				board.set(spot, as);
				return spot;
			}
			else
			{
				board.set(spot, "X");
				if (board.gameIsOver())
				{
					foundBestMove = true;
					board.set(spot, as);
					return spot;
				}
				else
				{
					board.set(spot, as);
				}
			}
		}
		if (foundBestMove)
		{
			return spot;
		}
		else
		{
			int n = ThreadLocalRandom.current().nextInt(0, availableSpaces.size());
			return Integer.parseInt(availableSpaces.get(n));
		}
	}
}
