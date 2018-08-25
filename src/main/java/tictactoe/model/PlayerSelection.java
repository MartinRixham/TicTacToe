package tictactoe.model;

public class PlayerSelection
{
	private String firstPlayerType;

	private String secondPlayerType;

	private String firstSymbol;

	private String secondSymbol;

	public boolean selectPlayerType(String input)
	{
		boolean valid = input.equals("1") || input.equals("2");

		if (valid)
		{
			if (firstPlayerType == null)
			{
				firstPlayerType = input;
			}
			else
			{
				secondPlayerType = input;
			}
		}

		return valid;
	}

	public boolean selectPlayerSymbol(String input)
	{
		boolean valid = input.length() == 1;

		if (valid)
		{
			if (firstSymbol == null)
			{
				firstSymbol = input;
			}
			else
			{
				secondSymbol = input;
			}
		}

		return valid;
	}

	public Player getFirstPlayer()
	{
		return getPlayer(firstSymbol, firstPlayerType, true);
	}

	public Player getSecondPlayer()
	{
		return getPlayer(secondSymbol, secondPlayerType, false);
	}

	private Player getPlayer(String symbol, String playerType, boolean isFirstPlayer)
	{
		if (symbol == null || playerType == null)
		{
			return null;
		}
		else if (playerType.equals("1"))
		{
			return new Human(symbol, isFirstPlayer);
		}
		else
		{
			return new Computer(symbol, isFirstPlayer);
		}
	}
}
