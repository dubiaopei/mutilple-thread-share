package cn.dubiaopei.share.synchronize;

import java.util.Vector;

public class TestThread4 {
	private static final class TestThreadHolder {
		private static TestThread4 theSingleton = new TestThread4();

		public static TestThread4 getSingleton() {
			return theSingleton;
		}

		private TestThreadHolder() {
		}
	}

	private Vector<String> ve = null;
	private Object lock = new Object();

	private TestThread4() {
		ve = new Vector<String>();
		initialize();
	}

	public static TestThread4 getInstance() {
		return TestThreadHolder.getSingleton();
	}

	private void initialize() {
		for (int i = 0; i < 100; i++) {
			ve.add(String.valueOf(i));
		}
	}

	public void reload() {
		synchronized (lock) {
			ve = null;
			ve = new Vector<String>();
			// lock = "abc";
			for (int i = 0; i < 100; i++) {
				ve.add(String.valueOf(i));
				System.out.println(Thread.currentThread().getName() + ": " + ve.get(i));
			}
		}
		System.out.println(Thread.currentThread().getName() + ": " + "reload end");

	}

}
