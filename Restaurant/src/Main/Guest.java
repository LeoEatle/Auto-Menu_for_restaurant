package Main;

import java.util.ArrayList;

public class Guest { //�˿Ͷ���
   public ArrayList<Dish> menu;
   
   public Guest(){
   }
   
   public void order(Dish a){//���
	   menu.add(a);
   }
}