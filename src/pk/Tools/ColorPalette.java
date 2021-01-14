package pk.Tools;


import javax.swing.*;
import java.awt.*;

/**
 *  It is used for showing a color palette
 * @author Rahul B.
 * @version 0.1.
 */
public class ColorPalette
{
    JPanel parent = new JPanel();

    /**
     * Constructor for objects of class ColorPallete
     */
    public ColorPalette(JPanel panel)
    {
        parent = panel;
    }

    public void show()
    {
        Color c =JColorChooser.showDialog(parent,"Color Chooser",ColorModel.getColor());
        ColorModel.setColor(c);
    }
}
