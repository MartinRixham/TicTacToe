package tictactoe.controller;

public class SymbolSelection implements Controller
{
	@Override
	public String prompt()
	{
		return "select symbol:";
	}

	@Override
	public Result handleInput(String input)
	{
		Controller nextController;

		if (input.length() == 1)
		{
			nextController = new PlayerSelection();
		}
		else
		{
			nextController = this;
		}

		return new Result("", nextController, false);
	}
}
