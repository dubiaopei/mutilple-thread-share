package cn.dubiaopei.share.concurrent;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/*
 * 一组线程相互等待，直到最后一个线程执行完某一阶段任务后，他们才会一起向下执行。
 * 
 */
public class CyclicBarrierDemo {

	public static void main(String[] args) {
		final CyclicBarrier cb = new CyclicBarrier(3);
		System.out.println("出发...");
		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						TimeUnit.SECONDS.sleep(new Random().nextInt(5)+1);
						System.out.println(Thread.currentThread().getName()+":到达山顶了。。。");
						cb.await();
						System.out.println();
						TimeUnit.SECONDS.sleep(new Random().nextInt(5)+1);
						System.out.println(Thread.currentThread().getName()+":吃完饭了。。。");
						cb.await();
						System.out.println();
						TimeUnit.SECONDS.sleep(new Random().nextInt(5)+1);
						System.out.println(Thread.currentThread().getName()+":唱完歌了。。。");
						cb.await();
						System.out.println("回家");
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (BrokenBarrierException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
	}
}
