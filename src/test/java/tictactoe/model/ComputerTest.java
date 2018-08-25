package tictactoe.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ComputerTest
{
	@Test
	public void firstMoveIsMiddleSquare()
	{
		Board board = new Board();
		Computer computer = new Computer("O", true);

		int selectedSquare = computer.selectSpot(board);

		assertEquals(4, selectedSquare);
		assertTrue(computer.isFirstPlayer());
	}

	@Test
	public void preventOpponentFromWinning()
	{
		Board board = new Board();
		board.set(3, "X");
		board.set(4, "X");

		Computer computer = new Computer("O", false);

		int selectedSquare = computer.selectSpot(board);

		assertEquals(5, selectedSquare);
		assertFalse(computer.isFirstPlayer());
	}

	@Test
	public void selectWinningMove()
	{
		Board board = new Board();
		board.set(0, "@");
		board.set(4, "@");

		Computer computer = new Computer("@", true);

		int selectedSquare = computer.selectSpot(board);

		assertEquals(8, selectedSquare);
	}

	@Test
	public void selectCornerIfPossible()
	{
		Board board = new Board();
		board.set(0, "O");
		board.set(4, "X");

		Computer computer = new Computer("O", true);

		int selectedSquare = computer.selectSpot(board);

		assertEquals(0, selectedSquare % 2);
	}
}
