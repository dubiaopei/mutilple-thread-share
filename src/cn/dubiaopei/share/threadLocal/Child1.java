package cn.dubiaopei.share.threadLocal;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Child1 implements Runnable{

	private String name;
	private Transformer0 transformer;
	public Child1(String name, Transformer0 transformer) {
		this.name = name;
		this.transformer = transformer;
	}
	public Child1() {
	}
	
	public void play(){
		transformer = new Transformer0();//每一次玩都会新创建一个对象
		
		synchronized (transformer) {
			
			Random ran = new Random();
			int num = ran.nextInt(100);
			System.out.println(Thread.currentThread().getName() + ":设置为擎天柱" + num);
			transformer.setShape("擎天柱" + num);
			try {
				TimeUnit.SECONDS.sleep(ran.nextInt(5));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			String shape = transformer.getShape();
			System.out.println(Thread.currentThread().getName() +":获取为"+ shape);
		}
	}
	
	@Override
	public void run() {
		play();
	}
}
