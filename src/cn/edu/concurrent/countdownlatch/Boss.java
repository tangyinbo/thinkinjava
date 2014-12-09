package cn.edu.concurrent.countdownlatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Boss implements Runnable{
	private CountDownLatch latch;
	
	public Boss(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
			try {
				System.out.println("boss is wait the work finish work....");
				latch.await();
				System.out.println("boss is eval the work....");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
	}
	
	private void dowork() throws InterruptedException{
		System.out.println("boss is eval the work....");
	}
}
