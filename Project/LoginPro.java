import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class LoginPro extends JFrame
{
  JLabel un,up,tit;
  JLabel imgun,imgup;
  JPanel mid;
  JTextField txtun;
  JPasswordField txtup;
  JButton ok,reset;
  LoginPro()
  {
	setVisible(true);
	setSize(500,500);
	setTitle("My Frame");

	mid=new JPanel();
	mid.setBackground(Color.pink);
	mid.setLayout(null);

	tit=new JLabel("Login Window");
	tit.setFont(new Font("Britannic",Font.BOLD,30));
	tit.setBounds(100,20,400,40);
	mid.add(tit);

	up=new JLabel("User Id");
	up.setFont(new Font("Britannic",Font.BOLD,30));
	up.setBounds(20,70,400,40);
	mid.add(up);



	add(mid);
  }
  public static void main(String args[])
  {
	LoginPro obj=new LoginPro();
	obj.setVisible(true);
  }
}