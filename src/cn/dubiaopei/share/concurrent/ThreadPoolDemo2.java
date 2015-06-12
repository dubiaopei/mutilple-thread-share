package cn.dubiaopei.share.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo2 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(3);

		threadPool.scheduleAtFixedRate(new Runnable() {

			@Override
			public void run() {
				System.out.println("bobm!");
			}
		}, 5, 1, TimeUnit.SECONDS);

		// ScheduledExecutorService threadPool2 = Executors.newScheduledThreadPool(3);
		//
		// Future<String> submit = null;
		// for (int i = 0; i < 10; i++) {
		// submit = threadPool2.submit(new Callable<String>() {
		// @Override
		// public String call() throws Exception {
		// System.out.println(Thread.currentThread().getName());
		// return "aaaa";
		// }
		// });
		// }
		//
		// for (int i = 0; i < 10; i++) {
		// String str = submit.get();
		// System.out.println(str);
		// }
		//
		// threadPool2.shutdown();
	}
}
