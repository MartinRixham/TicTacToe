package tictactoe.controller;

import tictactoe.model.PlayerSelection;

public class PlayerSelectionController implements Controller
{
	private PlayerSelection playerSelection;

	public PlayerSelectionController(PlayerSelection playerSelection)
	{
		this.playerSelection = playerSelection;
	}

	@Override
	public String prompt()
	{
		return "Player 1\n1) human\n2) computer\nselect player:";
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
}
