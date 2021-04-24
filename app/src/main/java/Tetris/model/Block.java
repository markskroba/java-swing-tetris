package model;

import java.awt.Color;

/*Creates an individual block that has a size and color. Each block also has two boolean
 * conditions isActive and isSettle that tell whether the block is currently showing 
 * (isActive = true) and if the block is part of a moving shape (isSettle = false).
 */
public class Block 
{
	protected Color blockColor;

	public Block(Color color)
	{
		this.blockColor = color;
	}

	public Block()
	{
		this.blockColor = null;
	}

	public void setColor(Color color)
	{
		this.blockColor = color;
	}

	public Color getColor()
	{
		return this.blockColor;
	}
}
