package model;

import java.util.ArrayList;

public class TetrisField extends TetrisArray
{
	public TetrisField()
	{
		super();
		System.out.println("Creating an array that shows all of the unmoving blocks");
	}

	public TetrisArray add(TetrisShape shape)
	{
		// use case 7
		// checks for two blocks (5th and 6th), since those are in the middle and we cannot add a new block with even one being placed already
		if (this.getBlock(0, 4) != null || this.getBlock(0, 5) != null)
		{
			System.out.println("Can't add a new block, top row is blocked");
			return null;
		}
		
		System.out.println("Combining the TetrisField and the TetrisShape");
		
		return this;
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
