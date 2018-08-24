package tictactoe.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HumanTest
{
	@Test
	public void validPick()
	{
		Board board = new ASCIIBoard();
		Human human = new Human("X");

		boolean success = human.selectSpot("3", board);

		assertTrue(success);
		assertEquals(8, board.getAvailableSpots().size());
		assertFalse(board.getAvailableSpots().contains(3));
	}

	@Test
	public void inputTooSmall()
	{
		Board board = new ASCIIBoard();
		Human human = new Human("X");

		boolean success = human.selectSpot("-1", board);

		assertFalse(success);
		assertEquals(9, board.getAvailableSpots().size());
	}

	@Test
	public void inputTooLarge()
	{
		Board board = new ASCIIBoard();
		Human human = new Human("X");

		boolean success = human.selectSpot("10", board);

		assertFalse(success);
		assertEquals(9, board.getAvailableSpots().size());
	}

	@Test
	public void unknownInput()
	{
		Board board = new ASCIIBoard();
		Human human = new Human("X");

		boolean success = human.selectSpot("wibble", board);

		assertFalse(success);
		assertEquals(9, board.getAvailableSpots().size());
	}

	@Test
	public void samePickTwice()
	{
		Board board = new ASCIIBoard();
		Human human = new Human("X");

		human.selectSpot("4", board);
		boolean success = human.selectSpot("4", board);

		assertFalse(success);
		assertEquals(8, board.getAvailableSpots().size());
		assertFalse(board.getAvailableSpots().contains(4));
	}
}
