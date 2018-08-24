package tictactoe.controller;

import tictactoe.model.Board;
import tictactoe.model.Computer;

public class ComputerController implements Controller
{
	private Board board;

	private Computer computer;

	private Controller opponentController;

	public ComputerController(Board board, Computer computer)
	{
		this.board = board;
		this.computer = computer;
	}

	public void setOpponentController(Controller opponentController)
	{
		this.opponentController = opponentController;
	}

	@Override
	public String prompt()
	{
		return "";
	}

	@Override
	public Result handleInput(String input)
	{
		int spot = computer.selectSpot(board);

		String output =
			"Player 1 picks spot: " + spot + "\n" + board;

		return new Result(output, opponentController, false);
	}
}
