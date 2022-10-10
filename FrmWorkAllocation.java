import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import timescreen.*;
import HtmlSetting.HtmlStyle;
import myUtility.*;
import javax.swing.border.*;
import DBReport.*;
import InputRestriction.*;

class FrmWorkAllocation extends JFrame implements ActionListener
{

	TimeScreenSS ES;

	//JLabel  lblWorkAllocationID;

	JLabel  lblCourseID;
	JLabel  lblSemisterID;
	JLabel  lblSubjectID;
	JLabel  lblTimeSlotID;
	JLabel  lblDayID;
	JLabel  lblTheory;
	JLabel  lblFloorID;
	JLabel  lblRoomID;
	JLabel  lblStaffID;

	//JLabel  lblSessionID;
	//JLabel  lblSubjectTypeID;

	JLabel  lblProgrammeHeading;

   // JTextField txtWorkAllocationID;

    JComboBox cmbCourseID;
    JComboBox cmbSemisterID;
    JComboBox cmbSubjectID;
    JComboBox cmbTimeSlotID;
    JComboBox cmbDayID;
    JComboBox cmbTheory;
    JComboBox cmbFloorID;
    JComboBox cmbRoomID;
    JComboBox cmbStaffID;
    JComboBox cmbSubjectTypeID;
    //JComboBox cmbSessionID;
//    JComboBox cmbSubjectTypeID;

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
    JPanel pnlButton1;
    JPanel pnlButton2;
    JPanel pnlDataReport;
    JButton btnStartAllocationButton;
    JButton btnStartAllocateNowButton;

    JButton btnAutomateAllocation;


    Font F2;

    Border border1;

    JComboBox cmbCourseUpdate;
    JPanel pnlCourseUpdate;
    JLabel lblCourseUpdate;

    JComboBox cmbSemisterUpdate;
    JPanel pnlSemisterUpdate;
    JLabel lblSemisterUpdate;

    JComboBox cmbSubjectUpdate;
    JPanel pnlSubjectUpdate;
    JLabel lblSubjectUpdate;

    JComboBox cmbTimeSlotUpdate;
    JPanel pnlTimeSlotUpdate;
    JLabel lblTimeSlotUpdate;

    JComboBox cmbDayUpdate;
    JPanel pnlDayUpdate;
    JLabel lblDayUpdate;

    JComboBox cmbSubjectTypeUpdate;
    JPanel pnlSubjectTypeUpdate;
    JLabel lblSubjectTypeUpdate;


    JComboBox cmbFloorUpdate;
    JPanel pnlFloorUpdate;
    JLabel lblFloorUpdate;

    JComboBox cmbRoomUpdate;
    JPanel pnlRoomUpdate;
    JLabel lblRoomUpdate;

    JComboBox cmbStaffUpdate;
    JPanel pnlStaffUpdate;
    JLabel lblStaffUpdate;

    ReportTool tool;
    ButtonState bst;
    ClsButtonManagement cbm;

    int Rcols;

    int vCourseID=0;
    int vSemisterID=0;
    int vSubjectID=0;
    int vTimeSlotID=0;
    int vDayID;

    int vFloorID=0;
    int vRoomID=0;
    int vStaffID=0;
    int vSubjectTypeID;

//	JPanel pnlDataReport;

	FrmWorkAllocation()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

         border1 = BorderFactory.createMatteBorder(0,0,2,0,Color.black);

         F2 = new Font("Sans Serif",Font.BOLD,18);


		setSize(screenSize.width,screenSize.height);
		setTitle("Work Allocation Form...");
		ES = new TimeScreenSS();
		add(ES);



//		pnlDataReport = ES.getDataReportPanel();
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
		pnlDataReport = ES.getDataReportPanel();

        pnlButton1=ES.getButton1Panel();
        pnlButton2=ES.getButton2Panel();

        btnNew = ES.getNewButton();
        btnSave = ES.getSaveButton();
        btnUpdate = ES.getUpdateButton();
        btnView = ES.getViewButton();
        btnEdit = ES.getEditButton();
        btnDelete = ES.getDeleteButton();
        btnClose = ES.getCloseButton();
        btnReport = ES.getReportButton();

        btnStartAllocationButton=ES.getStartAllocationButton();
        btnStartAllocateNowButton=ES.getAllocateNowButton();

        pnlCourseUpdate = ES.getFirstComboPanel();
        cmbCourseUpdate = ES.getFirstComboBox();
        lblCourseUpdate = ES.getFirstComboLabel();
		lblCourseUpdate.setText("Course ");

        pnlSemisterUpdate = ES.getSecondComboPanel();
        cmbSemisterUpdate = ES.getSecondComboBox();
        lblSemisterUpdate = ES.getSecondComboLabel();
		lblSemisterUpdate.setText("SemisterUpdate...");

