package tictactoe;

import org.junit.Test;
import tictactoe.controller.ComputerController;
import tictactoe.controller.Controller;
import tictactoe.controller.HumanController;
import tictactoe.controller.PlayerController;
import tictactoe.model.Board;
import tictactoe.model.Computer;
import tictactoe.model.Human;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class GameTest
{
	@Test
	public void losingGame()
	{
		PrintStream originalOut = System.out;
		InputStream originalIn = System.in;
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(stream);

		System.setOut(out);

		String input = "1\nX\n2\nO\n1\n2\n3\n1\nX\n2\nO\n1\n2\n3\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		Game.main(null);

		String expectedOutput =
			"Player 1\n1) human\n2) computer\nselect player:\nselect symbol:\n" +
			"Player 2\n1) human\n2) computer\nselect player:\nselect symbol:\n" +
			" 0 | 1 | 2\n" +
			"===+===+===\n" +
			" 3 | 4 | 5\n" +
			"===+===+===\n" +
			" 6 | 7 | 8\n" +
			"\n" +
			"Pick one of the available spots 0, 1, 2, 3, 4, 5, 6, 7, 8:\n" +
			"Player 1 picks spot: 1\n" +
			" 0 | X | 2\n" +
			"===+===+===\n" +
			" 3 | 4 | 5\n" +
			"===+===+===\n" +
			" 6 | 7 | 8\n" +
			"\n" +
			"Player 2 picks spot: 4\n" +
			" 0 | X | 2\n" +
			"===+===+===\n" +
			" 3 | O | 5\n" +
			"===+===+===\n" +
			" 6 | 7 | 8\n" +
			"\n" +
			"Pick one of the available spots 0, 2, 3, 5, 6, 7, 8:\n" +
			"Player 1 picks spot: 2\n" +
			" 0 | X | X\n" +
			"===+===+===\n" +
			" 3 | O | 5\n" +
			"===+===+===\n" +
			" 6 | 7 | 8\n" +
			"\n" +
			"Player 2 picks spot: 0\n" +
			" O | X | X\n" +
			"===+===+===\n" +
			" 3 | O | 5\n" +
			"===+===+===\n" +
			" 6 | 7 | 8\n" +
			"\n" +
			"Pick one of the available spots 3, 5, 6, 7, 8:\n" +
			"Player 1 picks spot: 3\n" +
			" O | X | X\n" +
			"===+===+===\n" +
			" X | O | 5\n" +
			"===+===+===\n" +
			" 6 | 7 | 8\n" +
			"\n" +
			"Player 2 picks spot: 8\n" +
			" O | X | X\n" +
			"===+===+===\n" +
			" X | O | 5\n" +
			"===+===+===\n" +
			" 6 | 7 | O\n" +
			"\n" +
			"Player 2 wins!\n";

		assertEquals(expectedOutput, stream	.toString());

		System.setOut(originalOut);
		System.setIn(originalIn);
	}

	@Test
	public void oneMoveGame()
	{
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(stream);
		Scanner in = new Scanner(new ByteArrayInputStream("2\n3\n4\n".getBytes()));
		Human human = new Human(true);

		Board board = new Board("X", "O");
		board.set(0, true);
		board.set(1, true);

		Controller controller = new HumanController(board, human);

		new Game(in, out, controller).play();

		String expectedOutput =
			"Pick one of the available spots 2, 3, 4, 5, 6, 7, 8:\n" +
			"Player 1 picks spot: 2\n" +
			" X | X | X\n" +
			"===+===+===\n" +
			" 3 | 4 | 5\n" +
			"===+===+===\n" +
			" 6 | 7 | 8\n\n" +
			"Player 1 wins!\n";

		assertEquals(expectedOutput, stream.toString());
	}

	@Test
	public void twoMoveGame()
	{
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(stream);
		Scanner in = new Scanner(new ByteArrayInputStream("2\n3\n4\n".getBytes()));
		Human human = new Human(false);
		Computer computer = new Computer(true);

		Board board = new Board("O", "X");
		board.set(0, false);
		board.set(1, false);

		PlayerController opponentController = new HumanController(board, human);
		PlayerController controller = new ComputerController(board, computer);

		opponentController.setOpponentController(controller);
		controller.setOpponentController(opponentController);

		new Game(in, out, controller).play();

		String expectedOutput =
			"Player 1 picks spot: 4\n" +
			" X | X | 2\n" +
			"===+===+===\n" +
			" 3 | O | 5\n" +
			"===+===+===\n" +
			" 6 | 7 | 8\n" +
			"\n" +
			"Pick one of the available spots 2, 3, 5, 6, 7, 8:\n" +
			"Player 2 picks spot: 2\n" +
			" X | X | X\n" +
			"===+===+===\n" +
			" 3 | O | 5\n" +
			"===+===+===\n" +
			" 6 | 7 | 8\n\n" +
			"Player 2 wins!\n";

		assertEquals(expectedOutput, stream.toString());
	}
}
