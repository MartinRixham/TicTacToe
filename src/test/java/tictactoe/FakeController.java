package tictactoe;

import tictactoe.controller.Controller;
import tictactoe.controller.Result;

public final class FakeController implements Controller
{
	private String prompt;

	private Result result;

	private FakeController(String prompt, Result result)
	{
		this.prompt = prompt;
		this.result = result;
	}

	public static FakeController gameOver()
	{
		String prompt = "Write some input:";
		Result result = new Result("Game over!", null, true);

		return new FakeController(prompt, result);
	}

	public static FakeController validInput()
	{
		String prompt = "Write some input:";
		Result result = new Result("Input was valid.", FakeController.gameOver(), false);

		return new FakeController(prompt, result);
	}

	@Override
	public String prompt()
	{
		return prompt;
	}

	@Override
	public Result handleInput(String input)
	{
		return result;
	}

	@Override
	public boolean requiresInput()
	{
		return true;
	}
}
