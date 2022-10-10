import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import timescreen.*;
import HtmlSetting.HtmlStyle;
import myUtility.*;
import javax.swing.border.*;
import DBReport.*;
import reportscreen.*;


class FrmBatchSlot extends JFrame implements ActionListener
{
	//int w = 3020;
	TimeScreen2 ES;

	JLabel lblBatchSlotID;
	JLabel  lblBatchSlotName;
	JLabel lblBatchStudents;
	JLabel  lblCourseID;
	JLabel  lblBatchSlotNameUpdate;
	JLabel  lblProgrammeHeading;

    JTextField txtBatchSlotID;
    JTextField txtBatchSlotName;
    JTextField txtBatchStudents;

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

	JPanel pnlBatchSlotUpdate;
    JComboBox cmbBatchSlotUpdate;
	JLabel lblBatchSlotUpdate;

    JPanel pnlCourseUpdate;
    JComboBox cmbCourseUpdate;
	JLabel lblCourseUpdate;

	ReportTool tool;
	ButtonState bst;
	ClsButtonManagement2 cbm;

	JPanel pnlDataReport;

    int Rcols;
	JComboBox cmbCourseID;
    int vCourseID = 0;

	FrmBatchSlot()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		border1 = BorderFactory.createMatteBorder(0,0,2,0,Color.black);
		F2 = new Font("Sans Serif",Font.BOLD,18);


		setSize(screenSize.width,screenSize.height);
		ES = new TimeScreen2();
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
        pnlCourseUpdate = ES.getFirstComboPanel();
        cmbCourseUpdate = ES.getFirstComboBox();
        lblCourseUpdate = ES.getFirstComboLabel();
		lblCourseUpdate.setText("Course Update...");
        pnlBatchSlotUpdate = ES.getSecondComboPanel();
        cmbBatchSlotUpdate = ES.getSecondComboBox();
        lblBatchSlotUpdate = ES.getSecondComboLabel();
		lblBatchSlotUpdate.setText("BatchSlot Update...");
        btnApply = ES.getApplyButton();
        lblProgrammeHeading = ES.getProgrammeHeading();

		lblProgrammeHeading.setText("BatchSlot Form ");

		HtmlStyle.applyH1(lblProgrammeHeading);

		BlinkLabel bl = new BlinkLabel(lblProgrammeHeading,500);
		bl.start();

		int y = 50;
		int h = 30;
		int gap = 10;

		lblBatchSlotID = new JLabel("BatchSlotID");
		lblBatchSlotID.setBounds(10,y,150,h);
		lblBatchSlotID.setFont(F2);
		pnlData.add(lblBatchSlotID);

		txtBatchSlotID = new JTextField();
		txtBatchSlotID.setBounds(160,y,100,h);
		txtBatchSlotID.setFont(F2);
		pnlData.add(txtBatchSlotID);

		y = y+h+gap;

		lblBatchSlotName = new JLabel("BatchSlot Name");
		lblBatchSlotName.setBounds(10,y,150,h);
		lblBatchSlotName.setFont(F2);
		pnlData.add(lblBatchSlotName);

		txtBatchSlotName = new JTextField();
		txtBatchSlotName.setBounds(160,y,250,h);
		txtBatchSlotName.setFont(F2);
		pnlData.add(txtBatchSlotName);

		y = y+h+gap;

		lblBatchStudents = new JLabel("BatchStudents");
		lblBatchStudents.setBounds(10,y,150,h);
		lblBatchStudents.setFont(F2);
		pnlData.add(lblBatchStudents);

		txtBatchStudents = new JTextField();
		txtBatchStudents.setBounds(160,y,250,h);
		txtBatchStudents.setFont(F2);
		pnlData.add(txtBatchStudents);

		y = y+h+gap;

		lblCourseID = new JLabel("CourseID");
		lblCourseID.setBounds(10,y,150,h);
		lblCourseID.setFont(F2);
		pnlData.add(lblCourseID);

		cmbCourseID = new JComboBox();
		cmbCourseID.setBounds(160,y,200,h);
		cmbCourseID.setFont(F2);
		pnlData.add(cmbCourseID);

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
        ES.ReportAreaSetting(1050,720);


		addCourseRecords(cmbCourseID);

