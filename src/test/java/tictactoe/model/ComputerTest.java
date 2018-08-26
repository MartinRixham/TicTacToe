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
		Board board = new Board("X", "O");
		Computer computer = new Computer(true);

		int selectedSquare = computer.selectSpot(board);

		assertEquals(5, selectedSquare);
		assertTrue(computer.isFirstPlayer());
	}

	@Test
	public void preventOpponentFromWinning()
	{
		Board board = new Board("X", "O");
		board.set(5, true);
		board.set(3, false);
		board.set(4, true);

		Computer computer = new Computer(false);

		int selectedSquare = computer.selectSpot(board);

		assertEquals(6, selectedSquare);
		assertFalse(computer.isFirstPlayer());
	}

	@Test
	public void selectWinningMove()
	{
		Board board = new Board("X", "O");
		board.set(1, true);
		board.set(5, true);

		Computer computer = new Computer(true);

		int selectedSquare = computer.selectSpot(board);

		assertEquals(9, selectedSquare);
	}

	@Test
	public void selectEdgeAfterMiddle()
	{
		Board board = new Board("X", "O");
		board.set(5, true);
		board.set(1, false);

		Computer computer = new Computer(true);

		int selectedSquare = computer.selectSpot(board);

		assertEquals(2, selectedSquare);
	}

	@Test
	public void avoidCornerIfOpponentHasSelectedTwoCorners()
	{
		Board board = new Board("X", "O");
		board.set(7, false);
		board.set(5, true);
		board.set(3, false);

		Computer computer = new Computer(true);

		int selectedSquare = computer.selectSpot(board);

		assertEquals(2, selectedSquare);
	}
}
