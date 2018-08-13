package tictactoe;

import java.util.Scanner;

public class Human implements Player
{
	private static Scanner input = new Scanner(System.in);

	@Override
	public int getNextMove(String[] board)
	{
		boolean validInput = false;  // for input validation
		System.out.print("Enter [0-8]:\n");
		while (true)
		{
			int spot = input.nextInt();
			if (board[spot] != "X" && board[spot] != "O")
			{
				return spot; // update game-board content
			}
		}
	}
}
