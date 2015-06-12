package cn.dubiaopei.share.synchronize2;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SaleWindow implements Runnable {

	private List<Food> foods;

	public SaleWindow(List<Food> foods) {
		this.foods = foods;
	}

	public SaleWindow() {
	}

	public void sale() {

		while (true) {
			synchronized (foods) {
				if (foods.size() > 0) {
					Food food = foods.get(0);
					System.out.println(Thread.currentThread().getName() + ": "
							+ food.getId() + " 号饭已经卖出去了...");
					try {
						TimeUnit.MILLISECONDS.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					foods.remove(0);
					foods.notifyAll();//唤醒
					
				} else {
					System.out.println(Thread.currentThread().getName()
							+ ": 已售罄！赶紧做饭");
					try {
						foods.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	@Override
	public void run() {
		sale();
	}
}
