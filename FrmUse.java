import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import timescreen.*;
import HtmlSetting.HtmlStyle;
import myUtility.*;
import javax.swing.border.*;
import DBReport.*;
import InputRestriction.*;

class FrmUse extends JFrame implements ActionListener
{
	//int w = 3020;
	TimeScreen ES;

	JLabel  lblUseID;
	JLabel  lblUseName;
	JLabel  lblProgrammeHeading;

    JTextField txtUseID;
    JTextField txtUseName;



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

    JComboBox cmbUseUpdate;
    JPanel pnlUseUpdate;
    JLabel lblUseUpdate;

    ReportTool tool;
    ButtonState bst;
    ClsButtonManagement cbm;

    int Rcols;

	JPanel pnlDataReport;
	FrmUse()
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
        pnlUseUpdate = ES.getFirstComboPanel();
        cmbUseUpdate = ES.getFirstComboBox();
        lblUseUpdate = ES.getFirstComboLabel();
        btnApply = ES.getApplyButton();
        lblProgrammeHeading = ES.getProgrammeHeading();
		lblUseUpdate.setText("Use ");
		lblProgrammeHeading.setText("UseForm..");
		lblProgrammeHeading.setBackground(Color.white);


		HtmlStyle.applyH1(lblProgrammeHeading);

		BlinkLabel bl = new BlinkLabel(lblProgrammeHeading,500);
		bl.start();

		int y = 20;
		int h = 30;
		int gap = 10;

       lblUseID = new JLabel("UseID");
       lblUseID.setBounds(10,y,150,h);
       lblUseID.setFont(F2);
       pnlData.add(lblUseID);

       txtUseID = new JTextField();
       txtUseID.setBounds(190,y,100,h);
       txtUseID.setFont(F2);
       pnlData.add(txtUseID);
       txtUseID.addKeyListener(new OnlyNumbers());


		y = y+h+gap;
       lblUseName = new JLabel("UseName");
	   lblUseName.setBounds(10,y,180,h);
	   lblUseName.setFont(F2);
	   pnlData.add(lblUseName);

       txtUseName = new JTextField();
	   txtUseName.setBounds(190,y,200,h);
	   txtUseName.setFont(F2);
       pnlData.add(txtUseName);




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
		cbm.manageFirstPanel(pnlUseUpdate);
		cbm.manageFirstLabel(lblUseUpdate);
		cbm.manageFirstCombo(cmbUseUpdate);
	}


   public void initUI()
   {
       txtUseID.setText("0");
       txtUseName.setText(" ");
   }

	public void addUseRecords(JComboBox cmbProcess)
	{
		cmbProcess.removeActionListener(this);
		ClsUse.addUseRecords(cmbProcess);
		cmbProcess.addActionListener(this);
	}


   public void actionPerformed(ActionEvent ae)
   {
       if(ae.getSource()==btnNew)
       {
			bst.setButtonState(ButtonState.NewState);
			cbm.showButtonsOnUI(bst);

           	txtUseID.setText("0");
			txtUseName.requestFocus();

	   }
	   else if(ae.getSource()==btnSave)
	   {
		   bst.setButtonState(ButtonState.SaveState);
			cbm.showButtonsOnUI(bst);
           ClsUse temp = readUI();
           ClsUse.addNewRecord(temp);
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
           ClsUse temp = readUI();
           ClsUse.updateRecord(temp);
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
            addUseRecords(cmbUseUpdate);

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
           ClsUse temp = readUI();
           ClsUse.deleteRecord(temp);
           JOptionPane.showMessageDialog(this,"Record Is Deleted Successfully");
           initUI();
	   }
	   else if(ae.getSource()==btnClose)
	   {
		   bst.setButtonUniqueState(ButtonState.CancelState);
			cbm.showButtonsOnUI(bst);
           initUI();
	   }
	   else if(ae.getSource()==cmbUseUpdate)
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

			String mUseName = (String)cmbUseUpdate.getSelectedItem();
			int mUseID = ClsUse.getUseIDFromName(mUseName);
			ClsUse temp = ClsUse.getUseInformation(mUseID);
			writeUI(temp);
		}
   }

   public void writeUI(ClsUse temp)
   {
		txtUseID.setText(String.valueOf(temp.getUseID()));
		txtUseName.setText(temp.getUseName());
   }

   ClsUse readUI()
   {

	   ClsUse temp2 = new ClsUse();
	   temp2.setUseID(Integer.parseInt(txtUseID.getText()));
	   temp2.setUseName(txtUseName.getText());

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
		Rcols+=tool.addNewColumn("UseID");
		Rcols+=tool.addNewColumn("UseName");


	}
	void setColumnsAlignment()
	{
		tool.setColumnAlignment(0,ReportTool.ALIGN_CENTER);
		tool.setColumnAlignment(1,ReportTool.ALIGN_CENTER);
	}
	void setColumnsWidth()
	{
		tool.setColumnWidth("UseID",80);
		tool.setColumnWidth("UseName",400);

	}

	void setColumnsData()
	{

		tool.removeAllRows();

		ClsUse Data[]=ClsUse.getAllUseInformation();

		for(int i=0;i<Data.length;i++)
		{
			Object Objectdata[]=new Object[Rcols];

			Objectdata[0]=i+1;
			Objectdata[1]=Data[i].getUseName();

            tool.addNewRow(Objectdata);
		}
	}


   public static void main(String args[])
   {
        FrmUse A = new FrmUse();
   }

}