import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import reportscreen.*;
import HtmlSetting.HtmlStyle;
import myUtility.*;
import javax.swing.border.*;
import DBReport.*;

class RptRoom extends JFrame implements ActionListener
{
	//int w = 3020;
	ReportScreen2 ES;

	JLabel  lblProgrammeHeading;

    JLabel lblFloorUpdate;
    JPanel pnlFloorUpdate;
	JComboBox cmbFloorUpdate;

    JLabel lblUseUpdate;
    JPanel pnlUseUpdate;
	JComboBox cmbUseUpdate;
	JButton btnApply;


	JPanel pnlEntry;
	JPanel pnlSelect;

   int vFloorID = 0;
   int vUseID = 0;

    Font F2;

    Border border1;

    int vFloorUpdate = 0;

    ReportTool tool;

    int Rcols;

	JPanel pnlDataReport;
	RptRoom()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

         border1 = BorderFactory.createMatteBorder(0,0,2,0,Color.black);

         F2 = new Font("Sans Serif",Font.BOLD,18);


		setSize(screenSize.width,screenSize.height);
		ES = new ReportScreen2();
		add(ES);

        pnlSelect = ES.getSelectPanel();
        pnlFloorUpdate = ES.getFirstComboPanel();
        lblFloorUpdate = ES.getFirstComboLabel();
        cmbFloorUpdate = ES.getFirstComboBox();

        pnlUseUpdate = ES.getSecondComboPanel();
        lblUseUpdate = ES.getSecondComboLabel();
        cmbUseUpdate = ES.getSecondComboBox();

        btnApply = ES.getApplyButton();
        lblFloorUpdate.setText("Floor Update..");
        lblUseUpdate.setText("Use Update..");

		pnlDataReport = ES.getDataReportPanel();
	    pnlEntry = ES.getEntryPanel();



        lblProgrammeHeading = ES.getProgrammeHeading();
		lblProgrammeHeading.setText("Floor And Use Wise Room Report..");

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
       addFloorRecords(cmbFloorUpdate);

		createReport();
		//setColumnsData();

		show();



	}
	public void addFloorRecords(JComboBox cmbProcess)
	{
		cmbProcess.removeActionListener(this);
		ClsFloor.addFloorRecords(cmbProcess);
		cmbProcess.addActionListener(this);
	}
    public void addUseRecords(JComboBox cmbProcess)
	{
		cmbProcess.removeActionListener(this);
		ClsUse.addUseRecords(cmbProcess);
		cmbProcess.addActionListener(this);
	}

   public void actionPerformed(ActionEvent ae)
   {

        if(ae.getSource()==cmbFloorUpdate)
		{
			String mFloorName = (String)cmbFloorUpdate.getSelectedItem();
		    vFloorID = ClsFloor.getFloorIDFromName(mFloorName);
			//PanelState.enabledComponents(pnlUseUpdate);
			addUseRecords(cmbUseUpdate);
		}
		else if(ae.getSource()==cmbUseUpdate)
		{

			String mUseName = (String)cmbUseUpdate.getSelectedItem();
			vUseID = ClsUse.getUseIDFromName(mUseName);


			//addRoomRecords(cmbRoomUpdate,mUseID,vFloorUpdate);
			//PanelState.enabledComponents(pnlRoomUpdate);
			//PanelState.enabledComponents(pnlApply);

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
		Rcols+=tool.addNewColumn("RoomID");
		Rcols+=tool.addNewColumn("RoomNumber");
		Rcols+=tool.addNewColumn("SittingCapacity");

	}
	void setColumnsAlignment()
	{
		tool.setColumnAlignment(0,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(1,ReportTool.ALIGN_LEFT);
		tool.setColumnAlignment(2,ReportTool.ALIGN_LEFT);

	}
	void setColumnsWidth()
	{
		tool.setColumnWidth("RoomID",80);
		tool.setColumnWidth("RoomNumber",180);
		tool.setColumnWidth("SittingCapacity",180);

	}

	void setColumnsData()
	{

		tool.removeAllRows();

		ClsRoom Data[]=ClsRoom.getAllRoomInformation(vFloorID,vUseID);


		for(int i=0;i<Data.length;i++)
		{
			Object Objectdata[]=new Object[Rcols];

			Objectdata[0]=i+1;
			Objectdata[1]=Data[i].getRoomNumber();
			Objectdata[2]=Data[i].getSittingCapacity();

			tool.addNewRow(Objectdata);
		}
	}


   public static void main(String args[])
   {
        RptRoom A = new RptRoom();
   }

}