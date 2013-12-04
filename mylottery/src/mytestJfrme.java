import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.Font;

/**
 * 窗体程序入口
 * @author meng
 *
 */
public class mytestJfrme extends JFrame {
	/**
	 * 数据分析
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private String url="";
	MyDatas md=new MyDatas();
	public static ArrayList<String> dataArray = new ArrayList<String> ();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mytestJfrme frame = new mytestJfrme();
					frame.setTitle("我的足彩分析");
					//Display the window.
					frame.pack();
					frame.setSize(450, 350);
					//frame.setUndecorated(true);
					frame.setLocationRelativeTo(null);
					//com.sun.awt.AWTUtilities.setWindowOpacity(frame, 0.02f);
					frame.setVisible(true);
					for(int i=0;i<50;i++){
						Thread.sleep(5);
						//com.sun.awt.AWTUtilities.setWindowOpacity(frame, i*0.02f);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 创建窗口以及控件
	 */
	public mytestJfrme() {
		getContentPane().setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(70, 130, 180));
		panel.setBounds(328, 98, 399, 92);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED,Color.white,new Color(148,145,140)));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("2.请选择对比方式");
		lblNewLabel.setBounds(117, 6, 200, 16);
		panel.add(lblNewLabel);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("横向对比");
		rdbtnNewRadioButton.setBounds(6, 39, 84, 23);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("纵向对比");
		rdbtnNewRadioButton_1.setBounds(95, 39, 84, 23);
		panel.add(rdbtnNewRadioButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(95, 158, 160));
		panel_1.setBounds(328, 6, 400, 80);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED,Color.white,new Color(148,145,140)));
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("1.请首先选择走势表");
		lblNewLabel_1.setBounds(116, 6, 261, 16);
		panel_1.add(lblNewLabel_1);
		textField = new JTextField();
		textField.setBounds(6, 34, 300, 28);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("选择");
		btnNewButton.setBounds(307, 34, 70, 29);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("开始");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				md.ReadDatas(url);
				for(int i=1;i<=14;i++)
				{
					md.zongxiang(i, 4,true);
				}
			}
		});
		btnNewButton_1.setBounds(328, 214, 117, 29);
		getContentPane().add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(119, 136, 153));
		panel_2.setBounds(30, 47, 205, 353);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label_1 = new JLabel("\u5BF9\u9635");
		label_1.setBounds(80, 6, 33, 16);
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel("\u9009\u9879");
		label_2.setBounds(155, 6, 33, 16);
		panel_2.add(label_2);
		
		JLabel lblNewLabel_2 = new JLabel("\u573A\u6B21");
		lblNewLabel_2.setBounds(6, 6, 41, 16);
		panel_2.add(lblNewLabel_2);
		
		JLabel label = new JLabel("\u672C\u8F6E\u5BF9\u9635");
		label.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		label.setForeground(new Color(255, 255, 255));
		label.setBounds(101, 20, 61, 16);
		getContentPane().add(label);
		btnNewButton.addActionListener(new ActionListener() {  
        public void actionPerformed(ActionEvent event) {  
            	btnNewButtonActionActionPerformed(event);  
            }
        });
	}
/**
 * "选择"按钮点击事件
 * @param event
 */
	protected void btnNewButtonActionActionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		JFileChooser jfc=new JFileChooser();
		jfc.setDialogTitle("请选择走势表文本");
		getContentPane().add(jfc);
		int i=jfc.showOpenDialog(this);
		if(i==JFileChooser.APPROVE_OPTION){
            File file=jfc.getSelectedFile();
            String URL=file.getPath();
            this.url=URL;
            textField.setText(URL);
            }
	}
}
