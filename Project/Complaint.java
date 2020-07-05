import java.awt.*;
import  javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.text.*;
import java.util.Date;
class Complaint extends JPanel implements ActionListener
{
  JPanel top,bot,mid;
  JLabel reg,date,com,dep,mob,tit;
  JTextField txtr,txtd,txtdep,txtmob;
  JTextArea jta;
  JButton b1,b2,b3,b4,b5,b6;

  Complaint()
  {
	setVisible(true);
	//setTitle("My Frame");
	Toolkit tk=Toolkit.getDefaultToolkit();
	Dimension dt=tk.getScreenSize();
	int w=dt.width;
	int h=dt.height;
	setSize(w,h);
    top=new JPanel();
    top.setBackground(Color.blue);
    add(top,"North");
    tit=new JLabel("Complaint Registration");
    tit.setFont(new Font("Constantia",Font.BOLD,80));
    top.add(tit);
    setLayout(new BorderLayout());

    mid=new JPanel();
    mid.setBackground(Color.gray);
    mid.setLayout(null);
    reg=new JLabel("Reg. No");
    reg.setFont(new Font("Constantia",Font.BOLD,40));
    reg.setBounds(400,100,250,40);
    mid.add(reg);

    txtr=new JTextField();
    txtr.setFont(new Font("Constantia",Font.BOLD,40));
    txtr.setBounds(650,100,250,50);
    mid.add(txtr);
    date=new JLabel("Date");
    date.setFont(new Font("Constantia",Font.BOLD,40));
    date.setBounds(1000,100,250,40);
    mid.add(date);
    txtd=new JTextField();
    txtd.setFont(new Font("Constantia",Font.BOLD,40));
    txtd.setBounds(1150,100,250,50);
    mid.add(txtd);
    //date Logic
	String pattern="dd-MMMM-yyyy";
	SimpleDateFormat sdf=new SimpleDateFormat(pattern);
	String date=sdf.format(new Date());
	txtd.setText(date);


    com=new JLabel("Complaint");
    com.setFont(new Font("Constantia",Font.BOLD,40));
    com.setBounds(400,200,250,50);
    mid.add(com);
    jta=new JTextArea(10,60);
    jta.setFont(new Font("Constantia",Font.BOLD,40));
	jta.setBounds(650,200,750,250);
    mid.add(jta);

    dep=new JLabel("Department");
	dep.setFont(new Font("Constantia",Font.BOLD,40));
	dep.setBounds(400,500,300,40);
	mid.add(dep);
	txtdep=new JTextField();
	txtdep.setFont(new Font("Constantia",Font.BOLD,40));
	txtdep.setBounds(650,500,750,50);
	mid.add(txtdep);

	mob=new JLabel("Mobile");
	mob.setFont(new Font("Constantia",Font.BOLD,40));
	mob.setBounds(400,600,300,40);
	mid.add(mob);
	txtmob=new JTextField();
	txtmob.setFont(new Font("Constantia",Font.BOLD,40));
	txtmob.setBounds(650,600,750,50);
	mid.add(txtmob);

	bot=new JPanel();
	bot.setBackground(Color.green);
	bot.setLayout(new FlowLayout(1,50,20));
	add(bot,"South");
	b1=new JButton("New");
	b1.setFont(new Font("Constantia",Font.BOLD,40));
	bot.add(b1);
	b2=new JButton("Save");
    b2.setFont(new Font("Constantia",Font.BOLD,40));
	bot.add(b2);
	b3=new JButton("Find");
	b3.setFont(new Font("Constantia",Font.BOLD,40));
	bot.add(b3);
	b4=new JButton("Delete");
	b4.setFont(new Font("Constantia",Font.BOLD,40));
	b4.setEnabled(false);
	bot.add(b4);
	b5=new JButton("Update");
	b5.setFont(new Font("Constantia",Font.BOLD,40));
	b5.setEnabled(false);
	bot.add(b5);
	b6=new JButton("Exit");
	b6.setFont(new Font("Constantia",Font.BOLD,40));
	bot.add(b6);
	add(mid);
	b1.addActionListener(this);
	b2.addActionListener(this);
	b3.addActionListener(this);
	b4.addActionListener(this);
	b5.addActionListener(this);
	b6.addActionListener(this);



     Show();
  }
  void Show()
  {
	try
	{
	  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	  Connection con=DriverManager.getConnection("Jdbc:Odbc:sham");
	  Statement st=con.createStatement();
	  ResultSet rs=st.executeQuery("select max(regno) from complaint");
	  int pk=0;
	  if(rs.next())
	  {
		pk=rs.getInt(1);
	  }
	  pk=pk+1;
	  txtr.setText(Integer.toString(pk));
    }
    catch(Exception e)
    {
	 e.printStackTrace();
	}
  }
  public void actionPerformed(ActionEvent ae)
  {
	if(ae.getSource()==b1)
	{
		New();
	}
	else if(ae.getSource()==b2)
	{
	  Save();
    }
	else if(ae.getSource()==b3)
	{
	  Find();
	}
	else if(ae.getSource()==b4)
	{
	  Delete();
	}
	else if(ae.getSource()==b5)
	{
	  Update();
	}
	else if(ae.getSource()==b6)
	{}
	else
	{}
  }
  boolean Valid()
  {
    boolean flag=true;
    String r=txtr.getText();
    String r1=txtd.getText();
    String r2=jta.getText();
    String r3=txtdep.getText();
    String r4=txtmob.getText();
    if(r.equals(""))
    {
	  JOptionPane.showMessageDialog(this,"Enter StudReg");
	  flag=false;
	}
	else if(r1.equals(""))
	{
	  JOptionPane.showMessageDialog(this,"Enter Date");
	  flag=false;
	}
	else if(r2.equals(""))
	{
	  JOptionPane.showMessageDialog(this,"Enter Complaint");
	  flag=false;
	}
	else if(r3.equals(""))
	{
	  JOptionPane.showMessageDialog(this,"Enter Department");
	  flag=false;
	}
	else if(r4.equals(""))
	{
	  JOptionPane.showMessageDialog(this,"Enter mobile");
	  flag=false;
	}
	else
	flag=true;

	return flag;

  }
  void Update()
  {
	try
	{
	  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	  Connection con=DriverManager.getConnection("Jdbc:Odbc:sham");
	  Statement st=con.createStatement();
	  String query="Update complaint set date1='"+txtd.getText()+"',comp='"+jta.getText()+"',dep='"+txtdep.getText()+"',mob='"+txtmob.getText()+"' where regno="+Integer.parseInt(txtr.getText());
	  System.out.println(query);
	  int i=st.executeUpdate(query);
	  if(i==1)
	    JOptionPane.showMessageDialog(this,"Record is Update");
	  else
	    JOptionPane.showMessageDialog(this,"Record not Update");
	    New();
	}
	catch(Exception e)
	{
	  e.printStackTrace();
	}
  }
  void Delete()
  {
	try
	{
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	Connection con=DriverManager.getConnection("Jdbc:Odbc:sham");
	Statement st=con.createStatement();
	int i=st.executeUpdate("delete from complaint where regno="+Integer.parseInt(txtr.getText()));
	if(i==1)
	 JOptionPane.showMessageDialog(this,"Record is Delete");
	else
	 JOptionPane.showMessageDialog(this,"Record not save");
	 b4.setEnabled(true);
	 b5.setEnabled(true);
	 New();
     }
     catch(Exception e)
     {
	  e.printStackTrace();
	  }
  }
  void Find()
  {
    try
    {
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     System.out.println("Driver is Loaded");
     Connection con=DriverManager.getConnection("Jdbc:Odbc:sham");
     System.out.println("Connection is Load");
     Statement st=con.createStatement();
     ResultSet rs=st.executeQuery("select * from complaint where regno="+Integer.parseInt(txtr.getText()));
	 if(rs.next())
	  {
	   txtr.setText(rs.getString(1));
	   txtd.setText(rs.getString(2));
	   jta.setText(rs.getString(3));
	   txtdep.setText(rs.getString(4));
	   txtmob.setText(rs.getString(5));
	   JOptionPane.showMessageDialog(this,"Record is Find");
	  }
	  else
	  JOptionPane.showMessageDialog(this,"Record not Found");
	   b4.setEnabled(true);
	   b5.setEnabled(true);

	}
	catch(Exception e)
	{
	  e.printStackTrace();
	}
  }

  void Save()
  {
	 try
	 {
	  if(Valid())
	   {
	   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	   Connection con=DriverManager.getConnection("Jdbc:Odbc:sham");
	   PreparedStatement pst=con.prepareStatement("insert Into complaint values(?,?,?,?,?)");
	   pst.setInt(1,Integer.parseInt(txtr.getText()));
	   pst.setString(2,txtd.getText());
	   pst.setString(3,jta.getText());
	   pst.setString(4,txtdep.getText());
	   pst.setString(5,txtmob.getText());
	   int i=pst.executeUpdate();
	   if(i==1)
	    JOptionPane.showMessageDialog(this,"Record is Save");
	   else
	    JOptionPane.showMessageDialog(this,"Record not save");
	   New();
      }
	  else
	  {}
	 }
	 catch(Exception e)
	 {
	   e.printStackTrace();
	 }
  }
  void New()
  {
	txtr.setText("");
	jta.setText("");
	txtdep.setText("");
	txtmob.setText("");
	Show();
  }
  public static void main(String args[])
  {
	Complaint obj=new Complaint();
	obj.setVisible(true);
  }
}