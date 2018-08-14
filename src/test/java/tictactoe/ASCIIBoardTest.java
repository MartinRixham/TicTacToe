package tictactoe;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ASCIIBoardTest
{
	@Test
	public void printStartingBoard()
	{
		Board board = new ASCIIBoard();

		String expectedBoard =
			" 0 | 1 | 2\n" +
			"===+===+===\n" +
			" 3 | 4 | 5\n" +
			"===+===+===\n" +
			" 6 | 7 | 8\n";

		assertEquals(expectedBoard, board.toString());
		assertFalse(board.gameIsOver());
		assertFalse(board.isTied());
	}

	@Test
	public void printBoardWithXInTopLeftCorner()
	{
		Board board = new ASCIIBoard();
		board.set(0, "X");

		String expectedBoard =
			" X | 1 | 2\n" +
			"===+===+===\n" +
			" 3 | 4 | 5\n" +
			"===+===+===\n" +
			" 6 | 7 | 8\n";

		assertEquals(expectedBoard, board.toString());
		assertFalse(board.gameIsOver());
		assertFalse(board.isTied());
	}

	@Test
	public void topLineWins()
	{
		Board board = new ASCIIBoard();
		board.set(0, "X");
		board.set(1, "X");
		board.set(2, "X");

		assertTrue(board.gameIsOver());
		assertFalse(board.isTied());
	}

	@Test
	public void middleLineWins()
	{
		Board board = new ASCIIBoard();
		board.set(3, "X");
		board.set(4, "X");
		board.set(5, "X");

		assertTrue(board.gameIsOver());
		assertFalse(board.isTied());
	}

	@Test
	public void bottomLineWins()
	{
		Board board = new ASCIIBoard();
		board.set(6, "X");
		board.set(7, "X");
		board.set(8, "X");

		assertTrue(board.gameIsOver());
		assertFalse(board.isTied());
	}

	@Test
	public void firstColumnWins()
	{
		Board board = new ASCIIBoard();
		board.set(0, "X");
		board.set(3, "X");
		board.set(6, "X");

		assertTrue(board.gameIsOver());
		assertFalse(board.isTied());
	}

	@Test
	public void middleColumnWins()
	{
		Board board = new ASCIIBoard();
		board.set(1, "X");
		board.set(4, "X");
		board.set(7, "X");

		assertTrue(board.gameIsOver());
		assertFalse(board.isTied());
	}

	@Test
	public void finalColumnWins()
	{
		Board board = new ASCIIBoard();
		board.set(2, "X");
		board.set(5, "X");
		board.set(8, "X");

		assertTrue(board.gameIsOver());
		assertFalse(board.isTied());
	}

	@Test
	public void forwardDiagonalWins()
	{
		Board board = new ASCIIBoard();
		board.set(6, "X");
		board.set(4, "X");
		board.set(2, "X");

		assertTrue(board.gameIsOver());
		assertFalse(board.isTied());
	}

	@Test
	public void backwardDiagonalWins()
	{
		Board board = new ASCIIBoard();
		board.set(0, "X");
		board.set(4, "X");
		board.set(8, "X");

		assertTrue(board.gameIsOver());
		assertFalse(board.isTied());
	}

	@Test
	public void fullBoardIsATie()
	{
		Board board = new ASCIIBoard();
		board.set(0, "O");
		board.set(1, "O");
		board.set(2, "X");
		board.set(3, "X");
		board.set(4, "X");
		board.set(5, "O");
		board.set(6, "O");
		board.set(7, "O");
		board.set(8, "X");

		assertFalse(board.gameIsOver());
		assertTrue(board.isTied());
	}
}
