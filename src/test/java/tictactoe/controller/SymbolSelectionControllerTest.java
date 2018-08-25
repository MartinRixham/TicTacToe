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

		assertTrue(controller.requiresInput());
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

		String expectedOutput =
			"\n 0 | 1 | 2\n" +
			"===+===+===\n" +
			" 3 | 4 | 5\n" +
			"===+===+===\n" +
			" 6 | 7 | 8\n";

		assertEquals(expectedOutput, result.getOutput());
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

		String expectedOutput =
			"\n 0 | 1 | 2\n" +
			"===+===+===\n" +
			" 3 | 4 | 5\n" +
			"===+===+===\n" +
			" 6 | 7 | 8\n";

		assertEquals(expectedOutput, result.getOutput());
		assertFalse(result.gameIsOver());
		assertTrue(result.getNextController() instanceof ComputerController);
	}

	@Test
	public void controllersAlternateTurns()
	{
		PlayerSelection playerSelection = new PlayerSelection();
		playerSelection.selectPlayerType("2");
		playerSelection.selectPlayerSymbol("X");
		playerSelection.selectPlayerType("1");

		Controller controller = new SymbolSelectionController(playerSelection);

		Result result = controller.handleInput("O");

		controller = result.getNextController();

		assertTrue(controller instanceof ComputerController);

		result = controller.handleInput("");
		controller = result.getNextController();

		assertTrue(controller instanceof HumanController);

		result = controller.handleInput("3");
		controller = result.getNextController();

		assertTrue(controller instanceof ComputerController);
	}
}
