package cn.dubiaopei.share.thread;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class Test6 {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("Test1-"+Thread.currentThread().getId());
		
		final ArrayList<Future> result = new ArrayList<Future>();
		//无界的线程池
		final ExecutorService pool = Executors.newCachedThreadPool();
		//创建线程数量固定的线程池
		//final ExecutorService pool = Executors.newFixedThreadPool(2);
		for (int j = 0; j < 50; j++) {
			final Future<String> f = pool.submit(new MyThread6(j));
			result.add(f);
		}
		pool.shutdown();
		for (Future f : result) {
			//get是阻塞操作，不能立即调用
			final Object x = f.get();
			System.out.println(x);
		}
	}
}


class MyThread6 implements Callable<String>{
	static final AtomicInteger counter = new AtomicInteger(0);
	int i;
	public MyThread6(int i) {
		if(counter.addAndGet(1)>1) {
			throw new RuntimeException("只能单例运行");
		}
		this.i = i;
		System.out.println("构造线程的编号是"+counter.get());
	}
	@Override
	public String call() throws Exception {
			final long id = Thread.currentThread().getId();
			System.out.println("运行线程编号"+i+"\t"+id);
			Thread.sleep(1000);
			return "线程"+id+"的返回值"+i;
	}
}