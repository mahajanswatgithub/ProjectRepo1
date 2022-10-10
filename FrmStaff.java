import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import timescreen.*;
import HtmlSetting.HtmlStyle;
import myUtility.*;
import javax.swing.border.*;
import DBReport.*;
import reportscreen.*;

class FrmStaff extends JFrame implements ActionListener
{
	//int w = 3020;
	TimeScreen3 ES;
    ReportScreen3 es;

	JLabel lblStaffID;
	JLabel  lblStaffName;
	JLabel  lblStaffWeeklyLoad;
	JLabel  lblStaffEducation;
	JLabel  lblLevelID;
    JLabel lblCourseID;

	JLabel  lblStaffNameUpdate;
	JLabel  lblProjectHeading;
	JLabel  lblProgrammeHeading;

    JTextField txtStaffID;
    JTextField txtStaffName;
    JTextField txtStaffWeeklyLoad;
    JTextField txtStaffEducation;

	JPanel  pnlData;
	JPanel pnlEntry;
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

    Font F2;

    Border border1;

	JPanel pnlStaffUpdate;
    JComboBox cmbStaffUpdate;
	JLabel lblStaffUpdate;

    JPanel pnlLevelUpdate;
    JComboBox cmbLevelUpdate;
	JLabel lblLevelUpdate;

    JPanel pnlCourseUpdate;
    JComboBox cmbCourseUpdate;
	JLabel lblCourseUpdate;

	JComboBox cmbLevelID;
	JComboBox cmbCourseID;
    int vLevelID = 0;
    int vCourseID = 0;

	ReportTool tool;
	ButtonState bst;
	ClsButtonManagement3 cbm;
	int Rcols;

	JPanel pnlDataReport;



	FrmStaff()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		border1 = BorderFactory.createMatteBorder(0,0,2,0,Color.black);
		F2 = new Font("Sans Serif",Font.BOLD,18);


		setSize(screenSize.width,screenSize.height);
		ES = new TimeScreen3();
		es = new ReportScreen3();
		add(ES);

		pnlDataReport = ES.getDataReportPanel();
        pnlEntry = ES.getEntryPanel();
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

        pnlLevelUpdate = ES.getSecondComboPanel();
        cmbLevelUpdate = ES.getSecondComboBox();
        lblLevelUpdate = ES.getSecondComboLabel();
        lblLevelUpdate.setText("Level Update...");

        pnlStaffUpdate = ES.getThirdComboPanel();
        cmbStaffUpdate = ES.getThirdComboBox();
        lblStaffUpdate = ES.getThirdComboLabel();
        lblStaffUpdate.setText("Staff Update...");

        btnApply = ES.getApplyButton();
        lblProgrammeHeading = ES.getProgrammeHeading();
        lblProgrammeHeading.setText("Staff Form");
		HtmlStyle.applyH1(lblProgrammeHeading);

		BlinkLabel bl = new BlinkLabel(lblProgrammeHeading,500);
		bl.start();

		int y = 50;
		int h = 30;
		int gap = 10;

		lblStaffID = new JLabel("Staff ID");
		lblStaffID.setBounds(10,y,150,h);
		lblStaffID.setFont(F2);
		pnlData.add(lblStaffID);

		txtStaffID = new JTextField();
		txtStaffID.setBounds(160,y,100,h);
		txtStaffID.setFont(F2);
		pnlData.add(txtStaffID);

		y = y+h+gap;

		lblStaffName = new JLabel("Staff Name");
		lblStaffName.setBounds(10,y,150,h);
		lblStaffName.setFont(F2);
		pnlData.add(lblStaffName);

		txtStaffName = new JTextField();
		txtStaffName.setBounds(160,y,250,h);
		txtStaffName.setFont(F2);
		pnlData.add(txtStaffName);

		y = y+h+gap;

		lblStaffWeeklyLoad = new JLabel("StaffWeeklyLoad");
		lblStaffWeeklyLoad.setBounds(10,y,150,h);
		lblStaffWeeklyLoad.setFont(F2);
		pnlData.add(lblStaffWeeklyLoad);

