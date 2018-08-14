package tictactoe;

import java.io.PrintStream;
import java.util.Scanner;

public class FakePlayerSelection implements PlayerSelection
{
	private Scanner in;

	private PrintStream out;

	public FakePlayerSelection(Scanner in, PrintStream out)
	{
		this.in = in;
		this.out = out;
	}

	@Override
	public Player getFirstPlayer()
	{
		return new Human(in, out, "X");
	}

	@Override
	public Player getSecondPlayer()
	{
		return new Computer("O", "X");
	}
}
