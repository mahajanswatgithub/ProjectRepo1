import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import timescreen.*;
import HtmlSetting.HtmlStyle;
import myUtility.*;
import javax.swing.border.*;
import DBReport.*;
import InputRestriction.*;

class FrmDemo extends JFrame //implements ActionListener
{
	//int w = 3020;
	TimeScreen2 ES;
	FrmDemo()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();



		setSize(screenSize.width,screenSize.height);
		ES = new TimeScreen2();
		add(ES);




		show();



	}



   public static void main(String args[])
   {
        FrmDemo A = new FrmDemo();
   }

}