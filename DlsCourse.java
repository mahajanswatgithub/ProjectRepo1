import java.io.*;
import DBManage.*;
import java.sql.*;
import myUtility.*;
import javax.swing.*;

class DlsCourse
{
	static void addNewRecord(ClsCourse temp)
	{
		String sq = "'";
		String com =",";

		String Q = "insert into tblCourse"+"(CourseName,CoursePattern,CourseDuration,CourseCapacity,CourseStartYear)"+
		"values("+sq+temp.getCourseName()+sq+com+
		         String.valueOf(temp.getCoursePattern())+com+
		         String.valueOf(temp.getCourseDuration())+com+
		         String.valueOf(temp.getCourseCapacity())+com+
		         String.valueOf(temp.getCourseStartYear())+
		         ")";
		DBManager.addNewRecord(Q);
		JOptionPane.showMessageDialog(null,"Record Is Inserted Successfully .... ");
	}

	static void updateRecord(ClsCourse   temp)
	{
		String sq="'";
		String com=",";
		String Q = "update tblCourse set "+
		"CourseName="+sq+temp.getCourseName()+sq+com+
		"CoursePattern="+String.valueOf(temp.getCoursePattern())+com+
		"CourseDuration="+String.valueOf(temp.getCourseDuration())+com+
		"CourseCapacity="+String.valueOf(temp.getCourseCapacity())+com+
		"CourseStartYear="+String.valueOf(temp.getCourseStartYear())+
		"  where CourseID ="+String.valueOf(temp.getCourseID());
		DBManager.addNewRecord(Q);
		JOptionPane.showMessageDialog(null,"Record Is Updated Successfully .... ");
	}

	static void deleteRecord(ClsCourse temp)
	{
		String Q = "delete from tblCourse  where CourseID="+temp.getCourseID();
		DBManager.addNewRecord(Q);
		JOptionPane.showMessageDialog(null,"Record Is Deleted Successfully .... ");
	}

	static int getCourseIDFromName(String mCourseName)
	{
		String Q = "select CourseID from tblCourse  where CourseName='"+mCourseName+"'";
		return(DBManager.getCode(Q));
	}


	static String getCourseNameFromID(int mCourseID)
	{
		String Q = "select CourseName from tblCourse  where CourseID="+String.valueOf(mCourseID);
		return(DBManager.getName(Q));
	}


	static int getAllRecordsCount()
	{
		String s="Select Count(*) from tblCourse  ";
		int Count =DBManager.getAllRecordsCount(s);
		return(Count);
	}


	static String[] getAllCourseRecords()
	{
		String Q="Select CourseName from tblCourse  ";
		int rec=getAllRecordsCount();
		return(DBManager.getAllRecords(Q,rec));
	}



	static ClsCourse getCourseInformation(int mCourseID)
	{
		ClsCourse   temp = new ClsCourse  ();
		String Q = "select * from tblCourse  where CourseID="+String.valueOf(mCourseID);
		String values[]=DBManager.getFullRow(Q,6);
		temp.setCourseID(Integer.parseInt(values[0]));
		temp.setCourseName(values[1]);
		temp.setCoursePattern(Integer.parseInt(values[2]));
		temp.setCourseDuration(Integer.parseInt(values[3]));
		temp.setCourseCapacity(Integer.parseInt(values[4]));
		temp.setCourseStartYear(Integer.parseInt(values[5]));

		return(temp);
	}

/*private int  CourseID ;
	private String CourseName;
    private int  CoursePattern;
    private int  CourseDuration;
    private int  CourseCapacity;
    private int  CourseStartYear;*/

	static ClsCourse[] getAllCourseInformation()
	{
		int rec=getAllRecordsCount();
		ClsCourse obj[]=new ClsCourse[rec];
		String Query ="select * from tblCourse  ";
		String values[][]=DBManager.getAllFullRow(Query,rec,6);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsCourse  ();
			obj[i].setCourseID(Integer.parseInt(values[i][0]));
			obj[i].setCourseName(values[i][1]);
            obj[i].setCoursePattern(Integer.parseInt(values[i][2]));
			obj[i].setCourseDuration(Integer.parseInt(values[i][3]));
			obj[i].setCourseCapacity(Integer.parseInt(values[i][4]));
			obj[i].setCourseStartYear(Integer.parseInt(values[i][5]));

		}
		return(obj);
	}
	public static void main(String args[])
	{
	}

}

