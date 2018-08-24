package tictactoe.controller;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PlayerSelectionTest
{
	@Test
	public void promptToSelectPlayer()
	{
		Controller controller = new PlayerSelection();

		assertEquals(
			"Player 1\n1) human\n2) computer\nselect player:",
			controller.prompt());
	}

	@Test
	public void oneIsValid()
	{
		Controller controller = new PlayerSelection();

		Result result = controller.handleInput("1");

		assertEquals("", result.getOutput());
		assertFalse(result.gameIsOver());
		assertTrue(result.getNextController() instanceof SymbolSelection);
	}

	@Test
	public void twoIsValid()
	{
		Controller controller = new PlayerSelection();

		Result result = controller.handleInput("2");

		assertEquals("", result.getOutput());
		assertFalse(result.gameIsOver());
		assertTrue(result.getNextController() instanceof SymbolSelection);
	}

	@Test
	public void otherNumberIsNotValid()
	{
		Controller controller = new PlayerSelection();

		Result result = controller.handleInput("3");

		assertEquals("", result.getOutput());
		assertFalse(result.gameIsOver());
		assertTrue(result.getNextController() instanceof PlayerSelection);
	}

	@Test
	public void nonNumberIsNotValid()
	{
		Controller controller = new PlayerSelection();

		Result result = controller.handleInput("wibble");

		assertEquals("", result.getOutput());
		assertFalse(result.gameIsOver());
		assertTrue(result.getNextController() instanceof PlayerSelection);
	}
}
