package tictactoe.controller;

import org.junit.Test;
import tictactoe.model.Board;
import tictactoe.model.Computer;
import tictactoe.model.Human;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HumanControllerTest
{
	@Test
	public void promptToSelectSpot()
	{
		Board board = new Board("X", "O");
		Human human = new Human(true);

		Controller controller = new HumanController(board, human);

		assertTrue(controller.requiresInput());
		assertEquals(
			"Pick one of the available spots 1, 2, 3, 4, 5, 6, 7, 8, 9:\n",
			controller.prompt());
	}

	@Test
	public void validPick()
	{
		Board board = new Board("X", "O");
		Computer computer = new Computer(false);
		PlayerController opponentController = new ComputerController(board, computer);
		Human human = new Human(true);

		PlayerController controller = new HumanController(board, human);
		controller.setOpponentController(opponentController);

		Result result = controller.handleInput("4");

		String expectedOutput =
			"Player 1 picks spot: 4\n" +
			" 1 | 2 | 3\n" +
			"===+===+===\n" +
			" X | 5 | 6\n" +
			"===+===+===\n" +
			" 7 | 8 | 9\n";

		assertEquals(expectedOutput, result.getOutput());
		assertFalse(result.gameIsOver());
		assertEquals(opponentController, result.getNextController());
	}

	@Test
	public void secondPlayerPick()
	{
		Board board = new Board("X", "O");
		Human human = new Human(false);

		PlayerController controller = new HumanController(board, human);

		Result result = controller.handleInput("4");

		String expectedOutput =
			"Player 2 picks spot: 4\n" +
			" 1 | 2 | 3\n" +
			"===+===+===\n" +
			" O | 5 | 6\n" +
			"===+===+===\n" +
			" 7 | 8 | 9\n";

		assertEquals(expectedOutput, result.getOutput());
		assertFalse(result.gameIsOver());
	}

	@Test
	public void invalidPick()
	{
		Board board = new Board("X", "O");
		Computer computer = new Computer(true);
		PlayerController opponentController = new ComputerController(board, computer);
		Human human = new Human(true);

		PlayerController controller = new HumanController(board, human);
		controller.setOpponentController(opponentController);

		Result result = controller.handleInput("10");

		assertEquals("", result.getOutput());
		assertFalse(result.gameIsOver());
		assertEquals(controller, result.getNextController());
	}

	@Test
	public void gameOver()
	{
		Board board = new Board("X", "O");
		board.set(1, true);
		board.set(2, true);

		Computer computer = new Computer(false);
		PlayerController opponentController = new ComputerController(board, computer);
		Human human = new Human(true);

		PlayerController controller = new HumanController(board, human);
		controller.setOpponentController(opponentController);

		Result result = controller.handleInput("3");

		String expectedOutput =
			"Player 1 picks spot: 3\n" +
			" X | X | X\n" +
			"===+===+===\n" +
			" 4 | 5 | 6\n" +
			"===+===+===\n" +
			" 7 | 8 | 9\n\n" +
			"Player 1 wins!";

		assertEquals(expectedOutput, result.getOutput());
		assertTrue(result.gameIsOver());
	}
}
