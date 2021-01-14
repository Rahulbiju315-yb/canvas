package pk.Tools;

/**
 * Fill Wih Color tool
 * 
 * @author Rahul B.
 * @version 0.1.
 */
import java.awt.*;

public class FillWithColorTool extends AbstractTool
{
    public static final int FWC_TOOL =2;
    public static final String FWC ="Fill With Color Tool";
    public boolean isSelected =false;

    public FillWithColorTool(){

     }
     
    public void pressed(int x,int y,int x1, int y1)
    {
        handle(x,y,x1,y1);
    }

    public boolean getSelected()
    {
        return isSelected;
    }

    public void setSelected(boolean sel)
    {
        isSelected = sel;
    }

    public String toString()
    {
        return FWC;
    }

    public void handle(int x,int y,int x1, int y1)
    {
        (new FWCHandler()).handle(x,y,(x1),y1);
        System.err.println("HAPPENED");
    }
}
