import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import timescreen.*;
import HtmlSetting.HtmlStyle;
import myUtility.*;
import javax.swing.border.*;
import DBReport.*;
import InputRestriction.*;

class FrmFloor extends JFrame implements ActionListener
{
	//int w = 3020;
	TimeScreen ES;

	JLabel  lblFloorID;
	JLabel  lblFloorName;
	JLabel  lblTotalRooms;
	JLabel  lblProgrammeHeading;

    JTextField txtFloorID;
    JTextField txtFloorName;
    JTextField txtTotalRooms;



	JPanel pnlEntry;
	JPanel  pnlData;
	JButton btnNew;
	JButton btnSave;
	JButton btnView;
	JButton btnUpdate;
	JButton btnDelete;
	JButton btnEdit;
	JButton btnReport;
	JButton btnClose;
	JButton btnApply;

	JPanel  pnlNew;
	JPanel	pnlSave;
	JPanel	pnlView;
	JPanel	pnlUpdate;
	JPanel  pnlDelete;
	JPanel	pnlEdit;
	JPanel	pnlReport;
	JPanel	pnlClose;
	JPanel  pnlApply;


    Font F2;

    Border border1;

    JComboBox cmbFloorUpdate;
    JPanel pnlFloorUpdate;
    JLabel lblFloorUpdate;

    ReportTool tool;
    ButtonState bst;
    ClsButtonManagement cbm;

    int Rcols;

	JPanel pnlDataReport;
	FrmFloor()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

         border1 = BorderFactory.createMatteBorder(0,0,2,0,Color.black);

         F2 = new Font("Sans Serif",Font.BOLD,18);


		setSize(screenSize.width,screenSize.height);
		ES = new TimeScreen();
		add(ES);



		pnlDataReport = ES.getDataReportPanel();
	    pnlData = ES.getDataPanel();
	    pnlEntry = ES.getEntryPanel();
	    pnlNew = ES.getNewPanel();
	    pnlSave = ES.getSavePanel();
	    pnlView = ES.getViewPanel();
		pnlEdit = ES.getEditPanel();
		pnlUpdate = ES.getUpdatePanel();
		pnlDelete = ES.getDeletePanel();
		pnlClose = ES.getClosePanel();
		pnlReport = ES.getReportPanel();
		pnlApply = ES.getApplyPanel();

        btnNew = ES.getNewButton();
        btnSave = ES.getSaveButton();
        btnUpdate = ES.getUpdateButton();
        btnView = ES.getViewButton();
        btnEdit = ES.getEditButton();
        btnDelete = ES.getDeleteButton();
        btnClose = ES.getCloseButton();
        btnReport = ES.getReportButton();
        pnlFloorUpdate = ES.getFirstComboPanel();
        cmbFloorUpdate = ES.getFirstComboBox();
        lblFloorUpdate = ES.getFirstComboLabel();
        btnApply = ES.getApplyButton();
        lblProgrammeHeading = ES.getProgrammeHeading();
		lblFloorUpdate.setText("Floor ");
		lblProgrammeHeading.setText("FloorForm..");

		HtmlStyle.applyH1(lblProgrammeHeading);

		BlinkLabel bl = new BlinkLabel(lblProgrammeHeading,500);
		bl.start();

		int y = 20;
		int h = 30;
		int gap = 10;

       lblFloorID = new JLabel("FloorID");
       lblFloorID.setBounds(10,y,150,h);
       lblFloorID.setFont(F2);
       pnlData.add(lblFloorID);

       txtFloorID = new JTextField();
       txtFloorID.setBounds(190,y,100,h);
       txtFloorID.setFont(F2);
       pnlData.add(txtFloorID);
       txtFloorID.addKeyListener(new OnlyNumbers());


		y = y+h+gap;
       lblFloorName = new JLabel("FloorName");
	   lblFloorName.setBounds(10,y,180,h);
	   lblFloorName.setFont(F2);
	   pnlData.add(lblFloorName);

