package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Window.Type;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.FlowLayout;

import javax.swing.UIManager;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuFrame {

	private JFrame frame;
	private static Dish[] dishes = Dish.dishes;//这是用来存储全部菜的对象数组
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		Dish.initialize();
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuFrame window = new MenuFrame();
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
	public MenuFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 532);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel content = new JPanel();
		frame.getContentPane().add(content, BorderLayout.CENTER);
		content.setLayout(new BorderLayout(0, 0));
		
		JPanel title = new JPanel();
		content.add(title, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("");
		
		lblNewLabel.setIcon(new ImageIcon(MenuFrame.class.getResource("QQ\u622A\u56FE20150611162551.png")));
		title.add(lblNewLabel);
		
		JPanel meal = new JPanel();
		content.add(meal, BorderLayout.CENTER);
		meal.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		meal.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(UIManager.getBorder("Menu.border"));
		panel.add(panel_4);
		
		JLabel lblStaple = new JLabel("\u4E3B\u98DF  Staple           ");
		lblStaple.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 18));
		panel_4.add(lblStaple);
		
		for(int n = 0; n < 7; n ++)//增加7个panel_dish给主食类
		{
			JPanel panel_dish = new JPanel();
			panel_dish.setLayout(new FlowLayout(FlowLayout.RIGHT, 1, 5));
			panel.add(panel_dish);
			panel_dish.add(dishes[n].l);
			panel_dish.add(dishes[n].t);
		}
		

		
		//这里开始进入类别2
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		meal.add(panel_1);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBorder(UIManager.getBorder("Menu.border"));
		panel_1.add(panel_10);
		
		JLabel lblSnack = new JLabel("\u5C0F\u5403 Snack");
		lblSnack.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 18));
		lblSnack.setLabelFor(panel_1);
		panel_10.add(lblSnack);
		for(int n = 7; n < 14; n ++)//增加7个panel_dish给小吃类
		{
			JPanel panel_dish = new JPanel();
			panel_dish.setLayout(new FlowLayout(FlowLayout.RIGHT, 1, 5));
			panel_1.add(panel_dish);
			panel_dish.add(dishes[n].l);
			panel_dish.add(dishes[n].t);
		}
		
		
//		这里开始饮品的Panel
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		meal.add(panel_2);
		
		JPanel panel_19 = new JPanel();
		panel_19.setBorder(UIManager.getBorder("Menu.border"));
		panel_2.add(panel_19);
		
		JLabel lblDrinks = new JLabel("\u996E\u54C1 Drinks");
		panel_19.add(lblDrinks);
		lblDrinks.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 18));
		for(int n = 14; n < 21; n ++)//增加7个panel_dish给饮品类
		{
			JPanel panel_dish = new JPanel();
			panel_dish.setLayout(new FlowLayout(FlowLayout.RIGHT, 1, 5));
			panel_2.add(panel_dish);
			panel_dish.add(dishes[n].l);
			panel_dish.add(dishes[n].t);
		}
		
		
		JPanel panel_27 = new JPanel();
		panel_27.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		content.add(panel_27, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_2 = new JLabel("\u70B9\u51FB\u6309\u94AE\u67E5\u770B\u5236\u4F5C\u8FDB\u7A0B\u5E76\u751F\u6210\u8BA2\u5355\r\nClick the button to check the state and the order");
		panel_27.add(lblNewLabel_2);
		
		JButton button = new JButton("\u751F\u6210\u8BA2\u5355");
		button.addActionListener(new ButtonListener());
		panel_27.add(button);
		
		frame.setLocationRelativeTo(null);
	}
	
	
	class ButtonListener implements ActionListener{
		
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		//OrderFrame order = new OrderFrame();
		Dish.getfenshu();
		OrderFrame.main(null);
		frame.setVisible(false);
		
		Task.test();
	}
	}

}
