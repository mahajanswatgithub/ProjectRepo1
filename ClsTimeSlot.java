import java.sql.*;
import javax.swing.*;
class ClsTimeSlot
{
	private int  TimeSlotID ;
	private String TimeSlotName;
	private String StartingTime;
	private String EndingTime;
	private int TimeSlotDescription;


	void setTimeSlotID(int value)
	{
		TimeSlotID = value;
	}
	int getTimeSlotID()
	{
		return TimeSlotID;
	}

	void setTimeSlotName(String value)
	{
		TimeSlotName = value;
	}
	String getTimeSlotName()
	{
		return TimeSlotName;
	}
	void setStartingTime(String value)
	{
	   StartingTime = value;
	}
	String getStartingTime()
	{
	   return StartingTime;
	}
    void setEndingTime(String value)
	{
	   EndingTime = value;
	}
	String getEndingTime()
	{
	   return EndingTime;
	}
   void setTimeSlotDescription(int value)
	{
	   TimeSlotDescription = value;
	}
	int getTimeSlotDescription()
	{
	   return TimeSlotDescription;
	}


	static void addNewRecord(ClsTimeSlot temp)
	{
		DlsTimeSlot.addNewRecord(temp);
	}

	static void updateRecord(ClsTimeSlot temp)
	{
		DlsTimeSlot.updateRecord(temp);
	}

	static void deleteRecord(ClsTimeSlot temp)
	{
		DlsTimeSlot.deleteRecord(temp);
	}

	static int getTimeSlotIDFromName(String mTimeSlotName)
	{
		return(DlsTimeSlot.getTimeSlotIDFromName(mTimeSlotName));
	}
	static String getTimeSlotNameFromID(int mTimeSlotID)
	{
		return(DlsTimeSlot.getTimeSlotNameFromID(mTimeSlotID));
	}
	static ClsTimeSlot getTimeSlotInformation(int mTimeSlotID)
	{
		return(DlsTimeSlot.getTimeSlotInformation(mTimeSlotID));
	}

	static void showTimeSlot(ClsTimeSlot temp)
	{
		System.out.println("TimeSlot ID             : ..........    "+temp.getTimeSlotID());
		System.out.println("TimeSlot Name           : ..........    "+temp.getTimeSlotName());
		System.out.println("StartingTime                  : ..........    "+temp.getStartingTime());
		System.out.println("EndingTime                  : ..........    "+temp.getEndingTime());
		System.out.println("TimeSlotDescription                  : ..........    "+temp.getTimeSlotDescription());
	}

	static ClsTimeSlot[] getAllTimeSlotInformation()
	{
		return(DlsTimeSlot.getAllTimeSlotInformation());
	}
	static int getAllRecordsCount()
	{
		return(DlsTimeSlot.getAllRecordsCount());

	}

	static String[] getAllTimeSlotRecords()
	{
		return(DlsTimeSlot.getAllTimeSlotRecords());
	}

	static void addTimeSlotRecords(JComboBox cmbProcess)
	{
		String Query = "select TimeSlotName from tblTimeSlot order by TimeSlotName";
		String data[]=getAllTimeSlotRecords();
		cmbProcess.removeAllItems();
		cmbProcess.addItem("Select TimeSlot...");
		for(String item : data)
		{
			cmbProcess.addItem(item);
		}
	}

	public static void main(String args[])
	{
		System.out.println(getAllRecordsCount());
	}
}
