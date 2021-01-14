package pk.Tools;
import pk.Resize.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.*;
/**
 *  THIS CLASS IS NOT USED
 */
public class Resizable2 extends JPanel
{
    public BufferedImage bim ;
    
    public int w,h,wid,hei;
    
    public Resizable2()
    {
        
    }
    public void setArea(int w,int h)
    {
        this.w=w;
        this.h=h;

        wid = w;
        hei = h;
    }

    @Override
    public void paint(Graphics g)
    {
        try{

            g.drawImage(bim.getSubimage(0,0,w,h),0,0,getWidth(),getHeight(),null);
            g.drawRect(0,0,getWidth()-1,getHeight()-1);
        }catch(Exception ex){System.out.println("ERRR");}
    }
}