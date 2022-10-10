import java.io.*;
import DBManage.*;
import java.sql.*;
import myUtility.*;
import javax.swing.*;

class DlsWorkAllocation
{
	static void addNewRecord(ClsWorkAllocation temp)
	{
		String sq = "'";
		String com =",";

		String Q = "insert into tblWorkAllocation"+"(TimeSlotID,DayID,SubjectTypeID,FloorID,RoomID,CourseID,StaffID,SemisterID,SubjectID)"+
		"values("+String.valueOf(temp.getTimeSlotID())+com+
		         String.valueOf(temp.getDayID())+com+
		         String.valueOf(temp.getSubjectTypeID())+com+
		         String.valueOf(temp.getFloorID())+com+
		         String.valueOf(temp.getRoomID())+com+
		         String.valueOf(temp.getCourseID())+com+
		         String.valueOf(temp.getStaffID())+com+
		         String.valueOf(temp.getSemisterID())+com+
		         String.valueOf(temp.getSubjectID())+
		         ")";
		DBManager.addNewRecord(Q);
		System.out.println(Q);
		JOptionPane.showMessageDialog(null,"Record Is Inserted Successfully .... ");
	}

	static void updateRecord(ClsWorkAllocation   temp)
	{
		String sq="'";
		String com=",";

		String Q = "update tblWorkAllocation  set "+
		"TimeSlotID="+String.valueOf(temp.getTimeSlotID())+com+
		"DayID="+String.valueOf(temp.getDayID())+com+
		"SubjectTypeID="+String.valueOf(temp.getSubjectTypeID())+com+
		"FloorID="+String.valueOf(temp.getFloorID())+
		"RoomID="+String.valueOf(temp.getRoomID())+com+
		"CourseID="+String.valueOf(temp.getCourseID())+com+
		"StaffID="+String.valueOf(temp.getStaffID())+com+
		"SemisterID="+String.valueOf(temp.getSemisterID())+com+
		"SubjectID="+String.valueOf(temp.getSubjectID())+com+
		"  where WorkAllocationID ="+String.valueOf(temp.getWorkAllocationID());
		DBManager.addNewRecord(Q);
		JOptionPane.showMessageDialog(null,"Record Is Updated Successfully .... ");
	}

	static void deleteRecord(ClsWorkAllocation temp)
	{
		String Q = "delete from tblWorkAllocation  where WorkAllocationID="+temp.getWorkAllocationID();
		DBManager.addNewRecord(Q);
		JOptionPane.showMessageDialog(null,"Record Is Deleted Successfully .... ");
	}

	/*static int getCourseIDFromName(String mCourseName)
	{
		String Q = "select CourseID from tblCourse  where CourseName='"+mCourseName+"'";
		return(DBManager.getCode(Q));
	}


	static String getCourseNameFromID(int mCourseID)
	{
		String Q = "select CourseName from tblCourse  where CourseID="+String.valueOf(mCourseID);
		return(DBManager.getName(Q));
	}*/




/*	static String[] getAllCourseRecords()
	{
		String Q="Select CourseName from tblWorkAllocation  ";
		int rec=getAllRecordsCount();
		return(DBManager.getAllRecords(Q,rec));
	}*/



	static ClsWorkAllocation getWorkAllocationInformation(int mWorkAllocationID)
	{
		ClsWorkAllocation   temp = new ClsWorkAllocation  ();
		String Q = "select * from tblWorkAllocation where WorkAllocationID="+String.valueOf(mWorkAllocationID);
		String values[]=DBManager.getFullRow(Q,10);
		temp.setWorkAllocationID(Integer.parseInt(values[0]));
		temp.setTimeSlotID(Integer.parseInt(values[1]));
		temp.setDayID(Integer.parseInt(values[2]));
		temp.setSubjectTypeID(Integer.parseInt(values[3]));
		temp.setFloorID(Integer.parseInt(values[4]));
		temp.setRoomID(Integer.parseInt(values[5]));
		temp.setCourseID(Integer.parseInt(values[6]));
		temp.setStaffID(Integer.parseInt(values[7]));
		temp.setSemisterID(Integer.parseInt(values[8]));
		temp.setSubjectID(Integer.parseInt(values[9]));

		return(temp);
	}

/*private int  CourseID ;
	private String CourseName;
    private int  CoursePattern;
    private int  CourseDuration;
    private int  CourseCapacity;
    private int  CourseStartYear;*/

