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
        blockColor = color;
	System.out.println("Creating a block that essentially codes the color");
    }

    public Block()
    {
        blockColor = null;
    }

    public void setColor(Color color)
    {
        blockColor = color;
    }

    public Color getColor()
    {
        return blockColor;
    }
    	
}
