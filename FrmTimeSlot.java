import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import timescreen.*;
import HtmlSetting.HtmlStyle;
import myUtility.*;
import javax.swing.border.*;
import DBReport.*;
import InputRestriction.*;

class FrmTimeSlot extends JFrame implements ActionListener
{
	//int w = 3020;
	TimeScreen ES;

	JLabel  lblTimeSlotID;
	JLabel  lblTimeSlotName;
	JLabel  lblStartingTime;
	JLabel  lblEndingTime;
	JLabel  lblTimeSlotDescription;

	JLabel  lblProgrammeHeading;

    JTextField txtTimeSlotID;
    JTextField txtTimeSlotName;
    JTextField txtStartingTime;
    JTextField txtEndingTime;
    JTextField txtTimeSlotDescription;

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

    JComboBox cmbTimeSlotUpdate;
    JPanel pnlTimeSlotUpdate;
    JLabel lblTimeSlotUpdate;

    ReportTool tool;
    ButtonState bst;
    ClsButtonManagement cbm;

    int Rcols;

	JPanel pnlDataReport;
	FrmTimeSlot()
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
        pnlTimeSlotUpdate = ES.getFirstComboPanel();
        cmbTimeSlotUpdate = ES.getFirstComboBox();
        lblTimeSlotUpdate = ES.getFirstComboLabel();
        btnApply = ES.getApplyButton();
        lblProgrammeHeading = ES.getProgrammeHeading();
		lblTimeSlotUpdate.setText("TimeSlot Update...");
		lblProgrammeHeading.setText("TimeSlotForm..");

		HtmlStyle.applyH1(lblProgrammeHeading);

		BlinkLabel bl = new BlinkLabel(lblProgrammeHeading,500);
		bl.start();

		int y = 20;
		int h = 30;
		int gap = 10;

       lblTimeSlotID = new JLabel("TimeSlotID");
       lblTimeSlotID.setBounds(10,y,150,h);
       lblTimeSlotID.setFont(F2);
       pnlData.add(lblTimeSlotID);

       txtTimeSlotID = new JTextField();
       txtTimeSlotID.setBounds(190,y,100,h);
       txtTimeSlotID.setFont(F2);
       pnlData.add(txtTimeSlotID);
       txtTimeSlotID.addKeyListener(new OnlyNumbers());


		y = y+h+gap;
       lblTimeSlotName = new JLabel("TimeSlotName");
	   lblTimeSlotName.setBounds(10,y,180,h);
	   lblTimeSlotName.setFont(F2);
	   pnlData.add(lblTimeSlotName);

       txtTimeSlotName = new JTextField();
	   txtTimeSlotName.setBounds(190,y,200,h);
	   txtTimeSlotName.setFont(F2);
       pnlData.add(txtTimeSlotName);

		y = y+h+gap;
		lblStartingTime = new JLabel("StartingTime");
		lblStartingTime.setBounds(10,y,150,h);
		lblStartingTime.setFont(F2);
		pnlData.add(lblStartingTime);

		txtStartingTime = new JTextField();
		txtStartingTime.setBounds(190,y,100,h);
		txtStartingTime.setFont(F2);
		pnlData.add(txtStartingTime);
		//txtStartingTime.addKeyListener(new OnlyNumbers());

        y = y+h+gap;
		lblEndingTime = new JLabel("EndingTime");
		lblEndingTime.setBounds(10,y,150,h);
		lblEndingTime.setFont(F2);
		pnlData.add(lblEndingTime);

		txtEndingTime = new JTextField();
		txtEndingTime.setBounds(190,y,100,h);
		txtEndingTime.setFont(F2);
		pnlData.add(txtEndingTime);

        y = y+h+gap;
		lblTimeSlotDescription = new JLabel("Time Slot Description");
		lblTimeSlotDescription.setBounds(10,y,150,h);
		lblTimeSlotDescription.setFont(F2);
		pnlData.add(lblTimeSlotDescription);

