package tictactoe.controller;

public class Result
{
	private String output;

	private Controller nextController;

	private boolean gameIsOver;

	public Result(String output, Controller nextController, boolean gameIsOver)
	{
		this.output = output;
		this.nextController = nextController;
		this.gameIsOver = gameIsOver;
	}

	public String getOutput()
	{
		return output;
	}

	public Controller getNextController()
	{
		return nextController;
	}

	public boolean gameIsOver()
	{
		return gameIsOver;
	}
}
