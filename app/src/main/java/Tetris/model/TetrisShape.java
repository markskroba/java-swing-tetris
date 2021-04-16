package model;
import java.awt.Color;

public abstract class TetrisShape extends TetrisArray
{
    protected Color shapeColor;

    public TetrisShape(Color color)
    {
	this.shapeColor = color;
    }
	
    public abstract void moveVertically();

    public abstract void moveHorizontally();

    public abstract void rotateShape();

}
