package myUtility;
import java.awt.*;
import javax.swing.*;

public class CreatePanel
{

	private int ParentWidth;
	private int ParentHeight;
	private int XValue;
	private int YValue;
	private int TotalWidth;
	private int TotalHeight;
	private int HorizontalGap;
	private int VerticalGap;

	public void placeComponent(JPanel parent,JButton myButton)
	{
		XValue=HorizontalGap;
		YValue=VerticalGap;
		Dimension size1 = parent.getSize();
		TotalWidth = size1.width-(HorizontalGap*2);
		TotalHeight = size1.height-(VerticalGap*2);
		myButton.setBounds(XValue,YValue,TotalWidth,TotalHeight);
	}

	public void placeComponent(JPanel parent,JLabel myLabel)
	{
		XValue=HorizontalGap;
		YValue=VerticalGap;
		Dimension size1 = parent.getSize();
		TotalWidth = size1.width-(HorizontalGap*2);
		TotalHeight = size1.height-(VerticalGap*2);
		myLabel.setBounds(XValue,YValue,TotalWidth,TotalHeight);
	}

	public CreatePanel(int ParW,int ParH)
	{
		ParentWidth=ParW;
		ParentHeight=ParH;
		XValue=0;
		YValue=0;
		TotalWidth=0;
		TotalHeight=0;
		HorizontalGap=0;
		VerticalGap=0;

	}


	public void addPanelInside(JPanel parent)
	{
		XValue=HorizontalGap;
		YValue=VerticalGap;
		Dimension Size1 = parent.getSize();
		TotalWidth = Size1.width - (HorizontalGap*2);
		TotalHeight = Size1.height - (VerticalGap*2);
	}

	public void addPanelAtTop(JPanel parent,int percent)
	{
		XValue=HorizontalGap;
		YValue=VerticalGap;
		Dimension Size1 = parent.getSize();
		TotalWidth = Size1.width - (HorizontalGap*2);
		TotalHeight = (ParentHeight/100)*percent;
	}

	public void addPanelAtTop(JWindow parent,int percent)
	{
		XValue=HorizontalGap;
		YValue=VerticalGap;
		Dimension Size1 = parent.getSize();
		TotalWidth = Size1.width - (HorizontalGap*2);
		TotalHeight = (ParentHeight/100)*percent;
	}



	public void addPanelAtTop(JScrollPane parent,int percent)
	{
		XValue=HorizontalGap;
		YValue=VerticalGap;
		Dimension Size1 = parent.getSize();
		TotalWidth = Size1.width - (HorizontalGap*2);
		TotalHeight = (ParentHeight/100)*percent;
	}



	public void addPanelAtBottom(JPanel parent,int percent)
	{
		XValue=HorizontalGap;
		Dimension Size1 = parent.getSize();
		TotalWidth = Size1.width - (HorizontalGap*2);
		TotalHeight = (ParentHeight/100)*percent;
		YValue=Size1.height-(TotalHeight+(VerticalGap*2));
	}
	public void addPanelAfterFromTop(JPanel parent,JPanel pnlup,int percent)
	{
		XValue=HorizontalGap;
		Dimension Size2 = parent.getSize();
		TotalWidth = Size2.width - (HorizontalGap*2);
		TotalHeight = (ParentHeight/100)*percent;
		Point YPoint = pnlup.getLocation();
		Dimension Size1 = pnlup.getSize();
		YValue=YPoint.y+Size1.height+VerticalGap;
	}

