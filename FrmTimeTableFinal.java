import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import timescreen.*;
import HtmlSetting.HtmlStyle;
import myUtility.*;
import javax.swing.border.*;
import DBReport.*;
import InputRestriction.*;

class FrmTimeTableFinal extends JFrame implements ActionListener
{

	TimeTableFinal ES;

    JPanel pnlMenu;
    JPanel pnlSelect;
    JLabel lblProgrammeHeading;
    JPanel pnlNew;
	JButton btnAddNew;
    JButton btnSelect;
    JPanel pnlCourseUpdate;
    JLabel lblCourseUpdate;
    JComboBox cmbCourseUpdate;

    JPanel pnlSemisterUpdate;
    JLabel lblSemisterUpdate;
    JComboBox cmbSemisterUpdate;

	JPanel TimeOptionPanel[];
    JPanel TimeDetailPanel[][];
	JLabel TimeDetailLabel[][];

    JPanel DisplayPanelArray[];
	JButton DisplayButtonArray[];

	JPanel pnlOption1;
	JLabel lblOption1;

	JPanel pnlOption2;
	JLabel lblOption2;

    ClsTimeSlot TimeSlotData[];
	JButton TimeOptionButton[];

    int vCourseID=0;
    int vSemisterID=0;

	int TimeSlotElements[];

	int vDisplayAction=-1;


	FrmTimeTableFinal()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		setSize(screenSize.width,screenSize.height);
		setTitle("Time Table Final...");
		ES = new TimeTableFinal();
		add(ES);

        pnlMenu=ES.getMenuPanel();
        pnlSelect=ES.getSelectPanel();
        btnSelect=ES.getSelectButton();

        pnlCourseUpdate = ES.getFirstComboPanel();
        cmbCourseUpdate = ES.getFirstComboBox();
        lblCourseUpdate = ES.getFirstComboLabel();
		lblCourseUpdate.setText("Course");

        pnlSemisterUpdate = ES.getSecondComboPanel();
        cmbSemisterUpdate = ES.getSecondComboBox();
        lblSemisterUpdate = ES.getSecondComboLabel();
		lblSemisterUpdate.setText("Semister ");

        TimeDetailPanel=ES.getTimeDetailOptionsPanel();
		TimeDetailLabel=ES.getTimeDetailOptionsLabel();

		DisplayPanelArray=ES.getDisplayButtonPanels();
		DisplayButtonArray=ES.getDisplayButtonButtons();

		PanelState.enabledComponents(DisplayPanelArray[0]);
		DisplayButtonArray[0].setLabel("Show Subject");
		DisplayButtonArray[0].addActionListener(this);

		PanelState.enabledComponents(DisplayPanelArray[1]);
		DisplayButtonArray[1].setLabel("Show Staff");
		DisplayButtonArray[1].addActionListener(this);


		PanelState.enabledComponents(DisplayPanelArray[2]);
		DisplayButtonArray[2].setLabel("Theory/Practical");
		DisplayButtonArray[2].addActionListener(this);


		PanelState.enabledComponents(DisplayPanelArray[3]);
		DisplayButtonArray[3].setLabel("Allocated Room");
		DisplayButtonArray[3].addActionListener(this);

		PanelState.enabledComponents(DisplayPanelArray[4]);
		DisplayButtonArray[4].setLabel("New Allocation");
		DisplayButtonArray[4].addActionListener(this);

		//lblProgrammeHeading.setText("Easy Way To Create Time Table...");
       // HtmlStyle.applyH1(lblProgrammeHeading);




      //  cmbCourseUpdate.addActionListener(this);
      //  cmbSemisterUpdate.addActionListener(this);

        ES.UIAreaSetting(1400,460);

		addCourseRecords(cmbCourseUpdate);

		show();
        btnSelect.addActionListener(this);
        PanelState.enabledComponents(pnlSelect);

