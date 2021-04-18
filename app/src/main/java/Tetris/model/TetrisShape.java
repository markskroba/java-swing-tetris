package model;
import java.awt.Color;

public abstract class TetrisShape extends TetrisArray
{
    protected Color shapeColor;

    public TetrisShape(Color color)
    {
	this.shapeColor = color;
	System.out.println("TetrisShape Creating an array that holds a shape with the color encoded");
    }
	
    public abstract void moveVertically();

    public abstract void moveHorizontally(int direction);

    public abstract void rotateShape();

}
