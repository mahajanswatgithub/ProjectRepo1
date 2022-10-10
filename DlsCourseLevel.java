import java.io.*;
import DBManage.*;
import java.sql.*;
import myUtility.*;
import javax.swing.*;

class DlsCourseLevel
{
	public static ClsCourseLevel getCourseLevelFromCourseID(int mLevelID)
	{
		ClsCourseLevel temp = new ClsCourseLevel();
		String Query = "SELECT tblCourse.CourseID, tblCourse.CourseName,tblLevel.LevelID, tblLevel.LevelName "+
						"FROM tblCourse INNER JOIN tblLevel ON tblCourse.CourseID = tblLevel.CourseID "+
						"WHERE (((tblLevel.LevelID)="+String.valueOf(mLevelID)+"))";

		String values[]=DBManager.getFullRow(Query,4);
		for(String item:values)
		{
			System.out.println(item);
		}
		temp.setCourseID(Integer.parseInt(values[0]));
		temp.setCourseName(values[1]);
		temp.setLevelID(Integer.parseInt(values[2]));
		temp.setLevelName(values[3]);
		return(temp);
	}

	public static void main(String args[])
	{
	}
}

