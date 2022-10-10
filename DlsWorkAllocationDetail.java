import java.io.*;
import DBManage.*;
import java.sql.*;
import myUtility.*;
import javax.swing.*;

class DlsWorkAllocationDetail
{

	static int getAllRecordsCount()
	{
		String Query = "select Count(tblWorkAllocation.WorkAllocationID) "+
								"FROM (((((tblWorkAllocation INNER JOIN tblTimeSlot ON tblWorkAllocation.TimeSlotID = tblTimeSlot.TimeSlotID)"+
															"INNER JOIN tblRoom ON tblWorkAllocation.RoomID = tblRoom.RoomID) "+
															"INNER JOIN tblFloor ON tblWorkAllocation.FloorID = tblFloor.FloorID) "+
															"INNER JOIN tblCourse ON tblWorkAllocation.CourseID = tblCourse.CourseID) "+
															"INNER JOIN tblStaff ON tblWorkAllocation.StaffID = tblStaff.StaffID) "+
															"INNER JOIN tblSubject ON tblWorkAllocation.SubjectID = tblSubject.SubjectID ";
		int Count =DBManager.getAllRecordsCount(Query);
		return(Count);
	}

	static ClsWorkAllocationDetail[] getAllWorkAllocationInformation()
	{
		int rec=getAllRecordsCount();
		ClsWorkAllocationDetail obj[]=new ClsWorkAllocationDetail[rec];

		String Query = "select tblWorkAllocation.WorkAllocationID, "+
								"tblWorkAllocation.TimeSlotID, "+
								"tblTimeSlot.TimeSlotName, "+
								"tblWorkAllocation.DayID, "+
								"tblWorkAllocation.SubjectTypeID, "+
								"tblWorkAllocation.RoomID, "+
								"tblRoom.RoomNumber, "+
								"tblWorkAllocation.FloorID, "+
								"tblFloor.FloorName, "+
								"tblWorkAllocation.CourseID, "+
								"tblCourse.CourseName, "+
								"tblWorkAllocation.StaffID, "+
								"tblStaff.StaffName, "+
								"tblWorkAllocation.SemisterID, "+
								"tblWorkAllocation.SubjectID, "+
								"tblSubject.SubjectName "+
								"FROM (((((tblWorkAllocation INNER JOIN tblTimeSlot ON tblWorkAllocation.TimeSlotID = tblTimeSlot.TimeSlotID)"+
															"INNER JOIN tblRoom ON tblWorkAllocation.RoomID = tblRoom.RoomID) "+
															"INNER JOIN tblFloor ON tblWorkAllocation.FloorID = tblFloor.FloorID) "+
															"INNER JOIN tblCourse ON tblWorkAllocation.CourseID = tblCourse.CourseID) "+
															"INNER JOIN tblStaff ON tblWorkAllocation.StaffID = tblStaff.StaffID) "+
															"INNER JOIN tblSubject ON tblWorkAllocation.SubjectID = tblSubject.SubjectID ";



		String values[][]=DBManager.getAllFullRow(Query,rec,16);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsWorkAllocationDetail();
			obj[i].setWorkAllocationID(Integer.parseInt(values[i][0]));
            obj[i].setTimeSlotID(Integer.parseInt(values[i][1]));
            obj[i].setTimeSlotName(values[i][2]);
			obj[i].setDayID(Integer.parseInt(values[i][3]));
			obj[i].setSubjectTypeID(Integer.parseInt(values[i][4]));
			obj[i].setRoomID(Integer.parseInt(values[i][5]));
			obj[i].setRoomNumber(values[i][6]);
			obj[i].setFloorID(Integer.parseInt(values[i][7]));
			obj[i].setFloorName(values[i][8]);
			obj[i].setCourseID(Integer.parseInt(values[i][9]));
			obj[i].setCourseName(values[i][10]);
			obj[i].setStaffID(Integer.parseInt(values[i][11]));
			obj[i].setStaffName(values[i][12]);
			obj[i].setSemisterID(Integer.parseInt(values[i][13]));
			obj[i].setSubjectID(Integer.parseInt(values[i][14]));
			obj[i].setSubjectName(values[i][15]);

		}
		return(obj);
	}


	static int getAllRecordsCount(int mCourseID)
	{
		String Query = "select Count(tblWorkAllocation.WorkAllocationID) "+
								"FROM (((((tblWorkAllocation INNER JOIN tblTimeSlot ON tblWorkAllocation.TimeSlotID = tblTimeSlot.TimeSlotID)"+
															"INNER JOIN tblRoom ON tblWorkAllocation.RoomID = tblRoom.RoomID) "+
															"INNER JOIN tblFloor ON tblWorkAllocation.FloorID = tblFloor.FloorID) "+
															"INNER JOIN tblCourse ON tblWorkAllocation.CourseID = tblCourse.CourseID) "+
															"INNER JOIN tblStaff ON tblWorkAllocation.StaffID = tblStaff.StaffID) "+
															"INNER JOIN tblSubject ON tblWorkAllocation.SubjectID = tblSubject.SubjectID "+
															"WHERE (tblWorkAllocation.CourseID="+String.valueOf(mCourseID)+")";
		int Count =DBManager.getAllRecordsCount(Query);
		return(Count);
	}

	static ClsWorkAllocationDetail[] getAllWorkAllocationInformation(int mCourseID)
	{
		int rec=getAllRecordsCount(mCourseID);
		ClsWorkAllocationDetail obj[]=new ClsWorkAllocationDetail[rec];

		String Query = "select tblWorkAllocation.WorkAllocationID, "+
								"tblWorkAllocation.TimeSlotID, "+
								"tblTimeSlot.TimeSlotName, "+
								"tblWorkAllocation.DayID, "+
								"tblWorkAllocation.SubjectTypeID, "+
								"tblWorkAllocation.RoomID, "+
								"tblRoom.RoomNumber, "+
								"tblWorkAllocation.FloorID, "+
								"tblFloor.FloorName, "+
								"tblWorkAllocation.CourseID, "+
								"tblCourse.CourseName, "+
								"tblWorkAllocation.StaffID, "+
								"tblStaff.StaffName, "+
								"tblWorkAllocation.SemisterID, "+
								"tblWorkAllocation.SubjectID, "+
								"tblSubject.SubjectName "+
								"FROM (((((tblWorkAllocation INNER JOIN tblTimeSlot ON tblWorkAllocation.TimeSlotID = tblTimeSlot.TimeSlotID)"+
															"INNER JOIN tblRoom ON tblWorkAllocation.RoomID = tblRoom.RoomID) "+
															"INNER JOIN tblFloor ON tblWorkAllocation.FloorID = tblFloor.FloorID) "+
															"INNER JOIN tblCourse ON tblWorkAllocation.CourseID = tblCourse.CourseID) "+
															"INNER JOIN tblStaff ON tblWorkAllocation.StaffID = tblStaff.StaffID) "+
															"INNER JOIN tblSubject ON tblWorkAllocation.SubjectID = tblSubject.SubjectID "+
															"WHERE (tblWorkAllocation.CourseID="+String.valueOf(mCourseID)+")";



		String values[][]=DBManager.getAllFullRow(Query,rec,16);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsWorkAllocationDetail();
			obj[i].setWorkAllocationID(Integer.parseInt(values[i][0]));
            obj[i].setTimeSlotID(Integer.parseInt(values[i][1]));
            obj[i].setTimeSlotName(values[i][2]);
			obj[i].setDayID(Integer.parseInt(values[i][3]));
			obj[i].setSubjectTypeID(Integer.parseInt(values[i][4]));
			obj[i].setRoomID(Integer.parseInt(values[i][5]));
			obj[i].setRoomNumber(values[i][6]);
			obj[i].setFloorID(Integer.parseInt(values[i][7]));
			obj[i].setFloorName(values[i][8]);
			obj[i].setCourseID(Integer.parseInt(values[i][9]));
			obj[i].setCourseName(values[i][10]);
			obj[i].setStaffID(Integer.parseInt(values[i][11]));
			obj[i].setStaffName(values[i][12]);
			obj[i].setSemisterID(Integer.parseInt(values[i][13]));
			obj[i].setSubjectID(Integer.parseInt(values[i][14]));
			obj[i].setSubjectName(values[i][15]);

		}
		return(obj);
	}


    static int getAllRecordsCount(int mCourseID,int mSemisterID)
	{
		String Query = "select Count(tblWorkAllocation.WorkAllocationID) "+
								"FROM (((((tblWorkAllocation INNER JOIN tblTimeSlot ON tblWorkAllocation.TimeSlotID = tblTimeSlot.TimeSlotID)"+
															"INNER JOIN tblRoom ON tblWorkAllocation.RoomID = tblRoom.RoomID) "+
															"INNER JOIN tblFloor ON tblWorkAllocation.FloorID = tblFloor.FloorID) "+
															"INNER JOIN tblCourse ON tblWorkAllocation.CourseID = tblCourse.CourseID) "+
															"INNER JOIN tblStaff ON tblWorkAllocation.StaffID = tblStaff.StaffID) "+
															"INNER JOIN tblSubject ON tblWorkAllocation.SubjectID = tblSubject.SubjectID "+
															"WHERE (tblWorkAllocation.CourseID="+String.valueOf(mCourseID)+" AND "+
															"(tblWorkAllocation.SemisterID="+String.valueOf(mSemisterID)+"))";
		int Count =DBManager.getAllRecordsCount(Query);
		//JOptionPane.showMessageDialog(null,Query);
		return(Count);
	}

	static ClsWorkAllocationDetail[] getAllWorkAllocationInformation(int mCourseID,int mSemisterID)
	{
		int rec=getAllRecordsCount(mCourseID,mSemisterID);
		ClsWorkAllocationDetail obj[]=new ClsWorkAllocationDetail[rec];

		String Query = "select tblWorkAllocation.WorkAllocationID, "+
								"tblWorkAllocation.TimeSlotID, "+
								"tblTimeSlot.TimeSlotName, "+
								"tblWorkAllocation.DayID, "+
								"tblWorkAllocation.SubjectTypeID, "+
								"tblWorkAllocation.RoomID, "+
								"tblRoom.RoomNumber, "+
								"tblWorkAllocation.FloorID, "+
								"tblFloor.FloorName, "+
								"tblWorkAllocation.CourseID, "+
								"tblCourse.CourseName, "+
								"tblWorkAllocation.StaffID, "+
								"tblStaff.StaffName, "+
								"tblWorkAllocation.SemisterID, "+
								"tblWorkAllocation.SubjectID, "+
								"tblSubject.SubjectName "+
								"FROM (((((tblWorkAllocation INNER JOIN tblTimeSlot ON tblWorkAllocation.TimeSlotID = tblTimeSlot.TimeSlotID)"+
															"INNER JOIN tblRoom ON tblWorkAllocation.RoomID = tblRoom.RoomID) "+
															"INNER JOIN tblFloor ON tblWorkAllocation.FloorID = tblFloor.FloorID) "+
															"INNER JOIN tblCourse ON tblWorkAllocation.CourseID = tblCourse.CourseID) "+
															"INNER JOIN tblStaff ON tblWorkAllocation.StaffID = tblStaff.StaffID) "+
															"INNER JOIN tblSubject ON tblWorkAllocation.SubjectID = tblSubject.SubjectID "+
															"WHERE (tblWorkAllocation.CourseID="+String.valueOf(mCourseID)+" AND "+
															"(tblWorkAllocation.SemisterID="+String.valueOf(mSemisterID)+"))";

		//JOptionPane.showMessageDialog(null,Query);


		String values[][]=DBManager.getAllFullRow(Query,rec,16);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsWorkAllocationDetail();
			obj[i].setWorkAllocationID(Integer.parseInt(values[i][0]));
            obj[i].setTimeSlotID(Integer.parseInt(values[i][1]));
            obj[i].setTimeSlotName(values[i][2]);
			obj[i].setDayID(Integer.parseInt(values[i][3]));
			obj[i].setSubjectTypeID(Integer.parseInt(values[i][4]));
			obj[i].setRoomID(Integer.parseInt(values[i][5]));
			obj[i].setRoomNumber(values[i][6]);
			obj[i].setFloorID(Integer.parseInt(values[i][7]));
			obj[i].setFloorName(values[i][8]);
			obj[i].setCourseID(Integer.parseInt(values[i][9]));
			obj[i].setCourseName(values[i][10]);
			obj[i].setStaffID(Integer.parseInt(values[i][11]));
			obj[i].setStaffName(values[i][12]);
			obj[i].setSemisterID(Integer.parseInt(values[i][13]));
			obj[i].setSubjectID(Integer.parseInt(values[i][14]));
			obj[i].setSubjectName(values[i][15]);

		}
		return(obj);
	}

    static int getAllRecordsCount(int mCourseID,int mSemisterID,int mSubjectID)
	{
		String Query = "select Count(tblWorkAllocation.WorkAllocationID) "+
								"FROM (((((tblWorkAllocation INNER JOIN tblTimeSlot ON tblWorkAllocation.TimeSlotID = tblTimeSlot.TimeSlotID)"+
															"INNER JOIN tblRoom ON tblWorkAllocation.RoomID = tblRoom.RoomID) "+
															"INNER JOIN tblFloor ON tblWorkAllocation.FloorID = tblFloor.FloorID) "+
															"INNER JOIN tblCourse ON tblWorkAllocation.CourseID = tblCourse.CourseID) "+
															"INNER JOIN tblStaff ON tblWorkAllocation.StaffID = tblStaff.StaffID) "+
															"INNER JOIN tblSubject ON tblWorkAllocation.SubjectID = tblSubject.SubjectID "+
															"WHERE (tblWorkAllocation.CourseID="+String.valueOf(mCourseID)+" AND "+
															"(tblWorkAllocation.SemisterID="+String.valueOf(mSemisterID)+" AND "+
															"(tblWorkAllocation.SubjectID="+String.valueOf(mSubjectID)+")))";
		int Count =DBManager.getAllRecordsCount(Query);
		return(Count);
	}

	static ClsWorkAllocationDetail[] getAllWorkAllocationInformation(int mCourseID,int mSemisterID,int mSubjectID)
	{
		int rec=getAllRecordsCount(mCourseID,mSemisterID,mSubjectID);
		ClsWorkAllocationDetail obj[]=new ClsWorkAllocationDetail[rec];

		String Query = "select tblWorkAllocation.WorkAllocationID, "+
								"tblWorkAllocation.TimeSlotID, "+
								"tblTimeSlot.TimeSlotName, "+
								"tblWorkAllocation.DayID, "+
								"tblWorkAllocation.SubjectTypeID, "+
								"tblWorkAllocation.RoomID, "+
								"tblRoom.RoomNumber, "+
								"tblWorkAllocation.FloorID, "+
								"tblFloor.FloorName, "+
								"tblWorkAllocation.CourseID, "+
								"tblCourse.CourseName, "+
								"tblWorkAllocation.StaffID, "+
								"tblStaff.StaffName, "+
								"tblWorkAllocation.SemisterID, "+
								"tblWorkAllocation.SubjectID, "+
								"tblSubject.SubjectName "+
								"FROM (((((tblWorkAllocation INNER JOIN tblTimeSlot ON tblWorkAllocation.TimeSlotID = tblTimeSlot.TimeSlotID)"+
															"INNER JOIN tblRoom ON tblWorkAllocation.RoomID = tblRoom.RoomID) "+
															"INNER JOIN tblFloor ON tblWorkAllocation.FloorID = tblFloor.FloorID) "+
															"INNER JOIN tblCourse ON tblWorkAllocation.CourseID = tblCourse.CourseID) "+
															"INNER JOIN tblStaff ON tblWorkAllocation.StaffID = tblStaff.StaffID) "+
															"INNER JOIN tblSubject ON tblWorkAllocation.SubjectID = tblSubject.SubjectID "+
															"WHERE (tblWorkAllocation.CourseID="+String.valueOf(mCourseID)+"AND"+
                                                            "(tblWorkAllocation.SemisterID="+String.valueOf(mSemisterID)+"AND"+
															"(tblWorkAllocation.SubjectID="+String.valueOf(mSubjectID)+")))";


		String values[][]=DBManager.getAllFullRow(Query,rec,16);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsWorkAllocationDetail();
			obj[i].setWorkAllocationID(Integer.parseInt(values[i][0]));
            obj[i].setTimeSlotID(Integer.parseInt(values[i][1]));
            obj[i].setTimeSlotName(values[i][2]);
			obj[i].setDayID(Integer.parseInt(values[i][3]));
			obj[i].setSubjectTypeID(Integer.parseInt(values[i][4]));
			obj[i].setRoomID(Integer.parseInt(values[i][5]));
			obj[i].setRoomNumber(values[i][6]);
			obj[i].setFloorID(Integer.parseInt(values[i][7]));
			obj[i].setFloorName(values[i][8]);
			obj[i].setCourseID(Integer.parseInt(values[i][9]));
			obj[i].setCourseName(values[i][10]);
			obj[i].setStaffID(Integer.parseInt(values[i][11]));
			obj[i].setStaffName(values[i][12]);
			obj[i].setSemisterID(Integer.parseInt(values[i][13]));
			obj[i].setSubjectID(Integer.parseInt(values[i][14]));
			obj[i].setSubjectName(values[i][15]);

		}
		return(obj);
	}

    static int getAllRecordsCount(int mCourseID,int mSemisterID,int mSubjectID,int mTimeSlotID)
	{
		String Query = "select Count(tblWorkAllocation.WorkAllocationID) "+
								"FROM (((((tblWorkAllocation INNER JOIN tblTimeSlot ON tblWorkAllocation.TimeSlotID = tblTimeSlot.TimeSlotID)"+
															"INNER JOIN tblRoom ON tblWorkAllocation.RoomID = tblRoom.RoomID) "+
															"INNER JOIN tblFloor ON tblWorkAllocation.FloorID = tblFloor.FloorID) "+
															"INNER JOIN tblCourse ON tblWorkAllocation.CourseID = tblCourse.CourseID) "+
															"INNER JOIN tblStaff ON tblWorkAllocation.StaffID = tblStaff.StaffID) "+
															"INNER JOIN tblSubject ON tblWorkAllocation.SubjectID = tblSubject.SubjectID "+
															"WHERE (tblWorkAllocation.CourseID="+String.valueOf(mCourseID)+" AND "+
															"(tblWorkAllocation.SemisterID="+String.valueOf(mSemisterID)+" AND "+
															"(tblWorkAllocation.SubjectID="+String.valueOf(mSubjectID)+" AND "+
															"(tblWorkAllocation.TimeSlotID="+String.valueOf(mTimeSlotID)+"))))";

		int Count =DBManager.getAllRecordsCount(Query);
		return(Count);
	}

	static ClsWorkAllocationDetail[] getAllWorkAllocationInformation(int mCourseID,int mSemisterID,int mSubjectID,int mTimeSlotID)
	{
		int rec=getAllRecordsCount(mCourseID,mSemisterID,mSubjectID,mTimeSlotID);
		ClsWorkAllocationDetail obj[]=new ClsWorkAllocationDetail[rec];

		String Query = "select tblWorkAllocation.WorkAllocationID, "+
								"tblWorkAllocation.TimeSlotID, "+
								"tblTimeSlot.TimeSlotName, "+
								"tblWorkAllocation.DayID, "+
								"tblWorkAllocation.SubjectTypeID, "+
								"tblWorkAllocation.RoomID, "+
								"tblRoom.RoomNumber, "+
								"tblWorkAllocation.FloorID, "+
								"tblFloor.FloorName, "+
								"tblWorkAllocation.CourseID, "+
								"tblCourse.CourseName, "+
								"tblWorkAllocation.StaffID, "+
								"tblStaff.StaffName, "+
								"tblWorkAllocation.SemisterID, "+
								"tblWorkAllocation.SubjectID, "+
								"tblSubject.SubjectName "+
								"FROM (((((tblWorkAllocation INNER JOIN tblTimeSlot ON tblWorkAllocation.TimeSlotID = tblTimeSlot.TimeSlotID)"+
															"INNER JOIN tblRoom ON tblWorkAllocation.RoomID = tblRoom.RoomID) "+
															"INNER JOIN tblFloor ON tblWorkAllocation.FloorID = tblFloor.FloorID) "+
															"INNER JOIN tblCourse ON tblWorkAllocation.CourseID = tblCourse.CourseID) "+
															"INNER JOIN tblStaff ON tblWorkAllocation.StaffID = tblStaff.StaffID) "+
															"INNER JOIN tblSubject ON tblWorkAllocation.SubjectID = tblSubject.SubjectID "+
															"WHERE (tblWorkAllocation.CourseID="+String.valueOf(mCourseID)+"AND"+
                                                            "(tblWorkAllocation.SemisterID="+String.valueOf(mSemisterID)+"AND"+
															"(tblWorkAllocation.SubjectID="+String.valueOf(mSubjectID)+" AND "+
														    "(tblWorkAllocation.TimeSlotID="+String.valueOf(mTimeSlotID)+"))))";



		String values[][]=DBManager.getAllFullRow(Query,rec,16);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsWorkAllocationDetail();
			obj[i].setWorkAllocationID(Integer.parseInt(values[i][0]));
            obj[i].setTimeSlotID(Integer.parseInt(values[i][1]));
            obj[i].setTimeSlotName(values[i][2]);
			obj[i].setDayID(Integer.parseInt(values[i][3]));
			obj[i].setSubjectTypeID(Integer.parseInt(values[i][4]));
			obj[i].setRoomID(Integer.parseInt(values[i][5]));
			obj[i].setRoomNumber(values[i][6]);
			obj[i].setFloorID(Integer.parseInt(values[i][7]));
			obj[i].setFloorName(values[i][8]);
			obj[i].setCourseID(Integer.parseInt(values[i][9]));
			obj[i].setCourseName(values[i][10]);
			obj[i].setStaffID(Integer.parseInt(values[i][11]));
			obj[i].setStaffName(values[i][12]);
			obj[i].setSemisterID(Integer.parseInt(values[i][13]));
			obj[i].setSubjectID(Integer.parseInt(values[i][14]));
			obj[i].setSubjectName(values[i][15]);

		}
		return(obj);
	}

    static int getAllRecordsCount(int mCourseID,int mSemisterID,int mSubjectID,int mTimeSlotID,int mDayID)
	{
		String Query = "select Count(tblWorkAllocation.WorkAllocationID) "+
								"FROM (((((tblWorkAllocation INNER JOIN tblTimeSlot ON tblWorkAllocation.TimeSlotID = tblTimeSlot.TimeSlotID)"+
															"INNER JOIN tblRoom ON tblWorkAllocation.RoomID = tblRoom.RoomID) "+
															"INNER JOIN tblFloor ON tblWorkAllocation.FloorID = tblFloor.FloorID) "+
															"INNER JOIN tblCourse ON tblWorkAllocation.CourseID = tblCourse.CourseID) "+
															"INNER JOIN tblStaff ON tblWorkAllocation.StaffID = tblStaff.StaffID) "+
															"INNER JOIN tblSubject ON tblWorkAllocation.SubjectID = tblSubject.SubjectID "+
															"WHERE (tblWorkAllocation.CourseID="+String.valueOf(mCourseID)+" AND "+
															"(tblWorkAllocation.SemisterID="+String.valueOf(mSemisterID)+" AND "+
															"(tblWorkAllocation.SubjectID="+String.valueOf(mSubjectID)+" AND "+
															"(tblWorkAllocation.TimeSlotID="+String.valueOf(mTimeSlotID)+" AND "+
														    "(tblWorkAllocation.DayID="+String.valueOf(mDayID)+")))))";

		int Count =DBManager.getAllRecordsCount(Query);
		return(Count);
	}

	static ClsWorkAllocationDetail[] getAllWorkAllocationInformation(int mCourseID,int mSemisterID,int mSubjectID,int mTimeSlotID,int mDayID)
	{
		int rec=getAllRecordsCount(mCourseID,mSemisterID,mSubjectID,mTimeSlotID,mDayID);
		ClsWorkAllocationDetail obj[]=new ClsWorkAllocationDetail[rec];

		String Query = "select tblWorkAllocation.WorkAllocationID, "+
								"tblWorkAllocation.TimeSlotID, "+
								"tblTimeSlot.TimeSlotName, "+
								"tblWorkAllocation.DayID, "+
								"tblWorkAllocation.SubjectTypeID, "+
								"tblWorkAllocation.RoomID, "+
								"tblRoom.RoomNumber, "+
								"tblWorkAllocation.FloorID, "+
								"tblFloor.FloorName, "+
								"tblWorkAllocation.CourseID, "+
								"tblCourse.CourseName, "+
								"tblWorkAllocation.StaffID, "+
								"tblStaff.StaffName, "+
								"tblWorkAllocation.SemisterID, "+
								"tblWorkAllocation.SubjectID, "+
								"tblSubject.SubjectName "+
								"FROM (((((tblWorkAllocation INNER JOIN tblTimeSlot ON tblWorkAllocation.TimeSlotID = tblTimeSlot.TimeSlotID)"+
															"INNER JOIN tblRoom ON tblWorkAllocation.RoomID = tblRoom.RoomID) "+
															"INNER JOIN tblFloor ON tblWorkAllocation.FloorID = tblFloor.FloorID) "+
															"INNER JOIN tblCourse ON tblWorkAllocation.CourseID = tblCourse.CourseID) "+
															"INNER JOIN tblStaff ON tblWorkAllocation.StaffID = tblStaff.StaffID) "+
															"INNER JOIN tblSubject ON tblWorkAllocation.SubjectID = tblSubject.SubjectID "+
															"WHERE (tblWorkAllocation.CourseID="+String.valueOf(mCourseID)+"AND"+
                                                            "(tblWorkAllocation.SemisterID="+String.valueOf(mSemisterID)+"AND"+
															"(tblWorkAllocation.SubjectID="+String.valueOf(mSubjectID)+" AND "+
														    "(tblWorkAllocation.TimeSlotID="+String.valueOf(mTimeSlotID)+" AND "+
														    "(tblWorkAllocation.DayID="+String.valueOf(mDayID)+")))))";



		String values[][]=DBManager.getAllFullRow(Query,rec,16);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsWorkAllocationDetail();
			obj[i].setWorkAllocationID(Integer.parseInt(values[i][0]));
            obj[i].setTimeSlotID(Integer.parseInt(values[i][1]));
            obj[i].setTimeSlotName(values[i][2]);
			obj[i].setDayID(Integer.parseInt(values[i][3]));
			obj[i].setSubjectTypeID(Integer.parseInt(values[i][4]));
			obj[i].setRoomID(Integer.parseInt(values[i][5]));
			obj[i].setRoomNumber(values[i][6]);
			obj[i].setFloorID(Integer.parseInt(values[i][7]));
			obj[i].setFloorName(values[i][8]);
			obj[i].setCourseID(Integer.parseInt(values[i][9]));
			obj[i].setCourseName(values[i][10]);
			obj[i].setStaffID(Integer.parseInt(values[i][11]));
			obj[i].setStaffName(values[i][12]);
			obj[i].setSemisterID(Integer.parseInt(values[i][13]));
			obj[i].setSubjectID(Integer.parseInt(values[i][14]));
			obj[i].setSubjectName(values[i][15]);

		}
		return(obj);
	}

    static int getAllRecordsCount(int mCourseID,int mSemisterID,int mSubjectID,int mTimeSlotID,int mDayID,int mSubjectTypeID)
	{
		String Query = "select Count(tblWorkAllocation.WorkAllocationID) "+
								"FROM (((((tblWorkAllocation INNER JOIN tblTimeSlot ON tblWorkAllocation.TimeSlotID = tblTimeSlot.TimeSlotID)"+
															"INNER JOIN tblRoom ON tblWorkAllocation.RoomID = tblRoom.RoomID) "+
															"INNER JOIN tblFloor ON tblWorkAllocation.FloorID = tblFloor.FloorID) "+
															"INNER JOIN tblCourse ON tblWorkAllocation.CourseID = tblCourse.CourseID) "+
															"INNER JOIN tblStaff ON tblWorkAllocation.StaffID = tblStaff.StaffID) "+
															"INNER JOIN tblSubject ON tblWorkAllocation.SubjectID = tblSubject.SubjectID "+
															"WHERE (tblWorkAllocation.CourseID="+String.valueOf(mCourseID)+" AND "+
															"(tblWorkAllocation.SemisterID="+String.valueOf(mSemisterID)+" AND "+
															"(tblWorkAllocation.SubjectID="+String.valueOf(mSubjectID)+" AND "+
															"(tblWorkAllocation.TimeSlotID="+String.valueOf(mTimeSlotID)+" AND "+
														    "(tblWorkAllocation.DayID="+String.valueOf(mDayID)+"AND"+
														   	"(tblWorkAllocation.SubjectTypeID="+String.valueOf(mSubjectTypeID)+"))))))";

		int Count =DBManager.getAllRecordsCount(Query);
		return(Count);
	}

	static ClsWorkAllocationDetail[] getAllWorkAllocationInformation(int mCourseID,int mSemisterID,int mSubjectID,int mTimeSlotID,int mDayID,int mSubjectTypeID)
	{
		int rec=getAllRecordsCount(mCourseID,mSemisterID,mSubjectID,mTimeSlotID,mDayID,mSubjectTypeID);
		ClsWorkAllocationDetail obj[]=new ClsWorkAllocationDetail[rec];

		String Query = "select tblWorkAllocation.WorkAllocationID, "+
								"tblWorkAllocation.TimeSlotID, "+
								"tblTimeSlot.TimeSlotName, "+
								"tblWorkAllocation.DayID, "+
								"tblWorkAllocation.SubjectTypeID, "+
								"tblWorkAllocation.RoomID, "+
								"tblRoom.RoomNumber, "+
								"tblWorkAllocation.FloorID, "+
								"tblFloor.FloorName, "+
								"tblWorkAllocation.CourseID, "+
								"tblCourse.CourseName, "+
								"tblWorkAllocation.StaffID, "+
								"tblStaff.StaffName, "+
								"tblWorkAllocation.SemisterID, "+
								"tblWorkAllocation.SubjectID, "+
								"tblSubject.SubjectName "+
								"FROM (((((tblWorkAllocation INNER JOIN tblTimeSlot ON tblWorkAllocation.TimeSlotID = tblTimeSlot.TimeSlotID)"+
															"INNER JOIN tblRoom ON tblWorkAllocation.RoomID = tblRoom.RoomID) "+
															"INNER JOIN tblFloor ON tblWorkAllocation.FloorID = tblFloor.FloorID) "+
															"INNER JOIN tblCourse ON tblWorkAllocation.CourseID = tblCourse.CourseID) "+
															"INNER JOIN tblStaff ON tblWorkAllocation.StaffID = tblStaff.StaffID) "+
															"INNER JOIN tblSubject ON tblWorkAllocation.SubjectID = tblSubject.SubjectID "+
															"WHERE (tblWorkAllocation.CourseID="+String.valueOf(mCourseID)+"AND"+
                                                            "(tblWorkAllocation.SemisterID="+String.valueOf(mSemisterID)+"AND"+
															"(tblWorkAllocation.SubjectID="+String.valueOf(mSubjectID)+" AND "+
														    "(tblWorkAllocation.TimeSlotID="+String.valueOf(mTimeSlotID)+" AND "+
                                                            "(tblWorkAllocation.DayID="+String.valueOf(mDayID)+"AND"+
														   	"(tblWorkAllocation.SubjectTypeID="+String.valueOf(mSubjectTypeID)+"))))))";


		String values[][]=DBManager.getAllFullRow(Query,rec,16);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsWorkAllocationDetail();
			obj[i].setWorkAllocationID(Integer.parseInt(values[i][0]));
            obj[i].setTimeSlotID(Integer.parseInt(values[i][1]));
            obj[i].setTimeSlotName(values[i][2]);
			obj[i].setDayID(Integer.parseInt(values[i][3]));
			obj[i].setSubjectTypeID(Integer.parseInt(values[i][4]));
			obj[i].setRoomID(Integer.parseInt(values[i][5]));
			obj[i].setRoomNumber(values[i][6]);
			obj[i].setFloorID(Integer.parseInt(values[i][7]));
			obj[i].setFloorName(values[i][8]);
			obj[i].setCourseID(Integer.parseInt(values[i][9]));
			obj[i].setCourseName(values[i][10]);
			obj[i].setStaffID(Integer.parseInt(values[i][11]));
			obj[i].setStaffName(values[i][12]);
			obj[i].setSemisterID(Integer.parseInt(values[i][13]));
			obj[i].setSubjectID(Integer.parseInt(values[i][14]));
			obj[i].setSubjectName(values[i][15]);

		}
		return(obj);
	}

    static int getAllRecordsCount(int mCourseID,int mSemisterID,int mSubjectID,int mTimeSlotID,int mDayID,int mSubjectTypeID,int mFloorID)
	{
		String Query = "select Count(tblWorkAllocation.WorkAllocationID) "+
								"FROM (((((tblWorkAllocation INNER JOIN tblTimeSlot ON tblWorkAllocation.TimeSlotID = tblTimeSlot.TimeSlotID)"+
															"INNER JOIN tblRoom ON tblWorkAllocation.RoomID = tblRoom.RoomID) "+
															"INNER JOIN tblFloor ON tblWorkAllocation.FloorID = tblFloor.FloorID) "+
															"INNER JOIN tblCourse ON tblWorkAllocation.CourseID = tblCourse.CourseID) "+
															"INNER JOIN tblStaff ON tblWorkAllocation.StaffID = tblStaff.StaffID) "+
															"INNER JOIN tblSubject ON tblWorkAllocation.SubjectID = tblSubject.SubjectID "+
															"WHERE (tblWorkAllocation.CourseID="+String.valueOf(mCourseID)+" AND "+
															"(tblWorkAllocation.SemisterID="+String.valueOf(mSemisterID)+" AND "+
															"(tblWorkAllocation.SubjectID="+String.valueOf(mSubjectID)+" AND "+
															"(tblWorkAllocation.TimeSlotID="+String.valueOf(mTimeSlotID)+" AND "+
														    "(tblWorkAllocation.DayID="+String.valueOf(mDayID)+"AND"+
														   	"(tblWorkAllocation.SubjectTypeID="+String.valueOf(mSubjectTypeID)+" AND "+
														    "(tblWorkAllocation.FloorID="+String.valueOf(mFloorID)+")))))))";

		int Count =DBManager.getAllRecordsCount(Query);
		return(Count);
	}

	static ClsWorkAllocationDetail[] getAllWorkAllocationInformation(int mCourseID,int mSemisterID,int mSubjectID,int mTimeSlotID,int mDayID,int mSubjectTypeID,int mFloorID)
	{
		int rec=getAllRecordsCount(mCourseID,mSemisterID,mSubjectID,mTimeSlotID,mDayID,mSubjectTypeID,mFloorID);
		ClsWorkAllocationDetail obj[]=new ClsWorkAllocationDetail[rec];

		String Query = "select tblWorkAllocation.WorkAllocationID, "+
								"tblWorkAllocation.TimeSlotID, "+
								"tblTimeSlot.TimeSlotName, "+
								"tblWorkAllocation.DayID, "+
								"tblWorkAllocation.SubjectTypeID, "+
								"tblWorkAllocation.RoomID, "+
								"tblRoom.RoomNumber, "+
								"tblWorkAllocation.FloorID, "+
								"tblFloor.FloorName, "+
								"tblWorkAllocation.CourseID, "+
								"tblCourse.CourseName, "+
								"tblWorkAllocation.StaffID, "+
								"tblStaff.StaffName, "+
								"tblWorkAllocation.SemisterID, "+
								"tblWorkAllocation.SubjectID, "+
								"tblSubject.SubjectName "+
								"FROM (((((tblWorkAllocation INNER JOIN tblTimeSlot ON tblWorkAllocation.TimeSlotID = tblTimeSlot.TimeSlotID)"+
															"INNER JOIN tblRoom ON tblWorkAllocation.RoomID = tblRoom.RoomID) "+
															"INNER JOIN tblFloor ON tblWorkAllocation.FloorID = tblFloor.FloorID) "+
															"INNER JOIN tblCourse ON tblWorkAllocation.CourseID = tblCourse.CourseID) "+
															"INNER JOIN tblStaff ON tblWorkAllocation.StaffID = tblStaff.StaffID) "+
															"INNER JOIN tblSubject ON tblWorkAllocation.SubjectID = tblSubject.SubjectID "+
															"WHERE (tblWorkAllocation.CourseID="+String.valueOf(mCourseID)+"AND"+
                                                            "(tblWorkAllocation.SemisterID="+String.valueOf(mSemisterID)+"AND"+
															"(tblWorkAllocation.SubjectID="+String.valueOf(mSubjectID)+" AND "+
														    "(tblWorkAllocation.TimeSlotID="+String.valueOf(mTimeSlotID)+" AND "+
                                                            "(tblWorkAllocation.DayID="+String.valueOf(mDayID)+"AND"+
														   	"(tblWorkAllocation.SubjectTypeID="+String.valueOf(mSubjectTypeID)+" AND "+
														    "(tblWorkAllocation.FloorID="+String.valueOf(mFloorID)+")))))))";

		String values[][]=DBManager.getAllFullRow(Query,rec,16);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsWorkAllocationDetail();
			obj[i].setWorkAllocationID(Integer.parseInt(values[i][0]));
            obj[i].setTimeSlotID(Integer.parseInt(values[i][1]));
            obj[i].setTimeSlotName(values[i][2]);
			obj[i].setDayID(Integer.parseInt(values[i][3]));
			obj[i].setSubjectTypeID(Integer.parseInt(values[i][4]));
			obj[i].setRoomID(Integer.parseInt(values[i][5]));
			obj[i].setRoomNumber(values[i][6]);
			obj[i].setFloorID(Integer.parseInt(values[i][7]));
			obj[i].setFloorName(values[i][8]);
			obj[i].setCourseID(Integer.parseInt(values[i][9]));
			obj[i].setCourseName(values[i][10]);
			obj[i].setStaffID(Integer.parseInt(values[i][11]));
			obj[i].setStaffName(values[i][12]);
			obj[i].setSemisterID(Integer.parseInt(values[i][13]));
			obj[i].setSubjectID(Integer.parseInt(values[i][14]));
			obj[i].setSubjectName(values[i][15]);

		}
		return(obj);
	}

    static int getAllRecordsCount(int mCourseID,int mSemisterID,int mSubjectID,int mTimeSlotID,int mDayID,int mSubjectTypeID,int mFloorID,int mRoomID)
	{
		String Query = "select Count(tblWorkAllocation.WorkAllocationID) "+
								"FROM (((((tblWorkAllocation INNER JOIN tblTimeSlot ON tblWorkAllocation.TimeSlotID = tblTimeSlot.TimeSlotID)"+
															"INNER JOIN tblRoom ON tblWorkAllocation.RoomID = tblRoom.RoomID) "+
															"INNER JOIN tblFloor ON tblWorkAllocation.FloorID = tblFloor.FloorID) "+
															"INNER JOIN tblCourse ON tblWorkAllocation.CourseID = tblCourse.CourseID) "+
															"INNER JOIN tblStaff ON tblWorkAllocation.StaffID = tblStaff.StaffID) "+
															"INNER JOIN tblSubject ON tblWorkAllocation.SubjectID = tblSubject.SubjectID "+
															"WHERE (tblWorkAllocation.CourseID="+String.valueOf(mCourseID)+" AND "+
															"(tblWorkAllocation.SemisterID="+String.valueOf(mSemisterID)+" AND "+
															"(tblWorkAllocation.SubjectID="+String.valueOf(mSubjectID)+" AND "+
															"(tblWorkAllocation.TimeSlotID="+String.valueOf(mTimeSlotID)+" AND "+
														    "(tblWorkAllocation.DayID="+String.valueOf(mDayID)+"AND"+
														   	"(tblWorkAllocation.SubjectTypeID="+String.valueOf(mSubjectTypeID)+" AND "+
														    "(tblWorkAllocation.FloorID="+String.valueOf(mFloorID)+" AND "+
														   	"(tblWorkAllocation.RoomID="+String.valueOf(mRoomID)+"))))))))";

		int Count =DBManager.getAllRecordsCount(Query);
		return(Count);
	}

	static ClsWorkAllocationDetail[] getAllWorkAllocationInformation(int mCourseID,int mSemisterID,int mSubjectID,int mTimeSlotID,int mDayID,int mSubjectTypeID,int mFloorID,int mRoomID)
	{
		int rec=getAllRecordsCount(mCourseID,mSemisterID,mSubjectID,mTimeSlotID,mDayID,mSubjectTypeID,mFloorID,mRoomID);
		ClsWorkAllocationDetail obj[]=new ClsWorkAllocationDetail[rec];

		String Query = "select tblWorkAllocation.WorkAllocationID, "+
								"tblWorkAllocation.TimeSlotID, "+
								"tblTimeSlot.TimeSlotName, "+
								"tblWorkAllocation.DayID, "+
								"tblWorkAllocation.SubjectTypeID, "+
								"tblWorkAllocation.RoomID, "+
								"tblRoom.RoomNumber, "+
								"tblWorkAllocation.FloorID, "+
								"tblFloor.FloorName, "+
								"tblWorkAllocation.CourseID, "+
								"tblCourse.CourseName, "+
								"tblWorkAllocation.StaffID, "+
								"tblStaff.StaffName, "+
								"tblWorkAllocation.SemisterID, "+
								"tblWorkAllocation.SubjectID, "+
								"tblSubject.SubjectName "+
								"FROM (((((tblWorkAllocation INNER JOIN tblTimeSlot ON tblWorkAllocation.TimeSlotID = tblTimeSlot.TimeSlotID)"+
															"INNER JOIN tblRoom ON tblWorkAllocation.RoomID = tblRoom.RoomID) "+
															"INNER JOIN tblFloor ON tblWorkAllocation.FloorID = tblFloor.FloorID) "+
															"INNER JOIN tblCourse ON tblWorkAllocation.CourseID = tblCourse.CourseID) "+
															"INNER JOIN tblStaff ON tblWorkAllocation.StaffID = tblStaff.StaffID) "+
															"INNER JOIN tblSubject ON tblWorkAllocation.SubjectID = tblSubject.SubjectID "+
															"WHERE (tblWorkAllocation.CourseID="+String.valueOf(mCourseID)+"AND"+
                                                            "(tblWorkAllocation.SemisterID="+String.valueOf(mSemisterID)+"AND"+
															"(tblWorkAllocation.SubjectID="+String.valueOf(mSubjectID)+" AND "+
														    "(tblWorkAllocation.TimeSlotID="+String.valueOf(mTimeSlotID)+" AND "+
                                                            "(tblWorkAllocation.DayID="+String.valueOf(mDayID)+"AND"+
														   	"(tblWorkAllocation.SubjectTypeID="+String.valueOf(mSubjectTypeID)+" AND "+
														    "(tblWorkAllocation.FloorID="+String.valueOf(mFloorID)+" AND "+
															"(tblWorkAllocation.RoomID="+String.valueOf(mRoomID)+"))))))))";

		String values[][]=DBManager.getAllFullRow(Query,rec,16);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsWorkAllocationDetail();
			obj[i].setWorkAllocationID(Integer.parseInt(values[i][0]));
            obj[i].setTimeSlotID(Integer.parseInt(values[i][1]));
            obj[i].setTimeSlotName(values[i][2]);
			obj[i].setDayID(Integer.parseInt(values[i][3]));
			obj[i].setSubjectTypeID(Integer.parseInt(values[i][4]));
			obj[i].setRoomID(Integer.parseInt(values[i][5]));
			obj[i].setRoomNumber(values[i][6]);
			obj[i].setFloorID(Integer.parseInt(values[i][7]));
			obj[i].setFloorName(values[i][8]);
			obj[i].setCourseID(Integer.parseInt(values[i][9]));
			obj[i].setCourseName(values[i][10]);
			obj[i].setStaffID(Integer.parseInt(values[i][11]));
			obj[i].setStaffName(values[i][12]);
			obj[i].setSemisterID(Integer.parseInt(values[i][13]));
			obj[i].setSubjectID(Integer.parseInt(values[i][14]));
			obj[i].setSubjectName(values[i][15]);

		}
		return(obj);
	}

    static int getAllRecordsCount(int mCourseID,int mSemisterID,int mSubjectID,int mTimeSlotID,int mDayID,int mSubjectTypeID,int mFloorID,int mRoomID,int mStaffID)
	{
		String Query = "select Count(tblWorkAllocation.WorkAllocationID) "+
								"FROM (((((tblWorkAllocation INNER JOIN tblTimeSlot ON tblWorkAllocation.TimeSlotID = tblTimeSlot.TimeSlotID)"+
															"INNER JOIN tblRoom ON tblWorkAllocation.RoomID = tblRoom.RoomID) "+
															"INNER JOIN tblFloor ON tblWorkAllocation.FloorID = tblFloor.FloorID) "+
															"INNER JOIN tblCourse ON tblWorkAllocation.CourseID = tblCourse.CourseID) "+
															"INNER JOIN tblStaff ON tblWorkAllocation.StaffID = tblStaff.StaffID) "+
															"INNER JOIN tblSubject ON tblWorkAllocation.SubjectID = tblSubject.SubjectID "+
															"WHERE (tblWorkAllocation.CourseID="+String.valueOf(mCourseID)+" AND "+
															"(tblWorkAllocation.SemisterID="+String.valueOf(mSemisterID)+" AND "+
															"(tblWorkAllocation.SubjectID="+String.valueOf(mSubjectID)+" AND "+
															"(tblWorkAllocation.TimeSlotID="+String.valueOf(mTimeSlotID)+" AND "+
														    "(tblWorkAllocation.DayID="+String.valueOf(mDayID)+"AND"+
														   	"(tblWorkAllocation.SubjectTypeID="+String.valueOf(mSubjectTypeID)+" AND "+
														    "(tblWorkAllocation.FloorID="+String.valueOf(mFloorID)+" AND "+
														   	"(tblWorkAllocation.RoomID="+String.valueOf(mRoomID)+" AND "+
														    "(tblWorkAllocation.StaffID="+String.valueOf(mStaffID)+")))))))))";

		int Count =DBManager.getAllRecordsCount(Query);
		return(Count);
	}

	static ClsWorkAllocationDetail[] getAllWorkAllocationInformation(int mCourseID,int mSemisterID,int mSubjectID,int mTimeSlotID,int mDayID,int mSubjectTypeID,int mFloorID,int mRoomID,int mStaffID)
	{
		int rec=getAllRecordsCount(mCourseID,mSemisterID,mSubjectID,mTimeSlotID,mDayID,mSubjectTypeID,mFloorID,mRoomID,mStaffID);
		ClsWorkAllocationDetail obj[]=new ClsWorkAllocationDetail[rec];

		String Query = "select tblWorkAllocation.WorkAllocationID, "+
								"tblWorkAllocation.TimeSlotID, "+
								"tblTimeSlot.TimeSlotName, "+
								"tblWorkAllocation.DayID, "+
								"tblWorkAllocation.SubjectTypeID, "+
								"tblWorkAllocation.RoomID, "+
								"tblRoom.RoomNumber, "+
								"tblWorkAllocation.FloorID, "+
								"tblFloor.FloorName, "+
								"tblWorkAllocation.CourseID, "+
								"tblCourse.CourseName, "+
								"tblWorkAllocation.StaffID, "+
								"tblStaff.StaffName, "+
								"tblWorkAllocation.SemisterID, "+
								"tblWorkAllocation.SubjectID, "+
								"tblSubject.SubjectName "+
								"FROM (((((tblWorkAllocation INNER JOIN tblTimeSlot ON tblWorkAllocation.TimeSlotID = tblTimeSlot.TimeSlotID)"+
															"INNER JOIN tblRoom ON tblWorkAllocation.RoomID = tblRoom.RoomID) "+
															"INNER JOIN tblFloor ON tblWorkAllocation.FloorID = tblFloor.FloorID) "+
															"INNER JOIN tblCourse ON tblWorkAllocation.CourseID = tblCourse.CourseID) "+
															"INNER JOIN tblStaff ON tblWorkAllocation.StaffID = tblStaff.StaffID) "+
															"INNER JOIN tblSubject ON tblWorkAllocation.SubjectID = tblSubject.SubjectID "+
															"WHERE (tblWorkAllocation.CourseID="+String.valueOf(mCourseID)+"AND"+
                                                            "(tblWorkAllocation.SemisterID="+String.valueOf(mSemisterID)+"AND"+
															"(tblWorkAllocation.SubjectID="+String.valueOf(mSubjectID)+" AND "+
														    "(tblWorkAllocation.TimeSlotID="+String.valueOf(mTimeSlotID)+" AND "+
                                                            "(tblWorkAllocation.DayID="+String.valueOf(mDayID)+"AND"+
														   	"(tblWorkAllocation.SubjectTypeID="+String.valueOf(mSubjectTypeID)+" AND "+
														    "(tblWorkAllocation.FloorID="+String.valueOf(mFloorID)+" AND "+
															"(tblWorkAllocation.RoomID="+String.valueOf(mRoomID)+" AND "+
														    "(tblWorkAllocation.StaffID="+String.valueOf(mStaffID)+")))))))))";

		String values[][]=DBManager.getAllFullRow(Query,rec,16);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsWorkAllocationDetail();
			obj[i].setWorkAllocationID(Integer.parseInt(values[i][0]));
            obj[i].setTimeSlotID(Integer.parseInt(values[i][1]));
            obj[i].setTimeSlotName(values[i][2]);
			obj[i].setDayID(Integer.parseInt(values[i][3]));
			obj[i].setSubjectTypeID(Integer.parseInt(values[i][4]));
			obj[i].setRoomID(Integer.parseInt(values[i][5]));
			obj[i].setRoomNumber(values[i][6]);
			obj[i].setFloorID(Integer.parseInt(values[i][7]));
			obj[i].setFloorName(values[i][8]);
			obj[i].setCourseID(Integer.parseInt(values[i][9]));
			obj[i].setCourseName(values[i][10]);
			obj[i].setStaffID(Integer.parseInt(values[i][11]));
			obj[i].setStaffName(values[i][12]);
			obj[i].setSemisterID(Integer.parseInt(values[i][13]));
			obj[i].setSubjectID(Integer.parseInt(values[i][14]));
			obj[i].setSubjectName(values[i][15]);

		}
		return(obj);
	}

	public static void main(String args[])
	{


	}


}