	public void addPanelAfterFromTop(JWindow parent,JPanel pnlup,int percent)
		{
			XValue=HorizontalGap;
			Dimension Size2 = parent.getSize();
			TotalWidth = Size2.width - (HorizontalGap*2);
			TotalHeight = (ParentHeight/100)*percent;
			Point YPoint = pnlup.getLocation();
			Dimension Size1 = pnlup.getSize();
			YValue=YPoint.y+Size1.height+VerticalGap;
	}
	public void addPanelAfterFromTop(JScrollPane parent,JPanel pnlup,int percent)
	{
		XValue=HorizontalGap;
		Dimension Size2 = parent.getSize();
		TotalWidth = Size2.width - (HorizontalGap*2);
		TotalHeight = (ParentHeight/100)*percent;
		Point YPoint = pnlup.getLocation();
		Dimension Size1 = pnlup.getSize();
		YValue=YPoint.y+Size1.height+VerticalGap;
	}
	public void addPanelAtLeft(JPanel parent,int percent)
	{
		XValue=HorizontalGap;
		YValue=VerticalGap;
		TotalWidth = (ParentWidth/100)*percent;
		Dimension Size1 = parent.getSize();
		TotalHeight = Size1.height - (VerticalGap*2);
	}



	public void addPanelAtLeft(JPanel parent,int Wpercent,int Hpercent,int YAxisValue)
	{
		XValue=HorizontalGap;
		TotalWidth = (ParentWidth/100)*Wpercent;
		Dimension Size1 = parent.getSize();
		TotalHeight = (ParentHeight/100)*Hpercent;
		YValue=YAxisValue;
	}

	public void addScrollPaneAtLeft(JPanel parent,int Wpercent,int Hpercent,int YAxisValue)
	{
		XValue=HorizontalGap;
		TotalWidth = (ParentWidth/100)*Wpercent;
		Dimension Size1 = parent.getSize();
		TotalHeight = (ParentHeight/100)*Hpercent;
		YValue=YAxisValue;
	}


	public void addPanelAtRight(JPanel parent,int Wpercent,int Hpercent,int YAxisValue)
	{
		YValue=VerticalGap;
		TotalWidth = (ParentWidth/100)*Wpercent;
		Dimension Size1 = parent.getSize();
		TotalHeight = (ParentHeight/100)*Hpercent;
		XValue=Size1.width-(TotalWidth+HorizontalGap);
	}

	public void addPanelAtRight(JPanel parent,int percent)
	{
		YValue=VerticalGap;
		TotalWidth = (ParentWidth/100)*percent;
		Dimension Size1 = parent.getSize();
		TotalHeight = Size1.height - (VerticalGap*2);
		XValue=Size1.width-(TotalWidth+HorizontalGap);
	}
	public void addPanelAfterFromLeft(JPanel parent,JPanel pnlLeft,int percent)
	{
		YValue=VerticalGap;
		TotalWidth = (ParentWidth/100)*percent;
		Dimension Size1 = pnlLeft.getSize();
		Point XPoint = pnlLeft.getLocation();
		XValue=XPoint.x+Size1.width+HorizontalGap;
		Dimension Size2 = parent.getSize();
		TotalHeight = Size2.height - (VerticalGap*2);
	}

	public void addPanelAfterFromLeft(JPanel parent,JPanel pnlLeft,int Wpercent,int Hpercent,int YAxisValue)
	{
		YValue=YAxisValue;
		TotalWidth = (ParentWidth/100)*Wpercent;
		TotalHeight = (ParentHeight/100)*Hpercent;
		Dimension Size1 = pnlLeft.getSize();
		Point XPoint = pnlLeft.getLocation();
		XValue=XPoint.x+Size1.width+HorizontalGap;
	}

	public void addPanelBetween(JPanel parent,JPanel pnlLeft,JPanel pnlRight)
	{
		YValue=VerticalGap;
		Dimension Size1 = pnlLeft.getSize();
		Point XPoint = pnlLeft.getLocation();
		XValue=XPoint.x+Size1.width+HorizontalGap;
		Dimension Size2 = parent.getSize();
		TotalHeight = Size2.height - (VerticalGap*2);
		Dimension Size3 = pnlRight.getSize();
		Point XPoint1 = parent.getLocation();
		TotalWidth = ParentWidth-((XPoint1.x+XPoint.x+Size1.width+Size3.width)+HorizontalGap*4);
	}

	public void setGap(int Hgap,int Vgap)
	{
		HorizontalGap=Hgap;
		VerticalGap=Vgap;
	}


