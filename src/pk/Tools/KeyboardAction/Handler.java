package pk.Tools.KeyboardAction;


import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import pk.Tools.*;
/**
 * Handles the received key event.
 * The key code is obtained from the event and to to this classes handle(int) function
 * 
 * @author Rahul B.
 * @version 0.1.
 */
public class Handler
{
    MoveHandler mh = new MoveHandler();
    TurnHandler th = new TurnHandler();
    
    public void handle(int kc)
    {
        if(kc == 38)mh.handle(MoveHandler.UP_KEY);//UP ARROW
        else if(kc == 37)mh.handle(MoveHandler.LEFT_KEY);//LEFT ARROW
        else if(kc == 40)mh.handle(MoveHandler.DOWN_KEY);//DOWN ARROW
        else if(kc == 39)mh.handle(MoveHandler.RIGHT_KEY);//RIGHT ARROW
        else if(kc == 88)th.handle(TurnHandler.CWISE);//x
        else if(kc == 90)th.handle(TurnHandler.ANTI_CWISE);//z
    }
}