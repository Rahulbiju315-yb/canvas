package pk.Tools;

import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.*;
import java.io.*;
import java.awt.image.*;

/**
 *  This class handles copying to and from the clipboard
 * @author Rahul B.
 * @version 0.1.
 */
public class CopyHandler implements ClipboardOwner
{
    /**
     *  Copies the image (bim parameter) to the system clipboard
     */
    public void copyImage(BufferedImage bim)
    {
        TransferableImage tim = new TransferableImage(bim);
        
        Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
        c.setContents(tim,this);
    }

    public void lostOwnership(Clipboard c,Transferable t)
    {
    }
    
    /**
     * This function return an object of type image from the system clipboard. 
     */
    public Image getImageFromClipboard()
    {
        Transferable transferable = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
        if (transferable != null && transferable.isDataFlavorSupported(DataFlavor.imageFlavor))
        {
            try
            {
                return (Image) transferable.getTransferData(DataFlavor.imageFlavor);
            }
            catch (UnsupportedFlavorException e)
            {
                // handle this as desired
                e.printStackTrace();
            }
            catch (IOException e)
            {
                // handle this as desired
                e.printStackTrace();
            }
        }
        else
        {
            System.err.println("getImageFromClipboard: That wasn't an image!");
        }
        return null;
    }
    private class TransferableImage implements Transferable {

        Image i;

        public TransferableImage( Image i ) {
            this.i = i;
        }

        public Object getTransferData( DataFlavor flavor )
        throws UnsupportedFlavorException, IOException {
            if ( flavor.equals( DataFlavor.imageFlavor ) && i != null ) {
                return i;
            }
            else {
                throw new UnsupportedFlavorException( flavor );
            }
        }

        public DataFlavor[] getTransferDataFlavors() {
            DataFlavor[] flavors = new DataFlavor[ 1 ];
            flavors[ 0 ] = DataFlavor.imageFlavor;
            return flavors;
        }

        public boolean isDataFlavorSupported( DataFlavor flavor ) {
            DataFlavor[] flavors = getTransferDataFlavors();
            for ( int i = 0; i < flavors.length; i++ ) {
                if ( flavor.equals( flavors[ i ] ) ) {
                    return true;
                }
            }

            return false;
        }
    }
}
