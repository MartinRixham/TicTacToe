package tictactoe.controller;

import tictactoe.model.PlayerSelection;

public class PlayerTypeSelectionController implements Controller
{
	private PlayerSelection playerSelection;

	private String playerNumber;

	public PlayerTypeSelectionController(
		PlayerSelection playerSelection,
		String playerNumber)
	{
		this.playerSelection = playerSelection;
		this.playerNumber = playerNumber;
	}

	@Override
	public String prompt()
	{
		return "Player " + playerNumber + "\n1) human\n2) computer\nselect player: ";
	}

	@Override
	public Result handleInput(String input)
	{
		Controller nextController;

		if (playerSelection.selectPlayerType(input))
		{
			nextController = new SymbolSelectionController(playerSelection);
		}
		else
		{
			nextController = this;
		}

		return new Result("", nextController, false);
	}

	@Override
	public boolean requiresInput()
	{
		return true;
	}
}
