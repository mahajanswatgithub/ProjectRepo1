import java.io.*;
import DBManage.*;
import java.sql.*;
import myUtility.*;
import javax.swing.*;

class DlsUse
{
	static void addNewRecord(ClsUse temp)
	{
		String Q = "insert into tblUse(UseName)values('"+temp.getUseName()+"')";
		DBManager.addNewRecord(Q);
		JOptionPane.showMessageDialog(null,"Record Is Inserted Successfully .... ");
	}


	static void updateRecord(ClsUse temp)
	{
		String Q = "update tblUse set UseName='"+temp.getUseName()+"' where UseID ="+String.valueOf(temp.getUseID());
		DBManager.addNewRecord(Q);
		JOptionPane.showMessageDialog(null,"Record Is Updated Successfully .... ");
	}

	static void deleteRecord(ClsUse temp)
	{
		String Q = "delete from tblUse  where UseID="+temp.getUseID();
		DBManager.addNewRecord(Q);
		JOptionPane.showMessageDialog(null,"Record Is Deleted Successfully .... ");
	}

	static int getUseIDFromName(String mUseName)
	{
		String Q = "select UseID from tblUse where UseName='"+mUseName+"'";
		return(DBManager.getCode(Q));
	}


	static String getUseNameFromID(int mUseID)
	{
		String Q = "select UseName from tblUse where UseID="+String.valueOf(mUseID);
		return(DBManager.getName(Q));
	}


	static int getAllRecordsCount()
	{
		String s="Select Count(*) from tblUse";
		int Count =DBManager.getAllRecordsCount(s);
		return(Count);
	}


	static String[] getAllUseRecords()
	{
		String Q="Select UseName from tblUse";
		int rec=getAllRecordsCount();
		return(DBManager.getAllRecords(Q,rec));
	}



	static ClsUse getUseInformation(int mUseID)
	{
		ClsUse temp = new ClsUse();
		String Q = "select * from tblUse where UseID="+String.valueOf(mUseID);
		String values[]=DBManager.getFullRow(Q,2);
		temp.setUseID(Integer.parseInt(values[0]));
		temp.setUseName(values[1]);
		return(temp);
	}


	static ClsUse[] getAllUseInformation()
	{
		int rec=getAllRecordsCount();
		ClsUse obj[]=new ClsUse[rec];
		String Query ="select * from tblUse";
		String values[][]=DBManager.getAllFullRow(Query,rec,2);
		for(int i=0;i<rec;i++)
		{
			obj[i]=new ClsUse();
			obj[i].setUseID(Integer.parseInt(values[i][0]));
			obj[i].setUseName(values[i][1]);
		}
		return(obj);
	}



	public static void main(String args[])
	{
	}

}

