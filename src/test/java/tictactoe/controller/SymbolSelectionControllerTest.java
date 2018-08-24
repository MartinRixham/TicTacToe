package tictactoe.controller;

import org.junit.Test;
import tictactoe.model.PlayerSelection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SymbolSelectionControllerTest
{
	@Test
	public void promptToSelectSymbol()
	{
		PlayerSelection playerSelection = new PlayerSelection();
		Controller controller = new SymbolSelectionController(playerSelection);

		assertEquals("select symbol:", controller.prompt());
	}

	@Test
	public void validInput()
	{
		PlayerSelection playerSelection = new PlayerSelection();
		Controller controller = new SymbolSelectionController(playerSelection);

		Result result = controller.handleInput("X");

		assertEquals("", result.getOutput());
		assertFalse(result.gameIsOver());
		assertTrue(result.getNextController() instanceof PlayerTypeSelectionController);
	}

	@Test
	public void invalidInput()
	{
		PlayerSelection playerSelection = new PlayerSelection();
		Controller controller = new SymbolSelectionController(playerSelection);

		Result result = controller.handleInput("XX");

		assertEquals("", result.getOutput());
		assertFalse(result.gameIsOver());
		assertEquals(controller, result.getNextController());
	}

	@Test
	public void humanStartsAfterSecondSelection()
	{
		PlayerSelection playerSelection = new PlayerSelection();
		playerSelection.selectPlayerType("1");
		playerSelection.selectPlayerSymbol("X");
		playerSelection.selectPlayerType("2");

		Controller controller = new SymbolSelectionController(playerSelection);

		Result result = controller.handleInput("O");

		assertEquals("", result.getOutput());
		assertFalse(result.gameIsOver());
		assertTrue(result.getNextController() instanceof HumanController);
	}

	@Test
	public void computerStartsAfterSecondSelection()
	{
		PlayerSelection playerSelection = new PlayerSelection();
		playerSelection.selectPlayerType("2");
		playerSelection.selectPlayerSymbol("X");
		playerSelection.selectPlayerType("1");

		Controller controller = new SymbolSelectionController(playerSelection);

		Result result = controller.handleInput("O");

		assertEquals("", result.getOutput());
		assertFalse(result.gameIsOver());
		assertTrue(result.getNextController() instanceof ComputerController);
	}
}
