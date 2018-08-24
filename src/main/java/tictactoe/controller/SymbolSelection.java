package tictactoe.controller;

import tictactoe.Computer;
import tictactoe.Human;
import tictactoe.Player;

public class SymbolSelection implements Controller
{
	private String firstPlayerNumber;

	private Player firstPlayer;

	private String secondPlayerNumber;

	public SymbolSelection(String firstPlayerNumber)
	{
		this.firstPlayerNumber = firstPlayerNumber;
	}

	public SymbolSelection(Player firstPlayer, String secondPlayerNumber)
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
		Controller nextController;

		if (input.length() != 1)
		{
			nextController = this;
		}
		else if (firstPlayer instanceof Human)
		{
			nextController = new HumanController();
		}
		else if (firstPlayer instanceof Computer)
		{
			nextController = new ComputerController();
		}
		else
		{
			nextController = new PlayerSelection();
		}

		return new Result("", nextController, false);
	}
}
