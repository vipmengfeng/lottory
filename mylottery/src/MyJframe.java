import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;


public class MyJframe extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Color lightBlue = new Color(153, 204, 255);
	
	public void run(ArrayList<String> AL,String title,int x,int y) {
	JFrame frame = new JFrame(title);
	//frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    DefaultListModel model = new DefaultListModel();
	for(int i=0;i<AL.size();i++)
	{
		model.addElement(AL.get(i));
	}
	JList jta=new JList(model);
	JScrollPane scp=new JScrollPane(jta);
	
	frame.getContentPane().add(scp, BorderLayout.CENTER);
	jta.setSize(100, 20);
	//Display the window.
	frame.pack();
	frame.setSize(400, 10);
	
	frame.setLocation(x, y);
	//frame.setLocationRelativeTo(null);
	//frame.show();
	//com.sun.awt.AWTUtilities.setWindowOpacity(frame, 0.00f);
	frame.setVisible(true);
	for(int i=0;i<50;i++){
		try{
		Thread.sleep(2);
		//com.sun.awt.AWTUtilities.setWindowOpacity(frame, i*0.02f);
		}catch (InterruptedException e){}
	}
    //Thread.sleep(10);
	}

	public static Color getLightblue() {
		return lightBlue;
	}

}
