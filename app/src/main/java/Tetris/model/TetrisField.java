package model;

import java.util.ArrayList;

public class TetrisField extends TetrisArray
{
    public TetrisField()
    {
	super();
	System.out.println("Creating an array that shows all of the unmoving blocks");
    }

    public TetrisArray add(TetrisShape shape)
    {
        // use case 7
        // checks for two blocks (5th and 6th), since those are in the middle and we cannot add a new block with even one being placed already
        if (this.getBlock(0, 4) != null || this.getBlock(0, 5) != null)
        {
            System.out.println("Can't add a new block, top row is blocked");
            return null;
        }
        System.out.println("Combining the TetrisField and the TetrisShape");
	    return this;
    }
}
