package tictactoe;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest
{
	@Test
	public void printStartingBoard()
	{
		Game game = new Game();

		String expectedBoard =
			" 0 | 1 | 2\n" +
			"===+===+===\n" +
			" 3 | 4 | 5\n" +
			"===+===+===\n" +
			" 6 | 7 | 8\n";

		assertEquals(expectedBoard, game.printBoard());
	}
}
