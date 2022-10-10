import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import timescreen.*;
import HtmlSetting.HtmlStyle;
import myUtility.*;
import javax.swing.border.*;
import DBReport.*;
import InputRestriction.*;

class FrmCourse extends JFrame implements ActionListener
{
	//int w = 3020;
	TimeScreen ES;

	JLabel  lblCourseID;
	JLabel  lblCourseName;
	JLabel  lblCoursePattern;
	JLabel  lblCourseDuration;
	JLabel  lblCourseCapacity;
	JLabel  lblCourseStartYear;

	JLabel  lblProgrammeHeading;

    JTextField txtCourseID;
    JTextField txtCourseName;
    JTextField txtCoursePattern;
    JTextField txtCourseDuration;
    JTextField txtCourseCapacity;
    JTextField txtCourseStartYear;

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

    JComboBox cmbCourseUpdate;
    JPanel pnlCourseUpdate;
    JLabel lblCourseUpdate;

    ReportTool tool;
    ButtonState bst;
    ClsButtonManagement cbm;

    int Rcols;

	JPanel pnlDataReport;
	FrmCourse()
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
        pnlCourseUpdate = ES.getFirstComboPanel();
        cmbCourseUpdate = ES.getFirstComboBox();
        lblCourseUpdate = ES.getFirstComboLabel();
        btnApply = ES.getApplyButton();
        lblProgrammeHeading = ES.getProgrammeHeading();
		lblCourseUpdate.setText("Course ");
		lblProgrammeHeading.setText("CourseForm..");

		HtmlStyle.applyH1(lblProgrammeHeading);

		BlinkLabel bl = new BlinkLabel(lblProgrammeHeading,500);
		bl.start();

		int y = 20;
		int h = 30;
		int gap = 10;

       lblCourseID = new JLabel("CourseID");
       lblCourseID.setBounds(10,y,150,h);
       lblCourseID.setFont(F2);
       pnlData.add(lblCourseID);

       txtCourseID = new JTextField();
       txtCourseID.setBounds(190,y,100,h);
       txtCourseID.setFont(F2);
       pnlData.add(txtCourseID);
       txtCourseID.addKeyListener(new OnlyNumbers());


		y = y+h+gap;
       lblCourseName = new JLabel("CourseName");
	   lblCourseName.setBounds(10,y,180,h);
	   lblCourseName.setFont(F2);
	   pnlData.add(lblCourseName);

       txtCourseName = new JTextField();
	   txtCourseName.setBounds(190,y,200,h);
	   txtCourseName.setFont(F2);
       pnlData.add(txtCourseName);

		y = y+h+gap;
		lblCoursePattern = new JLabel("Course Pattern");
		lblCoursePattern.setBounds(10,y,150,h);
		lblCoursePattern.setFont(F2);
		pnlData.add(lblCoursePattern);

		txtCoursePattern = new JTextField();
		txtCoursePattern.setBounds(190,y,100,h);
		txtCoursePattern.setFont(F2);
		pnlData.add(txtCoursePattern);
		//txtCoursePattern.addKeyListener(new OnlyNumbers());

        y = y+h+gap;
		lblCourseDuration = new JLabel("Course Duration");
		lblCourseDuration.setBounds(10,y,150,h);
		lblCourseDuration.setFont(F2);
		pnlData.add(lblCourseDuration);

		txtCourseDuration = new JTextField();
		txtCourseDuration.setBounds(190,y,100,h);
		txtCourseDuration.setFont(F2);
		pnlData.add(txtCourseDuration);

        y = y+h+gap;
		lblCourseCapacity = new JLabel("Course Capacity");
		lblCourseCapacity.setBounds(10,y,150,h);
		lblCourseCapacity.setFont(F2);
		pnlData.add(lblCourseCapacity);

		txtCourseCapacity = new JTextField();
		txtCourseCapacity.setBounds(190,y,100,h);
		txtCourseCapacity.setFont(F2);
		pnlData.add(txtCourseCapacity);

        y = y+h+gap;
		lblCourseStartYear = new JLabel("Course Start Year");
		lblCourseStartYear.setBounds(10,y,150,h);
		lblCourseStartYear.setFont(F2);
		pnlData.add(lblCourseStartYear);

		txtCourseStartYear = new JTextField();
		txtCourseStartYear.setBounds(190,y,100,h);
		txtCourseStartYear.setFont(F2);
		pnlData.add(txtCourseStartYear);

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
       ES.UIAreaSetting(440,250);
       ES.ReportAreaSetting(700,550);

