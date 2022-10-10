import java.sql.*;
import DBManage.*;

class DlsStaff
{
	static void addNewRecord(ClsStaff temp)
	{
		 String sq = "'";
		 String com = ",";

		String Q = "insert into tblStaff "+"(StaffName,StaffWeeklyLoad,StaffEducation,LevelID)"+
		"values("+sq+temp.getStaffName()+sq+com+
		             String.valueOf(temp.getStaffWeeklyLoad())+com+
		             sq+temp.getStaffEducation()+sq+com+
		             String.valueOf(temp.getLevelID())+")";
			DBManager.addNewRecord(Q);
			System.out.println(Q);
	}
	static void updateRecord(ClsStaff temp)
	{
		 String sq = "'";
		 String com = ",";

		String Q = "update tblStaff set "+
		            "StaffName="+sq+temp.getStaffName()+sq+com+
		            "StaffWeeklyLoad="+String.valueOf(temp.getStaffWeeklyLoad())+com+
		            "StaffEducation="+sq+temp.getStaffEducation()+sq+com+
		            "CourseID="+String.valueOf(temp.getLevelID())+
		            " where StaffID ="+String.valueOf(temp.getStaffID());
		DBManager.addNewRecord(Q);
	}

	static void deleteRecord(ClsStaff temp)
	{
		String Q = "delete from tblStaff  where StaffID="+temp.getStaffID();
		DBManager.addNewRecord(Q);
	}

	static int getStaffIDFromName(String mStaffName)
	{
		String Q = "select StaffID from tblStaff where StaffName='"+mStaffName+"'";
		return(DBManager.getCode(Q));
	}

	static String getStaffNameFromID(int mStaffID)
	{
		String Q = "select StaffName from tblStaff where StaffID="+String.valueOf(mStaffID);
		return(DBManager.getName(Q));
	}

    static int getAllRecordsCount()
	{
		String s="Select Count(*) from tblStaff";
		int Count =DBManager.getAllRecordsCount(s);
		return(Count);
	}
    static int getAllRecordsCount(int mLevelID)
	{
		String s="Select Count(*) from tblStaff where LevelID = "+String.valueOf(mLevelID);
		int Count =DBManager.getAllRecordsCount(s);
		return(Count);
	}

    static String[] getAllStaffRecords()
	{
		String x="Select StaffName from tblStaff";
		int rec=getAllRecordsCount();
		return(DBManager.getAllRecords(x,rec));
	}

    static String[] getAllStaffRecords(int mLevelID)
	{
		String x="Select StaffName from tblStaff where LevelID = "+String.valueOf(mLevelID);
		int rec=getAllRecordsCount(mLevelID);
		return(DBManager.getAllRecords(x,rec));
	}
	static ClsStaff getStaffInformation(int mStaffID)
	{
		ClsStaff temp = new ClsStaff();
		String Q = "select * from tblStaff where StaffID="+String.valueOf(mStaffID);
		String values[] = DBManager.getFullRow(Q,5);
		temp.setStaffID(Integer.parseInt(values[0]));
		temp.setStaffName(values[1]);
		temp.setStaffWeeklyLoad(Integer.parseInt(values[2]));
		temp.setStaffEducation(values[3]);
		temp.setLevelID(Integer.parseInt(values[4]));
		return(temp);
	}

	static ClsStaff[] getAllStaffInformation()
	{
		int rec=getAllRecordsCount();
		ClsStaff obj[]=new ClsStaff[rec];
		String Query ="select * from tblStaff";
		String values[][]=DBManager.getAllFullRow(Query,rec,5);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsStaff();
			obj[i].setStaffID(Integer.parseInt(values[i][0]));
			obj[i].setStaffName(values[i][1]);
			obj[i].setStaffWeeklyLoad(Integer.parseInt(values[i][2]));
			obj[i].setStaffEducation(values[i][3]);
			obj[i].setLevelID(Integer.parseInt(values[i][4]));

		}
		return(obj);
	}

    static ClsStaff[] getAllStaffInformation(int mLevelID)
	{
		int rec=getAllRecordsCount(mLevelID);
		ClsStaff obj[]=new ClsStaff[rec];
		String Query ="select * from tblStaff where LevelID = "+String.valueOf(mLevelID);
		String values[][]=DBManager.getAllFullRow(Query,rec,5);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsStaff();
			obj[i].setStaffID(Integer.parseInt(values[i][0]));
			obj[i].setStaffName(values[i][1]);
			obj[i].setStaffWeeklyLoad(Integer.parseInt(values[i][2]));
			obj[i].setStaffEducation(values[i][3]);
			obj[i].setLevelID(Integer.parseInt(values[i][4]));

		}
		return(obj);
	}

	public static void main(String args[])
	{
	}

}

