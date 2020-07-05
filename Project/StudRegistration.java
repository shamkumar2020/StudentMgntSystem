import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.text.*;
import java.util.Date;
class StudRegistration extends JPanel implements ActionListener
{
  JPanel top,bottom,middle;
  JLabel tit,jl3,gen,add,combo,ct,yr;
  JTextArea jta;
  JComboBox jcb,ct1;
  JRadioButton male,female;
  JButton b1,b2,b3,b4,b5,b6;
  JTextField jtf,jtf1,jtf2,yrt;
  StudRegistration()
  {
	 setVisible(true);
	 Toolkit tk=Toolkit.getDefaultToolkit();
	 Dimension dt=tk.getScreenSize();
	 int h=dt.height;
	 int w=dt.width;
	 setSize(w,h);
	 setLayout(new BorderLayout());
	 //setTitle("My Frame");

	 top=new JPanel();
	 top.setBackground(Color.yellow);
	 tit=new JLabel("Student Information");
	 tit.setFont(new Font("Britannic",Font.BOLD,50));
	 top.add(tit);
	 add(top,"North");

	 middle=new JPanel();
	 middle.setLayout(null);
	 middle.setBackground(Color.pink);
     JLabel jl1=new JLabel("Student Id");
     jl1.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
     jl1.setBounds(200,70,250,60);
     middle.add(jl1);
     add(middle);
     jtf=new JTextField();
     jtf.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
     jtf.setBounds(520,70,400,60);
     middle.add(jtf);

     JLabel jl2=new JLabel("Date");
     jl2.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
     jl2.setBounds(1050,70,200,60);
     middle.add(jl2);
     jtf1=new JTextField();
	 jtf1.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
	 jtf1.setBounds(1200,70,300,60);
	 middle.add(jtf1);
	 //Date logic
	 String pattern="dd-MMMM-yyyy";
	 SimpleDateFormat sdf=new SimpleDateFormat(pattern);
	 String date=sdf.format(new Date());
	 jtf1.setText(date);

     jl3=new JLabel("Student Name");
     jl3.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
     jl3.setBounds(200,180,350,60);
     middle.add(jl3);
     jtf2=new JTextField();
	 jtf2.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
	 jtf2.setBounds(520,180,980,60);
	 middle.add(jtf2);

    add=new JLabel("Address");
    add.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
    add.setBounds(200,280,350,60);
    middle.add(add);
    jta=new JTextArea(20,80);
    jta.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
    jta.setBounds(520,280,980,200);
    //middle.add(jta);
    int hor=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
	    int ver=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
	    JScrollPane jsp=new JScrollPane(jta,ver,hor);
	  //jta.add(jsp);
	  middle.add(jta);



    gen=new JLabel("Gender");
    gen.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
    gen.setBounds(200,550,300,60);
    middle.add(gen);

    male=new JRadioButton("Male");
    male.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
    male.setBounds(520,550,200,60);
    female=new JRadioButton("Female");
    female.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
	female.setBounds(820,550,200,60);
    ButtonGroup gr=new ButtonGroup();
    gr.add(male);
    gr.add(female);
	middle.add(female);
    middle.add(male);

     combo=new JLabel("Education");
     combo.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
     combo.setBounds(200, 660,300,60);
     middle.add(combo);
     String s1[]={"","SSC","HSC","Graduate","Post-Graduate"};
     jcb=new JComboBox(s1);
     jcb.setFont(new Font("Copperplate Gothic",Font.BOLD,30));
     jcb.setBounds(520,660,300,60);
     middle.add(jcb);

    ct=new JLabel("City");
    ct.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
    ct.setBounds(1030,660,300,60);
    middle.add(ct);
    String s2[]={"","pune","Mumbai","chennai","Delhi","Kolkata"};
    ct1=new JComboBox(s2);
    ct1.setFont(new Font("Copperplate Gothic",Font.BOLD,30));
    ct1.setBounds(1190,660,300,60);
    middle.add(ct1);

    yr=new JLabel("Year");
    yr.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
    yr.setBounds(200,760,300,60);
    middle.add(yr);
    yrt=new JTextField();
    yrt.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
    yrt.setBounds(520,760,300,60);
    middle.add(yrt);

    bottom=new JPanel();
    bottom.setLayout(new FlowLayout(1,50,10));
    bottom.setBackground(Color.red);
    add(bottom,"South");

    b1=new JButton("New");
    b1.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
    bottom.add(b1);
    b2=new JButton("Save");
	b2.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
    bottom.add(b2);
    b3=new JButton("Find");
	b3.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
    bottom.add(b3);
    b4=new JButton("Update");
	b4.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
    b4.setEnabled(false);
    bottom.add(b4);
    b5=new JButton("Delete");
	b5.setFont(new Font("Copperplate Gothic",Font.BOLD,40));
    b5.setEnabled(false);
    bottom.add(b5);
    b6=new JButton("Exit");
	b6.setFont(new Font("Constantia",Font.BOLD,40));
    bottom.add(b6);
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
		   System.out.println("Driver is loaded");
		   Connection con=DriverManager.getConnection("Jdbc:Odbc:sham");
		   System.out.println("Connection is created");
		   Statement st=con.createStatement();
		   ResultSet rs=st.executeQuery("select max(std) from Stud");
		   int pk=0;
		   if(rs.next())
		   {
			   pk=rs.getInt(1);
		   }
		   pk=pk+1;
		   jtf.setText(Integer.toString(pk));
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
		 Update();
	 }
	 else if(ae.getSource()==b5)
	 {
		 Delete();
	 }
	 else if(ae.getSource()==b6)
	 {}
	 else
	 {}

  }
  void Update()
  {
	  try
	  {
		   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		   System.out.println("Driver is loaded");
		   Connection con=DriverManager.getConnection("Jdbc:Odbc:sham");
		   System.out.println("Connection is created");
		   Statement st=con.createStatement();
		   String msg="";
		   if(male.isSelected())
			{
				msg="Male";
			}
			else if(female.isSelected())
			{
				msg="Female";
			}
			String query="Update Stud set date1='"+jtf1.getText()+"',studname='"+jtf2.getText()+"',add='"+jta.getText()+"',gen='"+msg+"',edu='"+(String)jcb.getSelectedItem()+"',city='"+(String)ct1.getSelectedItem()+"',year='"+yrt.getText()+"' where std="+Integer.parseInt(jtf.getText());
		   System.out.println(query);
		   int i=st.executeUpdate(query);
			if(i==1)
		   JOptionPane.showMessageDialog(this,"Record is Update");
		   else
		   JOptionPane.showMessageDialog(this,"Record is Not Update");
			b4.setEnabled(true);
			b5.setEnabled(true);
			New();
			con.close();
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
		   System.out.println("Driver is loaded");
		   Connection con=DriverManager.getConnection("Jdbc:Odbc:sham");
		   System.out.println("Connection is created");
		   Statement st=con.createStatement();
		   int i=st.executeUpdate("delete from Stud where std="+Integer.parseInt(jtf.getText()));

		   if(i==1)
		   JOptionPane.showMessageDialog(this,"Record is Delete");
		   else
		   JOptionPane.showMessageDialog(this,"Record is Not Delete");
			b4.setEnabled(true);
			b5.setEnabled(true);
			New();
			con.close();
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
		   System.out.println("Connection is created");
		   Statement st=con.createStatement();
		   ResultSet rs=st.executeQuery("select * from Stud where std="+Integer.parseInt(jtf.getText()));
		   if(rs.next())
		   {
			 	jtf.setText(rs.getString(1));
				jtf1.setText(rs.getString(2));
				jtf2.setText(rs.getString(3));
				jta.setText(rs.getString(4));
				String m=rs.getString(5);
				if(m.equals("Male"))
				{
					male.setSelected(true);
				}
				else if(m.equals("Female"))
				{
					female.setSelected(true);
				}
				jcb.setSelectedItem(rs.getString(6));
				ct1.setSelectedItem(rs.getString(7));
				yrt.setText(rs.getString(8));
				b4.setEnabled(true);
				b5.setEnabled(true);

				JOptionPane.showMessageDialog(this,"Record is Find");
		         con.close();
		   }
		   else
		   	JOptionPane.showMessageDialog(this,"Record is Not Find");


	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
  }
  boolean Valide()
  {
	  boolean flag=true;
	  String r=jtf.getText();
	  String r1=jtf1.getText();
	  String r2=jtf2.getText();
	  String r3=jta.getText();
	  String r4=(String)jcb.getSelectedItem();
	  String r5=(String)ct1.getSelectedItem();
	  String r6=yrt.getText();

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
	  	 JOptionPane.showMessageDialog(this,"Enter Name");
	  	 flag=false;
	  }
	  else if(r3.equals(""))
	  {
	  	  JOptionPane.showMessageDialog(this,"Enter Address");
	  	  flag=false;
	  }
	  else if(male.isSelected()==false && female.isSelected()==false)
	  	  {
	  	  	JOptionPane.showMessageDialog(this,"Select Gender");
	  	  	flag=false;
	  }
	  else if(r4.equals(""))
	  	  {
	  	  	JOptionPane.showMessageDialog(this,"Select Education");
	  	  	flag=false;
	  }
	  else if(r5.equals(""))
	  	  {
	  	  	JOptionPane.showMessageDialog(this,"Select city");
	  	  	flag=false;
	  }
	  else if(r6.equals(""))
	  	  {
	  	  	JOptionPane.showMessageDialog(this,"Enter Year");
	  	  	flag=false;
	  }
	  else
	  flag=true;

	  return flag;

  }
  void Save()
  {
	  try
	  {

		if(Valide())
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("Driver is loaded");
			Connection con=DriverManager.getConnection("Jdbc:Odbc:Sham");
			System.out.println("Connection is created");
			PreparedStatement pst=con.prepareStatement("insert into Stud values(?,?,?,?,?,?,?,?)");
			pst.setInt(1,Integer.parseInt(jtf.getText()));
			pst.setString(2,jtf1.getText());
			pst.setString(3,jtf2.getText());
			pst.setString(4,jta.getText());
			String msg="";//male.getText();
			//System.out.print(msg);
			if(male.isSelected())
			msg="Male";
			else if(female.isSelected())
			msg="Female";

			pst.setString(5,msg);
			pst.setString(6,(String)jcb.getSelectedItem());
			pst.setString(7,(String)ct1.getSelectedItem());
			pst.setString(8,yrt.getText());
			int i=pst.executeUpdate();
			System.out.println(i);
			if(i==1)
			JOptionPane.showMessageDialog(this,"Record is Save");
			else
			JOptionPane.showMessageDialog(this,"Record is Not Save");
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
	jtf.setText("");
	//jtf1.setText("");
	jtf2.setText("");
	yrt.setText("");
	jta.setText("");
	jcb.setSelectedItem("");
	ct1.setSelectedItem("");
	Show();
  }
  public static void main(String args[])
  {
	StudRegistration obj=new StudRegistration();
	obj.setVisible(true);

  }
}