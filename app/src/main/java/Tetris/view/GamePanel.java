package view;
import model.*;
import controller.*;
import model.TetrisArray;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class GamePanel implements TetrisUserInterface {
    
    protected BlockController controller;
    protected JPanel gameArea;

    public GamePanel(int x, int y)
    {
        gameArea = new JPanel();
		FlowLayout layout = new FlowLayout();
        layout.setHgap(0);
        layout.setVgap(0);
        gameArea.setLayout(layout);
        gameArea.setPreferredSize(new Dimension(x, y));
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        gameArea.setBorder(border);

//        this.updateView(new TetrisArray());
    }


    /*
     * While this seems to be somewhat functional if we were to call it, for example, in the constructor above,
     * even then it is not drawing active blocks (those that have color), while it can definitely find them and create
     * ViewBlock with those colors - drawing every block as color was not passed to it. However, when called from
     * BlockController it won't draw even that, leaving a clear GamePanel. I'm sure it is something dumb, so I will be
     * able to fix it.
     */
    public void updateView(TetrisArray gameScreen) {
        this.cleanUp();

        // We might need to reverse those two loops.
        for (int row = 0; row < 16; row++)
        {
            JPanel rowPanel = new JPanel();
            FlowLayout layout = (FlowLayout)rowPanel.getLayout();
            layout.setVgap(0);
            layout.setHgap(0);
            for (int column = 0; column < 9; column++)
            {
                Block modelBlock = gameScreen.getBlock(row, column);
                Color modelColor = modelBlock.getColor();
                if (modelColor != null)
                {
//                    System.out.println("Found Block with color set to " + modelColor + " at row " + row + " column " + column);
                    ViewBlock viewBlock = new ViewBlock(modelColor);
                    rowPanel.add(viewBlock);
                }
                else
                {
//                    System.out.println("Adding a non colored block");
                    ViewBlock viewBlock = new ViewBlock();
                    rowPanel.add(viewBlock);
                }
            }
            gameArea.add(rowPanel);
        }
        System.out.println("View updated!");
        System.out.println("starting updateView");
    }

    private void cleanUp()
    {
        for (int i = 0; i < gameArea.getComponentCount(); i++)
        {
            gameArea.remove(i);
        }
    }
    public JPanel getGameArea()
    {
		return gameArea;
    }
}
