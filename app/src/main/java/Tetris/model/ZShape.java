package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

public class ZShape extends TetrisShape
{
	public ZShape(Color color)
	{
		super(color);


		//add the shape to the center top of the array
		center = numCols/2;

		this.blockArray.get(0).get(center-1).setColor(color);
		this.blockArray.get(0).get(center).setColor(color);
		this.blockArray.get(1).get(center).setColor(color);
		this.blockArray.get(1).get(center+1).setColor(color);
		
		block1Position[0] = 0;
		block1Position[1] = center - 1;
		
		block2Position[0] = 0;
		block2Position[1] = center;
		
		block3Position[0] = 1;
		block3Position[1] = center;
		
		block4Position[0] = 1;
		block4Position[1] = center + 1;
		
		rotatedShapes = new int[4][][];
		
		currentRotation = 0;
		
		createFirstRotation();
		createSecondRotation();
		createThirdRotation();
		createFourthRotation();
	}
	
	public void createFirstRotation()
	{
		//All the row combinations for the first rotation
		rotatedShapes[0][0][0] = block1Position[0];
		rotatedShapes[0][1][0] = block2Position[0];
		rotatedShapes[0][2][0] = block3Position[0];
		rotatedShapes[0][3][0] = block4Position[0];
		//All the column combinations for the first rotation
		rotatedShapes[0][0][1] = block1Position[1];
		rotatedShapes[0][1][1] = block2Position[1];
		rotatedShapes[0][2][1] = block3Position[1];
		rotatedShapes[0][3][1] = block4Position[1];
	}
	
	public void createSecondRotation()
	{
		block1Position[0] = block1Position[0];
		block1Position[1] = block1Position[1];
		
		block2Position[0] = block1Position[0] + 1;
		block2Position[1] = block1Position[1] - 1;
		
		block3Position[0] = block1Position[0] - 1;
		block3Position[1] = block1Position[1] + 1;
		
		block4Position[0] = block1Position[0] - 2;
		block4Position[1] = block1Position[1];
		
		//All the row combinations for the second rotation
		rotatedShapes[1][0][0] = block1Position[0];
		rotatedShapes[1][1][0] = block2Position[0];
		rotatedShapes[1][2][0] = block3Position[0];
		rotatedShapes[1][3][0] = block4Position[0];
		//All the column combinations for the second rotation
		rotatedShapes[1][0][1] = block1Position[1];
		rotatedShapes[1][1][1] = block2Position[1];
		rotatedShapes[1][2][1] = block3Position[1];
		rotatedShapes[1][3][1] = block4Position[1];
	}
	
	public void createThirdRotation()
	{
		block1Position[0] = block1Position[0];
		block1Position[1] = block1Position[1];
		
		block2Position[0] = block1Position[0] - 1;
		block2Position[1] = block1Position[1] - 1;
		
		block3Position[0] = block1Position[0] + 1;
		block3Position[1] = block1Position[1] + 1;
		
		block4Position[0] = block1Position[0];
		block4Position[1] = block1Position[1] + 2;
		
		//All the row combinations for the third rotation
		rotatedShapes[2][0][0] = block1Position[0];
		rotatedShapes[2][1][0] = block2Position[0];
		rotatedShapes[2][2][0] = block3Position[0];
		rotatedShapes[2][3][0] = block4Position[0];
		//All the column combinations for the third rotation
		rotatedShapes[2][0][1] = block1Position[1];
		rotatedShapes[2][1][1] = block2Position[1];
		rotatedShapes[2][2][1] = block3Position[1];
		rotatedShapes[2][3][1] = block4Position[1];
	}
	
	public void createFourthRotation()
	{
		block1Position[0] = block1Position[0];
		block1Position[1] = block1Position[1];
		
		block2Position[0] = block1Position[0] - 1;
		block2Position[1] = block1Position[1] + 1;
		
		block3Position[0] = block1Position[0] + 1;
		block3Position[1] = block1Position[1] - 1;
		
		block4Position[0] = block1Position[0] + 2;
		block4Position[1] = block1Position[1];
		
		//All the row combinations for the fourth rotation
		rotatedShapes[3][0][0] = block1Position[0];
		rotatedShapes[3][1][0] = block2Position[0];
		rotatedShapes[3][2][0] = block3Position[0];
		rotatedShapes[3][3][0] = block4Position[0];
		//All the column combinations for the fourth rotation
		rotatedShapes[3][0][1] = block1Position[1];
		rotatedShapes[3][1][1] = block2Position[1];
		rotatedShapes[3][2][1] = block3Position[1];
		rotatedShapes[3][3][1] = block4Position[1];
	}

	public void moveHorizontally(int direction)
	{
		if(direction < 0)
		{
			this.blockArray.get(0).get(block1Position[1]).setColor(null);
			this.blockArray.get(0).get(block2Position[1]).setColor(null);
			this.blockArray.get(1).get(block3Position[1]).setColor(null);
			this.blockArray.get(1).get(block4Position[1]).setColor(null);
			
			block1Position[1] = block1Position[1] - 1;
			block2Position[1] = block1Position[1] - 1;
			block3Position[1] = block3Position[1] - 1;
			block4Position[1] = block4Position[1] - 1;
			
			this.blockArray.get(0).get(block1Position[1]).setColor(shapeColor);
			this.blockArray.get(0).get(block2Position[1]).setColor(shapeColor);
			this.blockArray.get(1).get(block3Position[1]).setColor(shapeColor);
			this.blockArray.get(1).get(block4Position[1]).setColor(shapeColor);
		}
		else if(direction > 0)
		{
			this.blockArray.get(0).get(block1Position[1]).setColor(null);
			this.blockArray.get(0).get(block2Position[1]).setColor(null);
			this.blockArray.get(1).get(block3Position[1]).setColor(null);
			this.blockArray.get(1).get(block4Position[1]).setColor(null);
			
			block1Position[1] = block1Position[1] + 1;
			block2Position[1] = block1Position[1] + 1;
			block3Position[1] = block3Position[1] + 1;
			block4Position[1] = block4Position[1] + 1;
			
			this.blockArray.get(0).get(block1Position[1]).setColor(shapeColor);
			this.blockArray.get(0).get(block2Position[1]).setColor(shapeColor);
			this.blockArray.get(1).get(block3Position[1]).setColor(shapeColor);
			this.blockArray.get(1).get(block4Position[1]).setColor(shapeColor);
		}
	}

	public void moveVertically()
	{
		this.blockArray.get(0).get(block1Position[1]).setColor(null);
		this.blockArray.get(0).get(block2Position[1]).setColor(null);
		this.blockArray.get(1).get(block3Position[1]).setColor(null);
		this.blockArray.get(1).get(block4Position[1]).setColor(null);
		
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
		currentRotation++;
		
		if(currentRotation > 3)
		{
			currentRotation = 0;
		}
		
		this.blockArray.get(rotatedShapes[currentRotation][0][0]).get(rotatedShapes[currentRotation][0][1]).setColor(shapeColor);
		this.blockArray.get(rotatedShapes[currentRotation][1][0]).get(rotatedShapes[currentRotation][1][1]).setColor(shapeColor);
		this.blockArray.get(rotatedShapes[currentRotation][2][0]).get(rotatedShapes[currentRotation][2][1]).setColor(shapeColor);
		this.blockArray.get(rotatedShapes[currentRotation][3][0]).get(rotatedShapes[currentRotation][3][1]).setColor(shapeColor);
	}
}