        pnlSubjectUpdate = ES.getThirdComboPanel();
        cmbSubjectUpdate = ES.getThirdComboBox();
        lblSubjectUpdate = ES.getThirdComboLabel();
		lblSubjectUpdate.setText("SubjectUpdate... ");

        pnlTimeSlotUpdate = ES.getFourthComboPanel();
        cmbTimeSlotUpdate = ES.getFourthComboBox();
        lblTimeSlotUpdate = ES.getFourthComboLabel();
		lblTimeSlotUpdate.setText("TimeSlotUpdate... ");

        pnlDayUpdate = ES.getFiveComboPanel();
        cmbDayUpdate = ES.getFiveComboBox();
        lblDayUpdate = ES.getFiveComboLabel();
		lblDayUpdate.setText("DayUpdate... ");

        pnlSubjectTypeUpdate = ES.getSixComboPanel();
        cmbSubjectTypeUpdate = ES.getSixComboBox();
        lblSubjectTypeUpdate = ES.getSixComboLabel();
		lblSubjectTypeUpdate.setText("SubjectTypeUpdate... ");

        pnlFloorUpdate = ES.getSevenComboPanel();
        cmbFloorUpdate = ES.getSevenComboBox();
        lblFloorUpdate = ES.getSevenComboLabel();
		lblFloorUpdate.setText("FloorUpdate... ");

        pnlRoomUpdate = ES.getEightComboPanel();
        cmbRoomUpdate = ES.getEightComboBox();
        lblRoomUpdate = ES.getEightComboLabel();
		lblRoomUpdate.setText("RoomUpdate... ");

        pnlStaffUpdate = ES.getNineComboPanel();
        cmbStaffUpdate = ES.getNineComboBox();
        lblStaffUpdate = ES.getNineComboLabel();
		lblStaffUpdate.setText("StaffUpdate... ");

        btnAutomateAllocation = new JButton("Automate Allocation");
        btnAutomateAllocation.setBounds(10,600,1120,80);
        pnlEntry.add(btnAutomateAllocation);

        btnApply = ES.getApplyButton();
        lblProgrammeHeading = ES.getProgrammeHeading();
		lblProgrammeHeading.setText("Work Allocation Form...");

		HtmlStyle.applyH1(lblProgrammeHeading);

		BlinkLabel bl = new BlinkLabel(lblProgrammeHeading,500);
		//bl.start();

		int y = 20;
		int h = 30;
		int gap = 10;


		tool=new ReportTool(100,100);
		tool.setBounds(10,10,1100,444);
		//tool.setBackground(Color.yellow);
		pnlEntry.add(tool);

	   btnStartAllocationButton.addActionListener(this);
       btnStartAllocateNowButton.addActionListener(this);
       btnAutomateAllocation.addActionListener(this);

       //ES.setDefaultOperation();
    //   ES.UIAreaSetting(440,550);
       ES.ReportAreaSetting(2000,850);


		bst = new ButtonState();
		cbm = new ClsButtonManagement();
		automateButtons();
		bst.setButtonState(ButtonState.InitialState);
		//cbm.showButtonsOnUI(bst);

        PanelState.enabledComponents(pnlButton1);
        PanelState.hideComponents(pnlData);
        PanelState.hideComponents(pnlDataReport);


      //  addCourseRecords(cmbCourseID);

        createReport();
//      setColumnsData();

        showTimeTableReport(-1,-1,-1,-1,-1,-1,-1,-1,-1);

		show();

