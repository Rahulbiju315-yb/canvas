package pk.Tools.KeyboardAction;

import pk.Tools.*;

/**
 * Handles turn ie turn the turtle
 * @author Rahul B.
 * @version 0.1.
 */
public class TurnHandler
{
    final static int CWISE =0;
    final static int ANTI_CWISE=1;
    final static double CON = Math.PI/180;
    public void handle(int kc)
    {
        if(kc == CWISE)
        {
            double inc =  Resource.turtle.angle_inc * CON;
            Resource.turtle.angle +=inc ;
            //if(Resource.turtle.angle >= 360)Resource.turtle.angle = 0;
        }
        else if(kc == ANTI_CWISE)
        {
            Resource.turtle.angle -= Resource.turtle.angle_inc * CON;
            System.err.println("POLI");
        }
        Resource.frame.repaint();
    }
}
