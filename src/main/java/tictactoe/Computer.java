package tictactoe;

import java.util.List;

public class Computer implements Player
{
	private String symbol;

	private String opponentSymbol;

	public Computer(String symbol, String opponentSymbol)
	{
		this.symbol = symbol;
		this.opponentSymbol = opponentSymbol;
	}

	public int getNextMove(Board board)
	{
		// First go in the middle.
		if (board.isAvailable(4))
		{
			return 4;
		}

		List<Integer> availableSpaces = board.getAvailableSpots();

		for (int spot : availableSpaces)
		{
			// Try to find a winning move.
			if (winsAt(spot, symbol, board))
			{
				return spot;
			}

			// Prevent an opponents winning move.
			if (winsAt(spot, opponentSymbol, board))
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

	@Override
	public String getSymbol()
	{
		return symbol;
	}

	private boolean winsAt(int spot, String symbol, Board board)
	{
		boolean wins;

		board.set(spot, symbol);
		wins = board.gameIsOver();
		board.set(spot, Integer.toString(spot));

		return wins;
	}
}
