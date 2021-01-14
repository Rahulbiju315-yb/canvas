package pk.Tools.KeyboardAction;

import java.awt.*;
import pk.Tools.*;

/**
 * Handles moving keycode kc is received from class pk.KAction
 * @author Rahul B.
 * @version 0.1.
 */
public class MoveHandler
{
    final static int UP_KEY = 0;
    final static int LEFT_KEY = 1;
    final static int DOWN_KEY = 2;
    final static int RIGHT_KEY = 3;
    public void handle(int kc)
    {
        Resource.turtle.px = Resource.turtle.x;
        Resource.turtle.py = Resource.turtle.y;

        if(kc == UP_KEY)
        {
            Resource.turtle.y -= Resource.turtle.speed;
        }
        else if(kc == LEFT_KEY)
        {
            Resource.turtle.x -= Resource.turtle.speed;
        }
        else if(kc == DOWN_KEY)
        {
            Resource.turtle.y += Resource.turtle.speed;
        }
        else if(kc == RIGHT_KEY)
        {  
            Resource.turtle.x += Resource.turtle.speed;
        }
        AbstractTool tool = ToolManager.getAsTool();
        float  x1 = AbstractHandler.easel.fx(Resource.turtle.x),
        y1 = AbstractHandler.easel.fy(Resource.turtle.y),

        ox = AbstractHandler.easel.fx(Resource.turtle.px),
        oy = AbstractHandler.easel.fy(Resource.turtle.py);

        float[] r1x = AbstractHandler.easel.rotate(x1,y1,ox,oy,Resource.turtle.angle);
        float[] r2x = AbstractHandler.easel.rotate(ox,oy,ox,oy,Resource.turtle.angle);
        Resource.turtle.x = AbstractHandler.easel.iX(r1x[0]);
        Resource.turtle.y = AbstractHandler.easel.iY(r1x[1]);
        if(Resource.turtle.pu)
        {           
            tool.handle(AbstractHandler.easel.iX(r1x[0]),AbstractHandler.easel.iY(r1x[1]),AbstractHandler.easel.iX(r2x[0]),AbstractHandler.easel.iY(r2x[1]));
            System.err.println("VISITED");
        }

        Resource.frame.repaint();

    }

}

