package pk.Tools;

/**
 * Eraser Tool
 * 
 * @author Rahul B.
 * @version 0.1.
 */
public class EraserTool extends AbstractTool
{
    public static final int ERASER_TOOL =6;
    public static final String ERASER ="Eraser";
    public boolean isSelected =false;
    
    public EraserTool(){
       super.ID ="Eraser";
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
        return ERASER;
    }
    
    public void handle(int x,int y,int x1, int y1)
    {
        (new EraserHandler()).handle(x,y,x1,y1);
    }

}
