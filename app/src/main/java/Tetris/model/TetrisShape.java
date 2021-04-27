package model;

import java.awt.Color;

public abstract class TetrisShape extends TetrisArray
{
	protected int[] block1Position;
	protected int[] block2Position;
	protected int[] block3Position;
	protected int[] block4Position;
	
	protected int[][][] rotatedShapes;
	
	protected int currentRotation;
	
	protected int center;
	
	protected Color shapeColor;

	public TetrisShape(Color color)
	{
		this.shapeColor = color;
		
		block1Position = new int[2];
		block2Position = new int[2];
		block3Position = new int[2];
		block4Position = new int[2];
		
		rotatedShapes = new int[4][4][2];
	}

	public abstract void createFirstRotation();
	
	public abstract void createSecondRotation();
	
	public abstract void createThirdRotation();
	
	public abstract void createFourthRotation();
	
	public abstract void moveVertically();

	public abstract void moveHorizontally(int direction);

	public abstract void rotateShape();
}
