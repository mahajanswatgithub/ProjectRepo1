import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import entryscreen.ProjectSelectionPanel;
import HtmlSetting.HtmlStyle;
import myUtility.*;
import javax.swing.border.*;
import DBReport.*;

class FrmProjectEntry extends JFrame implements ActionListener
{
	ProjectSelectionPanel ES;
	int Buttoncount =4;

	int count;


	JPanel pnlData;
	JPanel pnlDataScroll;
	JPanel pnlDataOperation;
	JPanel pnlDataMenuLeft;
	JPanel pnlDataMenuRight;

	JPanel pnlEntryPanel[];
	JButton btnEntryButton[];
//	String lblEntryButtonName[];

	JPanel pnlReportPanel[];
	JButton btnReportButton[];
	JLabel lblEntryLabel[];

	JButton btnNewProject ;
	JButton btnOpenProject;



	JLabel lblProgrameHeading;
	FrmProjectEntry()
	{


		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width,screenSize.height);
		ES = new ProjectSelectionPanel();
		add(ES);
		Border bd=BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);

		setLayout(null);
		pnlData = ES.getDataPanel();

		lblProgrameHeading = ES.getProgrammeHeading();

		lblProgrameHeading.setText("Project Entry ");
		HtmlStyle.applyH1(lblProgrameHeading);

		BlinkLabel bl = new BlinkLabel(lblProgrameHeading,500);
		bl.start();



		pnlData.setLayout(null);
		int mDataPanelWidth = 700;
		int mDataPanelHeight = 600;
		int mDataScrollPanelHeight=600;
		int mDataScrollPanelYValue=20;
		int mDatePanelXValue = 150;


		ES.UIAreaSetting(mDataPanelWidth,mDataPanelHeight);
		ES.setDataInnerPanels();

		pnlEntryPanel= new JPanel[Buttoncount];
		btnEntryButton = new JButton[Buttoncount];

		pnlReportPanel= new JPanel[Buttoncount];
		btnReportButton = new JButton[Buttoncount];
		lblEntryLabel = new JLabel[Buttoncount];


		pnlDataOperation = ES.getDataOperationPanel();


		btnNewProject = new JButton("New Project");
		pnlDataOperation.add(btnNewProject);


		btnOpenProject = new JButton("Open Project");
		pnlDataOperation.add(btnOpenProject);


		pnlDataMenuLeft = ES.getDataMenuLeftPanel();
		//pnlDataMenuLeft.setLayout(new GridLayout(7,1,5,5));


		//pnlDataMenuRight = ES.getDataMenuRightPanel();
		//pnlDataMenuRight.setLayout(new GridLayout(7,1,5,5));
		pnlEntryPanel = ES.getAllEntryOptions();
		btnEntryButton = ES.getAllEntryButtons();
		lblEntryLabel = ES.getAllEntryLabelName();
//		pnlReportPanel = ES.getAllReportOptions();
		btnReportButton = ES.getAllReportButtons();



	    String lblEntryButtonName[] = {"Interface","Listener","Package","Elements"};
		String lblReportButtonName[] = {"Interface","Listener","Package","Elements"};
 		Buttoncount = lblEntryButtonName.length;


		for(int i=0;i<Buttoncount;i++)
		{
			PanelState.visibleComponents(pnlEntryPanel[i]);
			btnEntryButton[i].setLabel(lblEntryButtonName[i]);
			btnEntryButton[i].setLabel(lblEntryButtonName[i]);
			btnEntryButton[i].addActionListener(this);
			btnReportButton[i].setLabel(lblReportButtonName[i]);
			lblEntryLabel[i].setText(lblEntryButtonName[i]);
			btnReportButton[i].addActionListener(this);
		}




       btnNewProject.addActionListener(this);
		btnOpenProject.addActionListener(this);

		show();
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==btnEntryButton[0])
		{

		}
		else if(ae.getSource()==btnReportButton[0])
		{
		}

	}
  public static void main(String args[])
   {
        FrmProjectEntry A = new FrmProjectEntry();

   }

}