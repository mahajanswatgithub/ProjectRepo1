import java.sql.*;
import javax.swing.*;

class ClsBatchSlot
{
	private int  BatchSlotID ;
	private String BatchSlotName;
	private int BatchStudents;
	private int CourseID;

	void setBatchSlotID(int value)
	{
		BatchSlotID = value;
	}
	int getBatchSlotID()
	{
		return BatchSlotID;
	}

	void setBatchSlotName(String value)
	{
		BatchSlotName = value;
	}
	String getBatchSlotName()
	{
		return BatchSlotName;
	}
	void setBatchStudents(int value)
	{
		BatchStudents = value;
	}
	int getBatchStudents()
	{
		return BatchStudents;
	}

	void setCourseID(int value)
	{
		CourseID = value;
	}
	int getCourseID()
	{
		return CourseID;
	}

	static void addNewRecord(ClsBatchSlot temp)
	{
		DlsBatchSlot.addNewRecord(temp);
	}

	static void updateRecord(ClsBatchSlot temp)
	{
		DlsBatchSlot.updateRecord(temp);
	}

	static void deleteRecord(ClsBatchSlot temp)
	{
		DlsBatchSlot.deleteRecord(temp);
	}

	static int getBatchSlotIDFromName(String mBatchSlotName)
	{
		return(DlsBatchSlot.getBatchSlotIDFromName(mBatchSlotName));
	}

	static String getBatchSlotNameFromID(int mBatchSlotID)
	{
		return(DlsBatchSlot.getBatchSlotNameFromID(mBatchSlotID));
	}

	static int getAllRecordsCount()
	{
		return(DlsBatchSlot.getAllRecordsCount());
	}

	static int getAllRecordsCount(int mCourseID)
	{
		return(DlsBatchSlot.getAllRecordsCount(mCourseID));
	}

	static String[] getAllBatchSlotRecords()
	{
		return(DlsBatchSlot.getAllBatchSlotRecords());
	}

	static String[] getAllBatchSlotRecords(int mCourseID)
	{
		return(DlsBatchSlot.getAllBatchSlotRecords(mCourseID));
	}

	static ClsBatchSlot getBatchSlotInformation(int mBatchSlotID)
	{
		return(DlsBatchSlot.getBatchSlotInformation(mBatchSlotID));
	}

	static ClsBatchSlot[] getAllBatchSlotInformation()
	{
		return(DlsBatchSlot.getAllBatchSlotInformation());
	}


	static ClsBatchSlot[] getAllBatchSlotInformation(int mBatchSlotID)
	{
		return(DlsBatchSlot.getAllBatchSlotInformation(mBatchSlotID));
	}





	static void showBatchSlot(ClsBatchSlot temp)
	{
		System.out.println("BatchSlot ID             : ..........    "+temp.getBatchSlotID());
		System.out.println("BatchSlot Name           : ..........    "+temp.getBatchSlotName());
		System.out.println("BatchStudents    : ..........    "+temp.getBatchStudents());
		System.out.println("Course Id           : ..........    "+temp.getCourseID());

	}

	static void addBatchSlotRecords(JComboBox cmbProcess,int mCourseID)
	{
		String Query = "select BatchSlotName from tblBatchSlot where CourseID ="+String.valueOf(mCourseID);
		String data[]=getAllBatchSlotRecords(mCourseID);
		cmbProcess.removeAllItems();
		cmbProcess.addItem("Select BatchSlot ...");
		for(String item : data)
		{
			cmbProcess.addItem(item);
		}
	}


	static void addBatchSlotRecords(JComboBox cmbProcess)
	{
		String Query = "select BatchSlotName from tblBatchSlot order by BatchSlotName";
		String data[]=getAllBatchSlotRecords();
		cmbProcess.removeAllItems();
		cmbProcess.addItem("Select BatchSlot ...");
		for(String item : data)
		{
			cmbProcess.addItem(item);
		}
	}


	public static void main(String args[])
	{
		//ClsBatchSlot.addBatchSlotRecords(cmbProcess,10);


	}
}
