package tictactoe.controller;

import tictactoe.model.Board;
import tictactoe.model.Human;

public class HumanController implements PlayerController
{
	private Board board;

	private Human human;

	private Controller opponentController;

	public HumanController(Board board, Human human)
	{
		this.board = board;
		this.human = human;
	}

	@Override
	public String prompt()
	{
		String availableSpots = board.getAvailableSpots().toString();
		String spotList = availableSpots.substring(1, availableSpots.length() - 1);

		return "Pick one of the available spots " + spotList + ":";
	}

	@Override
	public Result handleInput(String input)
	{
		boolean success = human.selectSpot(input, board);

		if (success)
		{
			int number = human.isFirstPlayer() ? 1 : 2;

			String output =
				"Player " + number + " picks spot: " + input + "\n" + board;

			return new Result(output, opponentController, board.gameIsOver());
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

	@Override
	public void setOpponentController(PlayerController opponentController)
	{
		this.opponentController = opponentController;
	}
}
