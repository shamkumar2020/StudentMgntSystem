import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.text.*;
import java.util.Date;
class MarksRegi extends JPanel implements ActionListener,FocusListener
{
  JPanel top,bot,mid;
  JLabel tit,studid,date,studn,edu,yr,semi,phi,che,mat,bio,c,cpp,tot,per;
  JTextField txtdt,txtstn,txtedu,txtyr,txtphi,txtche,txtmat,txtbio,txtc,txtcpp,txttot,txtper;
  JComboBox stid,sem;
  JButton b1,b2,b3,b4,b5,b6;
  MarksRegi()
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
	top.setBackground(Color.green);
	tit=new JLabel("Marks Registration");
	tit.setFont(new Font("Copperplate Gothic",Font.BOLD,60));
	top.add(tit);
	add(top,"North");

	mid=new JPanel();
	mid.setBackground(Color.red);
	mid.setLayout(null);
	studid=new JLabel("Student Id");
	studid.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
	studid.setBounds(300,80,250,40);
	mid.add(studid);
	stid=new JComboBox();
	stid.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
	stid.setBounds(650,80,250,40);
	mid.add(stid);

	date=new JLabel("Date");
	date.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
	date.setBounds(1050,80,250,40);
	mid.add(date);
    txtdt=new JTextField();
    txtdt.setFont(new Font("Copperplate Gothic",Font.BOLD,30));
    txtdt.setBounds(1250,80,250,40);
    mid.add(txtdt);
    String pattern="dd-MMMM-yy";
	SimpleDateFormat sdf=new SimpleDateFormat(pattern);
	String date=sdf.format(new Date());
	txtdt.setText(date);

    studn=new JLabel("Student Name");
    studn.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
    studn.setBounds(300,190,350,40);
    mid.add(studn);
    txtstn=new JTextField();
    txtstn.setFont(new Font("Copperplate Gothic",Font.BOLD,30));
    txtstn.setBounds(650,190,850,40);
    mid.add(txtstn);

    edu=new JLabel("Education");
    edu.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
    edu.setBounds(300,300,300,40);
    mid.add(edu);
    txtedu=new JTextField();
    txtedu.setFont(new Font("Copperplate Gothic",Font.BOLD,30));
    txtedu.setBounds(650,300,250,40);
    mid.add(txtedu);

    yr=new JLabel("Year");
    yr.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
    yr.setBounds(1050,300,250,40);
    mid.add(yr);
    txtyr=new JTextField();
    txtyr.setFont(new Font("Copperplate Gothic",Font.BOLD,30));
    txtyr.setBounds(1250,300,250,40);
    mid.add(txtyr);

    semi=new JLabel("Semister");
    semi.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
    semi.setBounds(300,380,300,40);
    mid.add(semi);
    String s1[]={"","1","2","3","4","5","6"};
    sem=new JComboBox(s1);
    sem.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
    sem.setBounds(650,380,250,40);
    mid.add(sem);

    phi=new JLabel("Physics");
    phi.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
    phi.setBounds(300,470,250,40);
    mid.add(phi);

    txtphi=new JTextField("0");
    txtphi.setFont(new Font("Copperplate Gothic",Font.BOLD,30));
    txtphi.setBounds(650,470,250,40);
    mid.add(txtphi);

    che=new JLabel("Chemistry");
	che.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
	che.setBounds(1040,470,250,50);
	mid.add(che);
	txtche=new JTextField("0");
	txtche.setFont(new Font("Copperplate Gothic",Font.BOLD,30));
	txtche.setBounds(1250,470,250,40);
    mid.add(txtche);

	mat=new JLabel("Mathematics");
	mat.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
	mat.setBounds(300,560,300,40);
	mid.add(mat);
	txtmat=new JTextField("0");
	txtmat.setFont(new Font("Copperplate Gothic",Font.BOLD,30));
	txtmat.setBounds(650,560,250,40);
	mid.add(txtmat);

