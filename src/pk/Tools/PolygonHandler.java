package pk.Tools;

import java.awt.*;
import javax.swing.*;
import Tools.Listener.*;

/**
 * Hnadler for polygon tool
 * 
 * @author Rahul B.
 * @version 0.1.
 */
public class PolygonHandler extends AbstractHandler
{ 
    public static boolean inProcess =false;
    public void handle(int x,int y, int x1 ,int x2)
    {
        Graphics g =  easel.getImage().getGraphics();
        g.setColor(ColorModel.color);
        g.drawLine(Zoom.toScreen(x),Zoom.toScreen(y),Zoom.toScreen(x1),Zoom.toScreen(x2));
    }
}
