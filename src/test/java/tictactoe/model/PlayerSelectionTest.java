package tictactoe.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PlayerSelectionTest
{
	@Test
	public void selectPlayerTypeOne()
	{
		PlayerSelection playerSelection = new PlayerSelection();

		boolean success = playerSelection.selectPlayerType("1");

		assertTrue(success);
	}

	@Test
	public void selectPlayerTypeTwo()
	{
		PlayerSelection playerSelection = new PlayerSelection();

		boolean success = playerSelection.selectPlayerType("2");

		assertTrue(success);
	}

	@Test
	public void selectPlayerTypeWithWrongNumber()
	{
		PlayerSelection playerSelection = new PlayerSelection();

		boolean success = playerSelection.selectPlayerType("3");

		assertFalse(success);
	}

	@Test
	public void selectPlayerTypeWithNonNumber()
	{
		PlayerSelection playerSelection = new PlayerSelection();

		boolean success = playerSelection.selectPlayerType("wibble");

		assertFalse(success);
	}

	@Test
	public void selectSymbolLengthOne()
	{
		PlayerSelection playerSelection = new PlayerSelection();

		boolean success = playerSelection.selectPlayerSymbol("X");

		assertTrue(success);
	}

	@Test
	public void selectSymbolLengthTwo()
	{
		PlayerSelection playerSelection = new PlayerSelection();

		boolean success = playerSelection.selectPlayerSymbol("XX");

		assertFalse(success);
	}

	@Test
	public void getFirstPlayerHuman()
	{
		PlayerSelection playerSelection = new PlayerSelection();
		playerSelection.selectPlayerType("1");
		playerSelection.selectPlayerSymbol("X");

		Player player = playerSelection.getFirstPlayer();

		assertTrue(player instanceof Human);
		assertFalse(playerSelection.hasPlayers());
		assertEquals("X", playerSelection.getFirstSymbol());
	}

	@Test
	public void getFirstPlayerComputer()
	{
		PlayerSelection playerSelection = new PlayerSelection();
		playerSelection.selectPlayerType("2");
		playerSelection.selectPlayerSymbol("O");

		Player player = playerSelection.getFirstPlayer();

		assertTrue(player instanceof Computer);
		assertFalse(playerSelection.hasPlayers());
		assertEquals("O", playerSelection.getFirstSymbol());
	}

	@Test
	public void getBothPlayers()
	{
		PlayerSelection playerSelection = new PlayerSelection();
		playerSelection.selectPlayerType("2");
		playerSelection.selectPlayerSymbol("X");
		playerSelection.selectPlayerType("2");
		playerSelection.selectPlayerSymbol("O");

		Player firstPlayer = playerSelection.getFirstPlayer();
		Player secondPlayer = playerSelection.getSecondPlayer();

		assertTrue(firstPlayer instanceof Computer);
		assertTrue(secondPlayer instanceof Computer);

		assertEquals("X", playerSelection.getFirstSymbol());
		assertEquals("O", playerSelection.getSecondSymbol());
	}
}
