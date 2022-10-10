import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import myUtility.*;
import timescreen.*;

public class ClsButtonManagement3
{
	JPanel pnlNew,pnlSave,pnlView,pnlEdit,pnlDelete,pnlCancel,pnlReport,pnlApply,pnlUpdate;
	JPanel pnlData,pnlEntry,pnlDataReport;
	ButtonState bst;

	JComboBox cmbFirst;
	JPanel pnlFirst;
	JLabel lblFirst;

	JComboBox cmbThird;
	JPanel pnlThird;
	JLabel lblThird;

	JComboBox cmbSecond;
	JPanel pnlSecond;
	JLabel lblSecond;


	void manageFirstCombo(JComboBox cmbFirst)
	{
		this.cmbFirst=cmbFirst;
	}
	void manageFirstPanel(JPanel pnlFirst)
	{
		this.pnlFirst=pnlFirst;
	}
	void manageFirstLabel(JLabel lblFirst)
	{
		this.lblFirst=lblFirst;
	}


    void manageSecondCombo(JComboBox cmbSecond)
	{
		this.cmbSecond=cmbSecond;
	}
	void manageSecondPanel(JPanel pnlSecond)
	{
		this.pnlSecond=pnlSecond;
	}
	void manageSecondLabel(JLabel lblSecond)
	{
		this.lblSecond=lblSecond;
	}


	void manageThirdCombo(JComboBox cmbThird)
	{
		this.cmbThird=cmbThird;
	}
	void manageThirdPanel(JPanel pnlThird)
	{
		this.pnlThird=pnlThird;
	}
	void manageThirdLabel(JLabel lblThird)
	{
		this.lblThird=lblThird;
	}




	void manageNewPanel(JPanel pnlNew)
	{
		this.pnlNew=pnlNew;
	}
	void manageDataPanel(JPanel pnlData)
	{
		this.pnlData=pnlData;
	}
	void manageEntryPanel(JPanel pnlEntry)
	{
		this.pnlEntry=pnlEntry;
	}
	void manageSavePanel(JPanel pnlSave)
	{
		this.pnlSave=pnlSave;
	}
	void manageViewPanel(JPanel pnlView)
	{
		this.pnlView=pnlView;
	}
	void manageEditPanel(JPanel pnlEdit)
	{
		this.pnlEdit=pnlEdit;
	}
	void manageUpdatePanel(JPanel pnlUpdate)
	{
		this.pnlUpdate=pnlUpdate;
	}
	void manageDeletePanel(JPanel pnlDelete)
	{
		this.pnlDelete=pnlDelete;
	}
	void manageCancelPanel(JPanel pnlCancel)
	{
		this.pnlCancel=pnlCancel;
	}
	void manageReportPanel(JPanel pnlReport)
	{
		this.pnlReport=pnlReport;
	}
	void manageDataReportPanel(JPanel pnlDataReport)
	{
		this.pnlDataReport=pnlDataReport;
	}
	void manageReportUIPanel(JPanel pnlDataReport)
	{
		this.pnlDataReport=pnlDataReport;
	}

	void manageApplyPanel(JPanel pnlApply)
	{
		this.pnlApply=pnlApply;
	}

