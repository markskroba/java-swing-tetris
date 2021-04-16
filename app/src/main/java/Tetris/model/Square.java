package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

public class Square extends TetrisShape
{
     private ArrayList<ArrayList<Block>> shapeArray;
     private Color color;

     public Square(Color color)
     {
	 super(color);
	 this.color = color;
	 shapeArray = new ArrayList<ArrayList<Block>();

	 //create an empty array for the new shape
	 for(int i=0; i<numRows; i++)
	 {
	    shapeArray.add(new ArrayList<Block>());

	    for(int j=0; j<numCols; j++)
	    {
		shapeArray.get(i).add(j, null);
	    }
	 }

	 //add the shape to the center top of the shapeArray
	 int center = numCols/2;

	 shapeArray.get(center).add(0, new Block(color));
	 shapeArray.get(center+1).add(0, new Block(color));
	 shapeArry.get(center).add(1, new Block(color));
	 shapeArray.get(center+1).add(1, new Block(color));
	 
     }

     public void moveHorizontally()
     {
	System.out.println("Figure how to move horizontally later");
     }

     public void moveVertically()
     {
	System.out.println("Figure how to move vertically later");
     }

     public void rotateShape()
     {
	//Does not have an effect on a square
     }
}


