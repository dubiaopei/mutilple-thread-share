package cn.dubiaopei.share.thread;


import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test5 {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("Test1-"+Thread.currentThread().getId());
		
		final ArrayList<Future> result = new ArrayList<Future>();
		//无界的线程池
		final ExecutorService pool = Executors.newCachedThreadPool();
		//创建线程数量固定的线程池
		//final ExecutorService pool = Executors.newFixedThreadPool(2);
		for (int j = 0; j < 50; j++) {
			final Future<String> f = pool.submit(new MyThread5(j));
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


class MyThread5 implements Callable<String>{
	int i;
	public MyThread5(int i) {
		this.i = i;
		//System.out.println("构造线程的编号是"+i);
	}
	@Override
	public String call() throws Exception {
			final long id = Thread.currentThread().getId();
			System.out.println("运行线程编号"+i+"\t"+id);
			Thread.sleep(1000);
			return "线程"+id+"的返回值"+i;
	}
}