		//PanelBatchSlot.enabledComponents(pnlNew);
		//PanelBatchSlot.disabledComponents(pnlData);
		//PanelBatchSlot.enabledComponents(pnlView);
		//createReport();
		bst = new ButtonState();
		cbm = new ClsButtonManagement2();
		automateButtons();
		bst.setButtonState(ButtonState.InitialState);
		cbm.showButtonsOnUI(bst);


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
		cbm.manageFirstPanel(pnlCourseUpdate);
		cbm.manageFirstLabel(lblCourseUpdate);
		cbm.manageFirstCombo(cmbCourseUpdate);
		cbm.manageSecondPanel(pnlBatchSlotUpdate);
		cbm.manageSecondLabel(lblBatchSlotUpdate);
		cbm.manageSecondCombo(cmbBatchSlotUpdate);
	}

	public void initUI()
	{
		txtBatchSlotID.setText("0");
		txtBatchSlotName.setText("");
	}
	public void addCourseRecords(JComboBox cmbProcess)
	{
		cmbProcess.removeActionListener(this);
		ClsCourse.addCourseRecords(cmbProcess);
		cmbProcess.addActionListener(this);
	}
	public void addBatchSlotRecords(JComboBox cmbProcess,int mCourseID)
	{
		cmbProcess.removeActionListener(this);
		ClsBatchSlot.addBatchSlotRecords(cmbProcess,mCourseID);
		cmbProcess.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==btnNew)
		{
			bst.setButtonState(ButtonState.NewState);
			cbm.showButtonsOnUI(bst);
			//PanelBatchSlot.enabledComponents(pnlData);
			//PanelBatchSlot.disabledComponents(pnlNew);
           // PanelBatchSlot.disabledComponents(pnlView);
           // PanelBatchSlot.enabledComponents(pnlSave);
           // PanelBatchSlot.enabledComponents(pnlClose);
            txtBatchSlotID.setText("0");
			txtBatchSlotName.requestFocus();
		}
		else if(ae.getSource()==cmbCourseID)
		{
			String mCourseName = (String)cmbCourseID.getSelectedItem();
			vCourseID = ClsCourse.getCourseIDFromName(mCourseName);

		}
		else if(ae.getSource()==btnSave)
		{

			bst.setButtonState(ButtonState.SaveState);
			cbm.showButtonsOnUI(bst);
			ClsBatchSlot temp = readUI();
			ClsBatchSlot.addNewRecord(temp);
			JOptionPane.showMessageDialog(this,"Record Is Saved Successfully");
			initUI();
		}
		else if(ae.getSource()==btnUpdate)
		{
			bst.setButtonState(ButtonState.UpdateState);
			cbm.showButtonsOnUI(bst);
			ClsBatchSlot temp = readUI();
			ClsBatchSlot.updateRecord(temp);
			JOptionPane.showMessageDialog(this,"Record Is Updated Successfully");
			initUI();
		}
		else if(ae.getSource()==btnView)
		{
			bst.setButtonState(ButtonState.ViewState);
			cbm.showButtonsOnUI(bst);
			addCourseRecords(cmbCourseUpdate);

		}
		else if(ae.getSource()==cmbCourseUpdate)
		{
			String mCourseName = (String)cmbCourseUpdate.getSelectedItem();
			int mCourseID = ClsCourse.getCourseIDFromName(mCourseName);
			addBatchSlotRecords(cmbBatchSlotUpdate,mCourseID);
			PanelState.enabledComponents(pnlBatchSlotUpdate);
		}
		else if(ae.getSource()==cmbBatchSlotUpdate)
		{
			PanelState.enabledComponents(pnlApply);
		}
		else if(ae.getSource()==btnEdit)
		{
			bst.setButtonState(ButtonState.EditState);
			cbm.showButtonsOnUI(bst);
			txtBatchSlotName.requestFocus();
			txtBatchSlotName.selectAll();
		}
		else if(ae.getSource()==btnDelete)
		{
			 bst.setButtonState(ButtonState.DeleteState);
			cbm.showButtonsOnUI(bst);

			ClsBatchSlot temp = readUI();
			ClsBatchSlot.deleteRecord(temp);
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

			String mBatchSlotName = (String)cmbBatchSlotUpdate.getSelectedItem();
			int mBatchSlotID = ClsBatchSlot.getBatchSlotIDFromName(mBatchSlotName);
			ClsBatchSlot temp = ClsBatchSlot.getBatchSlotInformation(mBatchSlotID);
			writeUI(temp);
		}
		else if(ae.getSource()==btnReport)
		{
			bst.setButtonCommonState(ButtonState.ReportState);
			cbm.showButtonsOnUI(bst);
			createReport();
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
		Rcols+=tool.addNewColumn("CourseID");


	}
	void setColumnsAlignment()
	{
		tool.setColumnAlignment(0,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(1,ReportTool.ALIGN_LEFT);
		tool.setColumnAlignment(2,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(3,ReportTool.ALIGN_CENTER);


	}
	void setColumnsWidth()
	{
		tool.setColumnWidth("BatchSlotID",80);
		tool.setColumnWidth("BatchSlotName",300);
		tool.setColumnWidth("BatchStudents",100);
		tool.setColumnWidth("CourseID",100);

	}

	void setColumnsData()
	{

		tool.removeAllRows();

		ClsBatchSlot Data[]=ClsBatchSlot.getAllBatchSlotInformation();

		for(int i=0;i<Data.length;i++)
		{
			Object Objectdata[]=new Object[Rcols];

			Objectdata[0]=i+1;
			Objectdata[1]=Data[i].getBatchSlotName();
			Objectdata[2]=Data[i].getBatchStudents();
			Objectdata[3]=Data[i].getCourseID();

			tool.addNewRow(Objectdata);
		}
	}

	public void writeUI(ClsBatchSlot temp)
	{
		txtBatchSlotID.setText(String.valueOf(temp.getBatchSlotID()));
		txtBatchSlotName.setText(temp.getBatchSlotName());
		int mCourseID=temp.getCourseID();
		String mCourseName = ClsCourse.getCourseNameFromID(mCourseID);
		cmbCourseID.setSelectedItem(mCourseName);
	}

	ClsBatchSlot readUI()
	{
		ClsBatchSlot temp = new ClsBatchSlot();
		temp.setBatchSlotID(Integer.parseInt(txtBatchSlotID.getText()));
		temp.setBatchSlotName(txtBatchSlotName.getText());
		temp.setCourseID(vCourseID);
		return(temp);
	}

	public static void main(String args[])
	{
		FrmBatchSlot A = new FrmBatchSlot();
	}
}