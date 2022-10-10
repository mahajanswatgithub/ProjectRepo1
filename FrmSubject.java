import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import timescreen.*;
import reportscreen.*;
import HtmlSetting.HtmlStyle;
import myUtility.*;
import javax.swing.border.*;
import DBReport.*;


class FrmSubject extends JFrame implements ActionListener
{
	//int w = 3020;
	TimeScreen2 ES;
	//ReportScreen2 es;

	JLabel lblSubjectID;
	JLabel  lblSubjectName;
	JLabel  lblAbbreviation;
	JLabel  lblSubjectPaperCode;
	JLabel  lblSubjectLearning;
	JLabel  lblCourseID;
	JLabel  lblSemisterID;
	JLabel  lblSubjectNameUpdate;
	JLabel  lblProgrammeHeading;

    JTextField txtSubjectID;
    JTextField txtSubjectName;
    JTextField txtAbbreviation;
    JTextField txtSubjectPaperCode;
    JTextField txtSubjectLearning;

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

	JPanel pnlSubjectUpdate;
    JComboBox cmbSubjectUpdate;
	JLabel lblSubjectUpdate;

    JPanel pnlCourseUpdate;
    JComboBox cmbCourseUpdate;
	JLabel lblCourseUpdate;

	ReportTool tool;
	ButtonState bst;
	ClsButtonManagement2 cbm;
    int Rcols;

	JPanel pnlDataReport;

	JComboBox cmbCourseID;
	JComboBox cmbSemisterID;

    int vCourseID = 0;
    int vSemisterID = 0;

	FrmSubject()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		border1 = BorderFactory.createMatteBorder(0,0,2,0,Color.black);
		F2 = new Font("Sans Serif",Font.BOLD,18);


		setSize(screenSize.width,screenSize.height);
		ES = new TimeScreen2();
	//	es = new ReportScreen2();
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
        pnlSubjectUpdate = ES.getSecondComboPanel();
        cmbSubjectUpdate = ES.getSecondComboBox();
        lblSubjectUpdate = ES.getSecondComboLabel();
		lblSubjectUpdate.setText("Subject Update...");
        btnApply = ES.getApplyButton();
        lblProgrammeHeading = ES.getProgrammeHeading();

		lblProgrammeHeading.setText("Subject Form ");

		HtmlStyle.applyH1(lblProgrammeHeading);

		BlinkLabel bl = new BlinkLabel(lblProgrammeHeading,500);
		bl.start();

		int y = 10;
		int h = 30;
		int gap = 10;

		lblSubjectID = new JLabel("SubjectID");
		lblSubjectID.setBounds(10,y,150,h);
		lblSubjectID.setFont(F2);
		pnlData.add(lblSubjectID);

		txtSubjectID = new JTextField();
		txtSubjectID.setBounds(160,y,100,h);
		txtSubjectID.setFont(F2);
		pnlData.add(txtSubjectID);

		y = y+h+gap;

		lblSubjectName = new JLabel("Subject Name");
		lblSubjectName.setBounds(10,y,150,h);
		lblSubjectName.setFont(F2);
		pnlData.add(lblSubjectName);

		txtSubjectName = new JTextField();
		txtSubjectName.setBounds(160,y,250,h);
		txtSubjectName.setFont(F2);
		pnlData.add(txtSubjectName);

		y = y+h+gap;

		lblAbbreviation = new JLabel("Abbreviation");
		lblAbbreviation.setBounds(10,y,150,h);
		lblAbbreviation.setFont(F2);
		pnlData.add(lblAbbreviation);

		txtAbbreviation = new JTextField();
		txtAbbreviation.setBounds(160,y,250,h);
		txtAbbreviation.setFont(F2);
		pnlData.add(txtAbbreviation);

		y = y+h+gap;

		lblSubjectPaperCode = new JLabel("Subject Paper Code");
		lblSubjectPaperCode.setBounds(10,y,150,h);
		lblSubjectPaperCode.setFont(F2);
		pnlData.add(lblSubjectPaperCode);

		txtSubjectPaperCode = new JTextField();
		txtSubjectPaperCode.setBounds(160,y,250,h);
		txtSubjectPaperCode.setFont(F2);
		pnlData.add(txtSubjectPaperCode);

