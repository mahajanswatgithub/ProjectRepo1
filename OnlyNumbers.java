package InputRestriction;
import java.awt.event.*;
//import java.awt.peer.*;
import java.awt.Toolkit.*;
import java.awt.*;
import javax.swing.*;
public class OnlyNumbers extends KeyAdapter
{
	public void keyTyped(KeyEvent ke)
	{
		char c = ke.getKeyChar();
		if(!((c >= '0')&&(c <= '9')) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))
		{
			Toolkit a= Toolkit.getDefaultToolkit();
			a.beep();
			ke.consume();
		}
	}
}