package cn.dubiaopei.share.threadLocal;

public class Test {

	public static void main(String[] args) {
		// Transformer0 transform = new Transformer0();
		// for (int i = 0; i < 3; i++) {
		// new Thread(new Child0("name" + i, transform)).start();
		// }

		// for (int i = 0; i < 3; i++) {
		// new Thread(new Child1()).start();
		// }

		for (int i = 0; i < 3; i++) {
			new Thread(new Child()).start();
		}

		// for (int i = 0; i < 3; i++) {
		// new Thread(new Child2()).start();
		// }
	}
}
