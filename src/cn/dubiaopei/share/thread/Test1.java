package cn.dubiaopei.share.thread;

public class Test1 {
	public static void main(String[] args) {
		System.out.println("Test1-" + Thread.currentThread().getId());

		for (int i = 0; i < 10; i++) {
			final MyThread1 myThread = new MyThread1(i);
			// 启动线程使用start()
			myThread.start();
		}
	}
}

class MyThread1 extends Thread {
	int i;

	public MyThread1(int i) {
		this.i = i;
		System.out.println("构造线程的编号是：" + i + ">>>>>>>线程ID：" + Thread.currentThread().getId());
	}

	// run()的调用不是程序员控制的，而是jdk控制的
	@Override
	public void run() {
		System.out.println("运行线程编号" + i + "=================================线程ID：" + Thread.currentThread().getId());
	}
}