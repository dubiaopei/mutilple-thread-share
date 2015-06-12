package cn.dubiaopei.share.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {

	public static void main(String[] args) {

		// ExecutorService pool3 = Executors.newSingleThreadExecutor();// 单一线程池
		// for (int i = 0; i < 10; i++) {
		// final int j = i;
		// pool3.execute(new Runnable() {
		//
		// @Override
		// public void run() {
		// int c;
		// if (j == 3)
		// c = 3 / 0;
		// System.out.println(Thread.currentThread().getName() + ":" + j);
		// }
		// });
		// }

		int num = Runtime.getRuntime().availableProcessors();// 获得当前计算机有几个CPU

		System.out.println(num);

		ExecutorService pool2 = Executors.newFixedThreadPool(4 * 2);// 固定大小的线程池
		for (int i = 0; i < 50; i++) {
			pool2.execute(new Runnable() {

				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName());
				}
			});
		}

		// ExecutorService pool1 = Executors.newCachedThreadPool();// 缓存线程池。无上限
		// for (int i = 0; i < 100; i++) {
		// pool1.execute(new Runnable() {
		//
		// @Override
		// public void run() {
		// System.out.println(Thread.currentThread().getName());
		// }
		// });
		// }

	}
}
