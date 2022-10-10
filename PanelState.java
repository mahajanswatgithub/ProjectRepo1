package myUtility;
import javax.swing.*;
import java.awt.*;

public class PanelState
{
	public static void enabledComponents(JPanel temp)
	{
		for(Component c:temp.getComponents())
		{
			if(c instanceof JPanel)
			{
				enabledComponents((JPanel)c);
			}
			c.setEnabled(true);
		}
		temp.setEnabled(true);
	}

	public static void disabledComponents(JPanel temp)
	{
		for(Component c:temp.getComponents())
		{
			if(c instanceof JPanel)
			{
				disabledComponents((JPanel)c);
			}
			c.setEnabled(false);
		}
		temp.setEnabled(false);
	}

	public static void visibleComponents(JPanel temp)
	{
		for(Component c:temp.getComponents())
		{
			if(c instanceof JPanel)
			{
				visibleComponents((JPanel)c);
			}
			c.setVisible(true);
		}
		temp.setVisible(true);
	}

	public static void hideComponents(JPanel temp)
	{
		for(Component c:temp.getComponents())
		{
			if(c instanceof JPanel)
			{
				hideComponents((JPanel)c);
			}
			c.setVisible(false);
		}
		temp.setVisible(false);
	}

}