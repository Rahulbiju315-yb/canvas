package pk.Tools.KeyboardAction;


import pk.Tools.*;

/**
 *  Tool for turtle.
 *  Tutle tool is repeated rather than handled.
 *  
 *  @author Rahul B.
 * @version 0.1.
 */
public class TurtleTool extends AbstractTool
{
   TurtleHandler h = new TurtleHandler() ; 
   public static final int TURTLE_TOOL = 8;
   public void handle(int x, int y, int x1, int y1)
   {
       
   }
   @Override
   public void repeat(int x, int y)
   {
       h.repeat(x,y);
   }
   
}
