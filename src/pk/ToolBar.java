package pk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import pk.Tools.*;
import pk.Panel.*;
import javax.swing.event.*;
import java.awt.geom.*;
import pk.Dialogs.*;

/**
 * This diplays the top toolbar with different buttons like<br>
 * clear      :- clear working space<br>
 * background :- choose gradient background<br>
 * open       :- open saved image<br>
 * save       :- save current image<br>
 * undo       :- undo last change<br>
 * redo       :- redo last change<br>
 * tools      :- displays tools popup menu<br>
 * palette    :- displays color palette<br>
 * slider1 and slider2 are not used
 * 
 * @author Rahul B.
 * @version 0.1.
 */
public class ToolBar extends JTabbedPane
{

    JPanel p;
    
    public ToolBar(JPanel panel,PropertiesBar bar,Main fr)
    {
        p =panel;
        JPanel file = new JPanel();
        file.setLayout(new BoxLayout(file,BoxLayout.X_AXIS));

        JButton clear = new JButton(new ImageIcon("icons/clear.png"));
        clear.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    Color temp = ColorModel.color;
                    ColorModel.color = Color.white;
                    AbstractHandler.easel.drawRect(true,0,0,AbstractHandler.easel.image.getWidth(),AbstractHandler.easel.getHeight());   
                    fr.repaint();
                    ColorModel.color = temp;
                }
            });
        clear.setText("Clear");

        

        JButton undo = new JButton(new ImageIcon("icons/undo.png"));
        undo.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    AbstractHandler.easel.undo();
                    Resource.frame.repaint();
                }
            });
        undo.setText("Undo");

        JButton redo = new JButton(new ImageIcon("icons/redo.png"));
        redo.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    AbstractHandler.easel.redo();
                    Resource.frame.repaint();
                }
            });
        redo.setText("Redo");

        JButton tools = new JButton(new ImageIcon("icons/tools.png"));
        tools.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    (new ToolsMenu()).show(ToolBar.this,5,getHeight());
                    try{
                        
                        Resource.c.remove(Resource.c.jp);
                        AbstractHandler.easel.image.getGraphics().drawImage(Resource.c.ip.bim.getSubimage(0,0,Resource.c.ip.w,Resource.c.ip.h),Resource.c.jp.getLocation().x,Resource.c.jp.getLocation().y,Resource.c.jp.getWidth(),Resource.c.jp.getHeight(),null);
                    }catch(Exception ex){}
                }
            });
        tools.setText("Tools");

        JButton colorPalette = new JButton(new ImageIcon("icons/palette.png"));
        colorPalette.addActionListener( new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    ColorPalette pal = new ColorPalette(p);
                    pal.show();
                    bar.setColor(ColorModel.color);
                }
            });
        colorPalette.setText("Palette");

        JButton open = new JButton(new ImageIcon("icons/open.png"));
        open.addActionListener( new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    open_fun f = new open_fun(p,fr);
                    f.openMenu();
                }
            });
        open.setText("Open");

        JButton save = new JButton(new ImageIcon("icons/save.png"));
        save.addActionListener( new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    save_fun f = new save_fun(p);
                    f.show();
                }
            });
        save.setText("Save");

        JButton background = new JButton(new ImageIcon("icons/grad.png"));
        background.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    pk.Dialogs.GradDial gd = new pk.Dialogs.GradDial();
                    Color[] c1 =gd.show(p);
                    if(c1!=null)AbstractHandler.easel.fillGrad(c1[0],c1[1]);
                    p.repaint();
                }
            });
        background.setText("Gradient");

        JSpinner slider2 = new JSpinner(new SpinnerNumberModel(.0,0.0,20.0,0.1));
        JSpinner slider = new JSpinner(new SpinnerNumberModel(.0,0.0,20.0,0.1));

        slider.addChangeListener(new ChangeListener()
            {
                public void stateChanged(ChangeEvent e)
                {
                    //Canvas.curSh = AffineTransform.getShearInstance((Double)slider.getValue(),(Double)slider2.getValue());
                    p.repaint();
                }
            });

        slider2.addChangeListener(new ChangeListener()
            {
                public void stateChanged(ChangeEvent e)
                {
                    //Canvas.curSh = AffineTransform.getShearInstance((Double)slider.getValue(),(Double)slider2.getValue());
                    p.repaint();
                }
            });

        

        file.add(tools);
        file.add(undo);
        file.add(redo);
        file.add(colorPalette);
        file.add(open);
        file.add(save);
        file.add(background);

        file.add(clear);
        addTab("File",file);

        
        
        
    }
}
