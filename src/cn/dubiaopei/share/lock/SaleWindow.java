package cn.dubiaopei.share.lock;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class SaleWindow implements Runnable {

	private List<Food> foods;

	public SaleWindow(List<Food> foods) {
		this.foods = foods;
	}

	public SaleWindow() {
	}

	public void sale() {

		while (true) {
			Lock lock = MyLock.getLock();
			lock.lock();
			Condition cookCon = MyLock.getCookCon();
			Condition windowCon = MyLock.getWindowCon();
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
					cookCon.signal();//唤醒
					
				} else {
					System.out.println(Thread.currentThread().getName()
							+ ": 已售罄！赶紧做饭");
					try {
						windowCon.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			lock.unlock();
		}
	}

	@Override
	public void run() {
		sale();
	}
}
