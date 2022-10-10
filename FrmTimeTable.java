import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import javax.swing.event.*;
import timescreen.*;
import DBReport.*;
import javax.swing.border.*;
import myUtility.*;
import HtmlSetting.*;
class FrmTimeTable extends JFrame implements ActionListener
{
	JPanel MainParent;
	TimeTablePanel EP;

	JLabel lblProgramHeading;

	JPanel pnlNew;
	JButton btnAddNew;

	JPanel TimeOptionPanel[];
	JButton TimeOptionButton[];

	JPanel DisplayPanelArray[];
	JButton DisplayButtonArray[];


	JPanel TimeDetailPanel[][];
	JLabel TimeDetailLabel[][];

	JPanel SelPanel1;
	JLabel SelLabel1;
	JComboBox SelComboBox1;

	JPanel SelPanel2;
	JLabel SelLabel2;
	JComboBox SelComboBox2;

	JPanel SelPanel3;
	JLabel SelLabel3;
	JComboBox SelComboBox3;



	ClsTimeSlot TimeSlotData[];
	int vSessionID = -1;
	int vCourseID = -1;
	int vSemisterID = -1;

	int TimeSlotElements[];
	int vDisplayAction=-1;

	FrmTimeTable ()
	{

		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension d=tk.getScreenSize();
		setSize(d.width,d.height);
		setLayout(null);

		EP=new TimeTablePanel();
		add(EP);


		MainParent=EP.getUIParentPanel();

		SelPanel1=EP.getSelectionOptionPanel1();
		SelLabel1=EP.getSelectionOptionLabel1();
		SelComboBox1=EP.getSelectionOptionCombo1();

		SelLabel1.setText("Select Session .... ");
		SelComboBox1.addItem("Select Session");
		SelComboBox1.addItem("Morning Session");
		SelComboBox1.addItem("Noon Session");
		SelComboBox1.addActionListener(this);

		SelPanel2 = EP.getSelectionOptionPanel2();
		SelLabel2 = EP.getSelectionOptionLabel2();
		SelComboBox2 = EP.getSelectionOptionCombo2();
		addCourseRecordsInComboBox(SelComboBox2);
		SelLabel2.setText("Select Course .... ");

		SelPanel3 = EP.getSelectionOptionPanel3();
		SelLabel3 = EP.getSelectionOptionLabel3();
		SelComboBox3 = EP.getSelectionOptionCombo3();
		SelLabel3.setText("Select Semister .... ");


		TimeDetailPanel=EP.getTimeDetailOptionsPanel();
		TimeDetailLabel=EP.getTimeDetailOptionsLabel();

		DisplayPanelArray=EP.getDisplayButtonPanels();
		DisplayButtonArray=EP.getDisplayButtonButtons();

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

		PanelState.enabledComponents(DisplayPanelArray[5]);
		DisplayButtonArray[5].setLabel("New Allocation");
		DisplayButtonArray[5].addActionListener(this);

		lblProgramHeading=EP.getProgramHeadingLabel();
		lblProgramHeading.setText("TIME TABLE DISPLAY");

		HtmlStyle.applyH2(lblProgramHeading);


		pnlNew=EP.getNewPanel();

		btnAddNew=EP.getNewButton();
		btnAddNew.addActionListener(this);




	}


	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==DisplayButtonArray[0])
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
		else if(ae.getSource()==DisplayButtonArray[5])
		{
			FrmWorkAllocation  A = new FrmWorkAllocation();

			A.show();

			showTimeTableData();
		}
		/*else if(ae.getSource()==SelComboBox1)
		{
			if(SelComboBox1.getSelectedIndex()==1)
			{
				vSessionID=0;
			}
			else
			{
				vSessionID=1;
			}

			TimeSlotData=ClsTimeSlot.getAllTimeSlotSessionWise(vSessionID);
			TimeSlotElements = new int[TimeSlotData.length];
			TimeOptionPanel = EP.getTimeOptionsPanel();
			TimeOptionButton = EP.getTimeOptionsButton();
			for (int i=0;i<TimeOptionPanel.length;i++)
			{
				if(i<TimeSlotData.length)
				{
					TimeSlotElements[i]=TimeSlotData[i].getTimeSlotID();
					PanelState.showComponents(TimeOptionPanel[i]);
					TimeOptionButton[i].setLabel(TimeSlotData[i].getStartingTime());
				}
				else
				{
					PanelState.hideComponents(TimeOptionPanel[i]);
				}
			}
		}
		*/
		else if(ae.getSource()==SelComboBox2)
		{

			if(SelComboBox2.getSelectedIndex()==0)
			{
				JOptionPane.showMessageDialog(null,"Please Select The Course .... ");
			}
			else
			{
				String x = (String)SelComboBox2.getSelectedItem();
				vCourseID = ClsCourse.getCourseIDFromName(x);
				addSemisterRecordsInComboBox(SelComboBox3);
				showTimeTableData();
			}
		}
		else if(ae.getSource()==SelComboBox3)
		{

			if(SelComboBox3.getSelectedIndex()==0)
			{
				JOptionPane.showMessageDialog(null,"Please Select The Semister .... ");
			}
			else
			{
				vSemisterID = SelComboBox3.getSelectedIndex();
				showTimeTableData();
			}

		}
	}

	void showTimeTableData()
	{
		resetTimeTableData();
		if(vSessionID!=-1 && vCourseID!=-1 && vSemisterID!=-1)
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

	void addCourseRecordsInComboBox(JComboBox temp)
	{
		temp.removeActionListener(this);
		ClsCourse.addCourseRecords(temp);
		temp.addActionListener(this);
	}

	void addSemisterRecordsInComboBox(JComboBox temp)
	{
		temp.removeActionListener(this);
		temp.removeAllItems();
		temp.addItem("Select Semister");
		temp.addItem("1");
		temp.addItem("2");
		temp.addItem("3");
		temp.addActionListener(this);
	}

	public static void main(String args[])
	{
	        FrmTimeTable f=new FrmTimeTable();
			f.show();
	}
}



