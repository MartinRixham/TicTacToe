package tictactoe.model;

public class Human implements Player
{
	private String symbol;

	private boolean firstPlayer;

	public Human(String symbol, boolean firstPlayer)
	{
		this.symbol = symbol;
		this.firstPlayer = firstPlayer;
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

	@Override
	public boolean isFirstPlayer()
	{
		return firstPlayer;
	}
}
