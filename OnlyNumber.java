package InputRestriction;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class OnlyNumber extends KeyAdapter
{
	public void KeyType(KeyEvent ke)
	{
		char c=ke.getKeyChar();
		if(!((c>='0')&&(c<='9')) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE))
		{
			Toolkit a=Toolkit.getDefaultToolkit();
			a.beep();
			ke.consume();
		}
	}
}