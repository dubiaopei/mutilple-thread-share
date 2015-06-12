package cn.dubiaopei.share.synchronize;

public class Test {

	public static void main(String[] args) {
		// TestThread1 test = new TestThread1();
		// Runnable runabble = new Thread1(test);// 同实例同步方法
		// Thread a = new Thread(runabble, "A");
		// a.start();
		// Thread b = new Thread(runabble, "B");
		// b.start();

		Runnable runabble = new Thread2();// 不同实例同步方法
		Thread a = new Thread(runabble, "A");
		a.start();
		Thread b = new Thread(runabble, "B");
		b.start();

		// TestThread3 test = new TestThread3();
		// Runnable runabble = new Thread3(test);// 静态同步与异步
		// Thread a = new Thread(runabble, "A");
		// a.start();
		// Thread b = new Thread(runabble, "B");
		// b.start();

		// TestThread4 test = TestThread4.getInstance();
		// Runnable runabble = new Thread4(test);
		// Thread a = new Thread(runabble, "A");
		// a.start();
		// Thread b = new Thread(runabble, "B");
		// b.start();
	}

}
