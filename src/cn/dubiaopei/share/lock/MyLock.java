package cn.dubiaopei.share.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyLock {

	private static Lock lock;
	private static Condition cookCon;
	private static Condition windowCon;

	public synchronized static Lock getLock() {
		if (lock == null)
			lock = new ReentrantLock();// 可重入互斥锁
		// lock = new ReentrantLock(true);//公平策略 -->谁等待时间最长，先让谁获取到锁
		return lock;
	}

	public synchronized static Condition getCookCon() {
		if (cookCon == null)
			cookCon = lock.newCondition();
		return cookCon;
	}

	public synchronized static Condition getWindowCon() {// MyLock.class this
		if (windowCon == null)
			windowCon = lock.newCondition();

		return windowCon;
	}

}
