package Main;

import java.awt.EventQueue;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;

import javax.swing.ImageIcon;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.border.CompoundBorder;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.Point;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


import java.lang.String;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JProgressBar;
public class QueueFrame {

	private JFrame frame;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblNewLabel_2;
    private static int time = 10;
    private static JLabel timelabel;
    private static Thread t1;
    private static QueueFrame window;
    private static JProgressBar progressBar;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new QueueFrame();
					window.frame.setVisible(true);
					System.out.println(QueueFrame.class.getResource("SE餐厅title.jpg"));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		 t1 = new Thread(new Runnable() {    //新线程为了更新时间

			@Override
				public void run() {
				for( ;time > 0 ;){
					try {
						Thread.sleep(1000);
						time--;
						timelabel.setText(String.valueOf(time) + "s" );
						System.out.println(time);
						progressBar.updateUI();
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						}
				}
			});
		 
	}

	/**
	 * Create the application.
	 */
	public QueueFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		frame.getContentPane().setBackground(new Color(255, 51, 51));
		frame.getContentPane().setForeground(new Color(152, 251, 152));
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.setSize(new Dimension(462, 449));
		panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("");
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(QueueFrame.class.getResource("start_title.PNG")));
		//lblNewLabel.setIcon(new ImageIcon(frame.getClass().getResource("src//Main//SE餐厅title.jpg")));
		panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout());
		
		JLabel lblNewLabel_1 = new JLabel("<html>"
				+ "<div>"
				+ "<center>点击此按钮加入队列</center><br/>"
				+ "<center>Click here to enter the queue.</center>"
				+ "</div>"
				+ "<html>");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		//lblNewLabel_1.setBounds(94, 8, 240, 119);
		lblNewLabel_1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
		panel_1.add(lblNewLabel_1,BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("Enter");
		//btnNewButton.setBounds(163, 167, 113, 49);
		//btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewButton.setActionCommand("Enter");
		btnNewButton.addActionListener(new ButtonListener());
		panel_1.add(btnNewButton,BorderLayout.SOUTH);
		
		
		
		
		panel_2 = new JPanel();
		panel_2.setLayout(new BorderLayout());
		lblNewLabel_2 = new JLabel("<html>"
				+ "<div>"
				+ "<center>您还需要排队的时间是：</center><br/>"
				+ "<center>The Time you need to wait is:</center>"
				+ "</div>"
				+ "<html>");
		//lblNewLabel_2.setBounds(89, 0, 240, 119);
		lblNewLabel_2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_2,BorderLayout.CENTER);
		
		timelabel = new JLabel(time + "s");//这里需要一个定时器？随时减少至0
		timelabel.setFont(new Font("宋体", Font.BOLD, 30));
		timelabel.setBounds(175, 137, 113, 49);
		timelabel.addPropertyChangeListener(new TimeListener());
		timelabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		progressBar = new JProgressBar();//这是进度条
		progressBar.setValue(100 - time * 10);
		panel_2.add(progressBar, BorderLayout.SOUTH);

		panel_2.add(timelabel,BorderLayout.SOUTH);
		//frame.setBounds(180, 100, 458, 440);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		
	}
	class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			if("Enter" == e.getActionCommand() )
			{
				
				
				frame.getContentPane().remove(panel_1);
				frame.getContentPane().add(panel_2, BorderLayout.CENTER);
				frame.getContentPane().validate();
				t1.start();
				
			}
			if("menu" == e.getActionCommand())
			{
				//MenuFrame menuframe = new MenuFrame();
				MenuFrame.main(null);
				frame.setVisible(false);
			}
		}
	}
	
	class TimeListener implements PropertyChangeListener{

		@Override
		public void propertyChange(PropertyChangeEvent e) {
			// TODO Auto-generated method stub
			if(time == 0)
			{
				time = -1;//这里是为了让时间更新线程停止更新
				
				lblNewLabel_2.setText("<html>"
				+ "<div>"
				+ "<center>久等了！请点击按钮进入菜单选择界面</center><br/>"
				+ "<center>Thank you and please click the button to enter menu.</center>"
				+ "</div>"
				+ "<html>");
				
				JButton menu = new JButton("MENU");
				menu.setBounds(151, 177, 113, 49);
			    menu.setFont(new Font("宋体", Font.BOLD, 30));
			    menu.setActionCommand("menu");
			    menu.addActionListener(new ButtonListener());
			    menu.setHorizontalAlignment(SwingConstants.CENTER);
				panel_2.add(menu, BorderLayout.SOUTH);
				panel_2.remove(timelabel);
				panel_2.validate();
				panel_2.updateUI();
				//MenuFrame menuframe = new MenuFrame();
				//MenuFrame.main(null);
			}
			
		}
		
	}

}
