package pk.Tools.GUIFractal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;


public class PointPlotter extends JPanel
{
   BufferedImage bim;
   Graphics2D g2d;
   
   double flen,rotation,randF,reductF;
   
   double dir,x,y;
   public PointPlotter(double flen,double rotation,double randF,double reductF)
   {
       this.flen = flen;
       this.rotation = rotation;
       this.randF = randF;
       this.reductF = reductF;
       
       x = 200;
       y = 200;
   }
   
   public void plot(char ch)
   {
      if(ch == 'F')
      {
          double rad = (Math.PI/180 * dir),
                               dx = flen *Math.cos(rad),
                               dy = flen *Math.sin(rad);
          
          
          g2d.drawLine((int)x,(int)y,(int)(x+dx),(int)(y+dy));
          x+=dx;
          y+=dy;
      }
      else if(ch == 'f')
      {
          double rad = (Math.PI/180 * dir),
                               dx = flen *Math.cos(rad),
                               dy = flen *Math.sin(rad);
          x+=dx;
          y+=dy;
      }
      else if(ch == '+' || ch == '>')
      {
          dir+=rotation;
      }
      else if(ch == '-' || ch == '<')
      {
          dir-=rotation;
      }
   }
   
   @Override
   public void paint(Graphics g)
   {
       if(bim==null)
       {
           bim = new BufferedImage(400,400,BufferedImage.TYPE_INT_RGB);
           g2d =(Graphics2D) bim.getGraphics();
       }
       g.drawImage(bim,0,0,null);
   }
}
