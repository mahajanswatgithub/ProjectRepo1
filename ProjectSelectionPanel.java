package entryscreen;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import myUtility.*;
import myUtility.PanelState;
import ProjectSetting.*;
import HtmlSetting.*;
import javax.swing.JScrollPane;

public class ProjectSelectionPanel extends JPanel
{

	JPanel pnlLogo;
	JPanel pnlProjectHeading;
	JPanel pnlProgramHeading;
	JPanel pnlImage;
	JPanel pnlSelect;
	JPanel pnlEntry;
	JPanel pnlBottom;
	JPanel pnlApply;
	JPanel pnlImageSubPanel1;
	JPanel pnlImageSubPanel2;
	JPanel pnlBottomLeft;
	JPanel pnlBottomRight;
	JPanel pnlButton;
	JPanel pnlData;
	JPanel pnlDataScroll;

	JPanel pnlDemo;

	JPanel pnlDataMenuLeft;
	JPanel pnlDataMenuRight;
	JPanel pnlDataOperation;

	JLabel lblProjectHeading;
	JLabel lblProgrammeHeading;
	JLabel lblSetImage1;
	JLabel lblSetImage2;
	JLabel lblLogo;
	JLabel lblBottomLeftImage;
	JLabel lblBottomRightImage;
	JLabel lblImg;
	JLabel lblButtonPanelImage;

	int AvailabelOptions=25;

	JPanel pnlEntryOptions[];
	JButton btnEntryButtons[];

//	JPanel pnlReportOptions[];
	JButton btnReportButtons[];

	JLabel lblEntryLabel[];
//	JPanel pnlEntryLabel[];

	JScrollPane scrollMenuLeft;
	JScrollPane scrollMenuRight;
	Container contant;






	CreatePanel CP;


