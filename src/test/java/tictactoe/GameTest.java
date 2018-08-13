package tictactoe;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class GameTest
{
	@Test
	public void losingGame()
	{
		PrintStream originalOut = System.out;
		InputStream originalIn = System.in;

		ByteArrayOutputStream spyOut = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(spyOut);
		System.setOut(out);

		InputStream in = new ByteArrayInputStream("1\n2\n3\n".getBytes());
		System.setIn(in);

		Game.main(null);

		String expectedOutput =
			" 0 | 1 | 2\n" +
			"===+===+===\n" +
			" 3 | 4 | 5\n" +
			"===+===+===\n" +
			" 6 | 7 | 8\n" +
			"\n" +
			"Enter [0-8]:\n" +
			" 0 | X | 2\n" +
			"===+===+===\n" +
			" 3 | 4 | 5\n" +
			"===+===+===\n" +
			" 6 | 7 | 8\n" +
			"\n" +
			" 0 | X | 2\n" +
			"===+===+===\n" +
			" 3 | O | 5\n" +
			"===+===+===\n" +
			" 6 | 7 | 8\n" +
			"\n" +
			"Enter [0-8]:\n" +
			" 0 | X | X\n" +
			"===+===+===\n" +
			" 3 | O | 5\n" +
			"===+===+===\n" +
			" 6 | 7 | 8\n" +
			"\n" +
			" O | X | X\n" +
			"===+===+===\n" +
			" 3 | O | 5\n" +
			"===+===+===\n" +
			" 6 | 7 | 8\n" +
			"\n" +
			"Enter [0-8]:\n" +
			" O | X | X\n" +
			"===+===+===\n" +
			" X | O | 5\n" +
			"===+===+===\n" +
			" 6 | 7 | 8\n" +
			"\n" +
			" O | X | X\n" +
			"===+===+===\n" +
			" X | O | 5\n" +
			"===+===+===\n" +
			" 6 | 7 | O\n" +
			"\n" +
			"Game over\n";

		assertEquals(expectedOutput, spyOut.toString());

		System.setOut(originalOut);
		System.setIn(originalIn);
	}
}
