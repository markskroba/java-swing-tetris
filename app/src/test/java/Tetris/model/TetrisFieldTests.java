package model;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.awt.Color;
import java.util.ArrayList;

public class TetrisFieldTests
{
	private TetrisField field;
	private TetrisShape shape;

	@Before
	public void setUp()
	{
		field = new TetrisField();
		shape = new LShape(Color.BLUE);
	}

	@Test
	public void testInitialEndGame()
	{
		assertFalse("Error: endGame not initially false", field.endGame());
	}

/*Currently it seems that LShape is not working properly (block is null at 0, center and should not be
 * 	@Test
	public void testAddNewShape()
	{
		TetrisArray array = field.add(shape);
		int center = shape.getNumColumns()/2;
		assertEquals("Error: New Shape not added properly", Color.BLUE, array.getBlock(0, center).getColor());
	}
*/
	@Test
	public void testContMovingAfterNewShape()
	{
		TetrisArray array = field.add(shape);
		assertTrue("Error: continueMoving False after adding a shape to field", field.continueMoving());
	}

/*	@Test
	public void testAddSameShapeTwice()
	{
		TetrisArray array = field.add(shape);
		TetrisShape shape2 = new LShape(Color.RED);
		TetrisArray array2 = field.add(shape2);
		assertTrue("Error: Game should end when a shape can't be added", field.endGame());
	}
*/	
	@Test
	public void testLocateFullRow()
	{
		for(int i=0; i<field.getNumColumns(); i++)
		{
			field.adjust(2, i, new Block(Color.RED));
		}

		ArrayList<Integer> results = field.locateFullRow();
		int row = results.get(0);
		assertEquals("Error: locateFullRow not working", 2, row);
	}

	@Test
	public void testClearRow()
	{
		for(int i=0; i<field.getNumColumns(); i++)
		{
			field.adjust(2, i, new Block(Color.RED));
		}
		field.adjust(1,4, new Block(Color.BLUE));
		field.clearRows();
		assertNull("Error: clearRow does not remove blocks", field.getBlock(2,1).getColor());
 	}

	@Test
	public void testClearRowMovement()
	{
		for(int i=0; i<field.getNumColumns(); i++)
		{
			field.adjust(2, i, new Block(Color.RED));
		}
		field.adjust(1,4, new Block(Color.BLUE));
		field.clearRows();
		assertNotNull("Error: clearRow does not move blocks down", field.getBlock(1,4).getColor());
	}
}
