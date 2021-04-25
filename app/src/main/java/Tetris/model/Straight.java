package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

public class Straight extends TetrisShape
{

	public Straight(Color color)
	{
		super(color);

		//add shape to the center top of shapeArray
		center = numCols/2;

		this.blockArray.get(0).get(center).setColor(this.shapeColor);
		this.blockArray.get(1).get(center).setColor(this.shapeColor);
		this.blockArray.get(2).get(center).setColor(this.shapeColor);
		this.blockArray.get(3).get(center).setColor(this.shapeColor);
		
		block1Position[0] = 0;
		block1Position[1] = center;
		
		block2Position[0] = 1;
		block2Position[1] = center;
		
		block3Position[0] = 2;
		block3Position[1] = center;
		
		block4Position[0] = 3;
		block4Position[1] = center;

	} 
	
	public void moveHorizontally(int direction)
	{
		if(direction < 0)
		{
			this.blockArray.get(0).get(block1Position[1]).setColor(null);
			this.blockArray.get(1).get(block2Position[1]).setColor(null);
			this.blockArray.get(2).get(block3Position[1]).setColor(null);
			this.blockArray.get(3).get(block4Position[1]).setColor(null);
			
			block1Position[1] = block1Position[1] - 1;
			block2Position[1] = block1Position[1] - 1;
			block3Position[1] = block3Position[1] - 1;
			block4Position[1] = block4Position[1] - 1;
			
			this.blockArray.get(0).get(block1Position[1]).setColor(shapeColor);
			this.blockArray.get(1).get(block2Position[1]).setColor(shapeColor);
			this.blockArray.get(2).get(block3Position[1]).setColor(shapeColor);
			this.blockArray.get(3).get(block4Position[1]).setColor(shapeColor);
		}
		else if(direction > 0)
		{
			this.blockArray.get(0).get(block1Position[1]).setColor(null);
			this.blockArray.get(1).get(block2Position[1]).setColor(null);
			this.blockArray.get(2).get(block3Position[1]).setColor(null);
			this.blockArray.get(3).get(block4Position[1]).setColor(null);
			
			block1Position[1] = block1Position[1] + 1;
			block2Position[1] = block1Position[1] + 1;
			block3Position[1] = block3Position[1] + 1;
			block4Position[1] = block4Position[1] + 1;
			
			this.blockArray.get(0).get(block1Position[1]).setColor(shapeColor);
			this.blockArray.get(1).get(block2Position[1]).setColor(shapeColor);
			this.blockArray.get(2).get(block3Position[1]).setColor(shapeColor);
			this.blockArray.get(3).get(block4Position[1]).setColor(shapeColor);
		}
	}

	public void moveVertically()
	{
		this.blockArray.get(0).get(block1Position[1]).setColor(null);
		this.blockArray.get(1).get(block2Position[1]).setColor(null);
		this.blockArray.get(2).get(block3Position[1]).setColor(null);
		this.blockArray.get(3).get(block4Position[1]).setColor(null);
		
		block1Position[0] = block1Position[0] + 1;
		block2Position[0] = block1Position[0] + 1;
		block3Position[0] = block3Position[0] + 1;
		block4Position[0] = block4Position[0] + 1;
		
		this.blockArray.get(block1Position[0]).get(block1Position[1]).setColor(shapeColor);
		this.blockArray.get(block2Position[0]).get(block2Position[1]).setColor(shapeColor);
		this.blockArray.get(block3Position[0]).get(block3Position[1]).setColor(shapeColor);
		this.blockArray.get(block4Position[0]).get(block4Position[1]).setColor(shapeColor);
	}

	public void rotateShape()
	{
		System.out.println("Figure out how to rotate later");	     
	}
}

