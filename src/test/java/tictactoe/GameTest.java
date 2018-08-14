package tictactoe;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class GameTest
{
	@Test
	public void losingGame()
	{
		PrintStream originalOut = System.out;
		InputStream originalIn = System.in;
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(stream);

		System.setOut(out);

		InputStream in = new ByteArrayInputStream("1\nX\n2\nO\n1\n2\n3\n".getBytes());
		System.setIn(in);

		Game.main(null);

		String expectedOutput =
			"Player 1\n1) human\n2) computer\nselect player:\nselect symbol:\n" +
			"Player 2\n1) human\n2) computer\nselect player:\nselect symbol:\n" +
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

		System.setOut(originalOut);
		System.setIn(originalIn);
	}

	@Test
	public void playerOneWins()
	{
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(stream);
		Board board = FakeBoard.playerOneWins();
		Scanner in = new Scanner(new ByteArrayInputStream("1\n2\n3\n".getBytes()));
		PlayerSelection playerSelection = new FakePlayerSelection(in, out);

		new Game(out, board, playerSelection).play();

		String expectedOutput =
			"□\n" +
			"Pick one of the available spots 0, 1, 2, 3:\n" +
			"Player 1 picks spot: 1\n" +
			"□\n" +
			"Player 1 wins!\n";

		assertEquals(expectedOutput, stream.toString());
	}

	@Test
	public void playerTwoWins()
	{
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(stream);
		Board board = FakeBoard.playerTwoWins();
		Scanner in = new Scanner(new ByteArrayInputStream("1\n2\n3\n".getBytes()));
		PlayerSelection playerSelection = new FakePlayerSelection(in, out);

		new Game(out, board, playerSelection).play();

		String expectedOutput =
			"□\n" +
			"Pick one of the available spots 0, 1, 2, 3:\n" +
			"Player 1 picks spot: 1\n" +
			"□\n" +
			"Player 2 picks spot: 0\n" +
			"□\n" +
			"Player 2 wins!\n";

		assertEquals(expectedOutput, stream.toString());
	}

	@Test
	public void tieAfterFirstMove()
	{
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(stream);
		Board board = FakeBoard.tieAfterFirstMove();
		Scanner in = new Scanner(new ByteArrayInputStream("1\n2\n3\n".getBytes()));
		PlayerSelection playerSelection = new FakePlayerSelection(in, out);

		new Game(out, board, playerSelection).play();

		String expectedOutput =
			"□\n" +
			"Pick one of the available spots 0, 1, 2, 3:\n" +
			"Player 1 picks spot: 1\n" +
			"□\n" +
			"It's a tie!\n";

		assertEquals(expectedOutput, stream.toString());
	}

	@Test
	public void tieAfterSecondMove()
	{
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(stream);
		Board board = FakeBoard.tieAfterSecondMove();
		Scanner in = new Scanner(new ByteArrayInputStream("1\n2\n3\n".getBytes()));
		PlayerSelection playerSelection = new FakePlayerSelection(in, out);

		new Game(out, board, playerSelection).play();

		String expectedOutput =
			"□\n" +
			"Pick one of the available spots 0, 1, 2, 3:\n" +
			"Player 1 picks spot: 1\n" +
			"□\n" +
			"Player 2 picks spot: 0\n" +
			"□\n" +
			"It's a tie!\n";

		assertEquals(expectedOutput, stream.toString());
	}
}
