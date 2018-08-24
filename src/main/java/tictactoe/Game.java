package tictactoe;

import tictactoe.controller.Controller;
import tictactoe.controller.PlayerSelectionController;
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
		Controller initialController = new PlayerSelectionController(playerSelection);
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
			out.println(controller.prompt());

			String line = in.nextLine();
			Result result = controller.handleInput(line);

			out.println(result.getOutput());

			if (result.gameIsOver())
			{
				return;
			}

			controller = result.getNextController();

			/*int spot = firstPlayer.getNextMove(board);
			board.set(spot, firstPlayer.getSymbol());

			out.println("Player 1 picks spot: " + spot);
			out.println(board);

			if (board.gameIsOver())
			{
				out.println("Player 1 wins!");
				return;
			}

			if (board.isTied())
			{
				out.println("It's a tie!");
				return;
			}

			spot = secondPlayer.getNextMove(board);
			board.set(spot, secondPlayer.getSymbol());

			out.println("Player 2 picks spot: " + spot);
			out.println(board);

			if (board.gameIsOver())
			{
				out.println("Player 2 wins!");
				return;
			}

			if (board.isTied())
			{
				out.println("It's a tie!");
				return;
			}*/
		}
	}
}
