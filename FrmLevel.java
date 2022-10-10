import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import timescreen.*;
import HtmlSetting.HtmlStyle;
import myUtility.*;
import javax.swing.border.*;
import DBReport.*;
import InputRestriction.*;

class FrmLevel extends JFrame implements ActionListener
{
	//int w = 3020;
	TimeScreen2 ES;

	JLabel  lblLevelID;
	JLabel  lblLevelName;
	JLabel  lblCourseID;
	JLabel  lblProgrammeHeading;

    JTextField txtLevelID;
    JTextField txtLevelName;



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

    JComboBox cmbLevelUpdate;
    JPanel pnlLevelUpdate;
    JLabel lblLevelUpdate;

    JComboBox cmbCourseUpdate;
    JPanel pnlCourseUpdate;
    JLabel lblCourseUpdate;

    ReportTool tool;
    ButtonState bst;
    ClsButtonManagement2 cbm;

    int Rcols;

    JComboBox cmbCourseID;
    int vCourseID = 0;

	JPanel pnlDataReport;
	FrmLevel()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

         border1 = BorderFactory.createMatteBorder(0,0,2,0,Color.black);

         F2 = new Font("Sans Serif",Font.BOLD,18);


		setSize(screenSize.width,screenSize.height);
		ES = new TimeScreen2();
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

		cmbCourseUpdate =  ES.getFirstComboBox();
		pnlCourseUpdate = ES.getFirstComboPanel();
		lblCourseUpdate = ES.getFirstComboLabel();

		cmbLevelUpdate = ES.getSecondComboBox();
		pnlLevelUpdate =ES.getSecondComboPanel();
		lblLevelUpdate = ES.getSecondComboLabel();
		lblLevelUpdate.setText("Level Update...");
		lblCourseUpdate.setText("Course Update...");

        btnApply = ES.getApplyButton();
        lblProgrammeHeading = ES.getProgrammeHeading();
		lblProgrammeHeading.setText("Level Form..");

		HtmlStyle.applyH1(lblProgrammeHeading);

		BlinkLabel bl = new BlinkLabel(lblProgrammeHeading,500);
		bl.start();

		int y = 20;
		int h = 30;
		int gap = 10;

       lblLevelID = new JLabel("LevelID");
       lblLevelID.setBounds(10,y,150,h);
       lblLevelID.setFont(F2);
       pnlData.add(lblLevelID);

       txtLevelID = new JTextField();
       txtLevelID.setBounds(190,y,100,h);
       txtLevelID.setFont(F2);
       pnlData.add(txtLevelID);
       txtLevelID.addKeyListener(new OnlyNumbers());


		y = y+h+gap;
       lblLevelName = new JLabel("LevelName");
	   lblLevelName
	   .setBounds(10,y,180,h);
	   lblLevelName.setFont(F2);
	   pnlData.add(lblLevelName);

       txtLevelName = new JTextField();
	   txtLevelName.setBounds(190,y,200,h);
	   txtLevelName.setFont(F2);
       pnlData.add(txtLevelName);

		y = y+h+gap;
		lblCourseID = new JLabel("CourseID");
		lblCourseID.setBounds(10,y,150,h);
		lblCourseID.setFont(F2);
		pnlData.add(lblCourseID);

	    cmbCourseID = new JComboBox();
	    cmbCourseID.setBounds(190,y,200,h);
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
       //ES.setDefaultOperation();
       ES.UIAreaSetting(440,180);
       ES.ReportAreaSetting(700,550);

        addCourseRecords(cmbCourseID);

		bst = new ButtonState();
		cbm = new ClsButtonManagement2();
		automateButtons();
		bst.setButtonState(ButtonState.InitialState);
		cbm.showButtonsOnUI(bst);

        createReport();
        setColumnsData();
		show();

        initUI();

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
		cbm.manageSecondPanel(pnlLevelUpdate);
		cbm.manageSecondLabel(lblLevelUpdate);
		cbm.manageSecondCombo(cmbLevelUpdate);

