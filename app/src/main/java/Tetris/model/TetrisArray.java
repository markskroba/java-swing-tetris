package model;
import java.util.ArrayList;

public class TetrisArray
{
     protected ArrayList<ArrayList<Block>> blockArray;
     protected int numRows;
     protected int numCols;

     public TetrisArray()
     {
	this.blockArray = new ArrayList<ArrayList<Block>>();
	numRows = 16;
	numCols=9;
	System.out.println("TetrisArray: Creating an array that shows the current state of the game");
          this.setRowsAndCols(numRows, numCols);
	
     }

     public void setRowsAndCols(int rows, int cols)
     {
	for(int i=0; i<rows; i++)
	{
	   blockArray.add(new ArrayList<Block>());

	   for(int j=0; j<cols; j++)
	   {
	      blockArray.get(i).add(j, null);	
	   }	
	}

	numRows = rows;
	numCols = cols;
     }

     public int getNumRows()
     {
	return numRows;
     }

     public int getNumColumns()
     {
	return numCols;
     }

     public Block getBlock(int row, int col)
     {
	return this.blockArray.get(row).get(col);
     }
}