       txtFloorName = new JTextField();
	   txtFloorName.setBounds(190,y,200,h);
	   txtFloorName.setFont(F2);
       pnlData.add(txtFloorName);

		y = y+h+gap;
		lblTotalRooms = new JLabel("TotalRooms");
		lblTotalRooms.setBounds(10,y,150,h);
		lblTotalRooms.setFont(F2);
		pnlData.add(lblTotalRooms);

		txtTotalRooms = new JTextField();
		txtTotalRooms.setBounds(190,y,100,h);
		txtTotalRooms.setFont(F2);
		pnlData.add(txtTotalRooms);
		txtTotalRooms.addKeyListener(new OnlyNumbers());


		tool=new ReportTool(100,100);
		tool.setBounds(10,10,600,444);
		//tool.setBackground(Color.yellow);
		pnlDataReport.add(tool);



       btnNew.addActionListener(this);
	   btnSave.addActionListener(this);
	   btnUpdate.addActionListener(this);
	   btnView.addActionListener(this);
	   btnEdit.addActionListener(this);
	   btnDelete.addActionListener(this);
	   btnClose.addActionListener(this);
       btnApply.addActionListener(this);
		btnReport.addActionListener(this);
       //ES.setDefaultOperation();
       ES.UIAreaSetting(440,180);
       ES.ReportAreaSetting(700,550);


//		PanelState.hideComponents(pnlDataReport);
//		PanelState.hideComponents(pnlData);
		//PanelState.visibleComponents(pnlDataReport);
		createReport();
		bst = new ButtonState();
		cbm = new ClsButtonManagement();
		automateButtons();
		bst.setButtonState(ButtonState.InitialState);
		cbm.showButtonsOnUI(bst);



		//setColumnsData();
//		PanelState.enabledComponents(pnlReport);



