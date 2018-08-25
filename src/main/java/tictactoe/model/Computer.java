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
		// First go in the middle.
		if (board.isAvailable(4))
		{
			return 4;
		}

		List<Integer> availableSpots = board.getAvailableSpots();

		for (int spot : availableSpots)
		{
			// Try to find a winning move.
			if (winsAt(spot, true, board))
			{
				return spot;
			}

			// Prevent an opponents winning move.
			if (winsAt(spot, false, board))
			{
				return spot;
			}
		}

		// Choose a corner if possible.
		for (int spot: availableSpots)
		{
			if (spot % 2 == 0)
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