		bst = new ButtonState();
		cbm = new ClsButtonManagement();
		automateButtons();
		bst.setButtonState(ButtonState.InitialState);
		cbm.showButtonsOnUI(bst);

        initUI();

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
	}


   public void initUI()
   {
       txtCourseID.setText("0");
       txtCourseName.setText(" ");
       txtCoursePattern.setText("0");
       txtCourseDuration.setText("0");
       txtCourseCapacity.setText("0");
       txtCourseStartYear.setText("0");

   }

   public void addCourseRecords(JComboBox cmbProcess)
   {
      cmbProcess.removeActionListener(this);
      ClsCourse.addCourseRecords(cmbProcess);
      cmbProcess.addActionListener(this);

   }

   public void actionPerformed(ActionEvent ae)
   {
       if(ae.getSource()==btnNew)
       {
			bst.setButtonState(ButtonState.NewState);
			cbm.showButtonsOnUI(bst);

			txtCourseName.requestFocus();
			initUI();

	   }
	   else if(ae.getSource()==btnSave)
	   {
		   bst.setButtonState(ButtonState.SaveState);
			cbm.showButtonsOnUI(bst);
           ClsCourse temp = readUI();
           ClsCourse.addNewRecord(temp);
           JOptionPane.showMessageDialog(this,"Record Is Saved Successfully");
	       initUI();
	  }
	   else if(ae.getSource()==btnUpdate)
	   {
		   bst.setButtonState(ButtonState.UpdateState);
			cbm.showButtonsOnUI(bst);
           ClsCourse temp = readUI();
           ClsCourse.updateRecord(temp);
           JOptionPane.showMessageDialog(this,"Record Is Updated Successfully");
           initUI();
	   }
	   else if(ae.getSource()==btnView)
	   {
			bst.setButtonState(ButtonState.ViewState);
			cbm.showButtonsOnUI(bst);
            addCourseRecords(cmbCourseUpdate);

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
           ClsCourse temp = readUI();
           ClsCourse.deleteRecord(temp);
           JOptionPane.showMessageDialog(this,"Record Is Deleted Successfully");
           initUI();
	   }
	   else if(ae.getSource()==btnClose)
	   {
		   bst.setButtonUniqueState(ButtonState.CancelState);
			cbm.showButtonsOnUI(bst);
           initUI();
	   }
	   else if(ae.getSource()==cmbCourseUpdate)
	   	{
			PanelState.enabledComponents(pnlApply);
	              initUI();
	   }

		else if(ae.getSource()==btnReport)
		{
			bst.setButtonCommonState(ButtonState.ReportState);
			cbm.showButtonsOnUI(bst);
			createReport();
			setColumnsData();
		}
		else if(ae.getSource()==btnApply)
		{
			bst.setButtonState(ButtonState.ApplyState);
			cbm.showButtonsOnUI(bst);

			String mCourseName = (String)cmbCourseUpdate.getSelectedItem();
			int mCourseID = ClsCourse.getCourseIDFromName(mCourseName);
			ClsCourse temp = ClsCourse.getCourseInformation(mCourseID);
			writeUI(temp);
		}
   }

   public void writeUI(ClsCourse temp)
   {
		txtCourseID.setText(String.valueOf(temp.getCourseID()));
		txtCourseName.setText(temp.getCourseName());
	    txtCoursePattern.setText(String.valueOf(temp.getCoursePattern()));
	    txtCourseDuration.setText(String.valueOf(temp.getCourseDuration()));
	    txtCourseCapacity.setText(String.valueOf(temp.getCourseCapacity()));
	    txtCourseStartYear.setText(String.valueOf(temp.getCourseStartYear()));

   }

   ClsCourse readUI()
   {

	   ClsCourse temp2 = new ClsCourse();
	   temp2.setCourseID(Integer.parseInt(txtCourseID.getText()));
	   temp2.setCourseName(txtCourseName.getText());
	   temp2.setCoursePattern(Integer.parseInt(txtCoursePattern.getText()));
	   temp2.setCourseDuration(Integer.parseInt(txtCourseDuration.getText()));
	   temp2.setCourseCapacity(Integer.parseInt(txtCourseCapacity.getText()));
	   temp2.setCourseStartYear(Integer.parseInt(txtCourseStartYear.getText()));

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
		tool.setColumnWidth("CourseID",80);
		tool.setColumnWidth("CourseName",400);
		tool.setColumnWidth("CoursePattern",100);
		tool.setColumnWidth("CourseDuration",100);
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
        FrmCourse A = new FrmCourse();
   }

}