	public ProjectSelectionPanel()
	{


		Color borderColor=Color.black;
		Border borderLineBorder = BorderFactory.createLineBorder(borderColor);
		Border Border1 = BorderFactory.createMatteBorder(2,2,2,2,Color.decode("#483D8B"));



		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		setSize(screenSize.width,screenSize.height);
		setLocation(0,0);
		setLayout(null);

		CP = new CreatePanel(screenSize.width,screenSize.height);
		CP.setGap(5,5);


		setBackground(ApplyColor.clrBackColor);

		CP.setXToLeftOf(this);
		CP.setYToTopOf(this);
		CP.setWidthPercentage(17);
		CP.setHeightPercentage(15);
		pnlLogo = CP.createPanel();

		pnlLogo.setBackground(ApplyColor.clrLogoPanel);
		pnlLogo.setLayout(new GridLayout(1,1));
		add(pnlLogo);


		CP.setXToLeftOf(this);
		CP.setPanelToBottom(11);
		CP.setWidthTillEnd(this);

		pnlBottom = CP.createPanel();

		pnlBottom.setBackground(ApplyColor.clrBottomPanel);
		pnlBottom.setLayout(null);
		add(pnlBottom);

		CP.setXToRightOf(pnlLogo);
		CP.setYToTopOf(this);
		CP.setWidthTillEndFrom(pnlLogo);
		CP.setHeightPercentage(5);
		pnlProjectHeading = CP.createPanel();

		pnlProjectHeading.setBackground(ApplyColor.clrProjectHeadingPanel);
		pnlProjectHeading.setLayout(new GridLayout(1,1));
		add(pnlProjectHeading);




		CP.setPanelToRight(26);
		CP.setYBelowOf(pnlProjectHeading);
		CP.setHeightBetween(pnlProjectHeading,pnlBottom);//setHeightPercentage(80);
		pnlImage = CP.createPanel();

		//pnlImage.setBackground(clrpnlImage);
		pnlImage.setLayout(new GridLayout(2,1,5,5));
		add(pnlImage);


		CP.setXToRightOf(pnlLogo);
		CP.setYBelowOf(pnlProjectHeading);
		CP.setWidthBetween(pnlLogo,pnlImage);
		CP.setHeightPercentage(5);
		pnlProgramHeading = CP.createPanel();

		pnlProgramHeading.setBackground(ApplyColor.clrProgramHeadingPanel);
		pnlProgramHeading.setLayout(new GridLayout(1,1));
		add(pnlProgramHeading);



		CP.setXToLeftOf(this);;
		CP.setYBelowOf(pnlLogo);
		CP.setWidthPercentage(17);
		CP.setHeightBetween(pnlLogo,pnlBottom);//setHeightPercentage(70);
		pnlSelect = CP.createPanel();


		pnlSelect.setBackground(ApplyColor.clrMenuSelectPanel);
		pnlSelect.setLayout(new GridLayout(1,1));
		add(pnlSelect);




		CP.setXToRightOf(pnlLogo);
		CP.setYBelowOf(pnlProgramHeading);
		CP.setWidthBetween(pnlLogo,pnlImage);
		CP.setHeightBetween(pnlProgramHeading,pnlBottom);//setHeightPercentage(74);
		pnlEntry = CP.createPanel();

		pnlEntry.setBackground(ApplyColor.clrEntryPanel);
		pnlEntry.setLayout(null);
		add(pnlEntry);

		CP.addPanelAtTop(pnlImage,49);
		pnlImageSubPanel1=CP.addPanel();
		pnlImage.add(pnlImageSubPanel1);
		pnlImageSubPanel1.setLayout(new GridLayout(1,1));
		pnlImageSubPanel1.setBackground(ApplyColor.clrImageSubPanel1);

		CP.addPanelAtBottom(pnlImage,49);
		pnlImageSubPanel2=CP.addPanel();
		pnlImage.add(pnlImageSubPanel2);
		pnlImageSubPanel2.setLayout(new GridLayout(1,1));
		pnlImageSubPanel2.setBackground(ApplyColor.clrImageSubPanel2);


		CP.addPanelAtLeft(pnlBottom,20);
		pnlBottomLeft=CP.addPanel();
		pnlBottom.add(pnlBottomLeft);
		pnlBottomLeft.setLayout(new GridLayout(1,1));
		pnlBottomLeft.setBackground(ApplyColor.clrBottomLeftPanel);

		CP.addPanelAtRight(pnlBottom,18);
		pnlBottomRight=CP.addPanel();
		pnlBottom.add(pnlBottomRight);
		pnlBottomRight.setLayout(new GridLayout(1,1));
		pnlBottomRight.setBackground(ApplyColor.clrBottomRightPanel);

		CP.addPanelBetween(pnlBottom,pnlBottomLeft,pnlBottomRight);
		pnlButton=CP.addPanel();
		pnlBottom.add(pnlButton);
		pnlButton.setLayout(new GridLayout(1,1));
		pnlButton.setBackground(ApplyColor.clrButtonPanel);
		Dimension size = pnlBottom.getSize();





		CP.addPanelAtLeft(pnlEntry,30);
		pnlData=CP.addPanel();
		pnlEntry.add(pnlData);
		pnlData.setLayout(null);
		pnlData.setBackground(ApplyColor.clrDataPanel);





		lblProjectHeading = new JLabel(ProjectTitle.getProjectTitle(),JLabel.CENTER);
	   lblProjectHeading.setForeground(ApplyColor.clrProjectHeadingText);
		pnlProjectHeading.add(lblProjectHeading);
		HtmlStyle.applyH1(lblProjectHeading);


		lblImg = new JLabel(new ImageIcon("Images\\JavaDeveloper.PNG"));
		pnlSelect.add(lblImg);

		lblButtonPanelImage = new JLabel(new ImageIcon("Images\\ImgButtonPanelFinal.JPG"));
		pnlButton.add(lblButtonPanelImage);

		lblProgrammeHeading = new JLabel("Galaxy ..... Program Information",JLabel.CENTER);
		lblProgrammeHeading.setForeground(ApplyColor.clrProgramHeadingText);
		pnlProgramHeading.add(lblProgrammeHeading);


		lblSetImage1 = new JLabel();
		lblSetImage1.setIcon(new ImageIcon("Images\\ImgTop1.jpg"));
		pnlImageSubPanel1.add(lblSetImage1);

		lblSetImage2 = new JLabel();
		lblSetImage2.setIcon(new ImageIcon("Images\\ImgTop2.jpg"));
		pnlImageSubPanel2.add(lblSetImage2);

		lblLogo = new JLabel("",JLabel.CENTER);
		lblLogo.setIcon(new ImageIcon("Images\\ImgLogo.jpg"));
		pnlLogo.add(lblLogo);

		lblBottomLeftImage = new JLabel("",JLabel.CENTER);
		lblBottomLeftImage.setIcon(new ImageIcon("Images\\ImgButtonLeft.jpg"));
		pnlBottomLeft.add(lblBottomLeftImage);

		lblBottomRightImage = new JLabel("",JLabel.RIGHT);
		lblBottomRightImage.setIcon(new ImageIcon("Images\\ImgButtonRight.jpg"));
		pnlBottomRight.add(lblBottomRightImage);


       setDefaultOperation();


	}
	public void setDefaultOperation()
	{

		//PanelState.disabledComponents(pnlData);
		//PanelState.disabledComponents(pnlButton);

	}
	public void UIAreaSetting(int rw,int rh)
	{
		Dimension ds=pnlData.getParent().getSize();
		int pw = ds.width;
		int ph = ds.height;
		int x = (pw-rw)/2;
		int y = ((ph-rh)/2);

		pnlData.setBounds(x,y,rw,rh);

	}


