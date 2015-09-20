package Main;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Dish {
	public  String name = null;//菜名
	public	int fenshu = 0;//份数
	public  int price;//价格
	public	int classify;//分类
	public JLabel l = new JLabel(); 
	public JTextField t = new JTextField();// 输入份数用
	public JLabel l_state = new JLabel();//状态label
	public JComboBox c_score = new JComboBox();//评分label
    public static ArrayList<Dish>  dishList; //点单队列	
    public int state = -1; //状态0未点 1已点 2已做完 
	public static Dish[] dishes = new Dish[30];
	
	public static void initialize()
	{
		//初始化所有的菜。。。
		dishes[0] = new Dish("泸州烤鸭" , 40);
		dishes[1] = new Dish("石耳炖鸡" , 35);
		dishes[2] = new Dish("腐乳爆肉" , 50);
		dishes[3] = new Dish("方腊鱼" , 45);
		dishes[4] = new Dish("出骨刀鱼" , 55);
		dishes[5] = new Dish("地锅鸡" , 60);
		dishes[6] = new Dish("明太子奶油海鲜乌冬面" , 26);
		dishes[7] = new Dish("台湾手抓饼", 8);
		dishes[8] = new Dish("山东煎饼", 8);
		dishes[9] = new Dish("麦当劳薯条", 9);
		dishes[10] = new Dish("肯德基鸡翅", 10);
		dishes[11] = new Dish("葡式蛋挞", 14);
		dishes[12] = new Dish("布丁芋圆烧仙草", 15);
		dishes[13] = new Dish("花生糊汤丸子", 20);
		dishes[14] = new Dish("章鱼小丸子", 12);
		dishes[15] = new Dish("伯爵奶茶", 10);
		dishes[16] = new Dish("清新绿茶", 10);
		dishes[17] = new Dish("统一红茶", 10);
		dishes[18] = new Dish("雀巢咖啡", 10);
		dishes[19] = new Dish("蓝山咖啡", 10);
		dishes[20] = new Dish("卡布奇诺", 10);
		dishes[21] = new Dish("超浓拿铁", 10);
		dishes[23] = new Dish("沙爹红茶", 10);
		
	}
	
	
	public static String duizheng(String n1)//orz我发现很难保证让菜名和后面的---对整齐所以就写了这个函数专门为了对准。。。
	{
		String wtf = "";
		int s = 11 - n1.length();
		for( int n = 0; n < s ; n ++)
		{
			wtf = wtf + "-";
		}
		return wtf;
	}
	
	 public Dish(String name, int p)
	 {
		this.name = name;
		this.price = p;
		this.l.setText(name + Dish.duizheng(name) + price + "\u00A5" + "            ");
		this.t.setColumns(5);
		this.t.setToolTipText("\u586B\u5199\u4EFD\u6570");
		this.l_state = new JLabel("还未制作");
		this.l_state.setForeground(Color.red);
		this.l.setHorizontalAlignment(SwingConstants.CENTER);
		//this.l.setVerticalAlignment(SwingConstants.TOP);
		this.l_state.setHorizontalAlignment(SwingConstants.CENTER);
		//this.l_state.setVerticalAlignment(SwingConstants.TOP);
		this.c_score.setModel(new DefaultComboBoxModel(new String[] {"1","2","3","4","5"}));
	 }
	 
	 public static void getfenshu()
	 {
		 for (int n = 0; n < 21 ; n ++)
		 {
			 if(Dish.dishes[n].t.getText().length() != 0)
			 {
			 Dish.dishes[n].fenshu = Integer.parseInt(Dish.dishes[n].t.getText());
			 Dish.dishes[n].state = 0;//这里把每个dish的状态初始化为0
			 }
		 }
	 }
	 
	 public static void order(Dish dish)
	 {
		 if(Dish.dishList.size() < 5){
			 Dish.dishList.add(dish);
			 dish.state=1;
			 
			 System.out.println(dish.name + "入队");
			 dish.updatestate();
		 } 
	 }
	 
	 public static void finish()
	 {  
		 if(Dish.dishList.size()!=0)
		 {
			 Dish.dishList.get(0).state = 2;
			 System.out.println(Dish.dishList.get(0).name +"出队");
			 Dish.dishList.get(0).fenshu = 0;//份数归零放在入队否则还未出队的菜会重复入队
			 Dish.dishList.get(0).updatestate();//更新在前！不然下面那个会去掉第一个还更新个P
			 Dish.dishList.remove(0);
			 
		 }
	 }
	 
	 public void updatestate()
	 {
		 if(this.state == 0)
		 {
			 this.l_state.setText("还未制作Unproduce");
			 this.l_state.setForeground(Color.red);
		 }
		 else if (this.state == 1)
		 {
			 this.l_state.setText("制作中Producing");
			 this.l_state.setForeground(Color.yellow);
			 
		 }
		 else if (this.state == 2)
		 {
			 this.l_state.setText("制作完成Complete");
			 this.l_state.setForeground(Color.green);
		 }
		 this.l_state.validate();
		 this.l_state.updateUI();
	 }
	
	
	


			
}
