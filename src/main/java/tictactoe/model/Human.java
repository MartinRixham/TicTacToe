package tictactoe.model;

public class Human implements Player
{
	private boolean firstPlayer;

	public Human(boolean firstPlayer)
	{
		this.firstPlayer = firstPlayer;
	}

	public boolean selectSpot(String input, Board board)
	{
		if (isValid(input))
		{
			int spot = Integer.parseInt(input);

			if (board.isAvailable(spot))
			{
				board.set(spot, firstPlayer);

				return true;
			}
		}

		return  false;
	}

	private boolean isValid(String input)
	{
		return input.length() == 1 && Character.isDigit(input.charAt(0));
	}

	@Override
	public boolean isFirstPlayer()
	{
		return firstPlayer;
	}
}
