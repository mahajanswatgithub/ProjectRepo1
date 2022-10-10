import java.io.*;
import DBManage.*;
import java.sql.*;
import myUtility.*;
import javax.swing.*;

class DlsFloor
{
	static void addNewRecord(ClsFloor temp)
	{
		String Q = "insert into tblFloor(FloorName,TotalRooms)values('"+temp.getFloorName()+"',"+String.valueOf(temp.getTotalRooms())+")";
		DBManager.addNewRecord(Q);
		JOptionPane.showMessageDialog(null,"Record Is Inserted Successfully .... ");
	}


	static void updateRecord(ClsFloor temp)
	{
		String Q = "update tblFloor set FloorName='"+temp.getFloorName()+"',TotalRooms="+String.valueOf(temp.getTotalRooms())+" where FloorID ="+String.valueOf(temp.getFloorID());
		DBManager.addNewRecord(Q);
		JOptionPane.showMessageDialog(null,"Record Is Updated Successfully .... ");
	}

	static void deleteRecord(ClsFloor temp)
	{
		String Q = "delete from tblFloor  where FloorID="+temp.getFloorID();
		DBManager.addNewRecord(Q);
		JOptionPane.showMessageDialog(null,"Record Is Deleted Successfully .... ");
	}

	static int getFloorIDFromName(String mFloorName)
	{
		String Q = "select FloorID from tblFloor where FloorName='"+mFloorName+"'";
		return(DBManager.getCode(Q));
	}


	static String getFloorNameFromID(int mFloorID)
	{
		String Q = "select FloorName from tblFloor where FloorID="+String.valueOf(mFloorID);
		return(DBManager.getName(Q));
	}


	static int getAllRecordsCount()
	{
		String s="Select Count(*) from tblFloor";
		int Count =DBManager.getAllRecordsCount(s);
		return(Count);
	}


	static String[] getAllFloorRecords()
	{
		String Q="Select FloorName from tblFloor";
		int rec=getAllRecordsCount();
		return(DBManager.getAllRecords(Q,rec));
	}



	static ClsFloor getFloorInformation(int mFloorID)
	{
		ClsFloor temp = new ClsFloor();
		String Q = "select * from tblFloor where FloorID="+String.valueOf(mFloorID);
		String values[]=DBManager.getFullRow(Q,3);
		temp.setFloorID(Integer.parseInt(values[0]));
		temp.setFloorName(values[1]);
		temp.setTotalRooms(Integer.parseInt(values[2]));
		return(temp);
	}


	static ClsFloor[] getAllFloorInformation()
	{
		int rec=getAllRecordsCount();
		ClsFloor obj[]=new ClsFloor[rec];
		String Query ="select * from tblFloor";
		String values[][]=DBManager.getAllFullRow(Query,rec,3);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsFloor();
			obj[i].setFloorID(Integer.parseInt(values[i][0]));
			obj[i].setFloorName(values[i][1]);
			obj[i].setTotalRooms(Integer.parseInt(values[i][2]));

		}
		return(obj);
	}



	public static void main(String args[])
	{
	}

}

