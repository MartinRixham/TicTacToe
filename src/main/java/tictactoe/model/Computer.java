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
		int spot = getNextMove(board, firstPlayer).getSpot();

		board.set(spot, firstPlayer);

		return spot;
	}

	private SpotScore getNextMove(Board board, boolean firstPlayer)
	{
		if (board.isAvailable(5))
		{
			return new SpotScore(5, Integer.MAX_VALUE, 0);
		}

		SpotScore bestScore = new SpotScore(0, Integer.MIN_VALUE, 0);
		List<Integer> availableSpots = board.getAvailableSpots();

		for (int spot: availableSpots)
		{
			board.set(spot, firstPlayer);

			SpotScore score;

			if (board.getWinner() > 0)
			{
				score = new SpotScore(spot, 1, 0);
			}
			else if (board.isTied())
			{
				score = new SpotScore(spot, 0, 0);
			}
			else
			{
				score = getNextMove(board, !firstPlayer).negateScore(spot);
			}

			if (score.isGreaterThan(bestScore))
			{
				bestScore = score;
			}

			board.reset(spot);
		}

		return bestScore.incrementDepth();
	}

	@Override
	public boolean isFirstPlayer()
	{
		return firstPlayer;
	}
}
