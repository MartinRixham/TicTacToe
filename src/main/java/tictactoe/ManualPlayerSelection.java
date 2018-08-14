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
		out.println("1) human");
		out.println("2) computer");
		out.println("select player:");

		int firstPlayerType = in.nextInt();

		out.println("select symbol:");

		String firstPlayerSymbol = in.next();

		out.println("Player 2");
		out.println("1) human");
		out.println("2) computer");
		out.println("select player:");

		int secondPlayerType = in.nextInt();

		out.println("select symbol:");

		String secondPlayerSymbol = in.next();

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
