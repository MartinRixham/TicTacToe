package tictactoe;

import java.util.ArrayList;
import java.util.List;

public class ASCIIBoard implements Board
{
	private String[] board = {"0", "1", "2", "3", "4", "5", "6", "7", "8"};

	@Override
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

	@Override
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

	@Override
	public void set(int spot, String symbol)
	{
		board[spot] = symbol;
	}

	@Override
	public List<Integer> getAvailableSpots()
	{
		List<Integer> availableSpots = new ArrayList<>();

		for (int i = 0; i < board.length; i++)
		{
			if (isAvailable(i))
			{
				availableSpots.add(i);
			}
		}

		return availableSpots;
	}

	@Override
	public boolean isAvailable(int spot)
	{
		if (spot < 0 || spot >= board.length)
		{
			return false;
		}

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
