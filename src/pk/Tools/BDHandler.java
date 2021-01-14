package pk.Tools;


import java.awt.*;
/**
 * NOTE: THIS CLASS IS NOT USED AS IT IS NOT DEVELOPED
 */
public class BDHandler extends AbstractHandler
{
    public   void handle(int x,int y, int x1, int y1)
   {
       int w = 15;
       int h = 15;
       Easel hr = AbstractHandler.easel;
       for(int  j=0;j<h;j++)
       for(int i=0;i<w;i++)
       {
           hr.image.setRGB(x+i,y+j,(new Color(hr.image.getRGB(x+i,y+j)).darker()).getRGB());
       }
   }
}
