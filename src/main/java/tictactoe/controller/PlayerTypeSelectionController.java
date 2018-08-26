package tictactoe.controller;

import tictactoe.model.PlayerSelection;

public class PlayerTypeSelectionController implements Controller
{
	private PlayerSelection playerSelection;

	public PlayerTypeSelectionController(PlayerSelection playerSelection)
	{
		this.playerSelection = playerSelection;
	}

	@Override
	public String prompt()
	{
		int number = playerSelection.getFirstPlayer() == null ? 1 : 2;

		return "Player " + number + "\n1) human\n2) computer\nselect player: ";
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
