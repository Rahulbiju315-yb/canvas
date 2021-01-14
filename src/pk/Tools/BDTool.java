package pk.Tools;


/**
 * Write a description of class BDTool here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BDTool extends AbstractTool
{
    public static final int BD_TOOL =9;
    public static final String BD ="BD";
    public boolean isSelected =false;

    public BDTool(){
           super.ID ="BD";
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
        return BD;
    }
    
    public void handle(int x,int y,int x1, int y1)
    {
        (new BDHandler()).handle(x,y,x1,y1);
    }
}