	public void setDataInnerPanels()
	{
				CP.addPanelAtBottom(pnlData,7);
				pnlDataOperation=CP.addPanel();
				pnlData.add(pnlDataOperation,BorderLayout.SOUTH);
				pnlDataOperation.setLayout(new GridLayout(1,2));




		//Left Side Panel Detail in Programe ..

				CP.addPanelAtLeft(pnlData,30,63,10);
				pnlDataMenuLeft=CP.addPanel();
				pnlDataMenuLeft.setLayout(new GridLayout(AvailabelOptions,1,5,5));

				//pnlData.add(scrollMenuLeft,BorderLayout.WEST);
				pnlEntryOptions=new JPanel[AvailabelOptions];
				btnEntryButtons=new JButton[AvailabelOptions];
				lblEntryLabel = new JLabel[AvailabelOptions];
//				pnlReportOptions=new JPanel[AvailabelOptions];
				btnReportButtons=new JButton[AvailabelOptions];


				CP.addPanelAtTop(pnlDataMenuLeft,6);
				pnlEntryOptions[0]=CP.addPanel();
				pnlEntryOptions[0].setBackground(Color.white);
				//pnlEntryOptions[0].setLayout(new GridLayout(1,1));
				//pnlDataMenuLeft.add(pnlEntryOptions[0]);
				lblEntryLabel[0] = new JLabel(".................");
				btnEntryButtons[0] = new JButton(".................");
				btnReportButtons[0] = new JButton(".................");
				//CP.placeComponent(pnlEntryOptions[0],btnEntryButtons[0]);
				pnlEntryOptions[0].add(lblEntryLabel[0]);
				pnlEntryOptions[0].add(btnEntryButtons[0]);
				pnlEntryOptions[0].add(btnReportButtons[0]);
				PanelState.hideComponents(pnlEntryOptions[0]);
				JPanel temp = pnlEntryOptions[0];
				for(int i=1;i<AvailabelOptions;i++)
				{
					CP.addPanelAfterFromTop(pnlDataMenuLeft,temp,6);
					pnlEntryOptions[i]=CP.addPanel();
					pnlDataMenuLeft.add(pnlEntryOptions[i]);
					pnlEntryOptions[i].setBackground(Color.white);
					pnlEntryOptions[i].setLayout(new GridLayout(1,3));

					lblEntryLabel[i] = new JLabel(".................");
					pnlEntryOptions[i].add(lblEntryLabel[i]);

					btnEntryButtons[i] = new JButton(".................");
				//	CP.placeComponent(pnlEntryOptions[i],btnEntryButtons[i]);
					pnlEntryOptions[i].add(btnEntryButtons[i]);

					btnReportButtons[i] =  new JButton(".................");
					pnlEntryOptions[i].add(btnReportButtons[i]);
					PanelState.hideComponents(pnlEntryOptions[i]);
					temp = pnlEntryOptions[i];

				}


				scrollMenuLeft = CP.addScrollPane(pnlData,pnlDataMenuLeft,30,50);
				//scrollMenuLeft = new JScrollPane(pnlDataMenuLeft);//, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				//scrollMenuLeft.setBounds(100,10,600,pnlData.getHeight()-100);//pnlData.getHeight()-100);
				pnlData.add(scrollMenuLeft);



				//Right Side Panel Detail in Programe ..

/*
				CP.addPanelAtRight(pnlData,10,63,10);
				pnlDataMenuRight=CP.addPanel();
			//	pnlDataMenuRight.setBounds(pnlData.getWidth()-165,10,150,pnlData.getHeight()-150);
				pnlDataMenuRight.setLayout(new GridLayout(AvailabelOptions,1,5,5));


			//	pnlData.add(pnlDataMenuRight);

				pnlReportOptions=new JPanel[AvailabelOptions];
				btnReportButtons=new JButton[AvailabelOptions];

				CP.addPanelAtTop(pnlDataMenuRight,6);
				pnlReportOptions[0]=CP.addPanel();
				pnlReportOptions[0].setBackground(Color.red);
				//pnlReportOptions[0].setLayout(null);
				pnlDataMenuRight.add(pnlReportOptions[0]);

				btnReportButtons[0] = new JButton("Reports....");
				//CP.placeComponent(pnlReportOptions[0],btnReportButtons[0]);
				pnlReportOptions[0].add(btnReportButtons[0]);
				PanelState.disabledComponents(pnlReportOptions[0]);
				JPanel temp1 = pnlReportOptions[0];

				for(int i=1;i<AvailabelOptions;i++)
				{
					CP.addPanelAfterFromTop(pnlDataMenuRight,temp1,6);
					pnlReportOptions[i]=CP.addPanel();
					pnlDataMenuRight.add(pnlReportOptions[i]);
					pnlReportOptions[i].setBackground(Color.red);
					pnlReportOptions[i].setLayout(new GridLayout(1,1));
					btnReportButtons[i] = new JButton("Reports....");

					//CP.placeComponent(pnlReportOptions[i],btnReportButtons[i]);
					pnlReportOptions[i].add(btnReportButtons[i]);
					PanelState.disabledComponents(pnlReportOptions[i]);
					temp1 = pnlReportOptions[i];

				}

				 scrollMenuRight = new JScrollPane(pnlDataMenuRight);//, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scrollMenuRight.setBounds(889,10,150,pnlData.getHeight()-100);
				pnlData.add(scrollMenuRight);
*/




	}

	public JPanel getEntryPanel()
	{
		return (pnlEntry);
	}
	public JPanel getDataPanel()
	{
		return (pnlData);
	}
	public JPanel getDataOperationPanel()
	{
		return(pnlDataOperation);
	}

	public JPanel getDataMenuLeftPanel()
	{
		return(pnlDataMenuLeft);
	}
	public JPanel[] getAllEntryOptions()
	{
		return pnlEntryOptions;
	}
/*	public JPanel[] getAllReportOptions()
	{
		return pnlReportOptions;
	}*/
	public JButton[] getAllEntryButtons()
	{
		return btnEntryButtons;
	}
	public JLabel[] getAllEntryLabelName()
	{
		return lblEntryLabel;
	}
	public JButton[] getAllReportButtons()
	{
		return btnReportButtons;
	}
	public JPanel getDataMenuRightPanel()
	{
		return(pnlDataMenuRight);
	}
	public JPanel getSelectPanel()
	{
		return (pnlSelect);
	}

   public JLabel getProgrammeHeading()
   {
	  return (lblProgrammeHeading);

   }





}
