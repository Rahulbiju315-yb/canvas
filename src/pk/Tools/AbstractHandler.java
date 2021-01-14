package pk.Tools;

/**
 * AbstractHandler handles the drawing of different tools.All Tool Handler must extend this class.
 * 
 * @author Rahul B.
 * @version 0.1.
 */
public abstract class AbstractHandler
{

    public static Easel easel;

    /** The method handle(int,int,int,int) takes 4 parameters x,y,x2,y2 
     * x ->previous x
     * y ->previous y
     * x2->current  x
     * y2->current  y(mouse cordinates)
     */
    public  abstract   void handle(int x,int y,int x2,int y2);

    public static void setEasel(Easel easel)
    {
        AbstractHandler.easel = easel;
    }
}
