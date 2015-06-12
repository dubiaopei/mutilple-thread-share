package cn.dubiaopei.share.concurrent;

import java.sql.Time;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {

	public static void main(String[] args) {
		final Semaphore semaphore = new Semaphore(3);//信号量，解决了 允许固定个数的线程 同时访问共享资源
		for (int i = 0; i < 10; i++) {

			new Thread(new Runnable() {

				@Override
				public void run() {
					try {
						semaphore.acquire();// 获得许可

						System.out.println(Thread.currentThread().getName()
								+ ": 来了...现在有"+(3-semaphore.availablePermits())+"位顾客");

						TimeUnit.SECONDS.sleep(new Random().nextInt(5));
						System.out.println("-->"+Thread.currentThread().getName()
								+ ": 走了...");

						semaphore.release();// 释放许可
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			}).start();
		}
	}
}
