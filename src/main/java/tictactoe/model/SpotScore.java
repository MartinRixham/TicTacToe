package tictactoe.model;

public class SpotScore
{
	private int spot;

	private int score;

	private int depth;

	public SpotScore(int spot, int score, int depth)
	{
		this.spot = spot;
		this.score = score;
		this.depth = depth;
	}

	public boolean isGreaterThan(SpotScore other)
	{
		if (score > other.score)
		{
			return true;
		}
		else if (score < other.score)
		{
			return false;
		}
		else
		{
			return depth < other.depth;
		}
	}

	public SpotScore invert(int spot)
	{
		return new SpotScore(spot, -score, depth + 1);
	}

	public int getSpot()
	{
		return spot;
	}
}
