package cn.dubiaopei.share.synchronize;

public class Thread2 implements Runnable {

	@Override
	public void run() {
		TestThread2 test = new TestThread2();//保证每个线上都是不同实例对象
		test.execute();
	}
}
