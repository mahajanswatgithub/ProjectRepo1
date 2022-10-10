import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import reportscreen.*;
import HtmlSetting.HtmlStyle;
import myUtility.*;
import javax.swing.border.*;
import DBReport.*;

class RptBatchSlot extends JFrame implements ActionListener
{
	//int w = 3020;
	ReportScreen1 ES;

	JLabel  lblProgrammeHeading;

    JLabel lblCourseUpdate;
    JPanel pnlCourseUpdate;
	JComboBox cmbCourseUpdate;

	JButton btnApply;


	JPanel pnlEntry;
	JPanel pnlSelect;

   int vCourseID = 0;


    Font F2;

    Border border1;

    ReportTool tool;

    int Rcols;

	JPanel pnlDataReport;
	RptBatchSlot()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

         border1 = BorderFactory.createMatteBorder(0,0,2,0,Color.black);

         F2 = new Font("Sans Serif",Font.BOLD,18);


		setSize(screenSize.width,screenSize.height);
		ES = new ReportScreen1();
		add(ES);

        pnlSelect = ES.getSelectPanel();
        pnlCourseUpdate = ES.getFirstComboPanel();
        lblCourseUpdate = ES.getFirstComboLabel();
        cmbCourseUpdate = ES.getFirstComboBox();
        btnApply = ES.getApplyButton();
        lblCourseUpdate.setText("Course Update..");

		pnlDataReport = ES.getDataReportPanel();
	    pnlEntry = ES.getEntryPanel();



        lblProgrammeHeading = ES.getProgrammeHeading();
		lblProgrammeHeading.setText("BatchSlot Report..");

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


        ES.ReportAreaSetting(1050,720);
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

   public void actionPerformed(ActionEvent ae)
   {
		if(ae.getSource()==cmbCourseUpdate)
		{
			String mCourseName = (String) cmbCourseUpdate.getSelectedItem();
			vCourseID = ClsCourse.getCourseIDFromName(mCourseName);
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
		Rcols+=tool.addNewColumn("BatchSlotID");
		Rcols+=tool.addNewColumn("BatchSlotName");
		Rcols+=tool.addNewColumn("BatchStudents");


	}
	void setColumnsAlignment()
	{
		tool.setColumnAlignment(0,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(1,ReportTool.ALIGN_LEFT);
		tool.setColumnAlignment(2,ReportTool.ALIGN_CENTER);


	}
	void setColumnsWidth()
	{
		tool.setColumnWidth("BatchSlotID",80);
		tool.setColumnWidth("BatchSlotName",200);
		tool.setColumnWidth("BatchStudents",100);

	}

	void setColumnsData()
	{

		tool.removeAllRows();

		ClsBatchSlot Data[]=ClsBatchSlot.getAllBatchSlotInformation(vCourseID);

		for(int i=0;i<Data.length;i++)
		{
			Object Objectdata[]=new Object[Rcols];

			Objectdata[0]=i+1;
			Objectdata[1]=Data[i].getBatchSlotName();
			Objectdata[2]=Data[i].getBatchStudents();

			tool.addNewRow(Objectdata);
		}
	}


   public static void main(String args[])
   {
        RptBatchSlot A = new RptBatchSlot();
   }

}