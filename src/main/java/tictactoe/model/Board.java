package tictactoe.model;

import java.util.ArrayList;
import java.util.List;

public class Board
{
	private String[] board = {"0", "1", "2", "3", "4", "5", "6", "7", "8"};

	private int[][] winningLines =
		new int[][]
			{
				new int[] {0, 1, 2},
				new int[] {3, 4, 5},
				new int[] {6, 7, 8},
				new int[] {0, 3, 6},
				new int[] {1, 4, 7},
				new int[] {2, 5, 8},
				new int[] {0, 4, 8},
				new int[] {2, 4, 6},
			};

	private String firstSymbol;

	private String secondSymbol;

	public Board(String firstSymbol, String secondSymbol)
	{
		this.firstSymbol = firstSymbol;
		this.secondSymbol = secondSymbol;
	}

	public boolean gameIsOver()
	{
		return isTied() || getWinner() > 0;
	}

	private int getWinner()
	{
		for (int[] line: winningLines)
		{
			if (board[line[0]].equals(board[line[1]]) &&
				board[line[1]].equals(board[line[2]]))
			{
				return board[line[0]].equals(firstSymbol) ? 1 : 2;
			}
		}

		return 0;
	}

	private boolean isTied()
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

	public void set(int spot, boolean firstPlayer)
	{
		board[spot] = firstPlayer ? firstSymbol : secondSymbol;
	}

	public void reset(int spot)
	{
		board[spot] = Integer.toString(spot);
	}

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
		String output =
			" " + board[0] + " | " + board[1] + " | " + board[2] +
			"\n===+===+===\n" + " " + board[3] + " | " + board[4] + " | " + board[5] +
			"\n===+===+===\n" + " " + board[6] + " | " + board[7] + " | " + board[8] +
			"\n";

		if (isTied())
		{
			output += "\nIt's a tie!";
		}

		int winner = getWinner();

		if (winner > 0)
		{
			output += "\nPlayer " + winner + " wins!";
		}

		return output;
	}
}
