package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

public class SShape extends TetrisShape
{
	public SShape(Color color)
	{
		super(color);

		//add shape to the center top of the shapeArray
		center = numCols/2;

		this.blockArray.get(1).get(center-1).setColor(this.shapeColor);
		this.blockArray.get(1).get(center).setColor(this.shapeColor);
		this.blockArray.get(0).get(center).setColor(this.shapeColor);
		this.blockArray.get(0).get(center+1).setColor(this.shapeColor);

/*		block1Position[0] = 1;
		block1Position[1] = center - 1;
		
		block2Position[0] = 1;
		block2Position[1] = center;
		
		block3Position[0] = 0;
		block3Position[1] = center;
		
		block4Position[0] = 0;
		block4Position[1] = center + 1;
		
		currentRotation = 0;
		
		createFirstRotation();
		createSecondRotation();
		createThirdRotation();
		createFourthRotation();
		*/
	}
	
	public void createFirstRotation()
	{
	/*	//All the row combinations for the first rotation
		rotatedShapes[0][0][0] = block1Position[0];
		rotatedShapes[0][1][0] = block2Position[0];
		rotatedShapes[0][2][0] = block3Position[0];
		rotatedShapes[0][3][0] = block4Position[0];
		//All the column combinations for the first rotation
		rotatedShapes[0][0][1] = block1Position[1];
		rotatedShapes[0][1][1] = block2Position[1];
		rotatedShapes[0][2][1] = block3Position[1];
		rotatedShapes[0][3][1] = block4Position[1];
	*/
	}
	
	public void createSecondRotation()
	{
	/*	block1Position[0] = block1Position[0] - 1;
		block1Position[1] = block1Position[1] + 1;
		
		block2Position[0] = block1Position[0];
		block2Position[1] = block1Position[1];
		
		block3Position[0] = block1Position[0] + 1;
		block3Position[1] = block1Position[1] + 1;
		
		block4Position[0] = block1Position[0] + 2;
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
	*/
	}
	
	public void createThirdRotation()
	{
	/*	block1Position[0] = block1Position[0] + 1;
		block1Position[1] = block1Position[1] + 1;
		
		block2Position[0] = block1Position[0];
		block2Position[1] = block1Position[1];
		
		block3Position[0] = block1Position[0] + 1;
		block3Position[1] = block1Position[1] - 1;
		
		block4Position[0] = block1Position[0];
		block4Position[1] = block1Position[1] - 2;
		
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
	*/
	}
	
	public void createFourthRotation()
	{
	/*	block1Position[0] = block1Position[0] + 1;
		block1Position[1] = block1Position[1] - 1;
		
		block2Position[0] = block1Position[0];
		block2Position[1] = block1Position[1];
		
		block3Position[0] = block1Position[0] - 1;
		block3Position[1] = block1Position[1] - 1;
		
		block4Position[0] = block1Position[0] - 2;
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
	*/
	}

/*	public void moveHorizontally(int direction)
	{
		boolean canMove = true;

		//to move left
		if(direction < 0)
		{
			for (int i=0; i<numRows; i++)
			{
				if(this.blockArray.get(i).get(0).getColor() != null)
				{
					canMove = false;
				}
			}

			if (canMove == true)
			{

			for (int i=0; i<numRows; i++)
				{
					for (int j=1; j<numCols; j++)
					{
						if(this.blockArray.get(i).get(j).getColor() != null)
						{
							this.blockArray.get(i).get(j).setColor(null);
							this.blockArray.get(i).get(j-1).setColor(this.shapeColor);
						}
					}
				}
			}

		}
		//to move right
		else if(direction > 0)
		{
			for (int i=0; i<numRows; i++)
			{
				if(this.blockArray.get(i).get(numCols-1).getColor() != null)
				{
					canMove = false;
				}
			}

			if (canMove == true)
			{
				for (int i=0; i<numRows; i++)
				{
					for (int j=numCols-2; j>=0; j--)
					{
						if(this.blockArray.get(i).get(j).getColor() != null)
						{
							this.blockArray.get(i).get(j).setColor(null);
							this.blockArray.get(i).get(j+1).setColor(this.shapeColor);
						}
					}
				}
			}

		}
	
	}

	public void moveVertically()
	{
		//Make sure that it can't move out of bounds by checking that the last row is empty
		boolean canMove = true;
		for(int j=0; j<numCols; j++)
		{
			if(this.blockArray.get(numRows-1).get(j).getColor() != null)
			{
				canMove = false;
			}
		}
		
		if (canMove == true)
		{
			for (int i=14; i>=0; i--)
			{
				for (int j=0; j<numCols; j++)
		 		{
					if(this.blockArray.get(i).get(j).getColor() != null)
					{
						this.blockArray.get(i).get(j).setColor(null);
						this.blockArray.get(i+1).get(j).setColor(this.shapeColor);
					}
		 		}	
		 	}
		}
		
	}
*/
	public void rotateShape()
	{
		int i = 0;
		boolean located = false;

		while (located == false)
		{
			for (int j=0; j<numCols-1; j++)
			{
				if(blockArray.get(i).get(j).getColor() != null && blockArray.get(i).get(j+1).getColor() != null)
				{
					if(i!=0 && (blockArray.get(i+1).get(j).getColor() != null))
					{
						blockArray.get(i+1).get(j-1).setColor(null);
						blockArray.get(i+1).get(j).setColor(null);
						blockArray.get(i-1).get(j).setColor(shapeColor);
						blockArray.get(i+1).get(j+1).setColor(shapeColor);
						located = true;
					}
					else if (i!= 0 && j != 0)
					{
						blockArray.get(i-1).get(j).setColor(null);
						blockArray.get(i+1).get(j+1).setColor(null);
						blockArray.get(i+1).get(j-1).setColor(shapeColor);
						blockArray.get(i+1).get(j).setColor(shapeColor);
						located = true;
					}
					else
					{
						located = true;
					}
				}
			}
			i++;
		}
	}

	
}

