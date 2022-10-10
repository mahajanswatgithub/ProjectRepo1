import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import reportscreen.*;
import HtmlSetting.HtmlStyle;
import myUtility.*;
import javax.swing.border.*;
import DBReport.*;

class RptStaff extends JFrame implements ActionListener
{
	//int w = 3020;
	ReportScreen2 ES;

    JLabel  lblProgrammeHeading;

    JLabel lblCourseUpdate;
    JPanel pnlCourseUpdate;
	JComboBox cmbCourseUpdate;

    JLabel lblLevelUpdate;
    JPanel pnlLevelUpdate;
	JComboBox cmbLevelUpdate;
	JButton btnApply;

	JPanel pnlEntry;
	JPanel pnlSelect;

   int vCourseID = 0;
   int vLevelID = 0;

    Font F2;

    Border border1;

    ReportTool tool;

    int Rcols;

	JPanel pnlDataReport;
	RptStaff()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

         border1 = BorderFactory.createMatteBorder(0,0,2,0,Color.black);

         F2 = new Font("Sans Serif",Font.BOLD,18);


		setSize(screenSize.width,screenSize.height);
		ES = new ReportScreen2();
		add(ES);

        pnlSelect = ES.getSelectPanel();
        pnlCourseUpdate = ES.getFirstComboPanel();
        lblCourseUpdate = ES.getFirstComboLabel();
        cmbCourseUpdate = ES.getFirstComboBox();

        pnlLevelUpdate = ES.getSecondComboPanel();
        lblLevelUpdate = ES.getSecondComboLabel();
        cmbLevelUpdate = ES.getSecondComboBox();

        btnApply = ES.getApplyButton();
        lblCourseUpdate.setText("Course Update..");
        lblLevelUpdate.setText("Level Update..");

		pnlDataReport = ES.getDataReportPanel();
	    pnlEntry = ES.getEntryPanel();



        lblProgrammeHeading = ES.getProgrammeHeading();
		lblProgrammeHeading.setText("Course And Level Wise Staff Report..");

		HtmlStyle.applyH1(lblProgrammeHeading);

		BlinkLabel bl = new BlinkLabel(lblProgrammeHeading,500);
		bl.start();

		int y = 50;
		int h = 30;
		int gap = 10;


		tool=new ReportTool(100,100);
		tool.setBounds(10,10,600,444);
		//tool.setBackground(Color.yellow);
		pnlDataReport.add(tool);


        ES.ReportAreaSetting(900,520);
        btnApply.addActionListener(this);



       PanelState.enabledComponents(pnlSelect);
       addCourseRecords(cmbCourseUpdate);

		createReport();
		//setColumnsData();

		show();

	}

    public void addCourseRecords(JComboBox cmbProcess)
	{
		cmbProcess.removeActionListener(this);
		ClsCourse.addCourseRecords(cmbProcess);
		cmbProcess.addActionListener(this);
	}
	public void addLevelRecords(JComboBox cmbProcess,int mCourseID)
	{
		cmbProcess.removeActionListener(this);
		ClsLevel.addLevelRecords(cmbProcess,mCourseID);
		cmbProcess.addActionListener(this);
	}

    public void actionPerformed(ActionEvent ae)
	{

        if(ae.getSource()==cmbCourseUpdate)
		{
			String mCourseName = (String)cmbCourseUpdate.getSelectedItem();
			vCourseID = ClsCourse.getCourseIDFromName(mCourseName);
			addLevelRecords(cmbLevelUpdate,vCourseID);
			PanelState.enabledComponents(pnlLevelUpdate);
		}
        else if(ae.getSource()==cmbLevelUpdate)
		{
			String mLevelName = (String)cmbLevelUpdate.getSelectedItem();
			vLevelID = ClsLevel.getLevelIDFromName(mLevelName);
//			addStaffRecords(cmbStaffUpdate,mLevelID);
		}
        else if(ae.getSource()==btnApply)
		{
			setColumnsData();
		}

   }

    void createReport()
	{
		setColumnsHeading();
		setColumnsAlignment();
		setColumnsWidth();
	}
	void setColumnsHeading()
	{
		Rcols=0;
		Rcols+=tool.addNewColumn("StaffID");
		Rcols+=tool.addNewColumn("StaffName");
		Rcols+=tool.addNewColumn("StaffWeeklyLoad");
		Rcols+=tool.addNewColumn("StaffEducation");
	//	Rcols+=tool.addNewColumn("LevelID");
	}
	void setColumnsAlignment()
	{
		tool.setColumnAlignment(0,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(1,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(2,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(3,ReportTool.ALIGN_CENTER);
	//	tool.setColumnAlignment(4,ReportTool.ALIGN_CENTER);

	}
	void setColumnsWidth()
	{
		tool.setColumnWidth("StaffID",30);
		tool.setColumnWidth("StaffName",80);
		tool.setColumnWidth("StaffWeeklyLoad",80);
		tool.setColumnWidth("StaffEducation",80);

		//tool.setColumnWidth("LevelID",80);

	}

	void setColumnsData()
	{

		tool.removeAllRows();

		ClsStaff Data[]=ClsStaff.getAllStaffInformation(vLevelID);

		for(int i=0;i<Data.length;i++)
		{
			Object Objectdata[]=new Object[Rcols];

			Objectdata[0]=i+1;
			Objectdata[1]=Data[i].getStaffName();
			Objectdata[2]=Data[i].getStaffWeeklyLoad();
			Objectdata[3]=Data[i].getStaffEducation();
			//Objectdata[4]=Data[i].getLevelID();
			tool.addNewRow(Objectdata);
		}
	}




   public static void main(String args[])
   {
        RptStaff A = new RptStaff();
   }

}
