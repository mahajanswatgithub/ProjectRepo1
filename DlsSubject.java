import java.io.*;
import DBManage.*;
import java.sql.*;
import myUtility.*;
import javax.swing.*;

class DlsSubject
{
	static void addNewRecord(ClsSubject temp)
	{
		String Query = "insert into tblSubject(SubjectName,Abbreviation,SubjectPaperCode,SubjectLearning,CourseID,SemisterID)values('"+
						temp.getSubjectName()+"','"+
						temp.getAbbreviation()+"',"+
						String.valueOf(temp.getSubjectPaperCode())+",'"+
						temp.getSubjectLearning()+"',"+
						String.valueOf(temp.getCourseID())+","+
						String.valueOf(temp.getSemisterID())+")";
		System.out.println(Query);
		DBManager.addNewRecord(Query);
	}

	static void updateRecord(ClsSubject temp)
	{
		String Query = "update tblSubject set SubjectName='"+temp.getSubjectName()+
						"', Abbreviation='"+temp.getAbbreviation()+
						"', SubjectPaperCode = "+String.valueOf(temp.getSubjectPaperCode())+
						", SubjectLearning='"+temp.getSubjectLearning()+
						"', CourseID = "+String.valueOf(temp.getCourseID())+
						", SemisterID = "+String.valueOf(temp.getSemisterID())+
						" where SubjectID ="+String.valueOf(temp.getSubjectID());

		DBManager.addNewRecord(Query);
	}

	static void deleteRecord(ClsSubject temp)
	{
		String Query = "delete * from tblSubject  where SubjectID="+temp.getSubjectID();
		DBManager.addNewRecord(Query);
	}

	static int getSubjectIDFromName(String mSubjectName)
	{
		String Query = "select SubjectID from tblSubject where SubjectName='"+mSubjectName+"'";
		return(DBManager.getCode(Query));
	}

	static String getSubjectNameFromID(int mSubjectID)
	{
		String Query = "select SubjectName from tblSubject where SubjectID="+String.valueOf(mSubjectID);
		return(DBManager.getName(Query));
	}


	static int getAllRecordsCount()
	{
		String Query="Select Count(*) from tblSubject";
		int Count =DBManager.getAllRecordsCount(Query);
		return(Count);
	}

	static int getAllRecordsCount(int mCourseID)
	{
		String Query="Select Count(*) from tblSubject   where CourseID="+String.valueOf(mCourseID);
		int Count =DBManager.getAllRecordsCount(Query);
		return(Count);
	}

    static int getAllRecordsCount(int mCourseID,int mSemisterID)
	{
		String Query="Select Count(*) from tblSubject   where CourseID="+String.valueOf(mCourseID)+"and SemisterID="+String.valueOf(mSemisterID);
		int Count =DBManager.getAllRecordsCount(Query);
		return(Count);
	}


	static String[] getAllSubjectRecords()
	{
		String Query="Select SubjectName from tblSubject";
		int rec=getAllRecordsCount();
		return(DBManager.getAllRecords(Query,rec));
	}

	static String[] getAllSubjectRecords(int mCourseID)
	{
		String Query="Select SubjectName from tblSubject where CourseID="+String.valueOf(mCourseID);
		int rec=getAllRecordsCount(mCourseID);
		return(DBManager.getAllRecords(Query,rec));
	}

    static String[] getAllSubjectRecords(int mCourseID,int mSemisterID)
	{
		String Query="Select SubjectName from tblSubject where CourseID="+String.valueOf(mCourseID)+"and SemisterID="+String.valueOf(mSemisterID);
		int rec=getAllRecordsCount(mCourseID,mSemisterID);
		return(DBManager.getAllRecords(Query,rec));
	}

	static ClsSubject getSubjectInformation(int mSubjectID)
	{
		ClsSubject temp = new ClsSubject();
		String Query = "select * from tblSubject where SubjectID="+String.valueOf(mSubjectID);
		String values[]=DBManager.getFullRow(Query,7);
		temp.setSubjectID(Integer.parseInt(values[0]));
		temp.setSubjectName(values[1]);
		temp.setAbbreviation(values[2]);
		temp.setSubjectPaperCode(Integer.parseInt(values[3]));
		temp.setSubjectLearning(values[4]);
		temp.setCourseID(Integer.parseInt(values[5]));
		temp.setSemisterID(Integer.parseInt(values[6]));
		return(temp);
	}

	static ClsSubject[] getAllSubjectInformation()
	{
		int rec=getAllRecordsCount();
		ClsSubject obj[]=new ClsSubject[rec];
		String Query ="select * from tblSubject";
		String values[][]=DBManager.getAllFullRow(Query,rec,7);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsSubject();
			obj[i].setSubjectID(Integer.parseInt(values[i][0]));
			obj[i].setSubjectName(values[i][1]);
			obj[i].setAbbreviation(values[i][2]);
			obj[i].setSubjectPaperCode(Integer.parseInt(values[i][3]));
			obj[i].setSubjectLearning(values[i][4]);
			obj[i].setCourseID(Integer.parseInt(values[i][5]));
			obj[i].setSemisterID(Integer.parseInt(values[i][6]));
		}
		return(obj);
	}


	static ClsSubject[] getAllSubjectInformation(int mCourseID)
	{
		int rec=getAllRecordsCount(mCourseID);
		ClsSubject obj[]=new ClsSubject[rec];
		String Query ="select * from tblSubject  where CourseID="+String.valueOf(mCourseID);
		String values[][]=DBManager.getAllFullRow(Query,rec,7);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsSubject();
			obj[i].setSubjectID(Integer.parseInt(values[i][0]));
			obj[i].setSubjectName(values[i][1]);
			obj[i].setAbbreviation(values[i][2]);
			obj[i].setSubjectPaperCode(Integer.parseInt(values[i][3]));
			obj[i].setSubjectLearning(values[i][4]);
			obj[i].setCourseID(Integer.parseInt(values[i][5]));
			obj[i].setSemisterID(Integer.parseInt(values[i][6]));
		}
		return(obj);
	}
    static ClsSubject[] getAllSubjectInformation(int mCourseID,int mSemisterID)
	{
		int rec=getAllRecordsCount(mCourseID,mSemisterID);
		ClsSubject obj[]=new ClsSubject[rec];
		String Query ="select * from tblSubject  where CourseID="+String.valueOf(mCourseID)+"and SemisterID="+String.valueOf(mSemisterID);
		String values[][]=DBManager.getAllFullRow(Query,rec,7);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsSubject();
			obj[i].setSubjectID(Integer.parseInt(values[i][0]));
			obj[i].setSubjectName(values[i][1]);
			obj[i].setAbbreviation(values[i][2]);
			obj[i].setSubjectPaperCode(Integer.parseInt(values[i][3]));
			obj[i].setSubjectLearning(values[i][4]);
			obj[i].setCourseID(Integer.parseInt(values[i][5]));
			obj[i].setSemisterID(Integer.parseInt(values[i][6]));
		}
		return(obj);
	}
	public static void main(String args[])
	{
	}

}