		show();



	}

   void automateButtons()
   {
		cbm.manageDataPanel(pnlData);
		cbm.manageEntryPanel(pnlEntry);
		cbm.manageDataReportPanel(pnlDataReport);
	    cbm.manageNewPanel(pnlNew);
		cbm.manageSavePanel(pnlSave);
		cbm.manageViewPanel(pnlView);
		cbm.manageEditPanel(pnlEdit);
		cbm.manageUpdatePanel(pnlUpdate);
		cbm.manageDeletePanel(pnlDelete);
		cbm.manageCancelPanel(pnlClose);
		cbm.manageReportPanel(pnlReport);
		cbm.manageApplyPanel(pnlApply);
		cbm.manageFirstPanel(pnlFloorUpdate);
		cbm.manageFirstLabel(lblFloorUpdate);
		cbm.manageFirstCombo(cmbFloorUpdate);
	}


   public void initUI()
   {
       txtFloorID.setText("0");
       txtFloorName.setText(" ");
       txtTotalRooms.setText("0");

   }

   public void addFloorRecords(JComboBox cmbProcess)
   {
   	   cmbProcess.removeActionListener(this);
   	    ClsFloor.addFloorRecords(cmbProcess);
   	   cmbProcess.addActionListener(this);
   }


   public void actionPerformed(ActionEvent ae)
   {
       if(ae.getSource()==btnNew)
       {
			bst.setButtonState(ButtonState.NewState);
			cbm.showButtonsOnUI(bst);

           	txtFloorID.setText("0");
			txtFloorName.requestFocus();
			txtTotalRooms.setText("0");

	   }
	   else if(ae.getSource()==btnSave)
	   {
		   bst.setButtonState(ButtonState.SaveState);
			cbm.showButtonsOnUI(bst);
           ClsFloor temp = readUI();
           ClsFloor.addNewRecord(temp);
           JOptionPane.showMessageDialog(this,"Record Is Saved Successfully");
	       initUI();

	    // PanelState.enabledComponents(pnlNew);
	    // PanelState.enabledComponents(pnlView);
	    // PanelState.enabledComponents(pnlClose);



	  }
	   else if(ae.getSource()==btnUpdate)
	   {
		   bst.setButtonState(ButtonState.UpdateState);
			cbm.showButtonsOnUI(bst);
           ClsFloor temp = readUI();
           ClsFloor.updateRecord(temp);
           JOptionPane.showMessageDialog(this,"Record Is Updated Successfully");
           initUI();
			//PanelState.enabledComponents(pnlNew);
			//PanelState.enabledComponents(pnlView);
			//PanelState.enabledComponents(pnlClose);
			//PanelState.disabledComponents(pnlUpdate);



	   }
	   else if(ae.getSource()==btnView)
	   {
			bst.setButtonState(ButtonState.ViewState);
			cbm.showButtonsOnUI(bst);
            addFloorRecords(cmbFloorUpdate);

	   }
	   else if(ae.getSource()==btnEdit)
	   {
			bst.setButtonState(ButtonState.EditState);
			cbm.showButtonsOnUI(bst);
	   }
	   else if(ae.getSource()==btnDelete)
	   {
		   bst.setButtonState(ButtonState.DeleteState);
			cbm.showButtonsOnUI(bst);
           ClsFloor temp = readUI();
           ClsFloor.deleteRecord(temp);
           JOptionPane.showMessageDialog(this,"Record Is Deleted Successfully");
           initUI();
	   }
	   else if(ae.getSource()==btnClose)
	   {
		   bst.setButtonUniqueState(ButtonState.CancelState);
			cbm.showButtonsOnUI(bst);
           initUI();
	   }
	   else if(ae.getSource()==cmbFloorUpdate)
	   	{
			PanelState.enabledComponents(pnlApply);
	              initUI();
	   }

		else if(ae.getSource()==btnReport)
		{
		   bst.setButtonCommonState(ButtonState.ReportState);
			cbm.showButtonsOnUI(bst);
//			PanelState.hideComponents(pnlData);
//			PanelState.visibleComponents(pnlDataReport);
			//createReport();
			setColumnsData();
		}
		else if(ae.getSource()==btnApply)
		{
			bst.setButtonState(ButtonState.ApplyState);
			cbm.showButtonsOnUI(bst);

			String mFloorName = (String)cmbFloorUpdate.getSelectedItem();
			int mFloorID = ClsFloor.getFloorIDFromName(mFloorName);
			ClsFloor temp = ClsFloor.getFloorInformation(mFloorID);
			writeUI(temp);
		}
   }

   public void writeUI(ClsFloor temp)
   {
		txtFloorID.setText(String.valueOf(temp.getFloorID()));
		txtFloorName.setText(temp.getFloorName());
	    txtTotalRooms.setText(String.valueOf(temp.getTotalRooms()));

   }

   ClsFloor readUI()
   {

	   ClsFloor temp2 = new ClsFloor();
	   temp2.setFloorID(Integer.parseInt(txtFloorID.getText()));
	   temp2.setFloorName(txtFloorName.getText());
	   temp2.setTotalRooms(Integer.parseInt(txtTotalRooms.getText()));

       return(temp2);

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
		Rcols+=tool.addNewColumn("FloorID");
		Rcols+=tool.addNewColumn("FloorName");
		Rcols+=tool.addNewColumn("TotalRooms");


	}
	void setColumnsAlignment()
	{
		tool.setColumnAlignment(0,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(1,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(2,ReportTool.ALIGN_CENTER);

	}
	void setColumnsWidth()
	{
		tool.setColumnWidth("FloorID",80);
		tool.setColumnWidth("FloorName",400);
		tool.setColumnWidth("TotalRooms",100);



	}

	void setColumnsData()
	{

		tool.removeAllRows();

		ClsFloor Data[]=ClsFloor.getAllFloorInformation();

		for(int i=0;i<Data.length;i++)
		{
			Object Objectdata[]=new Object[Rcols];

			Objectdata[0]=i+1;
			Objectdata[1]=Data[i].getFloorName();
			Objectdata[2]=Data[i].getTotalRooms();

            tool.addNewRow(Objectdata);
		}
	}


   public static void main(String args[])
   {
        FrmFloor A = new FrmFloor();
   }

}