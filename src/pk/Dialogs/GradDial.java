package pk.Dialogs;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import pk.Tools.*;

/**
 * Displays gradient dialog box.
 * Component description<br>
 * =======================<br>
 * chooser1   :- Button for choosing first color
 * chooser2   :- Button for choosing second color
 * direction  :- JComboBox for choosing direction of gradient
 * cyclic     :- JRadioButton for specifying whether gradient is cyclic
 * 
 * @author Rahul B.
 * @version 0.1.
 */
public class GradDial
{
    Color c1 =Color.white;
    Color c2 = Color.white;
    
    boolean isCyclic = false;
    public Color[] show(JPanel pan)
    {
        
        
        Box box = Box.createVerticalBox();
        box.add(Box.createVerticalStrut(10));
        
        JPanel hp1 = new JPanel();
        hp1.setLayout(new BoxLayout(hp1,BoxLayout.X_AXIS));
        JPanel hp2 = new JPanel();
        hp2.setLayout(new BoxLayout(hp2,BoxLayout.X_AXIS));
        
        JButton chooser1 = new JButton("CHOOSE");
        JButton chooser2 = new JButton("CHOOSE");
        
        JTextField field1 = new JTextField(10);
        JTextField field2 = new JTextField(10);
        field1.setEditable(false);
        field2.setEditable(false);
        
        JComboBox  direction = new JComboBox();
        direction.addItem("HORIZONTAL");
        direction.addItem("VERTICAL");
        direction.addItem("LEFT DIAGONAL");
        direction.addItem("RIGHT DIAGONAL");
        
        JRadioButton cyclic = new JRadioButton("Cyclic",false);
        
        chooser1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                c1 = JColorChooser.showDialog(pan,"Choose",Color.black);
                field1.setText(""+c1.getRGB());
            }
        });
        
        chooser2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                c2 = JColorChooser.showDialog(pan,"Choose",Color.black);
                field2.setText(""+c2.getRGB());                
            }
        });
        
        direction.addItemListener(new ItemListener()
        {
            public void itemStateChanged(ItemEvent e)
            {
                if(e.getStateChange() == ItemEvent.SELECTED)
                {
                    Easel es = AbstractHandler.easel;
                    if(e.getItem().toString().equals("HORIZONTAL"))es.setGradDir(Easel.HORIZONTAL);
                    else if(e.getItem().toString().equals("VERTICAL"))es.setGradDir(Easel.VERTICAL);
                    else if(e.getItem().toString().equals("LEFT DIAGONAL"))es.setGradDir(Easel.L2R_DIAGONAL);
                    else                                                   es.setGradDir(Easel.R2L_DIAGONAL);
                }
            }
        });
        
        cyclic.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Easel es = AbstractHandler.easel;
                isCyclic = !isCyclic;
                es.setCyclic(isCyclic);
            }
        });
        hp1.add(chooser1);
        hp1.add(field1);
        
        hp2.add(chooser2);
        hp2.add(field2);
        
        box.add(hp1);
        box.add(hp2);
        
        box.add(direction);
        
        box.add(cyclic);
        
        int a = JOptionPane.showConfirmDialog(pan,box);
        
        Color[] fin ={c1,c2};
        
        return a==JOptionPane.OK_OPTION?fin:null;
    }
}