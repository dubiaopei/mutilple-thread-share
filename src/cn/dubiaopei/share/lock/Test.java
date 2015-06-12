package cn.dubiaopei.share.lock;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		
		List<Food> foods = new ArrayList<Food>();
		
		for (int i = 0; i < 3; i++) {
			new Thread(new Cook(foods),"cook"+i).start();
		}
		
		for (int i = 0; i < 3; i++) {
			new Thread(new SaleWindow(foods),"window"+i).start();
		}
		
	}
}
