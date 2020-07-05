import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.text.*;
import java.util.Date;
class CourseReg extends JPanel implements ActionListener
{
  JPanel top,bot,mid;
  JLabel reg,date,studn,add,gen,cors,yr,fees,daten,tit,mob;
  JTextField txtd,txts,txtg,txtyr,txtf,txtdat,txtm;
  JTextArea jta;
  JComboBox txtr;
  JRadioButton male, female;
  JComboBox cor,yrr;
  JButton b1,b2,b3,b4,b5,b6;

  CourseReg()
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
	top.setBackground(Color.red);
	tit=new JLabel("Course Registration");
	tit.setFont(new Font("Copperplate Gothic",Font.BOLD,60));
	top.add(tit);
	add(top,"North");

	mid=new JPanel();
	mid.setBackground(Color.yellow);
	mid.setLayout(null);
	reg=new JLabel("Reg. No");
	reg.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
	reg.setBounds(400,50,250,50);
	mid.add(reg);
	txtr=new JComboBox();
	txtr.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
	txtr.setBounds(700,50,250,50);
	mid.add(txtr);
	date=new JLabel("Date");
	date.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
	date.setBounds(1050,50,250,50);
	mid.add(date);
	txtd=new JTextField();
	txtd.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
	txtd.setBounds(1200,50,300,50);
	mid.add(txtd);
	String pattern="dd-MMMM-yyyy";
	SimpleDateFormat sdf=new SimpleDateFormat(pattern);
	String date=sdf.format(new Date());
	txtd.setText(date);


	studn=new JLabel("Stud name");
	studn.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
	studn.setBounds(400,150,250,50);
	mid.add(studn);
	txts=new JTextField();
	txts.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
	txts.setBounds(700,150,800,50);
	mid.add(txts);

	add=new JLabel("Address");
	add.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
	add.setBounds(400,250,250,50);
	mid.add(add);
	jta=new JTextArea(10,80);
	jta.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
	jta.setBounds(700,250,800,100);
	mid.add(jta);

	mob=new JLabel("Mobile");
	mob.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
	mob.setBounds(400,400,250,40);
	mid.add(mob);
	txtm=new JTextField();
	txtm.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
	txtm.setBounds(700,400,800,50);
	mid.add(txtm);

	gen=new JLabel("Gender");
	gen.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
    gen.setBounds(400,500,250,50);
    mid.add(gen);

    male=new JRadioButton("male");
    male.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
    male.setBounds(700,500,250,50);
    male.setBackground(Color.yellow);
    female=new JRadioButton("Feamle");
    female.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
    female.setBounds(950,500,250,50);
    female.setBackground(Color.yellow);

    ButtonGroup bg=new ButtonGroup();
    bg.add(male);
    bg.add(female);
    mid.add(male);
    mid.add(female);

    cors=new JLabel("Course");
    cors.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
    cors.setBounds(400,600,250,40);
    mid.add(cors);
    String s1[]={"","C",".net","Java","Python"};
    cor=new JComboBox(s1);
    cor.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
    cor.setBounds(700,600,250,40);
    mid.add(cor);
    yr=new JLabel("Year");
    yr.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
    yr.setBounds(1100,600,250,40);
    mid.add(yr);
    String s2[]={"","2016","2017","2018","2019","2020"};
    yrr=new JComboBox(s2);
    yrr.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
    yrr.setBounds(1250,600,250,40);
    mid.add(yrr);

    fees=new JLabel("Fees");
    fees.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
    fees.setBounds(400,700,250,40);
    mid.add(fees);
    txtf=new JTextField();
    txtf.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
    txtf.setBounds(700,700,250,40);
    mid.add(txtf);

    daten=new JLabel("Date");
    daten.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
    daten.setBounds(1100,700,250,40);
    mid.add(daten);
    txtdat=new JTextField();
    txtdat.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
    txtdat.setBounds(1250,700,250,40);
    mid.add(txtdat);
	add(mid);

