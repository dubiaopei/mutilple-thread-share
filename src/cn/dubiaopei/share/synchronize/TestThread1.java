package cn.dubiaopei.share.synchronize;

/**
 * 同实例同步方法
 * 
 * @author dubiaopei
 * 
 */
public class TestThread1 {

	public void execute() { // synchronized,未修饰
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + ": " + i);
		}
	}

	// public synchronized void execute() { // synchronized
	// for (int i = 0; i < 100; i++) {
	// System.out.println(Thread.currentThread().getName() + ": " + i);
	// }
	// }
}