        btnAutomateAllocation.setEnabled(false);

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
	   cmbProcess.removeAllItems();
		cmbProcess.addItem("Select Semister...");
		for(int i=1;i<=6;i++)
		{
			cmbProcess.addItem(String.valueOf(i));
		}
		cmbProcess.addActionListener(this);
   }
    public void addDayRecords(JComboBox cmbProcess)
	{
		cmbProcess.removeActionListener(this);
	    cmbProcess.removeAllItems();

		cmbProcess.addItem("Select Day...");
		cmbProcess.addItem("Monday");
		cmbProcess.addItem("Tuesday");
		cmbProcess.addItem("Wednesday");
		cmbProcess.addItem("Thusday");
		cmbProcess.addItem("Friday");
		cmbProcess.addItem("Saturday");
		cmbProcess.addItem("Sunday");

		cmbProcess.addActionListener(this);
	}
    public void addSubjectTypeRecords(JComboBox cmbProcess)
	{
	    cmbProcess.removeAllItems();
		cmbProcess.removeActionListener(this);

		cmbProcess.addItem("Select SubjectType...");
		cmbProcess.addItem("Theory");
		cmbProcess.addItem("Practical");

		cmbProcess.addActionListener(this);
	}
    public void addSubjectRecords(JComboBox cmbProcess,int mCourseID,int mSemisterID)
	{
		cmbProcess.removeActionListener(this);
		ClsSubject.addSubjectRecords(cmbProcess,mCourseID,mSemisterID);
		cmbProcess.addActionListener(this);
	}
   public void addTimeSlotRecords(JComboBox cmbProcess)
   {
      cmbProcess.removeActionListener(this);
      ClsTimeSlot.addTimeSlotRecords(cmbProcess);
      cmbProcess.addActionListener(this);

   }
   public void addFloorRecords(JComboBox cmbProcess)
   {
   	   cmbProcess.removeActionListener(this);
   	   ClsFloor.addFloorRecords(cmbProcess);
   	   cmbProcess.addActionListener(this);
   }
   public void addRoomRecordsFloorWise(JComboBox cmbProcess,int mFloorID)
   {
        cmbProcess.removeActionListener(this);
		ClsRoom.addRoomRecordsFloorWise(cmbProcess,mFloorID);
		cmbProcess.addActionListener(this);
   }
   public void addStaffRecords(JComboBox cmbProcess)
   {
        cmbProcess.removeActionListener(this);
		ClsStaff.addStaffRecords(cmbProcess);
		cmbProcess.addActionListener(this);
   }
   public void actionPerformed(ActionEvent ae)
   {

       if(ae.getSource()==btnStartAllocationButton)
       {
          PanelState.enabledComponents(pnlCourseUpdate);
          addCourseRecords(cmbCourseUpdate);
	   }
       else if(ae.getSource()==btnStartAllocateNowButton)
       {
             ClsWorkAllocation temp = readUI();
             ClsWorkAllocation.addNewRecord(temp);
             btnAutomateAllocation.setEnabled(true);
//             setColumnsData(Data);
	   }
       else if(ae.getSource()==btnAutomateAllocation)
       {
            FrmTimeTableFinal A = new FrmTimeTableFinal();
	   }

     /*  else if(ae.getSource()==btnNew)
       {
			bst.setButtonState(ButtonState.NewState);
			cbm.showButtonsOnUI(bst);

		//	txtCourseName.requestFocus();
			initUI();

	   }
	   else if(ae.getSource()==btnSave)
	   {
		   bst.setButtonState(ButtonState.SaveState);
			cbm.showButtonsOnUI(bst);
//           ClsWorkAllocation temp = readUI();
//           ClsWorkAllocation.addNewRecord(temp);
           JOptionPane.showMessageDialog(this,"Record Is Saved Successfully");
	       initUI();
	  }
	   else if(ae.getSource()==btnUpdate)
	   {
		   bst.setButtonState(ButtonState.UpdateState);
			cbm.showButtonsOnUI(bst);
//           ClsWorkAllocation temp = readUI();
//           ClsWorkAllocation.updateRecord(temp);
           JOptionPane.showMessageDialog(this,"Record Is Updated Successfully");
           initUI();
	   }
	   else if(ae.getSource()==btnView)
	   {
			bst.setButtonState(ButtonState.ViewState);
			cbm.showButtonsOnUI(bst);
            //addCourseRecords(cmbCourseUpdate);

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
//           ClsWorkAllocation temp = readUI();
//           ClsWorkAllocation.deleteRecord(temp);
           JOptionPane.showMessageDialog(this,"Record Is Deleted Successfully");
           initUI();
	   }
	   else if(ae.getSource()==btnClose)
	   {
		   bst.setButtonUniqueState(ButtonState.CancelState);
			cbm.showButtonsOnUI(bst);
           initUI();
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
			addSubjectRecords(cmbSubjectID,vCourseID,vSemisterID);

		}
        else if(ae.getSource()==cmbSubjectID)
		{
            String mSubjectName = (String)cmbSubjectID.getSelectedItem();
			vSubjectID = ClsSubject.getSubjectIDFromName(mSubjectName);
		    addTimeSlotRecords(cmbTimeSlotID);

		}
        else if(ae.getSource()==cmbTimeSlotID)
		{
            String mTimeSlotName = (String)cmbSubjectID.getSelectedItem();
			vTimeSlotID = ClsTimeSlot.getTimeSlotIDFromName(mTimeSlotName);
	        addDayRecords(cmbDayID);
		}
        else if(ae.getSource()==cmbDayID)
		{
			String mDayID = (String)cmbDayID.getSelectedItem();
	        addSubjectTypeRecords(cmbSubjectTypeID);
		}
        else if(ae.getSource()==cmbSubjectTypeID)
		{
			String mSubjectTypeID = (String)cmbSubjectTypeID.getSelectedItem();
	        addFloorRecords(cmbFloorID);
		}
        else if(ae.getSource()==cmbFloorID)
		{
            String mFloorNumber = (String)cmbFloorID.getSelectedItem();
			vFloorID = ClsFloor.getFloorIDFromName(mFloorNumber);
            addRoomRecordsFloorWise(cmbRoomID,vFloorID);
		}
        else if(ae.getSource()==cmbRoomID)
		{
            String mRoomNumber = (String)cmbRoomID.getSelectedItem();
			vRoomID = ClsRoom.getRoomIDFromRoomNumber(mRoomNumber);
			addStaffRecords(cmbStaffID);
		}
        else if(ae.getSource()==cmbStaffID)
		{
            String mStaffName = (String)cmbStaffID.getSelectedItem();
			vStaffID = ClsStaff.getStaffIDFromName(mStaffName);
		}*/
        else if(ae.getSource()==cmbCourseUpdate)
		{
			String mCourseName = (String)cmbCourseUpdate.getSelectedItem();
			vCourseID = ClsCourse.getCourseIDFromName(mCourseName);
			addSemisterRecords(cmbSemisterUpdate);
            PanelState.enabledComponents(pnlSemisterUpdate);
			showTimeTableReport(vCourseID,-1,-1,-1,-1,-1,-1,-1,-1);
		}
        else if(ae.getSource()==cmbSemisterUpdate)
		{
			if(cmbSemisterUpdate.getSelectedIndex()!=0)
			{
				//JOptionPane.showMessageDialog(this,(String)cmbSemisterUpdate.getSelectedItem());
            	vSemisterID = Integer.parseInt((String)cmbSemisterUpdate.getSelectedItem());
				addSubjectRecords(cmbSubjectUpdate,vCourseID,vSemisterID);
				//JOptionPane.showMessageDialog(this,vSemisterID);
            	PanelState.enabledComponents(pnlSubjectUpdate);
				showTimeTableReport(vCourseID,vSemisterID,-1,-1,-1,-1,-1,-1,-1);
			}
		}
        else if(ae.getSource()==cmbSubjectUpdate)
		{
            if(cmbSubjectUpdate.getSelectedIndex()!=0)
			{
					String mSubjectName = (String)cmbSubjectUpdate.getSelectedItem();
					vSubjectID = ClsSubject.getSubjectIDFromName(mSubjectName);
					addTimeSlotRecords(cmbTimeSlotUpdate);
					PanelState.enabledComponents(pnlTimeSlotUpdate);
			    	showTimeTableReport(vCourseID,vSemisterID,vSubjectID,-1,-1,-1,-1,-1,-1);

		    }
		}
        else if(ae.getSource()==cmbTimeSlotUpdate)
		{

			if(cmbTimeSlotUpdate.getSelectedIndex()!=0)
			{
					String mTimeSlotName = (String)cmbTimeSlotUpdate.getSelectedItem();
					vTimeSlotID = ClsTimeSlot.getTimeSlotIDFromName(mTimeSlotName);
					addDayRecords(cmbDayUpdate);
					PanelState.enabledComponents(pnlDayUpdate);
			    	showTimeTableReport(vCourseID,vSemisterID,vSubjectID,vTimeSlotID,-1,-1,-1,-1,-1);

			}

	    }
        else if(ae.getSource()==cmbDayUpdate)
		{
            if(cmbDayUpdate.getSelectedIndex()!=0)
			{
				vDayID = cmbDayUpdate.getSelectedIndex();
			    showTimeTableReport(vCourseID,vSemisterID,vSubjectID,vTimeSlotID,vDayID,-1,-1,-1,-1);

                int count = ClsWorkAllocation.getAllRecordsCount(vCourseID,vSemisterID,vSubjectID,vTimeSlotID,vDayID);

                if(count==1)
                {
					 JOptionPane.showMessageDialog(this,"Select Different Day... or Change Time Slot ");
				}
				else
				{
					 addSubjectTypeRecords(cmbSubjectTypeUpdate);
					 PanelState.enabledComponents(pnlSubjectTypeUpdate);
				}
			}
	    }
        else if(ae.getSource()==cmbSubjectTypeUpdate)
		{

            if(cmbSubjectTypeUpdate.getSelectedIndex()!=0)
			{
				vSubjectTypeID = cmbSubjectTypeUpdate.getSelectedIndex();
				addFloorRecords(cmbFloorUpdate);
				PanelState.enabledComponents(pnlFloorUpdate);
			    showTimeTableReport(vCourseID,vSemisterID,vSubjectID,vTimeSlotID,vDayID,vSubjectTypeID,-1,-1,-1);

               /* int count = ClsWorkAllocation.getAllRecordsCount(vCourseID,vSemisterID,vTimeSlotID,vDayID,vSubjectTypeID);
                if(count==1)
                {
					JOptionPane.showMessageDialog(this,"Select Different Practical Day... or Change Time Slot");
				}
				else
				{
				    addFloorRecords(cmbFloorUpdate);
					PanelState.enabledComponents(pnlSubjectTypeUpdate);
				}*/
			}

	    }
        else if(ae.getSource()==cmbFloorUpdate)
		{

            if(cmbFloorUpdate.getSelectedIndex()!=0)
			{
				String mFloorNumber = (String)cmbFloorUpdate.getSelectedItem();
				vFloorID = ClsFloor.getFloorIDFromName(mFloorNumber);
				//addRoomRecordsFloorWise(cmbRoomUpdate,vFloorID);
				//PanelState.enabledComponents(pnlRoomUpdate);
			    showTimeTableReport(vCourseID,vSemisterID,vSubjectID,vTimeSlotID,vDayID,vSubjectTypeID,vFloorID,-1,-1);

                int count = ClsWorkAllocation.getAllRecordsCount(vCourseID,vSemisterID,vSubjectID,vTimeSlotID,vDayID,vSubjectTypeID,vFloorID);

                if(count==1)
                {
					JOptionPane.showMessageDialog(this,"Select Different Day... or Change Time Slot ");
				}
				else
				{
				    addRoomRecordsFloorWise(cmbRoomUpdate,vFloorID);
				    PanelState.enabledComponents(pnlRoomUpdate);
				}

		    }

		}
        else if(ae.getSource()==cmbRoomUpdate)
		{
            if(cmbRoomUpdate.getSelectedIndex()!=0)
			{
					String mRoomNumber = (String)cmbRoomUpdate.getSelectedItem();
					vRoomID = ClsRoom.getRoomIDFromRoomNumber(mRoomNumber);
					addStaffRecords(cmbStaffUpdate);
					PanelState.enabledComponents(pnlStaffUpdate);
			       showTimeTableReport(vCourseID,vSemisterID,vSubjectID,vTimeSlotID,vDayID,vSubjectTypeID,vFloorID,vRoomID,-1);
                  /* int count = ClsWorkAllocation.getAllRecordsCount(vCourseID,vSemisterID,vSubjectID,vTimeSlotID,vDayID,vSubjectTypeID,vFloorID,vRoomID);

					if(count==1)
					{
						JOptionPane.showMessageDialog(this,"Select Different Room... ");
					}
					else
					{
						addRoomRecordsFloorWise(cmbRoomUpdate,vFloorID);
						PanelState.enabledComponents(pnlRoomUpdate);
					}*/

			}

		}
        else if(ae.getSource()==cmbStaffUpdate)
		{
            if(cmbStaffUpdate.getSelectedIndex()!=0)
			{
				String mStaffName = (String)cmbStaffUpdate.getSelectedItem();
				vStaffID = ClsStaff.getStaffIDFromName(mStaffName);
				PanelState.enabledComponents(pnlButton2);
			    showTimeTableReport(vCourseID,vSemisterID,vSubjectID,vTimeSlotID,vDayID,vSubjectTypeID,vFloorID,vRoomID,vStaffID);

			}

		}
		else if(ae.getSource()==btnReport)
		{
			bst.setButtonCommonState(ButtonState.ReportState);
			cbm.showButtonsOnUI(bst);
		}
		else if(ae.getSource()==btnApply)
		{
			bst.setButtonState(ButtonState.ApplyState);
			cbm.showButtonsOnUI(bst);

			/*String mCourseName = (String)cmbCourseUpdate.getSelectedItem();
			int mCourseID = ClsCourse.getCourseIDFromName(mCourseName);
			ClsCourse temp = ClsCourse.getCourseInformation(mCourseID);
			//writeUI(temp);*/
		}
   }

 /*  public void writeUI(ClsCourse temp)
   {
		txtCourseID.setText(String.valueOf(temp.getCourseID()));
		txtCourseName.setText(temp.getCourseName());
	    txtCoursePattern.setText(String.valueOf(temp.getCoursePattern()));
	    txtCourseDuration.setText(String.valueOf(temp.getCourseDuration()));
	    txtCourseCapacity.setText(String.valueOf(temp.getCourseCapacity()));
	    txtCourseStartYear.setText(String.valueOf(temp.getCourseStartYear()));

   }*/

   ClsWorkAllocation readUI()
   {

	   ClsWorkAllocation temp = new ClsWorkAllocation();
	   temp.setCourseID(vCourseID);
	   temp.setSemisterID(vSemisterID);
	   temp.setSubjectID(vSubjectID);
	   temp.setTimeSlotID(vTimeSlotID);
	   temp.setDayID(vDayID);
	   temp.setSubjectTypeID(vSubjectTypeID);
	   temp.setFloorID(vFloorID);
	   temp.setRoomID(vRoomID);
	   temp.setStaffID(vStaffID);


	   /*temp2.setCoursePattern(Integer.parseInt(txtCoursePattern.getText()));
	   temp2.setCourseDuration(Integer.parseInt(txtCourseDuration.getText()));
	   temp2.setCourseCapacity(Integer.parseInt(txtCourseCapacity.getText()));
	   temp2.setCourseStartYear(Integer.parseInt(txtCourseStartYear.getText()));*/

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
		Rcols+=tool.addNewColumn("WorkAllocatonID");
		Rcols+=tool.addNewColumn("TimeSlotID");
		Rcols+=tool.addNewColumn("DayID");
		Rcols+=tool.addNewColumn("SubjectTypeID");
		Rcols+=tool.addNewColumn("FloorID");
		Rcols+=tool.addNewColumn("RoomID");
		Rcols+=tool.addNewColumn("CourseID");
		Rcols+=tool.addNewColumn("StaffID");
		Rcols+=tool.addNewColumn("SemisterID");
		Rcols+=tool.addNewColumn("SubjectID");

	}
	void setColumnsAlignment()
	{
		tool.setColumnAlignment(0,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(1,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(2,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(3,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(4,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(5,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(6,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(7,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(8,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(9,ReportTool.ALIGN_CENTER);

	}
	void setColumnsWidth()
	{
		//tool.setColumnWidth("WorkAllocationID",80);
		tool.setColumnWidth("TimeSlotID",200);
		tool.setColumnWidth("DayID",100);
		tool.setColumnWidth("SubjectTypeID",100);
		tool.setColumnWidth("FloorID",100);
		tool.setColumnWidth("RoomID",100);
		tool.setColumnWidth("CourseID",100);
		tool.setColumnWidth("StaffID",100);
		tool.setColumnWidth("SemisterID",100);
		tool.setColumnWidth("SubjectID",200);

	}

	void setColumnsData(ClsWorkAllocation Data[])
	{

		tool.removeAllRows();

		//Data=ClsWorkAllocation.getAllWorkAllocationInformation();

		for(int i=0;i<Data.length;i++)
		{
			Object Objectdata[]=new Object[Rcols];

			Objectdata[0]=i+1;
			Objectdata[1]=ClsTimeSlot.getTimeSlotNameFromID(Data[i].getTimeSlotID());
			Objectdata[2]=Data[i].getDayIDName();
			Objectdata[3]=Data[i].getSubjectTypeIDName();
			Objectdata[4]=ClsFloor.getFloorNameFromID(Data[i].getFloorID());
			Objectdata[5]=ClsRoom.getRoomNumberFromRoomID(Data[i].getRoomID());
			Objectdata[6]=ClsCourse.getCourseNameFromID(Data[i].getCourseID());
			Objectdata[7]=ClsStaff.getStaffNameFromID(Data[i].getStaffID());
			Objectdata[8]=Data[i].getSemisterID();
			Objectdata[9]=ClsSubject.getSubjectNameFromID(Data[i].getSubjectID());

            tool.addNewRow(Objectdata);
		}
	}


	void setColumnsData(ClsWorkAllocationDetail Data[])
	{

		tool.removeAllRows();

		//Data=ClsWorkAllocation.getAllWorkAllocationInformation();

		for(int i=0;i<Data.length;i++)
		{
			Object Objectdata[]=new Object[Rcols];

			Objectdata[0]=i+1;
			Objectdata[1]=Data[i].getTimeSlotName();
			Objectdata[2]=Data[i].getDayNameText();
			Objectdata[3]=Data[i].getSubjectTypeName();
			Objectdata[4]=Data[i].getFloorName();
			Objectdata[5]=Data[i].getRoomNumber();
			Objectdata[6]=Data[i].getCourseName();
			Objectdata[7]=Data[i].getStaffName();
			Objectdata[8]=Data[i].getSemisterID();
			Objectdata[9]=Data[i].getSubjectName();

            tool.addNewRow(Objectdata);
		}
	}



	void showTimeTableReport(int mCourseID,int mSemisterID,int mSubjectID,int mTimeSlotID,int mDayID,int mSubjectTypeID,int mFloorID,int mRoomID,int mStaffID)
	{

		    ClsWorkAllocation  Data[]=null;
		    ClsWorkAllocationDetail Data1[]=null;
		    if(mCourseID==-1 && mSemisterID==-1 && mSubjectID==-1 && mTimeSlotID==-1 && mDayID==-1 && mSubjectTypeID==-1 && mFloorID==-1 && mRoomID==-1 && mStaffID==-1)
			{
				Data1=ClsWorkAllocationDetail.getAllWorkAllocationInformation();
				setColumnsData(Data1);
			}
		    else if(mCourseID!=-1 && mSemisterID==-1 && mSubjectID==-1 && mTimeSlotID==-1 && mDayID==-1 && mSubjectTypeID==-1 && mFloorID==-1 && mRoomID==-1 && mStaffID==-1)
			{
				Data1=ClsWorkAllocationDetail.getAllWorkAllocationInformation(mCourseID);
				setColumnsData(Data1);
			}
		    else if(mCourseID!=-1 && mSemisterID!=-1 && mSubjectID==-1 && mTimeSlotID==-1 && mDayID==-1 && mSubjectTypeID==-1 && mFloorID==-1 && mRoomID==-1 && mStaffID==-1)
			{
				Data1=ClsWorkAllocationDetail.getAllWorkAllocationInformation(mCourseID,mSemisterID);
				setColumnsData(Data1);
			}
            else if(mCourseID!=-1 && mSemisterID!=-1 && mSubjectID!=-1 && mTimeSlotID==-1 && mDayID==-1 && mSubjectTypeID==-1 && mFloorID==-1 && mRoomID==-1 && mStaffID==-1)
			{
				Data1=ClsWorkAllocationDetail.getAllWorkAllocationInformation(mCourseID,mSemisterID,mSubjectID);
				setColumnsData(Data1);
			}
            else if(mCourseID!=-1 && mSemisterID!=-1 && mSubjectID!=-1 && mTimeSlotID!=-1 && mDayID==-1 && mSubjectTypeID==-1 && mFloorID==-1 && mRoomID==-1 && mStaffID==-1)
			{
				Data1=ClsWorkAllocationDetail.getAllWorkAllocationInformation(mCourseID,mSemisterID,mSubjectID,mTimeSlotID);
				setColumnsData(Data1);
			}
            else if(mCourseID!=-1 && mSemisterID!=-1 && mSubjectID!=-1 && mTimeSlotID!=-1 && mDayID!=-1 && mSubjectTypeID==-1 && mFloorID==-1 && mRoomID==-1 && mStaffID==-1)
			{
				Data1=ClsWorkAllocationDetail.getAllWorkAllocationInformation(mCourseID,mSemisterID,mSubjectID,mTimeSlotID,mDayID);
				setColumnsData(Data1);
			}
            else if(mCourseID!=-1 && mSemisterID!=-1 && mSubjectID!=-1 && mTimeSlotID!=-1 && mDayID!=-1 && mSubjectTypeID!=-1 && mFloorID==-1 && mRoomID==-1 && mStaffID==-1)
			{
				Data1=ClsWorkAllocationDetail.getAllWorkAllocationInformation(mCourseID,mSemisterID,mSubjectID,mTimeSlotID,mDayID,mSubjectTypeID);
				setColumnsData(Data1);
			}
            else if(mCourseID!=-1 && mSemisterID!=-1 && mSubjectID!=-1 && mTimeSlotID!=-1 && mDayID!=-1 && mSubjectTypeID!=-1 && mFloorID!=-1 && mRoomID==-1 && mStaffID==-1)
			{
				Data1=ClsWorkAllocationDetail.getAllWorkAllocationInformation(mCourseID,mSemisterID,mSubjectID,mTimeSlotID,mDayID,mSubjectTypeID,mFloorID);
				setColumnsData(Data1);
			}
            else if(mCourseID!=-1 && mSemisterID!=-1 && mSubjectID!=-1 && mTimeSlotID!=-1 && mDayID!=-1 && mSubjectTypeID!=-1 && mFloorID!=-1 && mRoomID!=-1 && mStaffID==-1)
			{
				Data1=ClsWorkAllocationDetail.getAllWorkAllocationInformation(mCourseID,mSemisterID,mSubjectID,mTimeSlotID,mDayID,mSubjectTypeID,mFloorID,mRoomID);
				setColumnsData(Data1);
			}
            else if(mCourseID!=-1 && mSemisterID!=-1 && mSubjectID!=-1 && mTimeSlotID!=-1 && mDayID!=-1 && mSubjectTypeID!=-1 && mFloorID!=-1 && mRoomID!=-1 && mStaffID!=-1)
			{
				Data1=ClsWorkAllocationDetail.getAllWorkAllocationInformation(mCourseID,mSemisterID,mSubjectID,mTimeSlotID,mDayID,mSubjectTypeID,mFloorID,mRoomID,mStaffID);
				setColumnsData(Data1);
			}



	/*	if(mTimeSlotID ==-1 && mDayID ==-1 &&  mSubjectTypeID ==-1 &&
			mFloorID ==-1 && mRoomID ==-1 && mCourseID ==-1 && mStaffID ==-1 && mSemisterID==-1 && mSubjectID==-1)
		{
			Data=ClsWorkAllocation.getAllWorkAllocationInformation();
			setColumnsData(Data);
		}
		else if(mTimeSlotID ==-1 && mDayID ==-1 &&  mSubjectTypeID ==-1 &&
			mFloorID ==-1 && mRoomID ==-1 && mCourseID ==-1 && mStaffID ==-1 && mSemisterID==-1 && mSubjectID==-1)
		{
			Data=ClsWorkAllocation.getAllWorkAllocationInformation();
			setColumnsData(Data);
		}
		else if(mCourseID !=-1 && mDayID ==-1 &&  mSubjectTypeID ==-1 &&
			mFloorID ==-1 && mRoomID ==-1 && mTimeSlotID ==-1 && mStaffID ==-1 && mSemisterID==-1&& mSubjectID==-1)
		{
			Data=ClsWorkAllocation.getAllWorkAllocationInformation(mCourseID);
			setColumnsData(Data);
		}
		else if(mCourseID !=-1 && mSemisterID !=-1 &&  mSubjectTypeID ==-1 &&
			mFloorID ==-1 && mRoomID ==-1 && mTimeSlotID ==-1 && mStaffID ==-1 && mDayID ==-1 && mSubjectID==-1)
		{
			Data=ClsWorkAllocation.getAllWorkAllocationInformation(mCourseID,mSemisterID);
			setColumnsData(Data);
		}
		else if(mCourseID !=-1 && mSemisterID !=-1 && mSubjectID!=-1 &&  mSubjectTypeID ==-1 &&
			mFloorID ==-1 && mRoomID ==-1 && mTimeSlotID ==-1 && mStaffID ==-1 && mDayID ==-1)
		{
			Data=ClsWorkAllocation.getAllWorkAllocationInformation(mCourseID,mSemisterID,mSubjectID);
			setColumnsData(Data);
		}
		else if(mCourseID !=-1 && mSemisterID !=-1 && mSubjectID!=-1 &&  mTimeSlotID !=-1 &&
			mFloorID ==-1 && mRoomID ==-1 && mSubjectTypeID ==-1 && mStaffID ==-1 && mDayID ==-1)
		{
			Data=ClsWorkAllocation.getAllWorkAllocationInformation(mCourseID,mSemisterID,mSubjectID,mTimeSlotID);
			setColumnsData(Data);
		}
		else if(mCourseID !=-1 && mSemisterID !=-1 && mSubjectID!=-1 &&  mTimeSlotID !=-1 &&

			mDayID !=-1 && mSubjectTypeID  ==-1 && mFloorID  ==-1 && mRoomID  ==-1 && mStaffID  ==-1 )
		{
			Data=ClsWorkAllocation.getAllWorkAllocationInformation(mCourseID,mSemisterID,mSubjectID,mTimeSlotID,mDayID);
			setColumnsData(Data);
		}
		else if(mCourseID !=-1 && mSemisterID !=-1 && mSubjectID!=-1 &&  mTimeSlotID !=-1 &&

			mDayID !=-1 && mSubjectTypeID  !=-1 && mFloorID  ==-1 && mRoomID  ==-1 && mStaffID  ==-1 )
		{
			Data=ClsWorkAllocation.getAllWorkAllocationInformation(mCourseID,mSemisterID,mSubjectID,mTimeSlotID,mDayID,mSubjectTypeID);
			setColumnsData(Data);
		}
		else if(mCourseID !=-1 && mSemisterID !=-1 && mSubjectID!=-1 &&  mTimeSlotID !=-1 &&

			mDayID !=-1 && mSubjectTypeID  !=-1 && mFloorID  !=-1 && mRoomID  ==-1 && mStaffID  ==-1 )
		{
			Data=ClsWorkAllocation.getAllWorkAllocationInformation(mCourseID,mSemisterID,mSubjectID,mTimeSlotID,mDayID,mSubjectTypeID,mFloorID);
			setColumnsData(Data);
		}
		else if(mCourseID !=-1 && mSemisterID !=-1 && mSubjectID!=-1 &&  mTimeSlotID !=-1 &&

			mDayID !=-1 && mSubjectTypeID  !=-1 && mFloorID  !=-1 && mRoomID  !=-1 && mStaffID  ==-1 )
		{
			Data=ClsWorkAllocation.getAllWorkAllocation(mCourseID,mSemisterID,mSubjectID,mTimeSlotID,mDayID,mSubjectTypeID,mFloorID,mRoomID);
			setColumnsData(Data);
		}
		else if(mCourseID !=-1 && mSemisterID !=-1 && mSubjectID!=-1 &&  mTimeSlotID !=-1 &&

			mDayID !=-1 && mSubjectTypeID  !=-1 && mFloorID  !=-1 && mRoomID  !=-1 && mStaffID  !=-1 )
		{
			Data=ClsWorkAllocation.getAllWorkAllocationInformation(mCourseID,mSemisterID,mSubjectID,mTimeSlotID,mDayID,mSubjectTypeID,mFloorID,mRoomID,mStaffID);
			setColumnsData(Data);
		}
		else
		{
			System.out.println("\n\n\nPrinting Values");
			System.out.println(mCourseID);
			System.out.println(mSemisterID);
			System.out.println(mSubjectTypeID);
			System.out.println(mFloorID);
			System.out.println(mRoomID);
			System.out.println(mTimeSlotID);
			System.out.println(mStaffID);
			System.out.println(mDayID);
		}*/

	}



   public static void main(String args[])
   {
        FrmWorkAllocation A = new FrmWorkAllocation();
   }

}