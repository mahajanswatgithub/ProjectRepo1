// Latest updated on 6 March 2018
package myUtility;
public class ButtonState
{
	public  int btnState;
	public  int btnUniqueState;
	public  int btnCommonState;
	public static int InitialState=0;
	public static int NewState=1;
	public static int ViewState=2;
	public static int EditState=3;
	public static int DeleteState=4;
	public static int CancelState=5;
	public static int ReportState=6;
	public static int SaveState=7;
	public static int UpdateState=8;
	public static int ApplyState=9;
	public static int ResetState=0;
	public static int CloseReportState=10;

	public ButtonState()
	{
		btnState=0;
		btnUniqueState=0;
		btnCommonState=0;
	}
	public  void setButtonState(int value)
	{
		btnState=value;
	}

	public  int  getButtonState()
	{
		return(btnState);
	}

	public  void setButtonUniqueState(int value)
	{
		btnUniqueState=value;
	}

	public  int  getButtonUniqueState()
	{
		return(btnUniqueState);
	}
	public  void setButtonCommonState(int value)
	{
		btnCommonState=value;
	}

	public  int  getButtonCommonState()
	{
		return(btnCommonState);
	}
}