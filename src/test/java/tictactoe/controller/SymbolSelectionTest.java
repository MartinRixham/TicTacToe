package tictactoe.controller;

import org.junit.Test;
import tictactoe.Computer;
import tictactoe.Human;
import tictactoe.Player;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SymbolSelectionTest
{
	@Test
	public void promptToSelectSymbol()
	{
		Controller controller = new SymbolSelection("1");

		assertEquals("select symbol:", controller.prompt());
	}

	@Test
	public void symbolLengthOneIsValid()
	{
		Controller controller = new SymbolSelection("1");

		Result result = controller.handleInput("X");

		assertEquals("", result.getOutput());
		assertFalse(result.gameIsOver());
		assertTrue(result.getNextController() instanceof PlayerSelection);
	}

	@Test
	public void symbolLengthTwoIsNotValid()
	{
		Controller controller = new SymbolSelection("1");

		Result result = controller.handleInput("XX");

		assertEquals("", result.getOutput());
		assertFalse(result.gameIsOver());
		assertEquals(controller, result.getNextController());
	}

	@Test
	public void ComputerStartsAfterSecondSelection()
	{
		Player player = new Computer("X", "O");
		Controller controller = new SymbolSelection(player, "2");

		Result result = controller.handleInput("O");

		assertEquals("", result.getOutput());
		assertFalse(result.gameIsOver());
		assertTrue(result.getNextController() instanceof ComputerController);
	}

	@Test
	public void HumanStartsAfterSecondSelection()
	{
		Player player = new Human("X");
		Controller controller = new SymbolSelection(player, "2");

		Result result = controller.handleInput("O");

		assertEquals("", result.getOutput());
		assertFalse(result.gameIsOver());
		assertTrue(result.getNextController() instanceof HumanController);
	}
}
