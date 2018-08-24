package tictactoe.controller;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SymbolSelectionTest
{
	@Test
	public void promptToSelectSymbol()
	{
		Controller controller = new SymbolSelection();

		assertEquals("select symbol:", controller.prompt());
	}

	@Test
	public void symbolLengthOneIsValid()
	{
		Controller controller = new SymbolSelection();

		Result result = controller.handleInput("X");

		assertEquals("", result.getOutput());
		assertFalse(result.gameIsOver());
		assertTrue(result.getNextController() instanceof PlayerSelection);
	}

	@Test
	public void symbolLengthTwoIsNotValid()
	{
		Controller controller = new SymbolSelection();

		Result result = controller.handleInput("XX");

		assertEquals("", result.getOutput());
		assertFalse(result.gameIsOver());
		assertTrue(result.getNextController() instanceof SymbolSelection);
	}
}
