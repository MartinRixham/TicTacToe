package tictactoe.controller;

import org.junit.Test;
import tictactoe.model.Board;
import tictactoe.model.Computer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ComputerControllerTest
{
	@Test
	public void computerMove()
	{
		Board board = new Board();
		Computer computer = new Computer("X", "O");
		PlayerController opponentController = new ComputerController(board, computer);

		PlayerController controller = new ComputerController(board, computer);
		controller.setOpponentController(opponentController);

		Result result = controller.handleInput("");

		String expectedOutput =
			"Player 1 picks spot: 4\n" +
			" 0 | 1 | 2\n" +
			"===+===+===\n" +
			" 3 | X | 5\n" +
			"===+===+===\n" +
			" 6 | 7 | 8\n";

		assertFalse(controller.requiresInput());
		assertEquals(expectedOutput, result.getOutput());
		assertEquals(opponentController, result.getNextController());
		assertFalse(result.gameIsOver());
		assertEquals("", controller.prompt());
	}

	@Test
	public void gameOver()
	{
		Board board = new Board();
		board.set(3, "X");
		board.set(5, "X");

		Computer computer = new Computer("X", "O");
		PlayerController opponentController = new ComputerController(board, computer);

		PlayerController controller = new ComputerController(board, computer);
		controller.setOpponentController(opponentController);

		Result result = controller.handleInput("");

		String expectedOutput =
			"Player 1 picks spot: 4\n" +
			" 0 | 1 | 2\n" +
			"===+===+===\n" +
			" X | X | X\n" +
			"===+===+===\n" +
			" 6 | 7 | 8\n";

		assertEquals(expectedOutput, result.getOutput());
		assertTrue(result.gameIsOver());
	}
}
