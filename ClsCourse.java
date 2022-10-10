import java.sql.*;
import javax.swing.*;
class ClsCourse
{
	private int  CourseID ;
	private String CourseName;
    private int  CoursePattern;
    private int  CourseDuration;
    private int  CourseCapacity;
    private int  CourseStartYear;

	void setCourseID(int value)
	{
		CourseID = value;
	}
	int getCourseID()
	{
		return CourseID;
	}

	void setCourseName(String value)
	{
		CourseName = value;
	}
	String getCourseName()
	{
		return CourseName;
	}
	void setCoursePattern(int value)
	{
		CoursePattern = value;
	}
	int getCoursePattern()
	{
		return CoursePattern;
	}
	void setCourseDuration(int value)
	{
		CourseDuration = value;
	}
	int getCourseDuration()
	{
		return CourseDuration;
	}
	void setCourseCapacity(int value)
	{
		CourseCapacity = value;
	}
	int getCourseCapacity()
	{
		return CourseCapacity;
	}
	void setCourseStartYear(int value)
	{
		CourseStartYear = value;
	}
	int getCourseStartYear()
	{
		return CourseStartYear;
	}

	static void addNewRecord(ClsCourse temp)
	{
		DlsCourse.addNewRecord(temp);
	}

	static void updateRecord(ClsCourse temp)
	{
		DlsCourse.updateRecord(temp);
	}

	static void deleteRecord(ClsCourse temp)
	{
		DlsCourse.deleteRecord(temp);
	}

	static int getCourseIDFromName(String mCourseName)
	{
		return(DlsCourse.getCourseIDFromName(mCourseName));
	}
	static String getCourseNameFromID(int mCourseID)
	{
		return(DlsCourse.getCourseNameFromID(mCourseID));
	}
	static ClsCourse getCourseInformation(int mCourseID)
	{
		return(DlsCourse.getCourseInformation(mCourseID));
	}

	static void showCourse(ClsCourse  temp)
	{
		System.out.println("CourseID                : ..........    "+temp.getCourseID());
		System.out.println("CourseName              : ..........    "+temp.getCourseName());
		System.out.println("CoursePattern           : ..........    "+temp.getCoursePattern());
		System.out.println("CourseDuration          : ..........    "+temp.getCourseDuration());
		System.out.println("CourseCapacity          : ..........    "+temp.getCourseCapacity());
		System.out.println("CourseStartYear         : ..........    "+temp.getCourseStartYear());

	}
	static ClsCourse[] getAllCourseInformation()
	{
		return(DlsCourse.getAllCourseInformation());
	}
	static int getAllRecordsCount()
	{
		return(DlsCourse.getAllRecordsCount());

	}

	static String[] getAllCourseRecords()
	{
		return(DlsCourse.getAllCourseRecords());
	}

	static void addCourseRecords(JComboBox cmbProcess)
	{
		String Query = "select CourseName from tblCourse order by CourseName";
		String data[]=getAllCourseRecords();
		cmbProcess.removeAllItems();
		cmbProcess.addItem("Select Course  ...");
		for(String item : data)
		{
			cmbProcess.addItem(item);
		}
	}

	public static void main(String args[])
	{
		System.out.println(getAllRecordsCount());

		ClsCourse A = new ClsCourse();
		A.setCourseID(1);
		A.setCourseName("JHJ");
		A.setCoursePattern(21);
		A.setCourseDuration(21);
		A.setCourseCapacity(12);
		A.setCourseStartYear(23);
		ClsCourse.deleteRecord(A);
	}
}