import java.awt.*;
import javax.swing.*;
public class SplashWindow extends JWindow implements Runnable
{
	Thread t;
	JLabel slabel;
	public SplashWindow()
	{
		setLayout(null);
		setSize(700,550);
		setVisible(true);
		t=new Thread();
		slabel=new JLabel(new ImageIcon("img\\abc.jpg"));
		add(slabel);
		slabel.setBounds(0,0,700,550);

		Dimension dt=Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(450,200);
		start();
	}
	public void start()
	{
		try
		{
			t.sleep(9000);
			for(int i=1;i<=100;i++)
			{
				if(i==99)
				stop();
			}
		}
		catch(Exception e)
		{
		}
	}
	public void run()
	{
	}
	public void stop()
	{
		this.dispose();
		new LoginDemo().setVisible(true);
	}
	public static void main(String args[])
	{
		SplashWindow obj=new SplashWindow();
	}
}