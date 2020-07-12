import java.awt.*;
import javax.swing.*;

class TabbedPaneDemo extends JFrame
{
	JPanel stud,c,t,m,n,mres,res,rep;
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
		tab.addTab("Marks res",new ImageIcon("img\\Business.png"),new MarksRegi());
		tab.addTab("Stud Report",new ImageIcon("img\\Business.png"),new StudReport());
		tab.addTab("Teacher Report",new ImageIcon("img\\Business.png"),new TeacherReport());
		tab.addTab("Course Report",new ImageIcon("img\\Business.png"),new CourceReport());
		tab.addTab("Notice Report",new ImageIcon("img\\Business.png"),new NoticeReport());
		tab.addTab("Complaint Report",new ImageIcon("img\\Business.png"),new ComplaintReport());
		tab.addTab("Marks Report",new ImageIcon("img\\Business.png"),new MarksReport());

		add(tab);
	}
	public static void main(String args[])
	{
		TabbedPaneDemo obj=new TabbedPaneDemo();
		obj.setVisible(true);
	}
}