	public void setXToLeftOf(JPanel parent)
	{
		Point XPoint = parent.getLocation();
		XValue = (XPoint.x)+HorizontalGap;
	}

	public void setXToRightOf(JPanel leftPanel)
	{
		Point XPoint = leftPanel.getLocation();
		Dimension Size = leftPanel.getSize();
		XValue = (XPoint.x)+(Size.width)+HorizontalGap;
	}

	public void setPanelToBottom(int percent)
	{
		TotalHeight = (ParentWidth/100)*percent;
		YValue = ParentHeight -(TotalHeight+VerticalGap);
	}


	public void setPanelToRight(int percent)
	{
		TotalWidth = (ParentWidth/100)*percent;
		XValue = ParentWidth-(TotalWidth+HorizontalGap);
	}

	public int getValueX()
	{
		return(XValue);
	}

	public void setYToTopOf(JPanel parent)
	{
		Point YPoint = parent.getLocation();
		YValue = (YPoint.y)+VerticalGap;
	}

	public void setYBelowOf(JPanel topPanel)
	{
		Point YPoint = topPanel.getLocation();
		Dimension Size = topPanel.getSize();
		YValue = (YPoint.y)+Size.height+VerticalGap;
	}
	public int getValueY()
	{
		return(YValue);
	}



	public void setWidthPercentage(int percent)
	{
		TotalWidth = (ParentWidth/100)*percent;
	}



	public void setWidthTillEndFrom(JPanel leftPanel)
	{
		Point XPoint = leftPanel.getLocation();
		Dimension Size = leftPanel.getSize();
		XValue = (XPoint.x)+(Size.width)+HorizontalGap;
		TotalWidth = (ParentWidth-XValue)-(HorizontalGap);
	}

	public void setWidthTillEnd(JPanel leftPanel)
	{
		Point XPoint = leftPanel.getLocation();
		Dimension Size = leftPanel.getSize();
		XValue = HorizontalGap;
		TotalWidth = ParentWidth-(HorizontalGap*2);
	}

	public void setWidthBetween(JPanel leftPanel,JPanel rightPanel)
	{
		Dimension Size1 = leftPanel.getSize();
		Dimension Size2 = rightPanel.getSize();
		Point X2Point = rightPanel.getLocation();
		//TotalWidth = ParentWidth-((Size1.width)+(Size2.width))-(HorizontalGap*4);

		TotalWidth = (X2Point.x-Size1.width)-HorizontalGap*3;

	}

	public void setHeightBetween(JPanel upPanel,JPanel downPanel)
	{
		Dimension Size1 = upPanel.getSize();
		Dimension Size2 = downPanel.getSize();
		Point Y2Point = upPanel.getLocation();
		TotalHeight = ParentHeight-((Y2Point.y+Size1.height)+(Size2.height))-(VerticalGap*3);
	}

	public int getWidth()
	{
		return(TotalWidth);
	}

	public void setHeightPercentage(int percent)
	{
		TotalHeight = (ParentHeight/100)*percent;
	}

	public int getHeight()
	{
		return(TotalHeight);
	}

	public JPanel createPanel()
	{
		JPanel pnlTemp = new JPanel();
		pnlTemp.setBounds(getValueX(),getValueY(),getWidth(),getHeight());
		return(pnlTemp);
	}
	public JPanel addPanel()
	{
		JPanel pnlTemp = new JPanel();
		pnlTemp.setBounds(getValueX(),getValueY(),getWidth(),getHeight());
		return(pnlTemp);
	}



	public JScrollPane addScrollPane(JPanel parent,JPanel pnlToAdd,int WPercent,int HPercent)
	{
		TotalWidth = (ParentWidth/100)*WPercent;
		XValue = (parent.getSize().width - TotalWidth )/2;
		YValue = (VerticalGap*3);
		TotalHeight = (ParentHeight/100)*HPercent;

		JScrollPane jsp = new JScrollPane(pnlToAdd);
		jsp.setBounds(getValueX(),getValueY(),getWidth(),getHeight());
		return jsp;
	}
}


