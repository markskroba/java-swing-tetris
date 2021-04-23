package model;

import java.util.ArrayList;
import java.awt.Color;

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
		System.out.println("Adding tetris shape to tetris field");

		//Adding Block at the top
		// checks for the center block at row 0 (since all the shapes have a block at the center of row 0)
		// for the straight shape, also have a chance of overlapping at the center of row 4
		int center = this.numCols/2;

		if (this.getBlock(0, center).getColor() != null || (this.getBlock(1, center).getColor() != null && this.getBlock(3, center).getColor() !=null))
		{
			continueMoving = false;
			endGame = true;
			System.out.println("currentState array is null");
			return null;
		}
		
		//Combining the TetrisField and TetrisShape.
		//If there is overlap, returns null (controller will return the previous state in that case)
		for(int i=0; i<numRows; i++)
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
					if(this.getBlock(i,j).getColor() != null)
					{
						currentState.adjust(i, j, new Block(this.getBlock(i,j).getColor()));
					}
					else if(shape.getBlock(i,j).getColor() != null)
					{
						currentState.adjust(i, j, new Block(shape.getBlock(i,j).getColor()));
						System.out.println("Added shape block");
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
		int start = fullRows.get(numRowsCleared-1)-1;
		Color currentColor;
		
		while(numRowsCleared != 0)
		{
			for(int i=start; i==0; i--)
			{
				for(int j=0; j < numCols; j++)
				{
					if(this.blockArray.get(i).get(j).getColor() != null && this.blockArray.get(i+1).get(j).getColor() == null)
					{
						currentColor = this.blockArray.get(i).get(j).getColor();
						this.blockArray.get(i).get(j).setColor(null);
						this.blockArray.get(i+1).get(j).setColor(currentColor);
					}

				}
			}
			numRowsCleared--;
		}
	}
}
