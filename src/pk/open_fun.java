package pk;

/**
 *  Open function class.
 *  Displays a file chooser for choosing the file.
 *  @author Rahul B.
 * @version 0.1.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import pk.Tools.*;
public class open_fun
{
    JPanel panel;
    Main fr;
    BufferedImage image;
    public open_fun(JPanel panel ,Main fr)
    {
        this.panel =panel ;
        this.fr = fr;
    }

    /**
     * Display file chooser
     */
    public void openMenu()
    {
        JFileChooser chooser = new JFileChooser();
        int rval =   chooser.showOpenDialog(panel);
        if(rval ==JFileChooser.APPROVE_OPTION)
        {
            File f = chooser.getSelectedFile();
            open(f);
            paintPicture();
            panel.repaint();
        }
    }

    /**
     *  Open a file f ( image file ) and store it in image.
     */
    public void open(File f)
    {
        try
        {
            image = ImageIO.read(f);
        }
        catch (IOException e){
            System.err.println("ERROR LOADING FILE");
        }
    }

    /**
     *  Returns the size of the image.
     */
    public Dimension getPreferredSize()
    {
        if(image==null)
            return new Dimension(0,0);
        else
            return new Dimension(image.getWidth(),image.getHeight());

    }

    /**
     *  Paints the loaded picture onto the easel
     */
    public void paintPicture()
    {
        fr.dimensionChanged(getPreferredSize().width,getPreferredSize().height);
        AbstractHandler.easel.drawImage(image);
    }
}