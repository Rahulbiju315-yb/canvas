package pk.Tools;


/**
 * Mystify Tool
 * 
 * @author Rahul B.
 * @version 0.1.
 */
public class MystifyTool extends AbstractTool
{
    public static final int MYSTIFY_TOOL =7;
    public static final String MYSTIFY ="Mystify";
    public boolean isSelected =false;
    
    public MystifyTool(){
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
        return MYSTIFY;
    }
    
   public void handle(int x,int y,int x1, int y1)
   {
       (new MystifyHandler()).handle(x,y,x1,y1);
   }
   @Override
   public void setInit(int x,int y)
   {
       Properties.MystifyProp.x = x;
       Properties.MystifyProp.y = y;
   }
}
