import java.io.*;
import DBManage.*;
import java.sql.*;
import myUtility.*;
import javax.swing.*;

class DlsTimeSlot
{
	static void addNewRecord(ClsTimeSlot temp)
	{
		String SQ ="'";
		String Comma =",";

		String Q = "insert into tblTimeSlot(TimeSlotName,StartingTime,EndingTime,TimeSlotDescription)values("+
		           SQ+temp.getTimeSlotName()+SQ+Comma+
		           SQ+temp.getStartingTime()+SQ+Comma+
		           SQ+temp.getEndingTime()+SQ+Comma+
		           String.valueOf(temp.getTimeSlotDescription())+
		           ")";
		DBManager.addNewRecord(Q);
		JOptionPane.showMessageDialog(null,"Record Is Inserted Successfully .... ");
	}


	static void updateRecord(ClsTimeSlot temp)
	{
	    String SQ ="'";
		String Comma =",";

		String Q = "update tblTimeSlot set "+
		           "TimeSlotName="+SQ+temp.getTimeSlotName()+SQ+Comma+
		           "StartingTime="+SQ+temp.getStartingTime()+SQ+Comma+
		           "EndingTime="+SQ+temp.getEndingTime()+SQ+Comma+
		           "TimeSlotDescription="+String.valueOf(temp.getTimeSlotDescription())+
		           " where TimeSlotID ="+String.valueOf(temp.getTimeSlotID());
		DBManager.addNewRecord(Q);
		JOptionPane.showMessageDialog(null,"Record Is Updated Successfully .... ");
	}

	static void deleteRecord(ClsTimeSlot temp)
	{
		String Q = "delete from tblTimeSlot  where TimeSlotID="+temp.getTimeSlotID();
		DBManager.addNewRecord(Q);
		JOptionPane.showMessageDialog(null,"Record Is Deleted Successfully .... ");
	}

	static int getTimeSlotIDFromName(String mTimeSlotName)
	{
		String Q = "select TimeSlotID from tblTimeSlot where TimeSlotName='"+mTimeSlotName+"'";
		return(DBManager.getCode(Q));
	}


	static String getTimeSlotNameFromID(int mTimeSlotID)
	{
		String Q = "select TimeSlotName from tblTimeSlot where TimeSlotID="+String.valueOf(mTimeSlotID);
		return(DBManager.getName(Q));
	}


	static int getAllRecordsCount()
	{
		String s="Select Count(*) from tblTimeSlot";
		int Count =DBManager.getAllRecordsCount(s);
		return(Count);
	}


	static String[] getAllTimeSlotRecords()
	{
		String Q="Select TimeSlotName from tblTimeSlot";
		int rec=getAllRecordsCount();
		return(DBManager.getAllRecords(Q,rec));
	}



	static ClsTimeSlot getTimeSlotInformation(int mTimeSlotID)
	{
		ClsTimeSlot temp = new ClsTimeSlot();
		String Q = "select * from tblTimeSlot where TimeSlotID="+String.valueOf(mTimeSlotID);
		String values[]=DBManager.getFullRow(Q,5);
		temp.setTimeSlotID(Integer.parseInt(values[0]));
		temp.setTimeSlotName(values[1]);
		temp.setStartingTime(values[2]);
		temp.setEndingTime(values[3]);
		temp.setTimeSlotDescription(Integer.parseInt(values[4]));
		return(temp);
	}


	static ClsTimeSlot[] getAllTimeSlotInformation()
	{
		int rec=getAllRecordsCount();
		ClsTimeSlot obj[]=new ClsTimeSlot[rec];
		String Query ="select * from tblTimeSlot";
		String values[][]=DBManager.getAllFullRow(Query,rec,5);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsTimeSlot();
			obj[i].setTimeSlotID(Integer.parseInt(values[i][0]));
			obj[i].setTimeSlotName(values[i][1]);
			obj[i].setStartingTime(values[i][2]);
			obj[i].setEndingTime(values[i][3]);
			obj[i].setTimeSlotDescription(Integer.parseInt(values[i][4]));

		}
		return(obj);
	}

    static ClsTimeSlot[] getAllTimeSlotInformation(int mCourseID)
	{
		int rec=getAllRecordsCount();
		ClsTimeSlot obj[]=new ClsTimeSlot[rec];
		String Query ="select * from tblTimeSlot";
		String values[][]=DBManager.getAllFullRow(Query,rec,5);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsTimeSlot();
			obj[i].setTimeSlotID(Integer.parseInt(values[i][0]));
			obj[i].setTimeSlotName(values[i][1]);
			obj[i].setStartingTime(values[i][2]);
			obj[i].setEndingTime(values[i][3]);
			obj[i].setTimeSlotDescription(Integer.parseInt(values[i][4]));

		}
		return(obj);
	}

	public static void main(String args[])
	{
	}

}

