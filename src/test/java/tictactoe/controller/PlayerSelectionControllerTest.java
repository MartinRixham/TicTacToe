package tictactoe.controller;

import org.junit.Test;
import tictactoe.model.PlayerSelection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PlayerSelectionControllerTest
{
	@Test
	public void promptToSelectPlayer()
	{
		PlayerSelection playerSelection = new PlayerSelection();
		Controller controller = new PlayerSelectionController(playerSelection);

		assertEquals(
			"Player 1\n1) human\n2) computer\nselect player:",
			controller.prompt());
	}

	@Test
	public void oneIsValid()
	{
		PlayerSelection playerSelection = new PlayerSelection();
		Controller controller = new PlayerSelectionController(playerSelection);

		Result result = controller.handleInput("1");

		assertEquals("", result.getOutput());
		assertFalse(result.gameIsOver());
		assertTrue(result.getNextController() instanceof SymbolSelectionController);
	}

	@Test
	public void nonNumberIsNotValid()
	{
		PlayerSelection playerSelection = new PlayerSelection();
		Controller controller = new PlayerSelectionController(playerSelection);

		Result result = controller.handleInput("wibble");

		assertEquals("", result.getOutput());
		assertFalse(result.gameIsOver());
		assertEquals(controller, result.getNextController());
	}
}
