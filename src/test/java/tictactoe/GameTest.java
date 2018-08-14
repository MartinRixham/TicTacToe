package tictactoe;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class GameTest
{
	@Test
	public void losingGame()
	{
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(stream);
		Scanner in = new Scanner(new ByteArrayInputStream("1\n2\n3\n".getBytes()));
		PlayerSelection playerSelection = new FakePlayerSelection(in, out);

		new Game(out, playerSelection).play();

		String expectedOutput =
			" 0 | 1 | 2\n" +
			"===+===+===\n" +
			" 3 | 4 | 5\n" +
			"===+===+===\n" +
			" 6 | 7 | 8\n" +
			"\n" +
			"Pick one of the available spots 0, 1, 2, 3, 4, 5, 6, 7, 8:\n" +
			"Player 1 picks spot: 1\n" +
			" 0 | X | 2\n" +
			"===+===+===\n" +
			" 3 | 4 | 5\n" +
			"===+===+===\n" +
			" 6 | 7 | 8\n" +
			"\n" +
			"Player 2 picks spot: 4\n" +
			" 0 | X | 2\n" +
			"===+===+===\n" +
			" 3 | O | 5\n" +
			"===+===+===\n" +
			" 6 | 7 | 8\n" +
			"\n" +
			"Pick one of the available spots 0, 2, 3, 5, 6, 7, 8:\n" +
			"Player 1 picks spot: 2\n" +
			" 0 | X | X\n" +
			"===+===+===\n" +
			" 3 | O | 5\n" +
			"===+===+===\n" +
			" 6 | 7 | 8\n" +
			"\n" +
			"Player 2 picks spot: 0\n" +
			" O | X | X\n" +
			"===+===+===\n" +
			" 3 | O | 5\n" +
			"===+===+===\n" +
			" 6 | 7 | 8\n" +
			"\n" +
			"Pick one of the available spots 3, 5, 6, 7, 8:\n" +
			"Player 1 picks spot: 3\n" +
			" O | X | X\n" +
			"===+===+===\n" +
			" X | O | 5\n" +
			"===+===+===\n" +
			" 6 | 7 | 8\n" +
			"\n" +
			"Player 2 picks spot: 8\n" +
			" O | X | X\n" +
			"===+===+===\n" +
			" X | O | 5\n" +
			"===+===+===\n" +
			" 6 | 7 | O\n" +
			"\n" +
			"Player 2 wins!\n";

		assertEquals(expectedOutput, stream	.toString());
	}
}
