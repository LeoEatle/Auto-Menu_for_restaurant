package Main;

import java.util.ArrayList;

public class GusetList extends ArrayList<Guest>{  //�˿Ͷ���
	//add������һ�����󵽶�β
	public void dequeue(){//ȥ������Ԫ��
		this.remove(0);
	}
	
	public int previousNumber(Guest a){//����ǰ���м�����
		return this. indexOf(a);
	}
	
}