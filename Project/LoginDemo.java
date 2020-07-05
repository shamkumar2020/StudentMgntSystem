import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class LoginDemo extends JFrame implements ActionListener
{
  JLabel un,up,tit;
  JLabel imgun,imgup;
  JTextField txtun;
  JPasswordField txtup;
  JPanel mid;
  JButton ok,cal;
  LoginDemo()
  {
	setVisible(true);
	setSize(550,400);
	setTitle("My Frame");
	mid=new JPanel();
	mid.setBackground(Color.pink);
	mid.setLayout(null);


	tit=new JLabel("Login Window");
	tit.setFont(new Font("Britannic",Font.BOLD,30));
	tit.setBounds(160,20,250,35);
	mid.add(tit);

	imgun=new JLabel(new ImageIcon("img\\author.png"));
	imgun.setBounds(10,80,100,30);
	mid.add(imgun);

	un=new JLabel("User Id");
	un.setFont(new Font("Britannic",Font.BOLD,25));
	un.setBounds(90,80,250,30);
	mid.add(un);

	txtun=new JTextField();
	txtun.setFont(new Font("Britannic",Font.BOLD,25));
	txtun.setBounds(250,80,200,30);
	mid.add(txtun);

    imgup=new JLabel(new  ImageIcon("img\\Accept.png"));
    imgup.setBounds(10,140,100,30);
    mid.add(imgup);
	up=new JLabel("Password");
	up.setFont(new Font("Britannic",Font.BOLD,25));
	up.setBounds(90,140,250,30);
	mid.add(up);
    txtup=new JPasswordField();
    txtup.setFont(new Font("Britannic",Font.BOLD,25));
    txtup.setBounds(250,140,200,30);
    mid.add(txtup);

    ok=new JButton("Ok", new ImageIcon("img\\tick.png"));
    ok.setFont(new Font("Britannic",Font.BOLD,25));
    ok.setBounds(90,220,120,50);
    mid.add(ok);
    cal=new JButton("Reset",new ImageIcon("img\\add.png"));
    cal.setFont(new Font("Britannic",Font.BOLD,25));
    cal.setBounds(310,220,150,50);
    mid.add(cal);

   add(mid);
   ok.addActionListener(this);
   cal.addActionListener(this);
  }
  public void actionPerformed(ActionEvent ae)
  {

   if(ae.getSource()==ok)
   {
	 try
	 {
	  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	  System.out.println("Driver is loaded");
	  Connection con=DriverManager.getConnection("Jdbc:Odbc:sham");
	  System.out.println("connection is crated");
	  Statement st=con.createStatement();
	  ResultSet rs=st.executeQuery("select * from login where uname='"+txtun.getText()+"' and pass='"+txtup.getText()+"'");
	  if(rs.next())
	  {
		JOptionPane.showMessageDialog(this,"Login Successfully");
         new TabbedPaneDemo();
         setVisible(false);
	  }
	  else
	  {
		JOptionPane.showMessageDialog(this,"Invalid Login");
	  }
	 }
	 catch(Exception e)
	 {
	   e.printStackTrace();
	 }

   }
   if(ae.getSource()==cal)
   {}
}
  public static void main(String args[])
  {
	LoginDemo obj=new LoginDemo();
	obj.setVisible(true);
  }
}