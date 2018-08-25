package tictactoe.controller;

import org.junit.Test;
import tictactoe.model.PlayerSelection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PlayerTypeSelectionControllerTest
{
	@Test
	public void promptToSelectPlayer()
	{
		PlayerSelection playerSelection = new PlayerSelection();
		Controller controller = new PlayerTypeSelectionController(playerSelection);

		assertTrue(controller.requiresInput());
		assertEquals(
			"Player 1\n1) human\n2) computer\nselect player:",
			controller.prompt());
	}

	@Test
	public void promptToSelectSecondPlayer()
	{
		PlayerSelection playerSelection = new PlayerSelection();
		playerSelection.selectPlayerType("1");
		playerSelection.selectPlayerSymbol("X");

		Controller controller = new PlayerTypeSelectionController(playerSelection);

		assertTrue(controller.requiresInput());
		assertEquals(
			"Player 2\n1) human\n2) computer\nselect player:",
			controller.prompt());
	}

	@Test
	public void validInput()
	{
		PlayerSelection playerSelection = new PlayerSelection();
		Controller controller = new PlayerTypeSelectionController(playerSelection);

		Result result = controller.handleInput("1");

		assertEquals("", result.getOutput());
		assertFalse(result.gameIsOver());
		assertTrue(result.getNextController() instanceof SymbolSelectionController);
	}

	@Test
	public void invalidInput()
	{
		PlayerSelection playerSelection = new PlayerSelection();
		Controller controller = new PlayerTypeSelectionController(playerSelection);

		Result result = controller.handleInput("wibble");

		assertEquals("", result.getOutput());
		assertFalse(result.gameIsOver());
		assertEquals(controller, result.getNextController());
	}
}
