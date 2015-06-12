package cn.dubiaopei.share.synchronize;

public class TestThread3 {

	private static Object lock = new Object();

	public synchronized static void execute() { // 同步静态方法
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + ": " + i);
		}
	}

	public static void execute1() {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + ": " + i);
		}
	}

	public void test() {
		execute(); // 输出是有序的，说明是同步的
		// execute1(); // 输出是无须的，说明是异步的
	}

}
