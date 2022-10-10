import java.sql.*;
import javax.swing.*;

class ClsCourseLevel
{
	int CourseID;
	String CourseName;

	int LevelID;
	String LevelName;


	void setCourseID(int value)
	{
		CourseID=value;
	}
	int getCourseID()
	{
		return(CourseID);
	}

	void setCourseName(String value)
	{
		CourseName=value;
	}
	String getCourseName()
	{
		return(CourseName);
	}


	void setLevelID(int value)
	{
		LevelID=value;
	}
	int getLevelID()
	{
		return(LevelID);
	}

	void setLevelName(String value)
	{
		LevelName=value;
	}
	String getLevelName()
	{
		return(LevelName);
	}

	public static ClsCourseLevel getCourseLevelFromCourseID(int mLevelID)
	{
		return(DlsCourseLevel.getCourseLevelFromCourseID(mLevelID));
	}

	static void showCourseLevel(ClsCourseLevel temp)
	{
		System.out.println("Course ID             : ..........    "+temp.getCourseID());
		System.out.println("Course Name           : ..........    "+temp.getCourseName());

		System.out.println("Level ID             : ..........    "+temp.getLevelID());
		System.out.println("Level Name           : ..........    "+temp.getLevelName());
	}

	public static void main(String args[])
	{
		ClsCourseLevel temp = ClsCourseLevel.getCourseLevelFromCourseID(9);
		ClsCourseLevel.showCourseLevel(temp);
	}
}

