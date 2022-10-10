package InputRestriction;
import java.awt.event.*;
import java.awt.peer.*;
import java.awt.Toolkit.*;
import java.awt.*;
import java.awt.event.FocusListener;
import javax.swing.*;
public class NumberLimit implements FocusListener
{
	int limit;
	public NumberLimit(int limit)
	{
		this.limit=limit;
	}
	public void focusLost(FocusEvent fe)
	{
		JTextField t=(JTextField)fe.getSource();
		try
		{
			if(Integer.parseInt(t.getText())>limit)
			{
				//t.setText("");
				t.setBackground(Color.red);
				t.setForeground(Color.yellow);
				JOptionPane.showMessageDialog(null,"Invalid");
				timePass(2000);
				t.setBackground(Color.white);
				t.setForeground(Color.black);
				t.setText("");
				//t.selectAll();
//				t.setForeground(Color.black);
				t.requestFocus();

			}
		}
		catch(NumberFormatException e)
		{
			if(t.getText().equals("ERR"))
			{}
				//timePass(1200);
		}
	}
	public void focusGained(FocusEvent fe)
	{
		JTextField t=(JTextField)fe.getSource();
		t.selectAll();

	}
	void timePass(int msec)
	{
		try
		{
			Thread.sleep(msec);
		}
		catch(InterruptedException e)
		{

		}
	}
}