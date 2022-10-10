import java.io.*;
import DBManage.*;
import java.sql.*;
import myUtility.*;
import javax.swing.*;

class DlsRoom
{
	static void addNewRecord(ClsRoom temp)
	{
		String Q = "insert into tblRoom(RoomNumber,SittingCapacity,UseID,FloorID) values('"+
							temp.getRoomNumber()+"',"+String.valueOf(temp.getSittingCapacity())+","+
							String.valueOf(temp.getFloorID())+","+
							String.valueOf(temp.getUseID())+
							")";
		DBManager.addNewRecord(Q);
	    System.out.println(Q);
		JOptionPane.showMessageDialog(null,"Record Is Inserted Successfully .... ");
	}


	static void updateRecord(ClsRoom temp)
	{
		String Q = "update tblRoom set RoomNumber = '"+temp.getRoomNumber()+"',"+
							"SittingCapacity="+String.valueOf(temp.getSittingCapacity())+","+
							"FloorID="+String.valueOf(temp.getFloorID())+","+
							"UseID="+String.valueOf(temp.getUseID())+
							" where RoomID ="+String.valueOf(temp.getRoomID());
		DBManager.addNewRecord(Q);
		JOptionPane.showMessageDialog(null,"Record Is Updated Successfully .... ");
	}

	static void deleteRecord(ClsRoom temp)
	{
		String Q = "delete from tblRoom  where RoomID="+temp.getRoomID();
		DBManager.addNewRecord(Q);
		JOptionPane.showMessageDialog(null,"Record Is Deleted Successfully .... ");
	}

	static int getRoomIDFromRoomNumber(String mRoomNumber)
	{
		String Q = "select RoomID from tblRoom where RoomNumber='"+mRoomNumber+"'";
		return(DBManager.getCode(Q));
	}

	static String getRoomNumberFromRoomID(int mRoomID)
	{
		String Q = "select RoomNumber from tblRoom where RoomID="+String.valueOf(mRoomID);
		return(DBManager.getName(Q));
	}

    static int getAllRecordsCount()
	{
		String s="Select Count(*) from tblRoom";
		int Count =DBManager.getAllRecordsCount(s);
		return(Count);
	}
    static int getAllRecordsCount(int mFloorID,int mUseID)
	{
		String s="Select Count(*) from tblRoom where FloorID = "+String.valueOf(mFloorID)+" and UseID = "+String.valueOf(mUseID);
		int Count =DBManager.getAllRecordsCount(s);
		return(Count);
	}

    static int getAllRecordsCountFloorWise(int mFloorID)
	{
		String s="Select Count(*) from tblRoom where FloorID = "+String.valueOf(mFloorID);
		int Count =DBManager.getAllRecordsCount(s);
		return(Count);
	}
    static int getAllRecordsCountUseWise(int mUseID)
	{
		String s="Select Count(*) from tblRoom where UseID = "+String.valueOf(mUseID);
		int Count =DBManager.getAllRecordsCount(s);
		return(Count);
	}

    static String[] getAllRoomRecords()
	{
		String x="Select RoomNumber from tblRoom";
		int rec=getAllRecordsCount();
		return(DBManager.getAllRecords(x,rec));
	}

    static String[] getAllRoomRecords(int mFloorID,int mUseID)
	{
		String x="select RoomNumber from tblRoom where FloorID = "+String.valueOf(mFloorID)+" and UseID = "+String.valueOf(mUseID); //+"order by FloorName";
		int rec=getAllRecordsCount(mFloorID,mUseID);
		return(DBManager.getAllRecords(x,rec));
	}

    static String[] getAllRoomRecordsFloorWise(int mFloorID)
	{
		String x="select RoomNumber from tblRoom where FloorID = "+String.valueOf(mFloorID); //+"order by FloorName";
		int rec=getAllRecordsCountFloorWise(mFloorID);
		return(DBManager.getAllRecords(x,rec));
	}
    static String[] getAllRoomRecordsUseWise(int mUseID)
	{
		String x="select RoomNumber from tblRoom where UseID = "+String.valueOf(mUseID); //+"order by FloorName";
		int rec=getAllRecordsCountUseWise(mUseID);
		return(DBManager.getAllRecords(x,rec));
	}

