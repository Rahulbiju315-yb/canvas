package pk.Tools;


import java.awt.*;
import pk.Tools.Listener.*;

/**
 * Handler for pancil tool
 * 
 * @author Rahul B.
 * @version 0.1.
 */

public class PencilHandler extends AbstractHandler
{
    public void handle(int x,int y,int x1, int y1)
    {
        ///easel.addUndoLayer();
        
         if(Properties.PencilProp.selected == Properties.PencilProp.NORMAL)
         easel.drawLine(Zoom.toScreen(x),Zoom.toScreen(y),Zoom.toScreen(x1),Zoom.toScreen(y1));
         else if(Properties.PencilProp.selected == Properties.PencilProp.CALIGRAPHIC)
         easel.drawCaligLine(Zoom.toScreen(x),Zoom.toScreen(y),Zoom.toScreen(x1),Zoom.toScreen(y1));
        else if(Properties.PencilProp.selected == Properties.PencilProp.SPIKE)
         easel.drawSpikeLine(Zoom.toScreen(x),Zoom.toScreen(y),Zoom.toScreen(x1),Zoom.toScreen(y1));
        else if(Properties.PencilProp.selected == Properties.PencilProp.TANGLED)
         easel.drawTangledLine(Zoom.toScreen(x),Zoom.toScreen(y),Zoom.toScreen(x1),Zoom.toScreen(y1));
        else if(Properties.PencilProp.selected == Properties.PencilProp.WAVY)
         easel.drawWavyLine(Zoom.toScreen(x),Zoom.toScreen(y),Zoom.toScreen(x1),Zoom.toScreen(y1));
         else if(Properties.PencilProp.selected == Properties.PencilProp.RIBBON)
         easel.drawRibbonLine(Zoom.toScreen(x),Zoom.toScreen(y),Zoom.toScreen(x1),Zoom.toScreen(y1));
         else if(Properties.PencilProp.selected == Properties.PencilProp.SPLOSH)
         easel.drawSploshedLine(Zoom.toScreen(x),Zoom.toScreen(y),Zoom.toScreen(x1),Zoom.toScreen(y1));
         else if(Properties.PencilProp.selected == Properties.PencilProp.GRASS)
         easel.drawGrassLine(Zoom.toScreen(x),Zoom.toScreen(y),Zoom.toScreen(x1),Zoom.toScreen(y1));
         
         
    }
}
