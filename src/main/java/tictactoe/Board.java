package tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Board
{
	private String[] board = {"0", "1", "2", "3", "4", "5", "6", "7", "8"};

	public boolean gameIsOver()
	{
		return board[0].equals(board[1]) && board[1].equals(board[2]) ||
			board[3].equals(board[4]) && board[4].equals(board[5]) ||
			board[6].equals(board[7]) && board[7].equals(board[8]) ||
			board[0].equals(board[3]) && board[3].equals(board[6]) ||
			board[1].equals(board[4]) && board[4].equals(board[7]) ||
			board[2].equals(board[5]) && board[5].equals(board[8]) ||
			board[0].equals(board[4]) && board[4].equals(board[8]) ||
			board[2].equals(board[4]) && board[4].equals(board[6]);
	}

	public boolean isTied()
	{
		for (int i = 0; i < board.length; i++)
		{
			if (isAvailable(i))
			{
				return false;
			}
		}

		return true;
	}

	public void set(int spot, String symbol)
	{
		board[spot] = symbol;
	}

	public List<Integer> getAvailableSpaces()
	{
		List<Integer> availableSpaces = new ArrayList<>();

		for (int i = 0; i < board.length; i++)
		{
			if (isAvailable(i))
			{
				availableSpaces.add(i);
			}
		}

		return availableSpaces;
	}

	public boolean isAvailable(int spot)
	{
		return board[spot].equals(Integer.toString(spot));
	}

	@Override
	public String toString()
	{
		return " " + board[0] + " | " + board[1] + " | " + board[2] +
			"\n===+===+===\n" + " " + board[3] + " | " + board[4] + " | " + board[5] +
			"\n===+===+===\n" + " " + board[6] + " | " + board[7] + " | " + board[8] +
			"\n";
	}
}
