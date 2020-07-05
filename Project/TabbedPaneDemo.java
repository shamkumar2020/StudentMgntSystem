import java.awt.*;
import javax.swing.*;

class TabbedPaneDemo extends JFrame
{
	JPanel stud,c,t,m,n;
	JTabbedPane tab;
	TabbedPaneDemo()
	{
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension dt=tk.getScreenSize();
		int w=dt.width;
		int h=dt.height;
		setSize(w,h);
		setVisible(true);
		setTitle("My Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//setLayout(new BorderLayout());
		stud=new JPanel();
		c=new JPanel();
		stud.setFont(new Font("Constantia",Font.BOLD,70));
		t=new JPanel();
	    m=new JPanel();
	    n=new JPanel();
	    c=new JPanel();
		tab=new JTabbedPane();
		tab.setFont(new Font("Constantia",Font.BOLD,25));

		tab.setTabPlacement(JTabbedPane.TOP);
		tab.addTab("Student Reg",new ImageIcon("img\\ok_Hover.png"),new StudRegistration());
		tab.addTab("Teacher Reg",new ImageIcon("img\\order details.png"),new TeacherRegi());
		tab.addTab("Cource Res",new ImageIcon("img\\box.png"),new CourseReg());
		tab.addTab("Complaint Res",new ImageIcon("img\\Brach.png"),new Complaint());
		tab.addTab("Notice Res",new ImageIcon("img\\Business.png"),new NoticeR());

		add(tab);
	}
	public static void main(String args[])
	{
		TabbedPaneDemo obj=new TabbedPaneDemo();
		obj.setVisible(true);
	}
}