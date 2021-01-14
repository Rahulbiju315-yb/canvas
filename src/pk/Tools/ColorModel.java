package pk.Tools;


import java.awt.Color; 
/**
 *  ColorModel stores the color current selected color , selected from the color palette
 *  
 *  @author Rahul B.
 * @version 0.1.
 */
public class ColorModel
{
    public static Color color =Color.black;
    
   
    public static void setColor(Color c)
    {
        color =c;
        AbstractTool.color =c;
        AbstractHandler.easel .setColor(c);
    }
    
    public static Color getColor()
    {
        return color;
    }
    
    public static int getRGB()
    {
        return color.getRGB();
    }
}