		txtStaffWeeklyLoad = new JTextField();
		txtStaffWeeklyLoad.setBounds(160,y,250,h);
		txtStaffWeeklyLoad.setFont(F2);
		pnlData.add(txtStaffWeeklyLoad);
		y = y+h+gap;

		lblStaffEducation = new JLabel("StaffEducation");
		lblStaffEducation.setBounds(10,y,150,h);
		lblStaffEducation.setFont(F2);
		pnlData.add(lblStaffEducation);

		txtStaffEducation = new JTextField();
		txtStaffEducation.setBounds(160,y,250,h);
		txtStaffEducation.setFont(F2);
		pnlData.add(txtStaffEducation);

         y = y+h+gap;

		lblCourseID = new JLabel("CourseID");
		lblCourseID.setBounds(10,y,150,h);
		lblCourseID.setFont(F2);
		pnlData.add(lblCourseID);

		cmbCourseID = new JComboBox();
		cmbCourseID.setBounds(160,y,200,h);
		cmbCourseID.setFont(F2);
		pnlData.add(cmbCourseID);

		y = y+h+gap;

		lblLevelID = new JLabel("LevelID");
		lblLevelID.setBounds(10,y,150,h);
		lblLevelID.setFont(F2);
		pnlData.add(lblLevelID);

		cmbLevelID = new JComboBox();
		cmbLevelID.setBounds(160,y,200,h);
		cmbLevelID.setFont(F2);
		pnlData.add(cmbLevelID);

		tool=new ReportTool(500,500);
		tool.setBounds(10,10,400,4400);
		tool.setBackground(null);
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
		ES.UIAreaSetting(450,350);

		addCourseRecords(cmbCourseID);

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

		cbm.manageFirstPanel(pnlCourseUpdate);
		cbm.manageFirstLabel(lblCourseUpdate);
		cbm.manageFirstCombo(cmbCourseUpdate);

		cbm.manageSecondPanel(pnlLevelUpdate);
		cbm.manageSecondLabel(lblLevelUpdate);
		cbm.manageSecondCombo(cmbLevelUpdate);

