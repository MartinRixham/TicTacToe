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
		return "select symbol: ";
	}

	@Override
	public Result handleInput(String input)
	{
		if (playerSelection.selectPlayerSymbol(input))
		{
			if (playerSelection.hasPlayers())
			{
				String firstSymbol = playerSelection.getFirstSymbol();
				String secondSymbol = playerSelection.getSecondSymbol();
				Board board = new Board(firstSymbol, secondSymbol);

				Controller controller =
					getPlayerController(playerSelection, board);

				 return new Result("\n" + board.toString(), controller, false);
			}
			else
			{
				Controller controller =
					new PlayerTypeSelectionController(playerSelection, "2");

				return new Result("", controller, false);
			}
		}
		else
		{
			return new Result("", this, false);
		}
	}

	@Override
	public boolean requiresInput()
	{
		return true;
	}

	private Controller getPlayerController(PlayerSelection playerSelection, Board board)
	{
		Player firstPlayer = playerSelection.getFirstPlayer();
		Player secondPlayer = playerSelection.getSecondPlayer();
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
