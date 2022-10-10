import java.sql.*;
import javax.swing.*;
class ClsLevel
{
	private int  LevelID ;
	private String LevelName;
	private int  CourseID;


	void setLevelID(int value)
	{
		LevelID = value;
	}
	int getLevelID()
	{
		return LevelID;
	}

	void setLevelName(String value)
	{
		LevelName = value;
	}
	String getLevelName()
	{
		return LevelName;
	}
	void setCourseID(int value)
	{
	   CourseID = value;
	}
	int getCourseID()
	{
	   return CourseID;
	}


	static void addNewRecord(ClsLevel temp)
	{
		DlsLevel.addNewRecord(temp);
	}

	static void updateRecord(ClsLevel temp)
	{
		DlsLevel.updateRecord(temp);
	}

	static void deleteRecord(ClsLevel temp)
	{
		DlsLevel.deleteRecord(temp);
	}

	static int getLevelIDFromName(String mLevelName)
	{
		return(DlsLevel.getLevelIDFromName(mLevelName));
	}
	static String getLevelNameFromID(int mLevelID)
	{
		return(DlsLevel.getLevelNameFromID(mLevelID));
	}
	static ClsLevel getLevelInformation(int mLevelID)
	{
		return(DlsLevel.getLevelInformation(mLevelID));
	}

	static void showLevel(ClsLevel temp)
	{
		System.out.println("Level ID             : ..........    "+temp.getLevelID());
		System.out.println("Level Name           : ..........    "+temp.getLevelName());
		System.out.println("CourseID                  : ..........    "+temp.getCourseID());

	}

	static ClsLevel[] getAllLevelInformation()
	{
		return(DlsLevel.getAllLevelInformation());
	}
    static ClsLevel[] getAllLevelInformation(int mCourseID)
	{
		return(DlsLevel.getAllLevelInformation(mCourseID));
	}
	static int getAllRecordsCount()
	{
		return(DlsLevel.getAllRecordsCount());

	}
    static int getAllRecordsCount(int mCourseID)
	{
		return(DlsLevel.getAllRecordsCount(mCourseID));

	}
	static String[] getAllLevelRecords()
	{
		return(DlsLevel.getAllLevelRecords());
	}
    static String[] getAllLevelRecords(int mCourseID)
	{
		return(DlsLevel.getAllLevelRecords(mCourseID));
	}

	static void addLevelRecords(JComboBox cmbProcess)
	{
		String Query = "select LevelName from tblLevel order by LevelName";
		String data[]=getAllLevelRecords();
		cmbProcess.removeAllItems();
		cmbProcess.addItem("Select Level...");
		for(String item : data)
		{
			cmbProcess.addItem(item);
		}
	}

    static void addLevelRecords(JComboBox cmbProcess,int mCourseID)
	{
		String Query = "select LevelName from tblLevel where CourseID ="+String.valueOf(mCourseID)+" order by LevelName";
		String data[]=getAllLevelRecords(mCourseID);
		cmbProcess.removeAllItems();
		cmbProcess.addItem("Select Level...");
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
