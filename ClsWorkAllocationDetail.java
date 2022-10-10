import java.sql.*;
import javax.swing.*;
class ClsWorkAllocationDetail
{
	private int  WorkAllocationID ;
	private int  TimeSlotID ;
	private String TimeSlotName;
	private int  DayID ;
	private String DayName;
	private int  SubjectTypeID;
	private String SubjectTypeName;
    private int  RoomID;
	private String RoomNumber;
    private int  CourseID;
	private String CourseName;
    private int  StaffID;
	private String StaffName;
    private int  SemisterID;
    private int  SubjectID;
	private String SubjectName;
	private int FloorID;
	private String FloorName;


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

    void setTimeSlotName(String value)
	{
		TimeSlotName = value;
	}
	String getTimeSlotName()
	{
		return TimeSlotName;
	}

	void setDayID(int value)
	{
		DayID = value;
	}
	int getDayID()
	{
		return DayID;
	}
    void setDayName(String value)
	{
	    DayName = value;
	}
	String getDayName()
	{
		return DayName;
	}
    String getDayNameText()
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

	String getSubjectTypeName()
	{
		String SName = "Theory";
		if(SubjectTypeID==2)
		{
			SName = "Practical";
		}
		return(SName);
	}


    void setFloorID(int value)
	{
		FloorID = value;
	}
	int getFloorID()
	{
		return FloorID;
	}


    void setFloorName(String value)
	{
		FloorName = value;
	}
	String getFloorName()
	{
		return FloorName;
	}


    void setRoomID(int value)
	{
		RoomID = value;
	}
	int getRoomID()
	{
		return RoomID;
	}
    void setRoomNumber(String value)
	{
		RoomNumber = value;
	}
	String getRoomNumber()
	{
		return RoomNumber;
	}

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

    void setStaffID(int value)
	{
		StaffID = value;
	}
	int getStaffID()
	{
		return StaffID;
	}
    void setStaffName(String value)
	{
		StaffName = value;
	}
	String getStaffName()
	{
		return StaffName;
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
    void setSubjectName(String value)
	{
		SubjectName = value;
	}
	String getSubjectName()
	{
		return SubjectName;
	}

    static int getAllRecordsCount()
	{
		return(DlsWorkAllocationDetail.getAllRecordsCount());
	}


	static ClsWorkAllocationDetail[] getAllWorkAllocationInformation()
	{
		return(DlsWorkAllocationDetail.getAllWorkAllocationInformation());
	}

	static ClsWorkAllocationDetail[] getAllWorkAllocationInformation(int mCourseID)
	{
		return(DlsWorkAllocationDetail.getAllWorkAllocationInformation(mCourseID));
	}
    static ClsWorkAllocationDetail[] getAllWorkAllocationInformation(int mCourseID,int mSemisterID)
	{
		return(DlsWorkAllocationDetail.getAllWorkAllocationInformation(mCourseID,mSemisterID));
	}
    static ClsWorkAllocationDetail[] getAllWorkAllocationInformation(int mCourseID,int mSemisterID,int mSubjectID)
	{
		return(DlsWorkAllocationDetail.getAllWorkAllocationInformation(mCourseID,mSemisterID,mSubjectID));
	}
    static ClsWorkAllocationDetail[] getAllWorkAllocationInformation(int mCourseID,int mSemisterID,int mSubjectID,int mTimeSlotID)
	{
		return(DlsWorkAllocationDetail.getAllWorkAllocationInformation(mCourseID,mSemisterID,mSubjectID,mTimeSlotID));
	}
    static ClsWorkAllocationDetail[] getAllWorkAllocationInformation(int mCourseID,int mSemisterID,int mSubjectID,int mTimeSlotID,int mDayID)
	{
		return(DlsWorkAllocationDetail.getAllWorkAllocationInformation(mCourseID,mSemisterID,mSubjectID,mTimeSlotID,mDayID));
	}
    static ClsWorkAllocationDetail[] getAllWorkAllocationInformation(int mCourseID,int mSemisterID,int mSubjectID,int mTimeSlotID,int mDayID,int mSubjectTypeID)
	{
		return(DlsWorkAllocationDetail.getAllWorkAllocationInformation(mCourseID,mSemisterID,mSubjectID,mTimeSlotID,mDayID,mSubjectTypeID));
	}
    static ClsWorkAllocationDetail[] getAllWorkAllocationInformation(int mCourseID,int mSemisterID,int mSubjectID,int mTimeSlotID,int mDayID,int mSubjectTypeID,int mFloorID)
	{
		return(DlsWorkAllocationDetail.getAllWorkAllocationInformation(mCourseID,mSemisterID,mSubjectID,mTimeSlotID,mDayID,mSubjectTypeID,mFloorID));
	}
    static ClsWorkAllocationDetail[] getAllWorkAllocationInformation(int mCourseID,int mSemisterID,int mSubjectID,int mTimeSlotID,int mDayID,int mSubjectTypeID,int mFloorID,int mRoomID)
	{
		return(DlsWorkAllocationDetail.getAllWorkAllocationInformation(mCourseID,mSemisterID,mSubjectID,mTimeSlotID,mDayID,mSubjectTypeID,mFloorID,mRoomID));
	}
    static ClsWorkAllocationDetail[] getAllWorkAllocationInformation(int mCourseID,int mSemisterID,int mSubjectID,int mTimeSlotID,int mDayID,int mSubjectTypeID,int mFloorID,int mRoomID,int mStaffID)
	{
		return(DlsWorkAllocationDetail.getAllWorkAllocationInformation(mCourseID,mSemisterID,mSubjectID,mTimeSlotID,mDayID,mSubjectTypeID,mFloorID,mRoomID,mStaffID));
	}
	static void showWorkAllocationDetail(ClsWorkAllocationDetail temp)
	{
		System.out.println("WorkAllocationID             : ..........    "+temp.getWorkAllocationID());
		System.out.println("TimeSlotID                   : ..........    "+temp.getTimeSlotID());
        System.out.println("TimeSlotName                 : ..........    "+temp.getTimeSlotName());
		System.out.println("DayID                        : ..........    "+temp.getDayID());
		System.out.println("DayName                      : ..........    "+temp.getDayNameText());
		System.out.println("SubjectTypeID                : ..........    "+temp.getSubjectTypeID());
		System.out.println("SubjectTypeName              : ..........    "+temp.getSubjectTypeName());
		System.out.println("RoomID                       :...........    "+temp.getRoomID());
		System.out.println("RoomNumber                   : ..........    "+temp.getRoomNumber());
		System.out.println("CourseID                     : ..........    "+temp.getCourseID());
		System.out.println("CourseName                   : ..........    "+temp.getCourseName());
		System.out.println("StaffID                      : ..........    "+temp.getStaffID());
		System.out.println("StaffName                    : ..........    "+temp.getStaffName());
		System.out.println("SemisterID                   : ..........    "+temp.getSemisterID());
		System.out.println("SubjectID                    : ..........    "+temp.getSubjectID());
		System.out.println("SubjectName                  : ..........    "+temp.getSubjectName());
		System.out.println("FloorID                      : ..........    "+temp.getFloorID());
		System.out.println("FloorName                    : ..........    "+temp.getFloorName());

	}




	public static void main(String args[])
    {


	}
}
