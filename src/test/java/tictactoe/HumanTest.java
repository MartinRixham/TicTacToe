package tictactoe;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class HumanTest
{
	@Test
	public void validPick()
	{
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(stream);
		InputStream in = new ByteArrayInputStream("3".getBytes());
		Board board = new Board();
		Player human = new Human(in, out, board);

		assertEquals(3, human.getNextMove());
	}

	@Test
	public void invalidPickFollowedByValidPick()
	{
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(stream);
		InputStream in = new ByteArrayInputStream("0\n4".getBytes());

		Board board = new Board();
		board.set(0, "X");
		board.set(1, "O");

		Player human = new Human(in, out, board);

		assertEquals(4, human.getNextMove());
	}
}
