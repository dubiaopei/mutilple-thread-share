package cn.dubiaopei.share.synchronize2;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Cook implements Runnable{

	private List<Food> foods;
	private static int num = 1;
	public Cook(List<Food> foods) {
		this.foods = foods;
	}
	
	
	public void produce(){
		while(true){
			
			synchronized (foods) {
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
					
					foods.notify();//随机唤醒等待险种中的一条
//					foods.notifyAll();//唤醒等待中的所有线程。
					
				} else {
					System.out.println(Thread.currentThread().getName()
							+ ": 已装满，赶紧卖！");
					try {
						foods.wait();//厨师等待
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}


	@Override
	public void run() {
		produce();
		
	}
	
}
