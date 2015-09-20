package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.ScrollPane;

import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import java.awt.Color;

public class OrderFrame {

	private JFrame frame;
	
	private static Dish[] dishes = Dish.dishes;//这是用来存储全部菜的对象数组

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//Dish.initialize();
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					OrderFrame window = new OrderFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OrderFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 514);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel Content = new JPanel();
		frame.getContentPane().add(Content, BorderLayout.CENTER);
		Content.setLayout(new BorderLayout(0, 0));
		
		JPanel Title = new JPanel();
		Content.add(Title, BorderLayout.NORTH);
		
		JLabel label = new JLabel("");
		
		label.setIcon(new ImageIcon(OrderFrame.class.getResource("QQ\u622A\u56FE20150611171646.png")));
		Title.add(label);
		
		JPanel State = new JPanel();
		Content.add(State, BorderLayout.CENTER);
		State.setLayout(new BoxLayout(State, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setSize(new Dimension(500, 0));
		State.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		//这一块是标题
		JPanel title2 = new JPanel();
		panel.add(title2, BorderLayout.NORTH);
		title2.setLayout(new GridLayout(0, 4, 0, 0));
		
		JLabel label_1 = new JLabel("\u83DC\u540D name");
		label_1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 18));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setVerticalAlignment(SwingConstants.TOP);
		title2.add(label_1);
		
		JLabel label_2 = new JLabel("\u4EFD\u6570 number");
		label_2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 18));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setVerticalAlignment(SwingConstants.TOP);
		title2.add(label_2);
		
		JLabel label_3 = new JLabel("\u72B6\u6001 state");
		label_3.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 18));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setVerticalAlignment(SwingConstants.TOP);
		title2.add(label_3);
		
		JLabel label_4 = new JLabel("\u8BC4\u5206 score");
		label_4.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 18));
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setVerticalAlignment(SwingConstants.TOP);
		title2.add(label_4);
		//标题结束，现在准备加上Dish类里的内容
		JScrollPane scrollPane = new JScrollPane();
		JPanel panel_content = new JPanel();
		scrollPane.setViewportView(panel_content);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED );
		//scrollPane.add(panel_content);
		panel_content.setLayout(new BoxLayout(panel_content, BoxLayout.Y_AXIS));
		panel.add(scrollPane,SwingConstants.CENTER);
		for(int n = 0; n < 21; n ++)
		{
			if(Dish.dishes[n].fenshu != 0)
			{
				JPanel panel_dish = new JPanel();
				panel_content.add(panel_dish);
				panel_dish.setPreferredSize(new Dimension(500, 0));
				panel_dish.setLayout(new GridLayout(0, 4, 0, 0));
				panel_dish.add(dishes[n].l);
				JLabel l_fenshu = new JLabel(String.valueOf(Dish.dishes[n].fenshu));
				panel_dish.add(l_fenshu);
				l_fenshu.setHorizontalAlignment(SwingConstants.CENTER);
				//System.out.println(String.valueOf(Dish.dishes[n].fenshu)+"fuck");
				panel_dish.add(dishes[n].l_state);
				panel_dish.add(dishes[n].c_score);
				//panel_content.add(panel_dish);
			}
		}
		
		

		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblPrice = new JLabel("\u603B\u4EF7 Price\uFF1A        ");
		lblPrice.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 18));
		panel_2.add(lblPrice);
		
		JLabel l_price = new JLabel(String.valueOf(getprice()));
		l_price.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 18));
		panel_2.add(l_price);
		
		JButton button = new JButton("\u70B9\u51FB\u8F6C\u5230\u652F\u4ED8\u754C\u9762");
		panel_2.add(button);
		
		JPanel QR = new JPanel();
		QR.setBorder(new LineBorder(new Color(0, 0, 0)));
		State.add(QR);
		QR.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		QR.add(panel_3, BorderLayout.NORTH);
		
		JLabel label_5 = new JLabel("\u626B\u63CF\u4E8C\u7EF4\u7801\r\n \u652F\u4ED8\u8BA2\u5355");
		label_5.setHorizontalAlignment(SwingConstants.TRAILING);
		label_5.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 22));
		panel_3.add(label_5);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(OrderFrame.class.getResource("eleme.png")));
		QR.add(lblNewLabel, BorderLayout.CENTER);
		
		frame.setLocationRelativeTo(null);
	}

	public int getprice() {
		// TODO 自动生成的方法存根
		int sum = 0;
		for(int n = 0; n < 21; n ++)
		{
			sum = sum + Dish.dishes[n].price * Dish.dishes[n].fenshu;
		}
		return sum;
	}

}
