package model;
import java.util.ArrayList;

public class TetrisArray
{
     protected ArrayList<ArrayList<Block>> blockArray;

     public TetrisArray()
     {
	this.blockArray = new ArrayList<ArrayList<Block>>();
     }

     public int getNumRows()
     {
	return blockArray.size();
     }

     public int getNumColumns()
     {
	return blockArray.get(0).size();
     }

     public Block getBlock(int row, int col)
     {
	return this.blockArray.get(row).get(col);
     }
}
