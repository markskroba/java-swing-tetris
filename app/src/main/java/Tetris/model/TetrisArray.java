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
