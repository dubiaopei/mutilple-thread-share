package cn.dubiaopei.share.synchronize;

public class Thread1 implements Runnable {
	TestThread1 test = null;


	public Thread1(TestThread1 pTest) { // 对象有外部引入，这样保证是同一个对象
		test = pTest;
	}

	@Override
	public void run() {
		test.execute();
	}
}