	bio=new JLabel("Biology");
	bio.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
	bio.setBounds(1040,560,250,40);
	mid.add(bio);
	txtbio=new JTextField("0");
	txtbio.setFont(new Font("Copperplate Gothic",Font.BOLD,30));
	txtbio.setBounds(1250,560,250,40);
    mid.add(txtbio);

	c=new JLabel("C");
	c.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
	c.setBounds(300,640,300,40);
	mid.add(c);
	txtc=new JTextField("0");
	txtc.setFont(new Font("Copperplate Gothic",Font.BOLD,30));
	txtc.setBounds(650,640,250,40);
	mid.add(txtc);

	cpp=new JLabel("CPP");
	cpp.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
	cpp.setBounds(1040,640,250,50);
	mid.add(cpp);
	txtcpp=new JTextField("0");
	txtcpp.setFont(new Font("Copperplate Gothic",Font.BOLD,30));
	txtcpp.setBounds(1250,640,250,40);
    mid.add(txtcpp);

    tot=new JLabel("Total");
   	tot.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
   	tot.setBounds(300,720,300,40);
   	mid.add(tot);
   	txttot=new JTextField("0");
   	txttot.setFont(new Font("Copperplate Gothic",Font.BOLD,30));
   	txttot.setBounds(650,720,250,40);
   	mid.add(txttot);

   	per=new JLabel("Percent");
   	per.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
   	per.setBounds(1040,720,250,40);
   	mid.add(per);
   	txtper=new JTextField("0");
   	txtper.setFont(new Font("Copperplate Gothic",Font.BOLD,30));
   	txtper.setBounds(1250,720,250,40);
    mid.add(txtper);
	add(mid);

	bot=new JPanel();
	bot.setBackground(Color.pink);
	add(bot,"South");
	b1=new JButton("New");
	b1.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
	bot.add(b1);
	b2=new JButton("Save");
    b2.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
    bot.add(b2);
    b3=new JButton("Find");
	b3.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
	bot.add(b3);
    b4=new JButton("Update");
	b4.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
	b4.setEnabled(false);
	bot.add(b4);
    b5=new JButton("Delete");
	b5.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
	b5.setEnabled(false);
	bot.add(b5);
    b6=new JButton("Exit");
	b6.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
	bot.add(b6);

