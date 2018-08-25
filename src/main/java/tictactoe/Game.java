package tictactoe;

import tictactoe.controller.Controller;
import tictactoe.controller.PlayerTypeSelectionController;
import tictactoe.controller.Result;
import tictactoe.model.PlayerSelection;

import java.io.PrintStream;
import java.util.Scanner;

public final class Game
{
	private PrintStream out;

	private Scanner in;

	private Controller controller;

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		PrintStream out = System.out;
		PlayerSelection playerSelection = new PlayerSelection();
		Controller initialController = new PlayerTypeSelectionController(playerSelection);
		Game game = new Game(in, out, initialController);

		game.play();
	}

	public Game(Scanner in, PrintStream out, Controller initialController)
	{
		this.in = in;
		this.out = out;
		this.controller = initialController;
	}

	public void play()
	{
		while (true)
		{
			out.print(controller.prompt());
			String input = "";

			if (controller.requiresInput())
			{
				input = in.nextLine();
			}

			Result result = controller.handleInput(input);

			out.println(result.getOutput());

			if (result.gameIsOver())
			{
				return;
			}

			controller = result.getNextController();
		}
	}
}
