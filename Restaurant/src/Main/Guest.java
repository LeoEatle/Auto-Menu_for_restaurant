package Main;

import java.util.ArrayList;

public class Guest { //顾客对象
   public ArrayList<Dish> menu;
   
   public Guest(){
   }
   
   public void order(Dish a){//点餐
	   menu.add(a);
   }
}