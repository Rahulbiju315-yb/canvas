package pk.Tools;




import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.border.*;

/**
 *  Stores properties of pencil tool.
 *  Like the current selected pencil type.
 *  Changes in selection are send to Properties.PencilProp.selected variable
 *  
 * @author Rahul B.
 * @version 0.1.
 */
public class PencilProp extends JPanel
{
    JRadioButton normal= new JRadioButton("NORMAL",true);
    JRadioButton caligraphic = new JRadioButton("CALIGRAPHIC",false);
    JRadioButton spike= new JRadioButton("SPIKE",false);
    JRadioButton tangled= new JRadioButton("TANGLED",false);
    JRadioButton wavy= new JRadioButton("WAVY",false);
    JRadioButton ribbon= new JRadioButton("RIBBONS",false);
    JRadioButton splosh= new JRadioButton("SPLOSH",false);
    JRadioButton grass= new JRadioButton("GRASS",false);
    //JRadioButton filled = new JRadioButton("FILLED?");
    public PencilProp()
    {
        splosh.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Properties.PencilProp.selected = Properties.PencilProp.SPLOSH;
            }
        });
        
        normal.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Properties.PencilProp.selected = Properties.PencilProp.NORMAL;
            }
        });
        caligraphic.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Properties.PencilProp.selected = Properties.PencilProp.CALIGRAPHIC;
            }
        });
        spike.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Properties.PencilProp.selected = Properties.PencilProp.SPIKE;
            }
        });
        tangled.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Properties.PencilProp.selected = Properties.PencilProp.TANGLED;
            }
        });
        wavy.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Properties.PencilProp.selected = Properties.PencilProp.WAVY;
            }
        });
        ribbon.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Properties.PencilProp.selected = Properties.PencilProp.RIBBON;
            }
        });
        
        grass.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Properties.PencilProp.selected = Properties.PencilProp.GRASS;
            }
        });
        
        ButtonGroup g = new ButtonGroup();
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        g.add(normal);
        g.add(caligraphic);
        g.add(tangled);
        g.add(spike);
        g.add(wavy);
        g.add(ribbon);
        g.add(splosh);
        g.add(grass);
        
        add(normal);
        add(caligraphic);
        add(tangled);
        add(spike);
        add(wavy);
        add(ribbon);
        add(splosh);
        add(grass);
        
        setBorder(new BevelBorder(BevelBorder.RAISED));
    }
    
    
    public void update()
    {
        repaint();
    }
    
}
