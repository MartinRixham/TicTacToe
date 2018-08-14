package tictactoe;

import java.util.List;

public interface Board
{
	boolean gameIsOver();

	boolean isTied();

	void set(int spot, String symbol);

	List<Integer> getAvailableSpots();

	boolean isAvailable(int spot);
}
