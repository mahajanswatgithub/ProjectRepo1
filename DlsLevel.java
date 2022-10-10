import java.io.*;
import DBManage.*;
import java.sql.*;
import myUtility.*;
import javax.swing.*;

class DlsLevel
{
	static void addNewRecord(ClsLevel temp)
	{
		String Q = "insert into tblLevel(LevelName,CourseID)values('"+temp.getLevelName()+"',"+String.valueOf(temp.getCourseID())+")";
		DBManager.addNewRecord(Q);
		JOptionPane.showMessageDialog(null,"Record Is Inserted Successfully .... ");
	}


	static void updateRecord(ClsLevel temp)
	{
		String Q = "update tblLevel set LevelName='"+temp.getLevelName()+"',CourseID="+String.valueOf(temp.getCourseID())+" where LevelID ="+String.valueOf(temp.getLevelID());
		DBManager.addNewRecord(Q);
		JOptionPane.showMessageDialog(null,"Record Is Updated Successfully .... ");
	}

	static void deleteRecord(ClsLevel temp)
	{
		String Q = "delete from tblLevel  where LevelID="+temp.getLevelID();
		DBManager.addNewRecord(Q);
		JOptionPane.showMessageDialog(null,"Record Is Deleted Successfully .... ");
	}

	static int getLevelIDFromName(String mLevelName)
	{
		String Q = "select LevelID from tblLevel where LevelName='"+mLevelName+"'";
		return(DBManager.getCode(Q));
	}


	static String getLevelNameFromID(int mLevelID)
	{
		String Q = "select LevelName from tblLevel where LevelID="+String.valueOf(mLevelID);
		return(DBManager.getName(Q));
	}


	static int getAllRecordsCount()
	{
		String s="Select Count(*) from tblLevel";
		int Count =DBManager.getAllRecordsCount(s);
		return(Count);
	}

    static int getAllRecordsCount(int mCourseID)
	{
		String s="Select Count(*) from tblLevel where CourseID ="+String.valueOf(mCourseID);
		int Count =DBManager.getAllRecordsCount(s);
		return(Count);
	}


	static String[] getAllLevelRecords()
	{
		String Q="Select LevelName from tblLevel";
		int rec=getAllRecordsCount();
		return(DBManager.getAllRecords(Q,rec));
	}
    static String[] getAllLevelRecords(int mCourseID)
	{
		String Q="Select LevelName from tblLevel where CourseID ="+String.valueOf(mCourseID);
		int rec=getAllRecordsCount(mCourseID);
		return(DBManager.getAllRecords(Q,rec));
	}

	static ClsLevel getLevelInformation(int mLevelID)
	{
		ClsLevel temp = new ClsLevel();
		String Q = "select * from tblLevel where LevelID="+String.valueOf(mLevelID);
		String values[]=DBManager.getFullRow(Q,3);
		temp.setLevelID(Integer.parseInt(values[0]));
		temp.setLevelName(values[1]);
		temp.setCourseID(Integer.parseInt(values[2]));
		return(temp);
	}


	static ClsLevel[] getAllLevelInformation()
	{
		int rec=getAllRecordsCount();
		ClsLevel obj[]=new ClsLevel[rec];
		String Query ="select * from tblLevel";
		String values[][]=DBManager.getAllFullRow(Query,rec,3);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsLevel();
			obj[i].setLevelID(Integer.parseInt(values[i][0]));
			obj[i].setLevelName(values[i][1]);
			obj[i].setCourseID(Integer.parseInt(values[i][2]));

		}
		return(obj);
	}

   static ClsLevel[] getAllLevelInformation(int mCourseID)
	{
		int rec=getAllRecordsCount(mCourseID);
		ClsLevel obj[]=new ClsLevel[rec];
		String Query ="select * from tblLevel where CourseID="+String.valueOf(mCourseID);
		String values[][]=DBManager.getAllFullRow(Query,rec,3);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsLevel();
			obj[i].setLevelID(Integer.parseInt(values[i][0]));
			obj[i].setLevelName(values[i][1]);
			obj[i].setCourseID(Integer.parseInt(values[i][2]));

		}
		return(obj);
	}

	public static void main(String args[])
	{
	}

}

