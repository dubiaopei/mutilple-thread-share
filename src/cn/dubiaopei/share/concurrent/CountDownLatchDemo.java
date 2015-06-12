package cn.dubiaopei.share.concurrent;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/*
 * 一组线程，等待另一组线程。
 * 
 */
public class CountDownLatchDemo {

	public static void main(String[] args) throws InterruptedException {
		final CountDownLatch cdl = new CountDownLatch(1);
		final CountDownLatch cdl2 = new CountDownLatch(3);
		Thread t = new Thread(new Runnable() {// 裁判

					@Override
					public void run() {

						System.out.println("预备：");
						for (int i = 3; i >= 1; i--) {
							System.out.println(i + "...");
							try {
								TimeUnit.SECONDS.sleep(1);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						System.out.println("跑！");
						cdl.countDown(); // 计数器 减1
					}
				});
		t.start();
		// t.join();// 插入

		// System.out.println("main:aaaaa");
		for (int i = 0; i < 3; i++) {// 运动员
			new Thread(new Runnable() {

				@Override
				public void run() {
					try {
						cdl.await(); // 等待，知道计数器变为0 为止

						System.out.println(Thread.currentThread().getName() + ":启动了...");

						TimeUnit.SECONDS.sleep(new Random().nextInt(5) + 1);
						System.out.println("--》" + Thread.currentThread().getName() + ":到达终点了...");

						cdl2.countDown();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}

		new Thread(new Runnable() {

			@Override
			public void run() {

				try {
					cdl2.await();

					System.out.println("宣布成绩！");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}
