package pk.Tools;


/**
 *Fractal Tool
 *@author Rahul B.
 *@version 0.1.
 */
public class FractTool extends AbstractTool
{
    public static final int FRACT_TOOL =10;
    public static final String FRACT ="FRACTAL";
    public boolean isSelected =false;

    public FractTool(){
           super.ID ="FRACTAL";
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
        return FRACT;
    }
    
    public void handle(int x,int y,int x1, int y1)
    {
        (new FractalHandler()).handle(x,y,x1,y1);
    }
}
