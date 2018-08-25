package tictactoe.controller;

import tictactoe.model.Player;
import tictactoe.model.Board;
import tictactoe.model.Computer;
import tictactoe.model.Human;
import tictactoe.model.PlayerSelection;

public class SymbolSelectionController implements Controller
{
	private PlayerSelection playerSelection;

	public SymbolSelectionController(PlayerSelection playerSelection)
	{
		this.playerSelection = playerSelection;
	}

	@Override
	public String prompt()
	{
		return "select symbol:";
	}

	@Override
	public Result handleInput(String input)
	{
		Controller nextController;

		if (playerSelection.selectPlayerSymbol(input))
		{
			Player firstPlayer = playerSelection.getFirstPlayer();
			Player secondPlayer = playerSelection.getSecondPlayer();

			if (firstPlayer != null && secondPlayer != null)
			{
				nextController = getPlayerController(firstPlayer, secondPlayer);
			}
			else
			{
				nextController = new PlayerTypeSelectionController(playerSelection);
			}
		}
		else
		{
			nextController = this;
		}

		return new Result("", nextController, false);
	}

	private Controller getPlayerController(Player firstPlayer, Player secondPlayer)
	{
		Board board = new Board();
		PlayerController playerController = getController(board, firstPlayer);
		PlayerController opponentController = getController(board, secondPlayer);

		playerController.setOpponentController(opponentController);
		opponentController.setOpponentController(playerController);

		return playerController;
	}

	private PlayerController getController(Board board, Player player)
	{
		if (player instanceof Human)
		{
			return new HumanController(board, (Human) player);
		}
		else
		{
			return new ComputerController(board, (Computer) player);
		}
	}
}