    b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(this);
    b4.addActionListener(this);
    b5.addActionListener(this);
    b6.addActionListener(this);
	stid.addActionListener(this);
	txtphi.addFocusListener(this);
	txtche.addFocusListener(this);
	txtmat.addFocusListener(this);
	txtbio.addFocusListener(this);
	txtc.addFocusListener(this);
	txtcpp.addFocusListener(this);
	txttot.addFocusListener(this);
	txtper.addFocusListener(this);
    Show();

  }
  void Show()
  {
	try
	{
	  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	  Connection con=DriverManager.getConnection("Jdbc:Odbc:sham");
	  Statement st=con.createStatement();
	  ResultSet rs=st.executeQuery("select std from stud");
	  int pk=0;
	  stid.removeAllItems();
	  stid.addItem("");
	  while(rs.next())
	  {
		stid.addItem(rs.getString(1));
	  }
	  con.close();
    }
    catch(Exception e)
    {
	 e.printStackTrace();
	}
  }
  public void focusLost(FocusEvent fe)
  {
	  int a,b,c,d,e,f,g;
	  float per,h;
	  	a=Integer.parseInt(txtphi.getText());
	  	b=Integer.parseInt(txtche.getText());
	  	c=Integer.parseInt(txtmat.getText());
	  	d=Integer.parseInt(txtbio.getText());
	  	e=Integer.parseInt(txtc.getText());
	  	f=Integer.parseInt(txtcpp.getText());
	  	g=Integer.parseInt(txttot.getText());
	  	h=Float.parseFloat(txtper.getText());
	  	g=a+b+c+d+e+f;
	  	txttot.setText(Integer.toString(g));
	  	per=(float)g/6;
	  	txtper.setText(Float.toString(per));


  }
  public void focusGained(FocusEvent f)
  {
	  System.out.println("Gained");
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
	   Update();
	 }
	 else if(ae.getSource()==b5)
	 {
	   Delete();
	 }
	 else if(ae.getSource()==b6)
	 {
	 }
	 else if(ae.getSource()==stid)
	 {
		 ShowRec();
	 }
	 else
	 {}

  }
  void ShowRec()
  {
	  try
	  {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
  	  	Connection con=DriverManager.getConnection("Jdbc:Odbc:sham");
  	  	Statement st=con.createStatement();
  	  	ResultSet rs=st.executeQuery("select std,studname,edu,year from stud where std="+stid.getSelectedIndex());
  	    if(rs.next())
  	    {
			stid.setSelectedIndex(rs.getInt(1));
			txtstn.setText(rs.getString(2));
			txtedu.setText(rs.getString(3));
			txtyr.setText(rs.getString(4));
		}
		con.close();
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
  }
  boolean Valide()
  {
	boolean flag=true;
	String r=(String)stid.getSelectedItem();
	String r1=txtdt.getText();
	String r2=txtstn.getText();
	String r3=txtedu.getText();
	String r4=txtyr.getText();
	String r5=(String)sem.getSelectedItem();
	String r6=txtphi.getText();
	String r7=txtche.getText();
	String r8=txtmat.getText();
	String r9=txtbio.getText();
	String r10=txtc.getText();
	String r11=txtcpp.getText();
	String r12=txttot.getText();
	String r13=txtper.getText();
    if(r.equals(""))
	 {
	   JOptionPane.showMessageDialog(this, "Enter index");
	   flag=false;
	 }
	 else if(r1.equals(""))
	 	 {
	 	   JOptionPane.showMessageDialog(this, "Enter date");
	 	   flag=false;
	 }
	 else if(r2.equals(""))
	 	 {
	 	   JOptionPane.showMessageDialog(this, "Enter stud name");
	 	   flag=false;
	 }
	 else if(r3.equals(""))
	 	 {
	 	   JOptionPane.showMessageDialog(this, "Enter education");
	 	   flag=false;
	 }
	 else if(r4.equals(""))
	 	 {
	 	   JOptionPane.showMessageDialog(this, "Enter Year");
	 	   flag=false;
	 }
	 else if(r5.equals(""))
	 	 {
	 	   JOptionPane.showMessageDialog(this, "Enter Semister");
	 	   flag=false;
	 }
	 else if(r6.equals(""))
	 	 {
	 	   JOptionPane.showMessageDialog(this, "Enter Phisics marks");
	 	   flag=false;
	 }
	 else if(r7.equals(""))
	 	 {
	 	   JOptionPane.showMessageDialog(this, "Enter Chemistry marks");
	 	   flag=false;
	 }

	 else if(r8.equals(""))
	 	 {
	 	   JOptionPane.showMessageDialog(this, "Enter Mathematics marks");
	 	   flag=false;
	 }
	 else if(r9.equals(""))
	 	 {
	 	   JOptionPane.showMessageDialog(this, "Enter Biology marks");
	 	   flag=false;
	 }
	 else if(r10.equals(""))
	 	 {
	 	   JOptionPane.showMessageDialog(this, "Enter c marks");
	 	   flag=false;
	 }
	 else if(r11.equals(""))
	 	 {
	 	   JOptionPane.showMessageDialog(this, "Enter cpp marks");
	 	   flag=false;
	 }
	 else if(r12.equals(""))
	 	 {
	 	   JOptionPane.showMessageDialog(this, "Enter total marks");
	 	   flag=false;
	 }
	 else if(r13.equals(""))
	 	 	 {
	 	 	   JOptionPane.showMessageDialog(this, "Enter Percentage");
	 	 	   flag=false;
	 }

	 else
	  flag=true;

	 return flag;



  }
  void Delete()
    {
  	 try
  	 {
  	  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
  	  Connection con=DriverManager.getConnection("Jdbc:Odbc:sham");
  	  Statement st=con.createStatement();
  	  int i=st.executeUpdate("Delete from marks where studid="+stid.getSelectedIndex());
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
  void Update()
    {
  	try
  	{
      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
      Connection con=DriverManager.getConnection("Jdbc:Odbc:sham");
      Statement st=con.createStatement();
       String query="Update marks set date1='"+txtdt.getText()+"',studn='"+txtstn.getText()+"',edu='"+txtedu.getText()+"',yr='"+txtyr.getText()+"',sem='"+(String)sem.getSelectedItem()+"',phi='"+txtphi.getText()+"',chem='"+txtche.getText()+"',mat='"+txtmat.getText()+"',bio='"+txtbio.getText()+"',c='"+txtc.getText()+"',cpp='"+txtcpp.getText()+"',tot='"+txttot.getText()+"',per='"+txtper.getText()+"' where studid="+stid.getSelectedItem();
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
  void Find()
  {
	try
	{
	  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	  Connection con=DriverManager.getConnection("Jdbc:Odbc:sham");
	  Statement st=con.createStatement();
	  ResultSet rs=st.executeQuery("select * from marks where studid="+Integer.parseInt((String)stid.getSelectedItem()));
	  if(rs.next())
	  {
	    //stid.getSelectedIndex(rs.getString(1));
	    txtdt.setText(rs.getString(2));
	    txtstn.setText(rs.getString(3));
	    txtedu.setText(rs.getString(4));
	    txtyr.setText(rs.getString(5));
	    sem.setSelectedItem(rs.getString(6));
	    txtphi.setText(rs.getString(7));
	    txtche.setText(rs.getString(8));
	    txtmat.setText(rs.getString(9));
	    txtbio.setText(rs.getString(10));
	    txtc.setText(rs.getString(11));
	    txtcpp.setText(rs.getString(12));
	    txttot.setText(rs.getString(13));
	    txtper.setText(rs.getString(14));
	    JOptionPane.showMessageDialog(this,"Record is find");
	    b4.setEnabled(true);
	    b5.setEnabled(true);
	  }
	  else
	    JOptionPane.showMessageDialog(this,"Record is not find");

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
	   if(Valide())
	   {
		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		 Connection con=DriverManager.getConnection("Jdbc:Odbc:sham");
		 PreparedStatement pst=con.prepareStatement("insert into marks values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		 pst.setString(1,(String)stid.getSelectedItem());
		 pst.setString(2,txtdt.getText());
		 pst.setString(3,txtstn.getText());
		 pst.setString(4,txtedu.getText());
		 pst.setString(5,txtyr.getText());
		 pst.setString(6,(String)sem.getSelectedItem());
		 pst.setString(7,txtphi.getText());
		 pst.setString(8,txtche.getText());
		 pst.setString(9,txtmat.getText());
		 pst.setString(10,txtbio.getText());
		 pst.setString(11,txtc.getText());
		 pst.setString(12,txtcpp.getText());
		 pst.setString(13,txttot.getText());
		 pst.setString(14,txtper.getText());
		 int i=pst.executeUpdate();
		 if(i==1)
		  JOptionPane.showMessageDialog(this,"Record is save");
		 else
		  JOptionPane.showMessageDialog(this,"Record not Save");
		 con.close();
		 New();
	  }
	  else
	  {

	  }

	}
	catch(Exception e)
	{
	  e.printStackTrace();
	}
  }
  void New()
  {
    stid.setSelectedItem("");
    //txtdt.setText("");
    txtstn.setText("");
    txtedu.setText("");
    txtyr.setText("");
    sem.setSelectedItem("");
    txtphi.setText("");
    txtche.setText("");
    txtmat.setText("");
    txtbio.setText("");
    txtc.setText("");
    txtcpp.setText("");
    txttot.setText("");
    txtper.setText("");

  }

  public static void main(String args[])
  {
	MarksRegi obj=new MarksRegi();
	obj.setVisible(true);
  }

}