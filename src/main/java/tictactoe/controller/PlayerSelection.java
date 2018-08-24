package tictactoe.controller;

public class PlayerSelection implements Controller
{
	@Override
	public String prompt()
	{
		return "Player 1\n1) human\n2) computer\nselect player:";
	}

	@Override
	public Result handleInput(String input)
	{
		Controller nextController;

		if (input.equals("1") || input.equals("2"))
		{
			nextController = new SymbolSelection(input);
		}
		else
		{
			nextController = this;
		}

		return new Result("", nextController, false);
	}
}
