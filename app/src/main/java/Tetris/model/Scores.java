package model;

public class Score
{
    private int currentScore;

    public Score()
    {
	currentScore = 0;
    }

    public int getScore()
    {
	System.out.println("getScore called");
	return 0;
	//return this.currentScore;
    }

    public void calculateScore(int rows)
    {
	System.out.println("calculateScore called");
	/*
	 * //A single row is 10 pts while each additional row is 50% more
	 * // So the second row is 15 pts, a third 20, etc.
	 * // The total score is calculated using a multiplication factor f
	 * float f = 1;   
	 * for (int i=0; i<rows; i++)
	 * {
	 *    this.currentScore += 10*f;
	 *    f += 0.5;
	 * }
	 */
    }
}
