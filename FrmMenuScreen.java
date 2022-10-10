import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import timescreen.*;
import HtmlSetting.HtmlStyle;
import myUtility.*;
import javax.swing.border.*;
import DBReport.*;
import InputRestriction.*;

class FrmMenuScreen extends JFrame implements ActionListener
{
	//int w = 3020;

	JPanel pnlData;
	JPanel pnlEntry;
	JPanel pnlMenu;
	JPanel pnlMenu1;
	JPanel pnlMenu2;
	JPanel pnlMenu3;
	JPanel pnlMenu4;
	JPanel pnlMenu5;
	JPanel pnlMenu6;
	JPanel pnlMenu7;
	JPanel pnlMenu8;
	JPanel pnlMenu9;
	//JLabel lblProgrammeHeading;

	JPanel pnlReportMenu;
	JPanel pnlReportMenu1;
	JPanel pnlReportMenu2;
    JPanel pnlReportMenu3;
    JPanel pnlReportMenu4;
    JPanel pnlReportMenu5;
    JPanel pnlReportMenu6;
    JPanel pnlReportMenu7;
    JPanel pnlReportMenu8;
    JPanel pnlReportMenu9;

	JButton btnMenu;
	JButton btnMenu1;
	JButton btnMenu2;
	JButton btnMenu3;
	JButton btnMenu4;
	JButton btnMenu5;
	JButton btnMenu6;
	JButton btnMenu7;
    JButton btnMenu8;
    JButton btnMenu9;

    JButton btnReportMenu;
    JButton btnReportMenu1;
    JButton btnReportMenu2;
    JButton btnReportMenu3;
    JButton btnReportMenu4;
    JButton btnReportMenu5;
    JButton btnReportMenu6;
    JButton btnReportMenu7;
    JButton btnReportMenu8;
    JButton btnReportMenu9;

	MainMenuScreen MS;

	FrmMenuScreen()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();



		setSize(screenSize.width,screenSize.height);
		MS = new MainMenuScreen();
		add(MS);

        pnlEntry=MS.getEntryPanel();
        pnlData=MS.getDataPanel();


        int x=10;
        int y=10;
        int gap=10;
        int h=60;
        int w=200;

        pnlMenu = new JPanel();
		pnlMenu.setLayout(new GridLayout(1,1));
        pnlMenu.setBounds(10,y,w,h);
        pnlData.add(pnlMenu);
        btnMenu=new JButton("Menu");
        pnlMenu.add(btnMenu);

        y=y+h+gap;
        pnlMenu1 = new JPanel();
		pnlMenu1.setLayout(new GridLayout(1,1));
        pnlMenu1.setBounds(10,y,w,h);
        pnlData.add(pnlMenu1);
        btnMenu1=new JButton("Use");
        pnlMenu1.add(btnMenu1);

		y=y+h+gap;
		pnlMenu2 = new JPanel();
		pnlMenu2.setLayout(new GridLayout(1,1));
		pnlMenu2.setBounds(10,y,w,h);
		pnlData.add(pnlMenu2);
		btnMenu2=new JButton("TimeSlot");
		pnlMenu2.add(btnMenu2);

        y=y+h+gap;
		pnlMenu3 = new JPanel();
		pnlMenu3.setLayout(new GridLayout(1,1));
		pnlMenu3.setBounds(10,y,w,h);
		pnlData.add(pnlMenu3);
		btnMenu3=new JButton("BatchSlot");
		pnlMenu3.add(btnMenu3);

        y=y+h+gap;
		pnlMenu4 = new JPanel();
		pnlMenu4.setLayout(new GridLayout(1,1));
		pnlMenu4.setBounds(10,y,w,h);
		pnlData.add(pnlMenu4);
		btnMenu4=new JButton("Room");
		pnlMenu4.add(btnMenu4);

        y=y+h+gap;
		pnlMenu5 = new JPanel();
		pnlMenu5.setLayout(new GridLayout(1,1));
		pnlMenu5.setBounds(10,y,w,h);
		pnlData.add(pnlMenu5);
		btnMenu5=new JButton("Course");
		pnlMenu5.add(btnMenu5);

        y=y+h+gap;
		pnlMenu6 = new JPanel();
		pnlMenu6.setLayout(new GridLayout(1,1));
		pnlMenu6.setBounds(10,y,w,h);
		pnlData.add(pnlMenu6);
		btnMenu6=new JButton("Level");
		pnlMenu6.add(btnMenu6);

        y=y+h+gap;
		pnlMenu7 = new JPanel();
		pnlMenu7.setLayout(new GridLayout(1,1));
		pnlMenu7.setBounds(10,y,w,h);
		pnlData.add(pnlMenu7);
		btnMenu7=new JButton("Staff");
		pnlMenu7.add(btnMenu7);

        y=y+h+gap;
		pnlMenu8 = new JPanel();
		pnlMenu8.setLayout(new GridLayout(1,1));
		pnlMenu8.setBounds(10,y,w,h);
		pnlData.add(pnlMenu8);
		btnMenu8=new JButton("Subject");
		pnlMenu8.add(btnMenu8);

        int x1=1190;
        int y1=10;

        pnlReportMenu = new JPanel();
		pnlReportMenu.setLayout(new GridLayout(1,1));
        pnlReportMenu.setBounds(x1,y1,w,h);
        pnlData.add(pnlReportMenu);
        btnReportMenu = new JButton("Report");
        pnlReportMenu.add(btnReportMenu);

        y1=y1+h+gap;
        pnlReportMenu1 = new JPanel();
		pnlReportMenu1.setLayout(new GridLayout(1,1));
        pnlReportMenu1.setBounds(x1,y1,w,h);
        pnlData.add(pnlReportMenu1);
        btnReportMenu1 = new JButton("Use");
        pnlReportMenu1.add(btnReportMenu1);

