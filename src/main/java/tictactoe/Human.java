package tictactoe;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Human implements Player
{
	private Scanner input;

	private PrintStream out;

	public Human(InputStream in, PrintStream out)
	{
		this.input = new Scanner(in);
		this.out = out;
	}

	@Override
	public int getNextMove(Board board)
	{
		out.print("Enter [0-8]:\n");
		while (true)
		{
			int spot = input.nextInt();
			if (board.get(spot) != "X" && board.get(spot) != "O")
			{
				return spot;
			}
		}
	}
}
