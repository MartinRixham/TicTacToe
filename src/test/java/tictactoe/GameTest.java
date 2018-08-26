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

		String input = "1\nX\n2\nO\n2\n3\n4\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		Game.main(null);

		String expectedOutput =
			"Player 1\n1) human\n2) computer\nselect player: \nselect symbol: \n" +
			"Player 2\n1) human\n2) computer\nselect player: \nselect symbol: \n" +
			" 1 | 2 | 3\n" +
			"===+===+===\n" +
			" 4 | 5 | 6\n" +
			"===+===+===\n" +
			" 7 | 8 | 9\n" +
			"\n" +
			"Pick one of the available spots 1, 2, 3, 4, 5, 6, 7, 8, 9: " +
			"Player 1 picks spot: 2\n" +
			" 1 | X | 3\n" +
			"===+===+===\n" +
			" 4 | 5 | 6\n" +
			"===+===+===\n" +
			" 7 | 8 | 9\n" +
			"\n" +
			"Player 2 picks spot: 5\n" +
			" 1 | X | 3\n" +
			"===+===+===\n" +
			" 4 | O | 6\n" +
			"===+===+===\n" +
			" 7 | 8 | 9\n" +
			"\n" +
			"Pick one of the available spots 1, 3, 4, 6, 7, 8, 9: " +
			"Player 1 picks spot: 3\n" +
			" 1 | X | X\n" +
			"===+===+===\n" +
			" 4 | O | 6\n" +
			"===+===+===\n" +
			" 7 | 8 | 9\n" +
			"\n" +
			"Player 2 picks spot: 1\n" +
			" O | X | X\n" +
			"===+===+===\n" +
			" 4 | O | 6\n" +
			"===+===+===\n" +
			" 7 | 8 | 9\n" +
			"\n" +
			"Pick one of the available spots 4, 6, 7, 8, 9: " +
			"Player 1 picks spot: 4\n" +
			" O | X | X\n" +
			"===+===+===\n" +
			" X | O | 6\n" +
			"===+===+===\n" +
			" 7 | 8 | 9\n" +
			"\n" +
			"Player 2 picks spot: 9\n" +
			" O | X | X\n" +
			"===+===+===\n" +
			" X | O | 6\n" +
			"===+===+===\n" +
			" 7 | 8 | O\n" +
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
		Scanner in = new Scanner(new ByteArrayInputStream("3\n".getBytes()));
		Human human = new Human(true);

		Board board = new Board("X", "O");
		board.set(1, true);
		board.set(2, true);

		Controller controller = new HumanController(board, human);

		new Game(in, out, controller).play();

		String expectedOutput =
			"Pick one of the available spots 3, 4, 5, 6, 7, 8, 9: " +
			"Player 1 picks spot: 3\n" +
			" X | X | X\n" +
			"===+===+===\n" +
			" 4 | 5 | 6\n" +
			"===+===+===\n" +
			" 7 | 8 | 9\n\n" +
			"Player 1 wins!\n";

		assertEquals(expectedOutput, stream.toString());
	}

	@Test
	public void twoMoveGame()
	{
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(stream);
		Scanner in = new Scanner(new ByteArrayInputStream("3\n".getBytes()));
		Human human = new Human(false);
		Computer computer = new Computer(true);

		Board board = new Board("O", "X");
		board.set(1, false);
		board.set(2, false);

		PlayerController opponentController = new HumanController(board, human);
		PlayerController controller = new ComputerController(board, computer);

		opponentController.setOpponentController(controller);
		controller.setOpponentController(opponentController);

		new Game(in, out, controller).play();

		String expectedOutput =
			"Player 1 picks spot: 5\n" +
			" X | X | 3\n" +
			"===+===+===\n" +
			" 4 | O | 6\n" +
			"===+===+===\n" +
			" 7 | 8 | 9\n" +
			"\n" +
			"Pick one of the available spots 3, 4, 6, 7, 8, 9: " +
			"Player 2 picks spot: 3\n" +
			" X | X | X\n" +
			"===+===+===\n" +
			" 4 | O | 6\n" +
			"===+===+===\n" +
			" 7 | 8 | 9\n\n" +
			"Player 2 wins!\n";

		assertEquals(expectedOutput, stream.toString());
	}
}
