package tictactoe.model;

import java.util.ArrayList;
import java.util.List;

public class Board
{
	private int[] board = new int[9];

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

	public int getWinner()
	{
		for (int[] line: winningLines)
		{
			if (board[line[0]] > 0 &&
				board[line[0]] == board[line[1]] &&
				board[line[1]] == board[line[2]])
			{
				return board[line[0]];
			}
		}

		return 0;
	}

	public boolean isTied()
	{
		for (int i = 1; i <= board.length; i++)
		{
			if (isAvailable(i))
			{
				return false;
			}
		}

		return getWinner() == 0;
	}

	public void set(int spot, boolean firstPlayer)
	{
		board[spot - 1] = firstPlayer ? 1 : 2;
	}

	public void reset(int spot)
	{
		board[spot - 1] = 0;
	}

	public List<Integer> getAvailableSpots()
	{
		List<Integer> availableSpots = new ArrayList<>();

		for (int i = 1; i <= board.length; i++)
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
		return spot > 0 && spot <= board.length && board[spot - 1] == 0;
	}

	@Override
	public String toString()
	{
		String output =
			" " + getSymbol(1) + " | " + getSymbol(2) + " | " + getSymbol(3) +
			"\n===+===+===\n" +
			" " + getSymbol(4) + " | " + getSymbol(5) + " | " + getSymbol(6) +
			"\n===+===+===\n" +
			" " + getSymbol(7) + " | " + getSymbol(8) + " | " + getSymbol(9) +
			"\n";

		int winner = getWinner();

		if (winner > 0)
		{
			output += "\nPlayer " + winner + " wins!";
		}
		else if (isTied())
		{
			output += "\nIt's a tie!";
		}

		return output;
	}

	private String getSymbol(int spot)
	{
		if (board[spot - 1] == 1)
		{
			return firstSymbol;
		}
		else if (board[spot - 1] == 2)
		{
			return secondSymbol;
		}
		else
		{
			return "" + spot;
		}
	}
}
