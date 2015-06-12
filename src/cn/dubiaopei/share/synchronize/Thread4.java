package cn.dubiaopei.share.synchronize;

public class Thread4 implements Runnable {
	TestThread4 test = null;


	public Thread4(TestThread4 pTest) { // 对象有外部引入，这样保证是同一个对象
		test = pTest;
	}

	@Override
	public void run() {
		test.reload();
	}
}
