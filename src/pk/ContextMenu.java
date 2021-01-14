package pk;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *  ContextMenu for selection tool
 * @author Rahul B.
 * @version 0.1.
 */
public class ContextMenu extends JPopupMenu
{
    public ContextMenu()
    {
        add(new Actions.Copy("Copy"));
        add(new Actions.Paste("Paste"));
    }
}
