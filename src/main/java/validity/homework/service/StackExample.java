package validity.homework.service;

import java.util.ArrayList;
import java.util.List;

public class StackExample {
	
	
	public static  List getList(int index) {
		
		 List list = new ArrayList<Integer>();
		for (int i = 0; i< index; i++) {
			list.add(i);
	}
	return list;
	}
	
	public static List<Integer> push(int i, List list) {
		
	
		list.add(i);
		return list;
		
	}
	public static  int  pop(List<Integer> list) {
		return list.get(list.size()-1);
		
	}
}