		y = y+h+gap;

		lblSubjectLearning = new JLabel("Subject Learning");
		lblSubjectLearning.setBounds(10,y,150,h);
		lblSubjectLearning.setFont(F2);
		pnlData.add(lblSubjectLearning);

		txtSubjectLearning = new JTextField();
		txtSubjectLearning.setBounds(160,y,250,h);
		txtSubjectLearning.setFont(F2);
		pnlData.add(txtSubjectLearning);

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

		lblSemisterID = new JLabel("SemisterID");
		lblSemisterID.setBounds(10,y,150,h);
		lblSemisterID.setFont(F2);
		pnlData.add(lblSemisterID);

		cmbSemisterID = new JComboBox();
		cmbSemisterID.setBounds(160,y,200,h);
		cmbSemisterID.setFont(F2);
		pnlData.add(cmbSemisterID);

		tool=new ReportTool(100,100);
		tool.setBounds(10,10,400,444);
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
		ES.UIAreaSetting(450,300);
//        es.ReportAreaSetting(900,520);

		addCourseRecords(cmbCourseID);

		createReport();
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
		cbm.manageSecondPanel(pnlSubjectUpdate);
		cbm.manageSecondLabel(lblSubjectUpdate);
		cbm.manageSecondCombo(cmbSubjectUpdate);
	}

	public void initUI()
	{
		txtSubjectID.setText("0");
		txtSubjectName.setText("");
		txtAbbreviation.setText("");
		txtSubjectPaperCode.setText("0");
		txtSubjectLearning.setText("");
	}
	public void addCourseRecords(JComboBox cmbProcess)
	{
		cmbProcess.removeActionListener(this);
		ClsCourse.addCourseRecords(cmbProcess);
		cmbProcess.addActionListener(this);
	}

	public void addSemisterRecords(JComboBox cmbProcess)
	{
		cmbProcess.removeActionListener(this);
		cmbProcess.addItem("Select Semister...");
		for(int i=1;i<=6;i++)
		{
			cmbProcess.addItem(i);
		}
		cmbProcess.addActionListener(this);
	}

	public void addSubjectRecords(JComboBox cmbProcess,int mCourseID)
	{
		cmbProcess.removeActionListener(this);
		ClsSubject.addSubjectRecords(cmbProcess,mCourseID);
		cmbProcess.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==btnNew)
		{
			bst.setButtonState(ButtonState.NewState);
			cbm.showButtonsOnUI(bst);

           	initUI();
			txtSubjectName.requestFocus();
		}
		else if(ae.getSource()==cmbCourseID)
		{
			String mCourseName = (String)cmbCourseID.getSelectedItem();
			vCourseID = ClsCourse.getCourseIDFromName(mCourseName);
			addSemisterRecords(cmbSemisterID);

		}
		else if(ae.getSource()==cmbSemisterID)
		{
			vSemisterID = (int)cmbSemisterID.getSelectedItem();
		}
		else if(ae.getSource()==btnSave)
		{

			bst.setButtonState(ButtonState.SaveState);
			cbm.showButtonsOnUI(bst);
			ClsSubject temp = readUI();
			ClsSubject.addNewRecord(temp);
			JOptionPane.showMessageDialog(this,"Record Is Saved Successfully");
			initUI();
		}
		else if(ae.getSource()==btnUpdate)
		{
			bst.setButtonState(ButtonState.UpdateState);
			cbm.showButtonsOnUI(bst);
			ClsSubject temp = readUI();
			ClsSubject.updateRecord(temp);
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
			addSubjectRecords(cmbSubjectUpdate,mCourseID);
			PanelState.enabledComponents(pnlSubjectUpdate);
		}
		else if(ae.getSource()==cmbSubjectUpdate)
		{
			//PanelSubject.enabledComponents(pnlApply);
		}
		else if(ae.getSource()==btnEdit)
		{
			bst.setButtonState(ButtonState.EditState);
			cbm.showButtonsOnUI(bst);
			txtSubjectName.requestFocus();
			txtSubjectName.selectAll();
		}
		else if(ae.getSource()==btnDelete)
		{
			 bst.setButtonState(ButtonState.DeleteState);
			cbm.showButtonsOnUI(bst);

			ClsSubject temp = readUI();
			ClsSubject.deleteRecord(temp);
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

			String mSubjectName = (String)cmbSubjectUpdate.getSelectedItem();
			int mSubjectID = ClsSubject.getSubjectIDFromName(mSubjectName);
			ClsSubject temp = ClsSubject.getSubjectInformation(mSubjectID);
			writeUI(temp);
		}
		else if(ae.getSource()==btnReport)
		{
			bst.setButtonCommonState(ButtonState.ReportState);
			cbm.showButtonsOnUI(bst);
			setColumnsData();
		}
   }

	public void writeUI(ClsSubject temp)
	{
		txtSubjectID.setText(String.valueOf(temp.getSubjectID()));
		txtSubjectName.setText(temp.getSubjectName());
		txtAbbreviation.setText(temp.getAbbreviation());
		txtSubjectPaperCode.setText(String.valueOf(temp.getSubjectPaperCode()));
		txtSubjectLearning.setText(temp.getSubjectLearning());

		int mCourseID=temp.getCourseID();
		String mCourseName = ClsCourse.getCourseNameFromID(mCourseID);
		cmbCourseID.setSelectedItem(mCourseName);

		int mSemisterID=temp.getSemisterID();
		cmbSemisterID.setSelectedItem(mSemisterID);
	}

	ClsSubject readUI()
	{
		ClsSubject temp = new ClsSubject();
		temp.setSubjectID(Integer.parseInt(txtSubjectID.getText()));
		temp.setSubjectName(txtSubjectName.getText());
		temp.setAbbreviation(txtAbbreviation.getText());
		temp.setSubjectPaperCode(Integer.parseInt(txtSubjectPaperCode.getText()));
		temp.setSubjectLearning(txtSubjectLearning.getText());
		temp.setCourseID(vCourseID);
		temp.setSemisterID(vSemisterID);
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
		Rcols+=tool.addNewColumn("SubjectID");
		Rcols+=tool.addNewColumn("SubjectName");
		Rcols+=tool.addNewColumn("Abbreviation");
		Rcols+=tool.addNewColumn("SubjectPaperCode");
		Rcols+=tool.addNewColumn("SubjectLearning");
		Rcols+=tool.addNewColumn("CourseID");
		Rcols+=tool.addNewColumn("SemisterID");
	}
	void setColumnsAlignment()
	{
		tool.setColumnAlignment(0,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(1,ReportTool.ALIGN_LEFT);
		tool.setColumnAlignment(2,ReportTool.ALIGN_LEFT);
		tool.setColumnAlignment(3,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(4,ReportTool.ALIGN_LEFT);
		tool.setColumnAlignment(5,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(6,ReportTool.ALIGN_CENTER);
	}
	void setColumnsWidth()
	{
		tool.setColumnWidth("SubjectID",80);
		tool.setColumnWidth("SubjectName",180);
		tool.setColumnWidth("Abbreviation",180);
		tool.setColumnWidth("SubjectPaperCode",180);
		tool.setColumnWidth("SubjectLearning",180);
		tool.setColumnWidth("CourseID",100);
		tool.setColumnWidth("SemisterID",100);
	}

	void setColumnsData()
	{

		tool.removeAllRows();

		ClsSubject Data[]=ClsSubject.getAllSubjectInformation();

		for(int i=0;i<Data.length;i++)
		{
			Object Objectdata[]=new Object[Rcols];

			Objectdata[0]=i+1;
			Objectdata[1]=Data[i].getSubjectName();
			Objectdata[2]=Data[i].getAbbreviation();
			Objectdata[3]=Data[i].getSubjectPaperCode();
			Objectdata[4]=Data[i].getSubjectLearning();
			Objectdata[5]=Data[i].getCourseID();
			Objectdata[6]=Data[i].getSemisterID();

			tool.addNewRow(Objectdata);
		}
	}


	public static void main(String args[])
	{
		FrmSubject A = new FrmSubject();
	}
}