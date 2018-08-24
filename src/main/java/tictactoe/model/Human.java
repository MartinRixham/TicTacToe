package tictactoe.model;

import tictactoe.Player;

public class Human implements Player
{
	private String symbol;

	public Human(String symbol)
	{
		this.symbol = symbol;
	}

	public boolean selectSpot(String input, Board board)
	{
		if (isInteger(input))
		{
			int spot = Integer.parseInt(input);

			if (board.isAvailable(spot))
			{
				board.set(spot, symbol);

				return true;
			}
		}

		return  false;
	}

	private boolean isInteger(String input)
	{
		try
		{
			Integer.parseInt(input);
		}
		catch (NumberFormatException e)
		{
			return false;
		}

		return true;
	}
}
