package view;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Dimension;

public class ViewBlock extends JPanel{

    private Color color;
    public ViewBlock()
    {
        System.out.println("Calling empty constructor");
        this.setPreferredSize(new Dimension(50, 50));
        this.setBackground(Color.WHITE);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
        this.setBorder(border);
    }
    public ViewBlock(Color color)
    {
        this.color = color;

        this.setPreferredSize(new Dimension(50, 50));
        this.setBackground(this.color);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
        this.setBorder(border);
        System.out.println(this.getBackground());
    }

}
