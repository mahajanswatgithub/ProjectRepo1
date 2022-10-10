import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import timescreen.*;
import HtmlSetting.HtmlStyle;
import myUtility.*;
import javax.swing.border.*;
import DBReport.*;
import reportscreen.*;

class FrmRoom extends JFrame implements ActionListener
{
	//int w = 3020;
	TimeScreen3 ES;
    ReportScreen3 es;

	JLabel  lblRoomID;
	JLabel  lblRoomNumber;
	JLabel lblSittingCapacity;
	JLabel  lblFloorID;
	JLabel  lblUseID;
	JLabel  lblRoomNumberUpdate;
	JLabel  lblProgrammeHeading;

    JTextField txtRoomID;
    JTextField txtRoomNumber;
    JTextField txtSittingCapacity;

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
	JPanel  pnlSelect;
	JPanel  pnlEntry;

    Font F2;

    Border border1;

	JPanel pnlFloorUpdate;
    JComboBox cmbFloorUpdate;
	JLabel lblFloorUpdate;

    JPanel pnlUseUpdate;
    JComboBox cmbUseUpdate;
	JLabel lblUseUpdate;

 	JPanel pnlRoomUpdate;
    JComboBox cmbRoomUpdate;
	JLabel lblRoomUpdate;

	JComboBox cmbFloorID;
	JComboBox cmbUseID;

	ReportTool tool;
	ButtonState bst;
	ClsButtonManagement3 cbm;
    int Rcols;

	JPanel pnlDataReport;


    int vUseID =  0;
    int vFloorID = 0;

    int vUseUpdate = 0;
      int vFloorUpdate = 0;

	FrmRoom()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		border1 = BorderFactory.createMatteBorder(0,0,2,0,Color.black);
		F2 = new Font("Sans Serif",Font.BOLD,18);


		setSize(screenSize.width,screenSize.height);
		ES = new TimeScreen3();
        es = new ReportScreen3();
		add(ES);

		pnlDataReport = ES.getDataReportPanel();
        pnlData = ES.getDataPanel();
	    pnlNew = ES.getNewPanel();
	    pnlSave = ES.getSavePanel();
	    pnlView = ES.getViewPanel();
		pnlEdit = ES.getEditPanel();
		pnlUpdate = ES.getUpdatePanel();
		pnlDelete = ES.getDeletePanel();
		pnlClose = ES.getClosePanel();
		pnlReport = ES.getReportPanel();
		pnlApply = ES.getApplyPanel();
		pnlSelect = ES.getSelectPanel();
		pnlEntry = ES.getEntryPanel();


        btnNew = ES.getNewButton();
        btnSave = ES.getSaveButton();
        btnUpdate = ES.getUpdateButton();
        btnView = ES.getViewButton();
        btnEdit = ES.getEditButton();
        btnDelete = ES.getDeleteButton();
        btnClose = ES.getCloseButton();
        btnReport = ES.getReportButton();
        pnlFloorUpdate = ES.getFirstComboPanel();
        cmbFloorUpdate = ES.getFirstComboBox();
        lblFloorUpdate = ES.getFirstComboLabel();
		lblFloorUpdate.setText("Floor Update...");
        pnlUseUpdate = ES.getSecondComboPanel();
        cmbUseUpdate = ES.getSecondComboBox();
        lblUseUpdate = ES.getSecondComboLabel();
        lblUseUpdate.setText("Use Update...");
        pnlRoomUpdate = ES.getThirdComboPanel();
	    cmbRoomUpdate = ES.getThirdComboBox();
	    lblRoomUpdate = ES.getThirdComboLabel();
		lblRoomUpdate.setText("Room Update...");
        btnApply = ES.getApplyButton();
        lblProgrammeHeading = ES.getProgrammeHeading();

		lblProgrammeHeading.setText("Room Form.. ");


		HtmlStyle.applyH1(lblProgrammeHeading);

		BlinkLabel bl = new BlinkLabel(lblProgrammeHeading,500);
		bl.start();

		int y = 50;
		int h = 30;
		int gap = 10;

		lblRoomID = new JLabel("RoomID");
		lblRoomID.setBounds(10,y,150,h);
		lblRoomID.setFont(F2);
		pnlData.add(lblRoomID);

		txtRoomID = new JTextField();
		txtRoomID.setBounds(160,y,100,h);
		txtRoomID.setFont(F2);
		pnlData.add(txtRoomID);

		y = y+h+gap;

		lblRoomNumber = new JLabel("Room Number");
		lblRoomNumber.setBounds(10,y,150,h);
		lblRoomNumber.setFont(F2);
		pnlData.add(lblRoomNumber);