        cbm.manageFirstPanel(pnlCourseUpdate);
		cbm.manageFirstLabel(lblCourseUpdate);
		cbm.manageFirstCombo(cmbCourseUpdate);
	}


   public void initUI()
   {
       txtLevelID.setText("0");
       txtLevelName.setText(" ");
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

   public void actionPerformed(ActionEvent ae)
   {
       if(ae.getSource()==btnNew)
       {
			bst.setButtonState(ButtonState.NewState);
			cbm.showButtonsOnUI(bst);

           	txtLevelID.setText("0");
			txtLevelName.requestFocus();
	   }
	   else if(ae.getSource()==btnSave)
	   {
		   bst.setButtonState(ButtonState.SaveState);
			cbm.showButtonsOnUI(bst);
           ClsLevel temp = readUI();
           ClsLevel.addNewRecord(temp);
           JOptionPane.showMessageDialog(this,"Record Is Saved Successfully");
	       initUI();

	  }
	  else if(ae.getSource()==cmbCourseID)
	  {
		  String mCourseName = (String)cmbCourseID.getSelectedItem();
		  vCourseID = ClsCourse.getCourseIDFromName(mCourseName);


	  }
	   else if(ae.getSource()==btnUpdate)
	   {
		   bst.setButtonState(ButtonState.UpdateState);
			cbm.showButtonsOnUI(bst);
           ClsLevel temp = readUI();
           ClsLevel.updateRecord(temp);
           JOptionPane.showMessageDialog(this,"Record Is Updated Successfully");
           initUI();
	   }
	   else if(ae.getSource()==btnView)
	   {
			bst.setButtonState(ButtonState.ViewState);
			cbm.showButtonsOnUI(bst);
            addCourseRecords(cmbCourseUpdate);
			//PanelState.enabledComponents(pnlCourseUpdate);
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
           ClsLevel temp = readUI();
           ClsLevel.deleteRecord(temp);
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
            String mCourseName = (String)cmbCourseUpdate.getSelectedItem();
            int mCourseID = ClsCourse.getCourseIDFromName(mCourseName);
            addLevelRecords(cmbLevelUpdate,mCourseID);
            PanelState.enabledComponents(pnlLevelUpdate);
		}
		else if(ae.getSource()==cmbLevelUpdate)
		{
			PanelState.enabledComponents(pnlApply);
			initUI();
		}

		else if(ae.getSource()==btnReport)
		{
		   bst.setButtonCommonState(ButtonState.ReportState);
			cbm.showButtonsOnUI(bst);
			//createReport();
			setColumnsData();
		}
		else if(ae.getSource()==btnApply)
		{
			bst.setButtonState(ButtonState.ApplyState);
			cbm.showButtonsOnUI(bst);

			String mLevelName = (String)cmbLevelUpdate.getSelectedItem();
			int mLevelID = ClsLevel.getLevelIDFromName(mLevelName);
			ClsLevel temp = ClsLevel.getLevelInformation(mLevelID);
			writeUI(temp);
		}
   }

   public void writeUI(ClsLevel temp)
   {
		txtLevelID.setText(String.valueOf(temp.getLevelID()));
		txtLevelName.setText(temp.getLevelName());
        String mCourseName = ClsCourse.getCourseNameFromID(temp.getCourseID());
		cmbCourseID.setSelectedItem(mCourseName);
   }

   ClsLevel readUI()
   {

	   ClsLevel temp2 = new ClsLevel();
	   temp2.setLevelID(Integer.parseInt(txtLevelID.getText()));
	   temp2.setLevelName(txtLevelName.getText());
       temp2.setCourseID(vCourseID);
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
		Rcols+=tool.addNewColumn("LevelID");
		Rcols+=tool.addNewColumn("LevelName");
		Rcols+=tool.addNewColumn("CourseID");


	}
	void setColumnsAlignment()
	{
		tool.setColumnAlignment(0,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(1,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(2,ReportTool.ALIGN_CENTER);

	}
	void setColumnsWidth()
	{
		tool.setColumnWidth("LevelID",80);
		tool.setColumnWidth("LevelName",400);
		tool.setColumnWidth("CourseID",100);



	}

	void setColumnsData()
	{

		tool.removeAllRows();

		ClsLevel Data[]=ClsLevel.getAllLevelInformation();

		for(int i=0;i<Data.length;i++)
		{
			Object Objectdata[]=new Object[Rcols];

			Objectdata[0]=i+1;
			Objectdata[1]=Data[i].getLevelName();
			Objectdata[2]=Data[i].getCourseID();

            tool.addNewRow(Objectdata);
		}
	}


   public static void main(String args[])
   {
        FrmLevel A = new FrmLevel();
   }

}