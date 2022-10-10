import java.io.*;
import DBManage.*;
import java.sql.*;
import myUtility.*;
import javax.swing.*;

class DlsBatchSlot
{
	static void addNewRecord(ClsBatchSlot temp)
	{
		String Query = "insert into tblBatchSlot(BatchSlotName,BatchStudents,CourseID)values('"+temp.getBatchSlotName()+"','"+String.valueOf(temp.getBatchStudents())+"' , "+temp.getCourseID()+")";
		DBManager.addNewRecord(Query);
	}

	static void updateRecord(ClsBatchSlot temp)
	{
		String Query = "update tblBatchSlot set BatchSlotName='"+temp.getBatchSlotName()+"' , BatchStudents="+String.valueOf(temp.getBatchStudents())+"' , CourseID = "+temp.getCourseID()+" where BatchSlotID ="+String.valueOf(temp.getBatchSlotID());
		DBManager.addNewRecord(Query);
	}

	static void deleteRecord(ClsBatchSlot temp)
	{
		String Query = "delete from tblBatchSlot  where BatchSlotID="+temp.getBatchSlotID();
		DBManager.addNewRecord(Query);
	}

	static int getBatchSlotIDFromName(String mBatchSlotName)
	{
		String Query = "select BatchSlotID from tblBatchSlot where BatchSlotName='"+mBatchSlotName+"'";
		return(DBManager.getCode(Query));
	}

	static String getBatchSlotNameFromID(int mBatchSlotID)
	{
		String Query = "select BatchSlotName from tblBatchSlot where BatchSlotID="+String.valueOf(mBatchSlotID);
		return(DBManager.getName(Query));
	}


	static int getAllRecordsCount()
	{
		String Query="Select Count(*) from tblBatchSlot";
		int Count =DBManager.getAllRecordsCount(Query);
		return(Count);
	}

	static int getAllRecordsCount(int mCourseID)
	{
		String Query="Select Count(*) from tblBatchSlot   where CourseID="+String.valueOf(mCourseID);
		int Count =DBManager.getAllRecordsCount(Query);
		return(Count);
	}


	static String[] getAllBatchSlotRecords()
	{
		String Query="Select BatchSlotName from tblBatchSlot";
		int rec=getAllRecordsCount();
		return(DBManager.getAllRecords(Query,rec));
	}


	static String[] getAllBatchSlotRecords(int mCourseID)
	{
		String Query="Select BatchSlotName from tblBatchSlot where CourseID="+String.valueOf(mCourseID);
		int rec=getAllRecordsCount(mCourseID);
		return(DBManager.getAllRecords(Query,rec));
	}



	static ClsBatchSlot getBatchSlotInformation(int mBatchSlotID)
	{
		ClsBatchSlot temp = new ClsBatchSlot();
		String Query = "select * from tblBatchSlot where BatchSlotID="+String.valueOf(mBatchSlotID);
		String values[]=DBManager.getFullRow(Query,4);
		temp.setBatchSlotID(Integer.parseInt(values[0]));
		temp.setBatchSlotName(values[1]);
		temp.setBatchStudents(Integer.parseInt(values[2]));
		temp.setCourseID(Integer.parseInt(values[3]));
		return(temp);
	}

	static ClsBatchSlot[] getAllBatchSlotInformation()
	{
		int rec=getAllRecordsCount();
		ClsBatchSlot obj[]=new ClsBatchSlot[rec];
		String Query ="select * from tblBatchSlot";
		String values[][]=DBManager.getAllFullRow(Query,rec,4);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsBatchSlot();
			obj[i].setBatchSlotID(Integer.parseInt(values[i][0]));
			obj[i].setBatchSlotName(values[i][1]);
			obj[i].setBatchStudents(Integer.parseInt(values[i][2]));
			obj[i].setCourseID(Integer.parseInt(values[i][3]));
		}
		return(obj);
	}


	static ClsBatchSlot[] getAllBatchSlotInformation(int mCourseID)
	{
		int rec=getAllRecordsCount(mCourseID);
		ClsBatchSlot obj[]=new ClsBatchSlot[rec];
		String Query ="select * from tblBatchSlot  where CourseID="+String.valueOf(mCourseID);
		String values[][]=DBManager.getAllFullRow(Query,rec,4);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsBatchSlot();
			obj[i].setBatchSlotID(Integer.parseInt(values[i][0]));
			obj[i].setBatchSlotName(values[i][1]);
			obj[i].setBatchStudents(Integer.parseInt(values[i][2]));
			obj[i].setCourseID(Integer.parseInt(values[i][3]));
		}
		return(obj);
	}

	public static void main(String args[])
	{
	}

}

