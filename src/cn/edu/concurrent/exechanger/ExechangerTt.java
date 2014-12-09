package cn.edu.concurrent.exechanger;

import java.util.concurrent.Exchanger;

public class ExechangerTt {
	public static void main(String[] args) {
		Exchanger<String> exchange = new Exchanger<String>();
		new Thread(new T1(exchange)).start();
		new Thread(new T2(exchange)).start();
	}
}

class T1 implements Runnable{
	private Exchanger<String> exchange;
	
	public T1(Exchanger<String> exchange) {
		super();
		this.exchange = exchange;
	}

	@Override
	public void run() {
		try {
			String s = exchange.exchange("T1");
			System.out.println("---t1\t"+s);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

class T2 implements Runnable{
	private Exchanger<String> exchange;
	
	public T2(Exchanger<String> exchange) {
		super();
		this.exchange = exchange;
	}

	@Override
	public void run() {
		try {
			String s = exchange.exchange("T2");
			System.out.println("---t2\t"+s);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}
	
}
