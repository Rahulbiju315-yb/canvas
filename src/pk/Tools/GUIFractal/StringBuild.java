package pk.Tools.GUIFractal;


/**
 * THIS PACKAGE IS UNDER DEVELOPEMENT
 */
public class StringBuild
{
    String instruction ="";
    public StringBuild()
    {
    }
    
    public void append(char ch)
    {
        instruction += ch;
    }
    
    public String getString()
    {
        return instruction;
    }
}
