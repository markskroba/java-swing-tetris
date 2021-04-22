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

		if (this.getBlock(1, center) != null || (this.getBlock(1, center) != null && this.getBlock(3, center) !=null))
		{
			continueMoving = false;
			endGame = true;
			return null;
		}
		
		//Combining the TetrisField and TetrisShape starting from the bottom
		for(int i=numRows-1; i>=0; i--)
		{
			for(int j=0; j<numCols; j++)
			{
				if(this.getBlock(i,j) != null && shape.getBlock(i,j) != null)
				{
					continueMoving = false;
					return null;
				}
				else
				{
					if(this.getBlock(i,j) != null)
					{
						currentState.get(i).set(j, this.getBlock(i,j));
					}
					else if(shape.getBlock(i,j) != null)
					{
						currentState.get(i).set(j, shape.getBlock(i,j));
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
		return contineMoving;
	}

	public ArrayList<Integer> locateFullRow()
	{
		System.out.println("locateFullRow scans the full array to find all the currently full rows");

		ArrayList<Integer> rowsFilled = new ArrayList<Integer>();
		boolean addRow = true;

		for(int i=0; i<numRows; i++)
		{
			addRow = true;

			for(int j=0; j<numCols; j++)
			{
				if(this.blockArray.get(i).get(j).equals(null))
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

	public void clearRows()
	{
		ArrayList<Integer> fullRows = locateFullRow();
		//step through the list of full rows to find each row
		//then call that row, and step through the colums setting each block to null
		for(int row: fullRows)
		{
			for(int i=0; i < numCols; i++)
			{
				this.blockArray.get(row).set(i, null);
			}
		}
		//iterate through the array starting from the the row above the lowest cleared row to move each block down
		int numRowsCleared = fullRows.size();
		int start = fullRows.get(numRowsCleared-1)-1;
		Block currentBlock;
		
		while(numRowsCleared != 0)
		{
			for(int i=start; i==0; i--)
			{
				for(int j=0; j < numCols; j++)
				{
					if(this.blockArray.get(i).get(j) != null && this.blockArray.get(i+1).get(j) == null)
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