		cbm.manageThirdPanel(pnlStaffUpdate);
		cbm.manageThirdLabel(lblStaffUpdate);
		cbm.manageThirdCombo(cmbStaffUpdate);

	}

	public void initUI()
	{
		txtStaffID.setText("0");
		txtStaffName.setText("");
		txtStaffWeeklyLoad.setText("0");
		txtStaffEducation.setText("");
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

    public void addStaffRecords(JComboBox cmbProcess,int mLevelID)
	{
		cmbProcess.removeActionListener(this);
		ClsStaff.addStaffRecords(cmbProcess,mLevelID);
		cmbProcess.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==btnNew)
		{
			bst.setButtonState(ButtonState.NewState);
			cbm.showButtonsOnUI(bst);
			txtStaffID.setText("0");
			txtStaffName.requestFocus();
			txtStaffWeeklyLoad.setText("0");
			txtStaffEducation.setText("");
		}
        else if(ae.getSource()==cmbCourseID)
		{
			String mCourseName = (String)cmbCourseID.getSelectedItem();
			vCourseID = ClsCourse.getCourseIDFromName(mCourseName);
            addLevelRecords(cmbLevelID,vCourseID);
		}
		else if(ae.getSource()==cmbLevelID)
		{
			String mLevelName = (String)cmbLevelID.getSelectedItem();
			vLevelID = ClsLevel.getLevelIDFromName(mLevelName);

		}
		else if(ae.getSource()==btnSave)
		{
			bst.setButtonState(ButtonState.SaveState);
			cbm.showButtonsOnUI(bst);
			ClsStaff temp = readUI();
			ClsStaff.addNewRecord(temp);
			JOptionPane.showMessageDialog(this,"Record Is Saved Successfully");
			initUI();
		}
		else if(ae.getSource()==btnUpdate)
		{
			bst.setButtonState(ButtonState.UpdateState);
			cbm.showButtonsOnUI(bst);
			ClsStaff temp = readUI();
			ClsStaff.updateRecord(temp);
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
		//	JOptionPane.showMessageDialog(null,mLevelID);
			addLevelRecords(cmbLevelUpdate,mCourseID);
			PanelState.enabledComponents(pnlLevelUpdate);
		}
        else if(ae.getSource()==cmbLevelUpdate)
		{
			String mLevelName = (String)cmbLevelUpdate.getSelectedItem();
			int mLevelID = ClsLevel.getLevelIDFromName(mLevelName);
			JOptionPane.showMessageDialog(null,mLevelID);
			addStaffRecords(cmbStaffUpdate,mLevelID);
			PanelState.enabledComponents(pnlStaffUpdate);
		}
		else if(ae.getSource()==cmbStaffUpdate)
		{
			PanelState.enabledComponents(pnlApply);
		}
		else if(ae.getSource()==btnEdit)
		{
            bst.setButtonState(ButtonState.EditState);
			cbm.showButtonsOnUI(bst);
			txtStaffName.requestFocus();
			txtStaffName.selectAll();
		}
		else if(ae.getSource()==btnDelete)
		{
	        bst.setButtonState(ButtonState.DeleteState);
			cbm.showButtonsOnUI(bst);
			ClsStaff temp = readUI();
			ClsStaff.deleteRecord(temp);
			JOptionPane.showMessageDialog(this,"Record Is Deleted Successfully");
			initUI();
		}
		else if(ae.getSource()==btnClose)
		{
			initUI();
		}
		else if(ae.getSource()==btnApply)
		{
			bst.setButtonState(ButtonState.ApplyState);
			cbm.showButtonsOnUI(bst);
			String mStaffName = (String)cmbStaffUpdate.getSelectedItem();
			int mStaffID = ClsStaff.getStaffIDFromName(mStaffName);
			ClsStaff temp = ClsStaff.getStaffInformation(mStaffID);
			writeUI(temp);
		}
		else if(ae.getSource()==btnReport)
		{
			bst.setButtonCommonState(ButtonState.ReportState);
			cbm.showButtonsOnUI(bst);

			setColumnsData();
		}
   }

	public void writeUI(ClsStaff temp)
	{
		txtStaffID.setText(String.valueOf(temp.getStaffID()));
		txtStaffName.setText(temp.getStaffName());
		txtStaffWeeklyLoad.setText(String.valueOf(temp.getStaffWeeklyLoad()));
		txtStaffEducation.setText(temp.getStaffEducation());
		vLevelID=temp.getLevelID();
		ClsCourseLevel temp1 = ClsCourseLevel.getCourseLevelFromCourseID(vLevelID);
		cmbCourseID.setSelectedItem(temp1.getCourseName());
		addLevelRecords(cmbLevelID,temp1.getCourseID());
		cmbLevelID.setSelectedItem(temp1.getLevelName());
	}

	ClsStaff readUI()
	{
		ClsStaff temp = new ClsStaff();
		temp.setStaffID(Integer.parseInt(txtStaffID.getText()));
		temp.setStaffName(txtStaffName.getText());
		temp.setStaffWeeklyLoad(Integer.parseInt(txtStaffWeeklyLoad.getText()));
		temp.setStaffEducation(txtStaffEducation.getText());
      //  temp.setCourseID(vCourseID);
		temp.setLevelID(vLevelID);
		return(temp);
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
		Rcols+=tool.addNewColumn("LevelID");
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
		tool.setColumnWidth("StaffID",30);
		tool.setColumnWidth("StaffName",80);
		tool.setColumnWidth("StaffWeeklyLoad",80);
		tool.setColumnWidth("StaffEducation",80);
		tool.setColumnWidth("LevelID",80);

	}

	void setColumnsData()
	{

		tool.removeAllRows();

		ClsStaff Data[]=ClsStaff.getAllStaffInformation();

		for(int i=0;i<Data.length;i++)
		{
			Object Objectdata[]=new Object[Rcols];

			Objectdata[0]=i+1;
			Objectdata[1]=Data[i].getStaffName();
			Objectdata[2]=Data[i].getStaffWeeklyLoad();
			Objectdata[3]=Data[i].getStaffEducation();
			Objectdata[4]=Data[i].getLevelID();
			tool.addNewRow(Objectdata);
		}
	}


	public static void main(String args[])
	{
		FrmStaff A = new FrmStaff();
	}
}