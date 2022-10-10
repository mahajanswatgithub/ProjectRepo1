import java.sql.*;
import javax.swing.*;

class ClsStaff
{
	private int  StaffID ;
	private String StaffName;
	private int StaffWeeklyLoad;
	private String StaffEducation;
	private int LevelID;

	void setStaffID(int value)
	{
		StaffID = value;
	}
	int getStaffID()
	{
		return StaffID;
	}

	void setStaffName(String value)
	{
		StaffName = value;
	}
	String getStaffName()
	{
		return StaffName;
	}

	void setStaffWeeklyLoad(int value)
	{
		StaffWeeklyLoad = value;
	}
	int  getStaffWeeklyLoad()
	{
		return StaffWeeklyLoad;
	}

	void setStaffEducation(String value)
	{
		StaffEducation = value;
	}
	String getStaffEducation()
	{
		return StaffEducation;
	}

	void setLevelID(int value)
	{
		LevelID = value;
	}
	int getLevelID()
	{
		return LevelID;
	}

	static void addNewRecord(ClsStaff temp)
	{
		DlsStaff.addNewRecord(temp);
	}

	static void updateRecord(ClsStaff temp)
	{
		DlsStaff.updateRecord(temp);
	}

	static void deleteRecord(ClsStaff temp)
	{
		DlsStaff.deleteRecord(temp);
	}

	static int getStaffIDFromName(String mStaffName)
	{
		return(DlsStaff.getStaffIDFromName(mStaffName));
	}
	static String getStaffNameFromID(int mStaffID)
	{
			return(DlsStaff.getStaffNameFromID(mStaffID));
	}

	static int getAllRecordsCount()
	{
		return(DlsStaff.getAllRecordsCount());
	}
    static int getAllRecordsCount(int mLevelID)
	{
		return(DlsStaff.getAllRecordsCount(mLevelID));
	}

	static String[] getAllStaffRecords()
	{
		return(DlsStaff.getAllStaffRecords());
	}
    static String[] getAllStaffRecords(int mLevelID)
	{
		return(DlsStaff.getAllStaffRecords(mLevelID));
	}


	static ClsStaff getStaffInformation(int mStaffID)
	{
		return(DlsStaff.getStaffInformation(mStaffID));
	}

	static ClsStaff[] getAllStaffInformation()
	{
		return(DlsStaff.getAllStaffInformation());
	}
    static ClsStaff[] getAllStaffInformation(int mLevelID)
	{
		return(DlsStaff.getAllStaffInformation(mLevelID));
	}

	static void showStaff(ClsStaff temp)
	{
		System.out.println("Staff ID             : ..........    "+temp.getStaffID());
		System.out.println("Staff Name           : ..........    "+temp.getStaffName());
		System.out.println("StaffWeeklyLoad      : ..........    "+temp.getStaffWeeklyLoad());
		System.out.println("StaffEducation       : ..........    "+temp.getStaffEducation());
		System.out.println("LevelID              : ..........    "+temp.getLevelID());
	}



	static void addStaffRecords(JComboBox cmbProcess,int mLevelID)
	{
		String Query = "select StaffName from tblStaff where LevelID="+String.valueOf(mLevelID);
		String data[]=getAllStaffRecords(mLevelID);
		cmbProcess.removeAllItems();
		cmbProcess.addItem("Select Staff...");
		for(String item : data)
		{
			cmbProcess.addItem(item);
		}
	}

	static void addStaffRecords(JComboBox cmbProcess)
	{
		String Query = "select StaffName from tblStaff order by StaffName";
		String data[]=getAllStaffRecords();
		cmbProcess.removeAllItems();
		cmbProcess.addItem("Select Staff..");
		for(String item : data)
		{
			cmbProcess.addItem(item);
		}
	}

    public static void main(String args[])
	{
	}
}
