package tictactoe;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class HumanTest
{
	@Test
	public void validPick()
	{
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(stream);
		Scanner in = new Scanner(new ByteArrayInputStream("3".getBytes()));
		Board board = new Board();
		Player human = new Human(in, out, board);

		assertEquals(3, human.getNextMove());
		assertEquals(
			"Pick one of the available spots 0, 1, 2, 3, 4, 5, 6, 7, 8:\n",
			stream.toString());
	}

	@Test
	public void handleUnknownInput()
	{
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(stream);
		Scanner in = new Scanner(new ByteArrayInputStream("wibble\n2\n".getBytes()));
		Board board = new Board();
		Player human = new Human(in, out, board);

		assertEquals(2, human.getNextMove());
		assertEquals(
			"Pick one of the available spots 0, 1, 2, 3, 4, 5, 6, 7, 8:\n" +
			"Pick one of the available spots 0, 1, 2, 3, 4, 5, 6, 7, 8:\n",
			stream.toString());
	}

	@Test
	public void invalidPickFollowedByValidPick()
	{
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(stream);
		Scanner in = new Scanner(new ByteArrayInputStream("0\n4".getBytes()));

		Board board = new Board();
		board.set(0, "X");
		board.set(1, "O");

		Player human = new Human(in, out, board);

		assertEquals(4, human.getNextMove());
		assertEquals(
			"Pick one of the available spots 2, 3, 4, 5, 6, 7, 8:\n" +
			"Pick one of the available spots 2, 3, 4, 5, 6, 7, 8:\n",
			stream.toString());
	}
}
