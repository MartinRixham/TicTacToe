package tictactoe;

import java.io.PrintStream;
import java.util.Scanner;

public class ManualPlayerSelection implements PlayerSelection
{
	private Player firstPlayer;

	private Player secondPlayer;

	public ManualPlayerSelection(Scanner in, PrintStream out)
	{
		out.println("Player 1");

		int firstPlayerType = getPlayerType(in, out);
		String firstPlayerSymbol = getSymbol(in, out);

		out.println("Player 2");

		int secondPlayerType = getPlayerType(in, out);
		String secondPlayerSymbol = getSymbol(in, out);

		if (firstPlayerType == 1)
		{
			firstPlayer = new Human(in, out, firstPlayerSymbol);
		}
		else
		{
			firstPlayer = new Computer(firstPlayerSymbol, secondPlayerSymbol);
		}

		if (secondPlayerType == 1)
		{
			secondPlayer = new Human(in, out, secondPlayerSymbol);
		}
		else
		{
			secondPlayer = new Computer(secondPlayerSymbol, firstPlayerSymbol);
		}
	}

	private int getPlayerType(Scanner in, PrintStream out)
	{
		while (true)
		{
			out.println("1) human");
			out.println("2) computer");
			out.println("select player:");

			if (in.hasNextInt())
			{
				int playerType = in.nextInt();
				in.nextLine();

				if (playerType == 1 || playerType == 2)
				{
					return playerType;
				}
			}
			else
			{
				in.nextLine();
			}
		}
	}

	private String getSymbol(Scanner in, PrintStream out)
	{
		while (true)
		{
			out.println("select symbol:");

			String symbol = in.nextLine();

			if (symbol.length() == 1)
			{
				return symbol;
			}
		}
	}

	@Override
	public Player getFirstPlayer()
	{
		return firstPlayer;
	}

	@Override
	public Player getSecondPlayer()
	{
		return secondPlayer;
	}
}
