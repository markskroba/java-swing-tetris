package model;
import java.awt.Color;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.awt.Dimension;


/*Creates an individual block that has a size and color. Each block also has two boolean
 * conditions isActive and isSettle that tell whether the block is currently showing 
 * (isActive = true) and if the block is part of a moving shape (isSettle = false).
 */
public class Block extends JPanel
{
	protected Color blockColor;
	protected boolean isActive;
	protected boolean isSettle;
	
	public Block(int side, Color color, boolean active, boolean settle)
	{
		isActive = active;
		isSettle = settle;
		blockColor = color;

		this.setPreferredSize(new Dimension(side,side));
		if (active)
		{
		    this.setBackground(color);
		    Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
		    this.setBorder(border);
		}
	}
	
	public void setColor(Color color)
	{
		blockColor = color;
	}
	
	public Color getColor()
	{
		return blockColor;
	}
	
	public void setIsActive(boolean cond)
	{
		isActive = cond;
	}
	
	public void setIsSettle(boolean cond)
	{
		isSettle = cond;
	}
	
	public boolean isActive()
	{
		return isActive;
	}
	
	public boolean isSettle()
	{
		return isSettle;
	}
}
