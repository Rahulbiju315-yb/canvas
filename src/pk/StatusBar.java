package pk;


import javax.swing.*;
import javax.swing.border.*;
import pk.Tools.*;
import javax.swing.event.*;
import java.awt.*;
import pk.Tools.Listener.*;

/**
 *  Status bar to display Mouse Position,change zoom factor,change Dimension etc.
 *  
 * @author Rahul B.
 * @version 0.1.
 */
public class StatusBar extends JPanel
{
    int width = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    int height = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();

    JLabel pos  = new JLabel("1000:1000");//JLabel to display position
    JLabel zoom = new JLabel("1");//JLabel to display zoom
    JLabel wl    = new JLabel(""+width);//Width
    JLabel hl    = new JLabel(""+height);//Height
    
    JLabel thick = new JLabel("1");
    
    public StatusBar(ZoomListener zl,DimensionListener d,JFrame f)
    {

        JSlider sl1 = new JSlider(1,20,1);
        pos.setHorizontalAlignment(SwingConstants.LEFT);
        pos.setBorder(new BevelBorder(BevelBorder.RAISED));
        sl1.addChangeListener(new ChangeListener()
            {
                public void stateChanged(ChangeEvent e)
                {
                    Zoom.zoomFactor = sl1.getValue();
                    zl.zoomed((sl1.getValue()));
                    zoom.setText(sl1.getValue()+"");
                    f.repaint();
                }
            });

        Box box = Box.createHorizontalBox();
        box.add(Box.createHorizontalGlue());
        box.add(pos);
        add(box);
        box.add(Box.createHorizontalStrut(10));
        box.add(sl1);
        box.add(Box.createHorizontalStrut(10));
        box.add(zoom);

        JSlider w = new JSlider(5,1500,width);
        JSlider h = new JSlider(5,1500,height);
        w.addChangeListener(new ChangeListener()
            {
                public void stateChanged(ChangeEvent e)
                {
                    d.dimensionChanged(w.getValue(),h.getValue());
                    wl.setText(w.getValue()+"");
                }
            });

        
        h.addChangeListener(new ChangeListener()
            {
                public void stateChanged(ChangeEvent e)
                {
                    d.dimensionChanged(w.getValue(),h.getValue());
                    hl.setText(h.getValue()+"");
                }
            });
        //box.add(Box.createHorizontalStrut(10));
        
        JSlider lineThick = new JSlider(1,10,1);
        lineThick.addChangeListener(new ChangeListener()
        {
            public void stateChanged(ChangeEvent e)
            {
                (AbstractHandler.easel.g).setStroke(new BasicStroke(lineThick.getValue()));
                thick.setText(lineThick.getValue()+"");
            }
        });
        
        box.add(Box.createHorizontalStrut(30));
        box.add(new JLabel("Width:"));
        box.add(Box.createHorizontalStrut(10));
        box.add(w);
        box.add(wl);
        
        box.add(Box.createHorizontalStrut(30));
        box.add(new JLabel("Height:"));
        box.add(Box.createHorizontalStrut(10));
        box.add(h);
        box.add(hl);
        
        
        
        
        
        box.add(Box.createHorizontalStrut(30));
        box.add(new JLabel("Line Width:   "));
        box.add(lineThick);
        box.add(thick);
    }
}
