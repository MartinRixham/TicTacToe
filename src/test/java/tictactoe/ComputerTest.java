package tictactoe;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ComputerTest
{
	@Test
	public void firstMoveIsMiddleSquare()
	{
		Board board = new Board();
		Player computer = new Computer(board);

		int selectedSquare = computer.getNextMove();

		assertEquals(4, selectedSquare);
	}

	@Test
	public void preventOpponentFromWinning()
	{
		Board board = new Board();
		board.set(3, "X");
		board.set(4, "X");

		Player computer = new Computer(board);

		int selectedSquare = computer.getNextMove();

		assertEquals(5, selectedSquare);
	}

	@Test
	public void selectWinningMove()
	{
		Board board = new Board();
		board.set(0, "O");
		board.set(4, "O");

		Player computer = new Computer(board);

		int selectedSquare = computer.getNextMove();

		assertEquals(8, selectedSquare);
	}

	@Test
	public void selectCornerIfPossible()
	{
		Board board = new Board();
		board.set(0, "O");
		board.set(4, "X");

		Player computer = new Computer(board);

		int selectedSquare = computer.getNextMove();

		assertEquals(0, selectedSquare % 2);
	}
}
