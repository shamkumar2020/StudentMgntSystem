import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class MarksReport extends JPanel
{
	Connection con=null;
	Statement pst=null;
	ResultSet rs=null;
	JPanel j1,j2;

	MarksReport()
	{
		setLayout(null);
		//setSize(1000,800);
		setVisible(true);
		try {


		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		System.out.println("Driver loaded");
		con=DriverManager.getConnection("Jdbc:Odbc:sham");
		System.out.println("Conncetion establish");

		String sql1="SELECT marks.studid, marks.studn, marks.edu, marks.yr, marks.sem, marks.tot, marks.per FROM marks";
		pst=con.createStatement();
		rs=pst.executeQuery(sql1);
		int x=350;
		while(rs.next())
		{
			JLabel lbl1=new JLabel(rs.getString(1));
			lbl1.setFont(new Font("Times New Roman",Font.TYPE1_FONT,20));
			lbl1.setBounds(300,x,20,20);
			add(lbl1);

			JLabel lbl2=new JLabel(rs.getString(2));
			lbl2.setFont(new Font("Times New Roman",Font.TYPE1_FONT,20));
			lbl2.setBounds(450,x,130,20);
			add(lbl2);

			JLabel lbl3=new JLabel(rs.getString(3));
			lbl3.setFont(new Font("Times New Roman",Font.TYPE1_FONT,15));
			lbl3.setBounds(670,x,200,20);
			add(lbl3);

			JLabel lbl4=new JLabel(rs.getString(4));
			lbl4.setFont(new Font("Times New Roman",Font.TYPE1_FONT,15));
			lbl4.setBounds(1370,x,100,30);
			add(lbl4);

			JLabel lbl5=new JLabel(rs.getString(5));
			lbl5.setBounds(1350,x,100,30);
			add(lbl5);

			JLabel lbl6=new JLabel(rs.getString(6));
			lbl6.setBounds(1630,x,120,30);
			add(lbl6);

			JLabel lbl7=new JLabel(rs.getString(7));
			lbl7.setBounds(970,x,120,30);
			add(lbl7);
            /*
			JLabel lbl8=new JLabel();
			lbl8.setBounds(1030,x,120,30);
			add(lbl8);
			*/
			x=x+30;

		}
	    }
    	catch(Exception e1)
		 {
			e1.printStackTrace();
		 }

	}
   public void paintComponent(Graphics g)
		{

			Toolkit kit=Toolkit.getDefaultToolkit();
			Image img=kit.getImage("img\\MarksReport.jpg");
			MediaTracker t=new MediaTracker(this);
			t.addImage(img,1);
			while(true)
			{
				try
				{
					t.waitForID(1);
					break;
				}
				catch(Exception e)
				{
				}
			}
			setVisible(true);
			g.drawImage(img,200,50,1600,900,null);

	   }
	   public static void main(String args[])
	   {
		   MarksReport obj=new MarksReport();
		   obj.setVisible(true);
	   }

}

