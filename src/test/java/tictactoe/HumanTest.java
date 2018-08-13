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
		String[] board = {"0", "1", "2", "3", "4", "5", "6", "7", "8"};
		Player human = new Human(in, out);

		assertEquals(3, human.getNextMove(board));
	}

	@Test
	public void invalidPickFollowedByValidPick()
	{
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(stream);
		InputStream in = new ByteArrayInputStream("0\n4".getBytes());
		String[] board = {"X", "O", "2", "3", "4", "5", "6", "7", "8"};
		Player human = new Human(in, out);

		assertEquals(4, human.getNextMove(board));
	}
}
