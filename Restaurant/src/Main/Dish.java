package Main;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Dish {
	public  String name = null;//����
	public	int fenshu = 0;//����
	public  int price;//�۸�
	public	int classify;//����
	public JLabel l = new JLabel(); 
	public JTextField t = new JTextField();// ���������
	public JLabel l_state = new JLabel();//״̬label
	public JComboBox c_score = new JComboBox();//����label
    public static ArrayList<Dish>  dishList; //�㵥����	
    public int state = -1; //״̬0δ�� 1�ѵ� 2������ 
	public static Dish[] dishes = new Dish[30];
	
	public static void initialize()
	{
		//��ʼ�����еĲˡ�����
		dishes[0] = new Dish("���ݿ�Ѽ" , 40);
		dishes[1] = new Dish("ʯ������" , 35);
		dishes[2] = new Dish("���鱬��" , 50);
		dishes[3] = new Dish("������" , 45);
		dishes[4] = new Dish("���ǵ���" , 55);
		dishes[5] = new Dish("�ع���" , 60);
		dishes[6] = new Dish("��̫�����ͺ����ڶ���" , 26);
		dishes[7] = new Dish("̨����ץ��", 8);
		dishes[8] = new Dish("ɽ�����", 8);
		dishes[9] = new Dish("��������", 9);
		dishes[10] = new Dish("�ϵ»�����", 10);
		dishes[11] = new Dish("��ʽ��̢", 14);
		dishes[12] = new Dish("������Բ���ɲ�", 15);
		dishes[13] = new Dish("������������", 20);
		dishes[14] = new Dish("����С����", 12);
		dishes[15] = new Dish("�����̲�", 10);
		dishes[16] = new Dish("�����̲�", 10);
		dishes[17] = new Dish("ͳһ���", 10);
		dishes[18] = new Dish("ȸ������", 10);
		dishes[19] = new Dish("��ɽ����", 10);
		dishes[20] = new Dish("������ŵ", 10);
		dishes[21] = new Dish("��Ũ����", 10);
		dishes[23] = new Dish("ɳ�����", 10);
		
	}
	
	
	public static String duizheng(String n1)//orz�ҷ��ֺ��ѱ�֤�ò����ͺ����---���������Ծ�д���������ר��Ϊ�˶�׼������
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
		this.l_state = new JLabel("��δ����");
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
			 Dish.dishes[n].state = 0;//�����ÿ��dish��״̬��ʼ��Ϊ0
			 }
		 }
	 }
	 
	 public static void order(Dish dish)
	 {
		 if(Dish.dishList.size() < 5){
			 Dish.dishList.add(dish);
			 dish.state=1;
			 
			 System.out.println(dish.name + "���");
			 dish.updatestate();
		 } 
	 }
	 
	 public static void finish()
	 {  
		 if(Dish.dishList.size()!=0)
		 {
			 Dish.dishList.get(0).state = 2;
			 System.out.println(Dish.dishList.get(0).name +"����");
			 Dish.dishList.get(0).fenshu = 0;//�������������ӷ���δ���ӵĲ˻��ظ����
			 Dish.dishList.get(0).updatestate();//������ǰ����Ȼ�����Ǹ���ȥ����һ�������¸�P
			 Dish.dishList.remove(0);
			 
		 }
	 }
	 
	 public void updatestate()
	 {
		 if(this.state == 0)
		 {
			 this.l_state.setText("��δ����Unproduce");
			 this.l_state.setForeground(Color.red);
		 }
		 else if (this.state == 1)
		 {
			 this.l_state.setText("������Producing");
			 this.l_state.setForeground(Color.yellow);
			 
		 }
		 else if (this.state == 2)
		 {
			 this.l_state.setText("�������Complete");
			 this.l_state.setForeground(Color.green);
		 }
		 this.l_state.validate();
		 this.l_state.updateUI();
	 }
	
	
	


			
}
