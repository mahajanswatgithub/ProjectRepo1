package DBManage;
import java.sql.*;
import javax.swing.*;
import ProjectSetting.*;

public class DBManager
{
	public static void addNewRecord(String q)
	{
		LocalConnection.processRecord(q);
	}
	public static int getAllRecordsCount(String q)
 	{
		return(LocalConnection.processRecordForValue(q));
 	}

	public static int getCode(String q)
 	{
		return(LocalConnection.processRecordForValue(q));
	}

	public static String getName(String q)
 	{
		return(LocalConnection.processRecordForString(q));
	}

	public static String[] getAllRecords(String q,int rec)
	{
		return(LocalConnection.processRecordForStrings(q,rec));
	}

	public static String[] getFullRow(String q,int cols)
	{
		return(LocalConnection.processRecordForRow(q,cols));
	}
	public static String[][] getAllFullRow(String q,int rows,int cols)
	{
		return(LocalConnection.processRecordForAllRow(q,rows,cols));
	}
}




class LocalConnection
{
	static void processQuery(String q,boolean status)
	{
		String DNSValue=DNSConnection.getDNSValue();
		try
    	{
	    	String url="jdbc:odbc:"+DNSValue;
			if(!status)
				System.out.println("1. Process Started ...."+DNSValue);

			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			if(!status)
				System.out.println("2. Driver Loaded Properly....");

	    	Connection con=DriverManager.getConnection(url);
			if(!status)
				System.out.println("3. Connection Eshtablished....");

			Statement stmt=con.createStatement();
			if(!status)
				System.out.println("4. Statement Created....");
			boolean ans=stmt.execute(q);
			if(!status)
			{
				if(ans)
				{
					System.out.println("5. Query Executed Properly....");
				}
				else
				{
					System.out.println("6. Something Wrong ....");
				}
			}
			con.close();
			if(!status)
				System.out.println("7. Connection Closed....");

		}
		catch(SQLException e)
    	{

			if(!status)
				System.out.println("SQL Exception while processing ....[ "+q+" ]"+e);
			else
				System.out.println("SQL Exception while processing ...."+e);
		}
		catch(ClassNotFoundException e)
		{
			if(!status)
				System.out.println("ClassNotFoundException whiie processing ....[ "+q+" ]"+e);
			else
				System.out.println("ClassNotFoundException while processing ...."+e);
		}
	}


	static int processQueryForValue(String q,boolean status)
	{
		int value=0;
		String DNSValue=DNSConnection.getDNSValue();
		try
    	{
	    	String url="jdbc:odbc:"+DNSValue;
			if(!status)
				System.out.println("1. Process Started ...."+DNSValue);

			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			if(!status)
				System.out.println("2. Driver Loaded Properly....");

	    	Connection con=DriverManager.getConnection(url);
			if(!status)
				System.out.println("3. Connection Eshtablished....");

			Statement stmt=con.createStatement();
			if(!status)
				System.out.println("4. Statement Created....");


 			ResultSet rs=stmt.executeQuery(q);
			if(rs.next())
			{
				value=rs.getInt(1);
			}


			if(!status)
			{
				System.out.println("5. Something Wrong ....");
			}
			con.close();
			if(!status)
				System.out.println("7. Connection Closed....");

		}
		catch(SQLException e)
    	{
			if(!status)
				System.out.println("SQL Exception while processing ....[ "+q+" ]"+e);
			else
				System.out.println("SQL Exception while processing ...."+e);
		}
		catch(ClassNotFoundException e)
		{
			if(!status)
				System.out.println("ClassNotFoundException whiie processing ....[ "+q+" ]"+e);
			else
				System.out.println("ClassNotFoundException while processing ...."+e);
		}

		return(value);
	}


	static String processQueryForString(String q,boolean status)
	{
		String value="";
		String DNSValue=DNSConnection.getDNSValue();
		try
    	{
	    	String url="jdbc:odbc:"+DNSValue;
			if(!status)
				System.out.println("1. Process Started ...."+DNSValue);

			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			if(!status)
				System.out.println("2. Driver Loaded Properly....");

	    	Connection con=DriverManager.getConnection(url);
			if(!status)
				System.out.println("3. Connection Eshtablished....");

			Statement stmt=con.createStatement();
			if(!status)
				System.out.println("4. Statement Created....");


 			ResultSet rs=stmt.executeQuery(q);
			if(rs.next())
			{
				value=rs.getString(1);
			}


			if(!status)
			{
				System.out.println("5. Something Wrong ....");
			}
			con.close();
			if(!status)
				System.out.println("7. Connection Closed....");

		}
		catch(SQLException e)
    	{
			if(!status)
				System.out.println("SQL Exception while processing ....[ "+q+" ]"+e);
			else
				System.out.println("SQL Exception while processing ...."+e);
		}
		catch(ClassNotFoundException e)
		{
			if(!status)
				System.out.println("ClassNotFoundException whiie processing ....[ "+q+" ]"+e);
			else
				System.out.println("ClassNotFoundException while processing ...."+e);
		}

		return(value);
	}



