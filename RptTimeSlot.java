import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import reportscreen.*;
import HtmlSetting.HtmlStyle;
import myUtility.*;
import javax.swing.border.*;
import DBReport.*;

class RptTimeSlot extends JFrame implements ActionListener
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
	RptTimeSlot()
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
		lblProgrammeHeading.setText("TimeSlot Report..");

		HtmlStyle.applyH1(lblProgrammeHeading);

		BlinkLabel bl = new BlinkLabel(lblProgrammeHeading,500);
		bl.start();

		int y = 50;
		int h = 30;
		int gap = 10;


		tool=new ReportTool(100,100);
		tool.setBounds(150,10,600,444);
		//tool.setBackground(Color.yellow);
		pnlDataReport.add(tool);





		ES.ReportAreaSetting(900,520);


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
		Rcols+=tool.addNewColumn("TimeSlotID");
		Rcols+=tool.addNewColumn("TimeSlotName");
    	Rcols+=tool.addNewColumn("StartingTime");
    	Rcols+=tool.addNewColumn("EndingTime");
    	Rcols+=tool.addNewColumn("TimeSlotDescription");

	}
	void setColumnsAlignment()
	{
		tool.setColumnAlignment(0,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(1,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(2,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(3,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(4,ReportTool.ALIGN_CENTER);

	}
	void setColumnsWidth()
	{
		tool.setColumnWidth("TimeSlotID",80);
		tool.setColumnWidth("TimeSlotName",200);
		tool.setColumnWidth("StartingTime",180);
		tool.setColumnWidth("EndingTime",180);
		tool.setColumnWidth("TimeSlotDescription",180);

	}

	void setColumnsData()
	{

		tool.removeAllRows();

		ClsTimeSlot Data[]=ClsTimeSlot.getAllTimeSlotInformation();

		for(int i=0;i<Data.length;i++)
		{
			Object Objectdata[]=new Object[Rcols];

			Objectdata[0]=i+1;
			Objectdata[1]=Data[i].getTimeSlotName();
			Objectdata[2]=Data[i].getStartingTime();
			Objectdata[3]=Data[i].getEndingTime();
			Objectdata[4]=Data[i].getTimeSlotDescription();

			tool.addNewRow(Objectdata);
		}
	}


   public static void main(String args[])
   {
        RptTimeSlot A = new RptTimeSlot();
   }

}