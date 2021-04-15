package model;

import java.awt.Color;


public class LShape extends TetrisShape
{
     private int orientation;
     private Color color;

     public LShape(Color color)
     {
	this.color = color;

	//Initialize each element with an arraylist
	blockArray.setUpArray(3);

	//set up initial L shaped block using array
	blockArray.add(0, new Block(color));
	blockArray.add(1, new Block(color));
	blockArray.add(2, new Block(color));
	blockArray.get(2).add(1, new Block(color));

	orientation = 1; 
     }

     public ArrayList<ArrayList<Block>> setUpArray(int row)
     {
	for(int i=0; i<row; i++)
	{
	    blockArray.add(new ArrayList<Block>());
	}
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
	blockArray.clear();

	if(orientation.equals(1))
	{
	     blockArray.setUpArray(2);
	     blockArray.add(0, new Block(color));
	     blockArray.get(0).add(1, new Block(color));
	     blockArray.get(0).add(2, new Block(color));
	     blockArray.add(1, new Block(color));

	     orientation = 2;
	}

	else if(orientation.equals(2))
	{
	     blockArray.setUpArray(3);
	     blockArray.add(0, new Block(color));
	     blockArray.get(0).add(1, new Block(color));
	     blockArray.add(1, null);
	     blockArray.get(1).add(1, new Block(color));
	     blockArray.add(2, null);
	     blockArray.get(2).add(1, new Block(color));

	     orientation = 3;
	}

	else if(orientation.equals(2))
	{
	     blockArray.setUpArray(2);
	     blockArray.add(0, null);
	     blockArray.get(0).add(1, null);
	     blockArray.get(0).add(2, new Block(color));
	     blockArray.add(1, new Block(color));
	     blockArray.get(1),add(1, new Block(color));
	     blockArray.get(1).add(2, new Block(color));

	     orientation = 4;
	}

	else if(orientation.equals(4))
	{
	     blockArray.setUpArray(3);
	     blockArray.add(0, new Block(color));
	     blockArray.add(1, new Block(color));
	     blockArray.add(2, new Block(color));
	     blockArray.get(2).add(1, new Block(color));

	     orientation = 1; 
	}

    }
}


