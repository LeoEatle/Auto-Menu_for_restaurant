package Main;

import java.util.ArrayList;


public class Task implements Runnable{
	public void run()
	{
		try{
			Thread.sleep(5000);//��sleep��������ʳ����̲�����
			while(true){
				
				for(int n = 0; n < 21 ; n ++)
				{
					if(Dish.dishes[n].state == 0)
					{
						Dish.order(Dish.dishes[n]);
						
					}
				}
				Thread.sleep(5000);//����ʱ��ķ�5��
				
				Dish.finish();
				
				
			}
		}
		catch(InterruptedException ex){
			
		}
	}
	public static void test(){
		Task task=new Task();
		Thread thread=new Thread(task);
		Dish.dishList = new ArrayList<Dish>();
		thread.start();
	}

}