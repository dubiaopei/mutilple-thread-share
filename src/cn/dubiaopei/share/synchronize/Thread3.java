package cn.dubiaopei.share.synchronize;

public class Thread3 implements Runnable {
	TestThread3 test = null;


	public Thread3(TestThread3 pTest) { // 对象有外部引入，这样保证是同一个对象
		test = pTest;
	}

	@Override
	public void run() {
		test.test();
	}
}