        y1=y1+h+gap;
        pnlReportMenu2 = new JPanel();
		pnlReportMenu2.setLayout(new GridLayout(1,1));
        pnlReportMenu2.setBounds(x1,y1,w,h);
        pnlData.add(pnlReportMenu2);
        btnReportMenu2 = new JButton("TimeSlot");
        pnlReportMenu2.add(btnReportMenu2);

        y1=y1+h+gap;
        pnlReportMenu3 = new JPanel();
		pnlReportMenu3.setLayout(new GridLayout(1,1));
        pnlReportMenu3.setBounds(x1,y1,w,h);
        pnlData.add(pnlReportMenu3);
        btnReportMenu3 = new JButton("BatchSlot");
        pnlReportMenu3.add(btnReportMenu3);

        y1=y1+h+gap;
        pnlReportMenu4 = new JPanel();
		pnlReportMenu4.setLayout(new GridLayout(1,1));
        pnlReportMenu4.setBounds(x1,y1,w,h);
        pnlData.add(pnlReportMenu4);
        btnReportMenu4 = new JButton("Room");
        pnlReportMenu4.add(btnReportMenu4);

        y1=y1+h+gap;
        pnlReportMenu5 = new JPanel();
		pnlReportMenu5.setLayout(new GridLayout(1,1));
        pnlReportMenu5.setBounds(x1,y1,w,h);
        pnlData.add(pnlReportMenu5);
        btnReportMenu5 = new JButton("Course");
        pnlReportMenu5.add(btnReportMenu5);

        y1=y1+h+gap;
        pnlReportMenu6 = new JPanel();
		pnlReportMenu6.setLayout(new GridLayout(1,1));
        pnlReportMenu6.setBounds(x1,y1,w,h);
        pnlData.add(pnlReportMenu6);
        btnReportMenu6 = new JButton("Level");
        pnlReportMenu6.add(btnReportMenu6);

        y1=y1+h+gap;
        pnlReportMenu7 = new JPanel();
		pnlReportMenu7.setLayout(new GridLayout(1,1));
        pnlReportMenu7.setBounds(x1,y1,w,h);
        pnlData.add(pnlReportMenu7);
        btnReportMenu7 = new JButton("Staff");
        pnlReportMenu7.add(btnReportMenu7);

        y1=y1+h+gap;
        pnlReportMenu8 = new JPanel();
		pnlReportMenu8.setLayout(new GridLayout(1,1));
        pnlReportMenu8.setBounds(x1,y1,w,h);
        pnlData.add(pnlReportMenu8);
        btnReportMenu8 = new JButton("Subject");
        pnlReportMenu8.add(btnReportMenu8);




        btnMenu1.addActionListener(this);
        btnMenu2.addActionListener(this);
        btnMenu3.addActionListener(this);
        btnMenu4.addActionListener(this);
        btnMenu5.addActionListener(this);
        btnMenu6.addActionListener(this);
        btnMenu7.addActionListener(this);
        btnMenu8.addActionListener(this);
        //btnMenu9.addActionListener(this);

        btnReportMenu1.addActionListener(this);
        btnReportMenu2.addActionListener(this);
        btnReportMenu3.addActionListener(this);
        btnReportMenu4.addActionListener(this);
        btnReportMenu5.addActionListener(this);
        btnReportMenu6.addActionListener(this);
        btnReportMenu7.addActionListener(this);
        btnReportMenu8.addActionListener(this);

        MS.UIAreaSetting(1400,650);



		show();



	}
    public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==btnMenu1)
		{
             FrmUse A = new FrmUse();
		}
        else if(ae.getSource()==btnMenu2)
		{
             FrmTimeSlot A = new FrmTimeSlot();
		}
        else if(ae.getSource()==btnMenu3)
		{
             FrmBatchSlot A = new FrmBatchSlot();
		}
        else if(ae.getSource()==btnMenu4)
		{
             FrmRoom A = new FrmRoom();
		}
		else if(ae.getSource()==btnMenu5)
		{
             FrmCourse A = new FrmCourse();
		}
 		else if(ae.getSource()==btnMenu6)
		{
             FrmLevel A = new FrmLevel();
		}
        else if(ae.getSource()==btnMenu7)
		{
             FrmStaff A = new FrmStaff();
		}
        else if(ae.getSource()==btnMenu8)
		{
             FrmSubject A = new FrmSubject();
		}
       /* else if(ae.getSource()==btnMenu9)
		{
             FrmFloor A = new FrmFloor();
		}*/
		else if(ae.getSource()==btnReportMenu1)
		{
             RptUse A = new RptUse();
		}
        else if(ae.getSource()==btnReportMenu2)
		{
             RptTimeSlot A = new RptTimeSlot();
		}
        else if(ae.getSource()==btnReportMenu3)
		{
             RptBatchSlot A = new RptBatchSlot();
		}
        else if(ae.getSource()==btnReportMenu4)
		{
             RptRoom A = new RptRoom();
		}
        else if(ae.getSource()==btnReportMenu5)
		{
             RptCourse A = new RptCourse();
		}
        else if(ae.getSource()==btnReportMenu6)
		{
             RptLevel A = new RptLevel();
		}
        else if(ae.getSource()==btnReportMenu7)
		{
             RptStaff A = new RptStaff();
		}
        else if(ae.getSource()==btnReportMenu8)
		{
             RptSubject A = new RptSubject();
		}
       /* else if(ae.getSource()==btnReportMenu9)
		{
             RptFloor A = new RptFloor();
		}*/
	}

   public static void main(String args[])
   {
        FrmMenuScreen A = new FrmMenuScreen();
   }

}