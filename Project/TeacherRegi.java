import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.text.*;
import java.util.Date;
class TeacherRegi extends JPanel implements ActionListener
{
  JPanel top,middle,bottom;
  JLabel regno,date,tecname,add,mob,gen,edu,yr,exp,sal,tit;
  JTextArea jta;
  JRadioButton male,female;
  JTextField txtregno,txtdate,txttn,txtmob,txte,txts;
  JComboBox jcb1,jcb2;
  JButton b1,b2,b3,b4,b5,b6;

  TeacherRegi()
  {
	setVisible(true);
	//setTitle("My Frame");
	Toolkit tk=Toolkit.getDefaultToolkit();
	Dimension dt=tk.getScreenSize();
	int w=dt.width;
	int h=dt.height;
	setSize(w,h);
	setLayout(new BorderLayout());

	top=new JPanel();
	top.setBackground(Color.yellow);
	tit=new JLabel("Teacher Registation");
	tit.setFont(new Font("Constantia",Font.BOLD,60));
	top.add(tit);
	add(top,"North");

	middle=new JPanel();
	middle.setBackground(Color.pink);
	middle.setLayout(null);
	regno=new JLabel("Reg No");
	regno.setFont(new Font("Constantia",Font.BOLD,30));
	regno.setBounds(400,60,200,40);
	middle.add(regno);
	txtregno=new JTextField();
	txtregno.setFont(new Font("Constantia",Font.BOLD,30));
	txtregno.setBounds(600,60,250,40);
	middle.add(txtregno);

	date=new JLabel("Date");
	date.setFont(new Font("Constantia",Font.BOLD,30));
	date.setBounds(1070,60,200,40);
	middle.add(date);
	txtdate=new JTextField();
	txtdate.setFont(new Font("Constantia",Font.BOLD,30));
	txtdate.setBounds(1200,60,250,40);
	middle.add(txtdate);
	//date Logic
	String pattern="dd-MM-yyyy";
	SimpleDateFormat sdf=new SimpleDateFormat(pattern);
	String date=sdf.format(new Date());
    txtdate.setText(date);

   tecname=new JLabel("Teac. Name");
   tecname.setFont(new Font("Constantia",Font.BOLD,30));
   tecname.setBounds(400,170,250,40);
   middle.add(tecname);
   txttn=new JTextField();
   txttn.setFont(new Font("Constantia",Font.BOLD,30));
   txttn.setBounds(600,170,850,40);
   middle.add(txttn);

   add=new JLabel("Address");
   add.setFont(new Font("Constantia",Font.BOLD,30));
   add.setBounds(400,250,250,40);
   middle.add(add);
   jta=new  JTextArea(20,80);
   jta.setFont(new Font("Constantia",Font.BOLD,30));
   jta.setBounds(600,250,850,100);
   middle.add(jta);

   mob=new JLabel("Mobile");
   mob.setFont(new Font("Constantia",Font.BOLD,30));
   mob.setBounds(400,410,250,40);
   middle.add(mob);
   txtmob=new JTextField();
   txtmob.setFont(new Font("Constantia",Font.BOLD,30));
   txtmob.setBounds(600,410,850,40);
   middle.add(txtmob);

   gen=new JLabel("Gender");
   gen.setFont(new Font("Constantia",Font.BOLD,30));
   gen.setBounds(400,490,250,40);
   middle.add(gen);
   male=new JRadioButton("Male");
   male.setFont(new Font("Constantia",Font.BOLD,30));
   male.setBackground(Color.pink);
   male.setBounds(600,490,250,40);
   middle.add(male);
   female=new JRadioButton("Female");
   female.setFont(new Font("Constantia",Font.BOLD,30));
   female.setBounds(1000,490,240,40);
   female.setBackground(Color.pink);
   middle.add(female);
   ButtonGroup bg=new ButtonGroup();
   bg.add(male);
   bg.add(female);

   edu=new JLabel("Education");
   edu.setFont(new Font("Constantia",Font.BOLD,30));
   edu.setBounds(400,570,250,40);
   middle.add(edu);
   String s1[]={"","Ssc","Hsc","Graduate","Post-Graduate","Other"};
   jcb1=new JComboBox(s1);
   jcb1.setFont(new Font("Constantia",Font.BOLD,30));
   jcb1.setBounds(600,570,250,40);
   middle.add(jcb1);

   yr=new JLabel("Year");
   yr.setFont(new Font("Constantia",Font.BOLD,30));
   yr.setBounds(1000,570,250,40);
   middle.add(yr);
   String s2[]={"","2015","2016","2017","2018","2019","2020"};
   jcb2=new JComboBox(s2);
   jcb2.setFont(new Font("Constantia",Font.BOLD,30));
   jcb2.setBounds(1130,570,250,40);
   middle.add(jcb2);

   exp=new JLabel("Experience");
   exp.setFont(new Font("Constantia",Font.BOLD,30));
   exp.setBounds(400,650,250,40);
   middle.add(exp);
   txte=new JTextField();
   txte.setFont(new Font("Constantia",Font.BOLD,30));
   txte.setBounds(600,650,250,40);
   middle.add(txte);

   sal=new JLabel("Salary");
   sal.setFont(new Font("Constantia",Font.BOLD,30));
   sal.setBounds(1000,650,250,40);
   middle.add(sal);
   txts=new JTextField();
   txts.setFont(new Font("Constantia",Font.BOLD,30));
   txts.setBounds(1130,650,250,40);
   middle.add(txts);
   add(middle);

   bottom=new JPanel();
   bottom.setBackground(Color.red);
   bottom.setLayout(new  FlowLayout(1,50,20));
   b1=new JButton("New");
   b1.setFont(new Font("Constantia",Font.BOLD,30));
   bottom.add(b1);
   b2=new JButton("save");
   b2.setFont(new Font("Constantia",Font.BOLD,30));
   bottom.add(b2);
   b3=new JButton("Find");
   b3.setFont(new Font("Constantia",Font.BOLD,30));
   bottom.add(b3);
   b4=new JButton("Delete");
   b4.setFont(new Font("Constantia",Font.BOLD,30));
   b4.setEnabled(false);
   bottom.add(b4);
   b5=new JButton("Update");
   b5.setFont(new Font("Constantia",Font.BOLD,30));
   b5.setEnabled(false);
   bottom.add(b5);
   b6=new JButton("Exit");
   b6.setFont(new Font("Constantia",Font.BOLD,30));
   bottom.add(b6);
   add(bottom,"South");
   b1.addActionListener(this);
   b2.addActionListener(this);
   b3.addActionListener(this);
   b4.addActionListener(this);
   b5.addActionListener(this);
   Show();
  }
  void Show()
  {
	try
	{
	  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	  System.out.println("Driver is load");
	  Connection con=DriverManager.getConnection("Jdbc:Odbc:sham");
	  System.out.println("Connection is created");
	  Statement st=con.createStatement();
	  ResultSet rs=st.executeQuery("select count(regno) from teacher");
	  int pk=0;
	  if(rs.next())
	  {
		 pk=rs.getInt(1);
	  }
	  pk=pk+1;
	  txtregno.setText(Integer.toString(pk));
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
  boolean Valide()
  {
    Boolean flag=true;
    String r=txtregno.getText();
    String r1=txtdate.getText();
    String r2=txttn.getText();
    String r3=jta.getText();
    String r4=txtmob.getText();
    String r5=(String)jcb1.getSelectedItem();
    String r6=(String)jcb2.getSelectedItem();
    String r7=txte.getText();
    String r8=txts.getText();

    if(r.equals(""))
     {
	   JOptionPane.showMessageDialog(this,"Enter Student reg");
	   flag=false;
     }
    else if(r1.equals(""))
     {
	   JOptionPane.showMessageDialog(this,"Enter reg date");
	   flag=false;
     }
     else if(r2.equals(""))
	      {
	 	   JOptionPane.showMessageDialog(this,"Enter Teacher name");
	 	   flag=false;
     }
     else if(r3.equals(""))
	      {
	 	   JOptionPane.showMessageDialog(this,"Enter Address");
	 	   flag=false;
     }
     else if(r4.equals(""))
	      {
	 	   JOptionPane.showMessageDialog(this,"Enter Mobile no.");
	 	   flag=false;
     }
     else if(male.isSelected()==false && female.isSelected()==false)
         {
		   JOptionPane.showMessageDialog(this,"Select Gender");
		   flag=false;
		 }

     else if(r5.equals(""))
	      {
	 	   JOptionPane.showMessageDialog(this,"Select Education");
	 	   flag=false;
     }
     else if(r6.equals(""))
	      {
	 	   JOptionPane.showMessageDialog(this,"Select year");
	 	   flag=false;
     }
     else if(r7.equals(""))
	      {
	 	   JOptionPane.showMessageDialog(this,"Enter Experience");
	 	   flag=false;
     }
     else if(r8.equals(""))
     {
	   JOptionPane.showMessageDialog(this,"Enter Salary");
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
	  String msg="";
	  if(male.isSelected())
	   msg="Male";
	  if(female.isSelected());
       msg="Female";
      String query="Update teacher set date1='"+txtdate.getText()+"',teachn='"+txttn.getText()+"',add='"+jta.getText()+"',mob='"+txtmob.getText()+"',gen='"+msg+"',edu='"+(String)jcb1.getSelectedItem()+"',yr='"+jcb2.getSelectedItem()+"',exp='"+txte.getText()+"',sal='"+txts.getText()+"' where regno="+Integer.parseInt(txtregno.getText());
	  System.out.println(query);
	  int i=st.executeUpdate(query);
	  if(i==1)
	  JOptionPane.showMessageDialog(this,"Record is Update");
	  else
	  JOptionPane.showMessageDialog(this,"Record not Upadate");
	  b4.setEnabled(false);
	  b5.setEnabled(false);
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
    Statement st= con.createStatement();
    int i=st.executeUpdate("delete from stud where std="+Integer.parseInt(regno.getText()));
     if(i==1)
     {
      JOptionPane.showMessageDialog(this,"Record is delete");
     }
        else
      JOptionPane.showMessageDialog(this,"Record is not delete");
      b4.setEnabled(false);
      b5.setEnabled(false);
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
   System.out.println("Driver is loaded");
   Connection con=DriverManager.getConnection("Jdbc:Odbc:sham");
   System.out.println("Connectiion is created");
   Statement st=con.createStatement();
   ResultSet rs=st.executeQuery("select * from teacher where regno="+Integer.parseInt(txtregno.getText()));
   if(rs.next())
    {
	   txtregno.setText(rs.getString(1));
	   txtdate.setText(rs.getString(2));
	   txttn.setText(rs.getString(3));
	   jta.setText(rs.getString(4));
       txtmob.setText(rs.getString(5));
       String m=rs.getString(6);
       if(m.equals("Male"))
         {
         male.setSelected(true);
	     }
       else if(m.equals("Female"))
       {
         female.setSelected(true);
	   }
	   jcb1.setSelectedItem(rs.getString(7));
	   jcb2.setSelectedItem(rs.getString(8));
	   txte.setText(rs.getString(9));
	   txts.setText(rs.getString(10));
	   b4.setEnabled(true);
	   b5.setEnabled(true);
	   JOptionPane.showMessageDialog(this,"Record is Find");
     }
     else
      JOptionPane.showMessageDialog(this,"Record does not found");
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
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	System.out.println("Driver is loaded");
	Connection con=DriverManager.getConnection("Jdbc:Odbc:sham");
	System.out.println("Connection is created");
	PreparedStatement pst=con.prepareStatement("insert into teacher values(?,?,?,?,?,?,?,?,?,?)");
    pst.setInt(1,Integer.parseInt(txtregno.getText()));
    pst.setString(2,txtdate.getText());
    pst.setString(3,txttn.getText());
    pst.setString(4,jta.getText());
    pst.setString(5,txtmob.getText());
    String msg="";
    if(male.getText()=="1")
     msg="Male";
    else
     msg="Female";
    pst.setString(6,msg);
    pst.setString(7,(String)jcb1.getSelectedItem());
    pst.setString(8,(String)jcb2.getSelectedItem());
    pst.setString(9,txte.getText());
    pst.setString(10,txts.getText());
    int i=pst.executeUpdate();
    System.out.println(i);

    con.close();
    New();
    }
    catch(Exception e)
    {
	 e.printStackTrace();
	}

  }
  void New()
  {
	 txtregno.setText("");
     //txtdate.setText("");
     txttn.setText("");
     txtmob.setText("");
     txte.setText("");
     txts.setText("");
     jta.setText("");
     jcb1.setSelectedItem("");
     jcb2.setSelectedItem("");
     Show();
  }
  public static void main(String args[])
  {
	TeacherRegi obj=new TeacherRegi();
	obj.setVisible(true);

  }
}