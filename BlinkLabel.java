package myUtility;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class BlinkLabel extends Thread
{
	JLabel currentLabel;
	int speed;

	public BlinkLabel(JLabel currentLabel,int speed)
	{
		this.currentLabel=currentLabel;
		this.speed=speed;
	}
	public void run()
	{
		while(true)
		{
			startBlinking();
		}
	}
	public void startBlinking()
	{

		try
		{
			currentLabel.setVisible(!(currentLabel.isVisible()));
			Thread.sleep(speed);
		}
		catch(Exception e)
		{

		}
	}
}

