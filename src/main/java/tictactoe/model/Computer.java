package tictactoe.model;

import java.util.List;

public class Computer implements Player
{
	private boolean firstPlayer;

	public Computer(boolean firstPlayer)
	{
		this.firstPlayer = firstPlayer;
	}

	public int selectSpot(Board board)
	{
		int spot = getNextMove(board);

		board.set(spot, firstPlayer);

		return spot;
	}

	private int getNextMove(Board board)
	{
		if (board.isAvailable(5))
		{
			return 5;
		}

		List<Integer> availableSpots = board.getAvailableSpots();

		for (int spot : availableSpots)
		{
			if (winsAt(spot, firstPlayer, board))
			{
				return spot;
			}

			if (winsAt(spot, !firstPlayer, board))
			{
				return spot;
			}
		}

		for (int spot: availableSpots)
		{
			if (spot % 2 == 1)
			{
				return spot;
			}
		}

		return availableSpots.get(0);
	}

	private boolean winsAt(int spot, boolean firstPlayer, Board board)
	{
		boolean wins;

		board.set(spot, firstPlayer);
		wins = board.gameIsOver();
		board.reset(spot);

		return wins;
	}

	@Override
	public boolean isFirstPlayer()
	{
		return firstPlayer;
	}
}
