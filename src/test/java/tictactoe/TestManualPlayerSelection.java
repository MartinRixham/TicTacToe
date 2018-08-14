package tictactoe;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class TestManualPlayerSelection
{
	@Test
	public void humanCrossesPlaysComputerNoughts()
	{
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(stream);
		Scanner in = new Scanner(new ByteArrayInputStream("1\nX\n2\nO\n".getBytes()));

		PlayerSelection playerSelection = new ManualPlayerSelection(in, out);

		Player firstPlayer = playerSelection.getFirstPlayer();
		Player secondPlayer = playerSelection.getSecondPlayer();

		assertTrue(firstPlayer instanceof Human);
		assertEquals("X", firstPlayer.getSymbol());
		assertTrue(secondPlayer instanceof Computer);
		assertEquals("O", secondPlayer.getSymbol());
		assertEquals(
			"Player 1\n1) human\n2) computer\nselect player:\nselect symbol:\n" +
			"Player 2\n1) human\n2) computer\nselect player:\nselect symbol:\n",
			stream.toString());
	}

	@Test
	public void computerAtSignPlaysHumanHashSign()
	{
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(stream);
		Scanner in = new Scanner(new ByteArrayInputStream("2\n@\n1\n#\n".getBytes()));

		PlayerSelection playerSelection = new ManualPlayerSelection(in, out);

		Player firstPlayer = playerSelection.getFirstPlayer();
		Player secondPlayer = playerSelection.getSecondPlayer();

		assertTrue(firstPlayer instanceof Computer);
		assertEquals("@", firstPlayer.getSymbol());
		assertTrue(secondPlayer instanceof Human);
		assertEquals("#", secondPlayer.getSymbol());
	}
}
