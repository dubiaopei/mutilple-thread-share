package cn.dubiaopei.share.synchronize2;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {

		List<Food> foods = new ArrayList<Food>();

		for (int i = 0; i < 3; i++) {
			new Thread(new Cook(foods)).start();
		}

		for (int i = 0; i < 3; i++) {
			new Thread(new SaleWindow(foods)).start();
		}

	}
}