		txtRoomNumber = new JTextField();
		txtRoomNumber.setBounds(160,y,250,h);
		txtRoomNumber.setFont(F2);
		pnlData.add(txtRoomNumber);

        y = y+h+gap;

		lblSittingCapacity = new JLabel("Sitting Capacity");
		lblSittingCapacity.setBounds(10,y,150,h);
		lblSittingCapacity.setFont(F2);
		pnlData.add(lblSittingCapacity);

		txtSittingCapacity = new JTextField();
		txtSittingCapacity.setBounds(160,y,250,h);
		txtSittingCapacity.setFont(F2);
		pnlData.add(txtSittingCapacity);

		y = y+h+gap;

		lblFloorID = new JLabel("Floor ID");
		lblFloorID.setBounds(10,y,150,h);
		lblFloorID.setFont(F2);
		pnlData.add(lblFloorID);

		cmbFloorID = new JComboBox();
		cmbFloorID.setBounds(160,y,200,h);
		cmbFloorID.setFont(F2);
		pnlData.add(cmbFloorID);

		y = y+h+gap;


		lblUseID = new JLabel("UseID");
		lblUseID.setBounds(10,y,150,h);
		lblUseID.setFont(F2);
		pnlData.add(lblUseID);

		cmbUseID = new JComboBox();
		cmbUseID.setBounds(160,y,200,h);
		cmbUseID.setFont(F2);
		pnlData.add(cmbUseID);

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

		ES.setDefaultOperation();
		ES.UIAreaSetting(450,250);
        es.ReportAreaSetting(700,550);


		addFloorRecords(cmbFloorID);
		addUseRecords(cmbUseID);

		//PanelState.enabledComponents(pnlNew);
		//PanelState.disabledComponents(pnlData);
		//PanelState.enabledComponents(pnlView);

		bst = new ButtonState();
		cbm = new ClsButtonManagement3();
		automateButtons();
		bst.setButtonState(ButtonState.InitialState);
		cbm.showButtonsOnUI(bst);

        createReport();

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

		cbm.manageSecondPanel(pnlUseUpdate);
		cbm.manageSecondLabel(lblUseUpdate);
		cbm.manageSecondCombo(cmbUseUpdate);

