package pk.Tools;

import pk.Tools.KeyboardAction.*;

/**
 *  ToolManager manages selection of tools.<br>
 *  It returns the current selected tools,depending on the tools ID specified in specified in each tool.
 *          Format:TOOL_NAME.TOOLNAME_TOOL (type int)
 * 
 * @author Rahul B.
 * @version 0.1.
 */
public class ToolManager
{
   static AbstractTool tool =null;
   static private int selected;
   
   public static void setTool(int seltool)
   {
       selected  = seltool;
       
       switch(seltool)
       {
           case 0:tool = new SquareTool();break;
           case 1 :tool = new OvalTool();break;
           case 2 :tool = new FillWithColorTool();break;
           case 3 :tool = new SelectionTool();break;
           case 4 :tool = new PencilTool();break;
           case 5 :tool = new PolygonTool();break;
           case 6 :tool = new EraserTool();break;
           case 7 :tool = new MystifyTool();break;
           case 8 :tool = new TurtleTool();break;
           case 9 :tool = new BDTool();break;
           case 10:tool = new FractTool();break;
       }
   }
   
   /**
    *  Gets the tool id of the curent selected tool
    */
   public static int  getTool()
   {
       return selected;
   }
   
   /**
    *  Returns an AbstractTool of the current selected tool.
    */
   public static AbstractTool  getAsTool()
   {
       return  tool;
   }
   
}
