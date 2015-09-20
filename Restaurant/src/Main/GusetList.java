package Main;

import java.util.ArrayList;

public class GusetList extends ArrayList<Guest>{  //顾客队列
	//add（）加一个对象到队尾
	public void dequeue(){//去除队首元素
		this.remove(0);
	}
	
	public int previousNumber(Guest a){//队列前面有几个人
		return this. indexOf(a);
	}
	
}