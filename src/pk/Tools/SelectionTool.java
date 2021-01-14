package pk.Tools;

/**
 * Selection Tool
 * 
 * @author Rahul B.
 * @version 0.1.
 */
import java.awt.*;
public class SelectionTool extends AbstractTool
{
    public static final int SELECTION_TOOL =3;
    public static final String SELECTION ="Selection";
    public boolean isSelected =false;
    public static boolean drag = false; 
    public static boolean inProc = true; 
    public static int wi=0 ,he=0 , px =0 ,py =0 ;
    SelectionHandler h =new SelectionHandler();
    public SelectionTool(){
        super.ID ="Selection";
    }

    public boolean getSelected()
    {
        return isSelected;
    }

    public void repeat(int x,int y)
    {
        h.handle(x,y,x,y); 
    }

    public void setSelected(boolean sel)
    {
        isSelected = sel;
    }

    public void setInit(int x, int y)
    {
        Properties.SelectionProp.x =x;
        Properties.SelectionProp.y =y;
    }

    public String toString()
    {
        return SELECTION;
    }

    @Override
    public void drag(int x, int y,int x1, int y1)
    {
        h.handle(x,y,x1,y1);
    }

    @Override
    public void released(int x,int y)
    {
        drag = false;

        if(!inProc)
        {
            inProc = true;
        }
    }

    public void handle(int x,int y,int x1, int y1)
    {
        h.handle(x,y,x1,y1);
    }

}