	void showButtonsOnUI(ButtonState bst)
	 {
		 this.bst=bst;
		if(bst.getButtonUniqueState()==ButtonState.CancelState)
		{
			bst.setButtonUniqueState(ButtonState.ResetState);
			rejectAction();
		}

		else if(bst.getButtonState()==ButtonState.NewState)
		{
			PanelState.visibleComponents(pnlSave);
			PanelState.hideComponents(pnlNew);
			PanelState.hideComponents(pnlView);
			PanelState.enabledComponents(pnlEntry);
			PanelState.enabledComponents(pnlData);
			PanelState.hideComponents(pnlDataReport);

		}
		else if(bst.getButtonState()==ButtonState.SaveState)
		{
			PanelState.hideComponents(pnlDataReport);
			PanelState.visibleComponents(pnlView);
			PanelState.visibleComponents(pnlNew);
			PanelState.hideComponents(pnlSave);
			PanelState.disabledComponents(pnlData);

		}
		else if(bst.getButtonState()==ButtonState.UpdateState)
		{
			PanelState.disabledComponents(pnlFirst);
			PanelState.disabledComponents(pnlSecond);
			PanelState.disabledComponents(pnlThird);
			PanelState.disabledComponents(pnlApply);
			PanelState.hideComponents(pnlSave);
			PanelState.hideComponents(pnlUpdate);
			PanelState.hideComponents(pnlDelete);
			PanelState.disabledComponents(pnlData);
			PanelState.visibleComponents(pnlNew);
			PanelState.visibleComponents(pnlView);

			resetAllCombo();
		}
		else if(bst.getButtonState()==ButtonState.ViewState)
		{
			PanelState.hideComponents(pnlEdit);
			PanelState.hideComponents(pnlDelete);
			PanelState.hideComponents(pnlView);
			PanelState.hideComponents(pnlNew);
			PanelState.enabledComponents(pnlFirst);
			PanelState.enabledComponents(pnlApply);
		}
		else if(bst.getButtonState()==ButtonState.ApplyState)
		{
			PanelState.visibleComponents(pnlEdit);
			PanelState.visibleComponents(pnlDelete);
			PanelState.hideComponents(pnlUpdate);
			PanelState.hideComponents(pnlView);
			PanelState.hideComponents(pnlNew);
			PanelState.hideComponents(pnlSave);
			PanelState.disabledComponents(pnlFirst);
			PanelState.disabledComponents(pnlSecond);
			PanelState.disabledComponents(pnlThird);
			PanelState.disabledComponents(pnlApply);
			PanelState.disabledComponents(pnlData);

		}
		else if(bst.getButtonState()==ButtonState.EditState)
		{
			PanelState.hideComponents(pnlEdit);
			PanelState.enabledComponents(pnlData);
			PanelState.visibleComponents(pnlUpdate);
			PanelState.hideComponents(pnlDelete);


		}
		else if(bst.getButtonState()==ButtonState.DeleteState)
		{
			PanelState.hideComponents(pnlSave);
			PanelState.hideComponents(pnlEdit);
			PanelState.hideComponents(pnlDelete);
			PanelState.visibleComponents(pnlView);
			PanelState.visibleComponents(pnlNew);
			PanelState.disabledComponents(pnlData);

//			resetAllCombo();

		}
		else if(bst.getButtonState()==ButtonState.InitialState)
		{

			PanelState.visibleComponents(pnlNew);
			PanelState.visibleComponents(pnlView);
			PanelState.visibleComponents(pnlCancel);
			PanelState.visibleComponents(pnlReport);
			PanelState.hideComponents(pnlUpdate);
			PanelState.hideComponents(pnlEdit);
			PanelState.hideComponents(pnlDelete);
			PanelState.hideComponents(pnlSave);
			PanelState.hideComponents(pnlDataReport);
			PanelState.disabledComponents(pnlData);
			PanelState.disabledComponents(pnlEntry);
			PanelState.disabledComponents(pnlApply);
			PanelState.disabledComponents(pnlFirst);
			PanelState.disabledComponents(pnlSecond);
			PanelState.disabledComponents(pnlThird);
		}

		if(bst.getButtonCommonState()==ButtonState.ReportState)
		{
			PanelState.visibleComponents(pnlDataReport);
			//PanelState.hideComponents(pnlEntry);
			PanelState.hideComponents(pnlData);
		}
		else if(bst.getButtonCommonState()==ButtonState.CloseReportState)
		{
			PanelState.visibleComponents(pnlData);
			PanelState.hideComponents(pnlDataReport);
			bst.setButtonCommonState(ButtonState.ResetState);
		}
	 }
     void rejectAction()
	 {
		if(bst.getButtonCommonState()==ButtonState.ReportState)
		{
			bst.setButtonCommonState(ButtonState.CloseReportState);
			showButtonsOnUI(bst);
		}
		else if(bst.getButtonState()==ButtonState.NewState)
		{
			bst.setButtonState(ButtonState.InitialState);
			showButtonsOnUI(bst);
		}
		else if(bst.getButtonState()==ButtonState.ViewState)
		{
			bst.setButtonState(ButtonState.InitialState);
			showButtonsOnUI(bst);
			resetAllCombo();
		}
		else if(bst.getButtonState()==ButtonState.ApplyState)
		{
			bst.setButtonState(ButtonState.ViewState);
			showButtonsOnUI(bst);
		}
		else if(bst.getButtonState()==ButtonState.EditState)
		{
			bst.setButtonState(ButtonState.ApplyState);
			showButtonsOnUI(bst);
		}
	 }
	void resetAllCombo()
	{
		cmbFirst.removeAllItems();
		cmbFirst.addItem("No Records...");
		lblFirst=new JLabel("-----------------");
		PanelState.disabledComponents(pnlFirst);

		cmbSecond.removeAllItems();
		cmbSecond.addItem("No Records...");
		lblSecond=new JLabel("-----------------");
		PanelState.disabledComponents(pnlSecond);


		cmbThird.removeAllItems();
		cmbThird.addItem("No Records...");
		lblThird=new JLabel("-----------------");
		PanelState.disabledComponents(pnlThird);


	}

}