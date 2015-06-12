package cn.dubiaopei.share.lock;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Cook implements Runnable{

	private List<Food> foods;
	private static int num = 1;
	public Cook(List<Food> foods) {
		this.foods = foods;
	}
	
	
	public void produce(){
		while(true){
			
			Lock lock = MyLock.getLock();
			lock.lock();
			Condition cookCon = MyLock.getCookCon();
			Condition windowCon = MyLock.getWindowCon();
				if (foods.size() < 10) {
					Food food = new Food(num++);
					foods.add(food);
					System.out.println(Thread.currentThread().getName() + ": "
							+ food.getId() + " 号饭已经做好了...");
					try {
						TimeUnit.MILLISECONDS.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					//foods.notify();//随机唤醒等待险种中的一条
					//foods.notifyAll();//唤醒等待中的所有线程。
					
					windowCon.signal();//唤醒此监视器上绑定的任意一条线程
					
				} else {
					System.out.println(Thread.currentThread().getName()
							+ ": 已装满，赶紧卖！");
					try {
						cookCon.await();//厨师等待
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			lock.unlock();
		}
	}


	@Override
	public void run() {
		produce();
		
	}
	
}
