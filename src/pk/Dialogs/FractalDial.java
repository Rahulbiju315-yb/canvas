package pk.Dialogs;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import pk.Tools.*;

/**
 * Dialog box for defining fractals.<br>
 * The variables axiom,F-string,f-string,X-string,Y-String,Rotation angle,Initial Direction,F length,Reduction Factor,Level,Random Factor are accepted and then their value in the Fractal object of 
 * the easel class are set.
 * Before showing the dialog box,the initial values of all fields are initialised to the current loaded fractal.
 * 
 * @author Rahul B.
 * @version 0.1.
 */
public class FractalDial
{
    String axiom,strF,strf="",strX,strY;
    float rotation,dirStart,fxStart,fyStart,lengthFract,reductFact,ran=0;

    JTextField[] str = new JTextField[5];
    JTextField[] flt= new JTextField[5];
    JTextField igr = new JTextField();
    String[] label ={"Axiom:","F-String","f-String","X-String","Y-String","Rotation angle","Initial Direction","F length","Reduction Factor","Level","Random Factor"};

    public FractalDial()
    {
        for(int i=0;i<5;i++)
        {
            str[i] = new JTextField(10);
        }
        for(int i=0;i<5;i++)
        {
            flt[i] = new JTextField(10);
        }
        igr = new JTextField(10);
    }

    /**
     *  Initialise all text field values to the corresponding values of the already loaded fractals
     */
    public void init(String s[])
    {
        JTextField[] comp ={str[0],str[1],str[2],str[3],str[4],
                flt[0],flt[1],flt[2],flt[3],igr,flt[4]};

        for(int i=0;i<s.length;i++)
        {
            if(s[i] .equals(""))str[i].setText("null");
            comp[i].setText(s[i]);
            System.out.println(i);
        }
    }

    /**
     * Shows the fractal dialog box
     */
    public void show()
    {
        try{
            init(new String[]{AbstractHandler.easel.frc.axiom,AbstractHandler.easel.frc.strF,AbstractHandler.easel.frc.strf,AbstractHandler.easel.frc.strX,AbstractHandler.easel.frc.strY
                ,""+AbstractHandler.easel.frc.rotation,""+AbstractHandler.easel.frc.dirStart,""+ (double) Math.round(AbstractHandler.easel.frc.lengthFract * 100) / 100,""+ (double)Math.round(AbstractHandler.easel.frc.reductFact*100)/ 100,
                    ""+AbstractHandler.easel.frc.level,""+AbstractHandler.easel.frc.randF});//initialse text field
                }catch(Exception ex){}
        JTextField[] comp ={str[0],str[1],str[2],str[3],str[4],
                flt[0],flt[1],flt[2],flt[3],
                igr,flt[4]};
        JPanel pa = new JPanel();
        JPanel r[] = new JPanel[12];
        pa.setLayout(new BoxLayout(pa,BoxLayout.Y_AXIS));
        for(int i=0;i<11
        ;i++)
        {
            r[i]= new JPanel();
            r[i].add(new JLabel(label[i]));
            r[i].add(comp[i]);
            pa.add(r[i]);//add all component to the panel.
        }                    
        int a ; 
        a = JOptionPane.showConfirmDialog(Resource.frame,pa);
        if(a == JOptionPane.YES_OPTION)
        {
            axiom = str[0].getText();
            strF  = str[1].getText();
            strf  = str[2].getText();
            strX  = str[3].getText();
            strY  = str[4].getText();

            rotation = Float.parseFloat(flt[0].getText());
            dirStart = Float.parseFloat(flt[1].getText());
            lengthFract = Float.parseFloat(flt[2].getText());
            reductFact = Float.parseFloat(flt[3].getText());
            ran        = Float.parseFloat(flt[4].getText());
            
            AbstractHandler.easel.frc.axiom = axiom;     
            AbstractHandler.easel.frc.strF  = strF;
            AbstractHandler.easel.frc.strf  = strf;
            AbstractHandler.easel.frc.strX  = strX;
            AbstractHandler.easel.frc.strY  = strY;

            AbstractHandler.easel.frc.rotation =rotation;
            AbstractHandler.easel.frc.dirStart =dirStart;
            AbstractHandler.easel.frc.dir =dirStart;
            //AbstractHandler.easel.frc.fxStart  =AbstractHandler.easel.frc.fx(fxStart) ;
            //AbstractHandler.easel.frc.fyStart  =AbstractHandler.easel.frc.fy(fyStart) ;

            //AbstractHandler.easel.frc.xLast  =AbstractHandler.easel.frc.fx(fxStart) ;
            //AbstractHandler.easel.frc.yLast  =AbstractHandler.easel.frc.fy(fyStart) ;

            System.out.println(AbstractHandler.easel.frc.fxStart +"\n"+AbstractHandler.easel.frc.fyStart);
            AbstractHandler.easel.frc.lengthFract =lengthFract;
            AbstractHandler.easel.frc.randF =ran;
            AbstractHandler.easel.frc.reductFact =reductFact;
            AbstractHandler.easel.frc.level      = Integer.parseInt(igr.getText());  
            //AbstractHandler.easel.drfr();

            //FractalIO.write(new String[]{axiom,strF,strf,strX,strY,""+rotation,""+dirStart,""+lengthFract,""+reductFact,igr.getText(),"Name_test"});
        }
    }
}
