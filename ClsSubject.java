import java.sql.*;
import javax.swing.*;

class ClsSubject
{
	private int  SubjectID ;
	private String SubjectName;
	private String Abbreviation;
	private int SubjectPaperCode;
	private String SubjectLearning;
	private int CourseID;
	private int SemisterID;

	void setSubjectID(int value)
	{
		SubjectID = value;
	}
	int getSubjectID()
	{
		return SubjectID;
	}

	void setSubjectName(String value)
	{
		SubjectName = value;
	}
	String getSubjectName()
	{
		return SubjectName;
	}

	void setAbbreviation(String value)
	{
		Abbreviation = value;
	}
	String getAbbreviation()
	{
		return Abbreviation;
	}

	void setSubjectPaperCode(int value)
	{
		SubjectPaperCode = value;
	}
	int getSubjectPaperCode()
	{
		return SubjectPaperCode;
	}

	void setSubjectLearning(String value)
	{
		SubjectLearning = value;
	}
	String getSubjectLearning()
	{
		return SubjectLearning;
	}

	void setCourseID(int value)
	{
		CourseID = value;
	}
	int getCourseID()
	{
		return CourseID;
	}

	void setSemisterID(int value)
	{
		SemisterID = value;
	}
	int getSemisterID()
	{
		return SemisterID;
	}

	static void addNewRecord(ClsSubject temp)
	{
		DlsSubject.addNewRecord(temp);
	}

	static void updateRecord(ClsSubject temp)
	{
		DlsSubject.updateRecord(temp);
	}

	static void deleteRecord(ClsSubject temp)
	{
		DlsSubject.deleteRecord(temp);
	}

	static int getSubjectIDFromName(String mSubjectName)
	{
		return(DlsSubject.getSubjectIDFromName(mSubjectName));
	}

	static String getSubjectNameFromID(int mSubjectID)
	{
		return(DlsSubject.getSubjectNameFromID(mSubjectID));
	}

	static int getAllRecordsCount()
	{
		return(DlsSubject.getAllRecordsCount());
	}

	static int getAllRecordsCount(int mCourseID)
	{
		return(DlsSubject.getAllRecordsCount(mCourseID));
	}
    static int getAllRecordsCount(int mCourseID,int mSemisterID)
	{
		return(DlsSubject.getAllRecordsCount(mCourseID,mSemisterID));
	}
	static String[] getAllSubjectRecords()
	{
		return(DlsSubject.getAllSubjectRecords());
	}

	static String[] getAllSubjectRecords(int mCourseID)
	{
		return(DlsSubject.getAllSubjectRecords(mCourseID));
	}
    static String[] getAllSubjectRecords(int mCourseID,int mSemisterID)
	{
		return(DlsSubject.getAllSubjectRecords(mCourseID,mSemisterID));
	}
	static ClsSubject getSubjectInformation(int mSubjectID)
	{
		return(DlsSubject.getSubjectInformation(mSubjectID));
	}

	static ClsSubject[] getAllSubjectInformation()
	{
		return(DlsSubject.getAllSubjectInformation());
	}


	static ClsSubject[] getAllSubjectInformation(int mSubjectID)
	{
		return(DlsSubject.getAllSubjectInformation(mSubjectID));
	}





	static void showSubject(ClsSubject temp)
	{
		System.out.println("Subject ID             : ..........    "+temp.getSubjectID());
		System.out.println("Subject Name           : ..........    "+temp.getSubjectName());
		System.out.println("Abbreviation           : ..........    "+temp.getAbbreviation());
		System.out.println("Subject Paper Code     : ..........    "+temp.getSubjectPaperCode());
		System.out.println("Subject Learning       : ..........    "+temp.getSubjectLearning());
		System.out.println("Course Id           : ..........    "+temp.getCourseID());
		System.out.println("Semister Id           : ..........    "+temp.getSemisterID());

	}

	static void addSubjectRecords(JComboBox cmbProcess,int mCourseID)
	{
		String Query = "select SubjectName from tblSubject where CourseID ="+String.valueOf(mCourseID);
		String data[]=getAllSubjectRecords(mCourseID);
		cmbProcess.removeAllItems();
		cmbProcess.addItem("Select Subject ...");
		for(String item : data)
		{
			cmbProcess.addItem(item);
		}
	}

    static void addSubjectRecords(JComboBox cmbProcess,int mCourseID,int mSemisterID)
	{
		String Query = "select SubjectName from tblSubject where CourseID ="+String.valueOf(mCourseID) +" and SemisterID = "+String.valueOf(mSemisterID);
		String data[]=getAllSubjectRecords(mCourseID,mSemisterID);
		cmbProcess.removeAllItems();
		cmbProcess.addItem("Select Subject ...");
		for(String item : data)
		{
			cmbProcess.addItem(item);
		}
	}
	static void addSubjectRecords(JComboBox cmbProcess)
	{
		String Query = "select SubjectName from tblSubject order by SubjectName";
		String data[]=getAllSubjectRecords();
		cmbProcess.removeAllItems();
		cmbProcess.addItem("Select Subject ...");
		for(String item : data)
		{
			cmbProcess.addItem(item);
		}
	}


	public static void main(String args[])
	{
		//ClsSubject.addSubjectRecords(cmbProcess,10);
		ClsSubject temp = new ClsSubject();

		temp.setSubjectID(3);
		temp.setSubjectName("English");
		temp.setAbbreviation("Language");
		temp.setSubjectPaperCode(301);
		temp.setSubjectLearning("English");
		temp.setCourseID(1);
		temp.setSemisterID(2);

		//deleteRecord(temp);
		getSubjectInformation(1);
	}
}