	bot=new JPanel();
	bot.setBackground(Color.pink);
    bot.setLayout(new FlowLayout(1,50,10));
	b1=new JButton("New");
	b1.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
	bot.add(b1);
	b2=new JButton("Save");
	b2.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
	bot.add(b2);
	b3=new JButton("Find");
	b3.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
	bot.add(b3);
	b4=new JButton("Delete");
	b4.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
	b4.setEnabled(false);
	bot.add(b4);
	b5=new JButton("Update");
	b5.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
	b5.setEnabled(false);
	bot.add(b5);
	b6=new JButton("Exit");
	b6.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
	bot.add(b6);
	add(bot,"South");
    b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(this);
    b4.addActionListener(this);
    b5.addActionListener(this);
	txtr.addActionListener(this);
    Show();
  }
  void Show()
  {
    try
    {
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	System.out.println("Driver is Loaded");
	Connection con=DriverManager.getConnection("Jdbc:Odbc:sham");
	System.out.println("Connection is Create");
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery("select std from stud");
	int pk=0;
	txtr.removeAllItems();
	txtr.addItem("");
	while(rs.next())
	{
	  txtr.addItem(rs.getString(1));
	}
	con.close();
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
	else if(ae.getSource()==txtr)
	{
		Find1();
	}
	else
	{}

  }
  boolean Valid()
  {
	boolean flag=true;
	//String r=txtr.getText();
	String r1=txtd.getText();
	String r2=txts.getText();
	String r3=jta.getText();
	String r4=txtm.getText();
	String r5=(String)cor.getSelectedItem();
	String r6=(String)yrr.getSelectedItem();
	String r7=txtf.getText();
	String r8=txtdat.getText();

	if(r1.equals(""))
	{
	  JOptionPane.showMessageDialog(this,"Enter Date");
	  flag=false;
	}
	else if(r2.equals(""))
		{
		  JOptionPane.showMessageDialog(this,"Enter stud name");
		  flag=false;
	}
	else if(r3.equals(""))
		{
		  JOptionPane.showMessageDialog(this,"Enter Address");
		  flag=false;
	}
	else if(r4.equals(""))
		{
		  JOptionPane.showMessageDialog(this,"Enter Mobile no");
		  flag=false;
	}
    else if(male.isSelected()==false && female.isSelected()==false)
    {
	  JOptionPane.showMessageDialog(this,"Select gender");
	  flag=false;
	}
	else if(r5.equals(""))
		{
		  JOptionPane.showMessageDialog(this,"slect cource");
		  flag=false;
	}
	else if(r6.equals(""))
		{
		  JOptionPane.showMessageDialog(this,"select year");
		  flag=false;
	}
	else if(r7.equals(""))
		{
		  JOptionPane.showMessageDialog(this,"Enter fees");
		  flag=false;
	}
    else if(r8.equals(""))
		{
		  JOptionPane.showMessageDialog(this,"Enter Date");
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
    else if(female.isSelected());
      msg="Feamle";
     String query="Update cource set date1='"+txtd.getText()+"',studn='"+txts.getText()+"',add='"+jta.getText()+"',mob='"+txtm.getText()+"',gen='"+msg+"',cource='"+(String)cor.getSelectedItem()+"',year='"+(String)yrr.getSelectedItem()+"',fees='"+txtf.getText()+"',daten='"+txtdat.getText()+"' where regno="+txtr.getSelectedItem();
     int i=st.executeUpdate(query);
     if(i==1)
       JOptionPane.showMessageDialog(this,"Record is Update");
     else
      JOptionPane.showMessageDialog(this,"Record is not Update");
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
	  int i=st.executeUpdate("Delete from cource where regno="+txtr.getSelectedItem());
	  if(i==1)
	   JOptionPane.showMessageDialog(this,"Record is Delete");
	  else
	   JOptionPane.showMessageDialog(this,"Record Doesnot Delete");
	   b4.setEnabled(true);
	   b5.setEnabled(true);
	   New();
	 }
	 catch(Exception e)
	 {
	   e.printStackTrace();
	 }
  }

  void Find1()
  {
	try
	{
	  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	  Connection con=DriverManager.getConnection("Jdbc:Odbc:sham");
	  Statement st=con.createStatement();
	  ResultSet rs=st.executeQuery("select * from Stud where std="+txtr.getSelectedItem());
	  if(rs.next())
	  {
		//txtr.setText(rs.getString(1));
		txtd.setText(rs.getString(2));
		txts.setText(rs.getString(3));
		jta.setText(rs.getString(4));
		//txtm.setText(rs.getString(5));
		String m=rs.getString(5);
		if(m.equals("Male"))
		  male.setSelected(true);
		else if(m.equals("Female"))
		  female.setSelected(true);
		b4.setEnabled(true);
		b5.setEnabled(true);
		//JOptionPane.showMessageDialog(this,"Record is Find");
	  }
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
  	  Connection con=DriverManager.getConnection("Jdbc:Odbc:sham");
  	  Statement st=con.createStatement();
  	  ResultSet rs=st.executeQuery("select * from cource where regno="+txtr.getSelectedItem());
  	  if(rs.next())
  	  {
  		//txtr.setText(rs.getString(1));
  		txtd.setText(rs.getString(2));
  		txts.setText(rs.getString(3));
  		jta.setText(rs.getString(4));
  		txtm.setText(rs.getString(5));
  		String m=rs.getString(6);
  		if(m.equals("Male"))
  		  male.setSelected(true);
  		else if(m.equals("Female"))
  		  female.setSelected(true);
  		cor.setSelectedItem(rs.getString(7));
  		yrr.setSelectedItem(rs.getString(8));
  		txtf.setText(rs.getString(9));
  		txtdat.setText(rs.getString(10));
  		b4.setEnabled(true);
  		b5.setEnabled(true);
  		JOptionPane.showMessageDialog(this,"Record is Find");
  	  }
  	  else
  	    JOptionPane.showMessageDialog(this,"Record not Find");
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
	 PreparedStatement pst=con.prepareStatement("insert into cource values(?,?,?,?,?,?,?,?,?,?)");
	  pst.setInt(1,txtr.getSelectedIndex());
	  pst.setString(2,txtd.getText());
	  pst.setString(3,txts.getText());
	  pst.setString(4,jta.getText());
	  pst.setString(5,"123");
	  String msg="";
	  if(male.isSelected())
	  msg="Male";
	  else if(female.isSelected())
	  msg="Female";
	  pst.setString(6,msg);
	  pst.setString(7,(String)cor.getSelectedItem());
	  pst.setString(8,(String)yrr.getSelectedItem());
	  pst.setString(9,txtf.getText());
	  pst.setString(10,txtdat.getText());
	  int i=pst.executeUpdate();
	  System.out.println(i);
	  if(i==1)
	  {
		JOptionPane.showMessageDialog(this,"Record is save");
	  }
	  else
	  {
		JOptionPane.showMessageDialog(this,"Record not save");
	  }

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
	 //txtr.setText("");
	 //txtd.setText("");
	 txts.setText("");
	 jta.setText("");
	 txtm.setText("");
	 cor.setSelectedItem("");
	 yrr.setSelectedItem("");
	 txtf.setText("");
	 txtdat.setText("");
	 Show();

  }
  public static void main(String args[])
  {
   CourseReg obj=new CourseReg();
   obj.setVisible(true);
  }

}
