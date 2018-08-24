package tictactoe.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ComputerTest
{
	@Test
	public void firstMoveIsMiddleSquare()
	{
		Board board = new ASCIIBoard();
		Computer computer = new Computer("O", "X");

		int selectedSquare = computer.selectSpot(board);

		assertEquals(4, selectedSquare);
	}

	@Test
	public void preventOpponentFromWinning()
	{
		Board board = new ASCIIBoard();
		board.set(3, "#");
		board.set(4, "#");

		Computer computer = new Computer("O", "#");

		int selectedSquare = computer.selectSpot(board);

		assertEquals(5, selectedSquare);
	}

	@Test
	public void selectWinningMove()
	{
		Board board = new ASCIIBoard();
		board.set(0, "@");
		board.set(4, "@");

		Computer computer = new Computer("@", "X");

		int selectedSquare = computer.selectSpot(board);

		assertEquals(8, selectedSquare);
	}

	@Test
	public void selectCornerIfPossible()
	{
		Board board = new ASCIIBoard();
		board.set(0, "O");
		board.set(4, "X");

		Computer computer = new Computer("O", "X");

		int selectedSquare = computer.selectSpot(board);

		assertEquals(0, selectedSquare % 2);
	}
}
