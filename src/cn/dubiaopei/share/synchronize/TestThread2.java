package cn.dubiaopei.share.synchronize;

/**
 * 不同实例同步方法
 * 
 * @author dubiaopei
 * 
 */
public class TestThread2 {

	public synchronized void execute() { // synchronized
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + ": " + i);
		}
	}

	// private static Object lock = new Object(); // 必须是静态的。
	//
	// public void execute() {
	// synchronized (lock) {// 增加了个锁，锁定了对象lock，在同一个类实例中，是线程安全的，但不同的实例还是不安全的。
	// // 因为不同的实例有不同对象锁lock
	// for (int i = 0; i < 100; i++) {
	// System.out.println(Thread.currentThread().getName() + ": " + i);
	// }
	// }
	// }
}
