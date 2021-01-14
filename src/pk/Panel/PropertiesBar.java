package pk.Panel;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import pk.Tools.*;
import javax.swing.border.*;

/**
 *  Displays the property panel for each tool at the right of the screen.
 *  
 * @author Rahul B.
 * @version 0.1.
 */
public class PropertiesBar extends JPanel
{
    static JLabel  selCol = new JLabel("COLOR");

    /**
     *  Method to update the property panel based on the current selected tool.
     *  Whenever a tool is selected this method is called with parameter of id of tool.
     */
    public  void update(int a)
    {
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        boolean flag = true;
        if(a ==SquareTool.SQUARE_TOOL && flag)
        {
            removeAll(); 
            revalidate();
            repaint();
            flag = false;
        }
        else if(a ==OvalTool.OVAL_TOOL && flag)
        {
            removeAll(); 
            add(new OvalProp());
            revalidate();
            repaint();
            flag = false;
        }
        else if(a ==PolygonTool.POLYGON_TOOL && flag)
        {
            removeAll(); 
            add(new PolygonProp());
            revalidate();
            repaint();
            flag = false;
        }
        else if(a ==EraserTool.ERASER_TOOL && flag)
        {
            removeAll(); 
            add(new EraserProp());
            System.out.println("romed");
            revalidate();
            repaint();
            flag = false;
        }
        else if(a ==PencilTool.PENCIL_TOOL && flag)
        {
            removeAll(); 
            add(new PencilProp());
            revalidate();
            repaint();
            flag = false;
        }
        else if(a ==FractTool.FRACT_TOOL && flag)
        {
            removeAll(); 
            add(new FractalProp());
            revalidate();
            repaint();
            flag = false;
        }
        else{
            removeAll();
            revalidate();
            flag = true;
        }

        selCol.setPreferredSize(new Dimension(50,50));
        selCol.setBackground(ColorModel.color);
        selCol.setOpaque(true);
        add(selCol);
        setBorder(new BevelBorder(BevelBorder.RAISED));
    }

    /**
     *  Set the color of the color label
     *  The color label displays the current selected color
     */
    public static void setColor(Color c)
    {
        selCol.setBackground(ColorModel.color);
        PropertiesBar.selCol.repaint();
    }
}