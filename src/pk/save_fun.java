package pk;

import javax.swing.*;
import java.io.*;
import java.awt.*;
import javax.imageio.*;
import pk.Tools.*;
import java.awt.image.BufferedImage;

/**
 *  Save function class.
 *  Displays a file chooser for saving the file.
 *  @author Rahul B.
 *  @version 0.1.
 */
public class save_fun extends JPanel
{

    JPanel pa;
    public save_fun(JPanel panel)
    {
        super();
        pa = panel;
    }

    /**
     *  Shows the file chooser.
     */
    public void show()
    {
        File saveFile;
        JFileChooser chooser = new JFileChooser();
        chooser.setSelectedFile(new File("C://savedImage.jpeg"));//Default selected file
        int rval = chooser.showSaveDialog(pa);

        if (rval == JFileChooser.APPROVE_OPTION)
        {
            saveFile = chooser.getSelectedFile();
            save(saveFile);
        }
    }

    /**
     *  Saves the file f .
     */
    public  void save(File f){

        try
        {   
            BufferedImage image = AbstractHandler.easel.getImage();
            Graphics2D graphics2D = image.createGraphics();
            paint(graphics2D);
            ImageIO.write(image,"png", f);
        }
        catch(Exception exception)
        {
        }

    }

}
