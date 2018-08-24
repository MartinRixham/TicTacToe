package tictactoe.controller;

import org.junit.Test;
import tictactoe.model.ASCIIBoard;
import tictactoe.model.Board;
import tictactoe.model.Human;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class HumanControllerTest
{
	@Test
	public void promptToSelectSpot()
	{
		Board board = new ASCIIBoard();
		Human human = new Human("X");

		Controller controller = new HumanController(board, human);

		assertEquals(
			"Pick one of the available spots 0, 1, 2, 3, 4, 5, 6, 7, 8:",
			controller.prompt());
	}

	@Test
	public void validPick()
	{
		Board board = new ASCIIBoard();
		Human human = new Human("X");

		Controller controller = new HumanController(board, human);

		Result result = controller.handleInput("3");

		String expectedOutput =
			"Player 1 picks spot: 3\n" +
			" 0 | 1 | 2\n" +
			"===+===+===\n" +
			" X | 4 | 5\n" +
			"===+===+===\n" +
			" 6 | 7 | 8\n";

		assertEquals(expectedOutput, result.getOutput());
		assertFalse(result.gameIsOver());
	}

	@Test
	public void invalidPick()
	{
		Board board = new ASCIIBoard();
		Human human = new Human("X");

		Controller controller = new HumanController(board, human);

		Result result = controller.handleInput("10");

		assertEquals("", result.getOutput());
		assertFalse(result.gameIsOver());
	}
}