        ManageTimeSlot();

	}

    void addCourseRecords(JComboBox temp)
	{
		temp.removeActionListener(this);
		ClsCourse.addCourseRecords(temp);
		temp.addActionListener(this);
	}

	void addSemisterRecords(JComboBox temp)
	{
		temp.removeActionListener(this);
		temp.removeAllItems();
		temp.addItem("Select Semister");
		temp.addItem("1");
		temp.addItem("2");
		temp.addItem("3");
		temp.addItem("4");
		temp.addItem("5");
		temp.addItem("6");

		temp.addActionListener(this);
	}


   public void actionPerformed(ActionEvent ae)
   {
        if(ae.getSource()==btnSelect)
		{
			JOptionPane.showMessageDialog(this,"Project Developed By Swati Mahajan");
		}
        else if(ae.getSource()==DisplayButtonArray[0])
		{
			vDisplayAction=1;
			showTimeTableData();
		}
		else if(ae.getSource()==DisplayButtonArray[1])
		{
			vDisplayAction=2;
			showTimeTableData();
		}
		else if(ae.getSource()==DisplayButtonArray[2])
		{
			vDisplayAction=3;
			showTimeTableData();
		}
		else if(ae.getSource()==DisplayButtonArray[3])
		{
			vDisplayAction=4;
			showTimeTableData();
		}
		else if(ae.getSource()==DisplayButtonArray[4])
		{
			FrmWorkAllocation  A = new FrmWorkAllocation();
			A.show();
			showTimeTableData();
		}
        else if(ae.getSource()==cmbCourseUpdate)
		{

            if(cmbCourseUpdate.getSelectedIndex()==0)
			{
				JOptionPane.showMessageDialog(null,"Please Select The Course .... ");
			}
			else
			{
				String mCourseName = (String)cmbCourseUpdate.getSelectedItem();
				vCourseID = ClsCourse.getCourseIDFromName(mCourseName);
				addSemisterRecords(cmbSemisterUpdate);

	//			showTimeTableReport(vCourseID,-1,-1,-1,-1,-1,-1,-1,-1);
            }

		}
        else if(ae.getSource()==cmbSemisterUpdate)
		{

			if(cmbSemisterUpdate.getSelectedIndex()==0)
			{
				JOptionPane.showMessageDialog(null,"Please Select The Course .... ");
			}
			else
			{
			    vSemisterID = Integer.parseInt((String)cmbSemisterUpdate.getSelectedItem());

			    showTimeTableData();
            }

		}

   }

    void ManageTimeSlot()
    {
		TimeSlotData=ClsTimeSlot.getAllTimeSlotInformation();
		TimeSlotElements = new int[TimeSlotData.length];
		TimeOptionPanel = ES.getTimeOptionsPanel();
		TimeOptionButton = ES.getTimeOptionsButton();

        for (int i=0;i<TimeOptionPanel.length;i++)
		{
			if(i<TimeSlotData.length)
			{
				TimeSlotElements[i]=TimeSlotData[i].getTimeSlotID();
				PanelState.enabledComponents(TimeOptionPanel[i]);
				TimeOptionButton[i].setLabel(TimeSlotData[i].getStartingTime());
			}
			else
			{
				PanelState.enabledComponents(TimeOptionPanel[i]);
			}
		}

    }
    void showTimeTableData()
	{
		resetTimeTableData();
		if(vCourseID!=-1 && vSemisterID!=-1)
		{
			ClsWorkAllocation temps[]=ClsWorkAllocation.getAllWorkAllocationInformation(vCourseID,vSemisterID);
			//String details = "SessionID : " + String.valueOf(vSessionID) +
			//				 "CourseID : " + String.valueOf(vCourseID)+
			//				 "SemisterID : " + String.valueOf(vSemisterID);
			//JOptionPane.showMessageDialog(this,"Values :  "+details);
			//JOptionPane.showMessageDialog(this,"Total Records Available Are  :  "+String.valueOf(temps.length));
			//TimeOptionPanel.length=6
			//TimeSlotData.length=4
			//temps.length=2
			for (int i=0;i<TimeOptionPanel.length;i++)
			{
				if(i<TimeSlotData.length)
				{
					for(int j=0;j<7;j++)
					{
						for(ClsWorkAllocation temp : temps)
						{
							//JOptionPane.showMessageDialog(null,"temp.getTimeSlotID() "+String.valueOf(temp.getTimeSlotID())+" == "+"TimeSlotElements[i]  "+String.valueOf(TimeSlotElements[i])+" && "+"temp.getDayID() "+String.valueOf(temp.getDayID())+" [j+1] "+String.valueOf(j+1));
							if(temp.getTimeSlotID()==TimeSlotElements[i] && temp.getDayID()==j+1)
							{
								TimeDetailPanel[i][j].setBackground(Color.black);
								String DisplayText="Book";

								if(vDisplayAction==1)
								{
									DisplayText=ClsSubject.getSubjectNameFromID(temp.getSubjectID());
								}
								else if(vDisplayAction==2)
								{
									DisplayText=ClsStaff.getStaffNameFromID(temp.getStaffID());
								}
								else if(vDisplayAction==3)
								{
									String mSubjectType="";
									if(temp.getSubjectTypeID()==1)
										DisplayText="Theory";
									else
										DisplayText="Practical";
								}
								else if(vDisplayAction==4)
								{
									DisplayText=ClsRoom.getRoomNumberFromRoomID(temp.getRoomID());
								}
								//String mStaffName =
								//String mSubjectName =
								//DisplayText = mSubjectName +"\n"+ mSubjectType;


								TimeDetailLabel[i][j].setText(DisplayText);
								break;
							}
							else
							{
								TimeDetailPanel[i][j].setBackground(new Color(209,209,209));
								TimeDetailLabel[i][j].setText("NOP");
							}
						}
					}
				}
			}
		}
	}

	void resetTimeTableData()
	{
		for (int i=0;i<TimeOptionPanel.length;i++)
		{
			for(int j=0;j<7;j++)
			{
				TimeDetailPanel[i][j].setBackground(new Color(209,209,209));
				TimeDetailLabel[i][j].setText("Galaxy");
			}
		}
	}
   public static void main(String args[])
   {
        FrmTimeTableFinal A = new FrmTimeTableFinal();
        A.show();
   }

}