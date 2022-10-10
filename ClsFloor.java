import java.sql.*;
import javax.swing.*;
class ClsFloor
{
	private int  FloorID ;
	private String FloorName;
	private int  TotalRooms;


	void setFloorID(int value)
	{
		FloorID = value;
	}
	int getFloorID()
	{
		return FloorID;
	}

	void setFloorName(String value)
	{
		FloorName = value;
	}
	String getFloorName()
	{
		return FloorName;
	}
	void setTotalRooms(int value)
	{
	   TotalRooms = value;
	}
	int getTotalRooms()
	{
	   return TotalRooms;
	}


	static void addNewRecord(ClsFloor temp)
	{
		DlsFloor.addNewRecord(temp);
	}

	static void updateRecord(ClsFloor temp)
	{
		DlsFloor.updateRecord(temp);
	}

	static void deleteRecord(ClsFloor temp)
	{
		DlsFloor.deleteRecord(temp);
	}

	static int getFloorIDFromName(String mFloorName)
	{
		return(DlsFloor.getFloorIDFromName(mFloorName));
	}
	static String getFloorNameFromID(int mFloorID)
	{
		return(DlsFloor.getFloorNameFromID(mFloorID));
	}
	static ClsFloor getFloorInformation(int mFloorID)
	{
		return(DlsFloor.getFloorInformation(mFloorID));
	}

	static void showFloor(ClsFloor temp)
	{
		System.out.println("Floor ID             : ..........    "+temp.getFloorID());
		System.out.println("Floor Name           : ..........    "+temp.getFloorName());
		System.out.println("TotalRooms                  : ..........    "+temp.getTotalRooms());

	}

	static ClsFloor[] getAllFloorInformation()
	{
		return(DlsFloor.getAllFloorInformation());
	}
	static int getAllRecordsCount()
	{
		return(DlsFloor.getAllRecordsCount());

	}

	static String[] getAllFloorRecords()
	{
		return(DlsFloor.getAllFloorRecords());
	}

	static void addFloorRecords(JComboBox cmbProcess)
	{
		String Query = "select FloorName from tblFloor order by FloorName";
		String data[]=getAllFloorRecords();
		cmbProcess.removeAllItems();
		cmbProcess.addItem("Select Floor...");
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
