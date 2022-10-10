import java.sql.*;
import javax.swing.*;
class ClsUse
{
	private int  UseID ;
	private String UseName;
	private int  TotalRooms;


	void setUseID(int value)
	{
		UseID = value;
	}
	int getUseID()
	{
		return UseID;
	}

	void setUseName(String value)
	{
		UseName = value;
	}
	String getUseName()
	{
		return UseName;
	}

	static void addNewRecord(ClsUse temp)
	{
		DlsUse.addNewRecord(temp);
	}

	static void updateRecord(ClsUse temp)
	{
		DlsUse.updateRecord(temp);
	}

	static void deleteRecord(ClsUse temp)
	{
		DlsUse.deleteRecord(temp);
	}

	static int getUseIDFromName(String mUseName)
	{
		return(DlsUse.getUseIDFromName(mUseName));
	}
	static String getUseNameFromID(int mUseID)
	{
		return(DlsUse.getUseNameFromID(mUseID));
	}
	static ClsUse getUseInformation(int mUseID)
	{
		return(DlsUse.getUseInformation(mUseID));
	}

	static void showUse(ClsUse temp)
	{
		System.out.println("Use ID             : ..........    "+temp.getUseID());
		System.out.println("Use Name           : ..........    "+temp.getUseName());

	}

	static ClsUse[] getAllUseInformation()
	{
		return(DlsUse.getAllUseInformation());
	}
	static int getAllRecordsCount()
	{
		return(DlsUse.getAllRecordsCount());

	}

	static String[] getAllUseRecords()
	{
		return(DlsUse.getAllUseRecords());
	}

	static void addUseRecords(JComboBox cmbProcess)
	{
		String Query = "select UseName from tblUse order by UseName";
		String data[]=getAllUseRecords();
		cmbProcess.removeAllItems();
		cmbProcess.addItem("Select Use...");
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
