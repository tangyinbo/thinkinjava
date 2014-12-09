package cn.edu.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Worker implements Runnable{
	private CountDownLatch latch;
	private String name;
	
	public Worker(CountDownLatch latch,String name) {
		this.latch = latch;
		this.name = name;
	}

	@Override
	public void run() {
			try {
				dowork();
				latch.countDown();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	
	private void dowork() throws InterruptedException{
		System.out.println(name+   "----isworking");
		TimeUnit.MICROSECONDS.sleep(1000);
		System.out.println(name+   "---- finish work");
	}
}
