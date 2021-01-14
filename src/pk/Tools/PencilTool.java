package pk.Tools;


/**
 *  @author Rahul B.
 *  PencilTool
 */
public class PencilTool extends AbstractTool
{
    public static final int PENCIL_TOOL =4;
    public static final String PENCIL ="Pencil";
    public boolean isSelected =false;
    
    public PencilTool(){
      
       super.ID ="Pencil";
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
        return PENCIL;
    }
    
    public void handle(int x,int y,int x1, int y1)
    {
        (new PencilHandler()).handle(x,y,x1,y1);
    }
}
