package cn.dubiaopei.share.thread;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class Test4 {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("Test1-"+Thread.currentThread().getId());
		
		final ArrayList<Future> result = new ArrayList<Future>();
		
		final ExecutorService pool = Executors.newCachedThreadPool();
		for (int j = 0; j < 5; j++) {
			final Future<String> f = pool.submit(new MyThread4(j));
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


class MyThread4 implements Callable<String>{
	int i;
	public MyThread4(int i) {
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