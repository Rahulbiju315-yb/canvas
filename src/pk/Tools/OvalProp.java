package pk.Tools;




import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.border.*;

/**
 * Propeties panel for oval tool<br>
 * Component Description<br>
 * ----------------------<br>
 * posBased   :- Checkbox to set drawing method to position based.<br>
 * speedBased :- Checkbox to set drawing method to speed based<br>
 * 
 * @author Rahul B.
 * @version 0.1.
 */
public class OvalProp extends JPanel
{
    JRadioButton speedBased = new JRadioButton("SPEED BASED",true);
    JRadioButton posBased   = new JRadioButton("POSITION BASED",false);
    JRadioButton normal     = new JRadioButton("NORMAL",false);
    JRadioButton filled     = new JRadioButton("FILLED?");
    public OvalProp()
    {
        posBased.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                 Properties.OvalProp.selected = Properties.OvalProp.POS_BASED;
            }
        });
        speedBased.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Properties.OvalProp.selected = Properties.OvalProp.SPEED_BASED;
            }
        });
        normal.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {  
                    Properties.OvalProp.selected = Properties.OvalProp.NORMAL;
                }
            });
        filled.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Properties.OvalProp.filled = !Properties.OvalProp.filled;
            }
        });
        
        
        ButtonGroup g = new ButtonGroup();
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        g.add(posBased);
        g.add(speedBased);
        g.add(normal);
        
        add(posBased);
        add(speedBased);
        add(normal);
        add(filled);
        
        setBorder(new BevelBorder(BevelBorder.RAISED));
    }
    
    public int getSelected()
    {
        if(posBased.isSelected()) return 1;
        else return 2;
    }
    public void update()
    {
        repaint();
    }
}