	static String[] processQueryForStrings(String q,int r,boolean status)
	{
		String data[]=new String [r];

		String DNSValue=DNSConnection.getDNSValue();
		try
    	{
	    	String url="jdbc:odbc:"+DNSValue;
			if(!status)
				System.out.println("1. Process Started ...."+DNSValue);

			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			if(!status)
				System.out.println("2. Driver Loaded Properly....");

	    	Connection con=DriverManager.getConnection(url);
			if(!status)
				System.out.println("3. Connection Eshtablished....");

			Statement stmt=con.createStatement();
			if(!status)
				System.out.println("4. Statement Created....");


 			ResultSet rs=stmt.executeQuery(q);
         	int index=0;
 			while(rs.next())
 			{
 				data[index]=rs.getString(1);
 				index++;
 	    	}


			if(!status)
			{
				System.out.println("5. Something Wrong ....");
			}
			con.close();
			if(!status)
				System.out.println("7. Connection Closed....");

		}
		catch(SQLException e)
    	{
			if(!status)
				System.out.println("SQL Exception while processing ....[ "+q+" ]"+e);
			else
				System.out.println("SQL Exception while processing ...."+e);
		}
		catch(ClassNotFoundException e)
		{
			if(!status)
				System.out.println("ClassNotFoundException whiie processing ....[ "+q+" ]"+e);
			else
				System.out.println("ClassNotFoundException while processing ...."+e);
		}

		return(data);
	}


	static String[] processQueryForRow(String q,int r,boolean status)
	{
		String data[]=new String [r];

		String DNSValue=DNSConnection.getDNSValue();
		try
    	{
	    	String url="jdbc:odbc:"+DNSValue;
			if(!status)
				System.out.println("1. Process Started ...."+DNSValue);

			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			if(!status)
				System.out.println("2. Driver Loaded Properly....");

	    	Connection con=DriverManager.getConnection(url);
			if(!status)
				System.out.println("3. Connection Eshtablished....");

			Statement stmt=con.createStatement();
			if(!status)
				System.out.println("4. Statement Created....");


 			ResultSet rs=stmt.executeQuery(q);

 			if(rs.next())
 			{
         		int index=0;
         		int rn=1;
 				while(rn<=r)
 				{
 					data[index]=(String)rs.getString(rn);
 					index++;
 					rn++;
 	    		}
			}

			if(!status)
			{
				System.out.println("5. Something Wrong ....");
			}
			con.close();
			if(!status)
				System.out.println("7. Connection Closed....");

		}
		catch(SQLException e)
    	{
			if(!status)
				System.out.println("SQL Exception while processing ....[ "+q+" ]"+e);
			else
				System.out.println("SQL Exception while processing ...."+e);
		}
		catch(ClassNotFoundException e)
		{
			if(!status)
				System.out.println("ClassNotFoundException whiie processing ....[ "+q+" ]"+e);
			else
				System.out.println("ClassNotFoundException while processing ...."+e);
		}

		return(data);
	}




	static String[][] processQueryForAllRow(String q,int rows,int cols,boolean status)
	{
				String data[][]=new String [rows][cols];

		String DNSValue=DNSConnection.getDNSValue();
		try
    	{
	    	String url="jdbc:odbc:"+DNSValue;
			if(!status)
				System.out.println("1. Process Started ...."+DNSValue);

			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			if(!status)
				System.out.println("2. Driver Loaded Properly....");

	    	Connection con=DriverManager.getConnection(url);
			if(!status)
				System.out.println("3. Connection Eshtablished....");

			Statement stmt=con.createStatement();
			if(!status)
				System.out.println("4. Statement Created....");


 			ResultSet rs=stmt.executeQuery(q);

 			int i=0;
 			while(rs.next())
 			{
				for(int j=0;j<cols;j++)
				{
						String temp1=rs.getString(j+1);
						data[i][j]=temp1;
				}
				i++;
			}

			System.out.println("End");

			if(!status)
			{
				System.out.println("5. Something Wrong ....");
			}
			con.close();
			if(!status)
				System.out.println("7. Connection Closed....");

		}
		catch(SQLException e)
    	{
			if(!status)
				System.out.println("SQL Exception while processing ....[ "+q+" ]"+e);
			else
				System.out.println("SQL Exception while processing ...."+e);
		}
		catch(ClassNotFoundException e)
		{
			if(!status)
				System.out.println("ClassNotFoundException whiie processing ....[ "+q+" ]"+e);
			else
				System.out.println("ClassNotFoundException while processing ...."+e);
		}

		return(data);
	}



	static void processRecord(String q)
	{
		boolean status=true;
		processQuery(q,status);
	}
	static void processRecord(String q,boolean status)
	{
		processQuery(q,status);
	}

	static int processRecordForValue(String q)
	{
		boolean status=true;
		return(processQueryForValue(q,status));
	}
	static int processRecordForValue(String q,boolean status)
	{
		return(processQueryForValue(q,status));
	}

	static String processRecordForString(String q)
	{
		boolean status=true;
		return(processQueryForString(q,status));
	}
	static String processRecordForString(String q,boolean status)
	{
		return(processQueryForString(q,status));
	}


	static String[] processRecordForStrings(String q,int r)
	{
		boolean status=true;
		return(processQueryForStrings(q,r,status));
	}
	static String[] processRecordForStrings(String q,int r,boolean status)
	{
		return(processQueryForStrings(q,r,status));
	}

	static String[] processRecordForRow(String q,int c)
	{
		boolean status=true;
		return(processQueryForRow(q,c,status));
	}
	static String[] processRecordForRow(String q,int c,boolean status)
	{
		return(processQueryForRow(q,c,status));
	}
	static String[][] processRecordForAllRow(String q,int r,int c)
	{
		boolean status=true;
		return(processQueryForAllRow(q,r,c,status));
	}
	static String[][] processRecordForAllRow(String q,int r,int c,boolean status)
	{
		return(processQueryForAllRow(q,r,c,status));
	}
}



class DNSConnection
{
	static String getDNSValue()
	{
		return("DSNEasyTasika");
	}
}

