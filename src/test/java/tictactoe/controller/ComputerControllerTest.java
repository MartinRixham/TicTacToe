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
		Board board = new Board("X", "O");
		Computer computer = new Computer(true);
		PlayerController opponentController = new ComputerController(board, computer);

		PlayerController controller = new ComputerController(board, computer);
		controller.setOpponentController(opponentController);

		Result result = controller.handleInput("");

		String expectedOutput =
			"Player 1 picks spot: 5\n" +
			" 1 | 2 | 3\n" +
			"===+===+===\n" +
			" 4 | X | 6\n" +
			"===+===+===\n" +
			" 7 | 8 | 9\n";

		assertFalse(controller.requiresInput());
		assertEquals(expectedOutput, result.getOutput());
		assertEquals(opponentController, result.getNextController());
		assertFalse(result.gameIsOver());
		assertEquals("", controller.prompt());
	}

	@Test
	public void secondPlayerComputerMove()
	{
		Board board = new Board("X", "O");
		Computer computer = new Computer(false);

		PlayerController controller = new ComputerController(board, computer);

		Result result = controller.handleInput("");

		String expectedOutput =
			"Player 2 picks spot: 5\n" +
			" 1 | 2 | 3\n" +
			"===+===+===\n" +
			" 4 | O | 6\n" +
			"===+===+===\n" +
			" 7 | 8 | 9\n";

		assertEquals(expectedOutput, result.getOutput());
		assertFalse(result.gameIsOver());
	}

	@Test
	public void gameOver()
	{
		Board board = new Board("X", "O");
		board.set(4, true);
		board.set(6, true);

		Computer computer = new Computer(true);
		PlayerController opponentController = new ComputerController(board, computer);

		PlayerController controller = new ComputerController(board, computer);
		controller.setOpponentController(opponentController);

		Result result = controller.handleInput("");

		String expectedOutput =
			"Player 1 picks spot: 5\n" +
			" 1 | 2 | 3\n" +
			"===+===+===\n" +
			" X | X | X\n" +
			"===+===+===\n" +
			" 7 | 8 | 9\n\n" +
			"Player 1 wins!";

		assertEquals(expectedOutput, result.getOutput());
		assertTrue(result.gameIsOver());
	}
}
