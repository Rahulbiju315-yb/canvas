package pk.Tools;

/**
 * Handler for square tool
 * 
 * @author Rahul B.
 * @version 0.1.
 */
import Tools.Listener.*;
public class SquareHandler extends AbstractHandler
{

    boolean flag = false;
    public   void handle(int x,int y, int x1, int y1)
    {
        boolean filled =Properties.SquareProp.filled;
        if(Properties.SquareProp.selected == Properties.SquareProp.SPEED_BASED)
            easel.drawRect(filled,Zoom.toScreen(x),Zoom.toScreen(y),Zoom.toScreen(Math.abs(x1-x)),Zoom.toScreen(Math.abs(y1-y)));

        else if(Properties.SquareProp.selected == Properties.SquareProp.POS_BASED)
            easel.drawRect(filled,Zoom.toScreen(x),Zoom.toScreen(y),Zoom.toScreen(Math.abs(x1)),Zoom.toScreen(Math.abs(y1)));
        else
        {
            int minX = Math.min(Properties.SquareProp.x,x1);
            int minY = Math.min(Properties.SquareProp.y,y1);
            
            int maxX = Math.max(Properties.SquareProp.x,x1);
            int maxY = Math.max(Properties.SquareProp.y,y1);
            if(filled)
                TGraph.g.fillRect(Zoom.toScreen(minX),Zoom.toScreen(minY),Zoom.toScreen(maxX-minX),Zoom.toScreen(maxY-minY));
            else
                TGraph.g.drawRect(Zoom.toScreen(minX),Zoom.toScreen(minY),Zoom.toScreen(maxX-minX),Zoom.toScreen(maxY-minY));
            if(flag)
            {
                easel.drawRect(filled,minX,minY,maxX-minX,maxY-minY);
            }
        };

    }

}
