package cn.dubiaopei.share.thread;

import java.util.concurrent.ExecutionException;

public class Test7 {
	//线程安全的
	public ThreadLocal<String>  localMap = new ThreadLocal<String>();
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		final Test7 test7 = new Test7();
		test7.localMap.set("value");
		final String result = test7.localMap.get();
		
	}
	
}