package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

public class LShape extends TetrisShape
{
	public LShape(Color color)
	{
		super(color);
		
		//add the shape to the center top of the this.blockArray
		center = numCols/2;

		this.blockArray.get(0).get(center).setColor(color);
		this.blockArray.get(0).get(center+1).setColor(color);
		this.blockArray.get(0).get(center-1).setColor(color);
		this.blockArray.get(1).get(center-1).setColor(color);
		
		block1Position[0] = 0;
		block1Position[1] = center;
		
		block2Position[0] = 0;
		block2Position[1] = center+1;
		
		block3Position[0] = 0;
		block3Position[1] = center-1;
		
		block4Position[0] = 1;
		block4Position[1] = center-1;

	}

	public void moveHorizontally(int direction)
	{
		if(direction < 0)
		{
			this.blockArray.get(0).get(block1Position[1]).setColor(null);
			this.blockArray.get(0).get(block2Position[1]).setColor(null);
			this.blockArray.get(0).get(block3Position[1]).setColor(null);
			this.blockArray.get(1).get(block4Position[1]).setColor(null);
			
			block1Position[1] = block1Position[1] - 1;
			block2Position[1] = block1Position[1] - 1;
			block3Position[1] = block3Position[1] - 1;
			block4Position[1] = block4Position[1] - 1;
			
			this.blockArray.get(0).get(block1Position[1]).setColor(shapeColor);
			this.blockArray.get(0).get(block2Position[1]).setColor(shapeColor);
			this.blockArray.get(0).get(block3Position[1]).setColor(shapeColor);
			this.blockArray.get(1).get(block4Position[1]).setColor(shapeColor);
		}
		else if(direction > 0)
		{
			this.blockArray.get(0).get(block1Position[1]).setColor(null);
			this.blockArray.get(0).get(block2Position[1]).setColor(null);
			this.blockArray.get(0).get(block3Position[1]).setColor(null);
			this.blockArray.get(1).get(block4Position[1]).setColor(null);
			
			block1Position[1] = block1Position[1] + 1;
			block2Position[1] = block1Position[1] + 1;
			block3Position[1] = block3Position[1] + 1;
			block4Position[1] = block4Position[1] + 1;
			
			this.blockArray.get(0).get(block1Position[1]).setColor(shapeColor);
			this.blockArray.get(0).get(block2Position[1]).setColor(shapeColor);
			this.blockArray.get(0).get(block3Position[1]).setColor(shapeColor);
			this.blockArray.get(1).get(block4Position[1]).setColor(shapeColor);
		}
	}

	public void moveVertically()
	{
		//System.out.println("Figure how to move vertically later");
	}

	public void rotateShape()
	{
		System.out.println("Figure out how to rotate later");
	}
}