		txtTimeSlotDescription = new JTextField();
		txtTimeSlotDescription.setBounds(190,y,100,h);
		txtTimeSlotDescription.setFont(F2);
		pnlData.add(txtTimeSlotDescription);

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
		cbm.manageFirstPanel(pnlTimeSlotUpdate);
		cbm.manageFirstLabel(lblTimeSlotUpdate);
		cbm.manageFirstCombo(cmbTimeSlotUpdate);
	}


   public void initUI()
   {
       txtTimeSlotID.setText("0");
       txtTimeSlotName.setText(" ");
       txtStartingTime.setText(" ");
       txtEndingTime.setText(" ");
       txtTimeSlotDescription.setText("0");

   }

   public void addTimeSlotRecords(JComboBox cmbProcess)
   {
      cmbProcess.removeActionListener(this);
      ClsTimeSlot.addTimeSlotRecords(cmbProcess);
      cmbProcess.addActionListener(this);

   }

   public void actionPerformed(ActionEvent ae)
   {
       if(ae.getSource()==btnNew)
       {
			bst.setButtonState(ButtonState.NewState);
			cbm.showButtonsOnUI(bst);

			txtTimeSlotName.requestFocus();
			initUI();

	   }
	   else if(ae.getSource()==btnSave)
	   {
		   bst.setButtonState(ButtonState.SaveState);
			cbm.showButtonsOnUI(bst);
           ClsTimeSlot temp = readUI();
           ClsTimeSlot.addNewRecord(temp);
           JOptionPane.showMessageDialog(this,"Record Is Saved Successfully");
	       initUI();
	  }
	   else if(ae.getSource()==btnUpdate)
	   {
		   bst.setButtonState(ButtonState.UpdateState);
			cbm.showButtonsOnUI(bst);
           ClsTimeSlot temp = readUI();
           ClsTimeSlot.updateRecord(temp);
           JOptionPane.showMessageDialog(this,"Record Is Updated Successfully");
           initUI();
	   }
	   else if(ae.getSource()==btnView)
	   {
			bst.setButtonState(ButtonState.ViewState);
			cbm.showButtonsOnUI(bst);
            addTimeSlotRecords(cmbTimeSlotUpdate);

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
           ClsTimeSlot temp = readUI();
           ClsTimeSlot.deleteRecord(temp);
           JOptionPane.showMessageDialog(this,"Record Is Deleted Successfully");
           initUI();
	   }
	   else if(ae.getSource()==btnClose)
	   {
		   bst.setButtonUniqueState(ButtonState.CancelState);
			cbm.showButtonsOnUI(bst);
           initUI();
	   }
	   else if(ae.getSource()==cmbTimeSlotUpdate)
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

			String mTimeSlotName = (String)cmbTimeSlotUpdate.getSelectedItem();
			int mTimeSlotID = ClsTimeSlot.getTimeSlotIDFromName(mTimeSlotName);
			ClsTimeSlot temp = ClsTimeSlot.getTimeSlotInformation(mTimeSlotID);
			writeUI(temp);
		}
   }

   public void writeUI(ClsTimeSlot temp)
   {
		txtTimeSlotID.setText(String.valueOf(temp.getTimeSlotID()));
		txtTimeSlotName.setText(temp.getTimeSlotName());
	    txtStartingTime.setText(temp.getStartingTime());
	    txtEndingTime.setText(temp.getEndingTime());
	    txtTimeSlotDescription.setText(String.valueOf(temp.getTimeSlotDescription()));

   }

   ClsTimeSlot readUI()
   {

	   ClsTimeSlot temp2 = new ClsTimeSlot();
	   temp2.setTimeSlotID(Integer.parseInt(txtTimeSlotID.getText()));
	   temp2.setTimeSlotName(txtTimeSlotName.getText());
	   temp2.setStartingTime(txtStartingTime.getText());
	   temp2.setEndingTime(txtEndingTime.getText());
	   temp2.setTimeSlotDescription(Integer.parseInt(txtTimeSlotDescription.getText()));

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
		tool.setColumnWidth("TimeSlotName",400);
		tool.setColumnWidth("StartingTime",100);
		tool.setColumnWidth("EndingTime",100);
		tool.setColumnWidth("TimeSlotDescription",100);

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
        FrmTimeSlot A = new FrmTimeSlot();
   }

}