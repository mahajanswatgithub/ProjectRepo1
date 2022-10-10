import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import reportscreen.*;
import HtmlSetting.HtmlStyle;
import myUtility.*;
import javax.swing.border.*;
import DBReport.*;

class RptCourse extends JFrame implements ActionListener
{
	//int w = 3020;
	ReportScreen ES;

	JLabel  lblProgrammeHeading;


	JPanel pnlEntry;



    Font F2;

    Border border1;

    ReportTool tool;

    int Rcols;

	JPanel pnlDataReport;
	RptCourse()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

         border1 = BorderFactory.createMatteBorder(0,0,2,0,Color.black);

         F2 = new Font("Sans Serif",Font.BOLD,18);


		setSize(screenSize.width,screenSize.height);
		ES = new ReportScreen();
		add(ES);



		pnlDataReport = ES.getDataReportPanel();
	    pnlEntry = ES.getEntryPanel();



        lblProgrammeHeading = ES.getProgrammeHeading();
		lblProgrammeHeading.setText("Course Report..");

		HtmlStyle.applyH1(lblProgrammeHeading);

		BlinkLabel bl = new BlinkLabel(lblProgrammeHeading,500);
		bl.start();

		int y = 50;
		int h = 30;
		int gap = 10;

		ES.ReportAreaSetting(900,520);


		tool=new ReportTool(750,450);
		tool.setBounds(10,10,800,520);
		//tool.setBackground(Color.yellow);
		pnlDataReport.add(tool);







		createReport();
		setColumnsData();

		show();



	}

   public void actionPerformed(ActionEvent ae)
   {

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
		Rcols+=tool.addNewColumn("CourseID");
		Rcols+=tool.addNewColumn("CourseName");
    	Rcols+=tool.addNewColumn("CoursePattern");
    	Rcols+=tool.addNewColumn("CourseDuration");
    	Rcols+=tool.addNewColumn("CourseCapacity");
    	Rcols+=tool.addNewColumn("CourseStartYear");

	}
	void setColumnsAlignment()
	{
		tool.setColumnAlignment(0,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(1,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(2,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(3,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(4,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(5,ReportTool.ALIGN_CENTER);

	}
	void setColumnsWidth()
	{
		tool.setColumnWidth("CourseID",100);
		tool.setColumnWidth("CourseName",250);
		tool.setColumnWidth("CoursePattern",100);
		tool.setColumnWidth("CourseDuration",100);
		tool.setColumnWidth("CourseCapacity",100);
		tool.setColumnWidth("CourseStartYear",100);

	}

	void setColumnsData()
	{

		tool.removeAllRows();

		ClsCourse Data[]=ClsCourse.getAllCourseInformation();

		for(int i=0;i<Data.length;i++)
		{
			Object Objectdata[]=new Object[Rcols];

			Objectdata[0]=i+1;
			Objectdata[1]=Data[i].getCourseName();
			Objectdata[2]=Data[i].getCoursePattern();
			Objectdata[3]=Data[i].getCourseDuration();
			Objectdata[4]=Data[i].getCourseCapacity();
			Objectdata[5]=Data[i].getCourseStartYear();

			tool.addNewRow(Objectdata);
		}
	}


   public static void main(String args[])
   {
        RptCourse A = new RptCourse();
   }

}