	static ClsRoom getRoomInformation(int mRoomID)
	{
		ClsRoom temp = new ClsRoom();

		String Q = "select * from tblRoom where RoomID ="+String.valueOf(mRoomID);
		String values[]=DBManager.getFullRow(Q,5);

		temp.setRoomID(Integer.parseInt(values[0]));
        temp.setRoomNumber(values[1]);
        temp.setSittingCapacity(Integer.parseInt(values[2]));
        temp.setFloorID(Integer.parseInt(values[3]));
		temp.setUseID(Integer.parseInt(values[4]));
		return(temp);
	}

	static ClsRoom[] getAllRoomInformation(int mFloorID,int mUseID)
	{
		int rec=getAllRecordsCount(mFloorID,mUseID);
		ClsRoom obj[]=new ClsRoom[rec];
		String Query ="select * from tblRoom where FloorID="+String.valueOf(mFloorID)+" and UseID="+String.valueOf(mUseID);
		String values[][]=DBManager.getAllFullRow(Query,rec,5);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsRoom();
			obj[i].setRoomID(Integer.parseInt(values[i][0]));
			obj[i].setRoomNumber(values[i][1]);
            obj[i].setSittingCapacity(Integer.parseInt(values[i][2]));
			obj[i].setFloorID(Integer.parseInt(values[i][3]));
			obj[i].setUseID(Integer.parseInt(values[i][4]));

	    }
		return(obj);
	}

    static ClsRoom[] getAllRoomInformationFloorWise(int mFloorID)
   	{
        int rec=getAllRecordsCountFloorWise(mFloorID);
 		ClsRoom obj[]=new ClsRoom[rec];
		String Query ="select * from tblRoom";
		String values[][]=DBManager.getAllFullRow(Query,rec,5);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsRoom();
			obj[i].setRoomID(Integer.parseInt(values[i][0]));
			obj[i].setRoomNumber(values[i][1]);
            obj[i].setSittingCapacity(Integer.parseInt(values[i][2]));
			obj[i].setFloorID(Integer.parseInt(values[i][3]));
			obj[i].setUseID(Integer.parseInt(values[i][4]));

	    }
		return(obj);

	}

    static ClsRoom[] getAllRoomInformationUseWise(int mUseID)
   	{
        int rec=getAllRecordsCountUseWise(mUseID);
 		ClsRoom obj[]=new ClsRoom[rec];
		String Query ="select * from tblRoom";
		String values[][]=DBManager.getAllFullRow(Query,rec,5);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsRoom();
			obj[i].setRoomID(Integer.parseInt(values[i][0]));
			obj[i].setRoomNumber(values[i][1]);
            obj[i].setSittingCapacity(Integer.parseInt(values[i][2]));
			obj[i].setFloorID(Integer.parseInt(values[i][3]));
			obj[i].setUseID(Integer.parseInt(values[i][4]));

	    }
		return(obj);

	}


    static ClsRoom[] getAllRoomInformation()
	{
		int rec=getAllRecordsCount();
		ClsRoom obj[]=new ClsRoom[rec];
		String Query ="select * from tblRoom";
		String values[][]=DBManager.getAllFullRow(Query,rec,5);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsRoom();
			obj[i].setRoomID(Integer.parseInt(values[i][0]));
			obj[i].setRoomNumber(values[i][1]);
            obj[i].setSittingCapacity(Integer.parseInt(values[i][2]));
            obj[i].setFloorID(Integer.parseInt(values[i][3]));
			obj[i].setUseID(Integer.parseInt(values[i][4]));

	    }
		return(obj);
	}

	public static void main(String args[])
	{

	}

}

