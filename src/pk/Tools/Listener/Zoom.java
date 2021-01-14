package pk.Tools.Listener;




/**
 * This class contains functions which help in zooming.
 * 
 * @author Rahul B.
 * @version 0.1.
 */
public class Zoom
{
    public static  double zoomFactor =1;
    

    /**
     * Sets the zoom factor
     */
    public void setZoomFactor(double zf)
    {
        zoomFactor =zf;
    }
    
    /**
     * Converts the cordinates according to the zoom factor 
     */
    public static int toScreen(double wc)
    {
        int scor = (int)Math.round(wc/zoomFactor);
        return scor;
    }
}
