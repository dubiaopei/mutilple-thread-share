package cn.dubiaopei.share.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Cache {

	private static Map<String, Object> cache = new HashMap<String, Object>();
	private static ReadWriteLock rwl = new ReentrantReadWriteLock();

	// 允许多个读线程并发，但是不允许写线程并发
	public static Object get(String key) {
		Lock readLock = rwl.readLock();
		Object value;
		try {
			readLock.lock();
			value = cache.get(key);
			if (value == null) {
				Lock writeLock = rwl.writeLock();
				readLock.unlock();
				try {
					writeLock.lock();
					if (value == null) {
						value = "xxx"; // 查询数据库
						cache.put(key, value);
					}
				} finally {
					writeLock.unlock();
				}
				readLock.lock();
			}
		} finally {
			readLock.unlock();
		}

		return value;
	}
}
