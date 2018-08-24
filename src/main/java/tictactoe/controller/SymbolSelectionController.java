package tictactoe.controller;

import tictactoe.Player;
import tictactoe.model.ASCIIBoard;
import tictactoe.model.Board;
import tictactoe.model.Computer;
import tictactoe.model.Human;

public class SymbolSelectionController implements Controller
{
	private String firstPlayerNumber;

	private Player firstPlayer;

	private String secondPlayerNumber;

	public SymbolSelectionController(String firstPlayerNumber)
	{
		this.firstPlayerNumber = firstPlayerNumber;
	}

	public SymbolSelectionController(Player firstPlayer, String secondPlayerNumber)
	{
		this.firstPlayer = firstPlayer;
		this.secondPlayerNumber = secondPlayerNumber;
	}

	@Override
	public String prompt()
	{
		return "select symbol:";
	}

	@Override
	public Result handleInput(String input)
	{
		Board board = new ASCIIBoard();

		Controller nextController;

		if (input.length() != 1)
		{
			nextController = this;
		}
		else if (firstPlayer instanceof Human)
		{
			nextController = new HumanController(board, (Human) firstPlayer);
		}
		else if (firstPlayer instanceof Computer)
		{
			nextController = new ComputerController(board, (Computer) firstPlayer);
		}
		else
		{
			nextController = new PlayerSelectionController();
		}

		return new Result("", nextController, false);
	}
}
