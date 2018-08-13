package tictactoe;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Computer implements Player
{
	public int getNextMove(String[] board)
	{
		while (true)
		{
			if (board[4] == "4")
			{
				return 4;
			}
			else
			{
				int spot = getBestMove(board);
				if (board[spot] != "X" && board[spot] != "O")
				{
					return spot;
				}
			}
		}
	}

	/**
	 * Return true if the game was just won
	 */
	public boolean gameIsOver(String[] board)
	{
		return board[0] == board[1] && board[1] == board[2] ||
			board[3] == board[4] && board[4] == board[5] ||
			board[6] == board[7] && board[7] == board[8] ||
			board[0] == board[3] && board[3] == board[6] ||
			board[1] == board[4] && board[4] == board[7] ||
			board[2] == board[5] && board[5] == board[8] ||
			board[0] == board[4] && board[4] == board[8] ||
			board[2] == board[4] && board[4] == board[6];
	}

	public int getBestMove(String[] board)
	{
		ArrayList<String> availableSpaces = new ArrayList<String>();
		boolean foundBestMove = false;
		int spot = 100;
		for (String s : board)
		{
			if (s != "X" && s != "O")
			{
				availableSpaces.add(s);
			}
		}
		for (String as : availableSpaces)
		{
			spot = Integer.parseInt(as);
			board[spot] = "O";
			if (gameIsOver(board))
			{
				foundBestMove = true;
				board[spot] = as;
				return spot;
			}
			else
			{
				board[spot] = "X";
				if (gameIsOver(board))
				{
					foundBestMove = true;
					board[spot] = as;
					return spot;
				}
				else
				{
					board[spot] = as;
				}
			}
		}
		if (foundBestMove)
		{
			return spot;
		}
		else
		{
			int n = ThreadLocalRandom.current().nextInt(0, availableSpaces.size());
			return Integer.parseInt(availableSpaces.get(n));
		}
	}
}