		cbm.manageThirdPanel(pnlRoomUpdate);
		cbm.manageThirdLabel(lblRoomUpdate);
		cbm.manageThirdCombo(cmbRoomUpdate);

	}



	public void initUI()
	{
		txtRoomID.setText("0");
		txtRoomNumber.setText("");
		txtSittingCapacity.setText("0");
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
	public void addRoomRecords(JComboBox cmbProcess,int mFloorID,int mUseID)
	{
		cmbProcess.removeActionListener(this);
		ClsRoom.addRoomRecords(cmbProcess,mFloorID,mUseID);
		cmbProcess.addActionListener(this);
	}
	public void addRoomRecordsFloorWise(JComboBox cmbProcess,int mFloorID)
	{
        cmbProcess.removeActionListener(this);
		ClsRoom.addRoomRecordsFloorWise(cmbProcess,mFloorID);
		cmbProcess.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==btnNew)
		{
			bst.setButtonState(ButtonState.NewState);
			cbm.showButtonsOnUI(bst);
			txtRoomID.setText("0");
			txtRoomNumber.requestFocus();
		}
		else if(ae.getSource()==cmbFloorID)
		{
			String mFloorName = (String)cmbFloorID.getSelectedItem();
			vFloorID = ClsFloor.getFloorIDFromName(mFloorName);
		}
		else if(ae.getSource()==cmbUseID)
		{
			String mUseName = (String)cmbUseID.getSelectedItem();
			vUseID = ClsUse.getUseIDFromName(mUseName);
		}
		else if(ae.getSource()==btnSave)
		{
			bst.setButtonState(ButtonState.SaveState);
			cbm.showButtonsOnUI(bst);
			ClsRoom temp = readUI();
			ClsRoom.addNewRecord(temp);
			JOptionPane.showMessageDialog(this,"Record Is Saved Successfully");
			initUI();

		}
		else if(ae.getSource()==btnUpdate)
		{
			bst.setButtonState(ButtonState.UpdateState);
			cbm.showButtonsOnUI(bst);
			ClsRoom temp = readUI();
			ClsRoom.updateRecord(temp);
			JOptionPane.showMessageDialog(this,"Record Is Updated Successfully");
			initUI();

		}
		else if(ae.getSource()==btnView)
		{

			bst.setButtonState(ButtonState.ViewState);
			cbm.showButtonsOnUI(bst);
			addFloorRecords(cmbFloorUpdate);

		}
		else if(ae.getSource()==cmbFloorUpdate)
		{
			String mFloorName = (String)cmbFloorUpdate.getSelectedItem();
		    vFloorUpdate = ClsFloor.getFloorIDFromName(mFloorName);

			PanelState.enabledComponents(pnlUseUpdate);
			addUseRecords(cmbUseUpdate);
		}
		else if(ae.getSource()==cmbUseUpdate)
		{

			String mUseName = (String)cmbUseUpdate.getSelectedItem();
			 vUseUpdate = ClsUse.getUseIDFromName(mUseName);

			addRoomRecords(cmbRoomUpdate,vFloorUpdate,vUseUpdate);
			PanelState.enabledComponents(pnlRoomUpdate);
			PanelState.enabledComponents(pnlApply);

		}
        else if(ae.getSource()==cmbRoomUpdate)
		{

			/*String mUseName = (String)cmbUseUpdate.getSelectedItem();
			 vUseUpdate = ClsUse.getUseIDFromName(mUseName);
            JOptionPane.showMessageDialog(null,vUseUpdate);
			addRoomRecords(cmbRoomUpdate,vFloorUpdate,vUseUpdate);
			PanelState.enabledComponents(pnlRoomUpdate);*/
			PanelState.enabledComponents(pnlApply);

		}

		else if(ae.getSource()==btnEdit)
		{
			bst.setButtonState(ButtonState.EditState);
			cbm.showButtonsOnUI(bst);

			txtRoomNumber.requestFocus();
			txtRoomNumber.selectAll();
		}
		else if(ae.getSource()==btnDelete)
		{
			 bst.setButtonState(ButtonState.DeleteState);
			cbm.showButtonsOnUI(bst);

			ClsRoom temp = readUI();
			ClsRoom.deleteRecord(temp);
			JOptionPane.showMessageDialog(this,"Record Is Deleted Successfully");
			initUI();
		}
		else if(ae.getSource()==btnClose)
		{
			 bst.setButtonUniqueState(ButtonState.CancelState);
			cbm.showButtonsOnUI(bst);
			initUI();
		}
		else if(ae.getSource()==btnApply)
		{
			bst.setButtonState(ButtonState.ApplyState);
			cbm.showButtonsOnUI(bst);

			String mRoomNumber = (String)cmbRoomUpdate.getSelectedItem();

			int mRoomID = ClsRoom.getRoomIDFromRoomNumber(mRoomNumber);
			ClsRoom temp = ClsRoom.getRoomInformation(mRoomID);
             ClsRoom.showRoom(temp);
			writeUI(temp);

		}
		else if(ae.getSource()==btnReport)
		{
			bst.setButtonCommonState(ButtonState.ReportState);
			cbm.showButtonsOnUI(bst);

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
		Rcols+=tool.addNewColumn("FloorID");
		Rcols+=tool.addNewColumn("UseID");

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
		tool.setColumnWidth("RoomID",80);
		tool.setColumnWidth("RoomNumber",400);
		tool.setColumnWidth("FloorID",80);
		tool.setColumnWidth("FloorID",80);
		tool.setColumnWidth("UseID",80);
	}

    void setColumnsData()
	{

		tool.removeAllRows();

		ClsRoom Data[]=ClsRoom.getAllRoomInformation();

		for(int i=0;i<Data.length;i++)
		{
			Object Objectdata[]=new Object[Rcols];

			Objectdata[0]=i+1;
			Objectdata[1]=Data[i].getRoomNumber();
			Objectdata[2]=Data[i].getSittingCapacity();
			Objectdata[3]=Data[i].getFloorID();
			Objectdata[4]=Data[i].getUseID();
			tool.addNewRow(Objectdata);
		}
	}


	public void writeUI(ClsRoom temp)
	{
		txtRoomID.setText(String.valueOf(temp.getRoomID()));
		txtRoomNumber.setText(temp.getRoomNumber());
		txtSittingCapacity.setText(String.valueOf(temp.getSittingCapacity()));
		vUseID=temp.getUseID();
		ClsUse temp1 = ClsUse.getUseInformation(vUseID);
		cmbUseID.setSelectedItem(temp1.getUseName());

        vFloorID= temp.getFloorID();
		ClsFloor temp2 = ClsFloor.getFloorInformation(vFloorID);
		cmbFloorID.setSelectedItem(temp2.getFloorName());

	}

	ClsRoom readUI()
	{
		ClsRoom temp = new ClsRoom();
		temp.setRoomID(Integer.parseInt(txtRoomID.getText()));
		temp.setRoomNumber(txtRoomNumber.getText());
		temp.setSittingCapacity(Integer.parseInt(txtSittingCapacity.getText()));
	   temp.setFloorID(vFloorID);
		temp.setUseID(vUseID);
		return(temp);
	}

	public static void main(String args[])
	{
		FrmRoom A = new FrmRoom();
	}
}