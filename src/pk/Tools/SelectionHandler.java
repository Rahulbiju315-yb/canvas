package pk.Tools;

import java.awt.*;
import java.awt.image.*;

import pk.Resize.*;

/**
 *  @author Rahul B.
 *  The handler for the selection tool.
 */
public class SelectionHandler extends AbstractHandler
{
    int xx,yy;
    int lxx,lyy;
    public static boolean drag = false;
    public static int state =2;

    public static SelectionPanel sp = null;
    BufferedImage mem = new BufferedImage(easel.image.getWidth(),easel.image.getHeight(),BufferedImage.TYPE_INT_RGB);
    public void handle(int x,int y,int x1,int y1)
    {
        int sx=Properties.SelectionProp.x;
        int sy=Properties.SelectionProp.y;
        System.out.println("HANDLED");
        if(!drag)//ie when the selection hasnt already took place
        {
            Point p1 = new Point(x,y);
            Point p2 = new Point(x1,y1);

            xx = Math.min(sx,x);
            yy = Math.min(sy,y);

            lxx=Math.max(sx,x);
            lyy=Math.max(sy,y);

            TGraph.g.setColor(Color.black);
            TGraph.g.drawRect(xx,yy,lxx-xx,lyy-yy);//Draws the selection border
            Resource.frame.repaint();


            if(!(lxx-xx==0) &&!(lyy-yy==0) && (lyy<easel.image.getHeight()) && (lxx<easel.image.getWidth()))
                try{
                    mem.getGraphics().drawImage(easel.image.getSubimage(xx,yy,(lxx-xx),(lyy-yy)),0,0,null);//draws selection to offscreen image
                }catch(Exception ex){System.exit(-1);}
            System.out.print("if");
        }
        else
        {
            System.out.print("else");
            if(sp == null)
            {
                try{
                    int a = pk.Tools.ColorModel.color.getRGB();
                    pk.Tools.ColorModel.color  = Color.white;
                        
                        
                    
                    sp = new SelectionPanel(lxx-xx,lyy-yy);//Selection Panel for displaying the selecteed image as it is dragged.
                    sp.bim = mem;
                    sp.setArea(lxx-xx,lyy-yy);
                    AbstractHandler.easel.image.getGraphics().fillRect(xx,yy,lxx-xx,lyy-yy);//Fill the selected area white to "remove" the selected part.
                    Resource.frame.repaint();
                    
                    Resizable r = new Resizable(sp);//Resizabele JComponent for dragging,resizing the selectionPanel
                    r.setBounds(xx,yy,lxx-xx+5,lyy-yy+5);//Setting the bounds to the bounds of SelectionPanel

                    
                    Resource.c.add(r);//Adding the Resizable component to Canvas
                    Resource.c.setResizable(r);//Setting r as the Resizable component of Canvas
                    Resource.c.setPanel(sp);
                    
                    pk.Tools.ColorModel.color = new Color(a);
                }catch(Exception ex){drag = false;}
            }
        }
    }
}

