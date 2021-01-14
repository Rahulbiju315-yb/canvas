package pk.Tools;

import java.awt.image.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.event.*;
import pk.*;
import java.awt.geom.*;

/**
 * SelectionPanel is used to copy the selected part of image onto itself,then add it to a resizable component 
 * so that it may be dragged , resized ,etc..
 * 
 * @author Rahul B.
 * @version 0.1.
 */
public class SelectionPanel extends JPanel
{
    public BufferedImage bim;
    public int w,h;

    public CopyHandler c = new CopyHandler();
    int wid,hei;
    public int ox=-1,oy=-1,nx,ny;

    final int UL = 1;
    final int UR = 2;
    final int LL = 3;
    final int LR = 4;

    int sel      =-1;

    private boolean drag = false;
    private Point dragLocation  = new Point();
    
    /**
     * constructor.
     * a => Width of copy area
     * b => Height of copy area
     */
    public SelectionPanel(int a,int b)
    {
        bim = new BufferedImage(a,b,BufferedImage.TYPE_INT_RGB);
    }

    /**
     * Set area of the copy area
     */
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
            g.drawImage(bim.getSubimage(0,0,wid,hei),0,0,getWidth(),getHeight(),null);//draw image
            g.drawRect(0,0,getWidth()-1,getHeight()-1);
        }catch(Exception ex){System.out.println("ERRR");}
    }

    /**
     * Copy image from the selection panel to the clipboard
     */
    public void copy()
    {
        BufferedImage after = new BufferedImage(wid, hei, BufferedImage.TYPE_INT_ARGB);
        AffineTransform at = new AffineTransform();
        at.scale(getWidth()/wid, getHeight()/hei);
        AffineTransformOp scaleOp = 
            new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
        after = scaleOp.filter(bim.getSubimage(0,0,wid,hei) , after);
        c.copyImage(bim.getSubimage(0,0,wid,hei));
    }
}
