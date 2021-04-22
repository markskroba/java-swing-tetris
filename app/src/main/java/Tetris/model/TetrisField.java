package model;

import java.util.ArrayList;

public class TetrisField extends TetrisArray
{
	protected boolean continueMoving;
	protected boolean endGame;
	
	public TetrisField()
	{
		super();
		endGame = false;
	}

	public TetrisArray add(TetrisShape shape)
	{
		TetrisArray currentState = new TetrisArray();
		continueMoving = true;

		//Adding Block at the top
		// checks for the center block at row 2 (since all the shapes have a block at the center of row 2)
		// for the straight shape, also have a chance of overlapping at the center of row 4
		int center = this.numCols/2;

		if (this.getBlock(1, center).getColor() != null || (this.getBlock(1, center).getColor() != null && this.getBlock(3, center).getColor() !=null))
		{
			continueMoving = false;
			endGame = true;
			return null;
		}
		
		//Combining the TetrisField and TetrisShape starting from the bottom
		for(int i=numRows-1; i==0; i--)
		{
			for(int j=0; j<numCols; j++)
			{
				if(this.getBlock(i,j).getColor() != null && shape.getBlock(i,j).getColor() != null)
				{
					continueMoving = false;
					return null;
				}
				else
				{
					if(this.getBlock(i,j) != null)
					{
						currentState.adjust(i, j, this.getBlock(i,j));
					}
					else if(shape.getBlock(i,j) != null)
					{
						currentState.adjust(i, j, shape.getBlock(i,j));
					}
				}
			}
		}
		
		return currentState;
	}

	public boolean endGame()
	{
		return endGame;
	}

	public boolean continueMoving()
	{
		return continueMoving;
	}

	/*
	 *Creates an arraylist containing the row number of each full row
	 */
	public ArrayList<Integer> locateFullRow()
	{

		ArrayList<Integer> rowsFilled = new ArrayList<Integer>();
		boolean addRow = true;

		for(int i=0; i<numRows; i++)
		{
			addRow = true;

			for(int j=0; j<numCols; j++)
			{
				if(this.blockArray.get(i).get(j).getColor() == null)
				{
					addRow = false;
				}
			}

			if(addRow == true)
			{
				rowsFilled.add(i);
			}
		}
		return rowsFilled;
	}

	/*
	 *Step through the list of full rows, call that row, and set each block in it to null
	 */
	public void clearRows()
	{
		ArrayList<Integer> fullRows = locateFullRow();
		for(int row: fullRows)
		{
			for(int i=0; i < numCols; i++)
			{
				this.blockArray.get(row).get(i).setColor(null);
			}
		}
		
		//iterate through the array starting from the the row above the lowest cleared row to move each block down
		int numRowsCleared = fullRows.size();
		int start = fullRows.get(numRowsCleared-1);
		Block currentBlock;
		
		while(numRowsCleared != 0)
		{
			for(int i=start; i==0; i--)
			{
				for(int j=0; j < numCols; j++)
				{
					if(this.blockArray.get(i).get(j).getColor() != null && this.blockArray.get(i+1).get(j).getColor() == null)
					{
						currentBlock = this.blockArray.get(i).get(j);
						this.blockArray.get(i+1).set(j, currentBlock);
					}

				}
			}
			numRowsCleared--;
		}
	}
}
