package pk.Tools;



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *  The fractal painter.
 *  The actula painting of fractals happen here.
 *  The following are the commands used as of now....<br>
 *  F :- Move forward by the method parameter len and draw.<br>
 *  f :- Move forward by the method parameter len without drawing.<br>
 *  + :- Increment dir by the factor specified in the variable rotation.<br>
 *  - :- Decrement dir by the factor specified in the variable rotation.<br>
 *  > :- Increment dir by a random multiple of the rotation variable<br>
 *  < :- Decrement dir by a random multiple of the rotation variable
 *  
 *  @author Rahul B.
 * @version 0.1.
 */
public class Fractal 
{
    int maxX,maxY;
    public String axiom,strF,strf,strX,strY;
    public int level =7;
    public double xLast,yLast,dir,rotation,dirStart,fxStart,fyStart,lengthFract,reductFact,dirLast;
    public double randF =0.0;
    String in;
    int dep;double lens;
    
    /**
     * Converts continuous to discrete cordinates.
     */
    int iX(double x){return (int)(Math.round(x));}
    int iY(double y){return (int)(Math.round(maxY-y));}
    
    /**
     * Coverts discrete to continuous cordinates.
     */
    public double fx(double x){return      (Math.round(x));}
    public double fy(double y){return      (Math.abs(y - maxY));}
    
    public Fractal()
    {
        maxY =1500;
        
    }
    
    void moveTo(double x,double y)
    {
        xLast = x;
        yLast = y;
    }
    
    void lineTo(Easel g,double x,double y)
    {
        g.setColor(ColorModel.color);
        g.drawLine(iX(xLast),iY(yLast),iX(x),iY(y));
        xLast = x;
        yLast = y;
    }
    
    public void fractals(Easel e,String instruction,int depth,double len)
    {
        double xMark =0,yMark =0,dirMark =0;
        Graphics g = e.image.getGraphics();
        
        //System.out.println("axiom"+axiom);
        //System.out.println("length fr"+lengthFract);
        //System.out.println("fx"+fxStart);
        for(int i= 0;i<instruction.length();i++)
        {
            char ch = instruction.charAt(i);
            switch(ch)
            {
                case 'F':
                    if(depth == 0)
                    {
                        double rad = (Math.PI/180 * dir),
                               dx = len *Math.cos(rad),
                               dy = len *Math.sin(rad);
                        lineTo(e,xLast+dx,yLast +dy);
                    }
                    else
                       fractals(e,strF,depth -1,reductFact * len);
                       break;
                case 'f':
                    if(depth == 0)
                    {
                        double rad =(double) (Math.PI/180 * dir),
                               dx = len * (double)Math.cos(rad),
                               dy = len * (double)Math.sin(rad);
                        
                        moveTo(xLast+dx,yLast +dy);
                    }
                     else
                       fractals(e,strf,depth -1,reductFact * len);
                       break;
                case 'X':
                    if(depth >0)
                       fractals(e,strX,depth -1,reductFact * len);
                       break;
                case 'Y':
                    if(depth >0)
                       fractals(e,strY,depth-1,reductFact *len);
                       break;
                case '+':
                    dir -=rotation;break;
                
                case '-':
                    dir += rotation;break;
                case '[':
                    xMark = xLast;yMark = yLast;dirMark =dir;break;
                case ']':
                    xLast = xMark;yLast = yMark;dir = dirLast;break;
                    
                case '>':
                    dir+=(Math.random()*randF+rotation);break;
                
                case '<':
                    dir-=(Math.random()*randF+rotation);break;
            }
    
        }
        Resource.frame.repaint();
    }
    
    public void fractals(Easel e)
    {
        double xMark =0,yMark =0,dirMark =0;
        Graphics g = e.image.getGraphics();
        
        //System.out.println("axiom"+axiom);
        //System.out.println("length fr"+lengthFract);
        //System.out.println("fx"+fxStart);
        for(int i= 0;i<in.length();i++)
        {
            char ch = in.charAt(i);
            switch(ch)
            {
                case 'F':
                    if(dep == 0)
                    {
                        double rad = (Math.PI/180 * dir),
                               dx = lens *Math.cos(rad),
                               dy = lens *Math.sin(rad);
                        lineTo(e,xLast+dx,yLast +dy);
                    }
                    else
                       fractals(e,strF,dep -1,reductFact * lens);
                       break;
                case 'f':
                    if(dep == 0)
                    {
                        double rad =(double) (Math.PI/180 * dir),
                               dx = lens * (double)Math.cos(rad),
                               dy = lens * (double)Math.sin(rad);
                        
                        moveTo(xLast+dx,yLast +dy);
                    }
                     else
                       fractals(e,strf,dep -1,reductFact * lens);
                       break;
                case 'X':
                    if(dep >0)
                       fractals(e,strX,dep -1,reductFact * lens);
                       break;
                case 'Y':
                    if(dep >0)
                       fractals(e,strY,dep-1,reductFact *lens);
                       break;
                case '+':
                    dir -=rotation;break;
                
                case '-':
                    dir += rotation;break;
                case '[':
                    xMark = xLast;yMark = yLast;dirMark =dir;break;
                case ']':
                    xLast = xMark;yLast = yMark;dir = dirLast;break;
                    
                case '>':
                    dir+=(Math.random()*randF+rotation);break;
                
                case '<':
                    dir-=(Math.random()*randF+rotation);break;
            }
    
        }
        Resource.frame.repaint();
        //fractals(e,in,dep,lens);
    }
}
