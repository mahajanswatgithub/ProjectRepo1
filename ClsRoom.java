import java.sql.*;
import javax.swing.*;
class ClsRoom
{
	private int  RoomID;
	private String RoomNumber;
	private int SittingCapacity;
	private int FloorID;
	private int UseID;

	void setRoomID(int value)
	{
		RoomID = value;
	}
	int getRoomID()
	{
		return RoomID;
	}
    void setRoomNumber(String value)
	{
		RoomNumber = value;
	}
	String getRoomNumber()
	{
		return RoomNumber;
	}
	void setSittingCapacity(int value)
	{
		SittingCapacity = value;
	}
	int getSittingCapacity()
	{
		return SittingCapacity;
	}

	void setFloorID(int value)
	{
		FloorID = value;
	}
	int getFloorID()
	{
	    return FloorID;
	}
    void setUseID(int value)
	{
		UseID = value;
	}
	int getUseID()
	{
		return UseID;
	}
	static void addNewRecord(ClsRoom temp)
	{
		DlsRoom.addNewRecord(temp);
	}

	static void updateRecord(ClsRoom temp)
	{
		DlsRoom.updateRecord(temp);
	}

	static void deleteRecord(ClsRoom temp)
	{
		DlsRoom.deleteRecord(temp);
	}

	static int getRoomIDFromRoomNumber(String mRoomNumber)
	{
		return(DlsRoom.getRoomIDFromRoomNumber(mRoomNumber));
	}
	static String getRoomNumberFromRoomID(int mRoomID)
	{
		return(DlsRoom.getRoomNumberFromRoomID(mRoomID));
	}

    static int getAllRecordsCount()
	{
		return(DlsRoom.getAllRecordsCount());
	}
    static int getAllRecordsCountUseWise(int mUseID)
	{
		return(DlsRoom.getAllRecordsCountUseWise(mUseID));
	}
    static int getAllRecordsCountFloorWise(int mFloorID)
	{
		return(DlsRoom.getAllRecordsCountFloorWise(mFloorID));
	}

    static String[] getAllRoomRecords()
	{
		return(DlsRoom.getAllRoomRecords());
	}
	static String[] getAllRoomRecords(int mFloorID,int mUseID)
	{
		return(DlsRoom.getAllRoomRecords(mFloorID,mUseID));
	}
	static String[] getAllRoomRecordsUseWise(int mUseID)
	{
		return(DlsRoom.getAllRoomRecordsUseWise(mUseID));
	}
	static String[] getAllRoomRecordsFloorWise(int mFloorID)
	{
		return(DlsRoom.getAllRoomRecordsFloorWise(mFloorID));
	}


	static ClsRoom getRoomInformation(int mRoomID)
	{
		return(DlsRoom.getRoomInformation(mRoomID));
	}

    static ClsRoom[] getAllRoomInformation()
	{
		return(DlsRoom.getAllRoomInformation());
	}

    static ClsRoom[] getAllRoomInformation(int mFloorID,int mUseID)
   	{
   		return(DlsRoom.getAllRoomInformation(mFloorID,mUseID));
   	}

    static ClsRoom[] getAllRoomInformationUseWise(int mUseID)
   	{
   		return(DlsRoom.getAllRoomInformationUseWise(mUseID));
   	}

    static ClsRoom[] getAllRoomInformationFloorWise(int mFloorID)
   	{
   		return(DlsRoom.getAllRoomInformationFloorWise(mFloorID));
   	}

	static void showRoom(ClsRoom temp)
	{
		System.out.println("Room ID                 : ..........    "+temp.getRoomID());
		System.out.println("Room Number             : ..........    "+temp.getRoomNumber());
        System.out.println("Room SittingCapacity    : ..........    "+temp.getSittingCapacity());
		System.out.println("Floor ID                : ..........    "+temp.getFloorID());
		System.out.println("Use ID                  : ..........    "+temp.getUseID());
	}

    static void addRoomRecords(JComboBox cmbProcess)
	{
		String data[]=getAllRoomRecords();
		cmbProcess.removeAllItems();
		cmbProcess.addItem("Select Room...");
		for(String item : data)
		{
			cmbProcess.addItem(item);
		}
	}


    static void addRoomRecords(JComboBox cmbProcess,int mFloorID,int mUseID)
	{
		String data[]=getAllRoomRecords(mFloorID,mUseID);
		cmbProcess.removeAllItems();
		cmbProcess.addItem("Select Room...");
		for(String item : data)
		{
			cmbProcess.addItem(item);
		}
	}

	public static void addRoomRecordsFloorWise(JComboBox cmbProcess,int mFloorID)
	{
		String data[]=getAllRoomRecordsFloorWise(mFloorID);
		cmbProcess.removeAllItems();
		cmbProcess.addItem("Select Room Number");
		for(String item : data)
		{
			cmbProcess.addItem(item);
		}
	}

	public static  void addRoomRecordsUseWise(JComboBox cmbProcess,int mUseID)
	{
		String data[]=getAllRoomRecordsUseWise(mUseID);
		cmbProcess.removeAllItems();
		cmbProcess.addItem("Select Room .....");
		for(String item : data)
		{
			cmbProcess.addItem(item);
		}
	}
   /* public static  void addRoomRecords(JComboBox cmbProcess)
	{
		String data[]=getAllRoomRecords();
		cmbProcess.removeAllItems();
		cmbProcess.addItem("Select Room .....");
		for(String item : data)
		{
			cmbProcess.addItem(item);
		}
	}*/

	/*public static  void addRoomTypeRecords(JComboBox cmbProcess)
	{
		String data[]={"Seminar Hall","Big Hall","Living Room","Class","Shop","Hospital","Celebration Hall","Cafe"};
		cmbProcess.removeAllItems();
		cmbProcess.addItem("Select Room Type");
		for(String item : data)
		{
			cmbProcess.addItem(item);
		}
	}*/


	public static void main(String args[])
	{

	}
}
