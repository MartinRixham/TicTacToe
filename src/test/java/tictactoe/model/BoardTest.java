package tictactoe.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BoardTest
{
	@Test
	public void printStartingBoard()
	{
		Board board = new Board("X", "O");

		String expectedBoard =
			" 0 | 1 | 2\n" +
			"===+===+===\n" +
			" 3 | 4 | 5\n" +
			"===+===+===\n" +
			" 6 | 7 | 8\n";

		assertEquals(expectedBoard, board.toString());
		assertFalse(board.gameIsOver());
	}

	@Test
	public void printBoardWithXInTopLeftCorner()
	{
		Board board = new Board("X", "O");
		board.set(0, true);

		String expectedBoard =
			" X | 1 | 2\n" +
			"===+===+===\n" +
			" 3 | 4 | 5\n" +
			"===+===+===\n" +
			" 6 | 7 | 8\n";

		assertEquals(expectedBoard, board.toString());
		assertFalse(board.gameIsOver());
	}

	@Test
	public void resetSelectedSpot()
	{
		Board board = new Board("X", "O");
		board.set(0, true);
		board.reset(0);

		String expectedBoard =
			" 0 | 1 | 2\n" +
			"===+===+===\n" +
			" 3 | 4 | 5\n" +
			"===+===+===\n" +
			" 6 | 7 | 8\n";

		assertEquals(expectedBoard, board.toString());
		assertFalse(board.gameIsOver());
	}

	@Test
	public void topLineWins()
	{
		Board board = new Board("X", "O");
		board.set(0, true);
		board.set(1, true);
		board.set(2, true);

		String expected =
			" X | X | X\n" +
			"===+===+===\n" +
			" 3 | 4 | 5\n" +
			"===+===+===\n" +
			" 6 | 7 | 8\n\n" +
			"Player 1 wins!";

		assertEquals(expected, board.toString());
		assertTrue(board.gameIsOver());
	}

	@Test
	public void middleLineWins()
	{
		Board board = new Board("X", "O");
		board.set(3, true);
		board.set(4, true);
		board.set(5, true);

		assertTrue(board.gameIsOver());
	}

	@Test
	public void bottomLineWins()
	{
		Board board = new Board("X", "O");
		board.set(6, true);
		board.set(7, true);
		board.set(8, true);

		assertTrue(board.gameIsOver());
	}

	@Test
	public void firstColumnWins()
	{
		Board board = new Board("X", "O");
		board.set(0, true);
		board.set(3, true);
		board.set(6, true);

		assertTrue(board.gameIsOver());
	}

	@Test
	public void middleColumnWins()
	{
		Board board = new Board("X", "O");
		board.set(1, true);
		board.set(4, true);
		board.set(7, true);

		assertTrue(board.gameIsOver());
	}

	@Test
	public void finalColumnWins()
	{
		Board board = new Board("X", "O");
		board.set(2, true);
		board.set(5, true);
		board.set(8, true);

		assertTrue(board.gameIsOver());
	}

	@Test
	public void forwardDiagonalWins()
	{
		Board board = new Board("X", "O");
		board.set(6, true);
		board.set(4, true);
		board.set(2, true);

		assertTrue(board.gameIsOver());
	}

	@Test
	public void backwardDiagonalWins()
	{
		Board board = new Board("X", "O");
		board.set(0, true);
		board.set(4, true);
		board.set(8, true);

		assertTrue(board.gameIsOver());
	}

	@Test
	public void fullBoardIsATie()
	{
		Board board = new Board("X", "O");
		board.set(0, false);
		board.set(1, false);
		board.set(2, true);
		board.set(3, true);
		board.set(4, true);
		board.set(5, false);
		board.set(6, false);
		board.set(7, false);
		board.set(8, true);

		String expected =
			" O | O | X\n" +
			"===+===+===\n" +
			" X | X | O\n" +
			"===+===+===\n" +
			" O | O | X\n\n" +
			"It's a tie!";

		assertEquals(expected, board.toString());
		assertTrue(board.gameIsOver());
	}
}
