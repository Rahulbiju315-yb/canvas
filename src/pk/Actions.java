package pk;


/**
 * Defines Actions mainly for tools menu and ContextMenu
 * 
 * @author Rahul B.
 * @version 0.1.
 */

import java.awt.event.*;
import pk.Tools.*;
import pk.Tools.KeyboardAction.*;
import javax.swing.event.*;
import javax.swing.*;
import pk.Panel.*;
import pk.Resize.*;
import java.awt.*;
public class Actions
{
    static PropertiesBar bar;
    static void addPropertiesListener(PropertiesBar b)
    {
        bar = b;
    }
     static class SquareAction extends AbstractAction
     {
          public SquareAction(String text)
          {
               super(text);
               
          }
          public void actionPerformed(ActionEvent e)
            {
                ToolManager.setTool(SquareTool.SQUARE_TOOL);
                bar.update(ToolManager.getTool());
            }
     }
     
     static class OvalAction extends AbstractAction
     {
         public OvalAction(String text)
          {
               super(text);
              
          }
          public void actionPerformed(ActionEvent e)
            {
                ToolManager.setTool(OvalTool.OVAL_TOOL);
                bar.update(ToolManager.getTool());
            }
     }
     
     static class FWCAction extends AbstractAction
     {
         public FWCAction(String text)
          {
               super(text);
              bar.update(ToolManager.getTool());
          }
          public void actionPerformed(ActionEvent e)
            {
                ToolManager.setTool(FillWithColorTool.FWC_TOOL);
            }
     }
     
     static class PencilAction extends AbstractAction
     {
         public PencilAction(String text)
          {
               super(text);
              
          }
          public void actionPerformed(ActionEvent e)
            {
                ToolManager.setTool(PencilTool.PENCIL_TOOL);bar.update(ToolManager.getTool());
            }
     }
     static class PolygonAction extends AbstractAction
     {
         public PolygonAction(String text)
          {
               super(text);
              
          }
          public void actionPerformed(ActionEvent e)
            {
                ToolManager.setTool(PolygonTool.POLYGON_TOOL);bar.update(ToolManager.getTool());
            }
     }
     static class EraserAction extends AbstractAction
     {
         public EraserAction(String text)
          {
               super(text);
              
          }
          public void actionPerformed(ActionEvent e)
            {
                ToolManager.setTool(EraserTool.ERASER_TOOL);bar.update(ToolManager.getTool());
            }
     }
      static class MystifyAction extends AbstractAction
     {
         public MystifyAction(String text)
          {
               super(text);
              
          }
          public void actionPerformed(ActionEvent e)
            {
                ToolManager.setTool(MystifyTool.MYSTIFY_TOOL);bar.update(ToolManager.getTool());
            }
     }
     static class SelectionAction extends AbstractAction
     {
         public SelectionAction(String text)
          {
               super(text);
              
          }
          public void actionPerformed(ActionEvent e)
            {
                ToolManager.setTool(SelectionTool.SELECTION_TOOL);bar.update(ToolManager.getTool());
            }
     }
     static class TurtleAction extends AbstractAction
     {
         public TurtleAction(String text)
          {
               super(text);
              
          }
          public void actionPerformed(ActionEvent e)
            {
                Canvas.turtle = true;
                bar.update(ToolManager.getTool());
            }
     }
     static class BDAction extends AbstractAction
     {
         public BDAction(String text)
          {
               super(text);
              
          }
          public void actionPerformed(ActionEvent e)
            {
                 ToolManager.setTool(BDTool.BD_TOOL);bar.update(ToolManager.getTool());
            }
     }
     static class FractAction extends AbstractAction
     {
         public FractAction(String text)
          {
               super(text);
              
          }
          public void actionPerformed(ActionEvent e)
            {
                 ToolManager.setTool(FractTool.FRACT_TOOL);bar.update(ToolManager.getTool());
            }
     }
     static class Copy extends AbstractAction
     {
         public Copy(String text)
         {
             super(text);
         }
         
         public void actionPerformed(ActionEvent e)
         {
             Resource.c.ip.copy();
         }
     }
     static class Paste extends AbstractAction
     {
         public Paste(String text)
         {
             super(text);
         }
         
         public void actionPerformed(ActionEvent e)
         {
             Image im = Resource.c.ip.c.getImageFromClipboard();
             JPanel j = new JPanel()
             {
                 public Dimension getPreferredSize()
                 {
                     return new Dimension(im.getWidth(null),im.getHeight(null));
                 }
                 @Override
                 public void paint(Graphics g)
                 {
                     g.drawImage(im,0,0,getWidth(),getHeight(),null);
                 }
             };
             Resizable r = new Resizable(j);
             r.setBounds(0,0,j.getWidth(),j.getHeight());
             Resource.c.add(r);
         }
     }
}
