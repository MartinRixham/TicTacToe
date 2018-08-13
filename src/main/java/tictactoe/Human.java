package tictactoe;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Human implements Player
{
	private Scanner input;

	private PrintStream out;

	private Board board;

	public Human(InputStream in, PrintStream out, Board board)
	{
		this.input = new Scanner(in);
		this.out = out;
		this.board = board;
	}

	@Override
	public int getNextMove()
	{
		while (true)
		{
			prompt();

			if (input.hasNextInt())
			{
				int spot = input.nextInt();
				if (board.isAvailable(spot))
				{
					return spot;
				}
			}
			else
			{
				input.nextLine();
			}
		}
	}

	private void prompt()
	{
		String availableSpots = board.getAvailableSpaces().toString();

		out.print("Pick one of the available spots ");
		out.print(availableSpots.substring(1, availableSpots.length() - 1));
		out.println(":");
	}
}
