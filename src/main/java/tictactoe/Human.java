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
		out.print("Enter [0-8]:\n");
		while (true)
		{
			int spot = input.nextInt();
			if (board.isAvailable(spot))
			{
				return spot;
			}
		}
	}
}
