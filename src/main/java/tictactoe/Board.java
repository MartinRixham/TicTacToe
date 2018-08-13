package tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Board
{
	private String[] board = {"0", "1", "2", "3", "4", "5", "6", "7", "8"};

	/**
	 * Return true if the game was just won
	 */
	public boolean gameIsOver()
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

	/**
	 * Return true if it is a draw (no more empty cell)
	 */
	// TODO: maybe there is an easeir way to check this
	public boolean isTied()
	{
		return board[0] != "0" &&
			board[1] != "1" &&
			board[2] != "2" &&
			board[3] != "3" &&
			board[4] != "4" &&
			board[5] != "5" &&
			board[6] != "6" &&
			board[7] != "7" &&
			board[8] != "8";
	}

	public String get(int spot)
	{
		return board[spot];
	}

	public void set(int spot, String symbol)
	{
		board[spot] = symbol;
	}

	public List<String> getAvailableSpaces()
	{
		List<String> availableSpaces = new ArrayList<>();

		for (String s : board)
		{
			if (s != "X" && s != "O")
			{
				availableSpaces.add(s);
			}
		}

		return availableSpaces;
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
