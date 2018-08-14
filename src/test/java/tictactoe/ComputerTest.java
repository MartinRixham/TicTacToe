package tictactoe;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ComputerTest
{
	@Test
	public void firstMoveIsMiddleSquare()
	{
		Board board = new Board();
		Player computer = new Computer("O", "X");

		int selectedSquare = computer.getNextMove(board);

		assertEquals(4, selectedSquare);
	}

	@Test
	public void preventOpponentFromWinning()
	{
		Board board = new Board();
		board.set(3, "#");
		board.set(4, "#");

		Player computer = new Computer("O", "#");

		int selectedSquare = computer.getNextMove(board);

		assertEquals(5, selectedSquare);
	}

	@Test
	public void selectWinningMove()
	{
		Board board = new Board();
		board.set(0, "@");
		board.set(4, "@");

		Player computer = new Computer("@", "X");

		int selectedSquare = computer.getNextMove(board);

		assertEquals(8, selectedSquare);
	}

	@Test
	public void selectCornerIfPossible()
	{
		Board board = new Board();
		board.set(0, "O");
		board.set(4, "X");

		Player computer = new Computer("O", "X");

		int selectedSquare = computer.getNextMove(board);

		assertEquals(0, selectedSquare % 2);
	}
}
