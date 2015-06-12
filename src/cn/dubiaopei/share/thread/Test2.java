package cn.dubiaopei.share.thread;


public class Test2 {
	public static void main(String[] args) {
		System.out.println("=================================主线程ID："+Thread.currentThread().getId());
		
		for(int i=0; i<10; i++) {
			final MyThread2 myThread = new MyThread2(i);
			//启动线程使用start()
			(new Thread(myThread)).start();
		}
		//myThread.run();    不要在代码中显示调用，该调用是错误的
	}
}


class MyThread2 implements Runnable{
	int i;
	public MyThread2(int i) {
		this.i = i;
		System.out.println("构造线程的编号是"+i+">>>>>>>>>>>>>>>线程ID:"+Thread.currentThread().getId());
	}
	
	//run()的调用不是程序员控制的，而是jdk控制的
	@Override
	public void run() {
		System.out.println("运行线程编号"+i+"=================================线程ID："+Thread.currentThread().getId());
	}
}