	static int getAllRecordsCount()
	{
		String s="Select Count(*) from tblWorkAllocation  ";
		int Count =DBManager.getAllRecordsCount(s);
		return(Count);
	}


	static ClsWorkAllocation[] getAllWorkAllocationInformation()
	{
		int rec=getAllRecordsCount();
		ClsWorkAllocation obj[]=new ClsWorkAllocation[rec];
		String Query ="select * from tblWorkAllocation";
		String values[][]=DBManager.getAllFullRow(Query,rec,10);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsWorkAllocation();
			obj[i].setWorkAllocationID(Integer.parseInt(values[i][0]));
            obj[i].setTimeSlotID(Integer.parseInt(values[i][1]));
			obj[i].setDayID(Integer.parseInt(values[i][2]));
			obj[i].setSubjectTypeID(Integer.parseInt(values[i][3]));
			obj[i].setFloorID(Integer.parseInt(values[i][4]));
			obj[i].setRoomID(Integer.parseInt(values[i][5]));
			obj[i].setCourseID(Integer.parseInt(values[i][6]));
			obj[i].setStaffID(Integer.parseInt(values[i][7]));
			obj[i].setSemisterID(Integer.parseInt(values[i][8]));
			obj[i].setSubjectID(Integer.parseInt(values[i][9]));

		}
		return(obj);
	}

	static int getAllRecordsCount(int mCourseID)
	{
		String s="Select Count(*) from tblWorkAllocation  where CourseID="+String.valueOf(mCourseID);
		int Count =DBManager.getAllRecordsCount(s);
		return(Count);
	}


	static ClsWorkAllocation[] getAllWorkAllocationInformation(int mCourseID)
	{
		int rec=getAllRecordsCount(mCourseID);
		ClsWorkAllocation obj[]=new ClsWorkAllocation[rec];
		String Query ="select * from tblWorkAllocation where CourseID="+String.valueOf(mCourseID);
		String values[][]=DBManager.getAllFullRow(Query,rec,10);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsWorkAllocation();
			obj[i].setWorkAllocationID(Integer.parseInt(values[i][0]));
            obj[i].setTimeSlotID(Integer.parseInt(values[i][1]));
			obj[i].setDayID(Integer.parseInt(values[i][2]));
			obj[i].setSubjectTypeID(Integer.parseInt(values[i][3]));
			obj[i].setFloorID(Integer.parseInt(values[i][4]));
			obj[i].setRoomID(Integer.parseInt(values[i][5]));
			obj[i].setCourseID(Integer.parseInt(values[i][6]));
			obj[i].setStaffID(Integer.parseInt(values[i][7]));
			obj[i].setSemisterID(Integer.parseInt(values[i][8]));
			obj[i].setSubjectID(Integer.parseInt(values[i][9]));

		}
		return(obj);
	}


	static int getAllRecordsCount(int mCourseID,int mSemisterID)
	{
		String s="Select Count(*) from tblWorkAllocation  where CourseID="+String.valueOf(mCourseID)+
															 " and SemisterID="+String.valueOf(mSemisterID);
		int Count =DBManager.getAllRecordsCount(s);
		return(Count);
	}


	static ClsWorkAllocation[] getAllWorkAllocationInformation(int mCourseID,int mSemisterID)
	{
		int rec=getAllRecordsCount(mCourseID,mSemisterID);
		ClsWorkAllocation obj[]=new ClsWorkAllocation[rec];
		String Query ="select * from tblWorkAllocation where CourseID="+String.valueOf(mCourseID)+
															 " and SemisterID="+String.valueOf(mSemisterID);
		String values[][]=DBManager.getAllFullRow(Query,rec,10);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsWorkAllocation();
			obj[i].setWorkAllocationID(Integer.parseInt(values[i][0]));
            obj[i].setTimeSlotID(Integer.parseInt(values[i][1]));
			obj[i].setDayID(Integer.parseInt(values[i][2]));
			obj[i].setSubjectTypeID(Integer.parseInt(values[i][3]));
			obj[i].setFloorID(Integer.parseInt(values[i][4]));
			obj[i].setRoomID(Integer.parseInt(values[i][5]));
			obj[i].setCourseID(Integer.parseInt(values[i][6]));
			obj[i].setStaffID(Integer.parseInt(values[i][7]));
			obj[i].setSemisterID(Integer.parseInt(values[i][8]));
			obj[i].setSubjectID(Integer.parseInt(values[i][9]));

		}
		return(obj);
	}

	static int getAllRecordsCount(int mCourseID,int mSemisterID,int mSubjectID)
	{
		String s="Select Count(*) from tblWorkAllocation  where CourseID="+String.valueOf(mCourseID)+
															 " and SemisterID="+String.valueOf(mSemisterID)+
															 " and SubjectID="+String.valueOf(mSubjectID);
		int Count =DBManager.getAllRecordsCount(s);
		return(Count);
	}


	static ClsWorkAllocation[] getAllWorkAllocationInformation(int mCourseID,int mSemisterID,int mSubjectID)
	{
		int rec=getAllRecordsCount(mCourseID,mSemisterID,mSubjectID);
		ClsWorkAllocation obj[]=new ClsWorkAllocation[rec];
		String Query ="select * from tblWorkAllocation where CourseID="+String.valueOf(mCourseID)+
															 " and SemisterID="+String.valueOf(mSemisterID)+
															 " and SubjectID="+String.valueOf(mSubjectID);
		String values[][]=DBManager.getAllFullRow(Query,rec,10);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsWorkAllocation();
			obj[i].setWorkAllocationID(Integer.parseInt(values[i][0]));
            obj[i].setTimeSlotID(Integer.parseInt(values[i][1]));
			obj[i].setDayID(Integer.parseInt(values[i][2]));
			obj[i].setSubjectTypeID(Integer.parseInt(values[i][3]));
			obj[i].setFloorID(Integer.parseInt(values[i][4]));
			obj[i].setRoomID(Integer.parseInt(values[i][5]));
			obj[i].setCourseID(Integer.parseInt(values[i][6]));
			obj[i].setStaffID(Integer.parseInt(values[i][7]));
			obj[i].setSemisterID(Integer.parseInt(values[i][8]));
			obj[i].setSubjectID(Integer.parseInt(values[i][9]));

		}
		return(obj);
	}

    static int getAllRecordsCount(int mCourseID,int mSemisterID,int mSubjectID,int mTimeSlotID)
	{
		String s="Select Count(*) from tblWorkAllocation  where CourseID="+String.valueOf(mCourseID)+
															 " and SemisterID="+String.valueOf(mSemisterID)+
															 " and SubjectID="+String.valueOf(mSubjectID)+
															 " and TimeSlotID="+String.valueOf(mTimeSlotID);
		int Count =DBManager.getAllRecordsCount(s);
		return(Count);
	}


	static ClsWorkAllocation[] getAllWorkAllocationInformation(int mCourseID,int mSemisterID,int mSubjectID,int mTimeSlotID)
	{
		int rec=getAllRecordsCount(mCourseID,mSemisterID,mSubjectID,mTimeSlotID);
		ClsWorkAllocation obj[]=new ClsWorkAllocation[rec];
		String Query ="select * from tblWorkAllocation where CourseID="+String.valueOf(mCourseID)+
															 " and SemisterID="+String.valueOf(mSemisterID)+
															 " and SubjectID="+String.valueOf(mSubjectID)+
															 " and TimeSlotID="+String.valueOf(mTimeSlotID);;
		String values[][]=DBManager.getAllFullRow(Query,rec,10);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsWorkAllocation();
			obj[i].setWorkAllocationID(Integer.parseInt(values[i][0]));
            obj[i].setTimeSlotID(Integer.parseInt(values[i][1]));
			obj[i].setDayID(Integer.parseInt(values[i][2]));
			obj[i].setSubjectTypeID(Integer.parseInt(values[i][3]));
			obj[i].setFloorID(Integer.parseInt(values[i][4]));
			obj[i].setRoomID(Integer.parseInt(values[i][5]));
			obj[i].setCourseID(Integer.parseInt(values[i][6]));
			obj[i].setStaffID(Integer.parseInt(values[i][7]));
			obj[i].setSemisterID(Integer.parseInt(values[i][8]));
			obj[i].setSubjectID(Integer.parseInt(values[i][9]));

		}
		return(obj);
	}

    static int getAllRecordsCount(int mCourseID,int mSemisterID,int mSubjectID,int mTimeSlotID,int mDayID)
	{
		String s="Select Count(*) from tblWorkAllocation  where CourseID="+String.valueOf(mCourseID)+
															 " and SemisterID="+String.valueOf(mSemisterID)+
															 " and SubjectID="+String.valueOf(mSubjectID)+
															 " and TimeSlotID="+String.valueOf(mTimeSlotID)+
															 " and DayID="+String.valueOf(mDayID);
		int Count =DBManager.getAllRecordsCount(s);
		return(Count);
	}


	static ClsWorkAllocation[] getAllWorkAllocationInformation(int mCourseID,int mSemisterID,int mSubjectID,int mTimeSlotID,int mDayID)
	{
		int rec=getAllRecordsCount(mCourseID,mSemisterID,mSubjectID,mTimeSlotID,mDayID);
		ClsWorkAllocation obj[]=new ClsWorkAllocation[rec];
		String Query ="select * from tblWorkAllocation where CourseID="+String.valueOf(mCourseID)+
															 " and SemisterID="+String.valueOf(mSemisterID)+
															 " and SubjectID="+String.valueOf(mSubjectID)+
															 " and TimeSlotID="+String.valueOf(mTimeSlotID)+
															 " and DayID="+String.valueOf(mDayID);

		String values[][]=DBManager.getAllFullRow(Query,rec,10);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsWorkAllocation();
			obj[i].setWorkAllocationID(Integer.parseInt(values[i][0]));
            obj[i].setTimeSlotID(Integer.parseInt(values[i][1]));
			obj[i].setDayID(Integer.parseInt(values[i][2]));
			obj[i].setSubjectTypeID(Integer.parseInt(values[i][3]));
			obj[i].setFloorID(Integer.parseInt(values[i][4]));
			obj[i].setRoomID(Integer.parseInt(values[i][5]));
			obj[i].setCourseID(Integer.parseInt(values[i][6]));
			obj[i].setStaffID(Integer.parseInt(values[i][7]));
			obj[i].setSemisterID(Integer.parseInt(values[i][8]));
			obj[i].setSubjectID(Integer.parseInt(values[i][9]));

		}
		return(obj);
	}
    static int getAllRecordsCount(int mCourseID,int mSemisterID,int mSubjectID,int mTimeSlotID,int mDayID,int mSubjectTypeID)
	{
		String s="Select Count(*) from tblWorkAllocation  where CourseID="+String.valueOf(mCourseID)+
															 " and SemisterID="+String.valueOf(mSemisterID)+
															 " and SubjectID="+String.valueOf(mSubjectID)+
															 " and TimeSlotID="+String.valueOf(mTimeSlotID)+
															 " and DayID="+String.valueOf(mDayID)+
															 " and SubjectTypeID="+String.valueOf(mSubjectTypeID);

		int Count =DBManager.getAllRecordsCount(s);
		return(Count);
	}


	static ClsWorkAllocation[] getAllWorkAllocationInformation(int mCourseID,int mSemisterID,int mSubjectID,int mTimeSlotID,int mDayID,int mSubjectTypeID)
	{
		int rec=getAllRecordsCount(mCourseID,mSemisterID,mSubjectID,mTimeSlotID,mDayID,mSubjectTypeID);
		ClsWorkAllocation obj[]=new ClsWorkAllocation[rec];
		String Query ="select * from tblWorkAllocation where CourseID="+String.valueOf(mCourseID)+
															 " and SemisterID="+String.valueOf(mSemisterID)+
															 " and SubjectID="+String.valueOf(mSubjectID)+
															 " and TimeSlotID="+String.valueOf(mTimeSlotID)+
															 " and DayID="+String.valueOf(mDayID)+
															 " and SubjectTypeID="+String.valueOf(mSubjectTypeID);

		String values[][]=DBManager.getAllFullRow(Query,rec,10);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsWorkAllocation();
			obj[i].setWorkAllocationID(Integer.parseInt(values[i][0]));
            obj[i].setTimeSlotID(Integer.parseInt(values[i][1]));
			obj[i].setDayID(Integer.parseInt(values[i][2]));
			obj[i].setSubjectTypeID(Integer.parseInt(values[i][3]));
			obj[i].setFloorID(Integer.parseInt(values[i][4]));
			obj[i].setRoomID(Integer.parseInt(values[i][5]));
			obj[i].setCourseID(Integer.parseInt(values[i][6]));
			obj[i].setStaffID(Integer.parseInt(values[i][7]));
			obj[i].setSemisterID(Integer.parseInt(values[i][8]));
			obj[i].setSubjectID(Integer.parseInt(values[i][9]));

		}
		return(obj);
	}


    static int getAllRecordsCountSubjectWise(int mCourseID,int mSemisterID,int mTimeSlotID,int mDayID,int mSubjectTypeID)
	{
		String s="Select Count(*) from tblWorkAllocation  where CourseID="+String.valueOf(mCourseID)+
															 " and SemisterID="+String.valueOf(mSemisterID)+
															 " and TimeSlotID="+String.valueOf(mTimeSlotID)+
															 " and DayID="+String.valueOf(mDayID)+
															 " and SubjectTypeID="+String.valueOf(mSubjectTypeID);

		int Count =DBManager.getAllRecordsCount(s);
		return(Count);
	}


	static ClsWorkAllocation[] getAllWorkAllocationInformationSubjectWise(int mCourseID,int mSemisterID,int mTimeSlotID,int mDayID,int mSubjectTypeID)
	{
		int rec=getAllRecordsCountSubjectWise(mCourseID,mSemisterID,mTimeSlotID,mDayID,mSubjectTypeID);
		ClsWorkAllocation obj[]=new ClsWorkAllocation[rec];
		String Query ="select * from tblWorkAllocation where CourseID="+String.valueOf(mCourseID)+
															 " and SemisterID="+String.valueOf(mSemisterID)+
															 " and TimeSlotID="+String.valueOf(mTimeSlotID)+
															 " and DayID="+String.valueOf(mDayID)+
															 " and SubjectTypeID="+String.valueOf(mSubjectTypeID);

		String values[][]=DBManager.getAllFullRow(Query,rec,9);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsWorkAllocation();
			obj[i].setWorkAllocationID(Integer.parseInt(values[i][0]));
            obj[i].setTimeSlotID(Integer.parseInt(values[i][1]));
			obj[i].setDayID(Integer.parseInt(values[i][2]));
			obj[i].setSubjectTypeID(Integer.parseInt(values[i][3]));
			obj[i].setFloorID(Integer.parseInt(values[i][4]));
			obj[i].setRoomID(Integer.parseInt(values[i][5]));
			obj[i].setCourseID(Integer.parseInt(values[i][6]));
			obj[i].setStaffID(Integer.parseInt(values[i][7]));
			obj[i].setSemisterID(Integer.parseInt(values[i][8]));
			//obj[i].setSubjectID(Integer.parseInt(values[i][9]));

		}
		return(obj);
	}



    static int getAllRecordsCount(int mCourseID,int mSemisterID,int mSubjectID,int mTimeSlotID,int mDayID,int mSubjectTypeID,int mFloorID)
	{
		String s="Select Count(*) from tblWorkAllocation  where CourseID="+String.valueOf(mCourseID)+
															 " and SemisterID="+String.valueOf(mSemisterID)+
															 " and SubjectID="+String.valueOf(mSubjectID)+
															 " and TimeSlotID="+String.valueOf(mTimeSlotID)+
															 " and DayID="+String.valueOf(mDayID)+
															 " and SubjectTypeID="+String.valueOf(mSubjectTypeID)+
														     " and FloorID="+String.valueOf(mFloorID);


		int Count =DBManager.getAllRecordsCount(s);
		return(Count);
	}


	static ClsWorkAllocation[] getAllWorkAllocationInformation(int mCourseID,int mSemisterID,int mSubjectID,int mTimeSlotID,int mDayID,int mSubjectTypeID,int mFloorID)
	{
		int rec=getAllRecordsCount(mCourseID,mSemisterID,mSubjectID,mTimeSlotID,mDayID,mFloorID);
		ClsWorkAllocation obj[]=new ClsWorkAllocation[rec];
		String Query ="select * from tblWorkAllocation where CourseID="+String.valueOf(mCourseID)+
															 " and SemisterID="+String.valueOf(mSemisterID)+
															 " and SubjectID="+String.valueOf(mSubjectID)+
															 " and TimeSlotID="+String.valueOf(mTimeSlotID)+
															 " and DayID="+String.valueOf(mDayID)+
															 " and SubjectTypeID="+String.valueOf(mSubjectTypeID)+
															 " and FloorID="+String.valueOf(mFloorID);

		String values[][]=DBManager.getAllFullRow(Query,rec,10);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsWorkAllocation();
			obj[i].setWorkAllocationID(Integer.parseInt(values[i][0]));
            obj[i].setTimeSlotID(Integer.parseInt(values[i][1]));
			obj[i].setDayID(Integer.parseInt(values[i][2]));
			obj[i].setSubjectTypeID(Integer.parseInt(values[i][3]));
			obj[i].setFloorID(Integer.parseInt(values[i][4]));
			obj[i].setRoomID(Integer.parseInt(values[i][5]));
			obj[i].setCourseID(Integer.parseInt(values[i][6]));
			obj[i].setStaffID(Integer.parseInt(values[i][7]));
			obj[i].setSemisterID(Integer.parseInt(values[i][8]));
			obj[i].setSubjectID(Integer.parseInt(values[i][9]));

		}
		return(obj);
	}

    static int getAllRecordsCount(int mCourseID,int mSemisterID,int mSubjectID,int mTimeSlotID,int mDayID,int mSubjectTypeID,int mFloorID,int mRoomID)
	{
		String s="Select Count(*) from tblWorkAllocation  where CourseID="+String.valueOf(mCourseID)+
															 " and SemisterID="+String.valueOf(mSemisterID)+
															 " and SubjectID="+String.valueOf(mSubjectID)+
															 " and TimeSlotID="+String.valueOf(mTimeSlotID)+
															 " and DayID="+String.valueOf(mDayID)+
															 " and SubjectTypeID="+String.valueOf(mSubjectTypeID)+
														     " and FloorID="+String.valueOf(mFloorID)+
														     " and RoomID="+String.valueOf(mRoomID);


		int Count =DBManager.getAllRecordsCount(s);
		return(Count);
	}


	static ClsWorkAllocation[] getAllWorkAllocationInformation(int mCourseID,int mSemisterID,int mSubjectID,int mTimeSlotID,int mDayID,int mSubjectTypeID,int mFloorID,int mRoomID)
	{
		int rec=getAllRecordsCount(mCourseID,mSemisterID,mSubjectID,mTimeSlotID,mDayID,mFloorID,mRoomID);
		ClsWorkAllocation obj[]=new ClsWorkAllocation[rec];
		String Query ="select * from tblWorkAllocation where CourseID="+String.valueOf(mCourseID)+
															 " and SemisterID="+String.valueOf(mSemisterID)+
															 " and SubjectID="+String.valueOf(mSubjectID)+
															 " and TimeSlotID="+String.valueOf(mTimeSlotID)+
															 " and DayID="+String.valueOf(mDayID)+
															 " and SubjectTypeID="+String.valueOf(mSubjectTypeID)+
															 " and FloorID="+String.valueOf(mFloorID)+
														     " and RoomID="+String.valueOf(mRoomID);

		String values[][]=DBManager.getAllFullRow(Query,rec,10);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsWorkAllocation();
			obj[i].setWorkAllocationID(Integer.parseInt(values[i][0]));
            obj[i].setTimeSlotID(Integer.parseInt(values[i][1]));
			obj[i].setDayID(Integer.parseInt(values[i][2]));
			obj[i].setSubjectTypeID(Integer.parseInt(values[i][3]));
			obj[i].setFloorID(Integer.parseInt(values[i][4]));
			obj[i].setRoomID(Integer.parseInt(values[i][5]));
			obj[i].setCourseID(Integer.parseInt(values[i][6]));
			obj[i].setStaffID(Integer.parseInt(values[i][7]));
			obj[i].setSemisterID(Integer.parseInt(values[i][8]));
			obj[i].setSubjectID(Integer.parseInt(values[i][9]));

		}
		return(obj);
	}

    static int getAllRecordsCount(int mCourseID,int mSemisterID,int mSubjectID,int mTimeSlotID,int mDayID,int mSubjectTypeID,int mFloorID,int mRoomID,int mStaffID)
	{
		String s="Select Count(*) from tblWorkAllocation  where CourseID="+String.valueOf(mCourseID)+
															 " and SemisterID="+String.valueOf(mSemisterID)+
															 " and SubjectID="+String.valueOf(mSubjectID)+
															 " and TimeSlotID="+String.valueOf(mTimeSlotID)+
															 " and DayID="+String.valueOf(mDayID)+
															 " and SubjectTypeID="+String.valueOf(mSubjectTypeID)+
														     " and FloorID="+String.valueOf(mFloorID)+
														     " and RoomID="+String.valueOf(mRoomID)+
														     " and StaffID="+String.valueOf(mStaffID);


		int Count =DBManager.getAllRecordsCount(s);
		return(Count);
	}


	static ClsWorkAllocation[] getAllWorkAllocationInformation(int mCourseID,int mSemisterID,int mSubjectID,int mTimeSlotID,int mDayID,int mSubjectTypeID,int mFloorID,int mRoomID,int mStaffID)
	{
		int rec=getAllRecordsCount(mCourseID,mSemisterID,mSubjectID,mTimeSlotID,mDayID,mFloorID,mRoomID,mStaffID);
		ClsWorkAllocation obj[]=new ClsWorkAllocation[rec];
		String Query ="select * from tblWorkAllocation where CourseID="+String.valueOf(mCourseID)+
															 " and SemisterID="+String.valueOf(mSemisterID)+
															 " and SubjectID="+String.valueOf(mSubjectID)+
															 " and TimeSlotID="+String.valueOf(mTimeSlotID)+
															 " and DayID="+String.valueOf(mDayID)+
															 " and SubjectTypeID="+String.valueOf(mSubjectTypeID)+
															 " and FloorID="+String.valueOf(mFloorID)+
														     " and RoomID="+String.valueOf(mRoomID)+
														     " and StaffID="+String.valueOf(mStaffID);


		String values[][]=DBManager.getAllFullRow(Query,rec,10);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsWorkAllocation();
			obj[i].setWorkAllocationID(Integer.parseInt(values[i][0]));
            obj[i].setTimeSlotID(Integer.parseInt(values[i][1]));
			obj[i].setDayID(Integer.parseInt(values[i][2]));
			obj[i].setSubjectTypeID(Integer.parseInt(values[i][3]));
			obj[i].setFloorID(Integer.parseInt(values[i][4]));
			obj[i].setRoomID(Integer.parseInt(values[i][5]));
			obj[i].setCourseID(Integer.parseInt(values[i][6]));
			obj[i].setStaffID(Integer.parseInt(values[i][7]));
			obj[i].setSemisterID(Integer.parseInt(values[i][8]));
			obj[i].setSubjectID(Integer.parseInt(values[i][9]));

		}
		return(obj);
	}
	public static void main(String args[])
	{
	}

}

