package pk.Tools;




/**
 * Class to handle mystify tool
 * 
 * @author Rahul B.
 * @version 0.1.
 */
import Tools.Listener.*;
public class MystifyHandler extends AbstractHandler
{
   
   public   void handle(int x,int y, int x2, int y2)
   {
       //Draw lines from first clicked point to the current points.First point is the point clicked at the beginning of drag.
       int x1 = Properties.MystifyProp.x;
       int y1 = Properties.MystifyProp.y;

       easel.drawLine(Zoom.toScreen(x1),Zoom.toScreen(y1),Zoom.toScreen(x),Zoom.toScreen(y));
       
   }
}



