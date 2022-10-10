import java.sql.*;
import javax.swing.*;
class ClsWorkAllocation
{
	private int  WorkAllocationID ;
    private int  TimeSlotID;
    private int  DayID;
    private int  SubjectTypeID;
    private int  FloorID;
    private int  RoomID;
    private int  CourseID;
    private int  StaffID;
    private int  SemisterID;
    private int  SubjectID;

	void setWorkAllocationID(int value)
	{
		WorkAllocationID = value;
	}
	int getWorkAllocationID()
	{
		return WorkAllocationID;
	}
	void setTimeSlotID(int value)
	{
		TimeSlotID = value;
	}
	int getTimeSlotID()
	{
		return TimeSlotID;
	}
	void setDayID(int value)
	{
		DayID = value;
	}
	int getDayID()
	{
		return DayID;
	}

	String getDayIDName()
	{
		String dn[]={"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};
		return dn[DayID-1];
	}
	void setSubjectTypeID(int value)
	{
		SubjectTypeID = value;
	}
	int getSubjectTypeID()
	{
		return SubjectTypeID;
	}
	String getSubjectTypeIDName()
	{
		String s = "Thoery";
		if(SubjectTypeID==2)
			s = "Practical";
		return(s);
	}
	void setFloorID(int value)
	{
		FloorID = value;
	}
	int getFloorID()
	{
		return FloorID;
	}
    void setRoomID(int value)
	{
		RoomID = value;
	}
	int getRoomID()
	{
		return RoomID;
	}
	void setCourseID(int value)
	{
		CourseID = value;
	}
	int getCourseID()
	{
		return CourseID;
	}
    void setStaffID(int value)
	{
		StaffID = value;
	}
	int getStaffID()
	{
		return StaffID;
	}
    void setSemisterID(int value)
	{
		SemisterID = value;
	}
	int getSemisterID()
	{
		return SemisterID;
	}
    void setSubjectID(int value)
	{
		SubjectID = value;
	}
	int getSubjectID()
	{
		return SubjectID;
	}

	static void addNewRecord(ClsWorkAllocation temp)
	{
		DlsWorkAllocation.addNewRecord(temp);
	}

	static void updateRecord(ClsWorkAllocation temp)
	{
		DlsWorkAllocation.updateRecord(temp);
	}

	static void deleteRecord(ClsWorkAllocation temp)
	{
		DlsWorkAllocation.deleteRecord(temp);
	}

	/*static int getCourseIDFromName(String mCourseName)
	{
		return(DlsWorkAllocation.getCourseIDFromName(mCourseName));
	}
	static String getCourseNameFromID(int mCourseID)
	{
		return(DlsWorkAllocation.getCourseNameFromID(mCourseID));
	}*/
	static ClsWorkAllocation getWorkAllocationInformation(int mWorkAllocationID)
	{
		return(DlsWorkAllocation.getWorkAllocationInformation(mWorkAllocationID));
	}

	static void showCourse(ClsWorkAllocation  temp)
	{
		System.out.println("WorkAllocationID               : ..........    "+temp.getWorkAllocationID());
		System.out.println("TimeSlotID              : ..........    "+temp.getTimeSlotID());
		System.out.println("DayID                   : ..........    "+temp.getDayID());
		System.out.println("SubjectTypeID           : ..........    "+temp.getSubjectTypeID());
		System.out.println("FloorID                 : ..........    "+temp.getFloorID());
		System.out.println("RoomID                  : ..........    "+temp.getRoomID());
		System.out.println("CourseID                : ..........    "+temp.getCourseID());
		System.out.println("StaffID                 : ..........    "+temp.getStaffID());
		System.out.println("SemisterID              : ..........    "+temp.getSemisterID());
		System.out.println("SubjectID               : ..........    "+temp.getSubjectID());

	}

	static int getAllRecordsCount()
	{
		return(DlsWorkAllocation.getAllRecordsCount());
	}


	static ClsWorkAllocation[] getAllWorkAllocationInformation()
	{
		return(DlsWorkAllocation.getAllWorkAllocationInformation());
	}


	static int getAllRecordsCount(int vCourseID)
	{
		return(DlsWorkAllocation.getAllRecordsCount(vCourseID));

	}

	static ClsWorkAllocation[] getAllWorkAllocationInformation(int vCourseID)
	{
		return(DlsWorkAllocation.getAllWorkAllocationInformation(vCourseID));
	}


	static int getAllRecordsCount(int mCourseID,int mSemisterID)
	{
		return(DlsWorkAllocation.getAllRecordsCount(mCourseID,mSemisterID));

	}

	static ClsWorkAllocation[] getAllWorkAllocationInformation(int mCourseID,int mSemisterID)
	{
		return(DlsWorkAllocation.getAllWorkAllocationInformation(mCourseID,mSemisterID));
	}

    static int getAllRecordsCount(int mCourseID,int mSemisterID,int mSubjectID)
	{
		return(DlsWorkAllocation.getAllRecordsCount(mCourseID,mSemisterID,mSubjectID));

	}

	static ClsWorkAllocation[] getAllWorkAllocationInformation(int mCourseID,int mSemisterID,int mSubjectID)
	{
		return(DlsWorkAllocation.getAllWorkAllocationInformation(mCourseID,mSemisterID,mSubjectID));
	}

    static int getAllRecordsCount(int mCourseID,int mSemisterID,int mSubjectID,int mTimeSlotID)
	{
		return(DlsWorkAllocation.getAllRecordsCount(mCourseID,mSemisterID,mSubjectID,mTimeSlotID));

	}

	static ClsWorkAllocation[] getAllWorkAllocationInformation(int mCourseID,int mSemisterID,int mSubjectID,int mTimeSlotID)
	{
		return(DlsWorkAllocation.getAllWorkAllocationInformation(mCourseID,mSemisterID,mSubjectID,mTimeSlotID));
	}
    static int getAllRecordsCount(int mCourseID,int mSemisterID,int mSubjectID,int mTimeSlotID,int mDayID)
 	{
		return(DlsWorkAllocation.getAllRecordsCount(mCourseID,mSemisterID,mSubjectID,mTimeSlotID,mDayID));

	}
	static ClsWorkAllocation[] getAllWorkAllocationInformation(int mCourseID,int mSemisterID,int mSubjectID,int mTimeSlotID,int mDayID)
	{
		return(DlsWorkAllocation.getAllWorkAllocationInformation(mCourseID,mSemisterID,mSubjectID,mTimeSlotID,mDayID));
	}

    static int getAllRecordsCount(int mCourseID,int mSemisterID,int mSubjectID,int mTimeSlotID,int mDayID,int mSubjectTypeID)
 	{
		return(DlsWorkAllocation.getAllRecordsCount(mCourseID,mSemisterID,mSubjectID,mTimeSlotID,mDayID,mSubjectTypeID));

	}
	static ClsWorkAllocation[] getAllWorkAllocationInformation(int mCourseID,int mSemisterID,int mSubjectID,int mTimeSlotID,int mDayID,int mSubjectTypeID)
	{
		return(DlsWorkAllocation.getAllWorkAllocationInformation(mCourseID,mSemisterID,mSubjectID,mTimeSlotID,mDayID,mSubjectTypeID));
	}

    static int getAllRecordsCountSubjectWise(int mCourseID,int mSemisterID,int mTimeSlotID,int mDayID,int mSubjectTypeID)
 	{
		return(DlsWorkAllocation.getAllRecordsCountSubjectWise(mCourseID,mSemisterID,mTimeSlotID,mDayID,mSubjectTypeID));

	}
	static ClsWorkAllocation[] getAllWorkAllocationInformationSubjectWise(int mCourseID,int mSemisterID,int mTimeSlotID,int mDayID,int mSubjectTypeID)
	{
		return(DlsWorkAllocation.getAllWorkAllocationInformationSubjectWise(mCourseID,mSemisterID,mTimeSlotID,mDayID,mSubjectTypeID));
	}

    static int getAllRecordsCount(int mCourseID,int mSemisterID,int mSubjectID,int mTimeSlotID,int mDayID,int mSubjectTypeID,int mFloorID)
 	{
		return(DlsWorkAllocation.getAllRecordsCount(mCourseID,mSemisterID,mSubjectID,mTimeSlotID,mDayID,mSubjectTypeID,mFloorID));

	}
	static ClsWorkAllocation[] getAllWorkAllocationInformation(int mCourseID,int mSemisterID,int mSubjectID,int mTimeSlotID,int mDayID,int mSubjectTypeID,int mFloorID)
	{
		return(DlsWorkAllocation.getAllWorkAllocationInformation(mCourseID,mSemisterID,mSubjectID,mTimeSlotID,mDayID,mSubjectTypeID,mFloorID));
	}

    static int getAllRecordsCount(int mCourseID,int mSemisterID,int mSubjectID,int mTimeSlotID,int mDayID,int mSubjectTypeID,int mFloorID,int mRoomID)
 	{
		return(DlsWorkAllocation.getAllRecordsCount(mCourseID,mSemisterID,mSubjectID,mTimeSlotID,mDayID,mSubjectTypeID,mFloorID,mRoomID));

	}
	static ClsWorkAllocation[] getAllWorkAllocationInformation(int mCourseID,int mSemisterID,int mSubjectID,int mTimeSlotID,int mDayID,int mSubjectTypeID,int mFloorID,int mRoomID)
	{
		return(DlsWorkAllocation.getAllWorkAllocationInformation(mCourseID,mSemisterID,mSubjectID,mTimeSlotID,mDayID,mSubjectTypeID,mFloorID,mRoomID));
	}

    static int getAllRecordsCount(int mCourseID,int mSemisterID,int mSubjectID,int mTimeSlotID,int mDayID,int mSubjectTypeID,int mFloorID,int mRoomID,int mStaffID)
 	{
		return(DlsWorkAllocation.getAllRecordsCount(mCourseID,mSemisterID,mSubjectID,mTimeSlotID,mDayID,mSubjectTypeID,mFloorID,mRoomID,mStaffID));

	}
	static ClsWorkAllocation[] getAllWorkAllocationInformation(int mCourseID,int mSemisterID,int mSubjectID,int mTimeSlotID,int mDayID,int mSubjectTypeID,int mFloorID,int mRoomID,int mStaffID)
	{
		return(DlsWorkAllocation.getAllWorkAllocationInformation(mCourseID,mSemisterID,mSubjectID,mTimeSlotID,mDayID,mSubjectTypeID,mFloorID,mRoomID,mStaffID));
	}
	/*static String[] getAllWorkAllocationRecords()
	{
		return(DlsWorkAllocation.getAllWorkAllocationRecords());
	}*/

	/*static void addWorkAllocationRecords(JComboBox cmbProcess)
	{
		String Query = "select CourseName from tblCourse order by CourseName";
		String data[]=getAllCourseRecords();
		cmbProcess.removeAllItems();
		cmbProcess.addItem("Select Course  ...");
		for(String item : data)
		{
			cmbProcess.addItem(item);
		}
	}*/

	public static void main(String args[])
	{
		System.out.println(getAllRecordsCount());

		ClsWorkAllocation A = new ClsWorkAllocation();
		/*A.setCourseID(1);
		A.setCourseName("JHJ");
		A.setCoursePattern(21);
		A.setCourseDuration(21);
		A.setCourseCapacity(12);
		A.setCourseStartYear(23);
		ClsWorkAllocation.deleteRecord(A);*/
	}
}